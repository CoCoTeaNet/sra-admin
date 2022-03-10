<template>
  <el-row align="middle" gutter="12">
    <!-- 折叠菜单按钮 -->
    <el-col span="12">
      <el-button type="text" :icon="store.state.isCollapseMenu ? Expand : Fold" @click="setCollapseMenu"></el-button>
    </el-col>
    <!-- 面包屑 -->
    <el-col span="12">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item v-for="item in itemList" :to="{ path: item.href }">
          {{ item.text }}
        </el-breadcrumb-item>
      </el-breadcrumb>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {RouteLocationMatched, useRoute} from "vue-router";
import { Expand, Fold } from '@element-plus/icons-vue';
import {useStore, setCollapseMenu} from "@/store";

const store = ref<any>(useStore());

const itemList = ref<RouteLocationMatched[]>([]);

onMounted(() => {
  getRouterMatch();
})

/**
 * 获取路由导航地址
 */
const getRouterMatch = () => {
  let list = useRoute().matched;
  let items: any[] = []
  list.forEach((item, index) => {
    items.push({text: item.meta.title, disabled: index === list.length - 1, href: item.path});
  });
  itemList.value = items;
}
</script>

<style scoped></style>