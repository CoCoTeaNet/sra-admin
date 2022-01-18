<template>
  <v-treeview open-all activatable :items="items">
    <template v-slot:prepend="{ item }">
      <v-icon>{{item.iconPath}}</v-icon>
    </template>
    <!-- 操作 -->
    <template v-slot:append="{ item }">
      <v-row>
        <v-col><v-btn icon @click="editItem(item, 1)"><v-icon>mdi-pencil</v-icon></v-btn></v-col>
        <v-col><v-btn icon @click="editItem(item, 2)"><v-icon>mdi-plus</v-icon></v-btn></v-col>
        <v-col><v-btn icon @click="editItem(item, 3)"><v-icon>mdi-delete</v-icon></v-btn></v-col>
      </v-row>
    </template>
  </v-treeview>
</template>

<script>
import { listByTree } from "@/api/system/menu-api";

export default {
  name: "MenuTree",
  data: () => ({
    items: [],
  }),
  created() {
    this.listByTree();
  },
  methods: {
    async listByTree() {
      let res = await listByTree();
      if (res.code === 200) {
        this.items = res.data;
      }
    },
    editItem(item, editType) {
      this.$emit('editItem', item, editType)
    }
  }
}
</script>