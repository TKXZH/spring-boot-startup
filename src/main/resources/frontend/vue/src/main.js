import Vue from 'vue'
import Index from './index.vue'
import './plugins/iview.js'
import axios from 'axios'
import qs from 'qs';


Vue.config.productionTip = false
Vue.prototype.axios = axios;
Vue.prototype.qs = qs;
new Vue({
  render: h => h(Index),
}).$mount('#app')
