/*
SQLyog Community v9.20 Beta2
MySQL - 5.7.23-log : Database - onlineexamsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineexamsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `onlineexamsystem`;

/*Table structure for table `tbl_category` */

DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_category` */

insert  into `tbl_category`(`category_id`,`category_name`) values (3,'Technical'),(4,'Soft Skills'),(5,'Aptitude');

/*Table structure for table `tbl_competency_analysis` */

DROP TABLE IF EXISTS `tbl_competency_analysis`;

CREATE TABLE `tbl_competency_analysis` (
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `topic_name` varchar(100) NOT NULL,
  `percent_obt` double NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `paper_id` (`test_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_1` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tbl_log` (`user_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `tbl_log` (`user_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_5` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_6` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_competency_analysis_ibfk_7` FOREIGN KEY (`test_id`) REFERENCES `tbl_log` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_competency_analysis` */

/*Table structure for table `tbl_log` */

DROP TABLE IF EXISTS `tbl_log`;

CREATE TABLE `tbl_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `percent_obt` double NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`),
  KEY `paper_id` (`test_id`),
  CONSTRAINT `tbl_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_log_ibfk_2` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_log` */

/*Table structure for table `tbl_options` */

DROP TABLE IF EXISTS `tbl_options`;

CREATE TABLE `tbl_options` (
  `question_id` int(11) NOT NULL,
  `option_a` varchar(100) DEFAULT NULL,
  `option_b` varchar(100) DEFAULT NULL,
  `option_c` varchar(100) DEFAULT NULL,
  `option_d` varchar(100) DEFAULT NULL,
  KEY `question_id` (`question_id`),
  CONSTRAINT `tbl_options_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `tbl_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_options` */

/*Table structure for table `tbl_parent_question` */

DROP TABLE IF EXISTS `tbl_parent_question`;

