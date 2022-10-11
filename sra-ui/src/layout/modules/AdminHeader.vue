<template>
  <el-row align="middle" class="header-row">
    <el-col :span="1">
      <el-button link @click="setCollapseMenu">
        <template #icon>
          <el-icon class="mouse-over right-item" :size="24">
            <expand v-if="store.state.isCollapseMenu"/>
            <fold v-else/>
          </el-icon>
        </template>
      </el-button>
    </el-col>
    <el-col :span="19"> <admin-tab/> </el-col>
    <!-- 用户信息 -->
    <el-col :span="4">
      <el-row :gutter="10" justify="end" align="bottom">
        <el-icon class="mouse-over" :size="24">
          <question-filled/>
        </el-icon>
        <el-icon class="mouse-over" :size="24" @click="doFullScreen">
          <full-screen/>
        </el-icon>
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
import {setUserInfo, useStore, setCollapseMenu} from "@/store";
import AdminTab from "@/layout/modules/AdminTab.vue";

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
.header-row {
  height: 100%;
  box-shadow: var(--el-box-shadow);
  border-radius: 4px;
  padding: 3px 1em;
}

.mouse-over {
  cursor: pointer;
  padding: 0 3px;
}
</style>