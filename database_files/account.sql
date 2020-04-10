DROP TABLE IF EXISTS `ACCOUNT`;
CREATE TABLE `ACCOUNT` (
    `ID` varchar(32) NOT NULL, 
	`F_NAME` varchar(20) NOT NULL, 
	`L_NAME` varchar(20) NOT NULL, 
	`ADDRESS` varchar(200) NOT NULL,
	`CITY` varchar(20) NOT NULL, 
	`BRANCH` varchar(20) NOT NULL,
	`ZIP` varchar(20) NOT NULL, 
	`USERNAME` varchar(20) NOT NULL, 
	`PASSWORD` varchar(20) NOT NULL, 
	`PHONE` varchar(11) NOT NULL, 
	`EMAIL` varchar(60) NOT NULL, 
	`ACCOUNT_TYPE` varchar(20) NOT NULL, 
	`REG_DATE` varchar(20) NOT NULL,
	`USER_STATUS` decimal(6,0) NOT NULL,
	PRIMARY KEY (`ID`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `ACCOUNT` VALUES ('PiSa532991','Pial Kanti','Samadder','Keranigonj,Dhaka','Dhaka','Dhaka','1304','PialKanti','1234','01676277976','pialkanti2012@gmail.com','Current Account','15/04/2017',1);
INSERT INTO `ACCOUNT` VALUES ('RaBh863299','Rajesh','Bhartia','Mymensingh','Mymensingh','Mymensingh','2210','rkBhartia','1234','01455699554','rbhartiamuk@gmail.com','Saving Account','16/04/2017',1);
INSERT INTO `ACCOUNT` VALUES ('GrBa240230','Green','Bank','KUET','Khulna','Khulna','1540','admin','admin','13234558','admin@greenbank.com','Saving Account','23/04/2017',1);
INSERT INTO `ACCOUNT` VALUES ('Admin240230','Admin','Bank','KUET','Khulna','Khulna','1540','admin','admin','123','admin@greenbank.com','Saving Account','23/04/2017',2);
