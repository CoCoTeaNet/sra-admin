<template>
  <v-treeview dense rounded hoverable activatable open-all :items="items" >
    <template v-slot:prepend="{ item }">
      <v-icon small>{{item.iconPath ? item.iconPath : 'mdi-key-chain-variant'}}</v-icon>
    </template>
    <template v-slot:label="{ item }">
      <span>{{item.menuName}}</span>
    </template>
    <!-- 操作 -->
    <template v-slot:append="{ item }">
      <v-row no-gutters>
        <v-col>
          <v-btn text small color="primary" @click="editItem(item, 0)">
            <v-icon small>mdi-eye</v-icon>查看
          </v-btn>
        </v-col>
        <v-col>
          <v-btn text small color="primary" @click="editItem(item, 4)">
            <v-icon small>mdi-drag-variant</v-icon>移动
          </v-btn>
        </v-col>
        <v-col>
          <v-btn text small color="primary" @click="editItem(item, 1)">
            <v-icon small>mdi-pencil</v-icon>编辑
          </v-btn>
        </v-col>
        <v-col>
          <v-btn text small color="primary" @click="editItem(item, 2)">
            <v-icon small>mdi-plus</v-icon>新增
          </v-btn>
        </v-col>
        <v-col>
          <v-btn text small color="primary" @click="editItem(item, 3)">
            <v-icon small>mdi-delete</v-icon>删除
          </v-btn>
        </v-col>
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