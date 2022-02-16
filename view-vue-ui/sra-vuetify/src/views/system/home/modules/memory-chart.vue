<template>
  <v-card>
    <div class="text-center pa-2" v-if="loading">
      <v-progress-circular v-if="loading" indeterminate color="primary"></v-progress-circular>
    </div>
    <div :id="chartName" style="height: 276px"></div>
  </v-card>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: 'MemoryChart',
  props: {
    chartName: {type: String, required: true, default: ''},
    data: {type: Object, required: true, default: {}},
    loading: {type: Boolean, required: true, default: true},
    title: {type: String, required: true, default: ''}
  },
  watch: {
    loading(val) {
      if (!val) {
        this.init();
      }
    }
  },
  methods: {
    /**
     * 初始化图表
     */
    init() {
      let self = this;
      let chartDom = document.getElementById(self.chartName);
      let myChart = echarts.init(chartDom);
      let diskExpand = self.data.diskPath ? `路径: ${self.data.diskPath} 分隔符: ${self.data.diskSeparator}` : '';
      let option = {
        title: {
          text: `${self.title}使用情况`,
          subtext: `${self.title}总大小：${self.data.totalValue} GB ${diskExpand}`,
          left: 'center'
        },
        tooltip: {trigger: 'item', formatter: "{a} <br/>{b}: {c} GB ({d}%)"},
        legend: {orient: 'vertical', left: 'left'},
        series: [
          {
            name: `${self.title}总大小：${self.data.totalValue} GB`,
            type: 'pie',
            radius: ['0', '65%'],
            avoidLabelOverlap: false,
            label: {show: false, position: 'center'},
            labelLine: {show: false},
            data: self.data.size
          }
        ],
      };
      option && myChart.setOption(option);
    }
  }
}
</script>
