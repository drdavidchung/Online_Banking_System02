DROP TABLE IF EXISTS `LOAN`;
  CREATE TABLE `LOAN` ( 
   `ID` varchar(20) NOT NULL,
	`AMOUNT` decimal(10,2) DEFAULT NULL, 
	`STATUS` varchar(20) NOT NULL, 
	`FIRST_NAME` varchar(20) NOT NULL,
	`LAST_NAME` varchar(20) NOT NULL,
	`ADDRESS` varchar(200) NOT NULL,
	`EMAIL` varchar(60) NOT NULL, 
  PRIMARY KEY (`ID`)
  ) ENGINE = InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `LOAN` VALUES ('RaBh863299',200000,'pending','Rajesh','Bhartia','Mymensingh','rbhartiamuk@gmail.com');
INSERT INTO `LOAN` VALUES ('PiSa532991',100000,'pending','Pial Kanti','Samadder','Keranigonj,Dhaka','pialkanti2012@gmail.com');
INSERT INTO `LOAN` VALUES ('PiSa532992',20000,'success','Pial Kanti2','Samadder','Keranigonj,Dhaka2','pialkanti2012@gmail.com');
