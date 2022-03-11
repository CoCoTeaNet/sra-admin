<template>
  <div class="bg">
    home
  </div>
</template>

<script setup lang="ts">
import {useStore} from "@/store";
import {ref} from "vue";

const store = ref(useStore());

</script>

<style scoped src="./css/Home.css"></style>