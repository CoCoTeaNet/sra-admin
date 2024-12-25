## 更新日志


#### v2.0.11
- 变更 quickvo-maven-plugin升级到1.0.4
- 优化 本地quickvo.xml模板，增加自定义注释生成
- 修复 使用强密码时校验异常问题

#### v2.0.10
- 新增 项目启动时打印banner内容
- 变更 smart-doc框架升级到3.0.9


#### v2.0.9
- 新增 code-generator模块（Maven插件生成实体类）


#### v2.0.8
- 变更 springboot框架升级到 >> 3.3.5
- 变更 sagacity-sqltoy-spring-starter升级到 >> 5.6.22
- 变更 sqltoy-plus升级到 >> 5.6.22
- 变更 hutool升级到 >> 5.8.32
- 优化 增加NoResourceFoundException全局拦截
- 修复 500状态码时默认响应“ERROR”消息提示问题


#### v2.0.7
- 变更：springmvc默认的Tomcat容器改成Undertow
- 变更：spring-boot-starter升级至3.3.2
- 变更：sqltoy框架升级至5.6.20
- 变更：hutool框架升级到5.8.31
- 变更：bouncycastle升级到1.78
- 变更：mysql-connector升级到8.3.0
- 变更：logback升级到1.5.6
- 优化：Maven打包时指定includeScope为runtime（排除测试时的依赖，降低lib体积）


#### v2.0.6
- 新增：ApiPage模型增加create方法创建sqltoy的Page对象
- 新增：ApiPageDTO基础分页模型
- 新增：添加全局HttpRequestMethodNotSupportedException异常拦截
- 优化：系统操作日志列表接口-屏蔽多余参数
- 优化：获取字典树形列表接口-屏蔽多余参数
- 优化：系统文件管理分页接口-屏蔽多余参数
- 优化：系统菜单相关列表接口-屏蔽多余参数
- 优化：系统角色管理列表接口-屏蔽多余参数
- 优化：系统用户管理列表接口-屏蔽多余参数
- 优化：系统版本管理列表接口-屏蔽多余参数
- 优化：补充系统操作日志列表接口VO字段注释
- 优化：减少在线用户续期IO
- 修复：数据库表结构ddl脚本默认时间有误问题
- 修复：系统用户管理列表接口-邮箱查询失效问题


#### v2.0.5
- 新增：系统日志添加‘接口路径’保存字段
- 新增：系统日志添加@LogPersistence注解拦截存储
- 优化：系统日志查询列表默认根据id倒叙
- 优化：创建Logger实例增加static关键词
- 变更：初始化脚本变成ddl+data两个文件（PS：table_ddl.sql是表结构）


#### v2.0.4
1. 优化：前端界面优化（sra-admin-vue仓库）
2. 修复：私钥缓存失效问题


#### v2.0.3
1. 优化：验证码缓存键从ip改成用UUID标识
2. 优化：登陆成功删除验证码缓存
3. 变更：验证码接口方法post改成get
4. 新增：密码参数使用sm2加密传输


#### v2.0.2
1. 优化：接口访问限制如果不配置或者小于零表示不开启
2. 修复：使用@PathVariable增加别名，避免“Name for argument of type”异常
3. sqltoy-orm和sqltoy-plus升级到5.6.9
4. 删除MultiWrapper写法
5. 修复系统日志列表“日志编号”查询条件类型转换异常问题


#### v2.0.1
1. 修复validation引入异常问题
2. 优化异常日志打印
3. 路由放行测试接口
4. 增加MethodArgumentNotValidException异常拦截


#### v2.0.0
1. SpringBoot升到3.x并且相关核心框架保持兼容
2. 整体架构重新优化
3. 主键ID使用连续不重复的雪花算法 
4. 移除前端项目，但后台提供在线api文档（前端项目将移动到另一个仓库）
5. 登录界面优化
6. 移除调度模块和内容管理模块（考虑插件模式引入）
7. 数据库结构优化 
8. 尽量使用sqltoy-plus来读取数据，兼容多种数据库
9. 引入smart-doc无侵入代码生成接口文档
