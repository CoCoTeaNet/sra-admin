import VueRouter from 'vue-router';
import Vue from 'vue';
import store from '@/store';

Vue.use(VueRouter);

/**
 * 路由配置
 */
const routes = [
    { path: '/login', component: () => import('@/layout/login-layout') },
    {
        path: '/admin',
        component: () => import('@/layout/admin-layout'),
        children: [
            { path: 'menu', component: () => import('@/views/system/menu/index') }
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

/**
 * 路由守卫
 * to: Route: 即将要进入的目标 路由对象
 * from: Route: 当前导航正要离开的路由
 * next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数
 */
router.beforeEach((to, from, next) => {
    let isAuthenticated = store.state.user.userInfo ? store.state.user.userInfo.loginStatus : null;
    let adminFlag = /\/admin\/*/.test(to.path);
    // 如果认证了直接跳转admin首页
    if (!adminFlag && isAuthenticated) {
        next({ path: '/admin' });
    }
    // 如果未认证且不是跳转登录页就重定向到登录页
    if (to.path !== '/login' && !isAuthenticated) {
        next({ path: `/login?from=${encodeURI(to.path)}`});
    } else {
        next();
    }
})

export default router;