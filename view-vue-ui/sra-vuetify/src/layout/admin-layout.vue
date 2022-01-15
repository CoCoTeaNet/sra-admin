<template>
  <v-app id="inspire">
    <!-- 导航菜单 -->
    <admin-drawer-nav/>

    <!-- 搜索 -->
    <v-app-bar app clipped-right flat height="72">
      <v-spacer></v-spacer>

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
        {{ $store.state.user.userInfo.userDetail.nickname.substring(0, 2) }}
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

export default {
  components: {AdminDrawerNav},
  data: () => ({}),
};
</script>