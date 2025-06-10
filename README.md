# Spring Boot 模块化示例仓库

该仓库为主仓库，使用 Git Submodule 管理多个子项目模块，适用于企业级微服务/模块化开发。

## 📦 当前包含的子模块

| 模块路径               | 描述                        |
| ---------------------- | --------------------------- |
| `spring-boot-constant` | 公共常量模块                |
| `spring-boot-demo`     | Spring Boot 入门示例        |
| `spring-boot-mybatis`  | 集成 MyBatis 示例           |
| `spring-boot-payment`  | 支付集成模块（支付宝/微信） |
| `spring-boot-tlias`    | 教学管理系统模块（TLias）   |

## 🚀 使用说明

### ✅ 克隆仓库（含所有子模块）

```bash
git clone --recurse-submodules https://github.com/sunMozi/spring-boot-module.git
cd spring-boot-module
```