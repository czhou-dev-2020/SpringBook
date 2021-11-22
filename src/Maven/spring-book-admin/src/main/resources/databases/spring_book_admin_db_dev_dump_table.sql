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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 16:35:34
