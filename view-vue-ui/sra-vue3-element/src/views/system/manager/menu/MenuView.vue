<template>
  <sra-tree-table :editForm="editForm" :pageVo="pageVo" :rules="rules" v-loading="loading"
                  @dialog-confirm="doUpdate" @remove-batch="removeBatch" @edit="edit" @remove="remove" @add="initAdd"
                  @enter-search="initTable">
    <!-- 表格列配置 -->
    <template v-slot:default>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="menuName" label="名称" sortable/>
      <el-table-column prop="iconPath" label="图标">
        <template #default="scope">
          <el-icon>
            <component :is="scope.row.iconPath"></component>
          </el-icon>
        </template>
      </el-table-column>
      <el-table-column prop="menuType" label="类型">
        <template #default="scope">
          <span>{{ getMenuTypeText(scope.row.menuType) }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="routerPath" label="路由地址"/>
      <el-table-column prop="isExternalLink" label="是否外链">
        <template #default="scope">
          <span>{{ getIsSomethingText(scope.row.isExternalLink) }}</span>
        </template>
      </el-table-column>
    </template>
    <!-- 新增&编辑表单 -->
    <template v-slot:edit>
      <el-form-item prop="menuName" label="菜单名称">
        <el-input v-model="editForm.menuName"></el-input>
      </el-form-item>
      <el-form-item prop="menuType" label="菜单类型">
        <el-radio-group v-model="editForm.menuType">
          <el-radio label="0">目录</el-radio>
          <el-radio label="1">菜单</el-radio>
          <el-radio label="2">按钮</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="routerPath" label="路由地址">
        <el-input v-model="editForm.routerPath"></el-input>
      </el-form-item>
      <el-form-item prop="isExternalLink" label="是否外链">
        <el-radio-group v-model="editForm.isExternalLink">
          <el-radio label="0">是</el-radio>
          <el-radio label="1">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="菜单图标">
        <icon-selection v-model="editForm.iconPath"/>
      </el-form-item>
      <el-form-item label="上级菜单">
        <el-cascader v-model="editForm.parentId" placeholder="选择节点"
                     :props="defaultProps" :options="pageVo.records" :show-all-levels="false"
                     @change="handleChange">
        </el-cascader>
      </el-form-item>
    </template>
  </sra-tree-table>
</template>

<script setup lang="ts">
import {onMounted, reactive, ref} from "vue";
import SraTreeTable from "@/components/table/tree-table/SraTreeTable.vue";
import IconSelection from "@/components/selection/IconSelection.vue";
import {listByTree, add, deleteBatch, update} from "@/api/system/menu-api";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import {getMenuTypeText, getIsSomethingText} from "@/utils/format-util";

// 级联选择框配置
const defaultProps = {
  value: 'id',
  label: 'menuName',
  children: 'children',
  checkStrictly: true
}

// 表单参数
const editForm = reactive<MenuModel>({
  id: '',
  menuName: '',
  menuType: '0',
  iconPath: '',
  routerPath: '',
  isExternalLink: '1',
  parentId: '',
  isMenu: '0',
  children: []
});

// 加载进度
const loading = ref<boolean>(true);

// 表单校验规则
const rules = reactive({
  menuName: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  menuType: [{required: true, message: '请选择菜单编号', trigger: 'blur'}],
  routerPath: [{required: true, min: 2, max: 255, message: '长度限制2~255', trigger: 'blur'}],
  isExternalLink: [{required: true, message: '请选择链接类型', trigger: 'blur'}],
});

// api返回的分页数据
const pageVo = ref<PageVO>({pageNum: 1, pageSize: 10, total: 0, records: []});

// 初始化数据
onMounted(() => {
  initTable();
});

/**
 * 初始化编辑数据
 * @param row
 */
const edit = (row: any): void => {
  if (row) {
    editForm.id = row.id;
    editForm.iconPath = row.iconPath;
    editForm.menuName = row.menuName;
    editForm.routerPath = row.routerPath;
    editForm.menuType = row.menuType;
    editForm.parentId = row.parentId;
    editForm.isExternalLink = row.isExternalLink;
  }
}

/**
 * 初始化新增数据
 */
const initAdd = (): void => {
  editForm.id = '';
  editForm.iconPath = '';
  editForm.menuName = '';
  editForm.routerPath = '';
  editForm.menuType = '1';
  editForm.parentId = '';
  editForm.isExternalLink = '1';
}

/**
 * 删除行
 * @param row
 */
const remove = (row: any): void => {
  removeBatch([row.id]);
}

/**
 * 渲染表格数据
 */
const initTable = (): void => {
  if (!loading.value) {
    loading.value = true;
  }
  reqCommonFeedback(listByTree(0), (data: any) => {
    pageVo.value.records = data;
    loading.value = false;
  });
}

/**
 * 更新操作
 * @param formEl 表单组件对象
 * @param callback 回调函数，调用就会关闭对话框
 */
const doUpdate = (formEl: any, callback: Function): void => {
  formEl.validate((valid: any) => {
    if (valid) {
      if (!editForm.id) {
        // 新增
        reqSuccessFeedback(add(editForm), '新增成功', () => {
          initTable();
          callback();
        });
      } else {
        // 修改
        reqSuccessFeedback(update(editForm), '修改成功', () => {
          initTable();
          callback();
        });
      }
    }
  });
}

/**
 * 批量删除
 * @param ids
 */
const removeBatch = (ids: string[]): void => {
  reqSuccessFeedback(deleteBatch(ids), '删除成功', () => {
    initTable();
  });
}

/**
 * 下拉框级联选项发生改变
 * @param data
 */
const handleChange = (data: any) => {
  editForm.parentId = data[data.length - 1] ? data[data.length - 1] : 0;
}
</script>

<style scoped></style>