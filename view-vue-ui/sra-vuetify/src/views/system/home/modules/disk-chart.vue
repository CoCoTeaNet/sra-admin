<template>
  <v-card>
    <div class="text-center pa-2" v-if="loading">
      <v-progress-circular v-if="loading" indeterminate color="primary"></v-progress-circular>
    </div>
    <div id="diskChart" style="height: 276px"></div>
    <div v-if="!loading" style="position: relative;bottom: 0;text-align: center;color: #757575;">
      {{ `路径: ${data.diskPath ? data.diskPath : ''}   分隔符: ${data.diskSeparator ? data.diskSeparator : ''}` }}
    </div>
  </v-card>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: 'DiskChart',
  props: {
    data: {type: Object, required: true, default: {}},
    loading: {type: Boolean, required: true, default: true}
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
      let chartDom = document.getElementById('diskChart');
      let myChart = echarts.init(chartDom);
      let option = {
        title: {
          text: '磁盘使用情况',
          subtext: `磁盘总大小：${self.data.totalValue} GB`,
          left: 'center'
        },
        tooltip: {trigger: 'item', formatter: "{a} <br/>{b}: {c} GB ({d}%)"},
        legend: {orient: 'vertical', left: 'left'},
        series: [
          {
            name: `磁盘总大小：${self.data.totalValue} GB`,
            type: 'pie',
            radius: ['40%', '70%'],
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
