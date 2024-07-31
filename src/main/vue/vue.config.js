const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../resources/static', // Build Directory
  devServer: {
    proxy: 'http://localhost:8085' // Spring Boot Server
  }
})