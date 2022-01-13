<template>
  <v-app>
    <div id="appOutbox">
      <!-- 路由出口 -->
      <!-- 路由匹配到的组件将渲染在这里 -->
      <router-view></router-view>
    </div>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data: () => ({}),
};
</script>

<style scoped>
#appOutbox {
  width: 100%;
  height: 100vh;
}
</style>