CREATE TABLE `tbl_parent_question` (
  `parent_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_question_desc` varchar(200) DEFAULT NULL,
  `test_id` int(11) NOT NULL,
  `difficulty` varchar(10) NOT NULL,
  `subjectivity` varchar(10) NOT NULL,
  `topic_name` varchar(100) NOT NULL,
  PRIMARY KEY (`parent_question_id`),
  KEY `paper_id` (`test_id`),
  CONSTRAINT `tbl_parent_question_ibfk_1` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_parent_question` */

insert  into `tbl_parent_question`(`parent_question_id`,`parent_question_desc`,`test_id`,`difficulty`,`subjectivity`,`topic_name`) values (14,'aknsdkj',1,'asd','asd','sda');

/*Table structure for table `tbl_question` */

DROP TABLE IF EXISTS `tbl_question`;

CREATE TABLE `tbl_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_question_id` int(11) NOT NULL,
  `question_type` varchar(25) NOT NULL,
  `question_name` varchar(200) NOT NULL,
  `answer` varchar(100) DEFAULT NULL,
  `marks` int(2) NOT NULL,
  `subtopic_name` varchar(100) NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `parent_question_id` (`parent_question_id`),
  CONSTRAINT `tbl_question_ibfk_1` FOREIGN KEY (`parent_question_id`) REFERENCES `tbl_parent_question` (`parent_question_id`),
  CONSTRAINT `tbl_question_ibfk_2` FOREIGN KEY (`parent_question_id`) REFERENCES `tbl_parent_question` (`parent_question_id`),
  CONSTRAINT `tbl_question_ibfk_3` FOREIGN KEY (`parent_question_id`) REFERENCES `tbl_parent_question` (`parent_question_id`),
  CONSTRAINT `tbl_question_ibfk_4` FOREIGN KEY (`parent_question_id`) REFERENCES `tbl_parent_question` (`parent_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_question` */

/*Table structure for table `tbl_question_test` */

DROP TABLE IF EXISTS `tbl_question_test`;

CREATE TABLE `tbl_question_test` (
  `test_id` int(10) NOT NULL,
  `question_id` int(10) NOT NULL,
  KEY `paper_id` (`test_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `tbl_question_test_ibfk_1` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`),
  CONSTRAINT `tbl_question_test_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `tbl_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_question_test` */

/*Table structure for table `tbl_response` */

DROP TABLE IF EXISTS `tbl_response`;

CREATE TABLE `tbl_response` (
  `response_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  `question_id` int(11) NOT NULL,
  `response` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`response_id`),
  KEY `user_id` (`user_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `tbl_response_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_response_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `tbl_question_test` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_response` */

/*Table structure for table `tbl_result` */

DROP TABLE IF EXISTS `tbl_result`;

CREATE TABLE `tbl_result` (
  `user_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `result` varchar(10) NOT NULL,
  `marks` int(2) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `tbl_result_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_log` (`user_id`),
  CONSTRAINT `tbl_result_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_log` (`user_id`),
  CONSTRAINT `tbl_result_ibfk_3` FOREIGN KEY (`question_id`) REFERENCES `tbl_question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_result` */

/*Table structure for table `tbl_subcategory` */

DROP TABLE IF EXISTS `tbl_subcategory`;

CREATE TABLE `tbl_subcategory` (
  `subcategory_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(100) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`subcategory_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `tbl_subcategory_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_subcategory` */

insert  into `tbl_subcategory`(`subcategory_id`,`subcategory_name`,`category_id`) values (5,'Java',3),(6,'dotNet',4);

/*Table structure for table `tbl_subskill_analysis` */

DROP TABLE IF EXISTS `tbl_subskill_analysis`;

CREATE TABLE `tbl_subskill_analysis` (
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `subtopic_name` varchar(100) NOT NULL,
  `percent_obt` double NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `paper_id` (`test_id`),
  CONSTRAINT `tbl_subskill_analysis_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_subskill_analysis_ibfk_2` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`),
  CONSTRAINT `tbl_subskill_analysis_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_subskill_analysis_ibfk_4` FOREIGN KEY (`test_id`) REFERENCES `tbl_log` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_subskill_analysis` */

/*Table structure for table `tbl_test` */

DROP TABLE IF EXISTS `tbl_test`;

CREATE TABLE `tbl_test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(100) NOT NULL,
  `subcategory_id` int(11) NOT NULL,
  `total_marks` int(11) NOT NULL,
  `cutoff` int(11) NOT NULL,
  PRIMARY KEY (`test_id`),
  KEY `subcategory_id` (`subcategory_id`),
  CONSTRAINT `tbl_test_ibfk_1` FOREIGN KEY (`subcategory_id`) REFERENCES `tbl_subcategory` (`subcategory_id`),
  CONSTRAINT `tbl_test_ibfk_2` FOREIGN KEY (`subcategory_id`) REFERENCES `tbl_subcategory` (`subcategory_id`),
  CONSTRAINT `tbl_test_ibfk_3` FOREIGN KEY (`subcategory_id`) REFERENCES `tbl_subcategory` (`subcategory_id`),
  CONSTRAINT `tbl_test_ibfk_4` FOREIGN KEY (`subcategory_id`) REFERENCES `tbl_subcategory` (`subcategory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_test` */

insert  into `tbl_test`(`test_id`,`test_name`,`subcategory_id`,`total_marks`,`cutoff`) values (1,'Java',5,50,34);

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `contact` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`username`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

/*Table structure for table `tbl_user_test` */

DROP TABLE IF EXISTS `tbl_user_test`;

CREATE TABLE `tbl_user_test` (
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  KEY `paper_id` (`test_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tbl_user_test_ibfk_1` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`),
  CONSTRAINT `tbl_user_test_ibfk_2` FOREIGN KEY (`test_id`) REFERENCES `tbl_test` (`test_id`),
  CONSTRAINT `tbl_user_test_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
  CONSTRAINT `tbl_user_test_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user_test` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
