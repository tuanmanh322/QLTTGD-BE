-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actions`
--

LOCK TABLES `actions` WRITE;
/*!40000 ALTER TABLE `actions` DISABLE KEYS */;
INSERT INTO `actions` VALUES (1,'ACTION','LIKE','LIKE BAI VIẾT'),(2,'ACTION','DISLIKE','DISLIKE BÀI VIẾT'),(3,'ACTION','COMMENT','BÌNH LUẬN'),(4,'ACTION','REPCOMMENT','TRẢ LỜI BÌNH LUẬN'),(5,'AC_5','TEST5','TEST5'),(6,'AC_6','TEST6','TEST6'),(7,'AC_7','TEST7','TEST7'),(8,'AC_8','TEST8','TEST8'),(9,'AC_9','TEST9','TEST9'),(10,'AC_10','TEST10','TEST10');
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
INSERT INTO `baiviet` VALUES (1,'BV_1','Trong kì thi tốt nghiệp THCS, mỗi phòng thi đều có 24 thí sinh được xếp vào 6 dãy bàn, mỗi dãy có 4 thí sinh. Có 24 tờ giấy nháp với 3 loại màu Xanh, Đỏ, Tím sẽ đuocẹ phát cho 24 thí sinh trong phòng thi. Hãy viết chương trình giúp cho Giám thị phát giất nháp sao cho mỗi thí sinh sử dụng một màu giấy nháp không trùng với mày của các bạn ngồi ở vị trí sau, phải, trái đối với thí sinh đó.\r\n\r\n1. Yêu cầu :\r\n\r\n+ In ra màn hình tất cả sơ đồ phát giấy nháp có thể thực hiện được.\r\n\r\n+ Tổng số giấy nháp mỗi loại được sử dụng.\r\n\r\nLưu ý : Các bạn có thể giải theo file hoặc không cần. Nhưng mình cần file hơn ạ. Mong mọi người giúp đỡ.',2,1,1,1,'2020-06-02 00:00:00','Anh chị giúp em bài này với ạ',NULL,1,18),(3,'BV_3','Cho hình bình hành ABCD. Phép tịnh tiến TAB→ + AD→ biến điểm A thành điểm:',0,0,3,2,'2020-02-04 00:00:00','Help me please',NULL,1,4),(5,'BV_5','Cho tam giác ABC vuông tại A , đường cao AH , biết AB = 21cm ; AC = 28cm .\r\n\r\na/Tính AH\r\n\r\nb/ Kẻ HD AB; HE AC .Tính diện tích tam giác AED.',0,0,5,3,'2020-01-23 00:00:00','Tam giác đồng dạng',NULL,1,1),(6,'BV_6','Một trường học có 1000 học sinh gồm 23 lớp. Chứng minh rằng phải có ít nhất một lớp có từ 44 học sinh trở lên',1,0,6,1,'2020-01-07 00:00:00','Định lý Diricle',NULL,1,1),(7,'BV_7','1 - 3 + 5 - 7 + ... + 2005 - 2007 + 2009 - 2011',1,0,7,1,'2020-04-30 00:00:00','Tính giá trị của biểu thức',NULL,1,1),(8,'BV_8','Một người đi xe đạp từ A đến B với vận tốc 20km/h ; Lúc quay về đi với vận tốc 15km/h nên thời gian về hơn thời gian đi 10 phút . Tính quãng đường AB ?​​ a→​​ và​​ b→.',0,0,8,2,'2020-03-31 00:00:00','Giải toán đố',NULL,1,23),(9,'BV_9','Cho hai vectơ​​ a→​​ và​​ b→. Đẳng thức nào sau đây sai?',0,0,1,3,'2020-03-30 00:00:00','cho test cho',NULL,1,2),(28,NULL,'<p>&nbsp;</p><figure class=\"image\"><img src=\"http://localhost:1234/api/media/1596640778550_image.png\"></figure>',0,0,3,5,'2020-08-05 22:19:55','Giúp em câu hỏi này với',NULL,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chude`
--

