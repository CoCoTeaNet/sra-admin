<template>
  <v-navigation-drawer app permanent>
    <!-- 用户头像 -->
    <user-info-card/>

    <v-divider></v-divider>

    <v-list nav dense>
      <v-list-item v-for="item in items" :key="item.id" :to="item.routerPath" link>
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
