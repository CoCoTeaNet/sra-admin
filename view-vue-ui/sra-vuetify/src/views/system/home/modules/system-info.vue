<template>
  <v-card class="mx-auto" tile>
    <v-list dense>
      <v-subheader>系统信息</v-subheader>
      <v-list-item-group color="primary">
        <div class="text-center">
          <v-progress-circular v-if="loading" indeterminate color="primary"></v-progress-circular>
        </div>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-content>
            <v-list-item-title v-text="item.text"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>

<script>
/**
 * 展示系统信息
 */
export default {
  name: 'SystemInfo',
  props: {
    items: {type: Array, required: true, default: []},
    loading: {type: Boolean, required: true, default: true}
  },
  mounted() {
    this.$emit('onFinish');
  }
}
</script>
