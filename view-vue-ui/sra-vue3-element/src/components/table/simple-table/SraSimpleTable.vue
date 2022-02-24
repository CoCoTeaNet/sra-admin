<template>
  <div>
    <!-- 表格操作 -->
    <el-row>
      <el-col :span="20">
        <el-button type="primary" @click="add">添加</el-button>
        <el-button type="danger" @click="removeBatch">删除</el-button>
      </el-col>
      <el-col :span="4" style="text-align: right">
        <el-input placeholder="回车搜索" :prefix-icon="Search" v-model="pageParam.searchKey" @keypress.enter="enterSearch"/>
      </el-col>
    </el-row>
    <!-- 表格视图 -->
    <el-table :data="pageVo.records" stripe style="width: 100%" @select="selectChange" @select-all="selectChange">
      <!-- 动态字段 -->
      <slot name="column"></slot>
      <!-- 单行操作 -->
      <el-table-column fixed="right" label="操作" width="120">
        <template #default>
          <el-button type="text" size="small" @click="edit('id::')">编辑</el-button>
          <el-button type="text" size="small" @click="remove('id::')">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination style="margin-top: 1em" background layout="total, sizes, prev, pager, next, jumper"
                   popper-class="asdas页"
                   v-model:page-size="pageParam.pageSize" v-model:current-page="pageParam.pageNum" :total="pageVo.total"
                   :page-sizes="pageSizes">
    </el-pagination>
    <!-- 编辑对话框 -->
    <el-dialog v-model="dialogFormVisible" :title="dialogTitle">
      <el-form :model="editForm">
        <slot name="edit"></slot>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogConfirm">确认</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import {Search} from "@element-plus/icons-vue";
import {onMounted, ref, toRefs} from "vue";
import {ElMessageBox, ElMessage} from "element-plus";

// 编辑对话框显示&隐藏
const dialogFormVisible = ref<boolean>(false);
// 对话框标题
const dialogTitle = ref<string>('');
// 搜索值
const searchKey = ref<string>('');
// 已选id集合
const selectionIds = ref([]);

// 定义组件参数
const props = withDefaults(defineProps<{
  // 表单数据
  editForm: object,
  // 总条数
  pageVo: PageVO,
  // 分页参数
  pageParam: PageParam,
  // 每页条数
  pageSizes?: number[]
}>(), {
  pageSizes: () => [15, 25, 35, 45, 55],
});

// 定义组件方法
const emit = defineEmits<{
  (e: 'edit', id: string): void
  (e: 'remove', id: string): void
  (e: 'remove-batch', selectionIds: string[]): void
  (e: 'enter-search', searchKey: string): void
  (e: 'dialog-confirm'): void
}>();

onMounted(() => {
  let {pageParam, pageVo, pageSizes} = toRefs(props);
  console.log(pageParam.value)
  console.log(pageVo.value)
  console.log(pageSizes.value)
})

/**
 * 新增
 */
const add = () => {
  dialogFormVisible.value = true;
  dialogTitle.value = '新增';
}

/**
 * 编辑单行
 * @param id
 */
const edit = (id: string) => {
  dialogFormVisible.value = true;
  dialogTitle.value = '编辑';
  emit('edit', id);
}

/**
 * 移除单行
 * @param id
 */
const remove = (id: string) => {
  ElMessageBox.confirm(
      '确定删除此行?',
      'Warning',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true,
      }
  ).then(() => {
    emit('remove', id);
  });
}

/**
 * 批量移除
 */
const removeBatch = () => {
  if (!(selectionIds.value.length > 0)) {
    ElMessage({
      message: '请选择删除项！',
      type: 'warning',
    })
    return;
  }
  ElMessageBox.confirm(
      '确定删除已选择行?',
      'Warning',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true,
      }
  ).then(() => {
    emit('remove-batch', selectionIds.value);
  });
}

/**
 * 选项发生改变
 * @param val 已选行
 */
const selectChange = (val: any[]) => {
  selectionIds.value = val;
  console.log(val)
}

/**
 * 回车搜索
 */
const enterSearch = () => {
  emit('enter-search', searchKey.value);
}

/**
 * 对话框确认操作
 */
const dialogConfirm = () => {
  emit('dialog-confirm');
}

</script>

<style scoped src="./css/SraSimpleTable.css"></style>