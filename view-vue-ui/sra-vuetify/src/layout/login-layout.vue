<template>
  <div class="login-layout-outbox">
    <!-- 登录页-组件 -->
    <login-view />
  </div>
</template>

<script>
import LoginView from "@/views/system/login/index";

export default {
  components: { LoginView },
};
</script>

<style scoped>
.login-layout-outbox {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  background-image: url(https://cdn.vuetifyjs.com/images/parallax/material.jpg);
  padding: 0 4% 0 0;
}
</style>