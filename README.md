# Spring Boot 模块化示例仓库

该仓库为主仓库，使用 Git Submodule 管理多个子项目模块，适用于企业级微服务 / 模块化开发场景。

## 📦 当前包含的子模块

| 模块路径                                                                              | 描述                                                                     | 状态     |
|-----------------------------------------------------------------------------------|------------------------------------------------------------------------|--------|
| [`spring-boot-constant`](https://github.com/sunMozi/spring-boot-constant)         | <sub>公共常量模块，集中维护系统枚举、错误码、通用常量等，便于跨模块复用与集中管理。</sub>                     | ✅ 已完成  |
| [`spring-boot-demo`](https://github.com/sunMozi/spring-boot-demo)                 | <sub>Spring Boot 入门示例，提供最小可运行结构，适合初学者上手与模块结构参考。</sub>                  | ✅ 已完成  |
| [`spring-boot-mybatis`](https://github.com/sunMozi/spring-boot-mybatis)           | <sub>基于 MyBatis 的数据访问模块，集成通用 Mapper、分页插件与注解驱动配置，适用于标准 SQL 映射场景。</sub>  | ✅ 已完成  |
| [`spring-boot-mybatis-plus`](https://github.com/sunMozi/spring-boot-mybatis-plus) | <sub>基于 MyBatis-Plus 的增强数据访问模块，支持 Lambda 条件构造器、自动填充、审计字段、乐观锁等特性。</sub> | 🛠 开发中 |
| [`spring-boot-payment`](https://github.com/sunMozi/spring-boot-payment)           | <sub>支付模块，封装支付宝 / 微信支付能力，支持统一下单、签名验签、异步回调、退款等企业支付接口流程。</sub>           | ⏳ 规划中  |
| [`spring-boot-tlias`](https://github.com/sunMozi/spring-boot-tlias)               | <sub>教学管理系统模块（TLias）</sub>                                             | ✅ 已完成  |

> 📌 所有子模块均为独立 Git 仓库，便于模块解耦与版本管理。

## 🚀 使用说明

### ✅ 克隆仓库（含所有子模块）

```bash
git clone --recurse-submodules https://github.com/sunMozi/spring-boot-module.git
cd spring-boot-module
```

### 🔄 拉取子模块更新

当主仓库或子模块有更新时，可执行以下命令同步子模块内容：

```bash
git submodule update --init --recursive
```