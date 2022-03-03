<template>
  <base-control-pane ref='baseControlPaneRef'
                     :page-param="pageParam" :page-vo="pageVo" :editForm="editForm" :selection-ids="selectionIds"
                     :page-sizes="pageSizes" :rules="rules"
                     @remove-batch="removeBatch" @enter-search="enterSearch" @dialog-confirm="dialogConfirm">
    <template v-slot:default>
      <el-table :data="pageVo.records" row-key="id" stripe default-expand-all
                @select="selectChange" @select-all="selectChange">
        <!-- 表格插槽 -->
        <slot name="default"></slot>
        <!-- 单行操作 -->
        <el-table-column fixed="right" label="操作" width="120">
          <template #default="scope">
            <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="remove(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>

    <template v-slot:edit>
      <slot name="edit"></slot>
    </template>
  </base-control-pane>
</template>

<script lang="ts" setup>
import BaseControlPane from "../base/BaseControlPane.vue";
import {ref} from "vue";

// 已选id集合
const selectionIds = ref([]);

// 定义组件参数
const props = withDefaults(defineProps<{
  // 表单数据
  editForm: object,
  //表单规则
  rules?: object,
  // 总条数
  pageVo: PageVO,
  // 分页参数
  pageParam?: PageParam,
  // 每页条数
  pageSizes?: number[]
}>(), {
  rules: {},
  pageParam: {pageNum: 1, pageSize: 10, searchKey: ''},
  pageSizes: () => [15, 25, 35, 45, 55],
});

// 定义组件方法
const emit = defineEmits<{
  (e: 'edit', id: string): void
  (e: 'remove', id: string): void
  (e: 'remove-batch', selectionIds: string[]): void
  (e: 'enter-search', searchKey: string): void
  (e: 'dialog-confirm'): void,
  (e: 'update:editForm', v: any): void
}>();

type BaseControlPaneInstance = InstanceType<typeof BaseControlPane>
const baseControlPaneRef = ref<BaseControlPaneInstance>();

const edit = (v: any) => {
  baseControlPaneRef.value.edit();
  emit('edit', v);
};
const remove = (v: any) => {
  baseControlPaneRef.value.remove().then(() => {
    emit('remove', v);
  });
};
const removeBatch = (v: string[]) => emit('remove-batch', v);
const enterSearch = (v: string) => emit('enter-search', v);
const dialogConfirm = (formEl: FormInstance | undefined) => emit('dialog-confirm', formEl);

/**
 * 选项发生改变
 * @param val 已选行
 */
const selectChange = (val: any[]) => {
  selectionIds.value = val;
  console.log(val)
}
</script>

<style scoped src="./css/SraTreeTable.css"></style>