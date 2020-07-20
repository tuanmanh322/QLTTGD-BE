-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: qlttgd
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actions`
--

DROP TABLE IF EXISTS `actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_actions` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_actions` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statuss` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actions`
--

LOCK TABLES `actions` WRITE;
/*!40000 ALTER TABLE `actions` DISABLE KEYS */;
INSERT INTO `actions` VALUES (1,'ACTION','LIKE','LIKE BAI VIẾT'),(2,'ACTION','DISLIKE','DISLIKE BÀI VIẾT'),(3,'ACTION','COMMENT','BÌNH LUẬN'),(4,'ACTION','REPCOMMENT','TRẢ LỜI BÌNH LUẬN'),(5,'ACTION','ACCEPT','DUYỆT BÀI'),(6,'ACTION','DECIDE','TỪ CHỐI DUYỆT BÀI'),(7,'ACTION','LIKE COMMENT','LIKE COMMENT'),(8,'ACTION','DISLIKE COMMENT','DISLIKE COMMENT'),(9,'ACTION','LIKE_REPCOMMENT','LIKE COMMENT'),(10,'ACTION','DISLIKE_REPCOMMENT','DISLIKE COMMENT'),(11,'ACTION','POINTS','CẬP NHẬT ĐIỂM');
/*!40000 ALTER TABLE `actions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baiviet`
--

DROP TABLE IF EXISTS `baiviet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `baiviet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_baiviet` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noidung` text,
  `luotthich` int(11) DEFAULT NULL,
  `luotkhongthich` int(11) DEFAULT NULL,
  `id_the` int(11) DEFAULT NULL,
  `ma_chude` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `title` text,
  `image_path` text,
  `trangthai` tinyint(1) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baiviet`
--

LOCK TABLES `baiviet` WRITE;
/*!40000 ALTER TABLE `baiviet` DISABLE KEYS */;
INSERT INTO `baiviet` VALUES (3,'BV_3','Cho hình bình hành ABCD. Phép tịnh tiến TAB→ + AD→ biến điểm A thành điểm:',12,4,3,2,'2020-02-04 00:00:00','cho 1 ',NULL,1,5),(4,'BV_4','Cho đường tròn (C) có tâm O và đường kính AB. Gọi ∆ là tiếp tuyến của (C) tại điểm A. Phép tịnh tiến TAB→ biến ∆ thành:',3,5,4,2,'2020-04-14 00:00:00','cho 2',NULL,1,7),(5,'BV_5','Cho v→(3;3) và đường tròn (C): x2 + y2 - 2x + 4y - 4 = 0. ảnh của (C) qua Tv→ là (C’).',77,5,5,3,'2020-01-23 00:00:00','cho 3',NULL,1,1),(6,'BV_6','Cho​​ a→​​ và​​ b→​​ là hai vectơ cùng hướng và đều khác vectơ​​ 0→. Mệnh đề nào sau đây đúng?',4,3,6,1,'2020-01-07 00:00:00','cho test cho',NULL,1,1),(7,'BV_7','Cho hai vectơ​​ a→​​ và​​ b→​​ khác​​ 0→. Xác định góc​​ α​​ giữa hai vectơ​​ a→​​ và​​ b→​​ khi​​ a→.b→=-a→.b→.',4,79,7,1,'2020-04-30 00:00:00','cho test cho',NULL,1,1),(8,'BV_8','Cho hai vectơ​​ a→​​ và​​ b→​​ thỏa mãn​​ a→=3,​​ b→=2​​ và​​ a→.b→=-3.​​ Xác định góc​​ α​​ giữa hai vectơ​​ a→​​ và​​ b→.',7,55,8,2,'2020-03-31 00:00:00','cho test cho',NULL,1,21),(9,'BV_9','Cho hai vectơ​​ a→​​ và​​ b→. Đẳng thức nào sau đây sai?',89,44,1,3,'2020-03-30 00:00:00','cho test cho',NULL,1,2),(22,NULL,'<p>test test test</p><figure class=\"image\"><img src=\"http://localhost:1234/api/media/1592149820124_ongbut-removebg-preview.png\"></figure>',2,1,1,5,'2020-06-14 22:50:29','cho test cho',NULL,1,2),(23,NULL,'<figure class=\"image\"><img src=\"http://localhost:1234/api/media/1592216025759_ongbut-image.png\"></figure>',0,0,1,5,'2020-06-15 17:13:48','teeeeees',NULL,0,1),(24,NULL,'<h2>123123</h2><figure class=\"image\"><img src=\"http://localhost:1234/api/media/1592360559777_87047440_10158217486053969_159800546079801344_n.jpg\"></figure>',7,5,8,1,'2020-06-17 09:22:42','tessst',NULL,1,16),(25,NULL,'<h2>123</h2><figure class=\"image\"><img src=\"http://localhost:1234/api/media/1592360605613_hoa1.jpg\"></figure>',17,7,6,9,'2020-06-17 09:23:28','test',NULL,1,18),(26,NULL,'<figure class=\"image\"><img src=\"http://localhost:1234/api/media/1592361423739_86971839_10158217485938969_9135951903144804352_n.jpg\"></figure>',32,16,8,5,'2020-06-17 09:37:05','wwww',NULL,1,91),(28,NULL,'<figure class=\"image\"><img src=\"http://localhost:1234/api/media/1594131302132_maths-ftr.jpg\"></figure><p>undefined</p>',36,22,4,3,'2020-07-07 21:15:03','dsfsdfweqw',NULL,1,53);
/*!40000 ALTER TABLE `baiviet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethocphi`
--

DROP TABLE IF EXISTS `chitiethocphi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chitiethocphi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenhocphi` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `giatien` decimal(18,2) DEFAULT NULL,
  `ngaythu` date DEFAULT NULL,
  `trangthai` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethocphi`
--

LOCK TABLES `chitiethocphi` WRITE;
/*!40000 ALTER TABLE `chitiethocphi` DISABLE KEYS */;
INSERT INTO `chitiethocphi` VALUES (1,'HP1',99999.00,'2020-05-01','1'),(2,'HP2',99992.00,'2020-05-01','1'),(3,'HP3',99993.00,'2020-05-01','1'),(4,'HP4',99994.00,'2020-05-01','1'),(5,'HP5',99995.00,'2020-05-01','1'),(6,'HP6',99996.00,'2020-05-01','1'),(7,'HP7',99997.00,'2020-05-01','1'),(8,'HP8',99998.00,'2020-05-01','1'),(9,'HP9',999991.00,'2020-05-01','1');
/*!40000 ALTER TABLE `chitiethocphi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chude`
--

DROP TABLE IF EXISTS `chude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chude` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_chude` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenchude` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noidung` text,
  `id_hangmuc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chude`
--

LOCK TABLES `chude` WRITE;
/*!40000 ALTER TABLE `chude` DISABLE KEYS */;
INSERT INTO `chude` VALUES (1,'CD_1','Hình học không gian','Hình học không gian',1),(2,'CD_2','HỆ THỨC VI-ET VÀ ỨNG DỤNG','HỆ THỨC VI-ET VÀ ỨNG DỤNG',2),(3,'CD_3','CĂN THỨC – BIẾN ĐỔI CĂN THỨC.','CĂN THỨC – BIẾN ĐỔI CĂN THỨC.',4),(4,'CD_4','PHƯƠNG TRÌNH BẬC HAI – ĐỊNH LÝ VI-ÉT.','PHƯƠNG TRÌNH BẬC HAI – ĐỊNH LÝ VI-ÉT.',4),(5,'CD_5','HỆ PHƯƠNG TRÌNH','HỆ PHƯƠNG TRÌNH',2),(6,'CD_6','HÀM SỐ ĐỒ TH','HÀM SỐ ĐỒ TH',1),(7,'CD_7','CHỨNG MINH HAI TAM GIÁC ĐỒNG DẠNG','CHỨNG MINH HAI TAM GIÁC ĐỒNG DẠNG',2),(8,'CD_8','CHỨNG MINH TỨ GIÁC NỘI TIẾP','CHỨNG MINH TỨ GIÁC NỘI TIẾP',3),(9,'CD_9','Chứng minh các điểm thẳng hàng, các đường thẳng đồng quy.','Chứng minh các điểm thẳng hàng, các đường thẳng đồng quy.',4),(13,'CD_13','HÌNH HỌC KHÔNG GIAN','tetst',6);
/*!40000 ALTER TABLE `chude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_comment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noidung` text,
  `luotthich` int(11) DEFAULT NULL,
  `loutkhongthich` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_baiviet` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `image_path` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,'CM_2','Đáp án B đúng',772,1,1,2,NULL,NULL),(4,'CM_4','Đáp án D đúng',773,1,1,2,NULL,NULL),(6,'CM_6','Câu này khó quá',77,1,1,2,NULL,NULL),(7,'CM_7','Đáp án mình làm ra không giống',772,1,1,3,NULL,NULL),(32,NULL,'<p>sdasd</p>',NULL,NULL,34,26,'2020-06-24 09:51:15',NULL),(33,NULL,'<figure class=\"image\"><img src=\"http://localhost:1234/api/media/1594049047033_1592216025759_ongbut-image.png\"></figure>',NULL,NULL,1,26,'2020-07-06 22:24:09',NULL),(34,NULL,'<p>test</p>',NULL,NULL,3,28,'2020-07-10 09:50:06',NULL),(35,NULL,'<p>aaa</p>',2,NULL,1,28,'2020-07-10 11:31:05',NULL),(36,NULL,'<p>â</p>',2,NULL,1,28,'2020-07-10 11:40:32',NULL),(37,NULL,'<p>sss</p>',NULL,NULL,1,26,'2020-07-10 11:49:35',NULL),(38,NULL,'<p>qq</p>',1,NULL,1,28,'2020-07-10 15:57:08',NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  `status` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (2,'Contact','cc@gmail.com','0316548971','test');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controls`
--

DROP TABLE IF EXISTS `controls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `controls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_controls` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_controls` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statuss` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controls`
--

LOCK TABLES `controls` WRITE;
/*!40000 ALTER TABLE `controls` DISABLE KEYS */;
INSERT INTO `controls` VALUES (1,'CT_1','CT 1TEST','TEST'),(2,'CT_2','CT 1TEST2','TEST'),(3,'CT_3','CT 1TEST3','TEST'),(4,'CT_4','CT 1TEST4','TEST'),(5,'CT_5','CT 1TEST5','TEST'),(6,'CT_6','CT 1TEST6','TEST'),(7,'CT_7','CT 1TEST7','TEST'),(8,'CT_8','CT 1TEST8','TEST'),(9,'CT_9','CT 1TEST9','TEST');
/*!40000 ALTER TABLE `controls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `diem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_diem` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diemmieng` float DEFAULT NULL,
  `diem15p` float DEFAULT NULL,
  `diem90p` float DEFAULT NULL,
  `diemtb` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES (9,'MD_9',2,4,5,4),(47,NULL,6,7,8,6),(48,NULL,6,8,8.2,7.6),(51,NULL,9,8,8,8),(52,NULL,6,7,8,6),(53,NULL,6,8,8.2,7.6),(56,NULL,9,8,8,8),(72,NULL,6,7,8,6),(73,NULL,6,8,8.2,7.6),(74,NULL,9,8,8,8),(76,NULL,9,8,8,8),(77,NULL,10,10,5,7.5),(96,NULL,6,7,8,6),(97,NULL,6,8,8.2,7.6),(98,NULL,9,8,8,8),(100,NULL,9,8,8,8),(101,NULL,10,10,5,7.5),(107,NULL,10,10,5,7.5),(108,NULL,8,7,8,6),(109,NULL,7,8,8.2,7.6),(110,NULL,9,8,8,8),(111,NULL,7,10,5,7.5),(112,NULL,8,8,8,8),(113,NULL,10,10,5,7.5);
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_district` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'HN','DA');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text,
  `noidung` text,
  `created_date` datetime DEFAULT NULL,
  `link_download` text,
  `id_the` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (12,'tesst','sadasd','2020-06-15 00:24:45','http://localhost:1234/api/media/1592155485499_100baipython.docx',2);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_group` varchar(20) DEFAULT NULL,
  `name_group` varchar(50) DEFAULT NULL,
  `statuss` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'GR_1','GR 1','TEST GR'),(2,'GR_2','GR 2','TEST GR'),(3,'GR_3','GR 3','TEST GR'),(4,'GR_4','GR 4','TEST GR'),(5,'GR_5','GR 5','TEST GR'),(6,'GR_6','GR 6','TEST GR'),(7,'GR_7','GR 7','TEST GR'),(8,'GR_8','GR 8','TEST GR');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_role`
--

DROP TABLE IF EXISTS `groups_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_group` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_roles` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_role`
--

LOCK TABLES `groups_role` WRITE;
/*!40000 ALTER TABLE `groups_role` DISABLE KEYS */;
INSERT INTO `groups_role` VALUES (1,'GR_1','RO_1'),(2,'GR_2','RO_2'),(3,'GR_3','RO_3'),(4,'GR_4','RO_4'),(5,'GR_5','RO_5'),(6,'GR_6','RO_6'),(7,'GR_7','RO_7'),(8,'GR_8','RO_8'),(9,'GR_9','RO_9');
/*!40000 ALTER TABLE `groups_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hangmuc`
--

DROP TABLE IF EXISTS `hangmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hangmuc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_hangmucbaiviet` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenhangmuc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mota` text,
  `ma_monhoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangmuc`
--

LOCK TABLES `hangmuc` WRITE;
/*!40000 ALTER TABLE `hangmuc` DISABLE KEYS */;
INSERT INTO `hangmuc` VALUES (1,'HM_1','Đại số 6','HM T1',5),(2,'HM_2','Đại số 8','HM T2',2),(3,'HM_3','Hình học 7','HM T3',3),(4,'HM_4','Hình học 8','HM T4',4),(5,'HM_5','Hình học 9','HM T5',5),(6,'HM_6','Hình học 10','HM T6',6),(7,'HM_7','Đại số 7','HM T7',7),(8,'HM_8','Đại số 8','HM T8',8),(9,'HM_9','Đại số 9','HM T9',9);
/*!40000 ALTER TABLE `hangmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaithe`
--

DROP TABLE IF EXISTS `loaithe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loaithe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_loaithe` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenloaithe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaithe`
--

LOCK TABLES `loaithe` WRITE;
/*!40000 ALTER TABLE `loaithe` DISABLE KEYS */;
INSERT INTO `loaithe` VALUES (1,'LT_1','Học sinh'),(2,'LT_2','Giáo viên');
/*!40000 ALTER TABLE `loaithe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_lop` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenlop` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `siso` int(11) DEFAULT NULL,
  `thoigianbatdau` date DEFAULT NULL,
  `thoigianketthuc` date DEFAULT NULL,
  `diadiem` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `hocphi` decimal(18,2) DEFAULT NULL,
  `ma_monhoc` int(11) DEFAULT NULL,
  `kip_day` varchar(200) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `giobatdau` time DEFAULT NULL,
  `gioketthuc` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (29,'ML_1','toán 9 k10',30,'2020-06-26','2020-05-30','HN',3000000.00,1,'1',NULL,NULL,NULL),(36,'ML_2','toán 9 123',30,'2020-05-12','2020-05-26','HN',3000000.00,2,'2',NULL,NULL,NULL),(37,'ML_3','toán 9 k9',30,'2020-05-12','2020-05-12','HN',3000000.00,3,'3',NULL,NULL,NULL),(38,'ML_4','ôn luyện đề',30,'2020-05-12','2020-07-21','HN',3000000.00,4,'4',NULL,NULL,NULL),(39,'ML_5','ôn cấp tốc vào 10',30,'2020-05-12','2020-07-21','HN',3000000.00,5,'5',NULL,NULL,NULL),(41,'ML_6','ôn thi quốc gia 12',30,'2020-05-12','2020-07-21','HN',3000000.00,6,'2',NULL,NULL,NULL),(45,'ML_7','toán 8 k12',30,'2020-05-05','2020-07-21','HN',3000000.00,7,'1',NULL,NULL,NULL),(46,'ML_8','toán 8 k10',30,'2020-06-28','2020-07-21','HN',3000000.00,8,'3',NULL,NULL,NULL),(49,'ML_9','toán 8 k9',30,'2020-06-28','2020-07-21','HN',3000000.00,4,'4',NULL,NULL,NULL),(54,'ML_10','toán 7',30,'2020-06-28','2020-07-21','HN',3000000.00,1,'5',NULL,NULL,NULL),(55,'ML_11','toán 7 k10',30,'2020-06-28','2020-07-21','HN',3000000.00,2,'1',NULL,NULL,NULL),(56,'ML_12','toán 7 k12',30,'2020-06-28','2020-07-21','HN',3000000.00,3,'1',NULL,NULL,NULL),(74,'ML_13','toán 6',NULL,NULL,NULL,NULL,NULL,1,'4',NULL,NULL,NULL);
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `monhoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_monhoc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenmonhoc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'MH_1','toán 6'),(2,'MH_2','toán 6'),(3,'MH_3','toán 8'),(4,'MH_4','toán 9'),(5,'MH_5','toán 10'),(6,'MH_6','toán 11');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhatcheckin`
--

DROP TABLE IF EXISTS `nhatcheckin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhatcheckin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_nhatky` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ma_the` int(11) DEFAULT NULL,
  `thoigianvao` datetime DEFAULT NULL,
  `status` text,
  `id_lop` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhatcheckin`
--

LOCK TABLES `nhatcheckin` WRITE;
/*!40000 ALTER TABLE `nhatcheckin` DISABLE KEYS */;
INSERT INTO `nhatcheckin` VALUES (53,NULL,3,'2020-07-01 15:02:36','CHECKIN',37),(54,NULL,3,'2020-07-02 15:02:36','CHECKIN',36),(55,NULL,18,'2020-06-30 22:48:09','CHECKIN',46),(56,NULL,4,'2020-06-30 22:51:12','CHECKIN',39),(57,NULL,63,'2020-07-02 15:02:36','CHECKIN',37),(58,NULL,3,'2020-07-03 12:25:13','CHECKIN',36),(59,NULL,4,'2020-07-10 10:03:44','CHECKIN',37),(60,NULL,4,'2020-07-10 10:04:01','CHECKIN',36);
/*!40000 ALTER TABLE `nhatcheckin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_the` int(11) DEFAULT NULL,
  `id_action` int(11) DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `id_baiviet` int(11) DEFAULT NULL,
  `id_comment` int(11) DEFAULT NULL,
  `id_rep_comment` int(11) DEFAULT NULL,
  `id_diem` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (240,1,2,1,'DISLIKE BÀI VIẾT','2020-07-10 10:38:24',28,NULL,NULL,NULL),(241,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:38:25',28,NULL,NULL,NULL),(243,1,2,0,'DISLIKE BÀI VIẾT','2020-07-10 10:43:00',25,NULL,NULL,NULL),(244,1,1,0,'LIKE BAI VIẾT','2020-07-10 10:43:01',25,NULL,NULL,NULL),(254,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:22',26,NULL,NULL,NULL),(255,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:23',26,NULL,NULL,NULL),(256,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:25',26,NULL,NULL,NULL),(257,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:25',26,NULL,NULL,NULL),(258,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:26',26,NULL,NULL,NULL),(259,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:26',26,NULL,NULL,NULL),(260,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:26',26,NULL,NULL,NULL),(261,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:27',26,NULL,NULL,NULL),(262,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:50:27',26,NULL,NULL,NULL),(263,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:52:10',28,NULL,NULL,NULL),(264,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:52:13',28,NULL,NULL,NULL),(265,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:52:14',28,NULL,NULL,NULL),(266,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:52:15',28,NULL,NULL,NULL),(267,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:53:54',22,NULL,NULL,NULL),(268,1,2,1,'DISLIKE BÀI VIẾT','2020-07-10 10:53:55',22,NULL,NULL,NULL),(269,1,1,1,'LIKE BAI VIẾT','2020-07-10 10:53:56',22,NULL,NULL,NULL),(270,1,2,0,'DISLIKE BÀI VIẾT','2020-07-10 10:54:01',7,NULL,NULL,NULL),(271,1,2,0,'DISLIKE BÀI VIẾT','2020-07-10 10:54:03',7,NULL,NULL,NULL),(272,1,1,1,'LIKE BAI VIẾT','2020-07-10 11:14:11',9,NULL,NULL,NULL),(273,1,2,1,'DISLIKE BÀI VIẾT','2020-07-10 11:14:11',9,NULL,NULL,NULL),(274,1,1,1,'LIKE BAI VIẾT','2020-07-10 11:22:01',24,NULL,NULL,NULL),(275,1,1,1,'LIKE BAI VIẾT','2020-07-10 11:22:02',24,NULL,NULL,NULL),(276,1,2,1,'DISLIKE BÀI VIẾT','2020-07-10 11:22:16',4,NULL,NULL,NULL),(277,1,1,1,'LIKE BAI VIẾT','2020-07-10 11:22:17',8,NULL,NULL,NULL),(278,1,1,1,'LIKE BAI VIẾT','2020-07-10 11:22:18',8,NULL,NULL,NULL),(279,1,3,1,'BÌNH LUẬN','2020-07-10 11:31:05',28,NULL,NULL,NULL),(280,1,3,1,'BÌNH LUẬN','2020-07-10 11:40:32',28,NULL,NULL,NULL),(281,8,4,1,'TRẢ LỜI BÌNH LUẬN','2020-07-10 11:43:51',28,NULL,NULL,NULL),(282,1,3,1,'BÌNH LUẬN','2020-07-10 11:49:35',26,NULL,NULL,NULL),(283,8,2,1,'DISLIKE BÀI VIẾT','2020-07-10 15:54:23',28,NULL,NULL,NULL),(284,8,2,1,'DISLIKE BÀI VIẾT','2020-07-10 15:54:23',28,NULL,NULL,NULL),(285,1,3,0,'BÌNH LUẬN','2020-07-10 15:57:08',28,NULL,NULL,NULL),(290,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:26:26',28,38,NULL,NULL),(291,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:26:26',28,38,NULL,NULL),(292,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:26:36',28,38,NULL,NULL),(293,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:26:44',28,38,NULL,NULL),(294,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:27:00',28,35,NULL,NULL),(295,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:27:01',28,35,NULL,NULL),(296,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:27:02',28,35,NULL,NULL),(297,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:27:03',28,35,NULL,NULL),(298,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:27:04',28,35,NULL,NULL),(299,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:27:10',28,36,NULL,NULL),(300,1,8,0,'ĐẪ KHÔNG THÍCH BÌNH LUẬN CỦA','2020-07-14 11:27:10',28,36,NULL,NULL),(301,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:27:11',28,36,NULL,NULL),(302,1,7,0,'ĐÃ THÍCH BÌNH LUẬN CỦA ','2020-07-14 11:27:12',28,36,NULL,NULL);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'PROVINCE1','TEST 1'),(2,'PROVINCE2','TEST 1'),(3,'PROVINCE3','TEST 1'),(4,'PROVINCE4','TEST 1'),(5,'PROVINCE5','TEST 1'),(6,'PROVINCE6','TEST 1'),(7,'PROVINCE7','TEST 1'),(8,'PROVINCE8','TEST 1'),(9,'PROVINCE9','TEST 1');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repcomment`
--

DROP TABLE IF EXISTS `repcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `repcomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_repcomment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noidung` text,
  `luotthich` int(11) DEFAULT NULL,
  `luotkhongthich` int(11) DEFAULT NULL,
  `id_comment` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `image_path` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repcomment`
--

LOCK TABLES `repcomment` WRITE;
/*!40000 ALTER TABLE `repcomment` DISABLE KEYS */;
INSERT INTO `repcomment` VALUES (7,'CM_7','Cảm ơn bạn',22,1,4,3,NULL,NULL),(10,NULL,'<p>www</p>',NULL,NULL,32,1,'2020-07-06 22:01:12',NULL),(11,NULL,'<p>www</p>',NULL,NULL,32,1,'2020-07-06 22:10:03',NULL),(12,NULL,'<p>s</p>',NULL,NULL,33,1,'2020-07-06 22:33:47',NULL),(13,NULL,'<figure class=\"image\"><img src=\"http://localhost:1234/api/media/1594131069175_guitar.jpg\"></figure><p>&nbsp;</p>',NULL,NULL,33,4,'2020-07-07 21:11:12',NULL),(14,NULL,'<p>test</p>',NULL,NULL,34,3,'2020-07-10 09:50:10',NULL),(15,NULL,'<p>aaaaa</p>',NULL,NULL,35,8,'2020-07-10 11:43:51',NULL);
/*!40000 ALTER TABLE `repcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statuss` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE','ROLE_ADMIN','TEST 1'),(2,'ROLE','ROLE_TEACHER','TEST 2'),(3,'ROLE','ROLE_STUDENT','TEST 3'),(4,'ROLE','ROLE_ANONYMOUS','TEST 4'),(5,'RO_5','RO TEST 4','TEST 5'),(6,'RO_6','RO TEST 5','TEST 6'),(7,'RO_7','RO TEST 6','TEST 7'),(8,'RO_8','RO TEST 7','TEST 8'),(9,'RO_9','RO TEST 8','TEST 9');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_action`
--

DROP TABLE IF EXISTS `roles_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_roles` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_action` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_action`
--

LOCK TABLES `roles_action` WRITE;
/*!40000 ALTER TABLE `roles_action` DISABLE KEYS */;
INSERT INTO `roles_action` VALUES (1,'RO_1','AC_1'),(2,'RO_2','AC_2'),(3,'RO_3','AC_3'),(4,'RO_4','AC_4'),(5,'RO_5','AC_5'),(6,'RO_6','AC_6'),(7,'RO_7','AC_7'),(8,'RO_8','AC_8'),(9,'RO_9','AC_9');
/*!40000 ALTER TABLE `roles_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_control`
--

DROP TABLE IF EXISTS `roles_control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles_control` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_roles` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_controls` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_control`
--

LOCK TABLES `roles_control` WRITE;
/*!40000 ALTER TABLE `roles_control` DISABLE KEYS */;
INSERT INTO `roles_control` VALUES (1,'RO_1','CT_1'),(2,'RO_2','CT_2'),(3,'RO_3','CT_3'),(4,'RO_4','CT_4'),(5,'RO_5','CT_5'),(6,'RO_6','CT_6'),(7,'RO_7','CT_7'),(8,'RO_8','CT_8'),(9,'RO_9','CT_9');
/*!40000 ALTER TABLE `roles_control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the`
--

DROP TABLE IF EXISTS `the`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `the` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_the` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaycap` date DEFAULT NULL,
  `trangthai` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ma_loaithe` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the`
--

LOCK TABLES `the` WRITE;
/*!40000 ALTER TABLE `the` DISABLE KEYS */;
INSERT INTO `the` VALUES (1,'admin','2020-05-01','1','LT_1','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',1),(3,'hocsinh','2020-05-01','1','LT_3','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(4,'giaovien1','2020-05-01','1','LT_4','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',2),(5,'giaovien2','2020-05-01','1','LT_5','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',4),(6,'giaovien3','2020-05-01','1','LT_6','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(7,'giaovien4','2020-05-01','1','LT_7','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(8,'giaovien5','2020-05-01','1','LT_8','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(9,'customer','2020-05-01','1','LT_9','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',4),(18,'15150287','2020-06-21','1','LT_10','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(31,'12127622','2020-06-23','1',NULL,'$2a$10$eyyNZpbGcX7qpGAs.Xejx.OxsBWRsXyd2XnbxSe/YAzqSbfeHKOIG',2),(32,'12129688','2020-06-23','0',NULL,'$2a$10$MzYB9xsGeLweCijqmeGBy.ZGJ1lqV1EJLMK6VJ32EwJyKS1nWM6q2',2),(34,'11112151','2020-06-24','1',NULL,'$2a$10$Qn9vzeGPw9l.0r//x7YeSuUf2xvOTHynpwvrEK4BvjapQns7zXHoa',4),(37,'15114519','2020-06-30','0',NULL,'$2a$10$7x1Fk.xwF6HQM1QlV9spSe804LRy/LYNlhkaDLo0fwZ15SGYkxXHu',3),(68,'15166137','2020-07-13','1',NULL,'$2a$10$dnjVSBIG3nvQv7sdN.iJH.X/JD16rSr.wMzUkYvlIfSqqV07G2kGO',3),(69,'15172850','2020-07-13','1',NULL,'$2a$10$KH5KrubKf/ReQDVfM.0dE.SU/Ix56kf0UihSp4k3vC11xk4yvL49S',3),(70,'15136824','2020-07-13','1',NULL,'$2a$10$I7oJ2LibCnCMAiYRTgByXetv91Arx197nCs69PsEb0.GmEzn2weVm',3),(71,'15169323','2020-07-13','1',NULL,'$2a$10$zxMzz7Lkk/VWsls4zvuupeiuyYX48QXi4P0Z9VhEqV6ipjlqoZcEm',3),(72,'15193858','2020-07-13','1',NULL,'$2a$10$USZ7C0DiLt/nOsiQuXCMZeYM/XuvS9ukYpruezYPCjgOXoYiK9L/K',3),(73,'15162840','2020-07-13','1',NULL,'$2a$10$SCFLug5t2B.p8oPsytFm/OOVog8z3Ap6cXqBLnJgmZR7yk8sUAF2u',3),(74,'15190097','2020-07-13','1',NULL,'$2a$10$T.6mgjTXxmZ1CkGWjTejw.biQu7cS52cfUl4B5ivb3zfOW4DJv.5a',3),(75,'15120329','2020-07-13','1',NULL,'$2a$10$2AXfFwbM0nw2DPFiEeuB2uohC3jqb7XludMgfrGmX44EmNVApThFS',3),(76,'15146324','2020-07-13','1',NULL,'$2a$10$MARoyL7kQKBDUNmorsdyfuLsTT/Sm8EppQ0/pVQHp/pkqsN9Syby2',3),(77,'15132912','2020-07-13','1',NULL,'$2a$10$3eZ6l3BPyIrcqJrVMKT4D.E.8MVnsSIypDeemMVIcG4R.dTKDN5Wu',3),(78,'15171625','2020-07-13','1',NULL,'$2a$10$vToGjLHTldFKcyQKV2Mo9.MlLamb5j4eKQ1cmZ.0oiswMjJMw2BJa',3),(79,'15170712','2020-07-13','1',NULL,'$2a$10$yV.AyKO5BxlpXE4CvYjcA.9iTD9nR4tap2czP2ki5hZlZkqv8PA4i',3);
/*!40000 ALTER TABLE `the` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_lop_mapper`
--

DROP TABLE IF EXISTS `user_lop_mapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_lop_mapper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_lop` int(11) DEFAULT NULL,
  `trangthai` tinyint(4) DEFAULT NULL,
  `is_teach` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_lop_mapper`
--

LOCK TABLES `user_lop_mapper` WRITE;
/*!40000 ALTER TABLE `user_lop_mapper` DISABLE KEYS */;
INSERT INTO `user_lop_mapper` VALUES (5,3,46,1,0),(6,3,49,1,0),(7,9,36,1,0),(8,3,36,1,0),(9,4,37,1,0),(10,5,37,1,0),(13,9,37,1,0),(14,3,38,1,0),(15,9,29,1,0),(16,9,38,1,0),(17,3,49,1,0),(18,3,37,1,0),(19,3,38,1,0),(20,3,39,1,0),(27,4,29,1,1),(28,4,36,1,1),(29,4,37,1,1),(30,4,38,1,1),(31,4,39,1,1),(32,4,29,1,1),(33,4,36,1,1),(34,4,37,1,1),(35,4,38,1,1),(36,4,39,1,1),(38,4,29,1,1),(40,4,36,1,1),(42,4,37,1,1),(44,4,38,1,1),(46,4,39,1,1),(142,8,36,1,0),(143,8,37,1,0),(144,8,38,1,0),(145,8,39,1,0),(209,4,29,1,1),(211,4,36,1,1),(213,4,37,1,1),(215,4,38,1,1),(217,4,39,1,1),(219,4,41,1,1),(221,4,29,1,1),(223,4,36,1,1),(225,4,37,1,1),(227,4,38,1,1),(229,4,39,1,1),(231,4,41,1,1),(233,4,29,1,1),(235,4,36,1,1),(237,4,37,1,1),(239,4,38,1,1),(241,4,39,1,1),(243,4,41,1,1),(244,113,54,NULL,NULL);
/*!40000 ALTER TABLE `user_lop_mapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gioitinh` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `socmt` int(11) DEFAULT NULL,
  `quoctich` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quequan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `noiohientai` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `hokhau` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quatrinhlamviec` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sodt` varchar(11) DEFAULT NULL,
  `luongcoban` double DEFAULT NULL,
  `ma_the` int(11) DEFAULT NULL,
  `ma_lop` int(11) DEFAULT NULL,
  `image_path` text,
  `is_teacher` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'USER_1','Nguyễn Đình Đức12','NAM','1999-02-15',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,'TEST1@gMAIL.COM','231231233',NULL,1,29,'http://localhost:1234/api/media/1591953037216_85244311_10158217486263969_7350014023686946816_n.jpg',0),(4,'USER_4','Lê Tuấn Anh','NAM','1999-02-22',3123133,'Việt Nam','NAM ĐỊNH','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST4@gMAIL.COM','231231233',0,4,37,NULL,1),(5,'USER_5','Lê Văn Nhật','NAM','1999-02-22',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST5@gMAIL.COM','231231233',0,5,37,NULL,0),(6,'USER_6','Hoàng Tuấn Anh','NAM','1999-02-22',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST6@gMAIL.COM','231231233',0,6,37,NULL,0),(7,'USER_7','Lê Văn Hoàng','NAM','1999-02-22',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST7@gMAIL.COM','231231233',0,7,39,NULL,0),(8,'USER_8','Lê Diệu hà','Nu','1999-02-22',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST8@gMAIL.COM','231231233',0,8,41,NULL,0),(9,'USER_9','Lâm Quang Huy','NAM','1999-02-22',3123133,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','GOOD','TEST@gMAIL.COM','231231233',0,9,37,NULL,0),(39,NULL,'Nguyễn Thị Test',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,NULL,0),(40,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(41,NULL,'Đặng Mạnh Tuấn',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(42,NULL,'Đồng Thị Thủy',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(43,NULL,'Hoàng Thanh Thảo',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(44,NULL,'Nguyễn Thị Test',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(45,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(46,NULL,'Đặng Mạnh Tuấn',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(47,NULL,'Đồng Thị Thủy',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(48,NULL,'Hoàng Thanh Thảo',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(49,NULL,'Nguyễn Thị Test',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(50,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(51,NULL,'Đặng Mạnh Tuấn',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(52,NULL,'Đồng Thị Thủy',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(53,NULL,'Hoàng Thanh Thảo',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(54,NULL,'Nguyễn Thị B',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(55,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(56,NULL,'Đặng Mạnh C',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(57,NULL,'Đồng Thị D',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(58,NULL,'Hoàng Thanh E',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(59,NULL,'Nguyễn Thị B',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(60,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(61,NULL,'Đặng Mạnh C',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(62,NULL,'Đồng Thị D',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(63,NULL,'Hoàng Thanh E',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(64,NULL,'Nguyễn Thị B',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(65,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(66,NULL,'Đặng Mạnh C',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(67,NULL,'Đồng Thị D',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(68,NULL,'Hoàng Thanh E',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(69,NULL,'Th G',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(70,NULL,'Tuấn','NAM','2020-06-01',12312312,'VN','DA','DA HN','DA HN','1','tyt.paladin@gmail.com','334567454',12000000,18,1,'http://localhost:1234/api/media/1591953037216_85244311_10158217486263969_7350014023686946816_n.jpg',0),(71,NULL,'Nguyễn Thị B',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(72,NULL,'Nguyễn Văn A',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(73,NULL,'Đặng Mạnh C',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(74,NULL,'Đồng Thị D',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(75,NULL,'Hoàng Thanh E',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(76,NULL,'Th G',NULL,'1999-02-22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(80,NULL,'tuảnetest',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tesut@gmail.com',NULL,NULL,34,NULL,NULL,0),(83,NULL,'Tế','Nữ',NULL,NULL,NULL,'HN',NULL,NULL,NULL,NULL,'123123123',NULL,37,NULL,NULL,NULL),(114,NULL,'test','Nam','2020-07-12',NULL,NULL,'ádasd',NULL,NULL,NULL,NULL,'123123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658133013_103154030_296959398100366_216732505627266566_n.jpg',0),(115,NULL,'test','Nam','2020-07-12',NULL,NULL,'ádasd',NULL,NULL,NULL,NULL,'123123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658139358_103154030_296959398100366_216732505627266566_n.jpg',0),(116,NULL,'âsasss','Nam','2020-07-12',NULL,NULL,'111',NULL,NULL,NULL,NULL,'123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658174249_103154030_296959398100366_216732505627266566_n.jpg',0),(117,NULL,'âsasss','Nam','2020-07-12',NULL,NULL,'111',NULL,NULL,NULL,NULL,'123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658174421_103154030_296959398100366_216732505627266566_n.jpg',0),(118,NULL,'tesst','Nu','2020-07-09',NULL,NULL,'2222222',NULL,NULL,NULL,NULL,'123123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658226680_103154030_296959398100366_216732505627266566_n.jpg',0),(119,NULL,'tesst','Nu','2020-07-09',NULL,NULL,'2222222',NULL,NULL,NULL,NULL,'123123',NULL,NULL,NULL,'http://localhost:1234/api/media/1594658226841_103154030_296959398100366_216732505627266566_n.jpg',0),(122,NULL,'tét','Nu','2020-07-09',NULL,NULL,'123',NULL,NULL,NULL,NULL,'123',NULL,76,NULL,'http://localhost:1234/api/media/1594658432205_103154030_296959398100366_216732505627266566_n.jpg',0),(123,NULL,'tét','Nu','2020-07-09',NULL,NULL,'123',NULL,NULL,NULL,NULL,'123',NULL,77,NULL,'http://localhost:1234/api/media/1594658502515_103154030_296959398100366_216732505627266566_n.jpg',0),(124,NULL,'ưqqw','Nam','2020-07-07',NULL,NULL,'124124',NULL,NULL,NULL,NULL,'123',NULL,78,NULL,'http://localhost:1234/api/media/1594658588933_103154030_296959398100366_216732505627266566_n.jpg',0),(125,NULL,'ưqqw','Nam','2020-07-07',NULL,NULL,'124124',NULL,NULL,NULL,NULL,'123',NULL,79,NULL,'http://localhost:1234/api/media/1594658595408_103154030_296959398100366_216732505627266566_n.jpg',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_diem_map`
--

DROP TABLE IF EXISTS `users_diem_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_diem_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_diem` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_diem_map`
--

LOCK TABLES `users_diem_map` WRITE;
/*!40000 ALTER TABLE `users_diem_map` DISABLE KEYS */;
INSERT INTO `users_diem_map` VALUES (9,4,9),(10,5,10),(11,4,11),(12,4,12),(13,9,15),(14,3,16),(22,9,25),(23,9,26),(24,3,27),(25,3,28),(26,3,29),(27,3,30),(44,39,47),(45,40,48),(48,43,51),(49,44,52),(50,45,53),(53,48,56),(69,64,72),(70,65,73),(71,66,74),(73,68,76),(74,69,77),(93,71,96),(94,72,97),(95,73,98),(97,75,100),(98,76,101),(104,70,107),(105,8,98),(106,8,101),(107,8,100),(108,8,107),(109,70,108),(110,70,109),(111,70,110),(112,70,111),(113,70,112),(114,70,113);
/*!40000 ALTER TABLE `users_diem_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_district` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
INSERT INTO `ward` VALUES (1,'DISTRICT 1','TEST DISTRICT 1 '),(2,'DISTRICT 2','TEST DISTRICT 2 '),(3,'DISTRICT 3','TEST DISTRICT 3 '),(4,'DISTRICT 4','TEST DISTRICT 4 '),(5,'DISTRICT 5','TEST DISTRICT 5 '),(6,'DISTRICT 6','TEST DISTRICT 6 '),(7,'DISTRICT 7','TEST DISTRICT 7 '),(8,'DISTRICT 8','TEST DISTRICT 8 ');
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-20 15:33:52
