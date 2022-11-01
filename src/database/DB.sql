
DROP DATABASE IF EXISTS workshopdbcc6;
CREATE DATABASE IF NOT EXISTS workshopdbcc6;

USE workshopdbcc6;

CREATE TABLE workshopuserrole(
    userRoleId TINYINT AUTO_INCREMENT,
    userRoleDescription VARCHAR(255) NOT NULL,
	deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (userRoleId)
);

INSERT INTO workshopuserrole(userRoleDescription) VALUES ('admin');
INSERT INTO workshopuserrole(userRoleDescription) VALUES ('advisor');
INSERT INTO workshopuserrole(userRoleDescription) VALUES ('client');

CREATE TABLE workshopuser(
    userId INTEGER AUTO_INCREMENT,
    userRoleId TINYINT NOT NULL,
    userPass VARCHAR(255) NOT NULL,
    userEmail VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (userId),
    FOREIGN KEY (userRoleId) REFERENCES workshopuserrole(userRoleId)
);

INSERT INTO workshopuser(userRoleId, userEmail, userPass) VALUES(1, 'test@gmail.com', '$2a$12$XTFUEWPTXdxKXnW5/ktys.0qcNAys5BYlsfoyS7g55cpwC5g6YXLC');

CREATE TABLE workshopclient(
  clientId INTEGER AUTO_INCREMENT,
  userId INTEGER NOT NULL,
  clientName VARCHAR(255) NOT NULL,
  clientLastName VARCHAR(255) NOT NULL,
  clientDpi VARCHAR(20) NOT NULL,
  clientPhoneNumber VARCHAR(20) NOT NULL,
  deleted TINYINT DEFAULT 0 NOT NULL,
  PRIMARY KEY(clientId),
  FOREIGN KEY (userId) REFERENCES workshopuser(userId),
  UNIQUE(userId)
);

CREATE TABLE workshoplocation(
    locationId INTEGER AUTO_INCREMENT,
    locationName VARCHAR(255) NOT NULL,
    locationLatitude DECIMAL(10, 8) NOT NULL,
    locationLongitude DECIMAL(10, 8) NOT NULL,
    locationAddress VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (locationId)
);

ALTER TABLE workshoplocation DROP COLUMN locationLatitude;
ALTER TABLE workshoplocation DROP COLUMN locationLongitude;
ALTER TABLE workshoplocation ADD COLUMN locationLatitude DECIMAL(20, 8) NOT NULL;
ALTER TABLE workshoplocation ADD COLUMN locationLongitude DECIMAL(20, 8) NOT NULL;

CREATE TABLE workshopadvisor(
    advisorId INTEGER AUTO_INCREMENT,
    advisorLocation INTEGER NOT NULL,
    userId INTEGER NOT NULL,
    advisorName VARCHAR(255) NOT NULL,
    advisorLastName VARCHAR(255) NOT NULL,
    advisorDpi VARCHAR(20) NOT NULL,
    advisorPhoneNumber VARCHAR(20) NOT NULL,
    advisorAddress TEXT NOT NULL,
    advisorHiringDate DATE NOT NULL,
	deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (advisorId),
    FOREIGN KEY (userId) REFERENCES workshopuser(userId),
    FOREIGN KEY (advisorLocation) REFERENCES workshoplocation(locationId),
    UNIQUE (userId)
);

# ALTER TABLE workshopadvisor DROP COLUMN advisorAddress;
# ALTER TABLE workshopadvisor ADD COLUMN advisorAddress TEXT NOT NULL;

CREATE TABLE workshopvehiclebrand(
    brandId INTEGER AUTO_INCREMENT,
    brandName VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY(brandId)
);

CREATE TABLE workshopvehicleline(
    lineId INTEGER AUTO_INCREMENT,
    brandId INTEGER NOT NULL,
    lineName VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (lineId),
    FOREIGN KEY (brandId) REFERENCES workshopvehiclebrand(brandId)
);

CREATE TABLE workshopvehiclemodel(
    modelId INTEGER AUTO_INCREMENT,
    modelLine INTEGER NOT NULL,
    modelYear VARCHAR(4) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY(modelId),
    FOREIGN KEY (modelLine) REFERENCES workshopvehicleline(lineId)
);

CREATE TABLE workshopclientvehicle(
    vehicleId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    vehicleModelId INTEGER NOT NULL,
    vehiclePlate VARCHAR(20) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (vehicleId),
    FOREIGN KEY (clientId) REFERENCES workshopclient(clientId),
    FOREIGN KEY (vehicleModelId) REFERENCES workshopvehiclemodel(modelId)
);

CREATE TABLE workshoppiecetype(
    pieceTypeId INTEGER AUTO_INCREMENT,
    pieceName VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (pieceTypeId)
);

CREATE TABLE workshopvehiclepiece(
    pieceId INTEGER AUTO_INCREMENT,
    pieceModel INTEGER NOT NULL,
    pieceType INTEGER NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (pieceId),
    FOREIGN KEY (pieceModel) REFERENCES workshopvehiclemodel(modelId),
    FOREIGN KEY (pieceType) REFERENCES workshoppiecetype(pieceTypeId)
);

