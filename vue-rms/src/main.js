// Vue
import Vue from 'vue'
import App from './App'
// store
//import store from '@/store/index'
// 多国语
import i18n from './i18n'
// 核心插件
import d2Admin from '@/plugin/d2admin'
// 菜单和路由设置
import router from './router'
import menuHeader from '@/menu/header'
import menuAside from '@/menu/aside'
import {frameInRoutes} from '@/router/routes'
import ElementUI from 'element-ui'
import store from "./store";
import 'element-ui/lib/theme-chalk/index.css'
import D2Crud from '@d2-projects/d2-crud'
import util from '@/libs/util.js'

import VCharts from 'v-charts'
import 'bootstrap';

Vue.use(ElementUI);
Vue.use(D2Crud);
Vue.use(VCharts);

import axios from 'axios'

Vue.prototype.$axios = axios;
axios.defaults.baseURL = 'http://127.0.0.1:8088';

axios.interceptors.request.use(
  config => {
    //请求带上token
    if (util.cookies.get('token')) {
      config.headers.Authorization='Bearer '+util.cookies.get('token')
    }
    return config
  },
  error => {
    // 发送失败
    console.log(error);
    Promise.reject(error)
  }
);
// 核心插件
Vue.use(d2Admin);
window.$ = window.jQuery = require('jquery');
new Vue({
  router,
  store,
  i18n,
  render: h => h(App),
  created() {
    axios.defaults.baseURL = 'http://127.0.0.1:8088';

    // 处理路由 得到每一级的路由设置
    this.$store.commit('d2admin/page/init', frameInRoutes);
    // 设置顶栏菜单
    this.$store.commit('d2admin/menu/headerSet', menuHeader);
    // 设置侧边栏菜单
    this.$store.commit('d2admin/menu/asideSet', menuAside);
    // 初始化菜单搜索功能
    this.$store.commit('d2admin/search/init', menuHeader);
    //在页面加载时读取localStorage里的状态信息
    localStorage.getItem("d2admin/menu/asideSet") && this.$store.replaceState(JSON.parse(localStorage.getItem("d2admin/menu/asideSet")));

    //在页面刷新时将vuex里的信息保存到localStorage里
    window.addEventListener("beforeunload",()=>{
      localStorage.setItem("d2admin/menu/asideSet",JSON.stringify(this.$store.state))
    })

  },
  mounted() {
    // 展示系统信息
    this.$store.commit('d2admin/releases/versionShow');
    // 用户登录后从数据库加载一系列的设置
    this.$store.dispatch('d2admin/account/load');
    // 获取并记录用户 UA
    this.$store.commit('d2admin/ua/get');
    // 初始化全屏监听
    this.$store.dispatch('d2admin/fullscreen/listen')
  }
}).$mount('#app');
