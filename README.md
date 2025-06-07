# spring-boot-module

> **企业级 Spring Boot 学习与示例仓库**
> 本仓库汇集了一系列相互独立的 Spring Boot 示例项目，演示从基础入门到常见技术栈集成的最佳实践，旨在帮助开发者快速掌握企业级架构和组件集成。

---

## 目录

* [项目概述](#项目概述)
* [子模块列表](#子模块列表)
* [技术栈与依赖管理](#技术栈与依赖管理)
* [环境与前提条件](#环境与前提条件)
* [快速启动](#快速启动)
* [构建与发布](#构建与发布)
* [代码规范与质量保障](#代码规范与质量保障)
* [贡献指南](#贡献指南)
* [许可证](#许可证)

---

## 项目概述

本仓库采用 **Mono‑Repo**（单一仓库 + 多模块聚合）模式，将多个学习型 Spring Boot
应用聚合管理，各模块间保持零耦合，便于统一构建、版本与依赖管理，同时保留独立性以便针对不同技术主题进行专项练习。

---

## 子模块列表

| 模块目录                   | 功能说明                                       |
|------------------------|--------------------------------------------|
| `spring-boot-hello`    | Spring Boot 最简入门示例，演示 HTTP REST 接口创建。      |
| `spring-boot-constant` | 常量与配置集中管理示例，演示 `@ConfigurationProperties`。 |
| `spring-boot-mybatis`  | MyBatis 集成示例，包含增删改查基础操作与分页功能。              |
| `spring-boot-payment`  | 支付场景示例，演示支付宝、微信支付 SDK 集成。                  |
| `spring-boot-tlias`    | 自研组件库集成示例（tlias-ui），演示前后端协同。               |
| `web-demo`             | 综合 Web 演示：前端静态资源加载、模板渲染示例。                 |

---

## 技术栈与依赖管理

* **Java 版本**：Java 17
* **构建工具**：Maven 3.8+
* **Spring Boot**：2.x / 3.x（以父 POM 统一管理）
* **测试框架**：JUnit 5、MockMvc、Testcontainers
* **代码质量**：Checkstyle、SpotBugs、JaCoCo、SonarQube
* **CI/CD 模板**：GitHub Actions（复用 `.github/workflows/reusable.yml`）

所有子模块继承根 `spring-boot-module/pom.xml` 中的依赖版本管理（Dependency Management），无需在各模块重复声明。

---

## 环境与前提条件

1. 本地安装并配置好：

    * JDK 17
    * Maven 3.8+
2. 可选：Docker（用于运行 Testcontainers 或本地中间件）
3. 检查并设置环境变量：

   ```bash
   export JAVA_HOME=/path/to/jdk17
   export MAVEN_OPTS="-Xmx1G"
   ```
