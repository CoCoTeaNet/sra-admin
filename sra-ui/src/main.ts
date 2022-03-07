import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import {router} from './router'
import { store, key } from './store'
import * as ElIcons from '@element-plus/icons-vue'

const app = createApp(App)

// 统一注册Icon图标
for (const name in ElIcons){
    app.component(name,(ElIcons as any)[name])
}

app.use(router)
app.use(ElementPlus)
app.use(store, key)
app.mount('#app')
