<template>
  <div>
    <v-dialog v-model="showDialog" max-width="500px" persistent>
      <v-card>
        <v-card-title>
          <span class="text-h5" v-if="editedItem.editType !== 0">
            {{ editedItem.editType === 1 ? '编辑菜单' : '新增菜单' }}
          </span>
        </v-card-title>

        <v-card-text>
          <!-- 表单 -->
          <v-form ref="form" v-model="valid" :disabled="editedItem.editType === 0">
            <v-text-field
                v-model="editedItem.menuName"
                label="菜单名称"
                placeholder="菜单名称"
                :counter="16"
                :rules="[
                  (v) => !!v || '菜单名称为空',
                  (v) => (v && v.length <= 16) || '菜单名称长度不能超过16个字符'
              ]"
            ></v-text-field>

            <v-text-field
                v-model="editedItem.permissionCode"
                label="权限编号"
                placeholder="权限编号"
                :counter="64"
                :rules="[
                  (v) => !!v || '权限编号为空',
                  (v) => (v && v.length <= 64) || '权限编号长度不能超过64个字符'
              ]"
            ></v-text-field>

            <v-text-field
                v-model="editedItem.routerPath"
                label="路由地址"
                placeholder="路由地址"
                :counter="255"
                :rules="[
                  (v) => !!v || '路由地址为空',
                  (v) => (v && v.length <= 255) || '路由地址长度不能超过255个字符'
              ]"
            ></v-text-field>

            <v-radio-group row v-model="editedItem.menuType" mandatory>
              <v-radio label="目录" value="0"></v-radio>
              <v-radio label="菜单" value="1"></v-radio>
              <v-radio label="按钮" value="2"></v-radio>
            </v-radio-group>

            <v-radio-group row v-model="editedItem.isMenu" mandatory>
              <v-radio label="导航菜单" value="0"></v-radio>
              <v-radio label="接口权限" value="1"></v-radio>
            </v-radio-group>

            <v-text-field
                v-model="editedItem.sort"
                type="number"
                label="显示顺序"
                placeholder="显示顺序"
            ></v-text-field>

            <v-text-field
              v-model="editedItem.componentPath"
              label="组件路径"
              placeholder="组件路径"
              :counter="64"
              :rules="[
                (v) => (v.length <= 64) || '组件路径长度不能超过64个字符'
              ]"
            ></v-text-field>

            <v-radio-group row v-model="editedItem.isExternalLink" mandatory>
              <v-radio label="是外链" value="0"></v-radio>
              <v-radio label="不是外链" value="1"></v-radio>
            </v-radio-group>

            <v-text-field
              v-model="editedItem.iconPath"
              label="图标名称（可从vuetifyjs官网查找）"
              placeholder="图标名称"
              :counter="255"
              :rules="[
                (v) => (v.length <= 255) || '图标名称长度不能超过255个字符'
              ]"
            ></v-text-field>
          </v-form>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="close">取消</v-btn>
          <v-btn color="blue darken-1" text @click="save" v-if="editedItem.editType !== 0">保存</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <common-tip ref="commonTip"/>
  </div>
</template>

<script>
import {add, update} from "@/api/system/menu-api";
import CommonTip from "@/components/common/tip";

export default {
  name: "MenuEdit",
  components: {CommonTip},
  props: {
    item: {type: Object, required: true, default: null},
    showDialog: {type: Boolean, required: false, default: false}
  },
  data: () => ({
    valid: true,
    saveParam: {},
    editedItem: {menuType:"1", isMenu:"0", sort:1, componentPath: '', isExternalLink:"1", iconPath:''}
  }),
  watch: {
    // 监听窗口，用于给表单赋值
    showDialog: {
      immediate: true,
      handler(val) {
        if(this.item.id) {
          this.editedItem = JSON.parse(JSON.stringify(this.item));
        }
      }
    }
  },
  methods: {
    /**
     * 关闭窗口
     */
    close() {
      this.$emit('close');
    },
    /**
     * 新增&更新
     * @returns {Promise<void>}
     */
    async save() {
      if (!this.$refs.form.validate()) {
        return;
      }
      let res;
      const param = this.editedItem;
      // 判断操作类型
      if (this.editedItem.editType === 1) {
        res = await update(param);
      } else if (this.editedItem.editType === 2){
        param.parentId = this.editedItem.id;
        res = await add(param);
      }
      if (res.code === 200) {
        this.$refs.commonTip.success('更新成功');
        this.close();
      } else {
        this.$refs.commonTip.error(res.data);
      }
    }
  }
}
</script>
