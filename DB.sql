DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`(
	`id` INT NOT NULL AUTO_INCREMENT, 
    `first_name` VARCHAR(45) NOT NULL, 
    `last_name` VARCHAR(45) NOT NULL, 
    `email` VARCHAR(45) NOT NULL, 
    PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
	`id` INT NOT NULL AUTO_INCREMENT, 
    `first_name` VARCHAR(45) NOT NULL, 
    `last_name` VARCHAR(45) NOT NULL, 
	`email` VARCHAR(45) NOT NULL, 
    PRIMARY KEY(`id`)
);

INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("riham", "katout", "test1@gmail.com");
INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("riham", "muneer", "test2@gmail.com");
INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("muneer", "katout", "test3@gmail.com");

DROP TABLE IF EXISTS `members`;
CREATE TABLE `members`(
	user_id varchar(50) NOT NULL, 
    pw varchar(68) NOT NULL, 
    active TINYINT(1) NOT NULL, 
    PRIMARY KEY(`user_id`)
) ENGINE=InnoDB DEFAULT charset=latin1;

INSERT INTO `members` VALUES	('riham', '{bcrypt}$2a$12$/CoFamjSCSqpfSPx74ev0.nqd5Bl0jFHdEIzDPjtYe1e.C1UT949a', 1), 
							('ahmad', '{bcrypt}$2a$12$DR5lNOiyW4q/0O1DWjnwBu28GVgLQRa9k1l.LyRRnZRk81LfEhjZq', 1), 
                            ('siwar', '{bcrypt}$2a$12$J3LtEGtQMG1sgJhXHN8ROOAgdIdNV/Jics6TEfmAw31h5Skuh5j1e', 1);

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`(
	`user_id` varchar(50) NOT NULL, 
    `role` varchar(50) NOT NULL, 
    unique KEY `role_PK` (`user_id`, `role`), 
    CONSTRAINT `role_FK` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles` VALUES ('riham', 'ROLE_ADMIN'), ('ahmad', 'ROLE_EMPLOYEE'), ('siwar', 'ROLE_MANAGER');


DROP TABLE IF EXISTS `instructor_details`;
CREATE TABLE `instructor_details`(
	`id` INT NOT NULL auto_increment, 
    `youtube_channel` varchar(128) DEFAULT NULL, 
    `hobby` varchar(45) DEFAULT NULL, 	
    PRIMARY KEY(`id`)
) ENGINE=InnoDB auto_increment=1, DEFAULT charset=latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`(
	`id` int(11) NOT NULL auto_increment,
    `first_name` VARCHAR(45) DEFAULT NULL, 
    `last_name` VARCHAR(45) DEFAULT NULL, 
    `email` VARCHAR(45) DEFAULT NULL,
    `instructor_detail_id` int(11) DEFAULT NULL, 
    primary key(`id`), 
    KEY `FX_detail_idx` (`instructor_detail_id`), constraint `FK_detail` foreign key (`instructor_detail_id`)
    REFERENCES `instructor_details` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB auto_increment=1, DEFAULT charset=latin1;


