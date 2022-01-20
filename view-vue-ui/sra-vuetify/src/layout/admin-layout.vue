<template>
  <v-app id="adminLayout">
    <!-- 导航菜单 -->
    <admin-drawer-nav :items="menuList"/>

    <!-- 顶部条 -->
    <v-app-bar app clipped-right flat height="52" color="white">
      <!-- 顶部导航栏 -->
      <template>
        <v-btn text rounded>
          <v-icon>mdi-format-list-bulleted-square</v-icon>
        </v-btn>
        <admin-tags-nav/>
      </template>
      <!-- 间隔 -->
      <v-spacer></v-spacer>
    </v-app-bar>

    <!-- 主要内容 -->
    <v-main>
      <v-divider></v-divider>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>

    <!-- 底部信息 -->
    <v-footer app color="transparent" height="72" inset light>
      Apache License 2.0 | Copyright 2022-sra-sss-admin
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