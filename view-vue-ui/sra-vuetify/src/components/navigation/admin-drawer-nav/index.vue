<template>
  <v-navigation-drawer app permanent :mini-variant="mini" light class="white">
    <v-row class="fill-height overflow-hidden" no-gutters>
      <!-- 嵌套导航 -->
      <v-navigation-drawer dark mini-variant mini-variant-width="56" permanent>
        <v-list class="fill-height">
          <!-- 头像 -->
          <v-list-item>
            <v-avatar @click="packUpNav" size="31">
              <v-img src="https://randomuser.me/api/portraits/women/75.jpg"></v-img>
            </v-avatar>
          </v-list-item>
          <v-list-item> <v-divider></v-divider> </v-list-item>
          <!-- 顶级菜单 -->
          <v-list-item v-for="(item, index) in firstLevelMenus" :key="index">
            <v-icon>{{ item.iconPath }}</v-icon>
          </v-list-item>
          <!-- 退出按钮 -->
          <v-list-item style="position: absolute;bottom: 0;">
            <v-menu v-model="menu" :close-on-content-click="false" offset-x max-width="98">
              <template v-slot:activator="{ on, attrs }">
                <v-icon v-on="on" v-bind="attrs">mdi-power</v-icon>
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

      <v-col v-show="!mini">
        <v-list dense>
          <!-- 用户信息 -->
          <v-btn v-if="!mini" icon @click.stop="packUpNav" absolute right style="z-index: 999">
            <v-icon>mdi-chevron-left</v-icon>
          </v-btn>
          <div @click="packUpNav">
            <user-info-card @packUpNav="packUpNav"/>
          </div>
        </v-list>
        <!-- 分割线 -->
        <v-divider></v-divider>
        <!-- 二级菜单列表 -->
        <v-list nav dense>
          <!-- :prepend-icon="item.iconPath"-->
          <v-list-group v-for="(item, index) in secondLevelMenus" :key="index">
            <template v-slot:activator>
              <v-list-item-title v-text="item.menuName"></v-list-item-title>
            </template>
            <!-- 三级菜单 -->
            <v-list-item v-for="i in 5" :key="i" link>
              <v-list-item-title v-text="'title'"></v-list-item-title>
            </v-list-item>
          </v-list-group>
        </v-list>
      </v-col>
    </v-row>
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
      firstLevelMenus: [],
      firstLevelIds: [],
      secondLevelMenus: [],
      threeLevelMenus: [],
      menu: false,
      mini: false
    }
  },
  created() {
    this.getLevelMenus();
  },
  methods: {
    /**
     * 收起导航栏
     */
    packUpNav() {
      this.mini = !this.mini;
    },
    /**
     * 获取菜单并且分级
     */
    getLevelMenus() {
      let firstLevel = [];
      // 映射一级id
      this.items.forEach(item => {
        if (item.parentId === '0') {
          firstLevel.push(item.id);
        }
      });
      // 映射二级id
      let secondLevel = [];
      this.items.forEach(item => {
        if (firstLevel.includes(item.parentId)){
          secondLevel.push(item.id);
        }
      });
      this.items.forEach(item => {
        // 获取一级
        if (firstLevel.includes(item.id)) {
          this.firstLevelMenus.push(item);
        }
        // 获取二级
        if (firstLevel.includes(item.parentId)) {
          this.secondLevelMenus.push(item);
        }
        // 获取三级
        if (!firstLevel.includes(item.parentId) && !secondLevel.includes(item.parentId)){
          this.threeLevelMenus.push(item);
        }
      });
    },
    /**
     * 退出登录
     */
    logout() {
      let self = this;
      logout().then(res => {
        if (res.code === 200) {
          self.$store.commit('user/setUserInfo', null);
          self.$router.push({path: '/login'});
          self.menu = false;
        }
      });
    },
  }
}
</script>
