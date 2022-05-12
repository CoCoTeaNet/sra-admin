<template>
  <div class="main-bg">
    <!-- 查询条件 -->
    <el-input v-model="pageParam.searchKey" placeholder="请输入表名" @keydown.enter="initTableList">
      <template #append>
        <el-button :icon="Search"/>
      </template>
    </el-input>
    <!-- 表格 -->
    <el-table :data="pageVo.records" v-loading="loading">
      <el-table-column prop="tableName" label="表名称"/>
      <el-table-column prop="tableCollation" label="字符集"/>
      <el-table-column prop="tableComment" label="表描述"/>
      <el-table-column fixed="right" label="操作">
        <template #default="scope">
          <el-button type="text" size="small" @click="preview(scope.row)">预览代码</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <el-pagination :hide-on-single-page="true"
                   background layout="prev, pager, next"
                   :total="pageVo.total"
                   v-model:current-page="pageParam.pageNo"
                   v-model:page-size="pageParam.pageSize"
    />
    <!-- 代码对话框 -->
    <el-dialog title="生成实体类" v-model="dialogVisible" width="80%;" style="height: 75%;text-align: center" @open="">
      <el-scrollbar style="width: 100%;height: 640px;overflow: auto">
        <highlightjs :code="codeSrc" language="java" style="border-radius: 3px;"></highlightjs>
      </el-scrollbar>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import {nextTick, onMounted, ref, watch} from 'vue';
import {findTablesByPage, getByTableName} from "@/api/system/code-generator-api";
import {reqCommonFeedback} from "@/api/ApiFeedback";
import {Search} from "@element-plus/icons-vue";

//表格加载宏
const loading = ref<boolean>(false);
//对话框是否显示
const dialogVisible = ref<boolean>(false);
//分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchKey: ''});
//分页返回值
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});
//代码页面
const codeSrc = ref<string>('');

onMounted(() => {
  initTableList();
});

// 监听当前页的变化
watch(
    () => [pageParam.value.pageNo, pageParam.value.pageSize], () => {
      initTableList();
    }
)

/**
 * 获取表列表
 */
const initTableList = () => {
  loading.value = true;
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    tableVO: {tableName: pageParam.value.searchKey}
  }
  reqCommonFeedback(findTablesByPage(param), (res: any) => {
    loading.value = false;
    pageVo.value.records = res.rows;
    pageVo.value.total = res.recordCount;
  });
}

/**
 * 预览代码生成
 * @param row
 */
const preview = (row: any) => {
  dialogVisible.value = true;
  reqCommonFeedback(getByTableName(row.tableName), (data: any) => {
    nextTick(() => {
      codeSrc.value = data;
    });
  });
}
</script>
