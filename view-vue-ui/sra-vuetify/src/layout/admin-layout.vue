<template>
  <v-app id="inspire">
    <!-- 导航菜单 -->
    <admin-drawer-nav/>

    <!-- 顶部条 -->
    <v-app-bar app clipped-right flat height="72" class="elevation-2">
      <!-- 顶部导航栏 -->
      <AdminTagsNav style="width: 86%" />
      <!-- 间隔 -->
      <v-spacer></v-spacer>
      <!-- 搜索框 -->
      <v-responsive max-width="156">
        <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
        ></v-text-field>
      </v-responsive>
    </v-app-bar>

    <!-- 主要内容 -->
    <v-main>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>

    <!-- 底部信息 -->
    <v-footer app color="transparent" height="72" inset>
      Apache License 2.0 | Copyright 2022-sra-sss-admin
    </v-footer>
  </v-app>
</template>

<script>
import AdminDrawerNav from "@/components/navigation/admin-drawer-nav";
import AdminTagsNav from "@/components/navigation/admin-tags-nav";

export default {
  components: {AdminTagsNav, AdminDrawerNav},
  data: () => ({}),
};
</script>