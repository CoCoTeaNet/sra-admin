<template>
  <div class="login">
    <el-card shadow="always" style="width: 306px">
      <h2 style="text-align: center">登录后台管理系统</h2>
      <el-form ref="loginFormRef" :model="loginForm" status-icon :rules="rules">
        <el-form-item prop="username">
          <el-input placeholder="账号" :prefix-icon="UserFilled" v-model="loginForm.username" autocomplete="off">
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input placeholder="密码" :prefix-icon="Lock" v-model="loginForm.password" type="password"
                    autocomplete="off">
          </el-input>
        </el-form-item>

        <el-form-item prop="verifyCode">
          <el-input placeholder="验证码" v-model.number="loginForm.verifyCode"></el-input>
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
import {ref, reactive} from 'vue';
import type {ElForm} from 'element-plus';
import {UserFilled, Lock} from "@element-plus/icons-vue";

type FormInstance = InstanceType<typeof ElForm>
const loginFormRef = ref<FormInstance>();

// 登录加载中
const loading = ref(false);

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

/**
 * 登录信息提交
 *
 * @param formEl
 */
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.validate((valid) => {
    if (valid) {
      loading.value = true;
      console.log('submit!');
    } else {
      console.log('error submit!');
      return false;
    }
  });
}
</script>

<style scoped>
.login {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
