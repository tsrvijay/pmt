CREATE DATABASE PMT;

-- -----------------------------------------------------
-- Schema PMT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS PMT DEFAULT CHARACTER SET utf8 ;
USE PMT;

-- -----------------------------------------------------
-- Table PMT.Users
-- -----------------------------------------------------
DROP TABLE IF EXISTS PMT.User ;

CREATE TABLE IF NOT EXISTS PMT.User (
 UserId INT NOT NULL AUTO_INCREMENT,
 FirstName VARCHAR(50) NOT NULL,
 LastName VARCHAR(50) NOT NULL,
 EmployeeId VARCHAR(20) NOT NULL,
 PRIMARY KEY (UserId));

-- -----------------------------------------------------
-- Table PMT.Project
-- -----------------------------------------------------
DROP TABLE IF EXISTS PMT.Project;

CREATE TABLE IF NOT EXISTS PMT.Project (
 ProjectId INT NOT NULL AUTO_INCREMENT,
 ProjectName VARCHAR(50) NOT NULL,
 StartDate DATETIME NOT NULL,,
 EndDate DATETIME NOT NULL,
 Priority INT NOT NULL,
 PRIMARY KEY (ProjectId));

-- -----------------------------------------------------
-- Table PMT.Task
-- -----------------------------------------------------
DROP TABLE IF EXISTS PMT.Task;

CREATE TABLE IF NOT EXISTS PMT.Task (
 TaskId INT NOT NULL AUTO_INCREMENT,
 ProjectName VARCHAR(100) NOT NULL,
 ParentId INT NOT NULL,
 ProjectId INT NOT NULL,
 StartDate DATETIME NOT NULL,,
 EndDate DATETIME NOT NULL,
 Priority INT NOT NULL,
 Status VARCHAR(10) NOT NULL,
 UserId INT NOT NULL,
 PRIMARY KEY (UserId));
 
 -- -----------------------------------------------------
-- Table PMT.ParentTask
-- -----------------------------------------------------
DROP TABLE IF EXISTS PMT.ParentTask;

CREATE TABLE IF NOT EXISTS PMT.ParentTask (
 ParentId INT NOT NULL AUTO_INCREMENT,
 ParentTask VARCHAR(100) NOT NULL,
 PRIMARY KEY (ParentId));