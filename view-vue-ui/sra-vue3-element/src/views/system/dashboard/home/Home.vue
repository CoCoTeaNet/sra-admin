<template>
  <div class="bg">
    <p>count: {{ store.state.count }}</p>
    <el-button @click="sum">加一</el-button>
    <div id="demo" style="height: 300px"></div>
  </div>
</template>

<script lang="ts" src="./ts/Home.ts"></script>

<style scoped src="./css/Home.css"></style>