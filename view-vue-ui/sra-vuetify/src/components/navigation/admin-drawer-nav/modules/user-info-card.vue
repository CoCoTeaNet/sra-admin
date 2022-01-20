<template>
  <v-menu
      v-model="menu"
      :close-on-content-click="false"
      :nudge-width="200"
      offset-x
  >
    <template v-slot:activator="{ on, attrs }">
      <v-list-item class="px-2">
        <v-list-item-avatar v-bind="attrs" v-on="on">
          <v-img src="https://randomuser.me/api/portraits/women/75.jpg"></v-img>
        </v-list-item-avatar>

        <v-list-item link>
          <v-list-item-content>
            <v-list-item-title class="text-h6">
              Sandra Adams
            </v-list-item-title>
            <v-list-item-subtitle>sandra_a88@gmail.com</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </v-list-item>
    </template>

    <v-card>
      <v-list>
        <v-list-item>
          <v-list-item-avatar>
            <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John">
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title>John Leider</v-list-item-title>
            <v-list-item-subtitle>Founder of Vuetify</v-list-item-subtitle>
          </v-list-item-content>

          <v-list-item-action>
            <v-btn :class="fav ? 'red--text' : ''" icon @click="fav = !fav">
              <v-icon>mdi-heart</v-icon>
            </v-btn>
          </v-list-item-action>
        </v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list>
        <v-list-item>
          <v-list-item-action>
            <v-switch
                v-model="message"
                color="purple"
            ></v-switch>
          </v-list-item-action>
          <v-list-item-title>Enable messages</v-list-item-title>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <v-switch
                v-model="hints"
                color="purple"
            ></v-switch>
          </v-list-item-action>
          <v-list-item-title>Enable hints</v-list-item-title>
        </v-list-item>
      </v-list>

      <v-card-actions>
        <v-spacer></v-spacer>

        <v-btn color="primary" text @click="logout">
          退出账号
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-menu>
</template>

<script>
import {logout} from "@/api/system/user-api";

export default {
  data: () => ({
    fav: true,
    menu: false,
    message: false,
    hints: true,
  }),
  methods: {
    /**
     * 退出登录
     */
    logout() {
      let self = this;
      logout().then(res => {
        if(res.code === 200) {
          self.$store.commit('user/setUserInfo', null);
          self.$router.push({path: '/login'});
          self.menu = false;
        }
      });
    }
  }
}
</script>