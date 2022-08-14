<template>
  <div class="tm-box">
    <el-form>
      <div class="tm-search">
        <slot name="search"></slot>
      </div>
    </el-form>

    <div class="tm-operate">
      <slot name="operate"></slot>
    </div>

    <div style="width: 100%;margin-top: 1em">
      <slot name="default"></slot>
    </div>

    <div style="margin-top: 3px">
      <slot name="page"></slot>
    </div>
  </div>
</template>

<script lang="ts" setup>
</script>

<style scoped>
.tm-box {
  background-color: white;
}

.tm-search {
  display: flex;
  flex-wrap: wrap;
}

::v-deep(.el-form-item) {
  margin-right: 1em;
}

.tm-operate {
  display: flex;
  justify-content: end;
}
</style>