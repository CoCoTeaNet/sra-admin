<template>
  <el-row align="middle" style="height: 100%;">
    <el-col :span="8">
      <admin-breadcrumb/>
    </el-col>
    <!-- 用户信息 -->
    <el-col :span="16">
      <el-row :gutter="10" justify="end" align="bottom">
        <div class="mouse-over right-item">
          <el-icon :size="24">
            <question-filled/>
          </el-icon>
        </div>
        <div class="mouse-over right-item" @click="doFullScreen">
          <el-icon :size="24">
            <full-screen/>
          </el-icon>
        </div>
        <el-dropdown>
          <span class="mouse-over"><el-avatar shape="square" :src="url"></el-avatar></span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item @click="clickToGo('/admin/user-center')">个人中心</el-dropdown-item>
              <el-dropdown-item divided @click="doLogout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-row>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import {router} from "@/router";
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {logout} from "@/api/system/user-api";
import {setUserInfo, useStore} from "@/store";
import AdminBreadcrumb from "@/layout/modules/AdminBreadcrumb.vue";

const store = useStore();

const url = store.state.userInfo.avatar ? store.state.userInfo.avatar : require('@/assets/svg-source/default-avatar.svg');

/**
 * 点击跳转
 */
const clickToGo = (url: string) => {
  router.push({path: url});
}

/**
 * 退出登录
 */
const doLogout = () => {
  reqCommonFeedback(logout(), () => {
    setUserInfo({id: '', username: '', nickname: ''});
    router.push({path: '/login', query: {redirect: encodeURIComponent(window.location.pathname)}});
  });
}

/**
 * 浏览器全屏
 */
const doFullScreen = (event: { exitFullscreen: () => void; }) => {
  // 点击切换全屏模式
  if (document.fullscreenElement) {
    document.exitFullscreen()
  } else {
    document.documentElement.requestFullscreen()
  }
}
</script>

<style>
.mouse-over {
  cursor: pointer;
  padding: 0 3px;
}

.right-item {
  padding: 6px;
}

.right-item:hover {
  background-color: rgba(51, 51, 51, 0.1);
  border-radius: 3px;
}
</style>