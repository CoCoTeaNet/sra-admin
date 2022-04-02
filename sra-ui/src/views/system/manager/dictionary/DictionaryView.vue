<template>
  <sra-tree-table v-loading="loading"
                  :editForm="editForm.data" :pageVo="pageVo" :rules="rules" :page-param="pageParam"
                  @dialog-confirm="doUpdate" @remove-batch="removeBatch" @edit="edit" @remove="remove" @add="initAdd"
                  @enter-search="initTable" @refresh="refresh">
    <!-- 表格列配置 -->
    <template v-slot:default>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="dictionaryName" label="名称" sortable/>
      <el-table-column prop="remark" label="备注"/>
      <el-table-column prop="enableStatus" label="是否启用">
        <template #default="scope">
          <div v-html="getIsSomethingText(scope.row.enableStatus)"></div>
        </template>
      </el-table-column>
      <el-table-column prop="sort" label="排序号" sortable/>
    </template>

    <!-- 新增&编辑表单 -->
    <template v-slot:edit>
      <el-form-item prop="dictionaryName" label="菜单名称">
        <el-input v-model="editForm.data.dictionaryName"></el-input>
      </el-form-item>
      <el-form-item prop="remark" label="备注">
        <el-input v-model="editForm.data.remark"></el-input>
      </el-form-item>
      <el-form-item prop="enableStatus" label="是否启用">
        <el-radio-group v-model="editForm.data.enableStatus">
          <el-radio label="0">是</el-radio>
          <el-radio label="1">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="sort" label="显示顺序">
        <el-input v-model="editForm.data.sort" type="number"></el-input>
      </el-form-item>
      <el-form-item label="上级">
        <el-cascader v-model="editForm.data.parentId" placeholder="选择节点"
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
import {listByTree, add, deleteBatch, update} from "@/api/system/dictionary-api";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import {getIsSomethingText} from "@/utils/format-util";

const initForm = {
  id: '',
  dictionaryName: '',
  remark: '',
  parentId: '',
  sort: 1,
  enableStatus: '0'
}

// 级联选择框配置
const defaultProps = {
  value: 'id',
  label: 'dictionaryName',
  children: 'children',
  checkStrictly: true
}

// 表单参数
const editForm = reactive<any>({
  data: initForm
});

// 加载进度
const loading = ref<boolean>(true);

// 表单校验规则
const rules = reactive({
  dictionaryName: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  enableStatus: [{message: '请选择菜单编号', trigger: 'blur'}],
  remark: [{min: 2, max: 255, message: '长度限制2~255', trigger: 'blur'}]
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
  editForm.data = initForm;
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
    dictionaryVO: {dictionaryName: pageParam.value.searchKey}
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