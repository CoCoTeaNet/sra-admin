<template>
  <v-app id="adminLayout">
    <!-- 导航菜单 -->
    <admin-drawer-nav :items="menuList"/>

    <!-- 顶部条 -->
    <v-app-bar app clipped-right flat height="52" color="white">
      <!-- 顶部导航栏 -->
      <template><admin-tags-nav/></template>
      <!-- 间隔 -->
      <v-spacer></v-spacer>
    </v-app-bar>

    <!-- 主要内容 -->
    <v-main class="grey lighten-3">
      <v-divider></v-divider>
      <v-container><router-view></router-view></v-container>
    </v-main>

    <!-- 底部信息 -->
    <v-footer class="elevation-1" color="white" app height="52" inset light>
      MIT License | copyright sss-rbac-admin 2022
    </v-footer>
  </v-app>
</template>

<script>
import AdminDrawerNav from "@/components/navigation/admin-drawer-nav";
import AdminTagsNav from "@/components/navigation/admin-tags-nav";

export default {
  components: {AdminTagsNav, AdminDrawerNav},
  data: () => ({
    menuList: []
  }),
  created() {
    this.getMenuList();
  },
  methods: {
    /**
     * 获取菜单列表
     */
    async getMenuList() {
      this.menuList = this.$store.state.user.userInfo.permissions;
    }
  }
};
</script>

<style>
/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.slide-fade-enter-active {
  transition: all .3s ease;
}

.slide-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(10px);
  opacity: 0;
}
</style>