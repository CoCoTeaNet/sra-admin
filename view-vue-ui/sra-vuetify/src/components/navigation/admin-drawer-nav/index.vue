<template>
  <v-navigation-drawer app permanent :mini-variant="mini" light class="white" width="279">
    <v-row class="fill-height" no-gutters>
      <!-- 嵌套导航 -->
      <v-col :cols="!mini ? 2 : 10">
        <v-navigation-drawer dark mini-variant permanent>
          <v-list class="fill-height">
            <!-- 头像 -->
            <v-list-item class="pa-0 ma-2">
              <v-avatar @click="packUpNav" size="32">
                <v-img src="https://randomuser.me/api/portraits/women/75.jpg"></v-img>
              </v-avatar>
            </v-list-item>
            <v-list-item>
              <v-divider></v-divider>
            </v-list-item>
            <!-- 顶级菜单 -->
            <v-list-item v-for="(item, index) in firstLevelMenus" :key="index" class="pa-0"
                         @click="onRootMenuChange(item)">
              <div class="text-center" style="width: 100%">
                <v-icon>{{ item.iconPath }}</v-icon>
              </div>
            </v-list-item>
            <!-- 退出按钮 -->
            <v-list-item class="pa-0 ma-2" style="position: absolute;bottom: 0;">
              <v-menu v-model="menu" :close-on-content-click="false" offset-x>
                <template v-slot:activator="{ on, attrs }">
                  <v-icon size="32" v-on="on" v-bind="attrs">mdi-power</v-icon>
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
      </v-col>

      <v-col cols="10" v-show="!mini">
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
          <!-- 按钮类型;0目录 1菜单 2按钮  -->
          <div v-for="(item, index) in secondLevelMenus">
            <!-- 菜单 -->
            <v-list-item v-if="item.menuType !== '0'" :key="index" :to="item.routerPath">
              <v-list-item-icon>
                <v-icon>{{ item.iconPath }}</v-icon>
              </v-list-item-icon>
              <v-list-item-title>{{ item.menuName }}</v-list-item-title>
            </v-list-item>
            <!-- 目录 -->
            <v-list-group v-else-if="item.menuType === '0'" :prepend-icon="item.iconPath" :key="index" no-action>
              <template v-slot:activator>
                <v-list-item-title v-text="item.menuName"></v-list-item-title>
              </template>
              <!-- 三级菜单 -->
              <v-list-item v-for="item in item.children" :key="item.id" :to="item.routerPath" link>
                <v-list-item-title v-text="item.menuName"></v-list-item-title>
                <v-list-item-icon>
                  <v-icon>{{ item.iconPath }}</v-icon>
                </v-list-item-icon>
              </v-list-item>
            </v-list-group>
          </div>
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
      menu: false,
      mini: false,
      selectRootMenuId: '0'
    }
  },
  created() {
    this.getFirstLevelMenus();
    this.getSecondLevelMenus();
  },
  watch: {
    selectRootMenuId() {
      this.getSecondLevelMenus();
    }
  },
  methods: {
    /**
     * 收起导航栏
     */
    packUpNav() {
      this.mini = !this.mini;
    },
    getFirstLevelMenus() {
      let list = this.items.filter(value => value.parentId === '0');
      this.selectRootMenuId = list[0].id;
      this.firstLevelMenus = list;
    },
    getSecondLevelMenus() {
      // 二级菜单
      let secondLevelMenus = this.items.filter(value => value.parentId === this.selectRootMenuId);
      // 拷贝对象，避免重复项
      secondLevelMenus = JSON.parse(JSON.stringify(secondLevelMenus));
      // 三级菜单
      this.items.forEach(item => {
        secondLevelMenus.forEach(value => {
          if (item.parentId === value.id) {
            if (!value.children) {
              value.children = [];
            }
            value.children.push(item);
          }
        });
      });
      this.secondLevelMenus = secondLevelMenus;
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
    /**
     * 顶级菜单切换
     */
    onRootMenuChange(item) {
      this.selectRootMenuId = item.id;
      this.$router.push({path: item.routerPath});
    }
  }
}
</script>
