USE SC_CRUD;

CREATE TABLE IF NOT EXISTS `SC_CRUD`.`USER` (
  `ID` VARCHAR(36) NOT NULL DEFAULT 'UUID()',
  `FIRST_NAME` VARCHAR(50) NOT NULL,
  `MIDDLE_NAME` VARCHAR(50) NULL,
  `LAST_NAME` VARCHAR(50) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `MOBILE` VARCHAR(15) NOT NULL,
  `GENDER` VARCHAR(5) NOT NULL,
  `CUSTOMER_NUMBER` VARCHAR(20) NOT NULL,
  `COUNTRY_BIRTH` VARCHAR(50) NOT NULL,
  `COUNTRY_RESIDENCE` VARCHAR(50) NOT NULL,
  `CUSTOMER_SEGMENT` VARCHAR(10) NOT NULL,
  `CREATED_TIMESTAMP` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `UPDATED_TIMESTAMP` TIMESTAMP(6) NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `UNIQUE_CUSTOMER_NUMBER` (`CUSTOMER_NUMBER` ASC) VISIBLE);
