<template>
  <table-manage>
    <template #search>
      <el-form-item label="数据库">
        <el-input placeholder="默认数据源" v-model="pageParam.searchObject.dbName" @keydown.enter="initTableList"></el-input>
      </el-form-item>
      <el-form-item label="表名">
        <el-input v-model="pageParam.searchObject.tableName" placeholder="请输入表名" @keydown.enter="initTableList"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="initTableList">搜索</el-button>
        <el-button @click="onReset">重置</el-button>
      </el-form-item>
    </template>

    <template #default>
      <el-table :data="pageVo.records" v-loading="loading">
        <el-table-column prop="tableName" label="表名称"/>
        <el-table-column prop="tableCollation" label="字符集"/>
        <el-table-column prop="tableComment" label="表描述"/>
        <el-table-column fixed="right" label="操作">
          <template #default="scope">
            <el-button plain size="small" @click="preview(scope.row, 0)">JAVA实体</el-button>
            <el-button plain size="small" @click="preview(scope.row, 1)">TS模型</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>

    <template #page>
      <el-pagination background layout="prev, pager, next"
                     :total="pageVo.total"
                     v-model:current-page="pageParam.pageNo"
                     v-model:page-size="pageParam.pageSize"
      />
    </template>

    <template #form>
      <el-dialog v-model="dialogVisible" title="预览代码">
        <div v-if="dialogVisible">
          <el-scrollbar style="width: 100%;height: 640px;overflow: auto">
            <highlightjs :code="codeSrc" :language="language" style="border-radius: 3px;"></highlightjs>
          </el-scrollbar>
        </div>
      </el-dialog>
    </template>
  </table-manage>
</template>

<script setup lang="ts">
import {nextTick, onMounted, ref, watch} from 'vue';
import {findTablesByPage, getByTableName} from "@/api/system/code-generator-api";
import {reqCommonFeedback} from "@/api/ApiFeedback";
import TableManage from "@/components/container/TableManage.vue";

//表格加载宏
const loading = ref<boolean>(false);
//对话框是否显示
const dialogVisible = ref<boolean>(false);
//分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchKey: '', searchObject: {tableName:'',dbName:''}});
//分页返回值
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});
//代码页面
const codeSrc = ref<string>('');
const language = ref<string>('java');

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
    tableVO: pageParam.value.searchObject
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
 * @param type
 */
const preview = (row: any, type: number) => {
  language.value = type === 0 ? 'java' : 'typescript';
  dialogVisible.value = true;
  let param = {tableName: row.tableName, dbName: pageParam.value.searchObject.dbName, type: type};
  reqCommonFeedback(getByTableName(param), (data: any) => {
    nextTick(() => {
      codeSrc.value = data;
    });
  });
}

const onReset = () => {
  pageParam.value.searchObject = {};
}
</script>
