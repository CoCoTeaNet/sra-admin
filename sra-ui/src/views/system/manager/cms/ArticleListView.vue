<template>
  <sra-simple-table class="main-bg" v-loading="loading"
                    :editForm="editForm.data" :pageVo="pageVo" :pageParam="pageParam" :rules="rules"
                    @add="initAdd" @edit="edit" @remove="remove" @enter-search="initTable" @refresh="refresh"
                    @dialog-confirm="doUpdate" @remove-batch="removeBatch">
    <template v-slot:column>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="title" label="标题"/>
      <el-table-column prop="summary" label="简介"/>
      <el-table-column prop="email" label="发布状态">
        <template #default="scope">
          <span v-html="getPublishStatus(scope.row.publishStatus)"></span>
        </template>
      </el-table-column>
      <el-table-column prop="createBy" label="创建人"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column prop="updateBy" label="更新人"/>
      <el-table-column prop="updateTime" label="更新时间"/>
    </template>
    <!-- 表单 -->
    <template v-slot:edit>
      <el-form-item prop="username" label="账号名">
        <el-input v-model="editForm.data.username"></el-input>
      </el-form-item>
      <el-form-item prop="nickname" label="用户昵称">
        <el-input v-model="editForm.data.nickname"></el-input>
      </el-form-item>
      <el-form-item prop="password" label="用户密码">
        <el-input :prefix-icon="Lock" v-model="editForm.data.password" type="password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="email" label="邮箱">
        <el-input v-model="editForm.data.email"></el-input>
      </el-form-item>
      <el-form-item prop="roleName" label="角色">
        <el-select v-model="editForm.data.roleId" placeholder="选择角色">
          <el-option v-for="item in roleOptions" :key="item.id" :label="item.roleName" :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="sort" label="性别">
        <el-radio-group v-model="editForm.data.sex">
          <el-radio label="0">不公开</el-radio>
          <el-radio label="1">男</el-radio>
          <el-radio label="2">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item prop="sort" label="状态">
        <el-radio-group v-model="editForm.data.accountStatus">
          <el-radio label="0">停用</el-radio>
          <el-radio label="1">正常</el-radio>
          <el-radio label="2">冻结</el-radio>
          <el-radio label="3">封禁</el-radio>
        </el-radio-group>
      </el-form-item>
    </template>
  </sra-simple-table>
</template>

<script setup lang="ts">
import {Lock} from "@element-plus/icons-vue";
import {onMounted, reactive, ref, watch} from "vue";
import SraSimpleTable from "@/components/table/simple-table/SraSimpleTable.vue";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import {listByPage, deleteBatch, add, update} from "@/api/system/user-api";
import roleApi from "@/api/system/role-api";
import {getPublishStatus} from "@/utils/format-util";

const initData: UserModel = {
  id: '',
  username: '',
  nickname: '',
  email: '',
  sex: '0',
  accountStatus: '1',
  roleId: '',
  roleName: '',
  password: ''
};

const roleOptions = ref<RoleModel[]>([]);
// 表单参数
const editForm = reactive<any>({data: initData});
// 分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchKey: ''});
// api返回的分页数据
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});
// 加载进度
const loading = ref<boolean>(true);
// 表单校验规则
const rules = reactive({
  username: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  nickname: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  password: [{required: true, min: 6, max: 32, message: '长度限制6~32', trigger: 'blur'}],
  roleId: [{required: true, message: '请选择角色', trigger: 'blur'}]
});

// 初始化数据
onMounted(() => {
  initTable();
  getRoles();
});

// 监听当前页的变化
watch(
    () => [pageParam.value.pageNo, pageParam.value.pageSize], () => {
      initTable();
    }
)

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
 * 获取角色列表
 */
const getRoles = () => {
  let param: any = {
    pageNo: 1,
    pageSize: 1000,
    roleVO: {roleName: ''}
  }
  reqCommonFeedback(roleApi.listByPage(param), (data: any) => {
    roleOptions.value = data.rows;
  });
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
 * 单个移除
 * @param row
 */
const remove = (row: any) => removeBatch([row.id]);

/**
 * 初始化数据
 */
const initTable = () => {
  // 渲染数据
  if (!loading.value) {
    loading.value = true;
  }
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    userVO: {nickname: pageParam.value.searchKey, username: pageParam.value.searchKey}
  };
  reqCommonFeedback(listByPage(param), (data: any) => {
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
const removeBatch = (ids: string[]) => {
  reqSuccessFeedback(deleteBatch(ids), '删除成功', () => {
    initTable();
  });
}
</script>

<style scoped></style>