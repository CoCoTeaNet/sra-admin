<template>
  <sra-tree-table :editForm="editFrom" :pageVo="pageVo" :pageParam="pageParam"
                  @edit="edit" @remove="remove" @enter-search="initTable"
                  @dialog-confirm="doUpdate" @remove-batch="removeBatch">
    <template v-slot:default>
      <el-table-column prop="date" label="date" sortable width="180" />
      <el-table-column prop="name" label="Name" sortable width="180" />
    </template>
  </sra-tree-table>
</template>

<script setup lang="ts">
import SraTreeTable from "@/components/table/tree-table/SraTreeTable.vue";
import {onMounted, reactive, ref, watch} from "vue";

interface User {
  id: number
  date: string
  name: string
  children?: User[]
}

const tableData: User[] = [
  {
    id: 1,
    date: '2016-05-02',
    name: 'wangxiaohu',
  },
  {
    id: 2,
    date: '2016-05-04',
    name: 'wangxiaohu',
  },
  {
    id: 3,
    date: '2016-05-01',
    name: 'wangxiaohu',
    children: [
      {
        id: 31,
        date: '2016-05-01',
        name: 'wangxiaohu',
      },
      {
        id: 32,
        date: '2016-05-01',
        name: 'wangxiaohu',
      },
    ],
  },
  {
    id: 4,
    date: '2016-05-03',
    name: 'wangxiaohu',
  },
]

// 表单参数
const editFrom = reactive({});
// 分页参数
const pageParam = ref<PageParam>({pageNum: 1, pageSize: 10, searchKey: ''});
// api返回的分页数据
const pageVo = ref<PageVO>({pageNum: 1, pageSize: 4, total: 14, records: []});

// 初始化数据
onMounted(() => {
  pageVo.value.records = tableData;
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

<style scoped></style>