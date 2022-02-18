<template>
  <v-data-table :loading="tableLoading" :headers="headers" :items="roleList" class="elevation-1" @update:page="onPageChange">
    <template v-slot:top>
      <v-toolbar flat>
        <v-row>
          <v-col cols="9">
            <v-btn class="mr-2 white" @click="initialize"><v-icon>mdi-refresh</v-icon>刷新</v-btn>
            <v-btn color="primary" @click="editItem({}, 1)">添加角色</v-btn>
          </v-col>
          <v-col cols="3">
            <v-text-field v-model="pageParam.roleVO.roleName" @keypress.enter="initialize"
                          append-icon="mdi-magnify" label="查询角色名称" single-line hide-details>
            </v-text-field>
          </v-col>
        </v-row>
        <!-- 编辑对话框 -->
        <role-edit :data="editedItem" :dialog-edit="dialogEdit" @close="closeEdit" />
        <!-- 设置角色权限对话框 -->
        <role-permission :show="dialogPermission" :item="editedItem" @close="dialogPermission = false"/>
        <!-- 删除对话框 -->
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">确定删除该角色?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="dialogDelete = false">取消</v-btn>
              <v-btn color="blue darken-1" text @click="del">删除</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <!-- 操作 -->
    <template v-slot:item.actions="{ item }">
      <v-icon small class="mr-2" @click="showPermissionDialog(item)">
        mdi-cog
      </v-icon>
      <v-icon small class="mr-2" @click="editItem(item, 2)">
        mdi-pencil
      </v-icon>
      <v-icon small @click="deleteItem(item)">
        mdi-delete
      </v-icon>
    </template>
    <template v-slot:no-data>无数据</template>
  </v-data-table>
</template>

<script>
import RoleEdit from "@/views/system/role/modules/role-edit";
import {listByPage,del} from "@/api/system/role-api";
import RolePermission from "@/views/system/role/modules/role-permission";

export default {
  name: "RoleView",
  components: {RolePermission, RoleEdit},
  data: () => ({
    // 删除对话框
    dialogDelete: false,
    // 编辑对话框
    dialogEdit: false,
    // 权限设置对话框
    dialogPermission: false,
    // 角色列表
    roleList: [],
    // 表单标题
    headers: [
      { text: '角色名称', value: 'roleName' },
      { text: '角色标识', value: 'roleKey' },
      { text: '创建时间', value: 'createTime' },
      { text: '备注', value: 'remark' },
      { text: '操作', value: 'actions', sortable: false },
    ],
    // 编辑项
    editedItem: {},
    // 分页参数
    pageParam: {
      pageSize: 10,
      pageNo: 1,
      recordCount: 0,
      roleVO: {
        roleName: '',
        roleKey: ''
      }
    },
    // 表格loading状态
    tableLoading: true
  }),

  watch: {},

  created () {
    this.initialize()
  },

  methods: {
    /**
     * 初始化数据
     */
    initialize () {
      let self = this;
      self.$nextTick(function () {
        listByPage(self.pageParam).then(res => {
          if (res.code === 200) {
            self.roleList = res.data.rows;
            self.pageParam.recordCount = res.recordCount;
            self.tableLoading = false;
          }
        });
      });
    },
    /**
     * 编辑弹窗
     * @param item
     * @param editType
     */
    editItem (item, editType) {
      item.editType = editType;
      this.editedItem = item;
      this.dialogEdit = true;
    },
    /**
     * 删除弹窗
      * @param item
     */
    deleteItem (item) {
      this.editedItem = item;
      this.dialogDelete = true;
    },
    /**
     * 关闭编辑弹窗
     * @param flag true表示获取数据
     */
    closeEdit(flag) {
      this.dialogEdit = false;
      if (flag) {
        this.initialize();
      }
    },
    /**
     * 删除菜单
     */
    del() {
      del(this.editedItem.id).then(res => {
        if (res.code === 200) {
          this.initialize();
          this.dialogDelete = false;
        }
      });
    },
    /**
     * 显示权限设置对话框
     */
    showPermissionDialog(item) {
      this.dialogPermission = true;
      this.editedItem = item;
    },
    /**
     * 页面发生改变
     */
    onPageChange(num) {
      console.log(num)
      this.pageParam.pageNo = num;
      this.initialize();
    }
  },
}
</script>