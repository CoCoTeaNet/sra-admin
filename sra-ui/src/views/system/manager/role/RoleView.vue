<template>
  <div>
    <sra-simple-table v-loading="loading"
                      :editForm="editForm.data" :pageVo="pageVo" :pageParam="pageParam" :rules="rules"
                      @add="initAdd" @edit="edit" @remove="remove" @enter-search="initTable" @refresh="refresh"
                      @dialog-confirm="doUpdate" @remove-batch="removeBatch">
      <template v-slot:column>
        <el-table-column type="selection" width="55"/>
        <el-table-column prop="roleName" label="角色名称"/>
        <el-table-column prop="roleKey" label="角色标识"/>
        <el-table-column prop="sort" label="排序" sortable/>
        <el-table-column label="权利操作">
          <template #default="scope">
            <el-button size="small" @click="showDialogMenu(scope.row, 0)">赋予菜单</el-button>
            <el-button size="small" @click="showDialogMenu(scope.row, 1)">授予权限</el-button>
          </template>
        </el-table-column>
      </template>
      <!-- 表单 -->
      <template v-slot:edit>
        <el-form-item prop="roleName" label="角色名称">
          <el-input v-model="editForm.data.roleName"></el-input>
        </el-form-item>
        <el-form-item prop="roleKey" label="角色标识">
          <el-input v-model="editForm.data.roleKey"></el-input>
        </el-form-item>
        <el-form-item prop="sort" label="排序">
          <el-input type="number" v-model="editForm.data.sort"></el-input>
        </el-form-item>
      </template>
    </sra-simple-table>
    <!-- 权限操作 -->
    <el-dialog v-model="dialogMenuVisible" title="授予权限">
      <el-tree v-model:default-checked-keys="defaultSelectMenuIdList"
               @check-change="checkChange"
               :data="menuOptions"
               show-checkbox
               default-expand-all
               node-key="id"
               highlight-current
               :props="defaultProps"
      />
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogMenuVisible = false">取消</el-button>
          <el-button type="primary" @click="dialogConfirm">确认</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import {onMounted, nextTick, reactive, ref, watch} from "vue";
import SraSimpleTable from "@/components/table/simple-table/SraSimpleTable.vue";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import roleApi, {grantPermissionsByRoleId} from "@/api/system/role-api";
import {listByTree, listByRoleId} from "@/api/system/menu-api";

// 树形选择框配置
const defaultProps = {
  value: 'id',
  label: 'menuName',
  children: 'children',
  checkStrictly: true
}

const initData: RoleModel = {
  id: '',
  roleName: '',
  roleKey: '',
  sort: 1
};

// 授予菜单对话框
const dialogMenuVisible = ref<boolean>(false);
// 默认已选id
const defaultSelectMenuIdList = ref<string[]>([]);
// 菜单选项
const menuOptions = ref<RoleModel[]>([]);
// 授予权限的行id
const selectId = ref<string>('');
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
  roleName: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  roleKey: [{required: true, min: 2, max: 255, message: '长度限制2~155', trigger: 'blur'}]
});

// 初始化数据
onMounted(() => {
  initTable();
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
    roleVO: {roleName: pageParam.value.searchKey, roleKey: pageParam.value.searchKey}
  };
  reqCommonFeedback(roleApi.listByPage(param), (data: any) => {
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
        reqSuccessFeedback(roleApi.add(editForm.data), '新增成功', () => {
          initTable();
          callback();
        });
      } else {
        // 修改
        reqSuccessFeedback(roleApi.update(editForm.data), '修改成功', () => {
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
  reqSuccessFeedback(roleApi.deleteBatch(ids), '删除成功', () => {
    initTable();
  });
}

/**
 * 确认修改权限
 */
const dialogConfirm = () => {
  let param: any[] = [];
  defaultSelectMenuIdList.value.forEach((item: string) => {
    param.push({roleId: selectId.value, menuId: item});
  });
  reqSuccessFeedback(grantPermissionsByRoleId(param), '修改成功', () => {
    dialogMenuVisible.value = false;
  });
}

/**
 * 显示授予菜单对话框
 * @param row 行数据
 * @param t 是否菜单：0是 1否
 */
const showDialogMenu = (row: any, t: number) => {
  defaultSelectMenuIdList.value = [];
  dialogMenuVisible.value = true;
  selectId.value = row.id;
  getMenus(t, () => {
    getMenusByRoleId(row.id);
  });
}

/**
 * 获取权限列表
 */
const getMenus = (t: number, callback: Function) => {
  let param: any = {
    pageNo: 1,
    pageSize: 1000,
    menuVO: {menuName: '', isMenu: t}
  }
  reqCommonFeedback(listByTree(param), (data: any) => {
    menuOptions.value = data.rows;
    nextTick(callback());
  });
}

/**
 * 根据角色id获取菜单id列表
 * @param roleId 角色id
 */
const getMenusByRoleId = (roleId: string) => {
  let selectIdList: string[] = [];
  reqCommonFeedback(listByRoleId(roleId), (data: any) => {
    data.forEach((item: any) => {
      selectIdList.push(item.id);
    });
    defaultSelectMenuIdList.value = selectIdList;
  });
}

/**
 * 共三个参数，依次为：传递给 data 属性的数组中该节点所对应的对象、节点本身是否被选中、节点的子树中是否有被选中的节点
 * @param v1
 * @param v2
 * @param v3
 */
const checkChange = (v1: any, v2: any, v3: any) => {
  if (v2) {
    // 选中，没有重复项
    if (defaultSelectMenuIdList.value.indexOf(v1.id) == -1) {
      defaultSelectMenuIdList.value.push(v1.id);
    }
  } else {
    // 未选中
    let index = defaultSelectMenuIdList.value.indexOf(v1.id);
    if (index != -1 && !v3) {
      defaultSelectMenuIdList.value.splice(index, 1);
    }
  }
}
</script>

<style scoped></style>