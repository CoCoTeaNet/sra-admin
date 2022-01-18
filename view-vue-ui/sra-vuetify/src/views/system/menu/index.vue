<template>
  <v-app id="menuView">
    <div>
      <!-- 表头 -->
      <v-row>
        <!-- 新增菜单 -->
        <v-col cols="9"></v-col>
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
          <menu-tree class="elevation-1" @editItem="editItem" />
        </v-col>
      </v-row>
    </div>
    <menu-edit :edited-item="editedItem" :show-dialog="dialogEdit" @close="closeEdit" />
  </v-app>
</template>

<script>
import MenuEdit from "@/views/system/menu/modules/menu-edit";
import MenuTree from "@/views/system/menu/modules/menu-tree";

export default {
  name: "MenuView",
  components: {MenuTree, MenuEdit},
  data: () => ({
    dialogEdit: false,
    dialogDelete: false,
    menuTrees: [],
    editedItem: {},
  }),

  created() {},

  methods: {
    /**
     * 编辑菜单：0查看，1编辑，2新增，3删除
     * @param editType
     * @param item
     */
    editItem(item, editType) {
      if (editType === 3) {
        // todo 删除
      } else {
        this.editedItem = item;
        this.editedItem.editType = editType;
        this.dialogEdit = true;
      }
    },
    /**
     * 关闭关机窗口
     */
    closeEdit() {
      this.dialogEdit = false;
    }
  },
}
</script>