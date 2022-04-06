<template>
  <div style="height: 100%;display: flex;flex-direction: column">
    <el-menu background-color="#00000000" text-color="#333333" default-active="1"
             :style="`height: 100%;padding: 0 ${!store.state.isCollapseMenu ? '10px' : '0'};`"
             :default-openeds="['0']" :collapse="store.state.isCollapseMenu">
      <!-- LOGO -->
      <h3 style="text-align: center;">
        {{ !store.state.isCollapseMenu ? 'SRA后台管理系统' : 'SR' }}
      </h3>
      <!-- 顶级菜单 -->
      <template v-for="(item, index) in store.state.userInfo.menuList" :key="index">
        <el-menu-item v-if="!hasChildren(item)" @click="$router.push({path: item.routerPath})" :index="`${index}`">
          <el-icon><component :is="item.iconPath"></component></el-icon>
          <template #title>
            <span>{{ item.menuName }}</span>
          </template>
        </el-menu-item>
        <!-- 有子菜单 -->
        <el-sub-menu v-if="hasChildren(item)" :index="`${index}`">
          <template #title>
            <el-icon><component :is="item.iconPath"></component></el-icon>
            <span>{{ item.menuName }}</span>
          </template>
          <!-- 二级菜单 -->
          <div v-for="(secItem, secIndex) in item.children" :key="`${index}-${secIndex}`">
            <el-menu-item v-if="!hasChildren(secItem)"
                          :index="`${index}-${secIndex}`"
                          @click="$router.push({path: secItem.routerPath})">
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
                            @click="$router.push({path: thiItem.routerPath})">
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
  </div>
</template>

<script setup lang="ts">
import {useStore} from "@/store";

const store = useStore();

/**
 * 判断是否有子菜单
 */
const hasChildren = (m: MenuModel) => {
  return m.children && m.children.length > 0;
}
</script>