<template>
  <div>
    <!-- 表格操作 -->
    <el-row style="margin-bottom: 1em">
      <el-col :span="20">
        <el-button type="primary" @click="add">添加</el-button>
        <el-button type="danger" @click="removeBatch">删除</el-button>
      </el-col>
      <el-col :span="4" style="text-align: right">
        <el-input placeholder="回车搜索" :prefix-icon="Search" v-model="pageParam.searchKey" @keypress.enter="enterSearch"/>
      </el-col>
    </el-row>

    <!-- 表格视图 -->
    <slot name="default"></slot>

    <!-- 分页 -->
    <el-pagination style="margin-top: 1em" background layout="total, sizes, prev, pager, next, jumper"
                   v-model:page-size="pageParam.pageSize" v-model:current-page="pageParam.pageNum" :total="pageVo.total"
                   :page-sizes="pageSizes">
    </el-pagination>

    <!-- 编辑对话框 -->
    <el-dialog v-model="dialogFormVisible" :title="dialogTitle">
      <el-form ref="formRef" :model="editForm" :rules="rules">
        <slot name="edit"></slot>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogConfirm(formRef)">确认</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import {ElForm, ElMessage, ElMessageBox} from "element-plus";
import {Search} from "@element-plus/icons-vue";
import {onMounted, ref, toRefs} from "vue";

type FormInstance = InstanceType<typeof ElForm>
const formRef = ref<FormInstance>();

// 编辑对话框显示&隐藏
const dialogFormVisible = ref<boolean>(false);
// 对话框标题
const dialogTitle = ref<string>('');
// 搜索值
const searchKey = ref<string>('');

// 定义组件参数
const props = withDefaults(defineProps<{
  // 表单数据
  editForm: object,
  // 表单规则
  rules?: object,
  // 总条数
  pageVo: PageVO,
  // 分页参数
  pageParam: PageParam,
  // 每页条数
  pageSizes?: number[],
  // 已选id集合
  selectionIds: []
}>(), {
  rules: {},
  pageSizes: () => [15, 25, 35, 45, 55],
});

// 定义组件方法
const emit = defineEmits<{
  (e: 'remove-batch', selectionIds: string[]): void
  (e: 'enter-search', searchKey: string): void
  (e: 'dialog-confirm'): void
}>();

/**
 * 新增
 */
const add = () => {
  dialogFormVisible.value = true;
  dialogTitle.value = '新增';
}

/**
 * 编辑单行
 */
const edit = () => {
  dialogFormVisible.value = true;
  dialogTitle.value = '编辑';
}

/**
 * 移除单行
 */
const remove = async () => {
  return await ElMessageBox.confirm(
      '确定删除此行?',
      'Warning',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true,
      }
  );
}

/**
 * 批量移除
 */
const removeBatch = () => {
  let {selectionIds} = toRefs(props);
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
 * 回车搜索
 */
const enterSearch = () => {
  emit('enter-search', searchKey.value);
}

/**
 * 对话框确认操作
 */
const dialogConfirm = (formEl: FormInstance | undefined) => {
  emit('dialog-confirm', formEl);
}

// 暴露组件属性及方法
defineExpose({
  edit, remove
});
</script>