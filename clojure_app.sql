/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.21 : Database - clojure_app
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clojure_app` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `clojure_app`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `postal_code` int(6) NOT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`postal_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`postal_code`,`city_name`) values 
(1,'New York'),
(11000,'Beograd'),
(11070,'Novi Beograd'),
(11080,'Zemun'),
(11271,'Surcin'),
(16000,'Leskovac'),
(17500,'Vranje'),
(21000,'Novi Sad'),
(37000,'Krusevac');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `city` int(11) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `stamina` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `city` (`city`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`city`) REFERENCES `city` (`postal_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1111 DEFAULT CHARSET=latin1;

/*Data for the table `member` */

insert  into `member`(`name`,`surname`,`birthday`,`sex`,`member_id`,`city`,`height`,`weight`,`stamina`,`rating`) values 
('Milan','Brkic','1994-07-08','M',1107,11000,185,80,7.8,9),
('Nikoleta','Stevic','1994-05-19','Z',1108,11000,170,60,6.5,8.5),
('Milena','Brkic','1994-07-08','Z',1109,11070,0,0,0,0),
('Stefan','Krstic','1993-08-25','M',1110,11070,NULL,NULL,NULL,NULL);

/*Table structure for table `sport` */

DROP TABLE IF EXISTS `sport`;

CREATE TABLE `sport` (
  `sport_id` int(11) NOT NULL,
  `sport_name` varchar(20) DEFAULT NULL,
  `max_in_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`sport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sport` */

insert  into `sport`(`sport_id`,`sport_name`,`max_in_team`) values 
(1,'Kosarka',20),
(2,'Mali fudbal',25),
(3,'Odbojka',22),
(4,'Rukomet',30),
(5,'Fudbal',40),
(6,'Stoni tenis',4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `member` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `member` (`member`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`member`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`member`) values 
('Milan','test',1107);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
