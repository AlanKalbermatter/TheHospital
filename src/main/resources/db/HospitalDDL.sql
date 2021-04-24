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
CREATE SCHEMA IF NOT EXISTS `mydb` ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Events` (
  `id` INT NOT NULL,
  `reason` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nurses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Nurses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medical_Insurances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medical_Insurances` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `partner_name` VARCHAR(45) NOT NULL,
  `ssn` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `symtom` VARCHAR(45) NULL,
  `events_id` INT NOT NULL,
  `nurses_id` INT NOT NULL,
  `Medical_Insurances_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Patients_Events1_idx` (`events_id` ASC) VISIBLE,
  INDEX `fk_Patients_Nurses1_idx` (`nurses_id` ASC) VISIBLE,
  INDEX `fk_Patients_Medical_Insurances1_idx` (`Medical_Insurances_id` ASC) VISIBLE,
  CONSTRAINT `fk_Patients_Events1`
    FOREIGN KEY (`events_id`)
    REFERENCES `mydb`.`Events` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patients_Nurses1`
    FOREIGN KEY (`nurses_id`)
    REFERENCES `mydb`.`Nurses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patients_Medical_Insurances1`
    FOREIGN KEY (`Medical_Insurances_id`)
    REFERENCES `mydb`.`Medical_Insurances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prescriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prescriptions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `details` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medicines` (
  `id_medicine` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Prescriptions_id` INT NOT NULL,
  PRIMARY KEY (`id_medicine`),
  INDEX `fk_Medicines_Prescriptions1_idx` (`Prescriptions_id` ASC) VISIBLE,
  CONSTRAINT `fk_Medicines_Prescriptions1`
    FOREIGN KEY (`Prescriptions_id`)
    REFERENCES `mydb`.`Prescriptions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Doctors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Appointments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Appointments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `Patients_id` INT NOT NULL,
  `Doctors_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Appointments_Patients1_idx` (`Patients_id` ASC) VISIBLE,
  INDEX `fk_Appointments_Doctors1_idx` (`Doctors_id` ASC) VISIBLE,
  CONSTRAINT `fk_Appointments_Patients1`
    FOREIGN KEY (`Patients_id`)
    REFERENCES `mydb`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointments_Doctors1`
    FOREIGN KEY (`Doctors_id`)
    REFERENCES `mydb`.`Doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Surgeons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Surgeons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Operations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Operations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `reason` VARCHAR(45) NOT NULL,
  `Surgeons_id` INT NOT NULL,
  `Patients_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Operations_Surgeons1_idx` (`Surgeons_id` ASC) VISIBLE,
  INDEX `fk_Operations_Patients1_idx` (`Patients_id` ASC) VISIBLE,
  CONSTRAINT `fk_Operations_Surgeons1`
    FOREIGN KEY (`Surgeons_id`)
    REFERENCES `mydb`.`Surgeons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Operations_Patients1`
    FOREIGN KEY (`Patients_id`)
    REFERENCES `mydb`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Beds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Beds` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `room_number` INT NOT NULL,
  `Patients_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Beds_Patients1_idx` (`Patients_id` ASC) VISIBLE,
  CONSTRAINT `fk_Beds_Patients1`
    FOREIGN KEY (`Patients_id`)
    REFERENCES `mydb`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Appointment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Appointment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `Appointments_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Appointment_type_Appointments1_idx` (`Appointments_id` ASC) VISIBLE,
  CONSTRAINT `fk_Appointment_type_Appointments1`
    FOREIGN KEY (`Appointments_id`)
    REFERENCES `mydb`.`Appointments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medical_Charts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medical_Charts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `history` VARCHAR(255) NULL,
  `Patients_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_HistorySheets_Patients1_idx` (`Patients_id` ASC) VISIBLE,
  CONSTRAINT `fk_HistorySheets_Patients1`
    FOREIGN KEY (`Patients_id`)
    REFERENCES `mydb`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Intern_student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Intern_student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Intern_students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Intern_students` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Supervition_Charts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Supervition_Charts` (
  `Intern_student_id` INT NOT NULL,
  `Doctors_id` INT NOT NULL,
  INDEX `fk_supervises_Intern_student1_idx` (`Intern_student_id` ASC) VISIBLE,
  INDEX `fk_supervises_Doctors1_idx` (`Doctors_id` ASC) VISIBLE,
  CONSTRAINT `fk_supervises_Intern_student1`
    FOREIGN KEY (`Intern_student_id`)
    REFERENCES `mydb`.`Intern_students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supervises_Doctors1`
    FOREIGN KEY (`Doctors_id`)
    REFERENCES `mydb`.`Doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prescriptions_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prescriptions_orders` (
  `doctors_id` INT NOT NULL,
  `prescriptions_id` INT NOT NULL,
  INDEX `fk_Prescriptions_orders_Doctors1_idx` (`doctors_id` ASC) VISIBLE,
  INDEX `fk_Prescriptions_orders_Prescriptions1_idx` (`prescriptions_id` ASC) VISIBLE,
  CONSTRAINT `fk_Prescriptions_orders_Doctors1`
    FOREIGN KEY (`doctors_id`)
    REFERENCES `mydb`.`Doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prescriptions_orders_Prescriptions1`
    FOREIGN KEY (`prescriptions_id`)
    REFERENCES `mydb`.`Prescriptions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
