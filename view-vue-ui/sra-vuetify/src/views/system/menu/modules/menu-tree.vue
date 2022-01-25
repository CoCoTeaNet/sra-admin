<template>
  <v-treeview open-on-click activatable :items="items">
    <template v-slot:prepend="{ item }">
      <v-icon>{{item.iconPath ? item.iconPath : 'mdi-key-chain-variant'}}</v-icon>
    </template>
    <template v-slot:label="{ item }">
      <span>{{item.menuName}}</span>
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
export default {
  name: "MenuTree",
  props: { itemList: {type: Array, required: true, default: []} },
  data: () => ({
    items: [],
  }),
  watch: {
    itemList: {
      immediate: true,
      handler(val) {
        this.items = this.itemList;
      }
    }
  },
  methods: {
    editItem(item, editType) {
      this.$emit('editItem', item, editType);
    }
  }
}
</script>