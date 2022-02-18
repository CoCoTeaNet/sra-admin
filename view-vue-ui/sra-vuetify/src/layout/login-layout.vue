<template>
  <v-app id="loginLayout">
    <div class="login-layout-outbox">
      <!-- 登录页-组件 -->
      <login-view/>
    </div>
  </v-app>
</template>

<script>
import LoginView from "@/views/system/login/index";
import {index} from "@/api/system/test-api";

export default {
  components: {LoginView},
  mounted() {
    setTimeout(async () => {
      let res = await index();
      if (res.code === 200) {
        console.log(res.data);
      }
    }, 800);
  }
};
</script>

<style scoped>
.login-layout-outbox {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(30deg, pink, #8080ff);
}
</style>