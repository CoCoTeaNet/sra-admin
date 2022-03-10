<template>
  <el-row align="middle" style="height: 100%;">
    <el-col :span="4">LOGO</el-col>
    <!-- 用户信息 -->
    <el-col :span="20" style="text-align: right">
      <el-dropdown>
        <span style="cursor: pointer"><el-avatar :src="url"></el-avatar></span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item divided @click="doLogout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {logout} from "@/api/system/user-api";
import {setUserInfo} from "@/store";
import {router} from "@/router";

const url = ref('https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg');

/**
 * 退出登录
 */
const doLogout = () => {
  reqCommonFeedback(logout(), () => {
    setUserInfo(null);
    router.push({path: '/login', query: {redirect: encodeURI(window.location.pathname)}});
  });
}
</script>

<style scoped>

</style>