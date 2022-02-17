<template>
  <v-app id="userManager">
    <v-data-table :loading="tableLoading" :headers="headers" :items="roleList" class="elevation-1" @update:page="onPageChange">
      <template v-slot:top>
        <v-toolbar flat>
          <v-row>
            <!-- 新增用户栏 -->
            <v-col cols="9">
              <v-btn color="primary" dark class="mb-2" @click="editItem({}, 1)">
                添加用户
              </v-btn>
            </v-col>
            <!-- 搜索栏 -->
            <v-col cols="3">
              <v-text-field append-icon="mdi-magnify" label="Search" single-line hide-details></v-text-field>
            </v-col>
          </v-row>
          <!-- 编辑对话框 -->
          <user-edit :data="editedItem" :dialog-edit="dialogEdit" @close="closeEdit" />
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
      <!-- 格式化数据 -->
      <template v-slot:item.sex="{ item }">
        <span>{{getSexText(item.sex)}}</span>
      </template>
      <template v-slot:item.accountStatus="{ item }">
        <span>{{getAccountStatusText(item.accountStatus)}}</span>
      </template>
      <!-- 操作 -->
      <template v-slot:item.actions="{ item }">
        <v-icon small class="mr-2" @click="editItem(item, 2)">
          mdi-pencil
        </v-icon>
        <v-icon small @click="deleteItem(item)">
          mdi-delete
        </v-icon>
      </template>
      <template v-slot:no-data>无数据</template>
    </v-data-table>
  </v-app>
</template>

<script>
import {listByPage, del} from "@/api/system/user-api";
import UserEdit from "@/views/system/user/modules/user-edit";
import {getSexText,getAccountStatusText} from "@/utils/format-util";

export default {
  name: "UserView",
  components: {UserEdit},
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
      { text: '用户账号', value: 'username' },
      { text: '用户昵称', value: 'nickname' },
      { text: '用户角色', value: 'roleName' },
      { text: '用户邮箱', value: 'email' },
      { text: '性别', value: 'sex' },
      { text: '账号状态', value: 'accountStatus' },
      { text: '操作', value: 'actions', sortable: false },
    ],
    // 编辑项
    editedItem: {},
    // 分页参数
    pageParam: {
      pageSize: 10,
      pageNo: 1,
      recordCount: 0,
      userVO: {
        username: '',
        nickname: ''
      }
    },
    // 表格加载
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
     * 删除用户
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
     * 页面发生改变
     */
    onPageChange(num) {
      this.pageParam.pageNo = num;
      this.initialize();
    },
    getSexText(num) {
      return getSexText(num);
    },
    getAccountStatusText(num) {
      return getAccountStatusText(num);
    }
  },
}
</script>
