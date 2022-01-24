<template>
  <v-navigation-drawer app permanent :mini-variant="mini">
    <v-list dense>
      <!-- 用户信息 -->
      <v-btn v-if="!mini" icon @click.stop="packUpNav" absolute right style="z-index: 999">
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>
      <div @click="packUpNav"><user-info-card @packUpNav="packUpNav" /></div>
    </v-list>
    <!-- 分割线 -->
    <v-divider></v-divider>
    <v-list nav dense>
      <!-- 菜单列表 -->
      <v-list-item-group color="primary">
        <v-list-item v-for="(item, index) in items" :key="index" :to="item.routerPath">
          <v-list-item-icon><v-icon>{{ item.iconPath }}</v-icon></v-list-item-icon>
          <v-list-item-title v-text="item.menuName"></v-list-item-title>
        </v-list-item>
      </v-list-item-group>
      <!-- 退出按钮 -->
      <v-list-item style="position: absolute;bottom: 0;left: 0;width: 100%">
        <v-menu v-model="menu" :close-on-content-click="false" offset-x max-width="98">
          <template v-slot:activator="{ on, attrs }">
            <v-list-item v-on="on" v-bind="attrs" to="#">
              <v-list-item-icon>
                <v-icon>mdi-exit-to-app</v-icon>
              </v-list-item-icon>
              <v-list-item-title>退出系统</v-list-item-title>
            </v-list-item>
          </template>
          <v-list>
            <v-list-item>
              <v-btn text @click="logout">确定</v-btn>
            </v-list-item>
            <v-list-item>
              <v-btn text @click="menu=false">取消</v-btn>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import UserInfoCard from "@/components/navigation/admin-drawer-nav/modules/user-info-card";
import {logout} from "@/api/system/user-api";

export default {
  components: {UserInfoCard},
  props: {
    items: {type: Array, required: false, default: []}
  },
  data() {
    return {
      menu: false,
      mini: false
    }
  },
  methods: {
    packUpNav() {
      this.mini = !this.mini;
    },
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
    },
  }
}
</script>