LOCK TABLES `chude` WRITE;
/*!40000 ALTER TABLE `chude` DISABLE KEYS */;
INSERT INTO `chude` VALUES (1,'CD_1','ƯCLN, BCNN','Ước chung lớn nhất, bội chung nhỏ nhất',1),(2,'CD_2','Thực hiện phép tính với số nguyên','Thực hiện phép tính trên tập hợp số nguyên',1),(3,'CD_3','CĂN THỨC – BIẾN ĐỔI CĂN THỨC.','CĂN THỨC – BIẾN ĐỔI CĂN THỨC.',10),(4,'CD_4','Thực hiện phép tính','Các bài toán liên quan đến thực hiện phép tính',1),(5,'CD_5','Điểm, Tia','Hỏi đáp các bài toán liên quan đến điểm và tia ',2),(6,'CD_6','Số nguyên tố','Bài tập về số nguyên tố',3),(7,'CD_7','Một số bài toán khác','Dạng khác',3),(8,'CD_8','Định lý Diricle','Bài toán chuồng thỏ',3),(9,'CD_9','Chứng minh các điểm thẳng hàng, các đường thẳng đồng quy.','Chứng minh các điểm thẳng hàng, các đường thẳng đồng quy.',11),(10,'CD_10','Số chính phương','Bài tập số chính phương',6),(11,'CD_11','Tam giác bằng nhau','Bài tập về tam giác bằng nhau',5),(12,'CD_12','Tam giác đồng dạng','Bài tập về tam giác đồng dạng',8),(13,'CD_13','Rút gọn biểu thức','Bài tập rút gọn',10),(14,'CD_14','Giải bài toán bằng cách lập phương trình','Giải bài toán bằng cách lập pt',7),(15,'CD_15','Giải bài toán bằng cách lập pt hoặc hệ pt','Giải bài toán bằng cách lập pt hoặc hệ pt',10),(16,'CD_16','Phương trình nghiệm nguyên','Phương trình nghiệm nguyên',12),(17,'CD_17','Phương trình vô tỉ','Phương trình vô tỉ',12),(18,'CD_18','Bất đẳng thức','Bất đẳng thức',10);
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'CM_1','Mình cũng muốn hỏi câu như thế này.',1,0,1,1,NULL,NULL),(2,'CM_2','Đáp án B đúng',0,0,1,2,NULL,NULL),(3,'CM_3','Đáp án C đúng',1,0,1,1,NULL,NULL),(4,'CM_4','Đáp án D đúng',0,0,1,2,NULL,NULL),(5,'CM_5','Đáp án A đúng',1,0,1,1,NULL,NULL),(6,'CM_6','Câu này khó quá',0,0,1,2,NULL,NULL),(7,'CM_7','Đáp án mình làm ra không giống',0,0,1,3,NULL,NULL),(32,NULL,'<p>sdasd</p>',NULL,NULL,34,26,'2020-06-24 09:51:15',NULL),(33,NULL,'<p>câu hỏi hay quá</p>',1,NULL,3,8,'2020-08-05 22:18:05',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES (150,NULL,6,7,8,6),(151,NULL,6,8,8.2,7.6),(152,NULL,9,8,8,8),(153,NULL,10,10,5,7.5),(154,NULL,9,8,8,8),(155,NULL,10,10,5,7.5),(156,NULL,6,7,8,6),(157,NULL,6,8,8.2,7.6),(158,NULL,9,8,8,8),(159,NULL,10,10,5,7.5),(160,NULL,9,8,8,8),(161,NULL,10,10,5,7.5);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangmuc`
--

LOCK TABLES `hangmuc` WRITE;
/*!40000 ALTER TABLE `hangmuc` DISABLE KEYS */;
INSERT INTO `hangmuc` VALUES (1,'HM_T6_DS','Đại số 6','HM T1',2),(2,'HM_T6_HH','Hình học 6','HM T2',2),(3,'HM_T6_SH','Số học 6','HM T3',2),(4,'HM_T7_DS','Đại số 7','HM T4',2),(5,'HM_T7_HH','Hình học 7','HM T5',2),(6,'HM_T7_SH','Số học 7','HM T6',2),(7,'HM_T8_DS','Đại số 8','HM T7',2),(8,'HM_T8_HH','Hình học 8','HM T8',2),(9,'HM_T8_SH','Số học 8','HM T9',2),(10,'HM_T9_DS','Đại số 9','HM T10',2),(11,'HM_T9_HH','Hình học 9','HM T11',2),(12,'HM_T9_SH','Số học 9','HM T12',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (29,'ML_1','toán 6 Đại ',30,'2020-06-26','2020-05-30','HN',3000000.00,1,'1',NULL,NULL,NULL),(36,'ML_2','toán 6 Hình',30,'2020-05-12','2020-05-26','HN',3000000.00,1,'2',NULL,NULL,NULL),(37,'ML_3','toán 7 Đại ',30,'2020-05-12','2020-05-12','HN',3000000.00,1,'3',NULL,NULL,NULL),(38,'ML_4','toán 7 Hình',30,'2020-05-12','2020-09-18','HN',3000000.00,1,'4',NULL,NULL,NULL),(39,'ML_5','toán 8 Đại ',30,'2020-05-12','2020-09-18','HN',3000000.00,1,'5',NULL,NULL,NULL),(41,'ML_6','toán 8 Hình',30,'2020-05-12','2020-09-18','HN',3000000.00,1,'2',NULL,NULL,NULL),(45,'ML_7','toán 9 Đại ',30,'2020-05-05','2020-09-18','HN',3000000.00,1,'1',NULL,NULL,NULL),(46,'ML_8','toán 9 Hình',30,'2020-06-28','2020-09-18','HN',3000000.00,1,'3',NULL,NULL,NULL),(76,'ML_9','toán 6 Số',30,'2020-06-28','2020-09-18','HN',3000000.00,1,'1',NULL,NULL,NULL),(77,'ML_10','toán 7 Số',30,'2020-06-28','2020-09-18','HN',3000000.00,1,'2',NULL,NULL,NULL),(78,'ML_11','toán 8 Số',30,'2020-06-28','2020-09-18','HN',3000000.00,1,'3',NULL,NULL,NULL),(79,'ML_12','toán 9 Số',30,'2020-06-28','2020-09-02','HN',3000000.00,1,'4',NULL,NULL,NULL);
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
INSERT INTO `monhoc` VALUES (1,'MH_1','Toán'),(2,'MH_2','Tin');
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
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhatcheckin`
--

LOCK TABLES `nhatcheckin` WRITE;
/*!40000 ALTER TABLE `nhatcheckin` DISABLE KEYS */;
INSERT INTO `nhatcheckin` VALUES (71,NULL,85,'2020-08-17 00:16:14','CHECKIN',79),(72,NULL,86,'2020-08-17 00:16:27','CHECKIN',46),(73,NULL,87,'2020-08-17 00:16:39','CHECKIN',79),(74,NULL,88,'2020-08-17 00:16:48','CHECKIN',79),(75,NULL,89,'2020-08-17 00:16:57','CHECKIN',79),(76,NULL,90,'2020-08-17 00:17:05','CHECKIN',46),(77,NULL,91,'2020-08-17 00:17:12','CHECKIN',46),(78,NULL,92,'2020-08-17 00:17:19','CHECKIN',46),(79,NULL,93,'2020-08-17 00:17:26','CHECKIN',46),(80,NULL,94,'2020-08-17 00:17:33','CHECKIN',46),(81,NULL,85,'2020-08-16 00:16:14','CHECKIN',79),(82,NULL,85,'2020-08-16 00:16:14','CHECKIN',79),(83,NULL,85,'2020-08-14 00:16:14','CHECKIN',79),(84,NULL,85,'2020-08-13 00:16:14','CHECKIN',79),(85,NULL,85,'2020-08-12 00:16:14','CHECKIN',79),(86,NULL,85,'2020-08-11 00:16:14','CHECKIN',79),(87,NULL,85,'2020-08-10 00:16:14','CHECKIN',79),(88,NULL,85,'2020-08-09 00:16:14','CHECKIN',79),(89,NULL,85,'2020-08-08 00:16:14','CHECKIN',79),(90,NULL,85,'2020-08-07 00:16:14','CHECKIN',79),(91,NULL,85,'2020-08-06 00:16:14','CHECKIN',79),(92,NULL,85,'2020-08-05 00:16:14','CHECKIN',79),(93,NULL,85,'2020-08-04 00:16:14','CHECKIN',79),(94,NULL,85,'2020-08-03 00:16:14','CHECKIN',79),(95,NULL,85,'2020-08-02 00:16:14','CHECKIN',79),(96,NULL,86,'2020-08-16 00:16:14','CHECKIN',46),(97,NULL,86,'2020-08-15 00:16:14','CHECKIN',46),(98,NULL,86,'2020-08-14 00:16:14','CHECKIN',46),(99,NULL,86,'2020-08-13 00:16:14','CHECKIN',46),(100,NULL,86,'2020-08-14 00:16:14','CHECKIN',46),(101,NULL,86,'2020-08-12 00:16:14','CHECKIN',46),(102,NULL,86,'2020-08-11 00:16:14','CHECKIN',46),(103,NULL,86,'2020-08-10 00:16:14','CHECKIN',46),(104,NULL,86,'2020-08-09 00:16:14','CHECKIN',46),(105,NULL,86,'2020-08-08 00:16:14','CHECKIN',46),(106,NULL,86,'2020-08-07 00:16:14','CHECKIN',46),(107,NULL,86,'2020-08-06 00:16:14','CHECKIN',46),(108,NULL,90,'2020-08-16 00:16:14','CHECKIN',46),(109,NULL,90,'2020-08-15 00:16:14','CHECKIN',46),(110,NULL,90,'2020-08-14 00:16:14','CHECKIN',46),(111,NULL,90,'2020-08-13 00:16:14','CHECKIN',46),(112,NULL,90,'2020-08-14 00:16:14','CHECKIN',46),(113,NULL,90,'2020-08-12 00:16:14','CHECKIN',46),(114,NULL,90,'2020-08-11 00:16:14','CHECKIN',46),(115,NULL,90,'2020-08-10 00:16:14','CHECKIN',46),(116,NULL,90,'2020-08-09 00:16:14','CHECKIN',46),(117,NULL,90,'2020-08-08 00:16:14','CHECKIN',46),(118,NULL,90,'2020-08-07 00:16:14','CHECKIN',46),(119,NULL,90,'2020-08-06 00:16:14','CHECKIN',46),(120,NULL,91,'2020-08-16 00:16:14','CHECKIN',46),(121,NULL,91,'2020-08-15 00:16:14','CHECKIN',46),(122,NULL,91,'2020-08-14 00:16:14','CHECKIN',46),(123,NULL,91,'2020-08-13 00:16:14','CHECKIN',46),(124,NULL,91,'2020-08-14 00:16:14','CHECKIN',46),(125,NULL,91,'2020-08-12 00:16:14','CHECKIN',46),(126,NULL,91,'2020-08-11 00:16:14','CHECKIN',46),(127,NULL,91,'2020-08-10 00:16:14','CHECKIN',46),(128,NULL,91,'2020-08-09 00:16:14','CHECKIN',46),(129,NULL,91,'2020-08-08 00:16:14','CHECKIN',46),(130,NULL,91,'2020-08-07 00:16:14','CHECKIN',46),(131,NULL,91,'2020-08-06 00:16:14','CHECKIN',46),(132,NULL,92,'2020-08-16 00:16:14','CHECKIN',46),(133,NULL,92,'2020-08-15 00:16:14','CHECKIN',46),(134,NULL,92,'2020-08-14 00:16:14','CHECKIN',46),(135,NULL,92,'2020-08-13 00:16:14','CHECKIN',46),(136,NULL,92,'2020-08-14 00:16:14','CHECKIN',46),(137,NULL,92,'2020-08-12 00:16:14','CHECKIN',46),(138,NULL,92,'2020-08-11 00:16:14','CHECKIN',46),(139,NULL,92,'2020-08-10 00:16:14','CHECKIN',46),(140,NULL,92,'2020-08-09 00:16:14','CHECKIN',46),(141,NULL,92,'2020-08-08 00:16:14','CHECKIN',46),(142,NULL,92,'2020-08-07 00:16:14','CHECKIN',46),(143,NULL,92,'2020-08-06 00:16:14','CHECKIN',46),(144,NULL,93,'2020-08-16 00:16:14','CHECKIN',46),(145,NULL,93,'2020-08-15 00:16:14','CHECKIN',46),(146,NULL,93,'2020-08-14 00:16:14','CHECKIN',46),(147,NULL,93,'2020-08-13 00:16:14','CHECKIN',46),(148,NULL,93,'2020-08-14 00:16:14','CHECKIN',46),(149,NULL,93,'2020-08-12 00:16:14','CHECKIN',46),(150,NULL,93,'2020-08-11 00:16:14','CHECKIN',46),(151,NULL,93,'2020-08-10 00:16:14','CHECKIN',46),(152,NULL,93,'2020-08-09 00:16:14','CHECKIN',46),(153,NULL,93,'2020-08-08 00:16:14','CHECKIN',46),(154,NULL,93,'2020-08-07 00:16:14','CHECKIN',46),(155,NULL,93,'2020-08-06 00:16:14','CHECKIN',46),(156,NULL,94,'2020-08-16 00:16:14','CHECKIN',46),(157,NULL,94,'2020-08-15 00:16:14','CHECKIN',46),(158,NULL,94,'2020-08-14 00:16:14','CHECKIN',46),(159,NULL,94,'2020-08-13 00:16:14','CHECKIN',46),(160,NULL,94,'2020-08-14 00:16:14','CHECKIN',46),(161,NULL,94,'2020-08-12 00:16:14','CHECKIN',46),(162,NULL,94,'2020-08-11 00:16:14','CHECKIN',46),(163,NULL,94,'2020-08-10 00:16:14','CHECKIN',46),(164,NULL,94,'2020-08-09 00:16:14','CHECKIN',46),(165,NULL,94,'2020-08-08 00:16:14','CHECKIN',46),(166,NULL,94,'2020-08-07 00:16:14','CHECKIN',46),(167,NULL,94,'2020-08-06 00:16:14','CHECKIN',46),(168,NULL,87,'2020-08-16 00:16:14','CHECKIN',79),(169,NULL,87,'2020-08-15 00:16:14','CHECKIN',79),(170,NULL,87,'2020-08-14 00:16:14','CHECKIN',79),(171,NULL,87,'2020-08-13 00:16:14','CHECKIN',79),(172,NULL,87,'2020-08-14 00:16:14','CHECKIN',79),(173,NULL,87,'2020-08-12 00:16:14','CHECKIN',79),(174,NULL,87,'2020-08-11 00:16:14','CHECKIN',79),(175,NULL,87,'2020-08-10 00:16:14','CHECKIN',79),(176,NULL,87,'2020-08-09 00:16:14','CHECKIN',79),(177,NULL,87,'2020-08-08 00:16:14','CHECKIN',79),(178,NULL,87,'2020-08-07 00:16:14','CHECKIN',79),(179,NULL,87,'2020-08-06 00:16:14','CHECKIN',79),(180,NULL,88,'2020-08-16 00:16:14','CHECKIN',79),(181,NULL,88,'2020-08-15 00:16:14','CHECKIN',79),(182,NULL,88,'2020-08-14 00:16:14','CHECKIN',79),(183,NULL,88,'2020-08-13 00:16:14','CHECKIN',79),(184,NULL,88,'2020-08-14 00:16:14','CHECKIN',79),(185,NULL,88,'2020-08-12 00:16:14','CHECKIN',79),(186,NULL,88,'2020-08-11 00:16:14','CHECKIN',79),(187,NULL,88,'2020-08-10 00:16:14','CHECKIN',79),(188,NULL,88,'2020-08-09 00:16:14','CHECKIN',79),(189,NULL,88,'2020-08-08 00:16:14','CHECKIN',79),(190,NULL,88,'2020-08-07 00:16:14','CHECKIN',79),(191,NULL,88,'2020-08-06 00:16:14','CHECKIN',79),(192,NULL,89,'2020-08-16 00:16:14','CHECKIN',79),(193,NULL,89,'2020-08-15 00:16:14','CHECKIN',79),(194,NULL,89,'2020-08-14 00:16:14','CHECKIN',79),(195,NULL,89,'2020-08-13 00:16:14','CHECKIN',79);
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
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (220,3,1,0,'LIKE BAI VIẾT','2020-08-05 23:02:57',1,NULL,NULL,NULL),(221,3,1,0,'LIKE BAI VIẾT','2020-08-05 23:03:00',7,NULL,NULL,NULL),(222,3,1,0,'LIKE BAI VIẾT','2020-08-05 23:03:03',6,NULL,NULL,NULL),(223,3,2,0,'DISLIKE BÀI VIẾT','2020-08-05 23:03:23',1,NULL,NULL,NULL),(224,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,157),(225,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,158),(226,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,159),(227,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,160),(228,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,161),(229,4,11,0,'CẬP NHẬT ĐIỂM','2020-08-07 00:58:33',NULL,NULL,NULL,162);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repcomment`
--

LOCK TABLES `repcomment` WRITE;
/*!40000 ALTER TABLE `repcomment` DISABLE KEYS */;
INSERT INTO `repcomment` VALUES (1,'CM_1','hay quá',22,1,1,1,NULL,NULL),(3,'CM_3','Mình nghĩ là đáp án khác',22,1,3,3,NULL,NULL),(4,'CM_4','Rất hay',22,1,1,1,NULL,NULL),(7,'CM_7','Cảm ơn bạn',22,1,4,3,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the`
--

LOCK TABLES `the` WRITE;
/*!40000 ALTER TABLE `the` DISABLE KEYS */;
INSERT INTO `the` VALUES (1,'admin','2020-05-01','1','LT_1','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',1),(3,'hocsinh','2020-05-01','1','LT_3','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(5,'giaovien2','2020-05-01','1','LT_5','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',4),(6,'giaovien3','2020-05-01','1','LT_6','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(7,'giaovien4','2020-05-01','1','LT_7','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(8,'giaovien5','2020-05-01','1','LT_8','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(9,'customer','2020-05-01','1','LT_9','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',4),(18,'15150287','2020-06-21','1','LT_10','$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly',3),(31,'12127622','2020-06-23','1',NULL,'$2a$10$eyyNZpbGcX7qpGAs.Xejx.OxsBWRsXyd2XnbxSe/YAzqSbfeHKOIG',2),(32,'12129688','2020-06-23','0',NULL,'$2a$10$MzYB9xsGeLweCijqmeGBy.ZGJ1lqV1EJLMK6VJ32EwJyKS1nWM6q2',2),(34,'11112151','2020-06-24','1',NULL,'$2a$10$Qn9vzeGPw9l.0r//x7YeSuUf2xvOTHynpwvrEK4BvjapQns7zXHoa',4),(37,'15114519','2020-06-30','0',NULL,'$2a$10$7x1Fk.xwF6HQM1QlV9spSe804LRy/LYNlhkaDLo0fwZ15SGYkxXHu',3),(67,'15109754','2020-08-07','1',NULL,'$2a$10$tCLq8Ou3hsitMh0wRtfq0OLMbkR20wvUJXV8.gmk6eF2rwYXMhzHK',3),(68,'12312323','2020-08-07','1',NULL,'$2a$10$xg5jmB9Ur4dn1i6g98vKsufP9hWUVBX6IANYMVCCkSu6qryN1KyJ6',3),(69,'12341233','2020-08-07','1',NULL,'$2a$10$5ybaKKIznkjAaUgGX58Eq.3LRqoF6zDlIT1RMav9xGBt32/xMB8N.',3),(70,'42342345','2020-08-07','1',NULL,'$2a$10$Aaq6TkJXoawsFc3ItzvkGO5MyFB9H.B.q8R.lkAek1uuXU2qurUZ2',3),(71,'46345345','2020-08-07','1',NULL,'$2a$10$VzbrnGr/u04y/avCEbFRle2LUEg5HgdkOXKFTEbmEe4.Gg3RXGVoO',3),(72,'56456433','2020-08-07','1',NULL,'$2a$10$zoTsEKIsVJuOyBFpMd4.neCiSD88e3/CHk8bgHLwIjg0aQ7On6M3q',3),(73,'65467564','2020-08-07','1',NULL,'$2a$10$.hfnXCoPBAmHRMZjTv6eSuT9/frLfvcyIJsiCzFq6NSU4AzYrafkC',3),(74,'15138675','2020-08-07','1',NULL,'$2a$10$fko7wnqUSKuQdrjmHcZGK.ssI5cIhJZ43EP3ttFv5gb8S2gKvjNXu',3),(75,'15184499','2020-08-08','1',NULL,'$2a$10$4mgZ.V6qg5Reoy9z12jzeu3Vzmew8ujL5dG083munxKQbeX/vL93m',3),(85,'15150297','2020-08-16','1',NULL,'$2a$10$pbGSjAf3K7bf4OKXaraYu.to0dmXGjWBqreau2niZOY3Fi.K8eKkK',2),(86,'15150223','2020-08-16','1',NULL,'$2a$10$80JGiaH65Ef3hUyITpRQiePmI5eewIvOHA./tVcloMHRQFtT.V5Si',2),(87,'15150204','2020-08-16','1',NULL,'$2a$10$dBKuRfj5i51VxMAUvR8A7uhxH8mgRtG/CYlImm/LbcxQwNBWwdRSq',3),(88,'15150201','2020-08-16','1',NULL,'$2a$10$UdD22lQG4nccxIp6dzKTVexA.03wrmCMPFA3Zn99ojbOXpb4bb39e',3),(89,'15150206','2020-08-16','1',NULL,'$2a$10$3ZlUp55tTWqdPRot64WYaeu4EspqZLkAUQKgnAUZlyfZHNAux4VxC',3),(90,'15150208','2020-08-16','1',NULL,'$2a$10$8A.BdGsn3rV5hIQoctY5AulXh3OcJnfTbz1mYV.YbzKDXfrdUb1hq',3),(91,'15150203','2020-08-16','1',NULL,'$2a$10$6dc.FLfwbuOf4yPjqF4eIugzHfYcB4jrwBUlQ9XDRM8Z1ZVdxZAqu',3),(92,'15150207','2020-08-16','1',NULL,'$2a$10$l9OPvd/ZV2mFdEpIK8XWY.iuAFa6CseO3kvmdnKZnmzZeDD/iTXA6',3),(93,'15122203','2020-08-16','1',NULL,'$2a$10$fjx6/gNWkIQ66MP2hS99COSd.gjji2vcoZGs6ej24YtpBOQfOo9bC',3),(94,'15150205','2020-08-16','1',NULL,'$2a$10$B5NwsbrXwUgEdIqFJy9z1.5JvX6O8FrFrJotA8oJr7lICameFuU22',3);
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
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_lop_mapper`
--

LOCK TABLES `user_lop_mapper` WRITE;
/*!40000 ALTER TABLE `user_lop_mapper` DISABLE KEYS */;
INSERT INTO `user_lop_mapper` VALUES (5,83,76,1,0),(7,80,76,1,0),(8,76,76,1,0),(9,75,76,1,0),(10,74,76,1,0),(13,73,76,1,0),(14,72,76,1,0),(15,71,76,1,0),(16,69,76,1,0),(18,5,45,1,0),(19,6,45,1,0),(20,7,45,1,0),(27,8,45,1,1),(28,9,45,1,1),(29,39,45,1,1),(30,40,45,1,1),(31,41,45,1,1),(32,42,45,1,1),(34,70,45,1,1),(35,43,45,1,1),(36,44,45,1,1),(38,45,45,1,1),(40,50,37,1,1),(42,51,37,1,1),(44,52,37,1,1),(46,53,37,1,1),(142,54,37,1,0),(143,55,37,1,0),(144,56,37,1,0),(145,57,37,1,0),(209,58,37,1,1),(211,59,37,1,1),(213,60,37,1,1),(215,62,37,1,1),(217,45,36,1,1),(219,44,36,1,1),(221,43,36,1,1),(223,42,36,1,1),(225,41,36,1,1),(227,40,36,1,1),(229,39,36,1,1),(231,9,36,1,1),(233,8,36,1,1),(235,7,36,1,1),(237,6,36,1,1),(239,5,36,1,1),(241,56,38,1,1),(243,57,38,1,1),(244,59,38,0,NULL),(245,60,38,0,NULL),(246,114,29,1,0),(248,115,36,1,0),(250,116,37,1,0),(252,117,38,1,0),(254,118,39,1,0),(256,119,41,1,0),(258,114,29,1,NULL),(260,115,36,1,NULL),(262,116,37,1,NULL),(264,117,38,1,NULL),(266,118,39,1,NULL),(268,119,41,1,NULL),(270,4,37,NULL,NULL),(271,4,37,NULL,NULL),(272,122,79,NULL,NULL),(274,124,79,1,1),(275,125,46,1,1),(276,124,79,NULL,NULL),(277,125,46,NULL,NULL),(278,126,79,1,0),(279,127,79,1,0),(280,128,79,1,0),(281,129,46,1,0),(282,130,46,1,0),(283,131,46,1,0),(284,132,46,1,0),(285,133,46,1,0);
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
  `socmt` varchar(12) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'USER_1','Nguyễn Ngọc Hà','NAM','1996-02-13','113254548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,'TEST1@gMAIL.COM','231231233',NULL,1,29,'http://localhost:1234/api/media/1591953037216_85244311_10158217486263969_7350014023686946816_n.jpg',0),(5,'USER_5','Lê Văn Nhật','NAM','2005-07-21','113274548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST5@gMAIL.COM','231231233',0,5,37,NULL,0),(7,'USER_7','Lê Văn Hoàng','NAM','2005-01-18','113274548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST7@gMAIL.COM','231231233',0,7,39,NULL,0),(8,'USER_8','Lê Diệu hà','Nu','2005-12-21','113274548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','12/12','TEST8@gMAIL.COM','231231233',0,8,41,NULL,0),(9,'USER_9','Lâm Quang Huy','NAM','2005-07-26','113274548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','GOOD','TEST@gMAIL.COM','231231233',0,9,37,NULL,0),(39,'USER_10','Nguyễn Huy Trường 2','NAM','2005-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,'0981231963',NULL,3,NULL,NULL,0),(40,'USER_10','Đỗ Trần Tú Anh','Nu','2005-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(41,'USER_10','Đặng Mạnh Tuấn','NAM','2005-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(42,'USER_10','Lưu Phương Anh','Nu','2005-10-03',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(43,'USER_11','Hoàng Thanh Thảo','Nu','2005-07-22',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(44,'USER_12','Nguyễn Viết Phong','NAM','2005-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(45,'USER_13','Nguyễn Thị Khánh Chi','Nu','2005-07-21',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(46,'USER_14','Đào Duy Tập','NAM','1985-08-01',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(47,'USER_15','Nguyễn Đức Thắng','NAM','2005-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(48,'USER_16','Tưởng Ngân Hà','Nu','2005-12-23',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(49,'USER_17','Nguyễn Minh Trí','NAM','2005-11-21',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(50,'USER_18','Tạ Khánh Linh','Nu','2007-07-12',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(51,'USER_19','Nguyễn Hạnh Nguyên ','Nu','2007-05-25',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(52,'USER_20','Nguyễn Thị Hồng Hạnh','Nu','2007-07-07',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(53,'USER_21','Ngô Đức Duẩn','NAM','2007-05-01',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(54,'USER_22','Phan Khánh Linh','Nu','2007-07-17',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(55,'USER_23','Phạm Trà My','Nu','2007-06-06',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(56,'USER_24','Ngô Trung Hiếu','NAM','2007-07-06',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(57,'USER_25','Tô Khánh Ngọc','Nu','2007-05-01',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(58,'USER_26','Ngô Thị Hồng Thơm','Nu','2007-12-31',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(59,'USER_27','Phạm Thu Trang','Nu','2007-01-05',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(60,'USER_28','Nguyễn Đình Kha','NAM','2007-02-03',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(61,'USER_29','Nguyễn Minh Hải','NAM','2007-02-05',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(62,'USER_30','Bùi Thùy Dương','Nu','2007-08-15',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(63,'USER_31','Nguyễn Thanh Lương','Nu','2007-06-06',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(64,'USER_32','Trịnh Minh Hiếu','NAM','2007-03-16',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(65,'USER_33','Đào Thu Thảo','Nu','2007-07-21',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(66,'USER_34','Ngô Thu Thảo','Nu','2007-07-12',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(67,'USER_35','Nguyễn Thanh Thảo','Nu','2007-10-16',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(68,'USER_36','Đào Hoàng Ngân','Nu','2007-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(69,'USER_37','Nguyễn Gia Hưng','NAM','2008-07-30',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(70,'USER_2','Nguyễn Đức Hưng','NAM','2005-06-06','113234548','Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI','1','tyt.paladin@gmail.com','334567454',12000000,18,1,'http://localhost:1234/api/media/1591953037216_85244311_10158217486263969_7350014023686946816_n.jpg',0),(71,'USER_39','Nguyễn Đình Giang','NAM','2008-07-30',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(72,'USER_40','Lê Kim Anh','Nu','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(73,'USER_41','Bùi Thu Trà','Nu','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(74,'USER_42','Nguyễn Thị Nguyệt','Nu','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(75,'USER_43','Lê Doãn Trung Hiếu','NAM','2008-07-16',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(76,'USER_44','Nguyễn Đức Thịnh','NAM','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(80,'USER_45','Nguyễn Văn Tính','NAM','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,'tesut@gmail.com',NULL,NULL,34,NULL,NULL,0),(83,'USER_47','Nguyễn Tiến Quang','NAM','2008-07-26',NULL,'Việt Nam','HÀ NỘI','THANH TRÌ - HÀ NỘI','THANH TRÌ - HÀ NỘI',NULL,NULL,'123123123',NULL,37,NULL,NULL,NULL),(124,'GV_85','Nguyễn Ngọc Hà','NỮ','1996-02-12','036197000864',NULL,NULL,NULL,NULL,NULL,NULL,'0981231963',90000000,85,NULL,'http://localhost:1234/api/media/1597595496152_TDAA2008.jpg',1),(125,'GV_86','Nguyễn Đình Đức','NAM','1997-02-23','036197000865',NULL,NULL,NULL,NULL,NULL,NULL,'0981231964',90000000,86,NULL,'http://localhost:1234/api/media/1597595568282_z2014339728298_c8df101c592d4d12075429969ff22be6.jpg',1),(126,NULL,'Lê Văn Hoàng','NAM','2006-08-20',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231923',NULL,87,NULL,'http://localhost:1234/api/media/1597596228351_z2014339538136_86806b74ad3ddd42d2566544f092756e.jpg',0),(127,NULL,'Hoàng Tuấn Kèn','NAM','2006-01-22',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231967',NULL,88,NULL,'http://localhost:1234/api/media/1597596366432_z2014339524649_61f57012a36c5142c3309791f3d98bcf.jpg',0),(128,NULL,'Thái Kiều Trinh','NỮ','2007-08-02',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231965',NULL,89,NULL,'http://localhost:1234/api/media/1597596412673_z2014339551550_c29e8fd8c04c581e09e79b417bea5d27.jpg',0),(129,NULL,'Phạm Hương','NỮ','2007-05-02',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231967',NULL,90,NULL,'http://localhost:1234/api/media/1597596451332_z2014339566569_c7394efa2348123cc6107cb0a951fc2b.jpg',0),(130,NULL,'Lê Văn Nhật','NAM','2006-04-03',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231924',NULL,91,NULL,'http://localhost:1234/api/media/1597596582746_IMG_6781.jpg',0),(131,NULL,'Jlies Nguyễn','NỮ','2007-06-12',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231963',NULL,92,NULL,'http://localhost:1234/api/media/1597596692094_z2014339566320_da4cf904f02a4fcef3ebc9c7555f4b63.jpg',0),(132,NULL,'Lê Diệu Hà','NỮ','2008-04-08',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231969',NULL,93,NULL,'http://localhost:1234/api/media/1597596850507_z2014339512773_e2ed050f28671d092d214bd51e7223a6.jpg',0),(133,NULL,'Lê Tuấn Anh','NỮ','2007-05-23',NULL,NULL,'Hà Nội',NULL,NULL,NULL,NULL,'0981231965',NULL,94,NULL,'http://localhost:1234/api/media/1597596906727_z2014339551550_c29e8fd8c04c581e09e79b417bea5d27.jpg',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_diem_map`
--

LOCK TABLES `users_diem_map` WRITE;
/*!40000 ALTER TABLE `users_diem_map` DISABLE KEYS */;
INSERT INTO `users_diem_map` VALUES (7,3,7),(9,4,9),(10,5,10),(11,4,11),(12,4,12),(13,9,15),(14,3,16),(22,9,25),(23,9,26),(24,3,27),(25,3,28),(26,3,29),(27,3,30),(44,39,47),(45,40,48),(46,41,49),(47,42,50),(49,44,52),(50,45,53),(51,46,54),(52,47,55),(53,48,56),(69,64,72),(70,65,73),(71,66,74),(72,67,75),(73,68,76),(74,69,77),(93,71,96),(94,72,97),(95,73,98),(96,74,99),(97,75,100),(98,76,101),(104,70,107),(105,8,98),(106,8,101),(107,8,100),(108,8,107),(109,70,108),(110,70,109),(111,70,110),(112,70,111),(113,70,112),(114,70,113),(151,114,150),(152,115,151),(153,116,152),(154,117,153),(155,118,154),(156,119,155),(157,114,156),(158,115,157),(159,116,158),(160,117,159),(161,118,160),(162,119,161);
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

--
-- Dumping routines for database 'qlttgd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-17  0:52:40
