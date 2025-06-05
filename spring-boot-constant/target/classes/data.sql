CREATE TABLE `t_constant` (
                              `constant_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
                              `category_code` VARCHAR(50) NOT NULL COMMENT '常量类别编码，如 USER_STATUS, GENDER',
                              `code` VARCHAR(50) NOT NULL COMMENT '常量编码，如 0, 1, M, F',
                              `name` VARCHAR(100) NOT NULL COMMENT '常量名称，如 "启用","男"',
                              `sort_order` INT DEFAULT 0 COMMENT '排序',
                              `status` TINYINT DEFAULT 1 COMMENT '1=可用,0=禁用',
                              `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`constant_id`),
                              UNIQUE KEY `uk_category_code_code` (`category_code`,`code`),
                              KEY `idx_category_code` (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统常量表';




INSERT INTO t_constant (category_code, code, name, sort_order, status)
VALUES ('USER_STATUS', '0', '禁用', 0, 1),
       ('USER_STATUS', '1', '启用', 1, 1),
       ('GENDER', 'M', '男', 1, 1),
       ('GENDER', 'F', '女', 2, 1);