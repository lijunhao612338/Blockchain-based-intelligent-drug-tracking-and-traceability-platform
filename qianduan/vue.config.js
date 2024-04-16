const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
  
})

module.exports={
  publicPath:'/',
  devServer:{
    proxy: {               //代理请求路径
      /* 这个api就是main里面设置的Axios.defaults.baseURL = '/api' */
      '/api': {
        /* 设置对象路径 */
        target: "http://127.0.0.1:8080",
        /* 开启跨域 */
        changeOrigin:true,
        pathRewrite:{
          '^/api':''
        }
      }
    }
  }
}
