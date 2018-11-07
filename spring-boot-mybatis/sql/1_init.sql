
CREATE TABLE `user` (
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(45) NOT NULL COMMENT '用户名',
`password` varchar(40) NOT NULL DEFAULT '0' COMMENT '密码',
`age` smallint(10) unsigned NOT NULL DEFAULT '0' COMMENT '年龄',
`version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
