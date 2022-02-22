import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import {resolve} from 'path'

// https://vitejs.dev/config/
export default defineConfig({
    server:{
        proxy: {
            // 选项写法
            '/api': {
                target: 'http://127.0.0.1:7777/sra-api',
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, '')
            }
        }
    },
    resolve: {
        alias: [
            {find: '@', replacement: resolve(__dirname, 'src')},
            {find: /^~/, replacement: ''}
        ]
    },
    plugins: [
        vue(),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ]
})

