<template>
  <sra-simple-table class="main-bg" v-loading="loading"
                    :editForm="editForm.data" :pageVo="pageVo" :pageParam="pageParam" :rules="rules"
                    @add="initAdd" @edit="edit" @remove="remove" @enter-search="initTable" @refresh="refresh"
                    @dialog-confirm="doUpdate" @remove-batch="removeBatch">
    <template v-slot:column>
      <el-table-column type="selection" width="55"/>
      <el-table-column prop="title" label="标题"/>
      <el-table-column prop="summary" label="简介"/>
      <el-table-column prop="publishStatus" label="发布状态">
        <template #default="scope">
          <span v-html="getPublishStatus(scope.row.publishStatus)"></span>
        </template>
      </el-table-column>
      <el-table-column prop="createBy" label="创建人"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column prop="updateBy" label="更新人"/>
      <el-table-column prop="updateTime" label="更新时间"/>
    </template>
    <!-- 表单 -->
    <template v-slot:edit>
      <el-form-item prop="username" label="标题">
        <el-input v-model="editForm.data.username"></el-input>
      </el-form-item>
      <el-form-item prop="content" label="内容">
        <div>
          <Toolbar
              style="border-bottom: 1px solid #ccc"
              :mode="mode"
              :editor="editorRef"
              :defaultConfig="toolbarConfig"
          />
          <Editor
              style="height: 450px; overflow-y: hidden;"
              :mode="mode"
              v-model="valueHtml"
              :defaultConfig="editorConfig"
              @onCreated="handleCreated"
          />
        </div>
      </el-form-item>
      <el-form-item prop="tag" label="标签">
        <el-tag
            v-for="tag in dynamicTags"
            :key="tag"
            class="mx-1"
            closable
            :disable-transitions="false"
            @close="handleClose(tag)"
        >
          {{ tag }}
        </el-tag>
        <el-input
            v-if="inputVisible"
            ref="InputRef"
            v-model="inputValue"
            class="ml-1 w-20"
            size="small"
            @keyup.enter="handleInputConfirm"
            @blur="handleInputConfirm"
        />
        <el-button v-else class="button-new-tag ml-1" size="small" @click="showInput">
          + 新增
        </el-button>
      </el-form-item>
    </template>
  </sra-simple-table>
</template>

<script setup lang="ts">
import {onMounted, reactive, nextTick, ref, watch, shallowRef, onBeforeUnmount} from "vue";
import SraSimpleTable from "@/components/table/simple-table/SraSimpleTable.vue";
import {reqCommonFeedback, reqSuccessFeedback} from "@/api/ApiFeedback";
import {listByPage, deleteBatch, add, update} from "@/api/cms/article-api";
import {getPublishStatus} from "@/utils/format-util";
import '@wangeditor/editor/dist/css/style.css';
import {Editor, Toolbar} from '@wangeditor/editor-for-vue';
import {ElInput} from 'element-plus';

const inputValue = ref('');
const dynamicTags = ref(['Tag 1']);
const inputVisible = ref(false);
const InputRef = ref<InstanceType<typeof ElInput>>();

const handleClose = (tag: string) => {
  dynamicTags.value.splice(dynamicTags.value.indexOf(tag), 1)
}

const showInput = () => {
  inputVisible.value = true
  nextTick(() => {
    InputRef.value!.input!.focus()
  })
}

const handleInputConfirm = () => {
  if (inputValue.value) {
    dynamicTags.value.push(inputValue.value)
  }
  inputVisible.value = false
  inputValue.value = ''
}

const initData: UserModel = {
  id: '',
  username: '',
  nickname: '',
  email: '',
  sex: '0',
  accountStatus: '1',
  roleId: '',
  roleName: '',
  password: ''
};

// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()
// 内容 HTML
const valueHtml = ref('<p>hello</p>')
const mode = ref('default')

const roleOptions = ref<RoleModel[]>([]);
// 表单参数
const editForm = reactive<any>({data: initData});
// 分页参数
const pageParam = ref<PageParam>({pageNo: 1, pageSize: 15, searchKey: ''});
// api返回的分页数据
const pageVo = ref<PageVO>({pageNo: 1, pageSize: 15, total: 0, records: []});
// 加载进度
const loading = ref<boolean>(true);
// 表单校验规则
const rules = reactive({
  title: [{required: true, min: 2, max: 30, message: '长度限制2~30', trigger: 'blur'}],
});

// 初始化数据
onMounted(() => {
  initTable();
});

// 监听当前页的变化
watch(
    () => [pageParam.value.pageNo, pageParam.value.pageSize], () => {
      initTable();
    }
)

/**
 * 初始化编辑数据
 * @param row
 */
const edit = (row: any): void => {
  if (row) {
    editForm.data = row;
  }
}

/**
 * 初始化新增数据
 */
const initAdd = (): void => {
  editForm.data = initData;
}

const toolbarConfig = {}
const editorConfig = {placeholder: '请输入内容...'}

// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor: any) => {
  editorRef.value = editor;
}

/**
 * 刷新
 */
const refresh = (): void => {
  pageParam.value.pageNo = 1;
  pageParam.value.pageSize = 15;
  pageParam.value.searchKey = '';
  setTimeout(initTable, 200);
}

/**
 * 单个移除
 * @param row
 */
const remove = (row: any) => removeBatch([row.id]);

/**
 * 初始化数据
 */
const initTable = () => {
  // 渲染数据
  if (!loading.value) {
    loading.value = true;
  }
  let param = {
    pageNo: pageParam.value.pageNo,
    pageSize: pageParam.value.pageSize,
    userVO: {nickname: pageParam.value.searchKey, username: pageParam.value.searchKey}
  };
  reqCommonFeedback(listByPage(param), (data: any) => {
    pageVo.value.records = data.rows;
    pageVo.value.total = data.recordCount;
    loading.value = false;
  });
}

/**
 * 更新操作
 * @param formEl 表单组件对象
 * @param callback 回调函数，调用就会关闭对话框
 */
const doUpdate = (formEl: any, callback: Function): void => {
  formEl.validate((valid: any) => {
    if (valid) {
      if (!editForm.data.id) {
        // 新增
        reqSuccessFeedback(add(editForm.data), '新增成功', () => {
          initTable();
          callback();
        });
      } else {
        // 修改
        reqSuccessFeedback(update(editForm.data), '修改成功', () => {
          initTable();
          callback();
        });
      }
    }
  });
}

/**
 * 批量删除
 * @param ids
 */
const removeBatch = (ids: string[]) => {
  reqSuccessFeedback(deleteBatch(ids), '删除成功', () => {
    initTable();
  });
}
</script>

<style scoped></style>