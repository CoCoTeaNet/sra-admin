<template>
  <v-dialog v-model="dialogEdit" max-width="600px" persistent>
    <v-card>
      <!-- 卡片标题 -->
      <v-card-title>
        <span class="text-h5">{{ editedItem.editType === 1 ? '新增' : '编辑' }}</span>
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
        <v-btn color="blue darken-1" text @click="close">
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
import {add, update} from "@/api/system/role-api";
import CommonTip from "@/components/common/tip";

export default {
  name: "UserEdit",
  components: {CommonTip},
  props: {
    dialogEdit: {type: Boolean, required: false},
    data: {type: Object, required: true}
  },
  data() {
    return {
      editedItem: {},
      valid: true
    }
  },
  watch: {
    dialogEdit: {
      immediate: true,
      handler(val) {
        this.editedItem = JSON.parse(JSON.stringify(this.data));
      }
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
      } else if (this.editedItem.editType === 2) {
        res = await update(param);
      }
      if (res.code === 200) {
        this.$emit('close', true);
      } else {
        this.$refs.commonTip.error(res.data);
      }
    },
    /**
     * 关闭窗口
     */
    close() {
      this.$emit('close', false);
    },
  }
}
</script>
