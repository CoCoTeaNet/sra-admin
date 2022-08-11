<template>
  <el-dialog v-model="show" title="新增文章" width="75%">
    <el-form style="max-height: 600px">
      <el-form-item prop="username" label="标题">
        <el-input v-model="dataForm.title"></el-input>
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
              v-model="dataForm.content"
              :defaultConfig="editorConfig"
              @onCreated="handleCreated"
          />
        </div>
      </el-form-item>
      <el-form-item prop="username" label="标签">
        <el-tag
            v-for="tag in dynamicTags"
            :key="tag"
            style="margin-right: 3px"
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
            size="small"
            @keyup.enter="handleInputConfirm"
            @blur="handleInputConfirm"
        />
        <el-button v-else size="small" @click="showInput">
          + 新增
        </el-button>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="onCancel">取 消</el-button>
        <el-button type="primary" @click="onConfirm">确 认</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import '@wangeditor/editor/dist/css/style.css';
import {onBeforeUnmount, ref, shallowRef, onMounted, reactive, nextTick} from 'vue';
import {Editor, Toolbar} from '@wangeditor/editor-for-vue';
import {ElInput} from 'element-plus';
import {add} from '@/api/cms/article-api';
import {reqCommonFeedback} from "@/api/ApiFeedback";

const props = withDefaults(defineProps<{
  show?: boolean
}>(), {
  show: false
});

const editorRef = shallowRef();
const mode = ref<string>('default');
const dataForm = reactive<any>({});
const inputValue = ref<string>('');
const dynamicTags = ref<any>(['默认']);
const inputVisible = ref<boolean>(false);
const InputRef = ref<InstanceType<typeof ElInput>>();

onMounted(() => {
  dataForm.content = '<p>请输入文章内容......</p>'
})

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

const emit = defineEmits(['update:show']);

const onCancel = () => emit('update:show', false);

const onConfirm = () => {
  let param = {title: dataForm.title, content: dataForm.content, tags: dynamicTags.value};
  reqCommonFeedback(add(param), () => {
    emit('update:show', false);
  });
}

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
</script>

<style scoped>
</style>