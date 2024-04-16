
import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '@/views/MyHome.vue'
import dealer from '@/views/MyDealer.vue'
import find from '@/views/MyFind.vue'
import manu from '@/views/MyManufacturer.vue'
import sup from '@/views/MySuppliers.vue'
import msg from '@/views/MyMessage.vue'
import edit from '../components/MyEdit.vue'
import axios from 'axios'
import addDealer from '../views/AddDealer.vue'
import addManu from '../views/AddManu.vue'
import addSup from '../views/AddSup.vue'
import editDealer from '../views/EditDealer.vue'
import editManu from '../views/EditManu.vue'
import editSup from '../views/EditSup.vue'
import login from '../views/LoginViews.vue'
Vue.use(VueRouter)
axios.defaults.baseURL="http://localhost:8080"
export default new VueRouter({
    routes:[
        
                {path:'/',component:login },
                {path:'/home',component:home },
                {path:'/dealer',component:dealer},
                {path:'/find',component:find},
                {path:'/manu',component:manu},
                {path:'/sup',component:sup},
                {path:'/msg',component:msg},
                {path:'/edit',component:edit},
                {path:"/addDealer",component:addDealer},
                {path:'/addManu',component:addManu},
                {path:'/addSup',component:addSup},
                {path:'/editDealer/index',component:editDealer},
                {path:'/editManu/index',component:editManu},
                {path:'/editSup/index',component:editSup},

    ]
})