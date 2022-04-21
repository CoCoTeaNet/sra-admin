<template>
  <div>
    <el-button type="text" @click="dialogVisible = true">click to open the Dialog</el-button>
    <el-dialog title="生成实体类" v-model="dialogVisible" width="80%" style="height: 75%">
      <iframe src="http://192.168.31.242:7777/codeGenerator/getByTableName/sys_user"
              style="width: 1024px;height: 640px;border: none"></iframe>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';

const dialogVisible = ref(false);

</script>

<style scoped>

</style>