import {createRouter, createWebHistory} from "vue-router";
import Login from '@/views/system/login/Login.vue';
import Home from '@/views/system/dashboard/home/Home.vue';
import AdminLayout from '@/layout/AdminLayout.vue';
import UserView from "@/views/system/manager/user/UserView.vue";

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
            {path: 'home', name: 'Home', component: Home},
            {path: 'manager-user', name: 'UserView', component: UserView}
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
    // let isAuthenticated = store.state.user.userInfo ? store.state.user.userInfo.loginStatus : null;
    let isAuthenticated: boolean = true;
    // let adminFlag = /\/admin\/*/.test(to.path);
    // 如果认证了直接跳转admin首页
    // if (!adminFlag && isAuthenticated || to.path === '/admin') {
    //     next({path: '/admin'});
    // }
    // 如果未认证且不是跳转登录页就重定向到登录页
    if (to.path !== '/login' && !isAuthenticated) {
        next({path: `/login?from=${encodeURI(to.path)}`});
    } else {
        next();
    }
})

router.afterEach(function (to, from) {
    let title = '';
    to.matched.forEach((item, index) => {
        title += item.meta.title + (index === to.matched.length - 1 ? '' : ' - ');
    });
    // 动态刷新title
    if (title) {
        document.title = title;
    }
})

