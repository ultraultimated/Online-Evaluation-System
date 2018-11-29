-- MySqlBackup.NET 2.0.9.2
-- Dump Time: 2018-11-28 01:05:59
-- --------------------------------------
-- Server version 5.7.23-log MySQL Community Server (GPL)

-- 
-- Create schema onlineexamsystem
-- 

CREATE DATABASE IF NOT EXISTS `onlineexamsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
Use `onlineexamsystem`;



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 
-- Definition of hibernate_sequence
-- 

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table hibernate_sequence
-- 

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence`(`next_val`) VALUES
(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- 
-- Definition of tbl_category
-- 

DROP TABLE IF EXISTS `tbl_category`;
CREATE TABLE IF NOT EXISTS `tbl_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_category
-- 

/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category`(`category_id`,`category_name`) VALUES
(1,'Technical Tests'),
(2,'Non-Technical Tests'),
(3,'Aptitude Tests'),
(4,'Testing Category');
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;

-- 
-- Definition of tbl_category_sub_category_list
-- 

DROP TABLE IF EXISTS `tbl_category_sub_category_list`;
CREATE TABLE IF NOT EXISTS `tbl_category_sub_category_list` (
  `category_category_id` int(11) NOT NULL,
  `sub_category_list_subcategory_id` int(11) NOT NULL,
  UNIQUE KEY `UK_4jvp1b3bs7n2odviyk121vhqs` (`sub_category_list_subcategory_id`),
  KEY `FK8dgk249y8v4dkypxhalcbrxit` (`category_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_category_sub_category_list
-- 

/*!40000 ALTER TABLE `tbl_category_sub_category_list` DISABLE KEYS */;
INSERT INTO `tbl_category_sub_category_list`(`category_category_id`,`sub_category_list_subcategory_id`) VALUES
(4,11),
(4,12),
(5,13),
(5,14),
(6,15),
(6,16),
(7,17),
(7,18);
/*!40000 ALTER TABLE `tbl_category_sub_category_list` ENABLE KEYS */;

-- 
-- Definition of tbl_competency_analysis
-- 

DROP TABLE IF EXISTS `tbl_competency_analysis`;
CREATE TABLE IF NOT EXISTS `tbl_competency_analysis` (
  `competency_id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_obt` double DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `topic_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`competency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_competency_analysis
-- 

/*!40000 ALTER TABLE `tbl_competency_analysis` DISABLE KEYS */;

/*!40000 ALTER TABLE `tbl_competency_analysis` ENABLE KEYS */;

-- 
-- Definition of tbl_log
-- 

DROP TABLE IF EXISTS `tbl_log`;
CREATE TABLE IF NOT EXISTS `tbl_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_obt` double DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_log
-- 

/*!40000 ALTER TABLE `tbl_log` DISABLE KEYS */;
INSERT INTO `tbl_log`(`log_id`,`percent_obt`,`test_id`,`timestamp`,`user_id`) VALUES
(1,75,16,'2018-11-27 12:15:23',1),
(2,50,16,NULL,2),
(3,30,16,'2018-11-28 00:14:17',3),
(4,80,13,NULL,3),
(5,60,12,NULL,3),
(6,40,16,'2018-11-28 09:39:11',3),
(7,20,16,'2018-11-28 09:42:27',4),
(8,40,16,'2018-11-28 10:53:29',5),
(9,55,16,'2018-11-28 11:02:57',5),
(10,13,16,'2018-11-28 11:48:38',4),
(11,10,16,'2018-11-28 11:48:55',4);
/*!40000 ALTER TABLE `tbl_log` ENABLE KEYS */;

-- 
-- Definition of tbl_options
-- 

DROP TABLE IF EXISTS `tbl_options`;
CREATE TABLE IF NOT EXISTS `tbl_options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_options
-- 

/*!40000 ALTER TABLE `tbl_options` DISABLE KEYS */;
INSERT INTO `tbl_options`(`option_id`,`option_a`,`option_b`,`option_c`,`option_d`) VALUES
(1,'No Language Process','Natural Language Process','Natural Language Processing','National Language Process'),
(15,'-128 to 127','-32768 to 32767','-2147483648 to 2147483647','None of the mentioned'),
(16,'malloc','alloc','new','new malloc'),
(17,'JVM','JDK','JIT','JRE'),
(18,'JVM','JDK','JIT','JRE'),
(19,'JVM','JDK','JIT','JRE'),
(20,'JVM','JDK','JIT','JRE');
/*!40000 ALTER TABLE `tbl_options` ENABLE KEYS */;

-- 
-- Definition of tbl_parent_question
-- 

DROP TABLE IF EXISTS `tbl_parent_question`;
CREATE TABLE IF NOT EXISTS `tbl_parent_question` (
  `parent_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `difficulty` varchar(255) DEFAULT NULL,
  `parent_question_desc` varchar(255) DEFAULT NULL,
  `subjectivity` varchar(255) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `topic_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parent_question_id`),
  KEY `FK4ysyg553h88weh8tkkchpp91q` (`test_id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_parent_question
-- 

/*!40000 ALTER TABLE `tbl_parent_question` DISABLE KEYS */;
INSERT INTO `tbl_parent_question`(`parent_question_id`,`difficulty`,`parent_question_desc`,`subjectivity`,`test_id`,`topic_name`) VALUES
(1,'2','What you know about java and .net?','0',1,'Spring MVC'),
(2,'2','.Net Controls','1',1,'.NET'),
(3,'2','What do you know about NLP?','0',1,'Machine Learning'),
(4,'1','What do you know about JSP?','1',2,'JSP Basics'),
(16,'0','What you know about java and .net?','1',8,'Spring MVC'),
(17,'1','.Net Controls','1',8,'.NET'),
(18,'2','What do you know about NLP?','1',8,'Machine Learning'),
(19,'0','What you know about java and .net?','1',9,'Spring MVC'),
(20,'1','.Net Controls','1',9,'.NET'),
(21,'2','What do you know about NLP?','1',9,'Machine Learning'),
(22,'0','What you know about java and .net?','1',10,'Spring MVC'),
(23,'1','.Net Controls','1',10,'.NET'),
(24,'2','What do you know about NLP?','1',10,'Machine Learning'),
(25,'0','What you know about java and .net?','1',11,'Spring MVC'),
(26,'1','.Net Controls','1',11,'.NET'),
(27,'2','What do you know about NLP?','1',11,'Machine Learning'),
(28,'0','Basics of Datatypes','1',13,'Java Basics'),
(29,'1','Arrays in Java','1',13,'Java Basics'),
(30,'1','Array Declaration in Java','0',13,'Java Basics'),
(31,'1','Method Overriding ','1',13,'OOPS Concepts'),
(32,'1','Which are OOPS Concepts in Java','0',13,'OOPS Concepts'),
(33,'0','Methods in Java','0',13,'Java Basics'),
(34,'2','Components in Java','1',13,'Java Components'),
(35,'0','Java File ','1',13,'Java Basics'),
(36,'0','Basics of Datatypes','1',14,'Java Basics'),
(37,'1','Arrays in Java','1',14,'Java Basics'),
(38,'1','Array Declaration in Java','0',14,'Java Basics'),
(39,'1','Method Overriding ','1',14,'OOPS Concepts'),
(40,'1','Which are OOPS Concepts in Java','0',14,'OOPS Concepts'),
(41,'0','Methods in Java','0',14,'Java Basics'),
(42,'2','Components in Java','1',14,'Java Components'),
(43,'0','Java File ','1',14,'Java Basics'),
(44,'0','Basics of Datatypes','1',15,'Java Basics'),
(45,'1','Arrays in Java','1',15,'Java Basics'),
(46,'1','Array Declaration in Java','0',15,'Java Basics'),
(47,'1','Method Overriding ','1',15,'OOPS Concepts'),
(48,'1','Which are OOPS Concepts in Java','0',15,'OOPS Concepts'),
(49,'0','Methods in Java','0',15,'Java Basics'),
(50,'2','Components in Java','1',15,'Java Components'),
(51,'0','Java File ','1',15,'Java Basics'),
(52,'0','Basics of Datatypes','1',16,'Java Basics'),
(53,'1','Arrays in Java','1',16,'Java Basics'),
(55,'1','Method Overriding ','1',16,'OOPS Concepts'),
(57,'0','Methods in Java','0',16,'Java Basics'),
(58,'2','Components in Java','1',16,'Java Components'),
(59,'0','Java File ','1',16,'Java Basics');
/*!40000 ALTER TABLE `tbl_parent_question` ENABLE KEYS */;

-- 
-- Definition of tbl_question
-- 

DROP TABLE IF EXISTS `tbl_question`;
CREATE TABLE IF NOT EXISTS `tbl_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `marks` int(11) NOT NULL,
  `parent_question_id` int(11) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `subtopic_name` varchar(255) DEFAULT NULL,
  `question_desc` varchar(255) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `option_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FKf9ugt35tup6owl8xuqpe71tv8` (`parent_question_id`),
  KEY `FKiq8fhur39rjy9u0pre1ycm2i6` (`option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_question
-- 

/*!40000 ALTER TABLE `tbl_question` DISABLE KEYS */;
INSERT INTO `tbl_question`(`question_id`,`answer`,`marks`,`parent_question_id`,`question_type`,`subtopic_name`,`question_desc`,`difficulty`,`option_id`) VALUES
(1,'True',1,1,'2','Java Basics','Is Java a High Level Language?',0,NULL),
(2,'True',1,1,'2','.Net Basics','Is .NET a High Level Language?',0,NULL),
(3,'Natural Language Processing',1,3,'3','NLP Basics','Full Form of NLP',1,NULL),
(4,'Java Server Pages',1,4,'1','JSP Basics','Full Form of JSP',1,NULL),
(6,'true',1,25,'2','Spring MVC','Child question no 2 of .Net Controls',2,NULL),
(7,'C',1,26,'3','Spring MVC','Expression Language is the part of Core Container in Spring Framework.',2,NULL),
(8,'B',1,28,'3','Datatypes','What is the range of short data type in Java?',0,NULL),
(9,'C',1,29,'3','Arrays','Which of these operators is used to allocate memory to array variable in Java?',1,NULL),
(10,NULL,2,30,'0','Array','Write the syntax to declare an array in java',1,NULL),
(11,'true',1,31,'2','OOPS Concepts','Method overriding is combination of inheritance and polymorphism',1,NULL),
(12,NULL,2,32,'0','OOPS Concepts','List down 4 primary OOPS Concepts.',1,NULL),
(13,'null',1,33,'1','Java Basics','What is the return type of a method that does not return any value?',0,NULL),
(14,'main',1,33,'1','Java Basics','Which method can be defined only once in a program?',1,NULL),
(15,'B',1,34,'3','Components','Which component is used to compile, debug and execute java program?',1,NULL),
(16,'A',1,34,'3','Components','Which component is responsible for converting bytecode into machine specific code?',1,NULL),
(17,'D',1,34,'3','Components','Which component is responsible to run java program?',2,NULL),
(18,'C',1,34,'3','Components','Which component is responsible to optimize bytecode to machine code?',2,NULL),
(19,'true',1,35,'2','Java Files','Is ''.java'' the extension of java code files?',0,NULL),
(20,'B',1,36,'3','Datatypes','What is the range of short data type in Java?',0,NULL),
(21,'C',1,37,'3','Arrays','Which of these operators is used to allocate memory to array variable in Java?',1,NULL),
(22,NULL,2,38,'0','Array','Write the syntax to declare an array in java',1,NULL),
(23,'true',1,39,'2','OOPS Concepts','Method overriding is combination of inheritance and polymorphism',1,NULL),
(24,NULL,2,40,'0','OOPS Concepts','List down 4 primary OOPS Concepts.',1,NULL),
(25,'null',1,41,'1','Java Basics','What is the return type of a method that does not return any value?',0,NULL),
(26,'main',1,41,'1','Java Basics','Which method can be defined only once in a program?',1,NULL),
(27,'B',1,42,'3','Components','Which component is used to compile, debug and execute java program?',1,NULL),
(28,'A',1,42,'3','Components','Which component is responsible for converting bytecode into machine specific code?',1,NULL),
(29,'D',1,42,'3','Components','Which component is responsible to run java program?',2,NULL),
(30,'C',1,42,'3','Components','Which component is responsible to optimize bytecode to machine code?',2,NULL),
(31,'true',1,43,'2','Java Files','Is ''.java'' the extension of java code files?',0,NULL),
(32,'B',1,44,'3','Datatypes','What is the range of short data type in Java?',0,NULL),
(33,'C',1,45,'3','Arrays','Which of these operators is used to allocate memory to array variable in Java?',1,NULL),
(34,NULL,2,46,'0','Array','Write the syntax to declare an array in java',1,NULL),
(35,'true',1,47,'2','OOPS Concepts','Method overriding is combination of inheritance and polymorphism',1,NULL),
(36,NULL,2,48,'0','OOPS Concepts','List down 4 primary OOPS Concepts.',1,NULL),
(37,'null',1,49,'1','Java Basics','What is the return type of a method that does not return any value?',0,NULL),
(38,'main',1,49,'1','Java Basics','Which method can be defined only once in a program?',1,NULL),
(39,'B',1,50,'3','Components','Which component is used to compile, debug and execute java program?',1,NULL),
(40,'A',1,50,'3','Components','Which component is responsible for converting bytecode into machine specific code?',1,NULL),
(41,'D',1,50,'3','Components','Which component is responsible to run java program?',2,NULL),
(42,'C',1,50,'3','Components','Which component is responsible to optimize bytecode to machine code?',2,NULL),
(43,'true',1,51,'2','Java Files','Is ''.java'' the extension of java code files?',0,NULL),
(44,'B',1,52,'3','Datatypes','What is the range of short data type in Java?',0,15),
(45,'C',1,53,'3','Arrays','Which of these operators is used to allocate memory to array variable in Java?',1,16),
(47,'true',1,55,'2','OOPS Concepts','Method overriding is combination of inheritance and polymorphism',1,NULL),
(49,'null',1,57,'1','Java Basics','What is the return type of a method that does not return any value?',0,NULL),
(50,'main',1,57,'1','Java Basics','Which method can be defined only once in a program?',1,NULL),
(51,'B',1,58,'3','Components','Which component is used to compile, debug and execute java program?',1,17),
(52,'A',1,58,'3','Components','Which component is responsible for converting bytecode into machine specific code?',1,18),
(53,'D',1,58,'3','Components','Which component is responsible to run java program?',2,19),
(54,'C',1,58,'3','Components','Which component is responsible to optimize bytecode to machine code?',2,20),
(55,'true',1,59,'2','Java Files','Is ''.java'' the extension of java code files?',0,NULL);
/*!40000 ALTER TABLE `tbl_question` ENABLE KEYS */;

-- 
-- Definition of tbl_question_test
-- 

DROP TABLE IF EXISTS `tbl_question_test`;
CREATE TABLE IF NOT EXISTS `tbl_question_test` (
  `question_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `parent_question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_test_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_question_test
-- 

/*!40000 ALTER TABLE `tbl_question_test` DISABLE KEYS */;

/*!40000 ALTER TABLE `tbl_question_test` ENABLE KEYS */;

-- 
-- Definition of tbl_response
-- 

DROP TABLE IF EXISTS `tbl_response`;
CREATE TABLE IF NOT EXISTS `tbl_response` (
  `response_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`response_id`)
) ENGINE=MyISAM AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_response
-- 

/*!40000 ALTER TABLE `tbl_response` DISABLE KEYS */;
INSERT INTO `tbl_response`(`response_id`,`question_id`,`response`,`timestamp`,`user_id`) VALUES
(105,45,'C',NULL,2),
(104,44,'A',NULL,2),
(103,55,'true',NULL,1),
(102,54,'A',NULL,1),
(101,53,'A',NULL,1),
(100,52,'A',NULL,1),
(99,51,'A',NULL,1),
(98,50,'final',NULL,1),
(97,49,'void',NULL,1),
(96,47,'true',NULL,1),
(95,45,'A',NULL,1),
(94,44,'A',NULL,1),
(93,44,'A',NULL,1),
(92,55,'false',NULL,1),
(91,54,'B',NULL,1),
(90,53,'B',NULL,1),
(89,52,'B',NULL,1),
(88,51,'B',NULL,1),
(87,50,'Pandya',NULL,1),
(86,49,'Rahul',NULL,1),
(85,47,'false',NULL,1),
(84,45,'B',NULL,1),
(83,44,'B',NULL,1),
(82,55,'',NULL,1),
(81,54,'',NULL,1),
(80,53,'',NULL,1),
(79,52,'',NULL,1),
(78,51,'',NULL,1),
(77,50,'',NULL,1),
(76,49,'',NULL,1),
(75,47,'',NULL,1),
(74,45,'',NULL,1),
(73,44,'',NULL,1),
(72,55,'false',NULL,1),
(71,54,'B',NULL,1),
(70,53,'A',NULL,1),
(69,52,'B',NULL,1),
(68,51,'A',NULL,1),
(67,50,'Pandya',NULL,1),
(66,49,'Rahul',NULL,1),
(65,47,'true',NULL,1),
(64,45,'A',NULL,1),
(63,44,'B',NULL,1),
(106,47,'true',NULL,2),
(107,49,'void',NULL,2),
(108,50,'final',NULL,2),
(109,51,'B',NULL,2),
(110,52,'B',NULL,2),
(111,53,'C',NULL,2),
(112,54,'C',NULL,2),
(113,55,'true',NULL,2),
(114,44,'A','2018-11-28 00:13:19',3),
(115,45,'C','2018-11-28 00:13:24',3),
(116,47,'true','2018-11-28 00:13:28',3),
(117,49,'void','2018-11-28 00:13:32',3),
(118,50,'final','2018-11-28 00:13:36',3),
(119,51,'A','2018-11-28 00:13:40',3),
(120,52,'B','2018-11-28 00:13:44',3),
(121,53,'C','2018-11-28 00:13:48',3),
(122,54,'A','2018-11-28 00:13:52',3),
(123,55,'true','2018-11-28 00:13:56',3),
(124,44,'A','2018-11-28 09:38:12',3),
(125,45,'C','2018-11-28 09:38:17',3),
(126,47,'true','2018-11-28 09:38:21',3),
(127,49,'void','2018-11-28 09:38:25',3),
(128,50,'final','2018-11-28 09:38:29',3),
(129,51,'B','2018-11-28 09:38:33',3),
(130,52,'B','2018-11-28 09:38:38',3),
(131,53,'A','2018-11-28 09:38:42',3),
(132,54,'A','2018-11-28 09:38:46',3),
(133,55,'true','2018-11-28 09:38:50',3),
(134,44,'D','2018-11-28 09:41:29',4),
(135,45,'D','2018-11-28 09:41:34',4),
(136,47,'false','2018-11-28 09:41:38',4),
(137,49,'void','2018-11-28 09:41:42',4),
(138,50,'final','2018-11-28 09:41:46',4),
(139,51,'D','2018-11-28 09:41:50',4),
(140,52,'D','2018-11-28 09:41:54',4),
(141,53,'C','2018-11-28 09:41:58',4),
(142,54,'D','2018-11-28 09:42:02',4),
(143,55,'false','2018-11-28 09:42:06',4),
(144,44,'A','2018-11-28 10:52:21',5),
(145,45,'B','2018-11-28 10:52:26',5),
(146,47,'true','2018-11-28 10:52:30',5),
(147,49,'null','2018-11-28 10:52:35',5),
(148,50,'main','2018-11-28 10:52:40',5),
(149,51,'A','2018-11-28 10:52:45',5),
(150,52,'B','2018-11-28 10:52:49',5),
(151,53,'C','2018-11-28 10:52:55',5),
(152,54,'D','2018-11-28 10:52:59',5),
(153,55,'true','2018-11-28 10:53:04',5),
(154,44,'B','2018-11-28 11:01:59',5),
(155,45,'C','2018-11-28 11:02:04',5),
(156,47,'true','2018-11-28 11:02:08',5),
(157,49,'null','2018-11-28 11:02:12',5),
(158,50,'main','2018-11-28 11:02:16',5),
(159,51,'D','2018-11-28 11:02:20',5),
(160,52,'B','2018-11-28 11:02:24',5),
(161,53,'A','2018-11-28 11:02:28',5),
(162,54,'C','2018-11-28 11:02:33',5),
(163,55,'true','2018-11-28 11:02:37',5),
(164,44,'','2018-11-28 11:47:42',4),
(165,45,'','2018-11-28 11:47:46',4),
(166,47,'','2018-11-28 11:47:50',4),
(167,49,'','2018-11-28 11:47:54',4),
(168,44,'','2018-11-28 11:47:57',4),
(169,50,'','2018-11-28 11:47:58',4),
(170,45,'','2018-11-28 11:48:02',4),
(171,51,'','2018-11-28 11:48:02',4),
(172,52,'','2018-11-28 11:48:06',4),
(173,47,'','2018-11-28 11:48:06',4),
(174,53,'','2018-11-28 11:48:10',4),
(175,49,'','2018-11-28 11:48:10',4),
(176,54,'','2018-11-28 11:48:14',4),
(177,50,'','2018-11-28 11:48:14',4),
(178,55,'','2018-11-28 11:48:18',4),
(179,51,'','2018-11-28 11:48:18',4),
(180,52,'','2018-11-28 11:48:23',4),
(181,53,'','2018-11-28 11:48:27',4),
(182,54,'','2018-11-28 11:48:31',4),
(183,55,'','2018-11-28 11:48:35',4);
/*!40000 ALTER TABLE `tbl_response` ENABLE KEYS */;

-- 
-- Definition of tbl_result
-- 

DROP TABLE IF EXISTS `tbl_result`;
CREATE TABLE IF NOT EXISTS `tbl_result` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `marks` int(11) NOT NULL,
  `question_id` int(11) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=MyISAM AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_result
-- 

/*!40000 ALTER TABLE `tbl_result` DISABLE KEYS */;
INSERT INTO `tbl_result`(`result_id`,`marks`,`question_id`,`result`,`user_id`) VALUES
(1,0,44,'Incorrect',1),
(2,0,45,'Incorrect',1),
(3,1,47,'Correct',1),
(4,0,49,'Incorrect',1),
(5,0,50,'Incorrect',1),
(6,0,51,'Incorrect',1),
(7,1,52,'Correct',1),
(8,0,53,'Incorrect',1),
(9,0,54,'Incorrect',1),
(10,1,55,'Correct',1),
(11,0,44,'Incorrect',2),
(12,1,45,'Correct',2),
(13,1,47,'Correct',2),
(14,0,49,'Incorrect',2),
(15,0,50,'Incorrect',2),
(16,1,51,'Correct',2),
(17,0,52,'Incorrect',2),
(18,0,53,'Incorrect',2),
(19,1,54,'Correct',2),
(20,1,55,'Correct',2),
(21,0,44,'Incorrect',3),
(22,1,45,'Correct',3),
(23,1,47,'Correct',3),
(24,0,49,'Incorrect',3),
(25,0,50,'Incorrect',3),
(26,0,51,'Incorrect',3),
(27,0,52,'Incorrect',3),
(28,0,53,'Incorrect',3),
(29,0,54,'Incorrect',3),
(30,1,55,'Correct',3),
(31,0,44,'Incorrect',3),
(32,1,45,'Correct',3),
(33,1,47,'Correct',3),
(34,0,49,'Incorrect',3),
(35,0,50,'Incorrect',3),
(36,1,51,'Correct',3),
(37,0,52,'Incorrect',3),
(38,0,53,'Incorrect',3),
(39,0,54,'Incorrect',3),
(40,1,55,'Correct',3),
(41,0,44,'Incorrect',4),
(42,0,45,'Incorrect',4),
(43,0,47,'Incorrect',4),
(44,0,49,'Incorrect',4),
(45,0,50,'Incorrect',4),
(46,0,51,'Incorrect',4),
(47,0,52,'Incorrect',4),
(48,0,53,'Incorrect',4),
(49,0,54,'Incorrect',4),
(50,0,55,'Incorrect',4),
(51,0,44,'Incorrect',5),
(52,0,45,'Incorrect',5),
(53,1,47,'Correct',5),
(54,1,49,'Correct',5),
(55,1,50,'Correct',5),
(56,0,51,'Incorrect',5),
(57,0,52,'Incorrect',5),
(58,0,53,'Incorrect',5),
(59,0,54,'Incorrect',5),
(60,1,55,'Correct',5),
(61,1,44,'Correct',5),
(62,1,45,'Correct',5),
(63,1,47,'Correct',5),
(64,1,49,'Correct',5),
(65,1,50,'Correct',5),
(66,0,51,'Incorrect',5),
(67,0,52,'Incorrect',5),
(68,0,53,'Incorrect',5),
(69,1,54,'Correct',5),
(70,1,55,'Correct',5),
(71,0,44,'Incorrect',4),
(72,0,45,'Incorrect',4),
(73,0,47,'Incorrect',4),
(74,0,49,'Incorrect',4),
(75,0,44,'Incorrect',4),
(76,0,50,'Incorrect',4),
(77,0,51,'Incorrect',4),
(78,0,45,'Incorrect',4),
(79,0,52,'Incorrect',4),
(80,0,47,'Incorrect',4),
(81,0,53,'Incorrect',4),
(82,0,49,'Incorrect',4),
(83,0,54,'Incorrect',4),
(84,0,50,'Incorrect',4),
(85,0,55,'Incorrect',4),
(86,0,51,'Incorrect',4),
(87,0,52,'Incorrect',4),
(88,0,53,'Incorrect',4),
(89,0,54,'Incorrect',4),
(90,0,55,'Incorrect',4);
/*!40000 ALTER TABLE `tbl_result` ENABLE KEYS */;

-- 
-- Definition of tbl_subcategory
-- 

DROP TABLE IF EXISTS `tbl_subcategory`;
CREATE TABLE IF NOT EXISTS `tbl_subcategory` (
  `subcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subcategory_id`),
  KEY `FK9qcacmnhxn8hjmh3k6bo891o4` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_subcategory
-- 

/*!40000 ALTER TABLE `tbl_subcategory` DISABLE KEYS */;
INSERT INTO `tbl_subcategory`(`subcategory_id`,`category_id`,`subcategory_name`) VALUES
(1,1,'Java Programming'),
(2,1,'PHP Test'),
(3,1,'Angular.js'),
(4,1,'Bootstrap'),
(5,1,'Javascript Test'),
(6,1,'dotNET Test'),
(7,2,'Behavioural Test'),
(8,2,'Psychometric Test'),
(9,2,'Fire Safety Test'),
(10,3,'General Aptitude Test'),
(11,4,'Testing Subcategory');
/*!40000 ALTER TABLE `tbl_subcategory` ENABLE KEYS */;

-- 
-- Definition of tbl_subskill_analysis
-- 

DROP TABLE IF EXISTS `tbl_subskill_analysis`;
CREATE TABLE IF NOT EXISTS `tbl_subskill_analysis` (
  `subskill_id` int(11) NOT NULL AUTO_INCREMENT,
  `percent_obt` double DEFAULT NULL,
  `subtopic_name` varchar(255) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`subskill_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_subskill_analysis
-- 

/*!40000 ALTER TABLE `tbl_subskill_analysis` DISABLE KEYS */;

/*!40000 ALTER TABLE `tbl_subskill_analysis` ENABLE KEYS */;

-- 
-- Definition of tbl_test
-- 

DROP TABLE IF EXISTS `tbl_test`;
CREATE TABLE IF NOT EXISTS `tbl_test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `cutoff` int(11) NOT NULL,
  `subcategory_id` int(11) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `total_marks` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_id`),
  KEY `FKb2hnns6aijfc7nt91xmaysxrf` (`subcategory_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_test
-- 

/*!40000 ALTER TABLE `tbl_test` DISABLE KEYS */;
INSERT INTO `tbl_test`(`test_id`,`cutoff`,`subcategory_id`,`test_name`,`total_marks`,`time`) VALUES
(1,23,1,'Core Java Developer',50,30),
(2,18,1,'Advance Java Developer',50,30),
(3,23,4,'Python',50,20),
(12,10,1,'Java',15,30),
(13,10,1,'Java',14,30),
(14,10,1,'Java Java & Java',15,25),
(16,6,11,'Test Name',10,20);
/*!40000 ALTER TABLE `tbl_test` ENABLE KEYS */;

-- 
-- Definition of tbl_test_parent_question_list
-- 

DROP TABLE IF EXISTS `tbl_test_parent_question_list`;
CREATE TABLE IF NOT EXISTS `tbl_test_parent_question_list` (
  `test_test_id` int(11) NOT NULL,
  `parent_question_list_parent_question_id` int(11) NOT NULL,
  KEY `FKfjlfdsv8fmfxcaan7qnolmpp3` (`parent_question_list_parent_question_id`),
  KEY `FKtk2h19kyva4gd7cbk26b9xtvp` (`test_test_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_test_parent_question_list
-- 

/*!40000 ALTER TABLE `tbl_test_parent_question_list` DISABLE KEYS */;

/*!40000 ALTER TABLE `tbl_test_parent_question_list` ENABLE KEYS */;

-- 
-- Definition of tbl_user
-- 

DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE IF NOT EXISTS `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `is_unique` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_user
-- 

/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user`(`user_id`,`dob`,`email`,`gender`,`name`,`password`,`user_type`,`username`,`country`,`is_unique`) VALUES
(1,'1996-10-16','neelp1543@gmail.com','male','Neel Nitinbhai Parikh','abcd','admin','neelp',NULL,0),
(5,'2018-11-01','neelp1543@gmail.com','male','Neel Parikh','11111111','admin','abcd',NULL,0),
(6,'2018-11-01','neelp1543@gmail.com','male','Neel Parikh','11111111','user','Ultraultimated',NULL,0),
(8,'1996-08-18','poojan8788@gmail.com','male','Poojan Patel','MTIzNA==','user','poojanp',NULL,0);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;

-- 
-- Definition of tbl_user_test
-- 

DROP TABLE IF EXISTS `tbl_user_test`;
CREATE TABLE IF NOT EXISTS `tbl_user_test` (
  `user_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_test_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table tbl_user_test
-- 

/*!40000 ALTER TABLE `tbl_user_test` DISABLE KEYS */;
INSERT INTO `tbl_user_test`(`user_test_id`,`test_id`,`user_id`) VALUES
(1,13,1),
(2,13,2),
(3,12,1),
(4,16,1);
/*!40000 ALTER TABLE `tbl_user_test` ENABLE KEYS */;

-- 
-- Definition of test_model
-- 

DROP TABLE IF EXISTS `test_model`;
CREATE TABLE IF NOT EXISTS `test_model` (
  `test_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `difficulty1` varchar(255) DEFAULT NULL,
  `test_question_desc` varchar(255) DEFAULT NULL,
  `subjectivity1` varchar(255) DEFAULT NULL,
  `test_id1` int(11) DEFAULT NULL,
  `topic_name1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`test_question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table test_model
-- 

/*!40000 ALTER TABLE `test_model` DISABLE KEYS */;

/*!40000 ALTER TABLE `test_model` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- Dump completed on 2018-11-28 01:06:00
-- Total time: 0:0:0:1:171 (d:h:m:s:ms)