CREATE TABLE workshoppiecestatus(
    pieceStatusId INTEGER AUTO_INCREMENT,
    pieceStatusDescription VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (pieceStatusId)
);

CREATE TABLE workshoporderstatus(
    workOrderStatusId INTEGER AUTO_INCREMENT,
    wokrOrderStatusDescription VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (workOrderStatusId)
);

CREATE TABLE workshopworkorder(
    workOrderId INTEGER AUTO_INCREMENT,
    workOrderStatus INTEGER NOT NULL,
    clientVehicle INTEGER NOT NULL,
    advisorId INTEGER NOT NULL,
    creationDate DATETIME NOT NULL,
    completionDate DATETIME NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (workOrderId),
    FOREIGN KEY (workOrderStatus) REFERENCES workshoporderstatus(workOrderStatusId),
    FOREIGN KEY (clientVehicle) REFERENCES workshopclientvehicle(vehicleId),
    FOREIGN KEY (advisorId) REFERENCES workshopadvisor(advisorId)
);

CREATE TABLE workshoppurchaseorder(
	workPurchaseOrderId INTEGER AUTO_INCREMENT,
    workOrderId INTEGER NOT NULL,
    pieceVehicleId INTEGER NOT NULL,
    distributorPieceId VARCHAR(255) NOT NULL,
    priceU DECIMAL(10, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY(workPurchaseOrderId),
    FOREIGN KEY (workOrderId) REFERENCES workshopworkorder(workOrderId),
    FOREIGN KEY(pieceVehicleId) REFERENCES workshopvehiclepiece(pieceId)
);

CREATE TABLE workshopadvisorratedservice(
	advisorRateId INTEGER AUTO_INCREMENT,
    advisorId INTEGER NOT NULL,
    workOrderId INTEGER NOT NULL,
    clientId INTEGER NOT NULL,
    clientScore SMALLINT NOT NULL,
    clientComment VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (advisorRateId),
    FOREIGN KEY (advisorId) REFERENCES workshopadvisor(advisorId),
    FOREIGN KEY (clientId) REFERENCES workshopclient(clientId),
    FOREIGN KEY (workOrderId) REFERENCES workshopworkorder(workOrderId)
);


CREATE TABLE workshopworkorderdetail(
    workOrderDetailId INTEGER AUTO_INCREMENT,
    workOrderId INTEGER NOT NULL,
    pieceTypeVehicle INTEGER NOT NULL,
    pieceStatus INTEGER NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (workOrderDetailId),
    FOREIGN KEY (workOrderId) REFERENCES workshopworkorder(workOrderId),
    FOREIGN KEY (pieceTypeVehicle) REFERENCES workshoppiecetype(pieceTypeId),
    FOREIGN KEY (pieceStatus) REFERENCES workshoppiecestatus(pieceStatusId)
);

CREATE TABLE workshopworkordergallery(
    workOrderImageId INTEGER AUTO_INCREMENT NOT NULL,
    workOrderId INTEGER NOT NULL,
    imagePath LONGTEXT NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (workOrderImageId),
    FOREIGN KEY (workOrderId) REFERENCES workshopworkorder(workOrderId)
);

CREATE TABLE workshoppayment(
    paymentId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    orderId INTEGER NOT NULL,
    cardNum VARCHAR(20) NOT NULL,
    paymentDate DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (paymentId),
    FOREIGN KEY (clientId) REFERENCES workshopclient(clientId),
    FOREIGN KEY (orderId) REFERENCES workshopworkorder(workOrderId)
);

CREATE TABLE workshopbill(
    workshopBillId INTEGER AUTO_INCREMENT,
    paymentId INTEGER NOT NULL,
    billName VARCHAR(255) NOT NULL,
    billNit VARCHAR(255) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (workshopBillId),
    FOREIGN KEY (paymentId) REFERENCES workshoppayment(paymentId)
);

CREATE TABLE workshopbillrow(
    billRowId INTEGER AUTO_INCREMENT,
    billId INTEGER NOT NULL,
    pieceIdCode INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    unitPrice DECIMAL(10, 2) NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (billRowId),
    FOREIGN KEY (billId) REFERENCES workshopbill(workshopBillId),
    FOREIGN KEY (pieceIdCode) REFERENCES workshopvehiclepiece(pieceId)
);

CREATE TABLE workshopappointment(
    appointmentId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    advisorId INTEGER NOT NULL,
    appointmentDate DATE NOT NULL,
    appointTime DATETIME NOT NULL,
    locationId INTEGER NOT NULL,
    deleted TINYINT DEFAULT 0 NOT NULL,
    PRIMARY KEY (appointmentId),
    FOREIGN KEY (clientId) REFERENCES workshopclient(clientId),
    FOREIGN KEY (advisorId) REFERENCES workshopadvisor(advisorId),
    FOREIGN KEY (locationId) REFERENCES workshoplocation(locationId)
);