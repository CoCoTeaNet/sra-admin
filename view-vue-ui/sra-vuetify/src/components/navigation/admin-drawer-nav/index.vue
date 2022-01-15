<template>
  <v-navigation-drawer
      app
      permanent
      width="300"
      v-model="drawer"
  >
    <v-row
        class="fill-height"
        no-gutters
    >
      <v-navigation-drawer
          dark
          mini-variant
          mini-variant-width="56"
          permanent
      >
        <!-- 用户头像 -->
        <user-info-card/>

        <v-divider></v-divider>

        <v-list
            dense
            nav
        >
          <v-list-item
              v-for="item in items"
              :key="item.title"
          >
            <v-list-item-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-list class="grow">
        <v-sheet color="white" width="100%" height="12"></v-sheet>
        <v-list-item
            v-for="link in links"
            :key="link"
            link
        >
          <v-list-item-title v-text="link"></v-list-item-title>
        </v-list-item>
      </v-list>
    </v-row>
  </v-navigation-drawer>
</template>

<script>
import UserInfoCard from "@/components/navigation/admin-drawer-nav/modules/user-info-card";
export default {
  components: {UserInfoCard},
  data() {
    return {
      items: [
        {title: 'Home', icon: 'mdi-view-dashboard'},
        {title: 'About', icon: 'mdi-forum'},
      ],
      links: ['Home', 'Contacts', 'Settings'],
      mini: true,
      drawer: null
    }
  }
}
</script>
