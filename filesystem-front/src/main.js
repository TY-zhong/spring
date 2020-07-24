import Vue from 'vue'
import App from './App.vue'
import router from './router'
import {Toast} from 'vant'
import {get, post} from './global/http.js'

Vue.prototype.$get = get
Vue.prototype.$post = post
Vue.prototype.$toast = Toast

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
