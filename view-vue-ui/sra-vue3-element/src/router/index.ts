import {createRouter, createWebHistory} from "vue-router";
import Login from '@/views/system/login/Login.vue';
import Home from '@/views/system/dashboard/home/Home.vue';
import AdminLayout from '@/layout/AdminLayout.vue';
import MenuView from "@/views/system/manager/menu/MenuView.vue";
import UserView from "@/views/system/manager/user/UserView.vue";

const routes = [
    {
        path: "/login",
        name: "Login",
        meta: {title: '系统登录'},
        component: Login
    },
    {
        path: '/admin',
        name: 'Admin',
        meta: {title: '后台管理'},
        component: AdminLayout,
        children: [
            {path: 'home', meta: {title: '首页'}, name: 'Home', component: Home},
            {path: 'user-manager', meta: {title: '用户管理'}, name: 'UserView', component: UserView},
            {path: 'menu-manager', meta: {title: '菜单管理'}, name: 'MenuView', component: MenuView},
        ]
    }
]

export const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

/**
 * 路由守卫
 * to: Route: 即将要进入的目标 路由对象
 * from: Route: 当前导航正要离开的路由
 * next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数
 */
router.beforeEach((to, from, next) => {
    let userInfo = JSON.parse(`${localStorage.getItem("userInfo")}`);
    let isAuthenticated: boolean = userInfo ? userInfo.loginStatus : false;
    // 如果认证了直接跳转admin首页
    let index: string = "/admin/home";
    if (index != to.path && isAuthenticated) {
        next({path: index});
    }
    // 如果未认证且不是跳转登录页就重定向到登录页
    if (to.path !== '/login' && !isAuthenticated) {
        next({path: `/login?redirect=${encodeURI(to.path)}`});
    } else {
        next();
    }
})

router.afterEach(function (to, from) {
    let title = '';
    to.matched.forEach((item, index) => {
        let field = (index === to.matched.length - 1 ? '' : ' - ');
        title += item.meta.title + field;
    });
    // 动态刷新title
    if (title) {
        document.title = title;
    }
})

