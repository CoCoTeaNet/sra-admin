<template>
  <v-app id="home" class="pa-2">
    <v-row>
      <v-col>
        <system-count/>
      </v-col>
    </v-row>

    <!-- 图表 -->
    <v-row>
      <v-col>
        <system-info :loading="loading" :items="systemInfoList"/>
      </v-col>
      <v-col>
        <memory-chart :loading="loading" :data="diskData" chart-name="diskChart" title="磁盘"/>
        <v-divider class="pa-3"></v-divider>
        <memory-chart :loading="loading" :data="memoryData" chart-name="memoryChart" title="内存"/>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <version-timeline/>
      </v-col>
      <v-col></v-col>
    </v-row>
  </v-app>
</template>

<script>
import SystemInfo from "@/views/system/home/modules/system-info";
import SystemCount from "@/views/system/home/modules/system-count";
import VersionTimeline from "@/views/system/home/modules/version-timeline";
import {getSystemInfo} from "@/api/system/dashboard-api";
import MemoryChart from "@/views/system/home/modules/memory-chart";

export default {
  name: "Home",
  components: {MemoryChart, VersionTimeline, SystemCount, SystemInfo},
  data: () => ({
    loading: true,
    // 系统信息
    systemInfoList: [],
    // 磁盘信息
    diskData: {},
    // 内存信息
    memoryData: {}
  }),
  created() {
    this.getSystemInfo();
  },
  methods: {
    /**
     * 获取系统信息
     */
    getSystemInfo() {
      getSystemInfo().then(res => {
        if (res.code === 200) {
          this.systemInfoList.push({text: `操作系统: ${res.data.os}`});
          this.systemInfoList.push({text: `服务器名称: ${res.data.serverName}`});
          this.systemInfoList.push({text: `服务器IP: ${res.data.serverIp}`});
          this.systemInfoList.push({text: `系统架构: ${res.data.serverArchitecture}`});
          this.systemInfoList.push({text: `Java名称: ${res.data.javaName}`});
          this.systemInfoList.push({text: `Java版本: ${res.data.javaVersion}`});
          this.systemInfoList.push({text: `java安装路径: ${res.data.javaPath}`});
          this.systemInfoList.push({text: `项目路径: ${res.data.projectPath}`});
          this.systemInfoList.push({text: `服务运行时长: ${res.data.runningTime} 秒`});
          this.systemInfoList.push({text: `CPU系统使用率: ${res.data.cpuSystemUsed}`});
          this.systemInfoList.push({text: `CPU用户使用率: ${res.data.cpuUserUsed}`});
          this.systemInfoList.push({text: `CPU空闲率: ${res.data.cpuFree}`});
          this.systemInfoList.push({text: `CPU核心数: ${res.data.cpuCount} 个`});

          // 内存数据
          this.memoryData = {
            memoryTotalSize: parseInt(res.data.memoryTotalSize / 1024 / 1024),
            size: [
              {name: '可用大小', value: (res.data.memoryAvailableSize / 1024 / 1024 / 1024).toFixed(2)},
              {
                name: '剩余大小',
                value: ((res.data.memoryTotalSize - res.data.memoryAvailableSize) / 1024 / 1024 / 1024).toFixed(2)
              }
            ],
            totalValue: (res.data.memoryTotalSize / 1024 / 1024 / 1024).toFixed(2),
          }

          // 磁盘数据
          this.diskData = {
            size: [
              {name: '已用大小', value: ((res.data.diskTotalSize - res.data.diskFreeSize) / 1024 / 1024 / 1024).toFixed(2)},
              {name: '剩余大小', value: (res.data.diskFreeSize / 1024 / 1024 / 1024).toFixed(2)}
            ],
            totalValue: (res.data.diskTotalSize / 1024 / 1024 / 1024).toFixed(2),
            diskPath: res.data.diskPath,
            diskSeparator: res.data.diskSeparator
          };
          this.loading = false;
        }
      });
    }
  }
}
</script>
