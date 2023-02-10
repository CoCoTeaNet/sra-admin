<template>
  <el-row align="middle" class="header-row">
    <el-col :span="20" style="display: flex">
      <el-button link @click="setCollapseMenu">
        <template #icon>
          <el-icon class="mouse-over right-item" :size="iconSize">
            <expand v-if="store.state.isCollapseMenu"/>
            <fold v-else/>
          </el-icon>
        </template>
      </el-button>
      <admin-tab/>
    </el-col>
    <!-- 用户信息 -->
    <el-col :span="4">
      <el-row :gutter="10" justify="end" align="middle">
        <el-icon class="mouse-over" :size="iconSize-2" @click="themeDrawer = !themeDrawer">
          <el-icon><Brush /></el-icon>
        </el-icon>
        <el-icon class="mouse-over" :size="iconSize-2" @click="doFullScreen">
          <full-screen/>
        </el-icon>
        <el-icon class="mouse-over" :size="iconSize-2" @click="router.push('/admin/home/')">
          <house/>
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

    <!-- 主题抽屉 -->
    <el-drawer v-model="themeDrawer" :with-header="false">
      <el-divider content-position="left">更改主题颜色</el-divider>
      <div class="demo-color-block">
        <span class="demonstration">选择颜色</span>
        <el-color-picker v-model="colorTheme" />
      </div>
      <el-divider content-position="left">操作</el-divider>
      <div>
        <el-button>保存配置</el-button>
        <el-button type="primary" @click="switchTheme">保存生效</el-button>
      </div>
    </el-drawer>
  </el-row>
</template>

<script setup lang="ts">
import {router} from "@/router";
import {useRoute} from "vue-router";
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {logout} from "@/api/system/login-api";
import {setUserInfo, useStore, setCollapseMenu} from "@/store";
import AdminTab from "@/layout/modules/AdminTab.vue";
import {Brush, Expand, Fold, FullScreen, House} from "@element-plus/icons-vue";
import {ref} from 'vue';
import {ElMessage} from 'element-plus';

const themeDrawer = ref(false);
const store = useStore();
const route = useRoute();

const url = store.state.userInfo.avatar ? store.state.userInfo.avatar : require('@/assets/svg-source/default-avatar.svg');

const iconSize = ref<number>(24);
const colorTheme = ref<string>('#409EFF');

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
    router.push({path: '/login', query: {redirect: encodeURIComponent(route.path)}});
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


const switchTheme = () => {
  // document.documentElement 是全局变量时
  const el = document.documentElement;
  // 获取 css 变量
  getComputedStyle(el).getPropertyValue(`--el-color-primary`);
  // 设置 css 变量
  el.style.setProperty('--el-color-primary', colorTheme.value);
  ElMessage({
    message: '主题设置成功!',
    type: 'success',
  });
}

</script>

<style>
.header-row {
  height: 63px;
  border-radius: 4px;
  padding: 3px 0;
}

.mouse-over {
  cursor: pointer;
  padding: 0 3px;
}
</style>