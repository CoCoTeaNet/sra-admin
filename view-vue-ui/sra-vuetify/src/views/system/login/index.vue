<template>
  <v-card width="343" class="pa-4" elevation="5">
    <!-- 登录结果提示 -->
    <v-alert v-if="loginResult.tipShow" dense :type="loginResult.flag === 1 ? 'success' : 'error'">
      {{ loginResult.message }}
    </v-alert>
    <!-- 登录表单 -->
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field
        v-model="username"
        :counter="16"
        :rules="usernameRules"
        label="账号名称"
        required
        @keyup.enter="validate"
      ></v-text-field>

      <v-text-field
        v-model="password"
        :counter="30"
        :rules="passwordRules"
        label="账号密码"
        required
        type="password"
        @keyup.enter="validate"
      ></v-text-field>

      <div style="display: flex;align-items: center">
        <v-text-field @keyup.enter="validate" v-model="verifyCode" :counter="4" :rules="verifyCodeRules" label="验证码" required>
        </v-text-field>
        <img style="width: 100px;height: 50px" :src="`data:image/jpeg;base64,${codeImageBase64}`" alt="codeImage">
      </div>

      <v-checkbox v-model="rememberMe" label="记住我"></v-checkbox>

      <v-btn
          :disabled="!valid"
          :loading="loginResult.loading"
          color="primary"
          class="mr-4"
          @click="validate"
          rounded :min-width="'100%'"
      >
        登录
      </v-btn>
    </v-form>
  </v-card>
</template>

<script>
import { verificationCode } from "@/api/system/file-api";
import { login } from "@/api/system/user-api";
import { passwordRule } from "@/utils/rules-util";

export default {
  // 登录页面
  name: "LoginView",
  data: () => ({
    valid: true,
    // 账号名称
    username: "",
    usernameRules: [
      (v) => !!v || "账号名称为空",
      (v) => (v && v.length <= 16) || "账号长度不能超过16个字符",
    ],
    // 账号密码
    password: "",
    passwordRules: [
      (v) => !!v || "密码为空",
      (v) => passwordRule().rule.test(v) || passwordRule().message,
    ],
    // 验证码
    verifyCode: "",
    verifyCodeRules: [
      (v) => !!v || "验证码为空",
      (v) => (v && v.length <= 4) || "验证码长度不能超过4个字符",
    ],
    // 验证码图片
    codeImageBase64: '',
    // 记住我
    rememberMe: true,
    // 登录结果, 0失败 1登录成功
    loginResult: { flag: 1, message: '', loading: false, tipShow: false }
  }),
  mounted() {
    this.verificationCode();
  },
  methods: {
    /**
     * 登录
     */
    validate() {
      // 表单校验
      if (this.$refs.form.validate()) {
        let self = this;
        self.loginResult.loading = true;
        setTimeout(async ()=>{
          let res = await login({ username: this.username, password: this.password });
          if (res.code === 200) {
            self.$store.commit('user/setUserInfo', res.data);
            self.loginResult = { flag: 1, message: '登录成功！', loading: false, tipShow: true };
            let fromPath = self.$route.query.fromPath;
            await self.$router.push({ path: fromPath ? fromPath : '/admin' });
          } else {
            self.loginResult = { flag: 0, message: res.data, loading: false, tipShow: true };
          }
        }, 800);
      }
    },
    /**
     * 获取登录验证码
     */
    async verificationCode() {
      let param = { codeType: "LOGIN", otherParam: "1111111" };
      let res = await verificationCode(param);
      if (res.code === 200) {
        this.codeImageBase64 = res.data;
      }
    }
  },
};
</script>

<style>
</style>