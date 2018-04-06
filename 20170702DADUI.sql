/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.17-log : Database - dadui
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dadui` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dadui`;

/*Table structure for table `t_changelist` */

DROP TABLE IF EXISTS `t_changelist`;

CREATE TABLE `t_changelist` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USERNAME` varchar(200) DEFAULT NULL COMMENT '用户',
  `STATUS` varchar(200) DEFAULT NULL COMMENT '状态 success',
  `STOCK_NAME` varchar(200) DEFAULT NULL COMMENT 'STOCK 名字',
  `TARGET_WEIGHT` float DEFAULT NULL COMMENT '调整后权重',
  `PRICE` float DEFAULT NULL COMMENT '价格',
  `PREV_WEIGHT_AJJUSTED` float DEFAULT NULL COMMENT '调整前权重',
  `USERID` varchar(200) DEFAULT NULL COMMENT '用户ID',
  `STOCK_SYMBOL` varchar(200) DEFAULT NULL COMMENT '用户代码',
  `updated_at` datetime DEFAULT NULL COMMENT '交易时间',
  `sign` varchar(200) DEFAULT NULL COMMENT '来源标识',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_changelist` */

/*Table structure for table `t_con` */

DROP TABLE IF EXISTS `t_con`;

CREATE TABLE `t_con` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `ORG_ID` int(10) DEFAULT NULL COMMENT '圈子ID',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '状态（0：待审核 1：审核通过 2：删除）',
  `CON` text COMMENT '内容',
  `CREATE_USER_ID` varchar(50) DEFAULT NULL COMMENT '创建者ID ',
  `CREATE_USER_OPENID` varchar(50) DEFAULT NULL COMMENT '创建者微信ID ',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='圈子内容 ';

/*Data for the table `t_con` */

insert  into `t_con`(`ID`,`ORG_ID`,`STATUS`,`CON`,`CREATE_USER_ID`,`CREATE_USER_OPENID`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`) values (1,1,1,'1111','591c458ba24547f2be59769d572cb244',NULL,NULL,NULL,0);

/*Table structure for table `t_img` */

DROP TABLE IF EXISTS `t_img`;

CREATE TABLE `t_img` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `MAIN_ID` int(10) DEFAULT NULL COMMENT '主内容ID ',
  `MAIN_ID_TYPE` tinyint(4) DEFAULT NULL COMMENT ' 0：圈子内容   1：图片',
  `FILE_PATH` varchar(50) DEFAULT NULL COMMENT '文件路径',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注列1 ',
  `REMARK2` varchar(50) DEFAULT NULL COMMENT '备注列2 ',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='（个人信息 圈子）-图片表 ';

/*Data for the table `t_img` */

/*Table structure for table `t_org` */

DROP TABLE IF EXISTS `t_org`;

CREATE TABLE `t_org` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `NAME` varchar(50) NOT NULL COMMENT '圈子名称',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '圈子状态（0：待审核  1：审核通过   2：审核不通过）	',
  `IMG_PATH` varchar(50) DEFAULT NULL COMMENT '圈子背景图片',
  `CREATE_USER_ID` varchar(36) NOT NULL COMMENT '创建者ID',
  `CREATE_USER_OPENID` varchar(50) DEFAULT NULL COMMENT '创建者微信ID',
  `CREATE_USER_INTRO` varchar(50) DEFAULT NULL COMMENT '创建者介绍',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='圈子';

/*Data for the table `t_org` */

insert  into `t_org`(`ID`,`NAME`,`STATUS`,`IMG_PATH`,`CREATE_USER_ID`,`CREATE_USER_OPENID`,`CREATE_USER_INTRO`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`) values (1,'test',1,'ssss','11','sssss','ssssss','2017-05-16 14:29:15','2017-05-23 14:29:20',0);

/*Table structure for table `t_org_user` */

DROP TABLE IF EXISTS `t_org_user`;

