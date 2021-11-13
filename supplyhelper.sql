-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema supply_helper
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `supply_helper` ;

-- -----------------------------------------------------
-- Schema supply_helper
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supply_helper` DEFAULT CHARACTER SET utf8 ;
USE `supply_helper` ;

-- -----------------------------------------------------
-- Table `supply_helper`.`baseofsupply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supply_helper`.`baseofsupply` ;

CREATE TABLE IF NOT EXISTS `supply_helper`.`baseofsupply` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name_of_object` VARCHAR(100) NULL DEFAULT NULL,
  `customer` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supply_helper`.`producer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supply_helper`.`producer` ;

CREATE TABLE IF NOT EXISTS `supply_helper`.`producer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `contact` VARCHAR(50) NULL DEFAULT NULL,
  `phone` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supply_helper`.`supply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supply_helper`.`supply` ;

CREATE TABLE IF NOT EXISTS `supply_helper`.`supply` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(250) NOT NULL,
  `quantity` DOUBLE NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `sum` DOUBLE NOT NULL,
  `statussup` VARCHAR(30) NOT NULL,
  `date_of_supply` DATE NOT NULL,
  `commentary` TEXT NULL DEFAULT NULL,
  `producer_id` INT(11) NOT NULL,
  `baseOfSupply_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `supply_ibfk_1`
    FOREIGN KEY (`producer_id`)
    REFERENCES `supply_helper`.`producer` (`id`),
  CONSTRAINT `supply_ibfk_2`
    FOREIGN KEY (`baseOfSupply_id`)
    REFERENCES `supply_helper`.`baseofsupply` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;

insert into baseofsupply values (1, 'HIDW', 'Sergey Kotkov');
insert into baseofsupply values (2, 'DIGP', 'Ivan Gryaznov');
insert into baseofsupply values (3, 'GPN-SNAB', 'Michail Stalk');
insert into baseofsupply values (4, 'GPN-KS', 'Ivan Kotov');
insert into baseofsupply values (5, 'UDIP', 'Rouboute Guilliman');
insert into baseofsupply values (6, 'Festival complex', 'Stepan Homyakov');
insert into baseofsupply values (7, 'KRU-1', 'Michail Farber');
insert into baseofsupply values (8, 'KRU-2', 'Kirill Devyatov');
insert into baseofsupply values (9, 'PGU-90', 'Elena Sorma');
insert into baseofsupply values (10, 'TEC-4', 'Sergey Grin');
insert into baseofsupply values (11, 'TEC-3', 'Leman Russ');

insert into producer values (1, 'Ralsi, OOO', 'Ramil', '8-888-888-0000');
insert into producer values (2, 'RIA, OOO', 'Roman', '8-777-888-0000');
insert into producer values (3, 'Kortex, OOO', 'Ivan', '8-666-888-0000');
insert into producer values (4, 'Komus, OOO', 'Elena', '8-555-888-0000');
insert into producer values (5, 'Stepanov RT, IP', 'Nikolai Sven', '8-888-777-0000');
insert into producer values (6, 'AAA, OOO', 'Private Shutnik', '8-888-666-0000');
insert into producer values (7, 'Neftehim, OOO', 'Semen', '8-888-888-1111');

insert into supply values (1, 'Bolt set 10x30', 5, 2.5, 12.5, 'Order approval', '2021-11-10', 'Import', 3, 1);
insert into supply values (2, 'Bolt set 8x20', 10, 100, 1000, 'Order approval', '2021-11-10', 'Import', 3, 6);
insert into supply values (3, 'Bolt set 6x20', 2, 5, 10, 'Make a contract', '2021-11-10', 'Import', 2, 2);
insert into supply values (4, 'Chiller Nordmann 1254362 2Kv', 3, 4, 12, 'Order approval', '2021-11-10', 'Import', 4, 2);
insert into supply values (5, 'Chiller Nordmann 1254-00 5Kv', 5, 6, 30, 'Delivery is done', '2021-08-15', 'Import', 5, 3);
insert into supply values (6, 'Support Brasket BSO 580-0.8', 10, 12, 120, 'Delivery is done', '2021-04-10', 'Import', 3, 2);
insert into supply values (7, 'Support Brasket BSO 420-0.8', 10, 13, 1300, 'Order approval', '2021-03-03', 'Import', 3, 7);
insert into supply values (8, 'Cable Tray 500x80x6000-0.8', 20, 5, 100, 'Make a contract', '2021-06-03', 'Import', 3, 2);
insert into supply values (9, 'Cable Tray 420x80x6000-0.8', 20, 5, 100, 'Make a contract', '2021-09-10', 'Import', 6, 2);
insert into supply values (10, 'Cable Tray 320x50x6000-0.8', 25, 4, 100, 'Make a contract', '2021-08-10', 'Import', 7, 10);
insert into supply values (11, 'Valve Rust-95 3/4', 30, 1, 30, 'Order approval', '2021-11-03', 'Import', 3, 2);
insert into supply values (12, 'Valve Rust-95 1/2', 40, 2, 80, 'Order approval', '2021-11-08', 'Import', 5, 8);
insert into supply values (13, 'Valve Rust-95 3/8', 150, 3, 450, 'On the way', '2021-11-08', 'Import', 3, 2);
insert into supply values (14, 'Valve Rust-95 1 1/2', 500, 1, 500, 'On the way', '2021-05-10', 'Import', 3, 11);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
