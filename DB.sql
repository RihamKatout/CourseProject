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

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	username varchar(50) NOT NULL, 
    password varchar(68) NOT NULL, 
    enabled TINYINT(1) NOT NULL, 
    PRIMARY KEY(`username`)
) ENGINE=InnoDB DEFAULT charset=latin1;

INSERT INTO `users` VALUES	('riham', '{bcrypt}$2a$12$/CoFamjSCSqpfSPx74ev0.nqd5Bl0jFHdEIzDPjtYe1e.C1UT949a', 1), 
							('ahmad', '{bcrypt}$2a$12$DR5lNOiyW4q/0O1DWjnwBu28GVgLQRa9k1l.LyRRnZRk81LfEhjZq', 1), 
                            ('siwar', '{bcrypt}$2a$12$J3LtEGtQMG1sgJhXHN8ROOAgdIdNV/Jics6TEfmAw31h5Skuh5j1e', 1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`(
	`username` varchar(50) NOT NULL, 
    `authority` varchar(50) NOT NULL, 
    unique KEY `auth_PK` (`username`, `authority`), 
    CONSTRAINT `auth_FK` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` VALUES ('riham', 'ROLE_ADMIN'), ('ahmad', 'ROLE_EMPLOYEE'), ('siwar', 'ROLE_MANAGER');