import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import * as ElIcons from '@element-plus/icons-vue'
import router from '@/router/index'
import store from '@/store'
import App from './App.vue'

const app = createApp(App)

// 统一注册Icon图标
for (const name in ElIcons) {
    app.component(name, ElIcons[name])
}

app.use(router)
app.use(ElementPlus)
app.use(store)

app.mount('#app')
