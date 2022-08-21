import {createApp} from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import {router} from './router'
import { store, key } from './store'
import * as ElIcons from '@element-plus/icons-vue'
import 'highlight.js/styles/atom-one-dark.css'
import 'highlight.js/lib/common'
import hljsVuePlugin from '@highlightjs/vue-plugin'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

const app = createApp(App)

// 统一注册Icon图标
for (const name in ElIcons){
    app.component(name,(ElIcons as any)[name])
}
app.use(router)
app.use(store, key)
app.use(hljsVuePlugin)
app.use(ElementPlus, {locale: zhCn})
app.mount('#app')
