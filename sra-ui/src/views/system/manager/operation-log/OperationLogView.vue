<template>
  <sra-simple-table class="main-bg" v-loading="loading"
                    :is-hide-edit-button="true" :pageVo="pageVo" :pageParam="pageParam"
                    @remove="remove" @enter-search="initTable" @refresh="refresh" @remove-batch="removeBatch">
    <!-- 表格列名 -->
    <template v-slot:column>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="logNumber" label="日志编号"/>
      <el-table-column prop="operatorName" label="操作人"/>
      <el-table-column prop="ipAddress" label="IP地址"/>
      <el-table-column prop="requestWay" label="请求方式">
        <template #default="scope">
          <span v-html="getRequestWay(scope.row.requestWay)"></span>
        </template>
      </el-table-column>
      <el-table-column prop="operationStatus" label="操作状态">
        <template #default="scope">
          <span v-html="getOperationStatusText(scope.row.operationStatus)"></span>
        </template>
      </el-table-column>
      <el-table-column prop="logType" label="日志类型">
        <template #default="scope">
          <span v-html="getLogTypeText(scope.row.logType)"></span>
        </template>
      </el-table-column>
      <el-table-column prop="operationTime" label="操作时间"/>
    </template>
  </sra-simple-table>
</template>

<script setup lang="ts">
import {onMounted, ref, watch} from "vue";
import SraSimpleTable from "@/components/table/simple-table/SraSimpleTable.vue";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import operationLogApi from "@/api/system/operation-log-api";
import {getOperationStatusText, getLogTypeText, getRequestWay} from "@/utils/format-util";

// 分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchKey: ''});
// api返回的分页数据
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});
// 加载进度
const loading = ref<boolean>(true);

// 初始化数据
onMounted(() => {
  initTable();
});

// 监听当前页的变化
watch(
    () => [pageParam.value.pageNo, pageParam.value.pageSize], () => {
      initTable();
    }
)

/**
 * 刷新
 */
const refresh = (): void => {
  pageParam.value.pageNo = 1;
  pageParam.value.pageSize = 15;
  pageParam.value.searchKey = '';
  setTimeout(initTable, 200);
}

/**
 * 单个移除
 * @param row
 */
const remove = (row: any) => removeBatch([row.id]);

/**
 * 初始化数据
 */
const initTable = () => {
  // 渲染数据
  if (!loading.value) {
    loading.value = true;
  }
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    operationLogVO: {
      logNumber: parseInt(pageParam.value.searchKey) ? pageParam.value.searchKey : null,
      operatorName: pageParam.value.searchKey
    }
  };
  reqCommonFeedback(operationLogApi.listByPage(param), (data: any) => {
    pageVo.value.records = data.rows;
    pageVo.value.total = data.recordCount;
    loading.value = false;
  });
}

/**
 * 批量删除
 * @param ids
 */
const removeBatch = (ids: string[]) => {
  reqSuccessFeedback(operationLogApi.deleteBatch(ids), '删除成功', () => {
    initTable();
  });
}
</script>

<style scoped></style>