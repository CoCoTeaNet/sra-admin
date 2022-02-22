<template>
  <div>home: {{store.state.count}}</div>
</template>

<script setup lang="ts">
import {useStore} from "@/store";

const store = useStore()

</script>

<style scoped>

</style>