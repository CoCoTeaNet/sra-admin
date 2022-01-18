<template>
  <v-app id="menuView">
    <v-row>
      <v-col cols="3"><menu-tree/></v-col>
      <v-col cols="9" class="fill-height">
        <v-data-table :headers="headers" :items="menuTrees" sort-by="calories">
          <template v-slot:top>
            <v-toolbar flat>
              <!-- 新增菜单 -->
              <v-btn color="primary" dark class="mb-2" @click="editItem(0)">
                新增菜单
              </v-btn>
              <v-spacer></v-spacer>
              <!-- 搜索栏 -->
              <v-text-field
                  append-icon="mdi-magnify"
                  label="Search"
                  single-line
                  hide-details
              ></v-text-field>

              <!-- 删除一条对话框 -->
              <v-dialog v-model="dialogDelete" max-width="500px">
                <v-card>
                  <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-toolbar>
          </template>
          <!-- 格式化数据 -->
          <template v-slot:item.menuType="{ item }">
            <span>{{ getMenuTypeName(item.menuType) }}</span>
          </template>
          <template v-slot:item.isMenu="{ item }">
            <span>{{ item.isMenu === "1" ? "接口权限" : "导航菜单" }}</span>
          </template>
          <template v-slot:item.isExternalLink="{ item }">
            <span>{{ item.isExternalLink === "0" ? "外链" : "非外链" }}</span>
          </template>
          <template v-slot:item.iconPath="{ item }">
            <v-icon>{{ item.iconPath }}</v-icon>
          </template>
          <!-- 删除和编辑按钮 -->
          <template v-slot:item.actions="{ item }">
            <v-icon small class="mr-2" @click="editItem(1, item)">mdi-pencil</v-icon>
            <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
          </template>
        </v-data-table>
      </v-col>
    </v-row>
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
    headers: [
      {text: '权限编号', value: 'permissionCode'},
      {text: '路由地址', value: 'routerPath'},
      {text: '按钮类型', value: 'menuType'},
      {text: '菜单类型', value: 'isMenu'},
      {text: '组件路径', value: 'componentPath'},
      {text: '是否外链', value: 'isExternalLink'},
      {text: '菜单图标', value: 'iconPath'},
      {text: '操作', value: 'actions', sortable: false},
    ],
    menuTrees: [],
    editedIndex: -1,
    editedItem: {},
    defaultItem: {},
  }),

  watch: {
    dialogDelete(val) {
      val || this.closeDelete()
    },
  },

  created() {
    this.initialize()
  },

  methods: {
    async initialize() {
    },

    /**
     * 编辑菜单：0新增，1编辑
     * @param editType
     * @param item
     */
    editItem(editType, item) {
      if (editType === 1) {
        this.editedItem = item;
      }
      this.editedItem.editType = editType;
      this.dialogEdit = true;
    },

    deleteItem(item) {
      this.editedIndex = this.menuTrees.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },

    deleteItemConfirm() {
      this.menuTrees.splice(this.editedIndex, 1)
      this.closeDelete()
    },

    closeDelete() {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },
    
    closeEdit() {
      this.dialogEdit = false;
    },
    /**
     * 获取菜单类型显示名称
     * @param s
     */
    getMenuTypeName(s) {
      if (s === "0") {
        return "目录";
      } else if (s === "1") {
        return "菜单";
      } else if (s === "2") {
        return "按钮";
      }
    }
  },
}
</script>