CREATE TABLE `t_org_user` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `ORG_ID` int(10) NOT NULL COMMENT '圈子ID ',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '用户微信ID',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '用户在当前圈子状态（0：待审核  1：审核通过   2：审核不通过）	',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='圈子用户表';

/*Data for the table `t_org_user` */

insert  into `t_org_user`(`ID`,`ORG_ID`,`USER_ID`,`OPENID`,`STATUS`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`) values (1,1,'591c458ba24547f2be59769d572cb244',NULL,1,NULL,NULL,0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `ID` varchar(36) NOT NULL COMMENT '唯一标识',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `NAME` varchar(15) DEFAULT NULL COMMENT '昵称',
  `IS_ALONE` tinyint(4) DEFAULT NULL COMMENT '是否alone（0：不是 1:是 ）',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `WECHAT` varchar(50) DEFAULT NULL COMMENT '微信账户',
  `NICKNAME` varchar(50) DEFAULT NULL COMMENT '微信昵称	',
  `GENDER` tinyint(4) DEFAULT NULL COMMENT '微信性别（0：女 1：男）	',
  `AVATAR_URL` varchar(300) DEFAULT NULL COMMENT '微信头像',
  `CITY` varchar(50) DEFAULT NULL COMMENT '微信城市',
  `PROVIENCE` varchar(50) DEFAULT NULL COMMENT '微信省份',
  `COUNTRY` varchar(50) DEFAULT NULL COMMENT '微信国家',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '当前用户状态（0：待审核  1：审核通过   2：审核不通过）	',
  `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  `FIRST_EDIT` int(4) DEFAULT '0' COMMENT '编辑个人信息次数 默认为0，未编辑',
  `SECOND_EDIT` int(4) DEFAULT '0' COMMENT '第二步编辑个人信息次数 默认为0，未编辑',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`ID`,`USERNAME`,`PASSWORD`,`NAME`,`IS_ALONE`,`OPENID`,`WECHAT`,`NICKNAME`,`GENDER`,`AVATAR_URL`,`CITY`,`PROVIENCE`,`COUNTRY`,`STATUS`,`REG_TIME`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`,`FIRST_EDIT`,`SECOND_EDIT`) values ('36bed8d670424f78ac9e93a3dc4b3a01',NULL,NULL,NULL,NULL,'11111',NULL,'2222',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-05-19 14:33:25','2017-05-19 14:33:25',0,0,0),('43db5714662a436e8fd43412fc3a9098',NULL,NULL,NULL,NULL,'undefined',NULL,'段书勇',1,'undefined','Zhengzhou','undefined','CN',NULL,NULL,'2017-06-03 18:16:59','2017-06-03 18:16:59',0,0,0),('591c458ba24547f2be59769d572cb244',NULL,NULL,NULL,NULL,'onDD80C0oSuFwM4_swUXx_esEr2A',NULL,'段书勇',1,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKGxkOibYsbwMSBewrE4VE5TFAo8nV8wVomhvRIvvNrrW2cwlap3GqzPrhaoSUrq58VVdaA5FEEXlA/0','Zhengzhou','undefined','CN',NULL,NULL,'2017-06-03 18:16:59','2017-07-01 21:01:17',0,67,67),('766fd5cf20c74bfbb634ce14f2f92841',NULL,NULL,NULL,NULL,'\"11111\"',NULL,'\"2222\"',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-05-19 11:42:16','2017-05-19 11:42:16',0,0,0);

/*Table structure for table `t_user_extend` */

DROP TABLE IF EXISTS `t_user_extend`;

CREATE TABLE `t_user_extend` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户表ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `BIRTHDAY_TIME` datetime DEFAULT NULL COMMENT '生日年月日',
  `HEIGHT` int(10) NOT NULL COMMENT '身高cm',
  `PROFESSION` varchar(50) DEFAULT NULL COMMENT '职业',
  `IS_HOUSE` tinyint(4) DEFAULT '0' COMMENT '是否有房（0:没有 1:有）',
  `IS_CAR` tinyint(4) DEFAULT '0' COMMENT '是否有车（0:没有 1:有）',
  `INTRODUCE` varchar(50) DEFAULT NULL COMMENT '个人介绍',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  `REQUIRE` varchar(50) DEFAULT NULL COMMENT '需要-要求',
  `INCOME` varchar(50) DEFAULT NULL COMMENT '收入',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户扩展表，储存用户扩展信息';

/*Data for the table `t_user_extend` */

insert  into `t_user_extend`(`ID`,`USER_ID`,`OPENID`,`BIRTHDAY_TIME`,`HEIGHT`,`PROFESSION`,`IS_HOUSE`,`IS_CAR`,`INTRODUCE`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`,`REQUIRE`,`INCOME`) values (1,'591c458ba24547f2be59769d572cb244',NULL,'2017-06-22 10:38:31',150,'eee',0,0,'ggggggg',NULL,'2017-06-24 16:38:14',0,NULL,NULL);

