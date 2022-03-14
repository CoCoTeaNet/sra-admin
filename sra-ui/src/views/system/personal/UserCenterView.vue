<template>
  <el-space style="width: 100%" direction="vertical" alignment="stretch">
    <el-card class="box-card">
      <el-descriptions title="个人信息" :column="3" border>
        <el-descriptions-item>
          <template #label>
            <div>
              <el-icon>
                <user/>
              </el-icon>
              账号名
            </div>
          </template>
          {{ detailUser.username }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div>
              <el-icon>
                <user/>
              </el-icon>
              账号角色
            </div>
          </template>
          {{ detailUser.roleName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon>
                <tickets/>
              </el-icon>
              用户昵称
            </div>
          </template>
          {{ detailUser.nickname }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon>
                <tickets/>
              </el-icon>
              性别
            </div>
          </template>
          {{ getSexText(detailUser.sex) }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div>
              <el-icon>
                <iphone/>
              </el-icon>
              手机号
            </div>
          </template>
          {{ detailUser.mobilePhone ? detailUser.mobilePhone : '...' }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div>
              <el-icon>
                <location/>
              </el-icon>
              邮箱
            </div>
          </template>
          {{ detailUser.email ? detailUser.email : '...' }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon>
                <office-building/>
              </el-icon>
              最后登录IP
            </div>
          </template>
          {{ detailUser.lastLoginIp }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div class="cell-item">
              <el-icon>
                <office-building/>
              </el-icon>
              最后登录时间
            </div>
          </template>
          {{ detailUser.lastLoginTime }}
        </el-descriptions-item>
      </el-descriptions>
    </el-card>

    <el-card>
      <template #header>
        <div class="card-header">
          <span>更新资料</span>
        </div>
      </template>
      <el-form ref="ucvFormRef" label-width="120px" label-position="right" :rules="rules" :model="editForm">
        <el-form-item prop="nickname" label="用户昵称">
          <el-input v-model="editForm.nickname"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="用户密码">
          <el-input :prefix-icon="Lock" v-model="editForm.password" type="password"
                    autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="email" label="电子邮箱">
          <el-input v-model="editForm.email"></el-input>
        </el-form-item>
        <el-form-item prop="mobilePhone" label="手机号">
          <el-input v-model="editForm.mobilePhone"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="editForm.sex">
            <el-radio label="0">不公开</el-radio>
            <el-radio label="1">男</el-radio>
            <el-radio label="2">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(ucvFormRef)">提交保存</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </el-space>
</template>

<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import type {FormInstance} from 'element-plus';
import {Lock} from "@element-plus/icons-vue";
import {getDetail, update} from "@/api/system/user-api";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import {getSexText} from "@/utils/format-util";
import {RULE_MOBILE, RULE_EMAIL} from "@/utils/rules-util";

const validatePhone = (rule: any, value: any, callback: any) => {
  if (!RULE_MOBILE.test(value)) {
    callback(new Error('非法手机号'));
  } else {
    callback();
  }
}

const validateEmail = (rule: any, value: any, callback: any) => {
  if (!RULE_EMAIL.test(value)) {
    callback(new Error('邮箱格式错误'));
  } else {
    callback();
  }
}

const ucvFormRef = ref<FormInstance>();
const editForm = ref<any>({});
const detailUser = ref<any>({});
// 表单校验规则
const rules = reactive({
  username: [{min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  mobilePhone: [{validator: validatePhone, trigger: 'blur'}],
  email: [{validator: validateEmail, trigger: 'blur'}],
  nickname: [{min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  password: [{min: 6, max: 32, message: '长度限制6~32', trigger: 'blur'}]
});

onMounted(() => {
  initUserDetail();
});

/**
 * 获取用户详细
 */
const initUserDetail = () => {
  reqCommonFeedback(getDetail(), (data: any) => {
    editForm.value = data;
    detailUser.value = Object.assign(detailUser.value ,data);
  });
}

/**
 * 表单提交
 * @param ucvFormRef
 */
const submitForm = (ucvFormRef: any) => {
  ucvFormRef.validate((valid: any) => {
    if (valid) {
      reqSuccessFeedback(update(editForm.value), '修改成功', () => {
        initUserDetail();
      });
    }
  });
}
</script>

<style scoped>

</style>