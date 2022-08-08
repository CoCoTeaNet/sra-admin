<template>
  <table-manage>
    <template v-slot:search>
      <el-form-item label="时间">
        <el-date-picker
            type="daterange"
            range-separator="To"
            start-placeholder="Start date"
            end-placeholder="End date"
        />
      </el-form-item>
      <el-form-item label="创建人">
        <el-input placeholder="作者"/>
      </el-form-item>
      <el-form-item label="文章标题">
        <el-input placeholder="标题"/>
      </el-form-item>
      <el-form-item label="状态">
        <el-select placeholder="选择状态">
          <el-option label="Zone one" value="shanghai"/>
          <el-option label="Zone two" value="beijing"/>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">搜索</el-button>
        <el-button>重置</el-button>
      </el-form-item>
    </template>
    <template v-slot:operate>
      <el-col span="12">
        <el-button type="primary">添加文章</el-button>
      </el-col>
      <el-col span="12">
        <el-button plain type="danger">批量删除</el-button>
      </el-col>
    </template>
    <template v-slot:default>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column type="selection" width="55"/>
        <el-table-column prop="name" label="标题" width="150"/>
        <el-table-column prop="state" label="简介" width="200"/>
        <el-table-column prop="state" label="发布状态" width="120"/>
        <el-table-column prop="address" label="创建人" width="180"/>
        <el-table-column prop="zip" label="创建时间" min-width="220"/>
        <el-table-column fixed="right" label="操作" width="240">
          <template #default>
            <el-button link type="primary" @click="handleClick">详细</el-button>
            <el-button link type="primary">编辑</el-button>
            <el-button link type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
    <template v-slot:page>
      <el-pagination background layout="prev, pager, next" :total="50" class="mt-4"/>
    </template>
  </table-manage>
</template>

<script setup lang="ts">
import TableManage from '@/components/container/TableManage.vue';

const handleClick = () => {
  console.log('click')
}

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St',
    zip: 'CA 90036',
    tag: 'Home',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St',
    zip: 'CA 90036',
    tag: 'Office',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St',
    zip: 'CA 90036',
    tag: 'Home',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St',
    zip: '2022-12-12 12:00:08',
    tag: 'Office',
  },
]
</script>

<style scoped></style>