<template>
  <div id="appOutbox">
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: "App",
  data: () => ({})
};
</script>

<style scoped>
#appOutbox {
  width: 100%;
  height: 100vh;
}
</style>