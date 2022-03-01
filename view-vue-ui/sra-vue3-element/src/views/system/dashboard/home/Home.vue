<template>
  <div class="bg">
    <sra-pie-chart :height="300" name="PeiName" :data="da" left="left" orient="vertical" :title="title"/>
  </div>
</template>

<script setup lang="ts">
import SraPieChart from "@/components/chart/pie-chart/SraPieChart.vue";
import {useStore} from "@/store";
import {ref} from "vue";

const title = {
  text: 'TitleText',
  subtext: 'title subtext',
  left: 'center'
}

const da = [
  {value: 1048, name: 'Search Engine'},
  {value: 735, name: 'Direct'},
  {value: 580, name: 'Email'},
  {value: 484, name: 'Union Ads'},
  {value: 300, name: 'Video Ads'}
]

const store = ref(useStore());

</script>

<style scoped src="./css/Home.css"></style>