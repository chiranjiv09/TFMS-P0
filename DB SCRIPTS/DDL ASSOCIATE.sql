CREATE DATABASE TFMS;
USE TFMS;
CREATE TABLE Associate
(
	#ID INT AUTO_INCREMENT,
	traineeName varchar(30) not null,
    traineeId int(4) AUTO_INCREMENT primary key,
    track varchar(20),
    qualification varchar(20),
    experience varchar(40),
    trainerId char(4) not null,
    FOREIGN KEY (trainerId) REFERENCES Trainer(trainerId)
); 