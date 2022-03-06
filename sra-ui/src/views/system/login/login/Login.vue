<template>
  <div class="login">
    <el-card shadow="always" style="width: 306px">
      <h2 style="text-align: center">登录后台管理系统</h2>
      <el-form ref="loginFormRef" :model="loginForm" status-icon :rules="rules">
        <el-form-item prop="username">
          <el-input placeholder="账号" :prefix-icon="UserFilled" v-model="loginForm.username"
                    autocomplete="off">
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input placeholder="密码" :prefix-icon="Lock" v-model="loginForm.password"
                    @keypress.enter="submitForm(loginFormRef)"
                    type="password"
                    autocomplete="off">
          </el-input>
        </el-form-item>

        <el-form-item prop="verifyCode">
          <el-input style="width: 75%;" placeholder="验证码" :prefix-icon="Connection"
                    @keypress.enter="submitForm(loginFormRef)"
                    v-model="loginForm.verifyCode">
          </el-input>
          <el-image @click="getVerifyCodeImage" style="width: 25%;cursor: pointer" :src="verifyCode"/>
        </el-form-item>

        <el-form-item>
          <el-checkbox v-model="loginForm.rememberMe">记住我</el-checkbox>
        </el-form-item>

        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="submitForm(loginFormRef)" :loading="loading">
            登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, onMounted} from "vue";
import type {ElForm} from 'element-plus';
import {UserFilled, Lock, Connection} from "@element-plus/icons-vue";
import {verificationCode} from "@/api/system/file-api";
import {login} from "@/api/system/user-api";
import {ElMessage} from "element-plus";
import {setUserInfo} from "@/store";
import {useRouter, useRoute} from "vue-router";

const router = useRouter();
const route = useRoute();

type FormInstance = InstanceType<typeof ElForm>
const loginFormRef = ref<FormInstance>();

// 登录加载中
const loading = ref<boolean>(false);

// 验证码
const verifyCode = ref<string>('');

// 表单对象
const loginForm = reactive({
  username: '',
  password: '',
  verifyCode: '',
  rememberMe: false
});

// 表单校验规则
const rules = reactive({
  username: [{required: true, min: 2, max: 16, message: '长度限制2~16', trigger: 'blur'}],
  password: [{required: true, min: 6, max: 30, message: '长度限制6~30', trigger: 'blur'}],
  verifyCode: [{required: true, message: '请输入验证码', trigger: 'blur'}],
});

onMounted(() => {
  getVerifyCodeImage();
});

/**
 * 获取验证码
 */
const getVerifyCodeImage = () => {
  verificationCode({codeType: "LOGIN"}).then((res: any) => {
    if (res.code === 200) {
      verifyCode.value = `data:image/jpeg;base64,${res.data}`;
    }
  });
}

/**
 * 提交登录信息
 * @param formEl FormInstance
 */
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.validate((valid: any) => {
    if (valid) {
      loading.value = true;
      login(loginForm).then((res: any) => {
        if (res.code === 200) {
          setUserInfo(res.data);
          let toPath: string = `${route.query.redirect}`;
          router.push({
            path: toPath ? toPath : '/',
          });
        } else {
          ElMessage.error(res.data);
        }
        loading.value = false;
      });
    } else {
      console.log('error submit!');
      return false;
    }
  });
}
</script>

<style scoped src="./css/Login.css"></style>
