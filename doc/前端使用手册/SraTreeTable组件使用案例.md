#### 例子
```vue
<template>
  <sra-tree-table :editForm="editFrom" :pageVo="pageVo" @edit="edit" @remove="remove" @enter-search="initTable"
                  @dialog-confirm="doUpdate" @remove-batch="removeBatch" :rules="rules"
                  v-loading="loading">
    <template v-slot:default>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="menuName" label="名称" sortable/>
      <el-table-column prop="iconPath" label="图标" sortable>
        <template #default="scope">
          <el-icon>
            <component :is="scope.row.iconPath"></component>
          </el-icon>
        </template>
      </el-table-column>
      <el-table-column prop="menuType" label="类型" sortable>
        <template #default="scope">
          <span>{{ getMenuTypeText(scope.row.menuType) }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="routerPath" label="路由地址"/>
      <el-table-column prop="isExternalLink" label="是否外链">
        <template #default="scope">
          <span>{{ getIsSomethingText(scope.row.isExternalLink) }}</span>
        </template>
      </el-table-column>
    </template>
    <!-- 新增&编辑表单 -->
    <template v-slot:edit>
      <el-form-item prop="menuName" label="菜单名称">
        <el-input v-model="editFrom.menuName"></el-input>
      </el-form-item>
      <el-form-item label="菜单类型">
        <el-radio-group v-model="editFrom.menuType">
          <el-radio model-value="0" label="目录"></el-radio>
          <el-radio model-value="1" label="菜单"></el-radio>
          <el-radio model-value="2" label="按钮"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="菜单图标">
        <icon-selection v-model="editFrom.iconPath"/>
      </el-form-item>
      <el-form-item label="路由地址">
        <el-input v-model="editFrom.routerPath"></el-input>
      </el-form-item>
      <el-form-item label="是否外链">
        <el-radio-group v-model="editFrom.isExternalLink">
          <el-radio model-value="0" label="是"></el-radio>
          <el-radio model-value="1" label="否"></el-radio>
        </el-radio-group>
      </el-form-item>
    </template>
  </sra-tree-table>
</template>

<script setup lang="ts">
import SraTreeTable from "@/components/table/tree-table/SraTreeTable.vue";
import {onMounted, reactive, ref} from "vue";
import {listByTree} from "@/api/system/menu-api";
import {ElMessage} from "element-plus";
import {getMenuTypeText, getIsSomethingText} from "@/utils/format-util";
import IconSelection from "@/components/selection/IconSelection.vue";

// 表单参数
const editFrom: MenuModel = reactive({
  id: '',
  menuName: '',
  menuType: '',
  iconPath: '',
  routerPath: '',
  isExternalLink: '',
  parentId: ''
});

// 加载进度
const loading = ref<boolean>(true);

// 表单校验规则
const rules = reactive({
  menuName: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
  menuType: [{required: true, message: '请选择菜单编号', trigger: 'blur'}],
  routerPath: [{required: true, min: 2, max: 255, message: '长度限制2~255', trigger: 'blur'}],
  isExternalLink: [{required: true, message: '请选择链接类型', trigger: 'blur'}],
});

// api返回的分页数据
const pageVo = ref<PageVO>({pageNum: 1, pageSize: 10, total: 0, records: []});

// 初始化数据
onMounted(() => {
  initTable();
});

const edit = (id: string) => {
  // todo 获取行详细
  console.log(id)
}

const remove = (id: string) => {
  // todo 调用删除行接口
  console.log(id)
}

const initTable = (): void => {
  // todo 渲染数据
  listByTree(0).then((res: any) => {
    if (res.code === 200) {
      pageVo.value.records = res.data;
    } else {
      ElMessage.error(res.data);
    }
    loading.value = false;
  });
}

const doUpdate = (formEl: FormInstance | undefined): void => {
  // todo 更新操作
  formEl.validate((valid: any) => {
    console.log('valid::', valid)
    console.log('doUpdate::', editFrom)
  });
}

const removeBatch = (ids: string[]): void => {
  // todo 批量删除
  console.log(ids);
}
</script>

```