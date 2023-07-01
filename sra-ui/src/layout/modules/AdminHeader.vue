<template>
  <el-row align="middle" class="header-row">
    <!-- 菜单标签 -->
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
          <el-icon>
            <Brush/>
          </el-icon>
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
              <el-dropdown-item @click="clickToGo('/admin/user-center', '个人中心')">个人中心</el-dropdown-item>
              <el-dropdown-item divided @click="doLogout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-row>
    </el-col>

    <!-- 主题抽屉 -->
    <el-drawer v-model="themeDrawer" :with-header="false" :size="300">
      <el-divider content-position="left">开启暗黑模式</el-divider>
      <div>
        <span class="demonstration">启用开关：</span>
        <el-switch v-model="isDark"/>
      </div>
      <el-divider content-position="left">更改主题颜色</el-divider>
      <form>
        <el-form-item label="主要颜色：">
          <el-color-picker v-model="colorTheme"/>
        </el-form-item>
        <el-form-item label="第二颜色：">
          <el-color-picker v-model="colorTheme2"/>
        </el-form-item>
        <el-form-item label="第三颜色：">
          <el-color-picker v-model="colorTheme3"/>
        </el-form-item>
        <el-form-item label="第四颜色：">
          <el-color-picker v-model="colorTheme4"/>
        </el-form-item>
      </form>
      <el-divider content-position="left">操作</el-divider>
      <div>
        <el-button @click="switchTheme">保存配置</el-button>
        <el-button type="primary" @click="saveTheme">保存生效</el-button>
        <el-divider content-position="left"></el-divider>
        <el-button @click="resetTheme">恢复原色</el-button>
      </div>
    </el-drawer>
  </el-row>
</template>

<script setup lang="ts">
import {router} from "@/router";
import {useRoute} from "vue-router";
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {logout} from "@/api/system/login-api";
import {setUserInfo, useStore, setCollapseMenu, addTabItem} from "@/store";
import AdminTab from "@/layout/modules/AdminTab.vue";
import {Brush, Expand, Fold, FullScreen, House} from "@element-plus/icons-vue";
import {onMounted, ref} from 'vue';
import {ElMessage} from 'element-plus';
import {useDark, useToggle} from '@vueuse/core'
import sysThemeApi from "@/api/system/sysTheme-api";

const themeDrawer = ref(false);
const store = useStore();
const route = useRoute();

const url = store.state.userInfo.avatar ? store.state.userInfo.avatar : require('@/assets/svg-source/default-avatar.svg');

const defaultColor = "#409EFF";
const defaultColor2 = "#a0cfff";
const defaultColor3 = "#337ecc";
const defaultColor4 = "#ecf5ff";

const iconSize = ref<number>(24);
const colorTheme = ref<string>(defaultColor);
const colorTheme2 = ref<string>(defaultColor2);
const colorTheme3 = ref<string>(defaultColor3);
const colorTheme4 = ref<string>(defaultColor4);
const isDark = ref<boolean>(false);

onMounted(() => {
  reqCommonFeedback(sysThemeApi.loadByUser(), (data: any) => {
    colorTheme.value = data.primaryColor;
    colorTheme2.value = data.color2;
    colorTheme3.value = data.color3;
    colorTheme4.value = data.color4;
    isDark.value = data.isDark === 1;
    switchTheme();
  });
});

/**
 * 点击跳转
 */
const clickToGo = (url: string, name: string) => {
  addTabItem({name: name, url: url, isActive: true});
  router.push({path: url});
}

/**
 * 退出登录
 */
const doLogout = () => {
  reqCommonFeedback(logout(), () => {
    // 清空用户信息
    setUserInfo({id: '', username: '', nickname: ''});
    // 清空用户主题配置
    const el = document.documentElement;
    isDark.value = false;
    resetTheme();
    setDarkTheme(el);
    // 跳转登录页面
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


const saveTheme = () => {
  switchTheme();
  updateTheme();
}

const switchTheme = () => {
  // document.documentElement 是全局变量时
  const el = document.documentElement;

  getComputedStyle(el).getPropertyValue(`--el-color-primary`);
  el.style.setProperty('--el-color-primary', colorTheme.value);

  getComputedStyle(el).getPropertyValue(`--el-color-primary-light-3`);
  el.style.setProperty('--el-color-primary-light-3', colorTheme2.value);

  getComputedStyle(el).getPropertyValue(`--el-color-primary-dark-2`);
  el.style.setProperty('--el-color-primary-dark-2', colorTheme3.value);

  getComputedStyle(el).getPropertyValue(`--el-color-primary-light-9`);
  el.style.setProperty('--el-color-primary-light-9', colorTheme4.value);

  getComputedStyle(el).getPropertyValue(`--el-menu-hover-bg-color`);
  // 暗黑
  setDarkTheme(el);
}

const updateTheme = () => {
  reqCommonFeedback(sysThemeApi.updateByUser({
    primaryColor: colorTheme.value,
    color2: colorTheme2.value,
    color3: colorTheme3.value,
    color4: colorTheme4.value,
    isDark: isDark.value,
  }), () => {
    ElMessage({
      message: '主题设置成功!',
      type: 'success',
    });
  })
}

const setDarkTheme = (el: HTMLElement) => {
  if (isDark.value) {
    el.style.setProperty('--el-menu-hover-bg-color', '#010101');
  } else {
    el.style.setProperty('--el-menu-hover-bg-color', '#ecf5ff');
  }
  const isUseDark = useDark({
    selector: 'html',
    attribute: 'class',
    valueDark: 'dark',
    valueLight: isDark.value ? 'dark' : 'light',
  });
  useToggle(isUseDark);
}

const resetTheme = () => {
  const el = document.documentElement;
  getComputedStyle(el).getPropertyValue(`--el-color-primary`);
  el.style.setProperty('--el-color-primary', defaultColor);
  getComputedStyle(el).getPropertyValue(`--el-color-primary-light-3`);
  el.style.setProperty('--el-color-primary-light-3', defaultColor2);
  getComputedStyle(el).getPropertyValue(`--el-color-primary-dark-2`);
  el.style.setProperty('--el-color-primary-dark-2', defaultColor3);
  getComputedStyle(el).getPropertyValue(`--el-color-primary-light-9`);
  el.style.setProperty('--el-color-primary-light-9', defaultColor4);
  colorTheme.value = defaultColor;
  colorTheme2.value = defaultColor2;
  colorTheme3.value = defaultColor3;
  colorTheme4.value = defaultColor4;
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