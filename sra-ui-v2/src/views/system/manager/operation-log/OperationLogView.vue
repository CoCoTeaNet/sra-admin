<template>
  <table-manage>
    <template #search>
      <n-form-item label="日志编号">
        <n-input placeholder="日志编号" v-model:value="pageParam.searchObject.logNumber"/>
      </n-form-item>
      <n-form-item label="操作人员">
        <n-input placeholder="操作人员" v-model:value="pageParam.searchObject.operatorName"/>
      </n-form-item>

      <n-form-item>
        <n-space>
          <n-button type="primary" @click="loadTableData">搜索</n-button>
          <n-button @click="onReset">重置</n-button>
        </n-space>
      </n-form-item>
    </template>

    <template #default>
      <n-data-table
        :data="pageVo.records"
        :columns="columns"
        :loading="loading"
        :scroll-x="1800"
      />
    </template>

    <template #page>
      <n-pagination :item-count="pageVo.total"
                    :page="pageParam.pageNo"
                    :page-size="pageParam.pageSize"
                    :page-sizes=[5,10,15]
                    :on-update:page="onPageChange"
                    :on-update:page-size="onSizeChange"
                    show-quick-jumper
                    show-size-picker
      />
    </template>
  </table-manage>
</template>

<script setup lang="ts">
import {h, nextTick, onMounted, ref} from "vue";
import {listByPage} from "@/api/system/operation-log-api";
import TableManage from "@/components/TableManage/TableManage.vue";
import {NButton, NTag} from "naive-ui";

// 分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchObject: {}});
// api返回的分页数据
const pageVo = ref<PageVO>({total: 0, records: []});
// 加载进度
const loading = ref<boolean>(true);
const getLogType: any = (status: number, type: number) => {
  let obj = {color: '', text: ''};
  switch (status) {
    case 0:
      obj = {color: 'success', text: '登录日志'};
      break;
    case 1:
      obj = {color: 'warning', text: '操作日志'};
      break;
  }
  if (type === 0) {
    return obj.color;
  } else {
    return obj.text;
  }
}
const getOperationStatus: any = (status: number, type: number) => {
  let obj = {color: '', text: ''};
  switch (status) {
    case 0:
      obj = {color: 'danger', text: '异常'};
      break;
    case 1:
      obj = {color: 'success', text: '成功'};
      break;
  }
  if (type === 0) {
    return obj.color;
  } else {
    return obj.text;
  }
}

const columns = [
  {
    title: '日志编号',
    key: 'logNumber',
  },
  {
    title: '操作人',
    key: 'operatorName',
  },
  {
    title: 'IP地址',
    key: 'ipAddress',
  },
  {
    title: '请求方式',
    key: 'requestWay',
  },
  {
    title: '日志类型',
    key: 'logType',
    render(row) {
      const tagType = getLogType(row.logType, 0);
      const tagName = getLogType(row.logType, 1);
      return h(
        NTag,
        {
          type: tagType
        },
        tagName
      )
    },
  },
  {
    title: '操作状态',
    key: 'operationStatus',
    render(row) {
      const tagType = getOperationStatus(row.operationStatus, 0);
      const tagName = getOperationStatus(row.operationStatus, 1);
      return h(
        NTag,
        {
          type: tagType
        },
        tagName
      )
    },
  },
];

// 初始化数据
onMounted(() => {
  loadTableData();
});

const onReset = (): void => {
  pageParam.value.searchObject = {
    logNumber: '',
    operatorName: '',
  };
}

const loadTableData = () => {
  if (!loading.value) loading.value = true;
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    operationLogVO: pageParam.value.searchObject
  };
  listByPage(param).then(data => {
    pageVo.value.records = data.rows;
    pageVo.value.total = data.recordCount;
    loading.value = false;
  });
}

const onPageChange = (currentPage: number) => {
  pageParam.value.pageNo = currentPage;
  nextTick(() => loadTableData());
}

const onSizeChange = (size: number) => {
  pageParam.value.pageSize = size;
  nextTick(() => loadTableData());
}
</script>

<style scoped></style>
