
# 物流管理系统
## Introduction
* 本项目为物流系统二次开发
* 本项目部署在`linux centos7`上运行
* 本次开发了受理模块、基础档案模块
* 本项目由`maven`构建
* 前端采用`easyui`、`jQuery`
* 后台采用`ssh`框架
* 数据库为`mysql`
* 数据库原型设计采用`powerdesigner`设计
* 客户数据采用`apache cxf`框架进行远程调用[crm项目](https://github.com/Scavenger-s/crm.git)
* 本系统采用`shiro`框架进行权限控制
* 管理分区模块显示区域分区分布图功能数据可视化采用`hchart`框架
* 区域设置模块，导入功能，请导入项目中的区域导入测试数据(因格式已经写死故不支持其他类型的数据)
---
## Quick Start
1. 将项目clone到本地
2. 关联上本地仓库
3. 将bos-parent install 在需要相应的jar(如：bos-domain)包时加入
4. 在数据库软件(如：navicat)中运行本项目中的sql文件中的脚本
   顺序为：
   user.sql-->bos_bc.sql-->bos_qb.sql
   -->bos_qbv1.sql(注：运行过程中可能会出现外键冲突的情况，如出现请现将对应分外键删除，运行完sql脚本后再将外键加上)
5. 修改bos-web/src/main/resources下的db.properties对应数据库设置
6. 初始化数据库数据：
   * 先运行项目中sql文件中初始化数据：auth_function.sql脚本
   * 请在user表中添加一个admin用户和密码以便初次登录，密码采用md5算法加密
7. 将[crm项目](https://github.com/Scavenger-s/crm.git)clone到本地，将其和bos项目一起加入tomact下

