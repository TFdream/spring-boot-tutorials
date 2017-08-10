
CREATE DATABASE IF NOT EXISTS demo DEFAULT CHARACTER SET = utf8mb4;

USE demo;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(32) NOT NULL COMMENT '用户姓名',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `age` SMALLINT(4) NOT NULL COMMENT '年龄',
  `email` varchar(32) NOT NULL COMMENT '注册邮箱',
  `register_time` DATETIME NOT NULL COMMENT '注册时间',
  `status` SMALLINT(4) NOT NULL DEFAULT 0 COMMENT '数据有效性,0:有效,其它无效',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `modify_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_email` (`email`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户注册表';