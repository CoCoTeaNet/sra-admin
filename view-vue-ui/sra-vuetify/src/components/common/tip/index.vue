<template>
  <div class="text-center">
    <v-snackbar
        v-model="snackbar"
        :timeout="timeout"
        :color="color"
        rounded="pill"
        class="text-center"
        text
    >
      <div style="text-align: center">{{ text }}</div>
    </v-snackbar>
  </div>
</template>

<script>
export default {
  name: 'CommonTip',
  data: () => ({
    snackbar: false,
    text: '',
    timeout: 2000,
    color: ''
  }),
  methods: {
    /**
     * 显示提示
     * @param text 提示文本
     * @param timeout 超时：默认1500
     * @param color 提示颜色
     */
    showTip(text = 'tip show', timeout = 1500, color = 'success') {
      this.snackbar = true;
      this.text = text;
      this.timeout = timeout;
      this.color = color;
    },
    success(text = '成功', timeout = 1500) {
      this.showTip(text, timeout, 'success');
    },
    error(text = '失败', timeout = 1500) {
      this.showTip(text, timeout, 'error');
    },
    warn(text = '失败', timeout = 1500) {
      this.showTip(text, timeout, 'warn');
    }
  }
}
</script>