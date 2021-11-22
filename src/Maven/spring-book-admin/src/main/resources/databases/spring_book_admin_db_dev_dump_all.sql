-- MariaDB dump 10.19  Distrib 10.4.20-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: spring_book_admin_db_dev
-- ------------------------------------------------------
-- Server version	10.4.20-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_auth_group_roles`
--

DROP TABLE IF EXISTS `tbl_auth_group_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_group_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_group_roles` (`group_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='组群角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_group_roles`
--

LOCK TABLES `tbl_auth_group_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_group_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_group_roles` VALUES (1,101,101,NULL),(2,101,102,NULL),(3,101,103,NULL),(4,102,101,NULL),(5,102,102,NULL),(6,102,103,NULL),(7,103,101,NULL),(8,103,102,NULL),(9,103,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_group_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_groups`
--

DROP TABLE IF EXISTS `tbl_auth_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(32) NOT NULL,
  `group_code` varchar(32) DEFAULT NULL COMMENT '群组代码',
  `group_status` int(11) DEFAULT 1 COMMENT '群组状态 (1:active, 0: inactive)',
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COMMENT='用户群组主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_groups`
--

LOCK TABLES `tbl_auth_groups` WRITE;
/*!40000 ALTER TABLE `tbl_auth_groups` DISABLE KEYS */;
INSERT INTO `tbl_auth_groups` VALUES (101,'Administrator Group','ADMIN',1,NULL),(102,'Normal User Group','NORMAL',1,NULL),(103,'Customer User Group','CUSTOMER',1,NULL);
/*!40000 ALTER TABLE `tbl_auth_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_roles`
--

DROP TABLE IF EXISTS `tbl_auth_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL,
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_status` int(11) NOT NULL DEFAULT 1 COMMENT '角色状态 (1:active, 0: inactive)',
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_roles_role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_roles`
--

LOCK TABLES `tbl_auth_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_roles` VALUES (101,'Administrator','ADMIN',1,NULL),(102,'Normal User','NORMAL',1,NULL),(103,'Guest User','GUEST',1,NULL),(104,'Regular User (Contract)','CONTRACT',1,NULL),(105,'Super User (VIP)','VIP',1,NULL),(106,'Super Guest User','SGUEST',1,NULL),(201,'Employee',NULL,1,NULL),(202,'Manager',NULL,1,NULL),(203,'Director',NULL,1,NULL),(204,'Vice President',NULL,1,NULL),(205,'President (CEO)',NULL,1,NULL),(206,'CTO',NULL,1,NULL),(207,'CFO',NULL,1,NULL),(208,'COO',NULL,1,NULL),(301,'Business Leader',NULL,1,NULL),(302,'Buesiness Developer (BD)',NULL,1,NULL),(1001,'Group Owner',NULL,1,NULL);
/*!40000 ALTER TABLE `tbl_auth_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_user_groups`
--

DROP TABLE IF EXISTS `tbl_auth_user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_user_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_user_groups` (`user_id`,`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COMMENT='用户群组关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_user_groups`
--

LOCK TABLES `tbl_auth_user_groups` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_groups` DISABLE KEYS */;
INSERT INTO `tbl_auth_user_groups` VALUES (1,2001,101,NULL),(2,2002,102,NULL),(3,2003,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_user_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_user_roles`
--

DROP TABLE IF EXISTS `tbl_auth_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_user_roles` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_user_roles`
--

LOCK TABLES `tbl_auth_user_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_user_roles` VALUES (1,2001,101,NULL),(2,2002,102,NULL),(3,2003,103,NULL),(4,2001,102,NULL),(5,2002,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_user_tokens`
--

DROP TABLE IF EXISTS `tbl_auth_user_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_user_tokens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token_name` varchar(128) DEFAULT NULL,
  `token_timestamp` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `token_expired_at` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_user_tokens` (`token_name`),
  KEY `fk_tbl_auth_user_tokens` (`user_id`),
  CONSTRAINT `fk_tbl_auth_user_tokens` FOREIGN KEY (`user_id`) REFERENCES `tbl_auth_users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录令牌(临时)表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_user_tokens`
--

LOCK TABLES `tbl_auth_user_tokens` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_auth_user_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_users`
--

DROP TABLE IF EXISTS `tbl_auth_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `fullname` varchar(64) DEFAULT NULL,
  `user_email` varchar(64) NOT NULL,
  `user_phone` varchar(32) DEFAULT NULL,
  `last_login` datetime NOT NULL COMMENT '最后登录',
  `date_joined` datetime NOT NULL COMMENT '创建时间',
  `user_status` int(11) NOT NULL DEFAULT 1 COMMENT '用户状态 (1:active, 0: inactive)',
  `role_id` int(11) DEFAULT 102 COMMENT '默认角色(102:Normal User)',
  `role_name` varchar(32) DEFAULT NULL,
  `group_id` int(11) DEFAULT 102 COMMENT '默认群组(102：Normal User Group)',
  `group_name` varchar(32) DEFAULT NULL,
  `city_id` int(11) DEFAULT 1001 COMMENT '默认城市(1001：Shanghai)',
  `city_name` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_auth_users_username` (`username`),
  UNIQUE KEY `unq_tbl_auth_users_user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4043 DEFAULT CHARSET=utf8mb4 COMMENT='用户主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_users`
--

LOCK TABLES `tbl_auth_users` WRITE;
/*!40000 ALTER TABLE `tbl_auth_users` DISABLE KEYS */;
INSERT INTO `tbl_auth_users` VALUES (2001,'admin','$2a$10$GH2UACuX4b7sXXkOIy3/p./Xa6IP.P89nc9wxfwoT5Am2y2qmufR.','crane zhou','crane_zhou@163.com','138xxxx5588','2018-10-08 20:01:00','2018-10-08 20:01:00',1,101,NULL,102,NULL,NULL,NULL,NULL),(2002,'normal','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','Normal User Name','normal_user@hellosoft.com','138xxxx5587','2018-10-08 20:02:00','2018-10-08 20:02:00',1,102,NULL,102,NULL,NULL,NULL,NULL),(2003,'user03','$2a$10$atnN6.ggLrOD6QDKfHPkZOFyChrnImwMBUSgHcCbFzWq1cFAAuSH.','User Name 03','user03@hellosoft.com','138xxxx5586','2018-10-08 20:03:00','2018-10-08 20:03:00',1,102,NULL,102,NULL,NULL,NULL,NULL),(4001,'user4001','password','User Name 4001','user4001@rillsoft.net',NULL,'2021-09-29 21:43:13','2021-09-29 21:43:13',1,102,NULL,102,NULL,NULL,NULL,NULL),(4002,'user4002','password','User Name 4002','user4002@rillsoft.net',NULL,'2021-09-29 21:28:17','2021-09-29 21:28:17',1,102,NULL,102,NULL,NULL,NULL,NULL),(4003,'user4003','password2021-11-18 09:27:29','User Name 2021-11-18 09:27:29','user4003@rillsoft.net',NULL,'2021-09-29 21:26:09','2021-09-29 21:26:09',1,102,NULL,102,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_auth_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_goods_category`
--

DROP TABLE IF EXISTS `tbl_goods_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_goods_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(32) NOT NULL,
  `cate_code` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  `cate_status` int(11) NOT NULL DEFAULT 1,
  `cate_desc` varchar(128) DEFAULT NULL COMMENT '分类描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_goods_category_cate_name` (`cate_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3002 DEFAULT CHARSET=utf8mb4 COMMENT='产品分类主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_goods_category`
--

LOCK TABLES `tbl_goods_category` WRITE;
/*!40000 ALTER TABLE `tbl_goods_category` DISABLE KEYS */;
INSERT INTO `tbl_goods_category` VALUES (1001,'书籍',NULL,NULL,1,NULL),(1002,'杂志',NULL,NULL,1,NULL),(2001,'饮料',NULL,NULL,1,NULL),(2002,'矿泉水',NULL,NULL,1,NULL),(3001,'茶叶',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `tbl_goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_goods_products`
--

DROP TABLE IF EXISTS `tbl_goods_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_goods_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(32) NOT NULL,
  `prod_code` varchar(32) DEFAULT NULL,
  `cate_id` int(11) NOT NULL,
  `cate_name` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `brand_name` varchar(32) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `type_name` varchar(32) DEFAULT NULL,
  `spec_id` int(11) DEFAULT NULL,
  `spec_name` varchar(32) DEFAULT NULL,
  `prod_unit` varchar(32) DEFAULT NULL,
  `prod_price` decimal(10,2) DEFAULT NULL,
  `prod_discount` int(11) DEFAULT 100,
  `prod_desc` varchar(128) DEFAULT NULL COMMENT '产品描述',
  `prod_status` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_goods_products_prod_name` (`prod_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2007 DEFAULT CHARSET=utf8mb4 COMMENT='产品信息主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_goods_products`
--

LOCK TABLES `tbl_goods_products` WRITE;
/*!40000 ALTER TABLE `tbl_goods_products` DISABLE KEYS */;
INSERT INTO `tbl_goods_products` VALUES (2001,'可乐',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'百事可乐',1),(2002,'雪碧',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'柠檬味汽水',1),(2003,'橙汁',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'果粒橙汁',1),(2004,'农夫山泉',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'农夫山泉 国产矿泉水',1),(2005,'冰露',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'冰露 国产矿泉水',1),(2006,'纯悦',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'纯悦 国产矿泉水',1);
/*!40000 ALTER TABLE `tbl_goods_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_goods_resource`
--

DROP TABLE IF EXISTS `tbl_goods_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_goods_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(32) NOT NULL,
  `resource_code` varchar(32) DEFAULT NULL,
  `cate_id` int(11) NOT NULL,
  `cate_name` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  `resource_status` int(11) NOT NULL DEFAULT 1,
  `resource_desc` varchar(128) DEFAULT NULL COMMENT '资源描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_goods_resource_resource_name` (`resource_name`),
  KEY `fk_tbl_goods_resource_tbl_goods_category` (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源信息主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_goods_resource`
--

LOCK TABLES `tbl_goods_resource` WRITE;
/*!40000 ALTER TABLE `tbl_goods_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_goods_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sites_city`
--

DROP TABLE IF EXISTS `tbl_sites_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sites_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(32) NOT NULL COMMENT '城市名称',
  `city_code` varchar(32) DEFAULT NULL,
  `city_status` int(11) NOT NULL DEFAULT 1,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_site_city_name` (`city_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COMMENT='城市主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sites_city`
--

LOCK TABLES `tbl_sites_city` WRITE;
/*!40000 ALTER TABLE `tbl_sites_city` DISABLE KEYS */;
INSERT INTO `tbl_sites_city` VALUES (1001,'Shanghai','021',1,'310000'),(1002,'HangZhou','0571',1,'330100'),(1003,'ShuZhou','0512',1,'320500');
/*!40000 ALTER TABLE `tbl_sites_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sites_park`
--

DROP TABLE IF EXISTS `tbl_sites_park`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sites_park` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `park_name` varchar(128) NOT NULL,
  `park_code` varchar(32) DEFAULT NULL,
  `park_status` int(11) NOT NULL DEFAULT 1,
  `city_id` int(11) NOT NULL DEFAULT 21,
  `city_name` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tbl_site_park_name` (`park_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb4 COMMENT='园区主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sites_park`
--

LOCK TABLES `tbl_sites_park` WRITE;
/*!40000 ALTER TABLE `tbl_sites_park` DISABLE KEYS */;
INSERT INTO `tbl_sites_park` VALUES (1001,'ZhangJiang High-Tech Park','310115-001',1,1001,'Shanghai',NULL),(1002,'JinQiao Office Park','310115-002',1,1001,'Shanghai',NULL),(1003,'WaiGaoQiao Trade Park (Zone)','310115-003',1,1001,'Shanghai',NULL),(1004,'LuJiaZui Financial Trade Center (Zone)','310115-004',1,1001,'Shanghai',NULL);
/*!40000 ALTER TABLE `tbl_sites_park` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sites_stock`
--

DROP TABLE IF EXISTS `tbl_sites_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sites_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_name` varchar(32) NOT NULL,
  `stock_code` varchar(32) DEFAULT NULL COMMENT '仓库代码',
  `stock_status` int(11) NOT NULL DEFAULT 1,
  `remark` varchar(32) DEFAULT NULL COMMENT '备注信息',
  `store_id` int(11) NOT NULL,
  `store_name` varchar(32) DEFAULT NULL,
  `stock_type` int(11) NOT NULL DEFAULT 1 COMMENT '仓库类型 (default is 1: type A, 2: B, 3: C)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COMMENT='仓库主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sites_stock`
--

LOCK TABLES `tbl_sites_stock` WRITE;
/*!40000 ALTER TABLE `tbl_sites_stock` DISABLE KEYS */;
INSERT INTO `tbl_sites_stock` VALUES (1001,'仓库名称一','310106-001',1,NULL,1001,NULL,1),(1002,'仓库名称二','310106-002',1,NULL,1001,NULL,1);
/*!40000 ALTER TABLE `tbl_sites_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sites_store`
--

DROP TABLE IF EXISTS `tbl_sites_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sites_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(32) NOT NULL COMMENT '门店名称',
  `store_code` varchar(32) DEFAULT NULL,
  `store_status` int(11) NOT NULL DEFAULT 1 COMMENT '门店状态 (1:active, 0: inactive)',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注信息',
  `store_type` int(11) NOT NULL DEFAULT 1 COMMENT '门店类型 (default is 1: type A, 2: B, 3: C)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COMMENT='门店主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sites_store`
--

LOCK TABLES `tbl_sites_store` WRITE;
/*!40000 ALTER TABLE `tbl_sites_store` DISABLE KEYS */;
INSERT INTO `tbl_sites_store` VALUES (1001,'门店名称一','310106-001',1,NULL,1),(1002,'门店名称二','301106-002',1,NULL,2);
/*!40000 ALTER TABLE `tbl_sites_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_stock_products`
--

DROP TABLE IF EXISTS `tbl_stock_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_stock_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_count` int(11) NOT NULL DEFAULT 0,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='仓库产品库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_stock_products`
--

LOCK TABLES `tbl_stock_products` WRITE;
/*!40000 ALTER TABLE `tbl_stock_products` DISABLE KEYS */;
INSERT INTO `tbl_stock_products` VALUES (1,1001,2001,10,NULL),(2,1001,2002,10,NULL),(3,1001,2003,10,NULL),(4,1002,2001,10,NULL),(5,1002,2002,10,NULL),(6,1002,2003,10,NULL);
/*!40000 ALTER TABLE `tbl_stock_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_store_products`
--

DROP TABLE IF EXISTS `tbl_store_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_store_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_count` int(11) NOT NULL DEFAULT 0,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='门店产品库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_store_products`
--

LOCK TABLES `tbl_store_products` WRITE;
/*!40000 ALTER TABLE `tbl_store_products` DISABLE KEYS */;
INSERT INTO `tbl_store_products` VALUES (1,1001,2001,10,NULL),(2,1001,2002,10,NULL),(3,1001,2003,10,NULL),(4,1002,2001,10,NULL),(5,1002,2002,10,NULL),(6,1002,2003,10,NULL);
/*!40000 ALTER TABLE `tbl_store_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 16:36:00
