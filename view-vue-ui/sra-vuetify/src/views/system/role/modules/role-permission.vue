<template>
  <v-dialog v-model="show" max-width="500px" persistent>
    <v-card>
      <v-card-title>
        <span class="text-h5">设置角色权限</span>
      </v-card-title>
      <!-- 权限列表 -->
      <v-treeview :items="items" selectable selection-type="independent" v-model="selectedPermissions">
        <template v-slot:label="{ item }">
          <span>{{ item.menuName }}</span>
        </template>
      </v-treeview>

      <!-- 操作 -->
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="close">
          取消
        </v-btn>
        <v-btn color="blue darken-1" text @click="update">
          保存
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import {listByRoleId, listByTree} from "@/api/system/menu-api";
import {grantPermissionsByRoleId} from "@/api/system/role-api";

export default {
  name: "RolePermission",
  props: {
    show: {type: Boolean, required: true, default: true},
    item: {type: Object, required: true, default: {}}
  },
  data() {
    return {
      items: [],
      // 选中的权限列表
      selectedPermissions: []
    }
  },
  watch: {
    show: {
      immediate: true,
      handler(val) {
        if (val) {
          this.getAllPermission();
        }
      }
    }
  },
  methods: {
    /**
     * 获取所有权限树结构
     */
    getAllPermission() {
      listByTree(2).then(res => {
        if (res.code === 200) {
          this.items = res.data;
          listByRoleId(this.item.id).then(res => {
            if (res.code === 200) {
              this.selectedPermissions = [];
              res.data.forEach(item => {
                this.selectedPermissions.push(item.id);
              });
            }
          });
        }
      });
    },
    /**
     * 更新角色权限
     */
    update() {
      let param = [];
      this.selectedPermissions.forEach(item => {
        param.push({roleId: this.item.id, menuId: item});
      })
      grantPermissionsByRoleId(param).then(res => {
        if (res.code === 200) {
          this.close();
        }
      })
    },
    /**
     * 关闭弹窗
     */
    close() {
      this.$emit('close');
    },
  }
}
</script>
