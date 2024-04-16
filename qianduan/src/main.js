import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from 'vue-router';
import router from './router';
import axios from 'axios';
import Print from 'vue-print-nb'
import VueClipboard from 'vue-clipboard2'
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(Print);
Vue.use(VueClipboard);
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
axios.defaults.baseURL = ''
