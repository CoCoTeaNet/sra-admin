<template>
  <v-app id="home" class="pa-2">
    <v-row>
      <v-col><system-count/></v-col>
    </v-row>

    <!-- 图表 -->
    <v-row>
      <v-col><disk-chart :loading="loading" :data="diskData"/></v-col>
      <v-col><timeline-chart/></v-col>
    </v-row>

    <v-row>
      <v-col><system-info :loading="loading" :items="systemInfoList"/></v-col>
      <v-col><weather-info/></v-col>
    </v-row>

    <v-row>
      <v-col><version-timeline/></v-col>
      <v-col></v-col>
    </v-row>
  </v-app>
</template>

<script>
import SystemInfo from "@/views/system/home/modules/system-info";
import SystemCount from "@/views/system/home/modules/system-count";
import WeatherInfo from "@/views/system/home/modules/weather-info";
import DiskChart from "@/views/system/home/modules/disk-chart";
import TimelineChart from "@/views/system/home/modules/timeline-chart";
import VersionTimeline from "@/views/system/home/modules/version-timeline";
import {getSystemInfo} from "@/api/system/dashboard-api";

export default {
  name: "Home",
  components: {VersionTimeline, TimelineChart, DiskChart, WeatherInfo, SystemCount, SystemInfo},
  data: () => ({
    loading: true,
    // 系统信息
    systemInfoList: [],
    // 磁盘信息
    diskData: {}
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
          this.systemInfoList.push({text: `内存总大小: ${(res.data.memoryTotalSize / 1024 / 1024 / 1024).toFixed(2)}G`});
          this.systemInfoList.push({text: `已用内存: ${(res.data.memoryUsedSize / 1024 / 1024 / 1024).toFixed(2)}G`});

          this.diskData = {
            size: [
              {name: '可用大小', value: ((res.data.diskTotalSize-res.data.diskFreeSize) / 1024 / 1024 / 1024).toFixed(2)},
              {name: '剩余大小', value: (res.data.diskFreeSize / 1024 / 1024 / 1024).toFixed(2)}
            ],
            totalValue: (res.data.diskTotalSize / 1024 / 1024 / 1024).toFixed(2),
            diskPath: res.data.diskPath,
            diskSeparator: res.data.diskSeparator
          };
          // this.systemInfoList.push({text: `磁盘路径: ${res.data.diskPath}`});
          // this.systemInfoList.push({text: `磁盘分隔符: ${res.data.diskSeparator}`});
          this.loading = false;
        }
      });
    }
  }
}
</script>
