module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://127.0.0.1:7777/sra-api',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    },
    lintOnSave: false,   // 取消 eslint 验证
    transpileDependencies: [
        'vuetify'
    ]
}
