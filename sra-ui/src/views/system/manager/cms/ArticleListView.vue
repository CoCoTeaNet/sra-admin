<template>
  <div>
    <table-manage>
      <template v-slot:search>
        <el-form-item label="时间">
          <el-date-picker type="daterange" range-separator="~" start-placeholder="开始日期" end-placeholder="结束日期"/>
        </el-form-item>
        <el-form-item label="创建人">
          <el-input placeholder="作者"/>
        </el-form-item>
        <el-form-item label="文章标题">
          <el-input placeholder="标题"/>
        </el-form-item>
        <el-form-item label="发布状态">
          <el-select placeholder="选择状态">
            <el-option label="Zone one" value="shanghai"/>
            <el-option label="Zone two" value="beijing"/>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loadTableData">搜索</el-button>
          <el-button>重置</el-button>
        </el-form-item>
      </template>
      <template v-slot:operate>
        <el-col span="12">
          <el-button type="primary" @click="onCreate">添加文章</el-button>
        </el-col>
        <el-col span="12">
          <el-button plain type="danger" @click="onDeleteBatch">批量删除</el-button>
        </el-col>
      </template>
      <template v-slot:default>
        <el-table :data="tableData" style="width: 100%" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55"/>
          <el-table-column prop="title" label="封面" width="150">
            <template #default="scope">
              <el-image style="width: 100px; height: 100px" :src="scope.row.cover" fit="fill" />
            </template>
          </el-table-column>
          <el-table-column prop="title" label="标题" width="150"/>
          <el-table-column prop="summary" label="简介" width="200"/>
          <el-table-column prop="tags" label="标签" width="200">
            <template #default="scope">
              <el-tag style="margin-left: 3px" v-for="item in scope.row.tagList">{{ item }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="publishStatus" label="发布状态" width="120">
            <template #default="scope">
              <el-tag :type="getPublishStatus(scope.row.publishStatus, 0)">
                {{ getPublishStatus(scope.row.publishStatus, 1) }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="createBy" label="创建人" width="180"/>
          <el-table-column prop="createTime" label="创建时间" min-width="220"/>
          <el-table-column fixed="right" label="操作" width="240">
            <template #default="scope">
              <el-button link type="primary" @click="handleClick">详细</el-button>
              <el-button link type="primary" @click="onEdit(scope.row.id)">编辑</el-button>
              <el-button link type="primary">设置封面</el-button>
              <el-button link type="danger" @click="onDelete(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <template v-slot:page>
        <el-pagination background layout="prev, pager, next" :total="50" class="mt-4"/>
      </template>
    </table-manage>

    <article-editor
        v-model:show="editorShow"
        :editType="editType"
        :aid="editRowId"
        @onConfirm="loadTableData" />
  </div>
</template>

<script setup lang="ts">
import TableManage from '@/components/container/TableManage.vue';
import ArticleEditor from "@/views/system/manager/cms/module/ArticleEditor.vue";
import {onMounted, ref} from "vue";
import {listByPage, deleteBatch} from '@/api/cms/article-api';
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {ElMessage, ElMessageBox} from 'element-plus';

const editorShow = ref<boolean>(false);
const page = ref<PageParam>({pageNo: 1, pageSize: 15, searchObject: {title: ''}});
const tableData = ref();
const multipleSelection = ref<any[]>([]);
const editType = ref<string>('create');
const editRowId = ref<string>();

onMounted(() => {
  loadTableData();
});

/**
 * 发布状态;1正常 2审核中 3审核不通过 4冻结 5保存
 * @param status
 * @param type
 */
const getPublishStatus: any = (status: number, type: number) => {
  let obj = {color: '', text: ''};
  switch (status) {
    case 1:
      obj = {color: 'success', text: '正常'};
      break;
    case 2:
      obj = {color: 'info', text: '审核中'};
      break;
    case 3:
      obj = {color: 'danger', text: '不通过'};
      break;
    case 4:
      obj = {color: 'warning', text: '冻结'};
      break;
    case 5:
      obj = {color: 'info', text: '保存'};
      break;
  }
  if (type === 0) {
    return obj.color;
  } else {
    return obj.text;
  }
}

const loadTableData = () => {
  let param = {pageNo: page.value.pageNo, pageSize: page.value.pageSize, articleVo: page.value.searchObject};
  reqCommonFeedback(listByPage(param), (data: any) => {
    tableData.value = data.rows;
  });
}

const handleClick = () => {
  console.log('click')
}

const onCreate = () => {
  editType.value = 'create';
  editorShow.value = true;
}

const onEdit = (id: string) => {
  editRowId.value = id;
  editType.value = 'update';
  editorShow.value = true;
}

const onDelete = (id: string) => {
  ElMessageBox.confirm('确认删除此文章?', 'Warning', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
  ).then(() => {
    reqCommonFeedback(deleteBatch([id]), () => {
      ElMessage({type: 'success', message: '删除成功'});
      loadTableData();
    });
  });
}

const handleSelectionChange = (arr: any[]) => {
  multipleSelection.value = arr;
}

const onDeleteBatch = () => {
  let ids: string[] = [];
  multipleSelection.value.map((item, index) => {
    ids.push(item.id);
  });
  ElMessageBox.confirm('确认删除所选择的文章?', 'Warning', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
  ).then(() => {
    reqCommonFeedback(deleteBatch(ids), () => {
      ElMessage({type: 'success', message: '删除成功'});
      loadTableData();
    });
  });
}

</script>

<style scoped></style>