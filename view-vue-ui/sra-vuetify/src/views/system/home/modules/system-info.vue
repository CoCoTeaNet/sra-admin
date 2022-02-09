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
import {getSystemInfo} from "@/api/system/dashboard-api";

/**
 * 展示系统信息
 */
export default {
  name: 'SystemInfo',
  data: () => ({
    items: [],
    loading: true
  }),
  created() {
    this.getSystemInfo();
  },
  methods: {
    getSystemInfo() {
      getSystemInfo().then(res => {
        if (res.code === 200) {
          this.items.push({text: `操作系统: ${res.data.os}`});
          this.items.push({text: `服务器名称: ${res.data.serverName}`});
          this.items.push({text: `服务器IP: ${res.data.serverIp}`});
          this.items.push({text: `系统架构: ${res.data.serverArchitecture}`});
          this.items.push({text: `Java名称: ${res.data.javaName}`});
          this.items.push({text: `Java版本: ${res.data.javaVersion}`});
          this.items.push({text: `java安装路径: ${res.data.javaPath}`});
          this.items.push({text: `项目路径: ${res.data.projectPath}`});
          this.items.push({text: `服务运行时长: ${res.data.runningTime} 秒`});
          this.items.push({text: `CPU系统使用率: ${res.data.cpuSystemUsed}`});
          this.items.push({text: `CPU用户使用率: ${res.data.cpuUserUsed}`});
          this.items.push({text: `CPU空闲率: ${res.data.cpuFree}`});
          this.items.push({text: `CPU核心数: ${res.data.cpuCount} 个`});
          this.items.push({text: `内存总大小: ${(res.data.memoryTotalSize / 1024 / 1024 / 1024).toFixed(2)}G`});
          this.items.push({text: `已用内存: ${(res.data.memoryUsedSize / 1024 / 1024 / 1024).toFixed(2)}G`});
          this.items.push({text: `磁盘总大小: ${(res.data.diskTotalSize / 1024 / 1024 / 1024).toFixed(2)}G`});
          this.items.push({text: `磁盘剩余大小: ${(res.data.diskFreeSize / 1024 / 1024 / 1024).toFixed(2)}G`});
          this.items.push({text: `磁盘路径: ${res.data.diskPath}`});
          this.items.push({text: `磁盘分隔符: ${res.data.diskSeparator}`});
          this.loading = false;
        }
      });
    },
  }
}
</script>
