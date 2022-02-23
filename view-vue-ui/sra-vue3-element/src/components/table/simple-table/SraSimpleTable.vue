<template>
  <div>
    <!-- 表格操作 -->
    <el-row>
      <el-col :span="20">
        <el-button type="primary">添加</el-button>
        <el-button type="danger">删除</el-button>
      </el-col>
      <el-col :span="4" style="text-align: right">
        <el-input placeholder="搜索" :prefix-icon="Search"/>
      </el-col>
    </el-row>
    <!-- 表格视图 -->
    <el-table :data="tableData" stripe style="width: 100%">
      <slot/>
      <!-- 单行操作 -->
      <el-table-column fixed="right" label="操作" width="120">
        <template #default>
          <el-button type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination style="margin-top: 1em" background layout="prev, pager, next" :total="1000"
                   :page-sizes="[100, 200, 300, 400]">
    </el-pagination>
  </div>
</template>

<script lang="ts" setup>
import {Search} from "@element-plus/icons-vue";

defineProps({
  tableData: Array
});
</script>

<style scoped src="./css/SraSimpleTable.css"></style>