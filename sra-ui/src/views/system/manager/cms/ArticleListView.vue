<template>
  <div>
    <table-manage>
      <template v-slot:search>
        <el-form-item label="时间">
          <el-date-picker
              type="daterange"
              range-separator="To"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
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
          <el-button type="primary" @click="onShowEditor">添加文章</el-button>
        </el-col>
        <el-col span="12">
          <el-button plain type="danger">批量删除</el-button>
        </el-col>
      </template>
      <template v-slot:default>
        <el-table :data="tableData" style="width: 100%">
          <el-table-column type="selection" width="55"/>
          <el-table-column prop="title" label="标题" width="150"/>
          <el-table-column prop="summary" label="简介" width="200"/>
          <el-table-column prop="tags" label="标签" width="200"/>
          <el-table-column prop="publishStatus" label="发布状态" width="120"/>
          <el-table-column prop="createBy" label="创建人" width="180"/>
          <el-table-column prop="createTime" label="创建时间" min-width="220"/>
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

    <article-editor v-model:show="editorShow">
    </article-editor>
  </div>
</template>

<script setup lang="ts">
import TableManage from '@/components/container/TableManage.vue';
import ArticleEditor from "@/views/system/manager/cms/module/ArticleEditor.vue";
import {onMounted, ref} from "vue";
import {listByPage} from '@/api/cms/article-api';
import {reqCommonFeedback} from "@/api/ApiFeedback";

const editorShow = ref<boolean>(false);
const page = ref<PageParam>({pageNo: 1, pageSize: 15, searchObject: {title: ''}});
const tableData = ref();

onMounted(() => {
  loadTableData();
});

const loadTableData = () => {
  let param = {pageNo: page.value.pageNo, pageSize: page.value.pageSize, articleVo: page.value.searchObject};
  reqCommonFeedback(listByPage(param), (data: any) => {
    tableData.value = data.rows;
  });
}

const handleClick = () => {
  console.log('click')
}

const onShowEditor = () => {
  editorShow.value = true;
}

</script>

<style scoped></style>