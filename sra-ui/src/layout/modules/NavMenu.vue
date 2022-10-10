<template>
  <el-menu background-color="#00000000" text-color="#333333" class="menu" :default-active="menuState.defaultActive"
           :style="`height: 100%;padding: 0 ${!store.state.isCollapseMenu ? '10px' : '0'};`"
           :default-openeds="menuState.defaultOpened" :collapse="store.state.isCollapseMenu">
    <!-- LOGO -->
    <div v-if="!store.state.isCollapseMenu" class="logo">
      <img :src="require('@/assets/logo.png')" style="width: 36px" alt="logo">
      <h2 style="overflow: hidden;white-space: nowrap;">
        SRA后台管理系统
      </h2>
    </div>
    <img v-else :src="require('@/assets/logo.png')" style="width: 100%;cursor: pointer" alt="logo">
    <!-- 顶级菜单 -->
    <template v-for="(item, index) in store.state.userInfo.menuList" :key="index">
      <el-menu-item v-if="!hasChildren(item)" @click="onClickMenu(item)" :index="`${index}`">
        <el-icon>
          <component :is="item.iconPath"></component>
        </el-icon>
        <template #title>
          <span>{{ item.menuName }}</span>
        </template>
      </el-menu-item>
      <!-- 有子菜单 -->
      <el-sub-menu v-if="hasChildren(item)" :index="`${index}`">
        <template #title>
          <el-icon>
            <component :is="item.iconPath"></component>
          </el-icon>
          <span>{{ item.menuName }}</span>
        </template>
        <!-- 二级菜单 -->
        <div v-for="(secItem, secIndex) in item.children" :key="`${index}-${secIndex}`">
          <el-menu-item v-if="!hasChildren(secItem)"
                        :index="`${index}-${secIndex}`"
                        @click="onClickMenu(secItem)">
            <el-icon>
              <component :is="secItem.iconPath"></component>
            </el-icon>
            <template #title>{{ secItem.menuName }}</template>
          </el-menu-item>

          <el-sub-menu v-if="hasChildren(secItem)" :index="`${index}-${secIndex}`">
            <template #title>
              <el-icon>
                <component :is="secItem.iconPath"></component>
              </el-icon>
              <span>{{ secItem.menuName }}</span>
            </template>
            <!-- 三级菜单 -->
            <el-menu-item v-for="(thiItem, thiIndex) in secItem.children"
                          :key="`${index}-${secIndex}-${thiIndex}`" :index="`${index}-${secIndex}-${thiIndex}`"
                          @click="onClickMenu(thiItem)">
              <el-icon>
                <component :is="thiItem.iconPath"></component>
              </el-icon>
              <template #title>{{ thiItem.menuName }}</template>
            </el-menu-item>
          </el-sub-menu>
        </div>
      </el-sub-menu>
    </template>
  </el-menu>
</template>

<script setup lang="ts">
import {useStore} from "@/store";
import {useRoute} from "vue-router";
import {computed} from "vue";
import {addTabItem} from "@/store";
import {router} from "@/router";

const store = useStore();
const route = useRoute();

/**
 * 根据路由路径动态设置当前菜单的状态
 */
let menuState = computed(() => {
  const path = route.path;
  const routes = store.state.userInfo.menuList;
  let state = {defaultOpened: [""], defaultActive: ""};
  if (routes) {
    let stack: Array<string> = [];
    for (let i in routes) {
      let r = routes[i];
      let len = stack.length;
      dfs(r, path, stack);
      if (len < stack.length) {
        state.defaultOpened = [i.toString()];
        stack.push(i);
        break;
      }
    }
    if (stack.length > 0) {
      let activeKey = "";
      for (let i = stack.length - 1; i >= 0; i--) {
        activeKey += stack[i];
        if (i != 0) {
          activeKey += "-";
        }
      }
      state.defaultActive = activeKey;
    }
  }
  return state;
});

const dfs = (root: MenuModel, path: string, stack: Array<string>) => {
  if (root.children) {
    let len = stack.length;
    for (let i in root.children) {
      let r = root.children[i];
      if (path === r.routerPath) {
        stack.push(i);
        return;
      }
      dfs(r, path, stack);
      if (len < stack.length) {
        return;
      }
    }
  }
}

/**
 * 判断是否有子菜单
 */
const hasChildren = (m: MenuModel) => {
  return m.children && m.children.length > 0;
}

const onClickMenu = (item: any) => {
  router.push({path: item.routerPath});
  addTabItem({name: item.menuName, url: item.routerPath, isActive: true});
}

</script>

<style scoped lang="css">
.logo {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.menu-box {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.el-menu-item.is-active {
  color: #000000;
  background-color: rgb(204, 204, 204);
  padding: 3px;
}

.el-menu-item:hover {
  background-color: rgb(204, 204, 204, 0.5);
}
</style>