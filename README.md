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

* **auto-configuration（重点）**

    Spring Boot自动配置，实现自定义autoconfigure Module、starter Module，子项目如下：
    
    项目名称                    | 描述
    ----------------------------|------------------------------------------------------------------------------------------
    lrucache-api        | 定义LRUCache接口
    non-con-lrucache          | 基于LinkedHashMap实现LRUCache接口（非线程安全）
    con-lrucache        | 基于ConcurrentLinkedHashMap实现LRUCache接口（线程安全）
    lrucache-spring-boot-autoconfigure          | 自定义spring-boot-autoconfigure
    lrucache-spring-boot-starter          | 自定义spring-boot-starter
    lrucache-spring-boot-sample     | Spring Boot集成lrucache-api

    项目最终实现Spring Boot集成lrucache-api的不同实现。通过包依赖以及属性lrucache.type自动配置LRUCache实例（唯一），当未设置属性lrucache.type时，按照NonConcurrentLRUCache、ConcurrentLRUCache优先顺序实例化。此外，通过属性lrucache.cache-size可配置缓存容量大小。
    
    参考：
    
    [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/html/)
    
    [Spring Boot集成Spring Cache源码](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/cache)
    
    [Spring Boot核心原理－自动配置](https://blog.csdn.net/xiaobing_122613/article/details/54943448)

## 环境

* JDK 1.8
* Spring Boot 2.0.1.RELEASE
* MySQL 5.7
* IntelliJ IDEA
* Maven 3.5.0
* Git VCS