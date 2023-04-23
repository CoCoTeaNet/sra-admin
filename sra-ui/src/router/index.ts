import {createRouter, createWebHashHistory, RouteLocationNormalized} from "vue-router";
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
router.beforeEach((to: RouteLocationNormalized, from: RouteLocationNormalized):boolean|object => {
    let userInfo = JSON.parse(`${localStorage.getItem("userInfo")}`);
    let isAuthenticated: boolean = userInfo ? userInfo.loginStatus : false;

    // 如果未认证且不是跳转登录页就重定向到登录页
    if (to.path !== '/login' && !isAuthenticated) {
        return {
            name: 'Login',
            query: {redirect: encodeURIComponent(from.path)}
        }
    }

    // 如果认证了直接跳转admin首页
    if ('/' == to.path && isAuthenticated) {
        return {path: "/admin/home"};
    }

    // 如果用户没有该菜单就自动跳到首页
    if (userInfo && userInfo.menuList) {
        let hasMenu: boolean = findMenu(userInfo.menuList, to.path);
        if (!hasMenu) {
            return {path: "/admin/home"};
        }
    }

    return true;
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

function findMenu(root: MenuModel[], target:string) {
    // 如果根节点为空，则返回false
    if (!root) {
        return false;
    }

    for (let index: number = 0; index < root.length; index++) {
        let element: MenuModel = root[index];
        let flag: boolean = element.routerPath === target;
        if (flag) {
            return true;
        } else {
            // 递归地搜索
            if (element.children) {
                const find: boolean = findMenu(element.children, target);
                if (find) {
                    return true;
                }
            }
        }
    }

    return false;
}
