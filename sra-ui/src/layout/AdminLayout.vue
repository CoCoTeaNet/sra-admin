<template>
  <!-- 采用element-ui常用布局：https://element-plus.gitee.io/zh-CN/component/container.html -->
  <el-container style="height: 100%">
    <!-- 头部 -->
    <el-header>
      <admin-header/>
    </el-header>
    <el-container style="background: #F2F6FC">
      <!-- 导航 -->
      <el-aside width="200px">
        <NavMenu/>
      </el-aside>
      <!-- 主体 -->
      <el-main>
        <admin-breadcrumb style="margin-bottom: 1em"/>
        <div style="background: white;padding: 1em;border-radius: 3px;">
          <router-view></router-view>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import NavMenu from "./modules/NavMenu.vue";
import AdminHeader from "./modules/AdminHeader.vue";
import AdminBreadcrumb from "./modules/AdminBreadcrumb.vue";

</script>

<style scoped>
.el-header{
  border-bottom: 1px solid #DCDFE6;
}
</style>