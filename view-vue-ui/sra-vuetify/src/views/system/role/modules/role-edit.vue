<template>
  <v-dialog v-model="dialog" max-width="600px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
        新建角色
      </v-btn>
    </template>

    <v-card>
      <!-- 卡片标题 -->
      <v-card-title>
        <span class="text-h5">{{ editedItem.editType === 1 ? '编辑' : '新增' }}</span>
      </v-card-title>

      <!-- 编辑表单 -->
      <v-card-text>
        <v-form ref="form" v-model="valid">
          <v-text-field
              v-model="editedItem.roleName"
              label="角色名称"
              placeholder="角色名称"
              :counter="30"
              :rules="[
                  (v) => !!v || '角色名称为空',
                  (v) => (v && v.length <= 30) || '角色名称长度不能超过30个字符'
              ]"
          ></v-text-field>

          <v-text-field
              v-model="editedItem.roleKey"
              label="角色编号"
              placeholder="角色编号"
              :counter="100"
              :rules="[
                  (v) => !!v || '角色编号为空',
                  (v) => (v && v.length <= 100) || '角色编号长度不能超过100个字符'
              ]"
          ></v-text-field>

          <v-text-field
              v-model="editedItem.sort"
              label="显示顺序"
              type="number"
              placeholder="显示顺序"
          ></v-text-field>
        </v-form>
      </v-card-text>

      <!-- 表单操作 -->
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="dialog = false">
          取消
        </v-btn>
        <v-btn color="blue darken-1" text @click="saveOrUpdate">
          保存
        </v-btn>
      </v-card-actions>
    </v-card>
    <common-tip ref="commonTip"/>
  </v-dialog>
</template>

<script>
import {add,update} from "@/api/system/role-api";
import CommonTip from "@/components/common/tip";

export default {
  name: "RoleEdit",
  components: {CommonTip},
  props: {dialogEdit: {type: Boolean, required: true, default: false}},
  data(){
    return{
      dialog: this.dialogEdit,
      editedItem: {},
      valid: true
    }
  },
  methods: {
    /**
     * 保存或更新
     */
    async saveOrUpdate() {
      if (!this.$refs.form.validate()) {
        return;
      }
      let param = this.editedItem;
      let res;
      if (this.editedItem.editType === 1) {
        res = await add(param);
      } else if(this.editedItem.editType === 2) {
        res = await update(param);
      }
      if (res.code === 200) {
        this.$emit('close');
      } else {
        this.$refs.commonTip.error(res.data);
      }
    },


  }
}
</script>
