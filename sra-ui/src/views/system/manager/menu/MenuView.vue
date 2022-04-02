<template>
  <sra-tree-table v-loading="loading"
                  :editForm="editForm.data" :pageVo="pageVo" :rules="rules" :page-param="pageParam"
                  @dialog-confirm="doUpdate" @remove-batch="removeBatch" @edit="edit" @remove="remove" @add="initAdd"
                  @enter-search="initTable" @refresh="refresh">

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
          <div v-html="getIsSomethingText(scope.row.isExternalLink)"></div>
        </template>
      </el-table-column>
      <el-table-column prop="menuStatus" label="菜单状态">
        <template #default="scope">
          <div v-html="getMenuStatusText(scope.row.menuStatus)"></div>
        </template>
      </el-table-column>
    </template>

    <!-- 新增&编辑表单 -->
    <template v-slot:edit>
      <el-form-item prop="menuName" label="菜单名称">
        <el-input v-model="editForm.data.menuName"></el-input>
      </el-form-item>
      <el-form-item prop="menuType" label="菜单类型">
        <el-radio-group v-model="editForm.data.menuType">
          <el-radio label="0">目录</el-radio>
          <el-radio label="1">菜单</el-radio>
          <el-radio label="2">按钮</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="routerPath" label="路由地址">
        <el-input v-model="editForm.data.routerPath"></el-input>
      </el-form-item>
      <el-form-item prop="isExternalLink" label="是否外链">
        <el-radio-group v-model="editForm.data.isExternalLink">
          <el-radio label="0">是</el-radio>
          <el-radio label="1">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="sort" label="显示顺序">
        <el-input v-model="editForm.data.sort" type="number"></el-input>
      </el-form-item>
      <el-form-item label="菜单图标">
        <icon-selection v-model="editForm.data.iconPath"/>
      </el-form-item>
      <el-form-item label="上级菜单">
        <el-cascader v-model="editForm.data.parentId" placeholder="选择节点"
                     :props="defaultProps" :options="pageVo.records" :show-all-levels="false"
                     @change="handleChange">
        </el-cascader>
      </el-form-item>
      <el-form-item prop="menuStatus" label="菜单状态">
        <el-radio-group v-model="editForm.data.menuStatus">
          <el-radio label="0">显示并启用</el-radio>
          <el-radio label="1">隐藏并关闭</el-radio>
          <el-radio label="2">显示不启用</el-radio>
          <el-radio label="3">隐藏但启用</el-radio>
        </el-radio-group>
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
import {getMenuTypeText, getIsSomethingText, getMenuStatusText} from "@/utils/format-util";

const initData = {
  id: '',
  menuName: '',
  menuType: '0',
  iconPath: '',
  routerPath: '',
  isExternalLink: '1',
  menuStatus: '0',
  parentId: '',
  sort: 0,
  isMenu: '0'
}

// 级联选择框配置
const defaultProps = {
  value: 'id',
  label: 'menuName',
  children: 'children',
  checkStrictly: true
}

// 表单参数
const editForm = reactive<any>({data: initData});

// 加载进度
const loading = ref<boolean>(true);

// 表单校验规则
const rules = reactive({
  menuName: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  menuType: [{required: true, message: '请选择菜单编号', trigger: 'blur'}],
  menuStatus: [{required: true, message: '请选择菜单状态', trigger: 'blur'}],
  routerPath: [{required: true, min: 2, max: 255, message: '长度限制2~255', trigger: 'blur'}],
  isExternalLink: [{required: true, message: '请选择链接类型', trigger: 'blur'}],
});

// api分页请求参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 1000, searchKey: ''});

// api返回的分页数据
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});

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
    editForm.data = row;
  }
}

/**
 * 初始化新增数据
 */
const initAdd = (): void => {
  editForm.data = initData;
}

/**
 * 删除行
 * @param row
 */
const remove = (row: any): void => {
  removeBatch([row.id]);
}

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
 * 渲染表格数据
 */
const initTable = (): void => {
  if (!loading.value) {
    loading.value = true;
  }
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    menuVO: {isMenu: 0, menuName: pageParam.value.searchKey}
  };
  reqCommonFeedback(listByTree(param), (data: any) => {
    pageVo.value.records = data.rows;
    pageVo.value.total = data.recordCount;
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
      if (!editForm.data.id) {
        // 新增
        reqSuccessFeedback(add(editForm.data), '新增成功', () => {
          initTable();
          callback();
        });
      } else {
        // 修改
        reqSuccessFeedback(update(editForm.data), '修改成功', () => {
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
  editForm.data.parentId = data[data.length - 1] ? data[data.length - 1] : 0;
}
</script>

<style scoped></style>