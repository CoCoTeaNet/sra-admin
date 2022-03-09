<template>
  <el-breadcrumb separator="/">
    <el-breadcrumb-item v-for="item in itemList" :to="{ path: item.href }">
      {{ item.text }}
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {RouteLocationMatched, useRoute} from "vue-router";

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