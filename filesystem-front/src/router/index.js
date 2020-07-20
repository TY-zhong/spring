import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

import AlbumList from '../pages/album/AlbumList'
import Index from '../pages/index'

let router = new VueRouter({
    routes: [
        {
            path: '/',
            redirect: '/index'
        },
        {
            path: '/index',
            component: Index
        },
        {
            path: '/albumlist',
            component: AlbumList
        }
    ]
});

export default router
