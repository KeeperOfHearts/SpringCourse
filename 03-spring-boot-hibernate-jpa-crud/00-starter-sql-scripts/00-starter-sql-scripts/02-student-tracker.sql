CREATE DATABASE  IF NOT EXISTS `quotesOfTheDay`;
USE `quotesOfTheDay`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `quotes`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quote`varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

