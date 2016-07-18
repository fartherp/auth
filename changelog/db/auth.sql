USE `auth`;

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` VARCHAR(100) NOT NULL COMMENT '菜单名称',
  `remark` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '菜单备注',
  `parent_id` INT(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `url` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `icon` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '菜单图片',
  `system_id` INT(11) NOT NULL COMMENT '系统ID',
  `level` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '菜单类型:1:菜单,2:按钮',
  `status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态,1:可用,2:不可用',
  `create_id` INT(11) NOT NULL COMMENT '操作人ID',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='菜单表';

LOCK TABLES `tb_menu` WRITE;
INSERT INTO `tb_menu` VALUES (1,'人员管理','人员管理',0,'user/init','',1,1,1,1,NOW()),
(2,'菜单管理','菜单管理',0,'menu/init','',1,1,1,1,NOW()),
(3,'角色管理','角色管理',0,'role/init','',1,1,1,1,NOW()),
(4,'菜单查询','菜单查询',2,'menu/listMenu','',1,2,1,1,NOW()),
(5,'菜单新增','菜单新增',2,'menu/addMenu','',1,2,1,1,NOW()),
(6,'菜单修改','修改按钮',2,'menu/modMenu','',1,2,1,1,NOW()),
(7,'菜单删除','删除按钮',2,'menu/delMenu','',1,2,1,1,NOW()),
(8,'人员查询','查询按钮',1,'user/listUser','',1,2,1,1,NOW()),
(9,'人员新增','新增按钮',1,'user/addUser','',1,2,1,1,NOW()),
(10,'人员修改','修改按钮',1,'user/modUser','',1,2,1,1,NOW()),
(11,'人员删除','删除按钮',1,'user/delUser','',1,2,1,1,NOW()),
(12,'人员权限','分配用户权限',1,'user/Auth','',1,2,1,1,NOW()),
(13,'人员权限确定','用户权限确定按钮',12,'user/userAuth/sure','',1,2,1,1,NOW()),
(14,'人员权限取消','用户权限取消按钮',12,'user/userAuth/cancel','',1,2,1,1,NOW()),
(15,'角色查询','查询按钮',3,'role/listRole','',1,2,1,1,NOW()),
(16,'角色新增','新增按钮',3,'role/addRole','',1,2,1,1,NOW()),
(17,'角色修改','修改按钮',3,'role/modRole','',1,2,1,1,NOW()),
(18,'角色删除','删除按钮',3,'role/delRole','',1,2,1,1,NOW()),
(19,'角色权限','分配角色权限',3,'role/Auth','',1,2,1,1,NOW()),
(20,'角色权限确定','角色权限确定',20,'role/roleAuth/sure','',1,2,1,1,NOW()),
(21,'角色权限取消','角色权限取消按钮',20,'role/roleAuth/cancel','',1,2,1,1,NOW()),
(22,'修改密码','修改密码',0,'user/modPassword/init','',1,1,1,1,NOW()),
(23,'重置密码','重置密码',1,'user/resetPassword','',1,2,1,1,NOW()),
(24,'个人管理','个人管理',0,'','',2,1,1,1,NOW()),
(25,'个人信息','个人信息',24,'user/init','',2,1,1,1,NOW()),
(26,'修改密码','OA系统修改密码',24,'user/modPassword/init','',2,1,1,1,NOW()),
(27,'签到签退','签到签退',24,'','',2,1,1,1,NOW()),
(28,'签到','签到',27,'sign/in','',2,2,1,1,NOW()),
(29,'签退','签退',27,'sign/out','',2,2,1,1,NOW()),
(30,'查询','个人签到签退查询',27,'sign/list','',2,2,1,1,NOW());
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` VARCHAR(100) NOT NULL COMMENT '角色名',
  `remark` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '备注',
  `system_id` INT(11) NOT NULL COMMENT '系统ID',
  `status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态:1:可用,2:不可用',
  `create_id` INT(11) NOT NULL COMMENT '操作人ID',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色表';

LOCK TABLES `tb_role` WRITE;
INSERT INTO `tb_role` VALUES (1,'管理员','管理员',1,1,1,NOW()),
(2,'测试','测试',1,1,1,NOW()),
(3,'oa管理员','oa管理员',2,1,1,NOW());
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色-菜单ID',
  `role_id` INT(11) NOT NULL COMMENT '角色ID',
  `menu_id` INT(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色-菜单表';

LOCK TABLES `tb_role_menu` WRITE;
INSERT INTO `tb_role_menu` VALUES (1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,1,6),
(7,1,7),
(8,1,8),
(9,1,9),
(10,1,10),
(11,1,11),
(12,1,12),
(13,1,13),
(14,1,14),
(15,1,15),
(16,1,16),
(17,1,17),
(18,1,18),
(19,1,19),
(20,1,20),
(21,1,21),
(22,1,22),
(23,1,23),
(24,2,2),
(25,2,4),
(26,2,22),
(27,3,24),
(28,3,25),
(29,3,26),
(30,3,27),
(31,3,28),
(32,3,29),
(33,3,30);
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` VARCHAR(100) NOT NULL COMMENT '用户名',
  `password` VARCHAR(1000) NOT NULL COMMENT '用户密码',
  `email` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `sex` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '性别，1:男,2:女',
  `role_id` INT(11) NOT NULL COMMENT '角色ID',
  `system_id` INT(11) NOT NULL COMMENT '系统ID',
  `status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态:1:可用,2:不可用',
  `create_id` INT(11) NOT NULL COMMENT '操作人ID',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';

LOCK TABLES `tb_user` WRITE;
INSERT INTO `tb_user` VALUES (1,'ck','b59c67bf196a4758191e42f76670ceba','yuqiang.cui@gmail.com','18611714795',1,1,1,1,1,NOW()),
(2,'test','b59c67bf196a4758191e42f76670ceba','214722930@qq.com','18611714795',1,2,1,1,1,NOW()),
(3,'oa','b59c67bf196a4758191e42f76670ceba','214722930@qq.com','18611714795',1,3,2,1,1,NOW());
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_user_menu`;
CREATE TABLE `tb_user_menu` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户-菜单ID',
  `user_id` INT(11) NOT NULL COMMENT '用户ID',
  `menu_id` INT(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户-菜单表';

LOCK TABLES `tb_user_menu` WRITE;
INSERT INTO `tb_user_menu` VALUES (1,2,1),(2,2,8);
UNLOCK TABLES;

DROP TABLE IF EXISTS `td_composite_dictionary`;
CREATE TABLE `td_composite_dictionary` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `dic_id` INT(11) NOT NULL COMMENT '字典ID',
  `dic_name` VARCHAR(100) NOT NULL COMMENT '字典名称',
  `dic_type` INT(11) NOT NULL COMMENT '类型',
  `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '字典状态:1:启用,0:禁用',
  `dic_desc` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT '字典描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='字典表';
insert  into `td_composite_dictionary`(`id`,`dic_id`,`dic_name`,`dic_type`,`status`,`dic_desc`) values
(1,1,'男',1,1,'性别'),(2,2,'女',1,1,'性别'),(3,1,'可用',2,1,'状态'),(4,2,'禁用',2,1,'状态'),(5,1,'权限系统',3,1,'系统ID'),(6,2,'oa系统',3,1,'系统ID')
,(7,3,'tyj系统',3,1,'系统ID'),(8,4,'jhpt系统',3,1,'系统ID'),(9,1,'菜单',4,1,'菜单类型'),(10,2,'按钮',4,1,'菜单类型');
