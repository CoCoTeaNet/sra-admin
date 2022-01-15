import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from '@/router/index'
import store from './store'

Vue.config.productionTip = false

// 提前获取用户信息，判断是否有
let userInfo = localStorage.getItem("userInfo");
if (userInfo !== undefined) {
  store.commit('user/setUserInfo', JSON.parse(userInfo));
}

// 挂载组件
new Vue({
  router,
  vuetify,
  store,
  render: h => h(App)
}).$mount('#app')
