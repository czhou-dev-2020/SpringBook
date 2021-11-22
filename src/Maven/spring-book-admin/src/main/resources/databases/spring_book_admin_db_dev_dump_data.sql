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
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `tbl_auth_group_roles`
--

LOCK TABLES `tbl_auth_group_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_group_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_group_roles` VALUES (1,101,101,NULL),(2,101,102,NULL),(3,101,103,NULL),(4,102,101,NULL),(5,102,102,NULL),(6,102,103,NULL),(7,103,101,NULL),(8,103,102,NULL),(9,103,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_group_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_groups`
--

LOCK TABLES `tbl_auth_groups` WRITE;
/*!40000 ALTER TABLE `tbl_auth_groups` DISABLE KEYS */;
INSERT INTO `tbl_auth_groups` VALUES (101,'Administrator Group','ADMIN',1,NULL),(102,'Normal User Group','NORMAL',1,NULL),(103,'Customer User Group','CUSTOMER',1,NULL);
/*!40000 ALTER TABLE `tbl_auth_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_roles`
--

LOCK TABLES `tbl_auth_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_roles` VALUES (101,'Administrator','ADMIN',1,NULL),(102,'Normal User','NORMAL',1,NULL),(103,'Guest User','GUEST',1,NULL),(104,'Regular User (Contract)','CONTRACT',1,NULL),(105,'Super User (VIP)','VIP',1,NULL),(106,'Super Guest User','SGUEST',1,NULL),(201,'Employee',NULL,1,NULL),(202,'Manager',NULL,1,NULL),(203,'Director',NULL,1,NULL),(204,'Vice President',NULL,1,NULL),(205,'President (CEO)',NULL,1,NULL),(206,'CTO',NULL,1,NULL),(207,'CFO',NULL,1,NULL),(208,'COO',NULL,1,NULL),(301,'Business Leader',NULL,1,NULL),(302,'Buesiness Developer (BD)',NULL,1,NULL),(1001,'Group Owner',NULL,1,NULL);
/*!40000 ALTER TABLE `tbl_auth_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_user_groups`
--

LOCK TABLES `tbl_auth_user_groups` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_groups` DISABLE KEYS */;
INSERT INTO `tbl_auth_user_groups` VALUES (1,2001,101,NULL),(2,2002,102,NULL),(3,2003,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_user_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_user_roles`
--

LOCK TABLES `tbl_auth_user_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_user_roles` VALUES (1,2001,101,NULL),(2,2002,102,NULL),(3,2003,103,NULL),(4,2001,102,NULL),(5,2002,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_user_tokens`
--

LOCK TABLES `tbl_auth_user_tokens` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_auth_user_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_auth_users`
--

LOCK TABLES `tbl_auth_users` WRITE;
/*!40000 ALTER TABLE `tbl_auth_users` DISABLE KEYS */;
INSERT INTO `tbl_auth_users` VALUES (2001,'admin','$2a$10$GH2UACuX4b7sXXkOIy3/p./Xa6IP.P89nc9wxfwoT5Am2y2qmufR.','crane zhou','crane_zhou@163.com','138xxxx5588','2018-10-08 20:01:00','2018-10-08 20:01:00',1,101,NULL,102,NULL,NULL,NULL,NULL),(2002,'normal','$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','Normal User Name','normal_user@hellosoft.com','138xxxx5587','2018-10-08 20:02:00','2018-10-08 20:02:00',1,102,NULL,102,NULL,NULL,NULL,NULL),(2003,'user03','$2a$10$atnN6.ggLrOD6QDKfHPkZOFyChrnImwMBUSgHcCbFzWq1cFAAuSH.','User Name 03','user03@hellosoft.com','138xxxx5586','2018-10-08 20:03:00','2018-10-08 20:03:00',1,102,NULL,102,NULL,NULL,NULL,NULL),(4001,'user4001','password','User Name 4001','user4001@rillsoft.net',NULL,'2021-09-29 21:43:13','2021-09-29 21:43:13',1,102,NULL,102,NULL,NULL,NULL,NULL),(4002,'user4002','password','User Name 4002','user4002@rillsoft.net',NULL,'2021-09-29 21:28:17','2021-09-29 21:28:17',1,102,NULL,102,NULL,NULL,NULL,NULL),(4003,'user4003','password2021-11-18 09:27:29','User Name 2021-11-18 09:27:29','user4003@rillsoft.net',NULL,'2021-09-29 21:26:09','2021-09-29 21:26:09',1,102,NULL,102,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_auth_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_goods_category`
--

LOCK TABLES `tbl_goods_category` WRITE;
/*!40000 ALTER TABLE `tbl_goods_category` DISABLE KEYS */;
INSERT INTO `tbl_goods_category` VALUES (1001,'书籍',NULL,NULL,1,NULL),(1002,'杂志',NULL,NULL,1,NULL),(2001,'饮料',NULL,NULL,1,NULL),(2002,'矿泉水',NULL,NULL,1,NULL),(3001,'茶叶',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `tbl_goods_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_goods_products`
--

LOCK TABLES `tbl_goods_products` WRITE;
/*!40000 ALTER TABLE `tbl_goods_products` DISABLE KEYS */;
INSERT INTO `tbl_goods_products` VALUES (2001,'可乐',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'百事可乐',1),(2002,'雪碧',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'柠檬味汽水',1),(2003,'橙汁',NULL,2001,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'果粒橙汁',1),(2004,'农夫山泉',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'农夫山泉 国产矿泉水',1),(2005,'冰露',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'冰露 国产矿泉水',1),(2006,'纯悦',NULL,2002,NULL,NULL,0,NULL,0,NULL,0,NULL,'瓶',5.00,100,'纯悦 国产矿泉水',1);
/*!40000 ALTER TABLE `tbl_goods_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_goods_resource`
--

LOCK TABLES `tbl_goods_resource` WRITE;
/*!40000 ALTER TABLE `tbl_goods_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_goods_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_sites_city`
--

LOCK TABLES `tbl_sites_city` WRITE;
/*!40000 ALTER TABLE `tbl_sites_city` DISABLE KEYS */;
INSERT INTO `tbl_sites_city` VALUES (1001,'Shanghai','021',1,'310000'),(1002,'HangZhou','0571',1,'330100'),(1003,'ShuZhou','0512',1,'320500');
/*!40000 ALTER TABLE `tbl_sites_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_sites_park`
--

LOCK TABLES `tbl_sites_park` WRITE;
/*!40000 ALTER TABLE `tbl_sites_park` DISABLE KEYS */;
INSERT INTO `tbl_sites_park` VALUES (1001,'ZhangJiang High-Tech Park','310115-001',1,1001,'Shanghai',NULL),(1002,'JinQiao Office Park','310115-002',1,1001,'Shanghai',NULL),(1003,'WaiGaoQiao Trade Park (Zone)','310115-003',1,1001,'Shanghai',NULL),(1004,'LuJiaZui Financial Trade Center (Zone)','310115-004',1,1001,'Shanghai',NULL);
/*!40000 ALTER TABLE `tbl_sites_park` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_sites_stock`
--

LOCK TABLES `tbl_sites_stock` WRITE;
/*!40000 ALTER TABLE `tbl_sites_stock` DISABLE KEYS */;
INSERT INTO `tbl_sites_stock` VALUES (1001,'仓库名称一','310106-001',1,NULL,1001,NULL,1),(1002,'仓库名称二','310106-002',1,NULL,1001,NULL,1);
/*!40000 ALTER TABLE `tbl_sites_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_sites_store`
--

LOCK TABLES `tbl_sites_store` WRITE;
/*!40000 ALTER TABLE `tbl_sites_store` DISABLE KEYS */;
INSERT INTO `tbl_sites_store` VALUES (1001,'门店名称一','310106-001',1,NULL,1),(1002,'门店名称二','301106-002',1,NULL,2);
/*!40000 ALTER TABLE `tbl_sites_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_stock_products`
--

LOCK TABLES `tbl_stock_products` WRITE;
/*!40000 ALTER TABLE `tbl_stock_products` DISABLE KEYS */;
INSERT INTO `tbl_stock_products` VALUES (1,1001,2001,10,NULL),(2,1001,2002,10,NULL),(3,1001,2003,10,NULL),(4,1002,2001,10,NULL),(5,1002,2002,10,NULL),(6,1002,2003,10,NULL);
/*!40000 ALTER TABLE `tbl_stock_products` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 16:35:46
