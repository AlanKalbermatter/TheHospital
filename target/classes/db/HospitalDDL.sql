-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb

-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb

-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb
` ;
USE `mydb
` ;

-- -----------------------------------------------------
-- Table `mydb
`.`Events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Events` (
  `id` INT NOT NULL,
  `reason` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Medical_Insurances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Medical_Insurances` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `partner_name` VARCHAR(45) NOT NULL,
  `ssn` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `symtom` VARCHAR(45) NULL,
  `events_id` INT NOT NULL,
  `medical_Insurances_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Patients_Events1_idx` (`events_id` ASC) VISIBLE,
  INDEX `fk_Patients_Medical_Insurances1_idx` (`medical_Insurances_id` ASC) VISIBLE,
  CONSTRAINT `fk_Patients_Events1`
    FOREIGN KEY (`events_id`)
    REFERENCES `mydb
    `.`Events` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patients_Medical_Insurances1`
    FOREIGN KEY (`medical_Insurances_id`)
    REFERENCES `mydb
    `.`Medical_Insurances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Prescriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Prescriptions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `details` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Medicines` (
  `id_medicine` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `prescriptions_id` INT NOT NULL,
  PRIMARY KEY (`id_medicine`),
  INDEX `fk_Medicines_Prescriptions1_idx` (`prescriptions_id` ASC) VISIBLE,
  CONSTRAINT `fk_Medicines_Prescriptions1`
    FOREIGN KEY (`prescriptions_id`)
    REFERENCES `mydb
    `.`Prescriptions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Medical_staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Medical_staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Appointments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Appointments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `patients_id` INT NOT NULL,
  `medical_staff_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Appointments_Patients1_idx` (`patients_id` ASC) VISIBLE,
  INDEX `fk_Appointments_MedicalStaff1_idx` (`medical_staff_id` ASC) VISIBLE,
  CONSTRAINT `fk_Appointments_Patients1`
    FOREIGN KEY (`patients_id`)
    REFERENCES `mydb
    `.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointments_MedicalStaff1`
    FOREIGN KEY (`medical_staff_id`)
    REFERENCES `mydb
    `.`Medical_staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Operations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Operations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `reason` VARCHAR(45) NOT NULL,
  `patients_id` INT NOT NULL,
  `medical_staff_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Operations_Patients1_idx` (`patients_id` ASC) VISIBLE,
  INDEX `fk_Operations_MedicalStaff1_idx` (`medical_staff_id` ASC) VISIBLE,
  CONSTRAINT `fk_Operations_Patients1`
    FOREIGN KEY (`patients_id`)
    REFERENCES `mydb
    `.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Operations_MedicalStaff1`
    FOREIGN KEY (`medical_staff_id`)
    REFERENCES `mydb
    `.`Medical_staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Beds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Beds` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `room_number` INT NOT NULL,
  `patients_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Beds_Patients1_idx` (`patients_id` ASC) VISIBLE,
  CONSTRAINT `fk_Beds_Patients1`
    FOREIGN KEY (`patients_id`)
    REFERENCES `mydb
    `.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Appointment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Appointment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `appointments_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Appointment_type_Appointments1_idx` (`appointments_id` ASC) VISIBLE,
  CONSTRAINT `fk_Appointment_type_Appointments1`
    FOREIGN KEY (`appointments_id`)
    REFERENCES `mydb
    `.`Appointments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Medical_Charts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Medical_Charts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `history` VARCHAR(255) NULL,
  `patients_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_HistorySheets_Patients1_idx` (`patients_id` ASC) VISIBLE,
  CONSTRAINT `fk_HistorySheets_Patients1`
    FOREIGN KEY (`patients_id`)
    REFERENCES `mydb
    `.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Intern_student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Intern_student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Prescriptions_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Prescriptions_orders` (
  `prescriptions_id` INT NOT NULL,
  `medical_staff_id` INT NOT NULL,
  INDEX `fk_Prescriptions_orders_Prescriptions1_idx` (`prescriptions_id` ASC) VISIBLE,
  INDEX `fk_Prescriptions_orders_MedicalStaff14_idx` (`medical_staff_id` ASC) VISIBLE,
  CONSTRAINT `fk_Prescriptions_orders_Prescriptions1`
    FOREIGN KEY (`prescriptions_id`)
    REFERENCES `mydb
    `.`Prescriptions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prescriptions_orders_MedicalStaff1`
    FOREIGN KEY (`medical_staff_id`)
    REFERENCES `mydb
    `.`Medical_staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb
`.`Positions_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb
`.`Positions_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `postion_description` VARCHAR(45) NULL,
  `medical_staff_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Positions_types_MedicalStaff1_idx` (`medical_staff_id` ASC) VISIBLE,
  CONSTRAINT `fk_Positions_types_MedicalStaff1`
    FOREIGN KEY (`medical_staff_id`)
    REFERENCES `mydb
    `.`Medical_staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
