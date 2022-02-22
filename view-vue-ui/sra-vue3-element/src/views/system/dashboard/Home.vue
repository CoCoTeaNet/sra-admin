<template>
  <div>
    <p>count: {{ store.state.count }}</p>
    <el-button @click="sum">加一</el-button>
  </div>
</template>

<script setup lang="ts">
import {onMounted} from "vue";
import {useStore, setStore} from "@/store";
import {index} from "@/api/system/test-api";

const store = useStore()

const sum = () => {
  setStore()
}

onMounted(() => {
  console.log('组件已挂载.')
  index().then((res: any) => {
    console.log(res.data)
  });
})
</script>

<style scoped>

</style>