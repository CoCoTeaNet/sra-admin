<template>
  <!-- 采用element-ui常用布局：https://element-plus.gitee.io/zh-CN/component/container.html -->
  <el-container style="height: 100%">
    <!-- 导航 -->
    <el-aside class="el-aside" :width="store.state.isCollapseMenu ? '64px' : '220px'">
      <NavMenu/>
    </el-aside>
    <el-container style="background: #F2F6FC">
      <!-- 头部 -->
      <el-header>
        <admin-header/>
      </el-header>
      <!-- 主体 -->
      <el-main>
        <admin-breadcrumb/>
        <div style="background: white;padding: 1em;border-radius: 3px;">
          <router-view></router-view>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import NavMenu from "./modules/NavMenu.vue";
import AdminHeader from "./modules/AdminHeader.vue";
import AdminBreadcrumb from "./modules/AdminBreadcrumb.vue";
import {useStore} from "@/store";
import {ref} from "vue";

const store = ref<any>(useStore());
</script>

<style scoped>
.el-aside {
  transition: width 200ms;
}
</style>