<template>
  <div class="ac-box">
    <div class="ac-nav" :style="`width:${lWidth}`">
      <slot name="nav"></slot>
    </div>
    <div class="ac-right" :style="`width:${rWidth}`">
      <div class="ac-header">
        <slot name="header"></slot>
      </div>
      <div class="ac-main">
        <slot name="main"></slot>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">

withDefaults(defineProps<{
  lWidth?: string,
  rWidth?: string
}>(), {lWidth: '18%', rWidth: '82%'});
</script>

<style scoped>
.ac-box {
  display: flex;
}

.ac-nav {
}

.ac-right {
  padding-right: 1em;
}

.ac-header {
  margin-top: 1em;
}

.ac-main {
  margin-top: 2em;
}
</style>