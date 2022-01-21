<template>
  <v-data-table :headers="headers" :items="roleList"class="elevation-1">
    <template v-slot:top>
      <v-toolbar flat>
        <v-spacer></v-spacer>
        <!-- 编辑对话框 -->
        <role-edit :dialog-edit="dialogEdit" />
        <!-- 删除对话框 -->
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">确定删除该角色?</v-card-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text>取消</v-btn>
              <v-btn color="blue darken-1" text>删除</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <!-- 操作 -->
    <template v-slot:item.actions="{ item }">
      <v-icon small class="mr-2" @click="editItem(item)">
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
import {listByPage} from "@/api/system/role-api";

export default {
  name: "RoleView",
  components: {RoleEdit},
  data: () => ({
    // 删除对话框
    dialogDelete: false,
    // 编辑对话框
    dialogEdit: false,
    roleList: [],
    headers: [
      { text: '角色名称', value: 'roleName' },
      { text: '角色标识', value: 'roleKey' },
      { text: '备注', value: 'remark' },
      { text: '创建时间', value: 'createTime' },
      { text: '操作', value: 'actions', sortable: false },
    ],
    // 编辑项
    editedItem: {},
    pageParam: {
      pageSize: 10,
      pageNo: 1,
      recordCount: 0,
      roleVO: {
        roleName: '',
        roleKey: ''
      }
    }
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
      listByPage(this.pageParam).then(res => {
        if (res.code === 200) {
          this.roleList = res.data.rows;
          this.pageParam.recordCount = res.recordCount;
        }
      });
    },
    /**
     * 编辑弹窗
      * @param item
     */
    editItem (item) {},
    /**
     * 删除弹窗
      * @param item
     */
    deleteItem (item) {},
    /**
     * 关闭编辑弹窗
     */
    closeEdit() {
      this.dialogEdit = false;
      this.initialize();
    }
  },
}
</script>