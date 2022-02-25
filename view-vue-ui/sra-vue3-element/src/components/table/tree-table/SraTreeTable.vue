<template>
  <base-control-pane ref='baseControlPaneRef' :page-param="pageParam" :page-vo="pageVo" :edit-form="editForm"
                     :selection-ids="selectionIds" :page-sizes="pageSizes"
                     @remove-batch="removeBatch" @enter-search="enterSearch"
                     @dialog-confirm="dialogConfirm">
    <template v-slot:default>
      <el-table :data="pageVo.records" row-key="id" stripe default-expand-all
                @select="selectChange" @select-all="selectChange">
        <!-- 表格插槽 -->
        <slot name="default"></slot>
        <!-- 单行操作 -->
        <el-table-column fixed="right" label="操作" width="120">
          <template #default>
            <el-button type="text" size="small" @click="edit('id::')">编辑</el-button>
            <el-button type="text" size="small" @click="remove('id::')">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  </base-control-pane>
</template>

<script lang="ts" setup>
import BaseControlPane from "../base/BaseControlPane.vue";
import {onMounted, ref} from "vue";

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

type BaseControlPaneInstance = InstanceType<typeof BaseControlPane>
const baseControlPaneRef = ref<BaseControlPaneInstance>();
onMounted(() => {
})

const edit = (v: string) => {
  baseControlPaneRef.value.edit();
  emit('edit', v);
};
const remove = (v: string) => {
  baseControlPaneRef.value.remove().then(() => {
    emit('remove', v);
  });
};
const removeBatch = (v: string[]) => emit('remove-batch', v);
const enterSearch = (v: string) => emit('enter-search', v);
const dialogConfirm = () => emit('dialog-confirm');

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