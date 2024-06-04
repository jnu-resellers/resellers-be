use resellers;

CREATE TABLE `MEMBER_TB`
(
    `MEMBER_PK`             BIGINT AUTO_INCREMENT,
    `MEMBER_NAME`           VARCHAR(255) NOT NULL,
    `MEMBER_EMAIL`          VARCHAR(255) NOT NULL,
    `MEMBER_PASSWORD`       VARCHAR(255) NOT NULL,
    `CREATED_DATE`          datetime(6)  NOT NULL,
    `UPDATED_DATE`          datetime(6)  NOT NULL,
    `MEMBER_ACCOUNT_NUMBER` VARCHAR(255) NOT NULL,
    `MEMBER_BANK_NAME`      VARCHAR(255),
    `MEMBER_CONTACT`        VARCHAR(255),
    PRIMARY KEY (`MEMBER_PK`)
) ENGINE = InnoDB;

CREATE TABLE `PRODUCT_TB`
(
    `PRODUCT_PK`          BIGINT AUTO_INCREMENT,
    `CREATED_DATE`        datetime(6)  NOT NULL,
    `UPDATED_DATE`        datetime(6)  NOT NULL,
    `PRODUCT_DESCRIPTION` VARCHAR(255) NOT NULL,
    `PRODUCT_DEFECT`      VARCHAR(255) NOT NULL,
    `PRODUCT_NAME`        VARCHAR(255) NOT NULL,
    `PRODUCT_PRICE`       INT          NOT NULL,
    `PRODUCT_IS_SOLD`     bit(1)       NOT NULL,
    `MEMBER_FK`           BIGINT,
    PRIMARY KEY (`PRODUCT_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;

CREATE TABLE `MATERIAL_TB`
(
    `MATERIAL_PK`        BIGINT AUTO_INCREMENT,
    `CREATED_DATE`       datetime(6) NOT NULL,
    `UPDATED_DATE`       datetime(6) NOT NULL,
    `MATERIAL_ITEM_TYPE` VARCHAR(255),
    `MATERIAL_CONTACT`   VARCHAR(255),
    `MEMBER_FK`          BIGINT,
    `PRODUCT_FK`         BIGINT,
    PRIMARY KEY (`MATERIAL_PK`),
    FOREIGN KEY (`PRODUCT_FK`) REFERENCES `PRODUCT_TB` (`PRODUCT_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;


CREATE TABLE `IMAGE_TB`
(
    `IMAGE_PK`        BIGINT AUTO_INCREMENT,
    `CREATED_DATE`    datetime(6)  NOT NULL,
    `UPDATED_DATE`    datetime(6)  NOT NULL,
    `IMAGE_FILE_NAME` VARCHAR(255) NOT NULL,
    `PRODUCT_FK`      BIGINT,
    PRIMARY KEY (`IMAGE_PK`),
    FOREIGN KEY (`PRODUCT_FK`) REFERENCES `PRODUCT_TB` (`PRODUCT_PK`)
) ENGINE = InnoDB;

CREATE TABLE `TRADE_TB`
(
    `TRADE_PK`        BIGINT AUTO_INCREMENT,
    `CREATED_DATE`    datetime(6)  NOT NULL,
    `UPDATED_DATE`    datetime(6)  NOT NULL,
    `TRADE_CONFIRM`   bit(1)       NOT NULL,
    `TRADE_QUANTITY`  INT          NOT NULL,
    `TRADE_ITEM_TYPE` VARCHAR(255) NOT NULL,
    `MATERIAL_FK`      BIGINT,
    `MEMBER_FK`       BIGINT,
    PRIMARY KEY (`TRADE_PK`),
    FOREIGN KEY (`MATERIAL_FK`) REFERENCES `MATERIAL_TB` (`MATERIAL_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;

CREATE TABLE `AUCTION_TB`
(
    `AUCTION_PK`         BIGINT AUTO_INCREMENT,
    `CREATED_DATE`    datetime(6)  NOT NULL,
    `UPDATED_DATE`    datetime(6)  NOT NULL,
    `AUCTION_DEADLINE`   datetime(6) NOT NULL,
    `AUCTION_START_AT`   datetime(6) NOT NULL,
    `AUCTION_BID_COUNT`  INT         NOT NULL,
    `AUCTION_PRICE_UNIT` INT         NOT NULL,
    `AUCTION_NOW_PRICE`  INT         NOT NULL,
    `AUCTION_IS_SOLD`    bit(1)      NOT NULL,
    `MEMBER_FK`          BIGINT,
    `MATERIAL_FK`        BIGINT,
    PRIMARY KEY (`AUCTION_PK`),
    FOREIGN KEY (`MATERIAL_FK`) REFERENCES `MATERIAL_TB` (`MATERIAL_PK`)
) ENGINE = InnoDB;

CREATE TABLE `AUCTION_MEMBER_TB`
(
    `AUCTION_MEMBER_PK`        BIGINT AUTO_INCREMENT,
    `AUCTION_FK`               BIGINT,
    `MEMBER_FK`                BIGINT,
    `AUCTION_MEMBER_USER_ROLE` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`AUCTION_MEMBER_PK`),
    FOREIGN KEY (`AUCTION_FK`) REFERENCES `AUCTION_TB` (`AUCTION_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;
