<template>
  <table-manage>
    <!-- 表格操作 -->
    <template #search>
      <el-input style="width: 200px;margin-right: 12px" placeholder="回车搜索" :prefix-icon="Search"
                v-model:model-value="pageParam.searchKey" @keypress.enter="$emit('enter-search')"/>
      <el-button  @click="$emit('refresh')">
        <el-space>
          <el-icon>
            <refresh/>
          </el-icon>
          刷新
        </el-space>
      </el-button>
    </template>
    <template #operate>
      <el-button v-if="!isHideEditButton" type="primary" @click="add">{{`添加${title}`}}</el-button>
      <el-button type="danger" @click="removeBatch">批量删除</el-button>
    </template>

    <!-- 表格视图 -->
    <el-table :data="pageVo.records" stripe style="width: 100%" @select="selectChange" @select-all="selectChange">
      <!-- 动态字段 -->
      <slot name="column"></slot>
      <!-- 单行操作 -->
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button v-if="!isHideEditButton" type="text" size="small" @click="edit(scope.row)">编辑</el-button>
          <el-button link type="danger" size="small" @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <template #page>
      <el-pagination style="margin-top: 1em" background layout="total, sizes, prev, pager, next, jumper"
                     v-model:page-size="pageParam.pageSize" v-model:current-page="pageParam.pageNo" :total="pageVo.total"
                     :page-sizes="pageSizes">
      </el-pagination>
    </template>

    <!-- 编辑对话框 -->
    <template #form>
      <el-dialog v-model="dialogFormVisible" :title="dialogTitle">
        <el-form ref="sstFormRef" :model="editForm" label-width="120px" :rules="rules">
          <slot name="edit"></slot>
        </el-form>
        <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogConfirm(sstFormRef)">确认</el-button>
        </span>
        </template>
      </el-dialog>
    </template>
  </table-manage>
</template>

<script lang="ts" setup>
import {ref} from "vue";
import {ElForm, ElMessage, ElMessageBox} from "element-plus";
import {Search} from "@element-plus/icons-vue";
import TableManage from "@/components/container/TableManage.vue";

type FormInstance = InstanceType<typeof ElForm>
const sstFormRef = ref<FormInstance>();
const dialogTitle = ref<string>('');
const dialogFormVisible = ref<boolean>(false);

// 已选id集合
const selectionIds = ref<any[]>([]);

// 定义组件参数
const props = withDefaults(defineProps<{
  title?: string,
  // 表单数据
  editForm?: any,
  // 表单规则
  rules?: any,
  // 总条数
  pageVo: PageVO,
  // 分页参数
  pageParam: PageParam,
  // 每页条数
  pageSizes?: number[],
  // 是否隐藏编辑按钮
  isHideEditButton?: boolean
}>(), {
  title: '',
  rules: {},
  editForm: {},
  pageSizes: () => [15, 25, 35, 45, 55],
  isHideEditButton: false
});

// 定义组件方法
const emit = defineEmits<{
  (e: 'edit', v: string): void
  (e: 'remove', v: string): void
  (e: 'remove-batch', v: string[]): void
  (e: 'enter-search', v: string): void
  (e: 'dialog-confirm', v: FormInstance, f: Function): void
  (e: 'add'): void
  (e: 'refresh'): void
}>();

/**
 * 新增
 */
const add = (): void => {
  dialogFormVisible.value = true;
  dialogTitle.value = '新增';
  emit('add');
}

/**
 * 编辑单行
 */
const edit = (v: any) => {
  dialogFormVisible.value = true;
  dialogTitle.value = '编辑';
  emit('edit', v);
};

/**
 * 移除单行
 */
const remove = (v: any) => {
  ElMessageBox.confirm('确定删除此行？', 'Warning', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }
  ).then(() => {
    emit('remove', v);
  });
};

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
  ElMessageBox.confirm('确定删除已选择行？', 'Warning', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }
  ).then(() => {
    let idList: string[] = [];
    selectionIds.value.forEach((item: any) => idList.push(item.id));
    emit('remove-batch', idList);
  });
}

/**
 * 对话框确认操作
 */
const dialogConfirm = (formEl: FormInstance) => {
  emit('dialog-confirm', formEl, () => dialogFormVisible.value = false);
}

/**
 * 选项发生改变
 * @param val 已选行
 */
const selectChange = (val: any[]) => {
  selectionIds.value = val;
}
</script>

<style scoped src="./css/SraSimpleTable.css"></style>