<template>
  <el-select v-model="value" filterable remote reserve-keyword placeholder="请输入关键词"
      :remote-method="remoteMethod"
      :loading="loading"
  >
    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
      <div style="display: flex;align-items: center;">
        <el-space>
          <el-icon><component :is="item.value"></component></el-icon>
          <span>{{item.label}}</span>
        </el-space>
      </div>
    </el-option>
  </el-select>
</template>

<!-- todo bug: warn:Missing required prop: "value"  -->
<script lang="ts" setup>
import {ref} from 'vue'
import * as ElIcons from '@element-plus/icons-vue'

interface ListItem {
  value: string
  label: string
}

const list = ref<ListItem[]>([])
const options = ref<ListItem[]>([])
const loading = ref(false)

defineProps<{
  value: string
}>();

// 加载element图标
let l: ListItem[] = [];
for (const name in ElIcons) {
  l.push({value: name, label: name});
}
list.value = l;

/**
 * 查询列表图标
 * @param query
 */
const remoteMethod = (query: string) => {
  if (query) {
    loading.value = true
    setTimeout(() => {
      loading.value = false
      options.value = list.value.filter((item) => {
        return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
      })
    }, 200)
  } else {
    options.value = []
  }
}

</script>