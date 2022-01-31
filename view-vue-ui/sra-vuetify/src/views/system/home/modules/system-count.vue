<template>
  <v-row>
    <v-col v-for="(item,index) in items" :key="index">
      <v-card>
        <v-card-title class="justify-center">{{item.title}}</v-card-title>
        <v-card-text class="text-center font-weight-medium" style="font-size: 1.5em">{{item.count}}</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import {getCount} from "@/api/system/dashboard-api";

export default {
  name: "system-count",
  data(){
    return{
      items: []
    }
  },
  created() {
    this.getCount();
  },
  methods: {
    getCount() {
      getCount().then(res => {
        if (res.code === 200) {
          this.items = res.data;
        }
      });
    }
  }
}
</script>
