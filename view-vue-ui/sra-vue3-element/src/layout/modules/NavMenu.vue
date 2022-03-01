<template>
  <el-menu default-active="1" style="height: 100%">
    <!-- 顶级菜单 -->
    <div v-for="(item, index) in store.state.userInfo.menuList" :key="index">
      <el-menu-item v-if="!hasChildren(item)" :index="index">
        <el-icon><component :is="item.iconPath"></component></el-icon>
        <template #title>{{ item.menuName }}</template>
      </el-menu-item>
      <!-- 有子菜单 -->
      <el-sub-menu v-if="hasChildren(item)" :index="index">
        <template #title>
          <el-icon><component :is="item.iconPath"></component></el-icon>
          <span>{{ item.menuName }}</span>
        </template>
        <!-- 二级菜单 -->
        <div v-for="(secItem, secIndex) in item.children" :key="`${index}-${secIndex}`">
          <el-menu-item v-if="!hasChildren(secItem)" :index="`${index}-${secIndex}`">
            <el-icon><component :is="secItem.iconPath"></component></el-icon>
            <template #title>{{ secItem.menuName}}</template>
          </el-menu-item>

          <el-sub-menu v-if="hasChildren(secItem)" :index="`${index}-${secIndex}`">
            <template #title>
              <el-icon><component :is="secItem.iconPath"></component></el-icon>
              <span>{{ secItem.menuName }}</span>
            </template>
            <!-- 三级菜单 -->
            <el-menu-item v-for="(thiItem, thiIndex) in secItem.children" :key="`${index}-${secIndex}-${thiIndex}`"
                          :index="`${index}-${secIndex}-${thiIndex}`">
              <el-icon><component :is="thiItem.iconPath"></component></el-icon>
              <template #title>{{ thiItem.menuName }}</template>
            </el-menu-item>
          </el-sub-menu>
        </div>
      </el-sub-menu>
    </div>
  </el-menu>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {useStore} from "@/store";

const store = ref<any>(useStore());

/**
 * 判断是否有子菜单
 */
const hasChildren = (m: MenuModel) => {
  return m.children && m.children.length > 0;
}

</script>