#### 例子
```vue
<template>
  <sra-simple-table :editForm="editFrom" :pageVo="pageVo" :pageParam="pageParam"
                    @edit="edit" @remove="remove" @enter-search="initTable"
                    @dialog-confirm="doUpdate" @remove-batch="removeBatch">
    <template v-slot:column>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="date" label="Date" width="180"/>
      <el-table-column prop="name" label="Name" width="180"/>
      <el-table-column prop="address" label="Address"/>
    </template>
    <template v-slot:edit>
      表单
    </template>
  </sra-simple-table>
</template>

<script setup lang="ts">
import SraSimpleTable from "@/components/table/simple-table/SraSimpleTable.vue";
import {onMounted, reactive, ref, watch} from "vue";

const td = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
];

// 表格数据
const tableData = ref([]);
// 表单参数
const editFrom = reactive({});
// 分页参数
const pageParam = ref<PageParam>({pageNum: 1, pageSize: 15, searchKey: ''});
// api返回的分页数据
const pageVo = ref<PageVO>({pageNum: 0, pageSize: 0, total: 0, records: []});

// 初始化数据
onMounted(() => {
  pageVo.value.records = td;
})

// 监听当前页的变化
watch(
    () => pageParam.value.pageNum,
    (current, preview) => {
      console.log(current)
    }
)

const edit = (id: string) => {
  // todo 获取行详细
  console.log(id)
}

const remove = (id: string) => {
  // todo 调用删除行接口
  console.log(id)
}

const currentChange = (pageIndex: number) => {
  // todo 换一页
  console.log(pageIndex)
}

const initTable = () => {
  // todo 渲染数据
  console.log(pageParam.value)
}

const doUpdate = () => {
  // todo 更新操作
}

const removeBatch = (ids: string[]) => {
  // todo 批量删除
  console.log(ids);
}

</script>
```