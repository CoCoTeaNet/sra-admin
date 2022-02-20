<template>
  <v-app id="menuView">
    <v-card class="pa-2">
      <!-- 表头 -->
      <v-row align="baseline">
        <!-- 新增菜单 -->
        <v-col cols="9">
          <v-btn color="primary" @click="editItem({}, 2)">
            {{isMenu===0 ? '添加菜单' : '添加权限'}}
          </v-btn>
        </v-col>
      </v-row>
      <!-- 表体 -->
      <v-row>
        <!-- 菜单树 -->
        <v-col>
          <menu-tree class="lighten-5" @editItem="editItem" :item-list="items"/>
        </v-col>
      </v-row>
      <!-- 删除项对话框 -->
      <v-dialog width="500" v-model="dialogDelete">
        <v-card>
          <v-card-title class="text-h5"> 确定删除「{{ deleteItem.menuName }}」{{isMenu===0?'菜单':'权限'}}? </v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn text @click="dialogDelete = false">取消</v-btn>
            <v-btn color="red darken-1" text @click="del">删除</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-card>
    <!-- 编辑菜单对话框 -->
    <menu-edit :item="editedItem" :isMenu="isMenu" :show-dialog="dialogEdit" @close="closeEdit"/>
    <!-- 菜单移动位置 -->
    <menu-move :item="editedItem" :show="dialogMove" @close="closeEdit"/>
  </v-app>
</template>

<script>
import MenuEdit from "@/views/system/menu/modules/menu-edit";
import MenuTree from "@/views/system/menu/modules/menu-tree";
import {del, listByTree} from "@/api/system/menu-api";
import MenuMove from "@/views/system/menu/modules/menu-move";

export default {
  name: "MenuView",
  components: {MenuMove, MenuTree, MenuEdit},
  data: () => ({
    // 编辑对话框
    dialogEdit: false,
    // 删除对话框
    dialogDelete: false,
    // 移动菜单对话框
    dialogMove: false,
    // 编辑项
    editedItem: {},
    // 删除项
    deleteItem: {},
    // 菜单列表
    items: [],
    // 是否菜单 0是 1否 2所有
    isMenu: 2,
  }),
  created() {
    let self = this;
    self.isMenu = self.$route.path === '/admin/sys-manager/menu' ? 0 : 1;
    self.$nextTick(() => {
      self.listByTree();
    });
  },
  methods: {
    /**
     * 编辑菜单：0查看，1编辑，2新增，3删除，4移动
     * @param editType
     * @param item
     */
    editItem(item, editType) {
      if (editType === 3) {
        this.deleteItem = item;
        this.dialogDelete = true;
      } else if (editType === 2) {
        this.editedItem = item;
        this.editedItem.editType = editType;
        this.dialogEdit = true;
      } else if (editType === 0 || editType === 1) {
        this.editedItem = item;
        this.editedItem.editType = editType;
        this.dialogEdit = true;
      } else if (editType === 4) {
        this.editedItem = item;
        this.dialogMove = true;
      }
    },
    /**
     * 删除菜单
     */
    async del() {
      let res = await del(this.deleteItem.id);
      if (res.code === 200) {
        this.closeEdit();
      }
    },
    /**
     * 获取菜单数据
     * @returns {Promise<void>}
     */
    async listByTree() {
      let res = await listByTree(this.isMenu);
      if (res.code === 200) {
        this.items = res.data;
      }
    },
    /**
     * 关闭窗口
     */
    closeEdit() {
      this.listByTree();
      this.dialogEdit = false;
      this.dialogDelete = false;
      this.dialogMove = false;
    }
  },
}
</script>