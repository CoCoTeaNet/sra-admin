<template>
  <v-navigation-drawer app class="elevation-1" permanent width="300" v-model="drawer">
    <v-row class="fill-height" no-gutters>
      <v-navigation-drawer dark mini-variant mini-variant-width="56" permanent>
        <!-- 用户头像 -->
        <user-info-card/>

        <v-divider></v-divider>

        <v-list dense nav>
          <v-list-item v-for="item in items" :key="item.id">
            <v-list-item-action>
              <v-icon>{{ item.iconPath }}</v-icon>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>{{ item.menuName }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-list class="grow">
        <v-sheet color="white" width="100%" height="12"></v-sheet>
        <v-list-item v-for="item in items" :key="item.id" :to="item.routerPath" link>
          <v-icon>{{ item.iconPath }}</v-icon>
          <v-list-item-title v-text="item.menuName"></v-list-item-title>
        </v-list-item>
      </v-list>
    </v-row>
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
