<template>
  <v-app id="menuView">
    <div>
      <!-- 表头 -->
      <v-row align="baseline">
        <!-- 新增菜单 -->
        <v-col cols="9">
          <v-btn rounded color="primary" @click="editItem({}, 2)">新增菜单</v-btn>
        </v-col>
        <!-- 搜索栏 -->
        <v-col cols="3">
          <v-text-field append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-col>
      </v-row>
      <!-- 表体 -->
      <v-row>
        <!-- 菜单树 -->
        <v-col>
          <menu-tree class="rounded-xl grey lighten-5 elevation-1" @editItem="editItem" :item-list="items" />
        </v-col>
      </v-row>
      <!-- 删除项对话框 -->
      <v-dialog width="500" v-model="dialogDelete">
        <v-card>
          <v-card-title class="text-h5">
            确定删除「{{deleteItem.menuName}}」菜单?
          </v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn text @click="dialogDelete = false">取消</v-btn>
            <v-btn color="red darken-1" text @click="del">删除</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
    <!-- 编辑菜单对话框 -->
    <menu-edit :item="editedItem" :show-dialog="dialogEdit" @close="closeEdit" />
  </v-app>
</template>

<script>
import MenuEdit from "@/views/system/menu/modules/menu-edit";
import MenuTree from "@/views/system/menu/modules/menu-tree";
import {del, listByTree} from "@/api/system/menu-api";

export default {
  name: "MenuView",
  components: {MenuTree, MenuEdit},
  data: () => ({
    // 编辑对话框
    dialogEdit: false,
    // 删除对话框
    dialogDelete: false,
    // 编辑项
    editedItem: {},
    // 删除项
    deleteItem: {},
    // 菜单列表
    items: []
  }),
  created() {
    this.listByTree();
  },
  methods: {
    /**
     * 编辑菜单：0查看，1编辑，2新增，3删除
     * @param editType
     * @param item
     */
    editItem(item, editType) {
      if (editType === 3) {
        // 删除提示
        this.deleteItem = item;
        this.dialogDelete = true;
      } if (editType === 2) {
        this.saveItem();
      } else {
        this.editedItem = item;
        this.editedItem.editType = editType;
        this.dialogEdit = true;
      }
    },
    /**
     * 新增菜单
     */
    saveItem() {
      this.editedItem = {};
      this.editedItem.editType = 2;
      this.dialogEdit = true;
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
      let res = await listByTree();
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
    }
  },
}
</script>