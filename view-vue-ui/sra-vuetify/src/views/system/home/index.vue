<template>
  <v-app id="home" class="pa-2">
    <v-row>
      <v-col><system-count/></v-col>
    </v-row>

    <!-- 图表 -->
    <v-row>
      <v-col><platform-chart/></v-col>
      <v-col><timeline-chart/></v-col>
    </v-row>

    <v-row>
      <v-col><system-info/></v-col>
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
import PlatformChart from "@/views/system/home/modules/platform-chart";
import TimelineChart from "@/views/system/home/modules/timeline-chart";
import VersionTimeline from "@/views/system/home/modules/version-timeline";

export default {
  name: "Home",
  components: {VersionTimeline, TimelineChart, PlatformChart, WeatherInfo, SystemCount, SystemInfo},
  data: () => ({
  }),
}
</script>
