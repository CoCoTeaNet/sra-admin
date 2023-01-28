const AdminLayout = () => import("@/layout/AdminLayout.vue");
const Home = () => import("@/views/system/dashboard/home/Home.vue");
const UserView = () => import("@/views/system/manager/system/user/UserView.vue");
const MenuView = () => import("@/views/system/manager/system/menu/MenuView.vue");
const DictionaryView = () => import("@/views/system/manager/system/dictionary/DictionaryView.vue");
const PermissionView = () => import("@/views/system/manager/system/menu/PermissionView.vue");
const RoleView = () => import("@/views/system/manager/system/role/RoleView.vue");
const Dashboard = () => import("@/views/system/dashboard/Dashboard.vue");
const NotFound = () => import("@/views/error/NotFound.vue");
const UserCenterView = () => import("@/views/system/personal/UserCenterView.vue");
const OperationLogView = () => import("@/views/system/manager/system/log/OperationLogView.vue");
const ArticleListView = () => import("@/views/system/manager/cms/ArticleListView.vue");
const CommentView = () => import("@/views/system/manager/cms/CommentView.vue");
const JobView = () => import("@/views/system/manager/schedule/JobView.vue");
const JobLogView = () => import("@/views/system/manager/schedule/JobLogView.vue");
const VersionView = () => import("@/views/system/manager/system/version/VersionView.vue");
const SysFileView = () => import("@/views/system/manager/system/file/SysFileView.vue");
const RecycleBinView = () => import("@/views/system/manager/system/file/RecycleBinView.vue");
const Login = () => import("@/views/system/login/Login.vue");

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
            {path: 'article-list', meta: {title: '文章列表'}, name: 'ArticleListView', component: ArticleListView},
            {path: 'comment-manager', meta: {title: '评论管理'}, name: 'CommentView', component: CommentView},
            {path: 'job-manager', meta: {title: '任务管理'}, name: 'JobView', component: JobView},
            {path: 'JobLog-manager', meta: {title: '调度记录'}, name: 'JobLogView', component: JobLogView},
            {path: 'version-manager', meta: {title: '版本管理'}, name: 'VersionView', component: VersionView},
            {path: 'sysFile-manager', meta: {title: '文件管理'}, name: 'SysFileView', component: SysFileView},
            {path: 'recycleBin-manager', meta: {title: '文件回收站'}, name: 'RecycleBinView', component: RecycleBinView},
        ]
    },
    {
        path: '/:pathMatch(.*)',
        name: 'error',
        component: NotFound,
        meta: {title: '404'},
    }
];