/*Table structure for table `t_user_img` */

DROP TABLE IF EXISTS `t_user_img`;

CREATE TABLE `t_user_img` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户表ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `IMG_PATH` varchar(50) DEFAULT NULL COMMENT '图片位置',
  `IS_MAIN` tinyint(4) DEFAULT '0' COMMENT '是否主头像（0:不是 1:是）',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户图片表，储存用户图片';

/*Data for the table `t_user_img` */

insert  into `t_user_img`(`ID`,`USER_ID`,`OPENID`,`IMG_PATH`,`IS_MAIN`,`CREATE_TIME`,`UPDATE_TIME`,`DELETE_TAG`) values (11,'591c458ba24547f2be59769d572cb244',NULL,'198558891796114136.jpg',0,'2017-07-01 22:02:27','2017-07-01 22:02:27',NULL),(12,'591c458ba24547f2be59769d572cb244',NULL,'198560631895392949.jpg',0,'2017-07-01 22:09:05','2017-07-01 22:09:05',NULL),(13,'591c458ba24547f2be59769d572cb244',NULL,'198560649477912674.jpg',0,'2017-07-01 22:09:09','2017-07-01 22:09:09',NULL);

/*Table structure for table `t_user_sugar` */

DROP TABLE IF EXISTS `t_user_sugar`;

CREATE TABLE `t_user_sugar` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户表ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `SUGAR_NUM` int(10) NOT NULL COMMENT '余额',
  `WECHAT_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '微信提现账户ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人账户表';

/*Data for the table `t_user_sugar` */

/*Table structure for table `t_user_sugar_add` */

DROP TABLE IF EXISTS `t_user_sugar_add`;

CREATE TABLE `t_user_sugar_add` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户表ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `SUGAR_NUM` int(10) NOT NULL COMMENT '充值后余额',
  `WECHAT_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '充值账户ID',
  `AMOUNT` int(10) NOT NULL COMMENT '充值金额',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人账户充值记录';

/*Data for the table `t_user_sugar_add` */

/*Table structure for table `t_user_sugar_reduce` */

DROP TABLE IF EXISTS `t_user_sugar_reduce`;

CREATE TABLE `t_user_sugar_reduce` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户表ID',
  `OPENID` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `SUGAR_NUM` int(10) DEFAULT NULL COMMENT '提现后余额',
  `WECHAT_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '提现账户ID',
  `AMOUNT` int(10) DEFAULT NULL COMMENT '提现金额',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人账户提现记录';

/*Data for the table `t_user_sugar_reduce` */

/*Table structure for table `t_user_wechat_add` */

DROP TABLE IF EXISTS `t_user_wechat_add`;

CREATE TABLE `t_user_wechat_add` (
  `ID` int(10) NOT NULL COMMENT '唯一标识',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户ID',
  `BY_USER_ID` int(10) NOT NULL COMMENT '被添加用户ID',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '添加状态(0：待通过  1：已通过  2：7天未回复)  ',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DELETE_TAG` tinyint(4) DEFAULT '0' COMMENT '是否删除 （0:未删除  1：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信添加记录表 ';

/*Data for the table `t_user_wechat_add` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
