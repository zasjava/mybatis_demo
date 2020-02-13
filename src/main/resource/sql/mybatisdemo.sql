/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-02-13 18:11:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '中国', 'CN');
INSERT INTO `country` VALUES ('2', '美国', 'US');
INSERT INTO `country` VALUES ('3', '俄罗斯', 'RU');
INSERT INTO `country` VALUES ('4', '英国', 'GB');
INSERT INTO `country` VALUES ('5', '法国', 'FG');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(500) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '用户管理', '/users');
INSERT INTO `sys_privilege` VALUES ('2', '角色管理', '/roles');
INSERT INTO `sys_privilege` VALUES ('3', '系统日志', '/logs');
INSERT INTO `sys_privilege` VALUES ('4', '人员维护', '/persons');
INSERT INTO `sys_privilege` VALUES ('5', '单位维护', '/companies');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `enabled` int(11) DEFAULT NULL COMMENT '有效标志',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '1', '1', '2016-04-01 17:02:34');
INSERT INTO `sys_role` VALUES ('28', 'aa', '1', '1', '2020-02-11 15:50:00');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('1', '1');
INSERT INTO `sys_role_privilege` VALUES ('1', '2');
INSERT INTO `sys_role_privilege` VALUES ('1', '3');
INSERT INTO `sys_role_privilege` VALUES ('2', '4');
INSERT INTO `sys_role_privilege` VALUES ('2', '5');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_info` text COMMENT '简介',
  `head_image` blob COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin_test', '123456789', 'test@mybatis.ck', 'aaa', null, '2016-04-01 17:00:58');
INSERT INTO `sys_user` VALUES ('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', null, '2016-04-01 17:01:52');
INSERT INTO `sys_user` VALUES ('1002', 'test1', '123456', 'test@qq.com', 'test info', 0x010203, '2020-02-11 08:51:53');
INSERT INTO `sys_user` VALUES ('1003', 'test1', '123456', 'test@mybatis.tck', 'test info', 0x010203, '2020-02-13 10:05:26');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('1001', '2');
INSERT INTO `sys_user_role` VALUES ('1003', '1');
INSERT INTO `sys_user_role` VALUES ('1003', '2');

-- ----------------------------
-- Procedure structure for delete_user_by_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `delete_user_by_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_user_by_id`(
IN userId BIGINT
)
BEGIN
DELETE FROM sys_user_role WHERE user_id = userId;
DELETE FROM sys_user WHERE id =userId;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insert_user_and_roles
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_user_and_roles`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_user_and_roles`(
OUT userId BIGINT,
IN userName VARCHAR(50),
IN userPassword VARCHAR(50),
IN userEmail VARCHAR(50),
IN userInfo TEXT,
IN headImg BLOB,
OUT createTime DATETIME,
IN roleIds VARCHAR(50)
)
BEGIN
SET createTime =NOW();
INSERT INTO sys_user(
user_name,user_password,user_email,user_info,head_image,create_time
)values(
userName,userPassword,userEmail,userInfo,headImg,createTime
);
SELECT LAST_INSERT_ID() INTO userId;
SET roleIds=CONCAT(',',roleIds,',');
INSERT INTO sys_user_role(user_id,role_id) SELECT userId,id FROM sys_role WHERE instr(roleIds,CONCAT(',',id,','))>0;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for select_user_by_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `select_user_by_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_user_by_id`(
IN userId BIGINT,
OUT userName VARCHAR(50),
OUT userPassword VARCHAR(50),
OUT userEmail VARCHAR(50),
OUT userInfo TEXT,
OUT headImg BLOB,
OUT createTime DATETIME)
BEGIN
SELECT user_name,user_password,user_email ,user_info,head_image,create_time
INTO userName,userPassword,userEmail,userInfo,headImg,createTime
FROM  sys_user
WHERE id =userId;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for select_user_page
-- ----------------------------
DROP PROCEDURE IF EXISTS `select_user_page`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_user_page`(
IN userName VARCHAR(50),
IN _offset BIGINT,
IN _limit BIGINT,
OUT total BIGINT
)
BEGIN
SELECT count(*) INTO total FROM sys_user  WHERE user_name LIKE CONCAT('%',userName,'%');
SELECT * FROM sys_user WHERE user_name LIKE CONCAT('%',userName,'%') LIMIT _offset,_limit;
END
;;
DELIMITER ;
