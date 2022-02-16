import VueRouter from 'vue-router';
import Vue from 'vue';
import store from '@/store';

// 解决vue-router路由版本更新产生的问题,导致路由跳转失败抛出该错误，但并不影响程序功能
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location, onResolve, onReject) {
    if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
    return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter);

/**
 * 路由配置
 */
const routes = [
    {path: '/login', meta:{title: '系统登录'}, component: () => import('@/layout/login-layout')},
    {
        path: '/admin',
        name: 'admin',
        meta:{title: 'Admin'},
        redirect: { name: 'dashboard' },
        component: () => import('@/layout/admin'),
        children: [
            {
                path: 'home',
                name: 'home',
                meta: {title: '首页'},
                component: () => import('@/layout/admin/modules/sys-home-layout'),
                children: [
                    {path: 'dashboard', name: 'dashboard', meta:{title: '仪表盘'}, component: () => import('@/views/system/home/index')},
                ]
            },
            {
                path: 'sys-manager',
                name: 'sys-manager',
                meta:{title: '系统管理'},
                redirect: { name: 'user' },
                component: () => import('@/layout/admin/modules/sys-manager-layout'),
                children: [
                    {path: 'menu', name: 'menu', meta:{title: '菜单管理'}, component: () => import('@/views/system/menu/index')},
                    {path: 'permission', name: 'permission', meta:{title: '权限管理'}, component: () => import('@/views/system/menu/permission-index')},
                    {path: 'role', name: 'role', meta:{title: '角色管理'}, component: () => import('@/views/system/role/index')},
                    {path: 'user', name: 'user', meta:{title: '用户管理'}, component: () => import('@/views/system/user/index')},
                ]
            },
            {
                path: 'sys-setting',
                name: 'sys-setting',
                meta:{title: '系统设置'},
                component: () => import('@/layout/admin/modules/sys-setting-layout')
            },
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
    if (!adminFlag && isAuthenticated || to.path === '/admin') {
        next({path: '/admin'});
    }
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
    if(title){
        document.title = title;
    }
})

export default router;