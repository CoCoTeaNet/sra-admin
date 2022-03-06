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
    presets: [
        '@vue/cli-plugin-babel/preset'
    ]
}
