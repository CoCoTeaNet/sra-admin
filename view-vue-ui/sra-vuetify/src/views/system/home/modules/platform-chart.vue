<template>
  <div id="platformChart" style="height: 300px"></div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: 'PlatformChart',
  mounted() {
    let self = this;
    this.$nextTick(() => {
      self.init();
    });
  },
  methods: {
    /**
     * 初始化图表
     */
    init() {
      let chartDom = document.getElementById('platformChart');
      let myChart = echarts.init(chartDom);
      let option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              {value: 1048, name: 'Search Engine'},
              {value: 735, name: 'Direct'},
              {value: 580, name: 'Email'}
            ]
          }
        ]
      };

      option && myChart.setOption(option);
    }
  }
}
</script>
