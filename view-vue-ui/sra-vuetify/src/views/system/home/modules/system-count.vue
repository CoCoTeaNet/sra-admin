<template>
  <v-row>
    <v-col v-for="(item,index) in items" :key="index">
      <v-card :color="item.color">
        <v-card-title class="justify-center">{{ item.title }}</v-card-title>
        <v-card-text class="text-center font-weight-medium" style="font-size: 1.5em">{{ item.count }}</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import {getCount} from "@/api/system/dashboard-api";

export default {
  name: "system-count",
  data() {
    return {
      items: [],
      timer: null
    }
  },
  created() {
    let self = this;
    self.getCount();
    self.timer = setInterval(() => {
      self.getCount();
    }, 30000);
  },
  beforeDestroy() {
    this.clearTimer();
  },
  watch: {
    $route: {
      handler(v, v1) {
        console.log(v, v1)
      },
      deep: true
    }
  },
  methods: {
    getCount() {
      getCount().then(res => {
        if (res.code === 200) {
          let items = res.data;
          items.forEach((i, index) => {
            if (index === 0) {
              i.color = 'grey lighten-4';
            } else if (index === 1) {
              i.color = 'grey lighten-4';
            } else if (index === 2) {
              i.color = 'grey lighten-4';
            } else if (index === 3) {
              i.color = 'grey lighten-4';
            }
          });
          this.items = items;
        }
      });
    },
    clearTimer() {
      clearInterval(this.timer);
      this.timer = null;
    }
  }
}
</script>
