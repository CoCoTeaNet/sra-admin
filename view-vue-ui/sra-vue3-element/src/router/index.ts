import {createRouter, createWebHashHistory} from "vue-router";
import Login from '@/views/system/login/Login.vue';
import Home from '@/views/system/dashboard/home/Home.vue';
import AdminLayout from '@/layout/AdminLayout.vue';

const routes = [
    {
        path: "/login",
        name: "Login",
        component: Login
    },
    {
        path: '/admin',
        name: 'Admin',
        component: AdminLayout,
        children: [
            {path: 'home', name: 'Home', component: Home}
        ]
    }
]

export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})
