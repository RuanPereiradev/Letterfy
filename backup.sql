-- MySQL dump 10.13  Distrib 9.1.0, for Linux (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_albuns`
--

DROP TABLE IF EXISTS `tb_albuns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_albuns` (
  `album_id` binary(16) NOT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `spotify_id` varchar(255) NOT NULL,
  PRIMARY KEY (`album_id`),
  UNIQUE KEY `UK_cfcny6k4sfixhxdw68mhu2sc` (`spotify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_albuns`
--

LOCK TABLES `tb_albuns` WRITE;
/*!40000 ALTER TABLE `tb_albuns` DISABLE KEYS */;
INSERT INTO `tb_albuns` VALUES (_binary '¿í\Û—ìCéï[_Ñç%ú','MC Caverinha','2025-02-28 14:46:41.958723','My Boo','0IvpAd8VMNzoPfKp0SUL5F'),(_binary '/\"\ﬂTÜBÇët\Î?≠u\Ÿ','Bruninho & Davi','2025-02-28 14:46:41.931539','Peguei, Pegava e Pegaria','7aUiXiYY2C9IVblYLYJZ8T'),(_binary '12345\0\0\0\0\0\0\0\0\0\0\0','http://example.com/cover.jpg','2025-02-05 14:40:36.755633','My Album','spotify_example_id'),(_binary '8Ñ%åFÉFçÆ\Œ)\”\Ï','Vintage Culture','2025-02-28 14:46:42.024923','Weak','7M457yfuVeLaiYrtiKTvqn'),(_binary ':¿PQ\" B«†08\Ë\€*:','Pabllo Vittar','2025-02-28 14:46:41.850538','Pede Pra Eu Ficar (Listen To Your Heart)','6ruTaJyyvcDhUJCMChPfuW'),(_binary '=BQ\n”§Mß∫ñF3v°\Ã','foto','2025-02-17 01:40:29.684852','78979','Cassia Eller'),(_binary 'Adelle\0\0\0\0\0\0\0\0\0\0','adelle','2025-02-06 01:07:52.567194','000000','Single'),(_binary 'Jˇ!–∞\ÓO}ä\≈AY3¯','Tiji Jojo','2025-03-07 20:44:47.999326','FNF','65zERkLZ5jhy7Emo8oEMWz'),(_binary 'K\√R®\—\ŒEiß∂\À_ir™Å','Eve','2025-02-28 14:46:41.826647','Insomnia','51QJlvJclfVB6jNNXlDatS'),(_binary 'Michal Jackson\0\0','Michael','2025-02-05 14:42:12.557015','Triller','15408460'),(_binary 'Trill4\0\0\0\0\0\0\0\0\0\0','Michael','2025-01-28 17:16:47.542769',NULL,'triller'),(_binary '[ö\∆K˘Fƒì\ÛW>ˇ“†','oruam','2025-02-08 21:33:57.980010','000000','Oruam top demais'),(_binary '`¿\—}õMbß\ÓQo.∫','Jonas Blue','2025-02-28 14:46:42.040609','Rest Of My Life','7zeA4kJCW5R6Qef90r2zQM'),(_binary 'aleatorio\0\0\0\0\0\0\0','eu','2025-02-02 23:57:52.084077',NULL,'nome album'),(_binary 'b\œhtDR≥g¶µ\Ì<\"±','DJ ESCOBAR','2025-02-28 14:46:41.999869','Chuva de Mec','6fOBk2fXnKaOQLSc3BIJcp'),(_binary 'g\À\Œ\ÔA#K_•_\Â/òT\…\'','Ariel Donato','2025-02-28 14:46:41.917068','Labirinto','1VqFCDs5i27SB11y6aPs8Y'),(_binary 'novo\0\0\0\0\0\0\0\0\0\0\0\0','praia','2025-02-05 14:41:34.482225','novo album','1234567890'),(_binary 'Õ£k∑úG¨≤n>\Ï\"C','MC Cabelinho','2025-02-28 14:46:41.859657','Dia de Opera√ß√£o','2of77xllwOV4R21J3v4t20'),(_binary 'á\0ØS^ÆJBæ\≈#A∏L°','ATARASHII GAKKO!','2025-02-28 14:46:41.834138','HELLO (from The Tiger\'s Apprentice)','4eCOedqcXqpKnu3wsRRVdf'),(_binary 'ç∞\ 3FµÅ∑#êf\„•','LUDMILLA','2025-02-28 14:46:41.842516','Maliciosa (Ao Vivo)','6ijC1S3LFTvQlrQWkQko3E'),(_binary 'ôö@78pF¥@\ÌHÉ°','Leon Bridges','2025-02-28 14:46:41.802076','Leon','6mHNMtHrXIdUWWuZD9njsG'),(_binary 'ù≥©*_\ËOûé≥ºåR0äá','Casa Comigo','2025-02-28 14:46:41.884519','Amorzin de Sacanage','0R5cf0gW93CE17TYRU9rJZ'),(_binary '¢;)WF‘±U`Ä∑Ω´','Mc Davi','2025-02-28 14:46:41.944194','Enquadro','5P0q5p1O6G4aC6RvtqZL9U'),(_binary 'ßë\‰AN*Ü≤\\ÿΩ.V\‘','Tasha & Tracie','2025-02-28 14:46:41.900582','Drop da Santa','6ObK2QGCtSFaDxDYnKyKyZ'),(_binary '±ãbvtBñÆ∂cLC[Hë','YENTOWN','2025-03-19 15:35:21.500600','„Éê„Ç∞„Çä (feat. kZm, Awich, PETZ, MonyHorse & JNKMN)','2fPFTelUOr9Nw72DW55aHU'),(_binary '∂\0Ü(»äAy∂ÅëTCïp\’','Gloria Groove','2025-02-28 14:46:42.053994','BRUXARIA 3000','4dSYs3xICrNR4Mob4nn3Sa'),(_binary '∑1±ú\ÀJÅ£\◊\ı=è\ÛøØ','Elana Dara','2025-02-28 14:46:41.984874','Luz Acesa','1MVOG9MC3OaC4Mli2NPsQX'),(_binary '—°4\“*ïN∫ò¢%m\0A´','Feyj√£o','2025-02-28 14:46:41.871403','Meu Tom','1scxBLyeF8CmbdErwhZgHj'),(_binary '\‚\Á?ä\‡\ÎFw¶™¶´*\…h+','MC Kevinho','2025-02-28 14:46:42.010794','Tropical','4y2B0NZZ9FRdtHSKu4qAwH'),(_binary '\ˆ\r\‡&DPG)è=˘<û*:','Kayin','2025-02-28 14:46:41.971521','Foragido','3UoWqSV4Ut6qIz4Hq6xBG3');
/*!40000 ALTER TABLE `tb_albuns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reviews`
--

DROP TABLE IF EXISTS `tb_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reviews` (
  `review_id` binary(16) NOT NULL,
  `comment` tinytext,
  `created_at` datetime(6) DEFAULT NULL,
  `rating` decimal(3,2) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `account_id` binary(16) DEFAULT NULL,
  `album_id` binary(16) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` binary(16) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  UNIQUE KEY `UK_snmiwafffdifty758dl6tah3b` (`login`),
  KEY `FKg8t0s6e5fy7akh26plgujp2ur` (`account_id`),
  KEY `FKim11ygyvpbt2uvssctxce6k8w` (`album_id`),
  KEY `FKem8og5jayog5v1939csqdp9ky` (`user_id`),
  CONSTRAINT `FKim11ygyvpbt2uvssctxce6k8w` FOREIGN KEY (`album_id`) REFERENCES `tb_albuns` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reviews`
--

LOCK TABLES `tb_reviews` WRITE;
/*!40000 ALTER TABLE `tb_reviews` DISABLE KEYS */;
INSERT INTO `tb_reviews` VALUES (_binary '\∆\Û\«9\ƒK®•dN°\\\Ï\Ò\Ë','I hate these album, He is the trash ','2025-03-04 19:06:15.838190',2.00,'2025-03-04 19:06:15.838258',NULL,_binary '¿í\Û—ìCéï[_Ñç%ú',NULL,_binary '\Îhz¿ßpOè\ˆ\Ì\ŒèíÇ',NULL),(_binary '\À¯lt!ñEÄÿÉWg\˜◊ü','I don¬¥t like sertanejo, but these album is good','2025-03-08 21:09:54.129127',3.30,'2025-03-08 21:09:54.129181',NULL,_binary '/\"\ﬂTÜBÇët\Î?≠u\Ÿ',NULL,_binary 'P7\'/;¨@#å\ˆK3=\Ú\’%',NULL),(_binary '\“evC\’uAR¢;\·\ÔˇD\ÿ','The best album ever','2025-03-04 20:18:48.009512',5.00,'2025-03-04 20:18:48.009611',NULL,_binary '¢;)WF‘±U`Ä∑Ω´',NULL,_binary 'πT \œS;EZæ+˘Zñ€ó\Z',NULL);
/*!40000 ALTER TABLE `tb_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `user_id` varbinary(255) NOT NULL,
  `bio` longtext,
  `created_at` datetime(6) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (_binary 'IH\Ÿua[D≠ä,^∂2|\Ÿ\”',NULL,'2025-02-26 12:59:45.185107','qualuer@gmail.com','$2a$10$iPK5cBaZo4zp7Tr4KgdowuKR8KQkTVmG/pQ71QObst0beBoLbihB2',NULL,0,'2025-02-26 12:59:45.185223',NULL),(_binary 'P7\'/;¨@#å\ˆK3=\Ú\’%',NULL,'2025-03-08 20:36:09.712611','xerequinha@gmail.com','$2a$10$quZJxbIFsJ7Qatk6KTUUP.Pai8ydEAvflIVtprfXduDhi6amKmEpq',NULL,1,'2025-03-08 20:36:09.712662',NULL),(_binary 'Y\‘\ŒtRMnÄóÉÑc∆íJ',NULL,'2025-02-24 01:50:59.261583',NULL,'$2a$10$FR3AoyWaIaUsAelHuCV4keM1op9UWidWP4WpQkTBIPbz5G4aHlYAi',NULL,0,'2025-02-24 01:50:59.261630',NULL),(_binary 'oÜàQâL&Çè˙T8óë\Î',NULL,'2025-02-24 02:07:48.186659','pau@gmail.com','$2a$10$387h1IKmuulFd68ggMa3i..eVZUaCAJRu.iurh/FuUSlxDJGzSkUq',NULL,0,'2025-02-24 02:07:48.186709',NULL),(_binary 'üd\‘&ccOπªÉ\‹2Aî…ù',NULL,'2025-02-24 01:54:38.507974','pereira@gmail.com','$2a$10$35/iCWl6ICmQ5VFmlNEfAuxQJbjy8GT1nHMpGT1qbXodDNvRvFqpm',NULL,0,'2025-02-24 01:54:38.508030',NULL),(_binary '∞\¬\'≠îNJlà\“…ªç\’z',NULL,'2025-02-24 21:23:30.396353','ernestoche@gmail.com','$2a$10$rOwEgjHeITtFyDgd4RburemjkPHiM.JJ5VjHWPd6Dw.J672X74aey',NULL,0,'2025-02-24 21:23:30.396416',NULL),(_binary '¥˚\‘	í\ÚAS≥ïQÂ¢É\"]',NULL,'2025-02-24 02:08:40.325887','teste@gmail.com','$2a$10$7VOBqUOKMuthyw7QDpwqGOZTcCvZPy0NMulHgxT8N0.lDpTs3AzLm',NULL,0,'2025-02-24 02:08:40.325907',NULL),(_binary 'πT \œS;EZæ+˘Zñ€ó\Z',NULL,'2025-03-04 20:16:30.100764','novousuario@gmail.com','$2a$10$pobvjLd385n2b.utEN417Orper5TT7G7aPiJEvBeiphHBbr6e9kqm',NULL,1,'2025-03-04 20:16:30.100804',NULL),(_binary '\Ÿ\Î\«|D8¥DD ßØá\È',NULL,'2025-03-19 18:45:45.738014','ruanteste@gmail.com','$2a$10$5J8JCjwqKSoYrrMRxkr9R.4X5yhtTNXRQ55hI.qGqHNLjaBAIYf.m',NULL,1,'2025-03-19 18:45:45.738110',NULL),(_binary '\Îhz¿ßpOè\ˆ\Ì\ŒèíÇ',NULL,'2025-02-28 22:50:31.120135','ruanpereira@gmail.com','$2a$10$7JrzV7rwRUTaCUkKGzvjauYCB55txM5AhlO1gRaa73A6j/qspRm0C',NULL,0,'2025-02-28 22:50:31.120314',NULL),(_binary '¯Yä\0çôJóóç\\´\Ô\·7Ü',NULL,'2025-02-24 01:55:29.672861','gabriel@gmail.com','$2a$10$5dGIX4fR2l3E7/rR987sBORWBUIzlvkuwA/sdLmgqVsjnYBQCkU.u',NULL,0,'2025-02-24 01:55:29.672881',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_review`
--

DROP TABLE IF EXISTS `tb_user_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_review` (
  `review_id` varbinary(255) NOT NULL,
  `quantity` int DEFAULT NULL,
  `user_id` varbinary(255) NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKey5qp52xevqt9b04gmk5q46r0` (`user_id`),
  CONSTRAINT `FK4gxcem5eprko7wbeb4a3pl0l0` FOREIGN KEY (`review_id`) REFERENCES `tb_reviews` (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_review`
--

LOCK TABLES `tb_user_review` WRITE;
/*!40000 ALTER TABLE `tb_user_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_users` (
  `user_id` binary(16) NOT NULL,
  `bio` tinytext COLLATE utf8mb4_unicode_ci,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `profile_picture` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `login` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (_binary 'AKª\Ó\ËK\\µ<Œ•1ex',NULL,'2025-02-03 19:16:20.681296','laisa@email.com','7895',NULL,'2025-02-03 19:16:20.681361','Lasa Muniz',NULL,NULL),(_binary '=‘ó\ÙoáF\˜ô\Í4O`7ˇÇ',NULL,'2025-02-21 19:08:37.326670','$2a$10$tfOi1R0eF7aZDGn8SLFAW.fBPXWDJ.vFqCvrVWnSUGbFkJMyKlCeW',NULL,NULL,'2025-02-21 19:08:37.326718','ruan',0,NULL),(_binary 'B$e†ÇLt®5J7ú\Œ\Á6',NULL,'2025-02-21 19:09:30.022781','$2a$10$GUxVz.1f0wKkmWN7TI6ax.fp89IxOgVozd6NG72MMu5rbzkFlCC/u',NULL,NULL,'2025-02-21 19:09:30.022796','nego@gmail.com',0,NULL),(_binary '|q6∞\Ô\‹B¢•`õW{',NULL,'2025-02-21 20:41:30.527550','$2a$10$VE/xN/svV08ahZg3y7ROeeFYs4JnFc.jKHjxcF63mhshVSyoNpEka',NULL,NULL,'2025-02-21 20:41:30.527616','mell@gmail.com',0,NULL),(_binary '\€6rC\·\ÏD¿Å*5pÆØ',NULL,'2025-02-06 01:05:27.409477','teste@email.com','789456123',NULL,'2025-02-06 01:05:27.409560','Ruan Muniz da Silva',NULL,NULL),(_binary '\Êí@\n\ﬂM<Ä≤wòÃ®\”{',NULL,'2025-02-03 00:16:03.102287','ruanpnascimento@email.com','0000',NULL,'2025-02-03 00:16:03.102363','Ruan Pereira do Nascimento',NULL,NULL);
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` binary(16) NOT NULL,
  `bio` tinytext,
  `created_at` datetime(6) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `role` tinyint DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-20 20:31:44
