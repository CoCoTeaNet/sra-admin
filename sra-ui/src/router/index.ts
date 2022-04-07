import {createRouter, createWebHashHistory} from "vue-router";
import {routes} from "@/router/modules/routes";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

/**
 * 路由守卫
 * to: Route: 即将要进入的目标 路由对象
 * from: Route: 当前导航正要离开的路由
 * next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数
 */
router.beforeEach((to: any, from: any, next: any) => {
    let userInfo = JSON.parse(`${localStorage.getItem("userInfo")}`);
    let isAuthenticated: boolean = userInfo ? userInfo.loginStatus : false;
    // 如果认证了直接跳转admin首页
    if ('/' == to.path && isAuthenticated) {
        next({path: "/admin/home"});
    }
    // 如果未认证且不是跳转登录页就重定向到登录页
    if (to.path !== '/login' && !isAuthenticated) {
        next({path: `/login?redirect=${encodeURIComponent(from.path)}`});
    }
    next();
})

router.afterEach(function (to: any, from: any) {
    let title = '';
    to.matched.forEach((item: any, index: any) => {
        let field = (index === to.matched.length - 1 ? '' : ' - ');
        title += item.meta.title + field;
    });
    // 动态刷新title
    if (title) {
        document.title = title;
    }
})
