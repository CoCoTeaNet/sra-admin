create table sys_version
(
    ID            varchar(32)  not null
        primary key,
    UPDATE_NO     varchar(20)  null comment '更新版本号',
    UPDATE_DESC   varchar(900) null comment '版本更新描述',
    PLATFORM_NAME varchar(10)  null comment '系统平台名称',
    DOWNLOAD_URL  varchar(200) null comment '下载地址',
    CREATE_BY     varchar(32)  not null comment '创建人',
    CREATE_TIME   datetime     not null comment '创建时间',
    UPDATE_BY     varchar(32)  not null comment '更新人',
    UPDATE_TIME   datetime     not null comment '更新时间'
)
    comment '系统版本更新记录表' engine = InnoDB;

INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('1fc2b2e8b759487eb5d24a18da766724', 'v1.0.2', '1. 修复已知BUG & 优化UI.
2. 新增字典表维护.
3. 补充权限缓存以及角色鉴权.
4. 后台系统新增实体类代码生成器.
5. 增加操作日志功能.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 00:45:15', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:23');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('235d7f32012145b8a7aa6e82c2fd1b3b', 'v1.1.1', '1. 修复已知BUG.
2. 优化UI界面.
3. 更改是否枚举标识.
4. 优化任务调度代码.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:08:54', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:09:34');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('2add0d3910f640a3876009e49ad93494', 'v1.1.0', '1. 修复已知BUG.
2. 新增CMS模块.
3. 新增任务调度模块.
4. 更改GAV,优化UI界面.
5. 移除swagger.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:05:43', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:06:25');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('3c882adf3ea040cfb32daf5fb0d11812', 'v1.1.3', '1.新增VO实体类代码生成；
2.新增版本号管理功能；', 'web', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:14:09', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:14:09');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('503e3cc107fd4e2991d8cf1423bbd4e6', 'v1.1.2', '1. 修复文件上传XSS安全漏洞.
2. 增加图片上传格式限制.
3. 升级springboot到2.7.4版本
4. 升级mysql连接器到8.0.30版本', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:10:07', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-12-06 14:08:37');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('6830f35c6dd44140b590278c6d155c0d', 'v1.2.5', '1.readme添加支持者
2.优化管理页面代码模板
3.优化调度任务的实例创建过程，优先考虑是否存在于Spring容器，无法找到相应的实例再通过反射进行创建
4.主题新增重置功能
5.统一系统管理模块表单样式', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-03-13 02:19:23', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-04-14 06:55:24');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('69bbbe02152246b79b5cad88aaf00620', 'v1.2.4', '1、新增主题切换功能
2、修复弹窗异常
3、优化Admin头部UI
4、升级elementui到v2.2.13
5、升级hutool到v5.8.12', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-02-25 17:51:10', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-02-25 17:51:10');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('6ee72c610c7d4d47bc1db567cebbaeac', 'v1.0.1', '基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。                   是一款前后端分离、开箱即用的后台权限管理系统。', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-29 23:06:36', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:27');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('7b96a830cee145888051e6959e3617ae', 'v1.2.7', '1、优化退出登录，会话失效的情况直接返回退出登录成功；
2、优化登录时服务未启动导致一直loading；
3、更正某些不规范的VO命名；
4、优化表单管理组件，固定头部和底部；
5、更改vue弃用的v-deep方法，改成:deep；
6、优化登录功能“记住我”模式；
7、移除代码生成器；', 'web-pc', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-06-25 06:09:38', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-06-25 06:09:38');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('9b2e3509d0af41989f84acfe03b81ee0', 'v1.2.1', '1.优化UI界面
2.新增文件管理功能
3.新增代码生成器插件
4.更改代码结构', 'web', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-04 05:47:07', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-04 05:47:07');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('a011cceb21ba4c1ba47e8ffcd769509a', 'v1.2.8', '1.修复用户中心菜单跳转失效问题
2.修复日志打印意外错误异常堆栈信息
3.移除DataBaseTypeConstant和JavaTypeConstant
4.指定打包编码，解决maven打包出现的警告
5.各个模块命名统一规范
6.修复任务调度执行结果查询无效
7.修复退出登录时主题未回复初始状态
8.全局更新数据配置未登录策略判断
9.优化用户密码修改
10.maven依赖升级sqltoy到5.2.54
11.添加依赖sqltoy-plus
12.调度任务添加和更新时加入Cron表达式校验
13.移除注解控制任务是否并发执行，使用字段控制并发执行
14.优化任务初始化与执行流程 (1) 任务参数将在初始化时被解析 (2) 类模式与函数模式分类封装 (3) 任务参数支持以数组类型JSON来映射方法内的参数
15.修复任务调度添加/更新时查询任务信息未带出是否允许并发执行字段问题', 'web-pc', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-07-13 09:41:40', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-07-13 09:41:40');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('a12bda5f1d344770babb79c35262ccd7', 'v1.2.6', '1.修复菜单根菜单无法激活bug；
2.指定tinyInt1isBit=false避免返回的tinyint(1)是Boolean类型；
3.修复新增用户时角色ID参数拦截异常；
4.用户路由拦截优化；
5.修复登录信息缓存BUG；
6.jdbc url备注时区信息；
7.新增常用工具类；
8.Is枚举名称更改；
9.删除命名转换工具类；', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-05-11 06:11:45', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-05-11 06:11:45');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('d4b60c17d49248748d27a8332d9d02d5', 'v1.0.3', '1. 修复已知BUG.
2. 新增CMS模块.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:17', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:07:54');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('db5b460ed2f2467996933506867fb5f4', 'v1.2.3', '1.优化系统角色(增加多角色)
2.优化更改用户密码为非必填项
3.修复编辑用户title显示异常问题
4.优化用户管理页UI
5.优化前端项目打包策略', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-27 08:57:01', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-28 14:55:18');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('fe090de822264705850ea99faf05c831', 'v1.2.2', '1. 修复maku-generator-boot-starter打包异常;
2. 优化头像上传;
3. 修复手动执行任务日志丢失BUG;
4. 优化任务管理页面;', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-18 15:28:31', '7d7f2f72dd0e4b6080373a3cc1469a15', '2023-01-18 15:28:31');
