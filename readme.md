# ✨ SraAdmin 后台管理系统

## 📝 介绍

SraAdmin 是一个**前后端分离**的后台管理系统。它引入了市面上常用的工具包和核心框架，只实现了用户、字典、角色、权限等常见功能，能够帮助您快速搭建一个 Web 项目。

* **后端技术栈**：`springboot3` + `sqltoy` + `satoken` + `hutool`
* **前端技术栈**：`vue3` + `vue-router` + `typescript` + `elementui`

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a59c1e8139e946ab94e25a791b4bacb3)](https://app.codacy.com/gh/CoCoTeaNet/sra-admin/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

---

## 🚀 附加仓库

| 项目名称 | 描述 | 仓库地址 |
| :--- | :--- | :--- |
| **sra-admin-vue** | 前端项目，基于 VUE 开发 | https://github.com/CoCoTeaNet/sra-admin-vue.git |
| **sra-admin-solon** | 后端项目，基于 Solon 开发 | https://github.com/CoCoTeaNet/sra-admin-solon |

---

## 🎯 应用场景

* XXX 网站 | 博客网站
* 编程学习 | 毕业设计
* XXX 管理系统

---

## ⚙️ 启动说明

### 步骤

1.  运行数据库脚本：包含表结构和初始化数据。
2.  启动本地 **Redis** 并运行后端服务。
3.  安装前端依赖并运行前端项目。

### 备注

> 1.  **配置文件**：`sra-admin-service/sra-web/src/main/resources/application.yml`
> 2.  **数据库运行脚本**：`/doc/sql/*.sql`
> 3.  **项目启动类**：`sra-admin-service/sra-web/src/main/java/net/cocotea/admin/Launcher.java`

### 访问地址

测试后端接口：http://localhost:9000/test/index

---
