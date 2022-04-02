<script setup lang="ts">
import BaseLayout from "@/layout/BaseLayout.vue";
import {setUserInfo} from "./store";

// 读取缓存，以免用户F5刷新登录失效
let userInfo = JSON.parse(`${localStorage.getItem("userInfo")}`);
if (userInfo) {
  setUserInfo(userInfo);
}
</script>

<template>
  <el-scrollbar :noresize="true">
    <base-layout style="height: 100vh"/>
  </el-scrollbar>
</template>

<style>
html, body, #app {
  margin: 0;
  padding: 0;
  height: 100%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.status-tag-red, .status-tag-green {
  color: white;
  border-radius: 3px;
  padding: 0.25em 1em;
  font-size: 12px;
}

.status-tag-red {
  background: #f56c6c;
  border: 1px solid #f56c6c;
}

.status-tag-green {
  background: #67c23a;
  border: 1px solid #67c23a;
}

</style>
