
CREATE DATABASE IF NOT EXISTS demo DEFAULT CHARACTER SET = utf8mb4;

USE demo;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `age` SMALLINT(4) NOT NULL COMMENT '年龄',
  `mobile` varchar(32) NOT NULL COMMENT '注册手机号',
  `email` varchar(32) NOT NULL COMMENT '注册邮箱',
  `registy_time` DATETIME NOT NULL COMMENT '注册时间',
  `status` SMALLINT(4) NOT NULL DEFAULT 0 COMMENT '数据有效性,0:有效,其它无效',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `modify_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_email` (`email`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户注册表';

CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` SMALLINT(4) NOT NULL DEFAULT 0 COMMENT '数据有效性,0:有效,其它无效',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `modify_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `index_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE `tb_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `price` DECIMAL(9,3) NOT NULL  COMMENT '商品点击',
  `quantity` SMALLINT (4) DEFAULT '0' COMMENT '购买数量',
  `status` SMALLINT(4) NOT NULL DEFAULT 0 COMMENT '数据有效性,0:有效,其它无效',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `modify_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `index_user_pk` (`user_id`, `order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单项表';