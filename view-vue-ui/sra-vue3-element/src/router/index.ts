import {createRouter, createWebHashHistory} from "vue-router";
import Login from '../components/Login.vue';

const routes = [
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
