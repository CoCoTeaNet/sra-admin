import {createRouter, createWebHashHistory} from "vue-router";
import Login from '@/views/system/Login.vue';
import Home from '@/views/system/dashboard/Home.vue';
import AdminLayout from '@/layout/AdminLayout.vue';

const routes = [
    {
        path: '/admin',
        name: 'Admin',
        component: AdminLayout,
        children: [
            {path: 'home', name: 'Home', component: Home}
        ]
    },
    {
        path: "/login",
        name: "Login",
        component: Login
    }
]

export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})
