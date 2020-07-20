import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import {get, post} from './global/http.js'

Vue.prototype.$get = get
Vue.prototype.$post = post

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router: router
}).$mount('#app')
