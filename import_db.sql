CREATE TABLE
    `instructor` (
        `id` INT(11) NOT NULL AUTO_INCREMENT,
        `first_name` CHAR(30) NOT NULL,
        `last_name` CHAR(30) NOT NULL,
        `hobby` SMALLINT(6) NOT NULL,
		PRIMARY KEY(`id`)
    )

CREATE TABLE
    `instructor` (
        `id` INT(11) NOT NULL AUTO_INCREMENT,
        `first_name` varchar(45) DEFAULT NULL,
        `last_name` varchar(45) DEFAULT NULL,
        `email` varchar(45) DEFAULT NULL,
        `instructor_detail_id` int(11) DEFAULT NULL,
		PRIMARY KEY(`id`),
        CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
        REFERENCES `instructor_detail` (`id`)
    );