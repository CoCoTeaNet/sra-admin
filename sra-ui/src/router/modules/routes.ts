import Login from "@/views/system/login/Login.vue";
import AdminLayout from "@/layout/AdminLayout.vue";
import Home from "@/views/system/dashboard/home/Home.vue";
import UserView from "@/views/system/manager/user/UserView.vue";
import MenuView from "@/views/system/manager/menu/MenuView.vue";
import DictionaryView from "@/views/system/manager/dictionary/DictionaryView.vue";
import PermissionView from "@/views/system/manager/menu/PermissionView.vue";
import RoleView from "@/views/system/manager/role/RoleView.vue";
import Dashboard from "@/views/system/dashboard/Dashboard.vue";
import NotFound from "@/views/error/NotFound.vue";
import UserCenterView from "@/views/system/personal/UserCenterView.vue";
import CodeGenerator from "@/views/system/sys-util/CodeGenerator.vue";
import OperationLogView from "@/views/system/manager/operation-log/OperationLogView.vue";
import ArticleListView from "@/views/system/manager/cms/ArticleListView.vue";

export const routes = [
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
        redirect: {name: 'Home'},
        children: [
            {path: 'home', meta: {title: '首页'}, name: 'Home', component: Home},
            {path: 'dashboard', meta: {title: '仪表盘'}, name: 'Dashboard', component: Dashboard},
            {path: 'user-manager', meta: {title: '用户管理'}, name: 'UserView', component: UserView},
            {path: 'menu-manager', meta: {title: '菜单管理'}, name: 'MenuView', component: MenuView},
            {path: 'permission-manager', meta: {title: '权限管理'}, name: 'PermissionView', component: PermissionView},
            {path: 'role-manager', meta: {title: '角色管理'}, name: 'RoleView', component: RoleView},
            {path: 'dictionary-manager', meta: {title: '字典管理'}, name: 'DictionaryView', component: DictionaryView},
            {path: 'operation-log-manager', meta: {title: '日志管理'}, name: 'OperationLogView', component: OperationLogView},
            {path: 'user-center', meta: {title: '用户中心'}, name: 'UserCenterView', component: UserCenterView},
            {path: 'code-generator', meta: {title: '代码生成'}, name: 'CodeGenerator', component: CodeGenerator},
            {path: 'article-list', meta: {title: '文章列表'}, name: 'ArticleListView', component: ArticleListView}
        ]
    },
    {
        path: '/:pathMatch(.*)',
        name: 'error',
        component: NotFound,
        meta: {title: '404'},
    }
];