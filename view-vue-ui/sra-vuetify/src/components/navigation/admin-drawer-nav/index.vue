<template>
  <v-navigation-drawer app permanent>
    <v-list nav dense>
      <!-- 用户头像 -->
      <v-list-item>
        <user-info-card/>
      </v-list-item>
      <v-divider></v-divider>
      <!-- 菜单列表 -->
      <v-list-item v-for="(item, index) in items" :key="index" :to="item.routerPath">
        <v-list-item-icon>
          <v-icon>{{ item.iconPath }}</v-icon>
        </v-list-item-icon>
        <v-list-item-title v-text="item.menuName"></v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import UserInfoCard from "@/components/navigation/admin-drawer-nav/modules/user-info-card";

export default {
  components: {UserInfoCard},
  props: {
    items: {type: Array, required: false, default: []}
  },
  data() {
    return {
      mini: true,
      drawer: null
    }
  }
}
</script>
