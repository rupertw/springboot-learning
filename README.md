## SpringBoot 示例

此项目是本人在阅读Spring Boot官方文档（spring-boot-reference-2.0.1.RELEASE）时，写的示例。涵盖了Spring Boot原理与应用的关键点。

## 子项目说明

* **helloworld**

    idea创建Spring Boot项目；打包启动jar；spring-boot-starter分类；spring-boot-devtools使用；spring-boot-starter-test测试

* **properties**

    Spring Boot属性配置（Spring Booot组件属性、自定义属性、多环境配置）

* **web**

    mybatis集成（使用mysql数据库）；数据库事务；restful、mvc拦截器、restdocs；web Servlet、Filter、Listener

* **dubbo-api、dubbo-server、dubbo-client**

    Spring Boot集成dubbo

* **auto-configuration**

    Spring Boot自动化配置，实现自定义autoconfigure Module、Starter Module

    1.lrucache-api &nbsp;&nbsp;&nbsp;定义LRUCache接口

    2.non-con-lrucache &nbsp;&nbsp;&nbsp;基于LinkedHashMap实现LRUCache接口（非线程安全）
    
    3.con-lrucache &nbsp;&nbsp;&nbsp;基于ConcurrentLinkedHashMap实现LRUCache接口（线程安全）
    
    4.lrucache-spring-boot-autoconfigure &nbsp;&nbsp;&nbsp;自定义spring-boot-autoconfigure
    
    5.lrucache-spring-boot-starter &nbsp;&nbsp;&nbsp;自定义spring-boot-starter
    
    6.lrucache-spring-boot-sample &nbsp;&nbsp;&nbsp;Spring Boot集成lrucache-api示例

## 环境

* JDK 1.8
* Spring Boot 2.0.1.RELEASE
* MySQL 5.7
* Intellij Idea
* Maven latest