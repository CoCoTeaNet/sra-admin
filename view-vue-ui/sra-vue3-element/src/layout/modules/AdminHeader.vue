<template>
  <el-row align="middle" style="height: 100%;">
    <el-col :span="4">LOGO</el-col>
    <el-col :span="20" style="text-align: right">
      <el-avatar :src="url"></el-avatar>
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import {ref} from 'vue';

const url = ref('https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg');
</script>

<style scoped>

</style>