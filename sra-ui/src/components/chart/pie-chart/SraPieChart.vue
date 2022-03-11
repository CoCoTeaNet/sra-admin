<template>
  <div :id="spcId" :style="`height: ${300}px`"></div>
</template>

<script setup lang="ts">
import {onMounted, nextTick, toRefs} from "vue";
import * as echarts from "echarts";

onMounted(() => {
  nextTick(() => {
    init();
  })
});

interface Title {
  text: string,
  subtext: string,
  left: string
}

const props = withDefaults(
    defineProps<{
      height: number,
      name: string,
      data: [],
      left?: string,
      orient?: string,
      title?: Title,
      spcId: string
    }>(), {
      height: 300,
      left: 'left',
      orient: 'vertical',
      title: {
        text: '',
        subtext: '',
        left: ''
      }
    }
);

const init = () => {
  let {name, data, left, orient, title, spcId} = toRefs(props);
  let chartDom = document.getElementById(spcId.value);
  let myChart = echarts.init(chartDom);
  let option = {
    title: title.value,
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: orient.value,
      left: left.value
    },
    series: [
      {
        name: name.value,
        type: 'pie',
        radius: '50%',
        data: data.value,
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  };
  option && myChart.setOption(option);
}
</script>

<style scoped src="./css/SraPieChart.css"></style>