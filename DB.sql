DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`(
	`id` INT NOT NULL AUTO_INCREMENT, 
    `first_name` VARCHAR(45) NOT NULL, 
    `last_name` VARCHAR(45) NOT NULL, 
    `email` VARCHAR(45) NOT NULL, 
    PRIMARY KEY(`id`)
);
