-- -----------------------------------------------------
-- Schema candidatemanagement
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `candidatemanagement` ;

-- -----------------------------------------------------
-- Schema candidatemanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `candidatemanagement` DEFAULT CHARACTER SET utf8 ;
USE `candidatemanagement` ;

-- -----------------------------------------------------
-- Table `candidatemanagement`.`Organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `candidatemanagement`.`Organization` (
  `name` VARCHAR(10) NULL,
  `org_id` INT NOT NULL,
  PRIMARY KEY (`org_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatemanagement`.`SubOrganization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `candidatemanagement`.`SubOrganization` (
  `sub_org_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `part_of` INT NULL,
  PRIMARY KEY (`sub_org_id`),
  INDEX `org_id_idx` (`part_of` ASC) VISIBLE,
  CONSTRAINT `org_id`
    FOREIGN KEY (`part_of`)
    REFERENCES `candidatemanagement`.`Organization` (`org_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatemanagement`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `candidatemanagement`.`Role` (
  `role_id` INT NOT NULL,
  `name` VARCHAR(10) NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatemanagement`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `candidatemanagement`.`Department` (
  `dep_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`dep_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `candidatemanagement`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `candidatemanagement`.`Employee` (
  `emp_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `role_id` INT NULL,
  `belongs_to` INT NULL,
  `part_of` INT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL CHECK(age>18),
  PRIMARY KEY (`emp_id`),
  INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
  INDEX `dep_id_idx` (`belongs_to` ASC) VISIBLE,
  INDEX `part_of_idx` (`part_of` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `candidatemanagement`.`Role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dep_id`
    FOREIGN KEY (`belongs_to`)
    REFERENCES `candidatemanagement`.`Department` (`dep_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `part_of`
    FOREIGN KEY (`part_of`)
    REFERENCES `candidatemanagement`.`SubOrganization` (`sub_org_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;