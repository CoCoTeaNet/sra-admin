<template>
  <v-card>
    <div class="text-center pa-2" v-if="loading">
      <v-progress-circular v-if="loading" indeterminate color="primary"></v-progress-circular>
    </div>
    <v-progress-circular
        v-if="!loading"
        :rotate="180"
        :size="100"
        :width="150"
        :value="parseInt((mData.memoryAvailableSize / mData.memoryTotalSize) * 100)"
        color="pink"
    >
      {{ `已用：${mData.memoryAvailableSize}MB，总大小：${mData.memoryTotalSize}MB` }}
      {{ parseInt((mData.memoryAvailableSize / mData.memoryTotalSize) * 100) + '%' }}
    </v-progress-circular>
  </v-card>
</template>

<script>
export default {
  name: "MemoryChart",
  props: {
    mData: {type: Object, required: true, default: {}},
    loading: {type: Boolean, required: true, default: true}
  },
}
</script>
