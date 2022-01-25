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
              v-model="editedItem.username"
              label="账号名"
              placeholder="账号名"
              :counter="30"
              :rules="[
                  (v) => !!v || '账号名为空',
                  (v) => (v && v.length <= 30) || '账号名长度不能超过30个字符'
              ]"
          ></v-text-field>

          <v-text-field
              v-model="editedItem.password"
              label="用户密码"
              placeholder="用户密码"
              :counter="30"
              :rules="[
                  (v) => !!v || '用户密码为空',
                  (v) => (v && v.length <= 30) || '用户密码长度不能超过30个字符'
              ]"
          ></v-text-field>

          <v-select
              v-model="selectRole"
              :items="roleList"
              item-text="roleName"
              item-value="id"
              label="选择角色"
          ></v-select>
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
import {listByPage} from "@/api/system/role-api";
import {add} from "@/api/system/user-api";
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
      valid: true,
      // 分页参数
      pageParam: {
        pageSize: 10,
        pageNo: 1,
        recordCount: 0,
        roleVO: {
          roleName: '',
          roleKey: ''
        }
      },
      selectRole: {roleId: '', roleName: ''},
      // 角色列表
      roleList: []
    }
  },
  created() {
    this.roleListByPage();
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
        param.roleId = this.selectRole;
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
    /**
     * 搜索角色列表
     */
    roleListByPage() {
      listByPage(this.pageParam).then(res => {
        if (res.code === 200) {
          this.roleList = res.data.rows;
        }
      });
    }
  }
}
</script>
