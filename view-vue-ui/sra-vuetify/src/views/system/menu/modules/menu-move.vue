<template>
  <v-dialog v-model="show" max-width="500px" persistent>
    <v-card>
      <v-card-title>
        <span class="text-h5">移动位置</span>
      </v-card-title>
      <!-- 权限列表 -->
      <v-radio-group v-model="selected" mandatory>
        <v-treeview :items="items">
          <template v-slot:prepend="{ item }">
            <v-radio :key="item.id" :label="item.menuName" :value="item.id"></v-radio>
          </template>
        </v-treeview>
      </v-radio-group>

      <!-- 操作 -->
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="close">取消</v-btn>
        <v-btn color="blue darken-1" text @click="move">保存</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import {listByTree, update} from "@/api/system/menu-api";

const defaultSelect = {id: '0', menuName: '根节点'};

export default {
  name: "MenuMove",
  props: {
    show: {type: Boolean, required: true, default: true},
    item: {type: Object, required: true, default: {}}
  },
  data() {
    return {
      items: [],
      // 选中的权限列表
      selected: defaultSelect
    }
  },
  watch: {
    show: {
      immediate: true,
      handler(val) {
        // 窗口为true时渲染数据
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
      listByTree(this.item.isMenu).then(res => {
        if (res.code === 200) {
          this.items = [];
          this.items.push(defaultSelect)
          // 移除当前项
          res.data.forEach(item => {
            if (item.id !== this.item.id) {
              this.items.push(item);
            }
          });
        }
      });
    },
    /**
     * 移动菜单位置
     */
    move() {
      let param = this.item;
      param.parentId = this.selected;
      update(param).then(res => {
        if (res.code === 200) {
          this.close();
        }
      });
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
