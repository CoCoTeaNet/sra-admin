<template>
  <v-row>
    <!-- 用户数量 -->
    <v-col>
      <v-card>
        <v-card-title>用户数量</v-card-title>
        <v-card-text>15</v-card-text>
      </v-card>
    </v-col>
    <!-- 角色数量 -->
    <v-col>
      <v-card>
        <v-card-title>角色数量</v-card-title>
        <v-card-text>15</v-card-text>
      </v-card>
    </v-col>
    <!-- 菜单数量 -->
    <v-col>
      <v-card>
        <v-card-title>菜单数量</v-card-title>
        <v-card-text>15</v-card-text>
      </v-card>
    </v-col>
    <!-- 在线人数：30秒发送一次请求告诉服务器在线 -->
    <v-col>
      <v-card>
        <v-card-title>在线人数</v-card-title>
        <v-card-text>15</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "system-count"
}
</script>

<style scoped>

</style>