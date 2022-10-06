
DROP DATABASE IF EXISTS WorkshopDBCC6;
CREATE DATABASE IF NOT EXISTS WorkshopDBCC6;

USE WorkshopDBCC6;

CREATE TABLE WorkshopUserRole(
    userRoleId TINYINT AUTO_INCREMENT,
    userRoleDescription VARCHAR(255) NOT NULL,
    PRIMARY KEY (userRoleId)
);

INSERT INTO WorkshopUserRole(userRoleDescription) VALUES ('admin');
INSERT INTO WorkshopUserRole(userRoleDescription) VALUES ('advisor');
INSERT INTO WorkshopUserRole(userRoleDescription) VALUES ('client');

CREATE TABLE WorkshopUser(
    userId INTEGER AUTO_INCREMENT,
    userRoleId TINYINT NOT NULL,
    userPass VARCHAR(255) NOT NULL,
    userEmail VARCHAR(255) NOT NULL,
    PRIMARY KEY (userId),
    FOREIGN KEY (userRoleId) REFERENCES WorkshopUserRole(userRoleId)
);

INSERT INTO WorkshopUser(userRoleId, userPass, userEmail) VALUES(1, 'cheleyotto98@gmail.com', '$2a$12$XTFUEWPTXdxKXnW5/ktys.0qcNAys5BYlsfoyS7g55cpwC5g6YXLC');


CREATE TABLE WorkshopClient(
  clientId INTEGER AUTO_INCREMENT,
  userId INTEGER NOT NULL,
  clientName VARCHAR(255) NOT NULL,
  clientLastName VARCHAR(255) NOT NULL,
  clientDpi VARCHAR(20) NOT NULL,
  clientPhoneNumber VARCHAR(20) NOT NULL,
  PRIMARY KEY(clientId),
  FOREIGN KEY (userId) REFERENCES WorkshopUser(userId),
  UNIQUE(userId)
);

CREATE TABLE WorkshopLocation(
    locationId INTEGER AUTO_INCREMENT,
    locationName VARCHAR(255) NOT NULL,
    locationLatitude DECIMAL(10, 8) NOT NULL,
    locationLongitude DECIMAL(10, 8) NOT NULL,
    locationAddress VARCHAR(255) NOT NULL,
    PRIMARY KEY (locationId)
);

CREATE TABLE WorkshopAdvisor(
    advisorId INTEGER AUTO_INCREMENT,
    advisorLocation INTEGER NOT NULL,
    userId INTEGER NOT NULL,
    advisorName VARCHAR(255) NOT NULL,
    advisorLastName VARCHAR(255) NOT NULL,
    advisorDpi VARCHAR(20) NOT NULL,
    advisorPhoneNumber VARCHAR(20) NOT NULL,
    advisorAddress VARCHAR(20) NOT NULL,
    advisorHiringDate DATE NOT NULL,
    PRIMARY KEY (advisorId),
    FOREIGN KEY (userId) REFERENCES WorkshopUser(userId),
    FOREIGN KEY (advisorLocation) REFERENCES WorkshopLocation(locationId),
    UNIQUE (userId)
);

CREATE TABLE WorkshopVehicleBrand(
    brandId INTEGER AUTO_INCREMENT,
    brandName VARCHAR(255) NOT NULL,
    PRIMARY KEY(brandId)
);

CREATE TABLE WorkshopVehicleLine(
    lineId INTEGER AUTO_INCREMENT,
    brandId INTEGER NOT NULL,
    lineName VARCHAR(255) NOT NULL,
    PRIMARY KEY (lineId),
    FOREIGN KEY (brandId) REFERENCES WorkshopVehicleBrand(brandId)
);

CREATE TABLE WorkshopVehicleModel(
    modelId INTEGER AUTO_INCREMENT,
    modelLine INTEGER NOT NULL,
    modelYear VARCHAR(4) NOT NULL,
    PRIMARY KEY(modelId),
    FOREIGN KEY (modelLine) REFERENCES WorkshopVehicleLine(lineId)
);

CREATE TABLE WorkshopClientVehicle(
    vehicleId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    vehicleModelId INTEGER NOT NULL,
    vehiclePlate VARCHAR(20) NOT NULL,
    PRIMARY KEY (vehicleId),
    FOREIGN KEY (clientId) REFERENCES WorkshopClient(clientId),
    FOREIGN KEY (vehicleModelId) REFERENCES WorkshopVehicleModel(modelId)
);

CREATE TABLE WorkshopPieceType(
    pieceTypeId INTEGER AUTO_INCREMENT,
    pieceName VARCHAR(255) NOT NULL,
    PRIMARY KEY (pieceTypeId)
);

CREATE TABLE WorkshopVehiclePiece(
    pieceId INTEGER AUTO_INCREMENT,
    pieceModel INTEGER NOT NULL,
    pieceType INTEGER NOT NULL,
    PRIMARY KEY (pieceId),
    FOREIGN KEY (pieceModel) REFERENCES WorkshopVehicleModel(modelId),
    FOREIGN KEY (pieceType) REFERENCES WorkshopPieceType(pieceTypeId)
);

CREATE TABLE WorkshopPieceStatus(
    pieceStatusId INTEGER AUTO_INCREMENT,
    pieceStatusDescription VARCHAR(255) NOT NULL,
    PRIMARY KEY (pieceStatusId)
);

CREATE TABLE WorkshopOrderStatus(
    workOrderStatusId INTEGER AUTO_INCREMENT,
    wokrOrderStatusDescription VARCHAR(255) NOT NULL,
    PRIMARY KEY (workOrderStatusId)
);

CREATE TABLE WorkshopWorkOrder(
    workOrderId INTEGER AUTO_INCREMENT,
    workOrderStatus INTEGER NOT NULL,
    clientVehicle INTEGER NOT NULL,
    advisorId INTEGER NOT NULL,
    creationDate DATETIME NOT NULL,
    completionDate DATETIME NULL,
    PRIMARY KEY (workOrderId),
    FOREIGN KEY (workOrderStatus) REFERENCES WorkshopOrderStatus(workOrderStatusId),
    FOREIGN KEY (clientVehicle) REFERENCES WorkshopClientVehicle(vehicleId),
    FOREIGN KEY (advisorId) REFERENCES WorkshopAdvisor(advisorId)
);

CREATE TABLE WorkshopPurchaseOrder(
	workPurchaseOrderId INTEGER AUTO_INCREMENT,
    workOrderId INTEGER NOT NULL,
    pieceVehicleId INTEGER NOT NULL,
    distributorPieceId VARCHAR(255) NOT NULL,
    priceU DECIMAL(10, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY(workPurchaseOrderId),
    FOREIGN KEY (workOrderId) REFERENCES WorkshopWorkOrder(workOrderId),
    FOREIGN KEY(pieceVehicleId) REFERENCES WorkshopVehiclePiece(pieceId)
);

CREATE TABLE WorkshopAdvisorRatedService(
	advisorRateId INTEGER AUTO_INCREMENT,
    advisorId INTEGER NOT NULL,
    workOrderId INTEGER NOT NULL,
    clientId INTEGER NOT NULL,
    clientScore SMALLINT NOT NULL,
    clientComment VARCHAR(255) NOT NULL,
    PRIMARY KEY (advisorRateId),
    FOREIGN KEY (advisorId) REFERENCES WorkshopAdvisor(advisorId),
    FOREIGN KEY (clientId) REFERENCES WorkshopClient(clientId),
    FOREIGN KEY (workOrderId) REFERENCES WorkshopWorkOrder(workOrderId)
);


CREATE TABLE WorkshopWorkOrderDetail(
    workOrderDetailId INTEGER AUTO_INCREMENT,
    workOrderId INTEGER NOT NULL,
    pieceTypeVehicle INTEGER NOT NULL,
    pieceStatus INTEGER NOT NULL,
    PRIMARY KEY (workOrderDetailId),
    FOREIGN KEY (workOrderId) REFERENCES WorkshopWorkOrder(workOrderId),
    FOREIGN KEY (pieceTypeVehicle) REFERENCES WorkshopPieceType(pieceTypeId),
    FOREIGN KEY (pieceStatus) REFERENCES WorkshopPieceStatus(pieceStatusId)
);

CREATE TABLE WorkshopWorkOrderGallery(
    workOrderImageId INTEGER AUTO_INCREMENT NOT NULL,
    workOrderId INTEGER NOT NULL,
    imagePath LONGTEXT NOT NULL,
    PRIMARY KEY (workOrderImageId),
    FOREIGN KEY (workOrderId) REFERENCES WorkshopWorkOrder(workOrderId)
);

CREATE TABLE WorkshopPayment(
    paymentId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    orderId INTEGER NOT NULL,
    cardNum VARCHAR(20) NOT NULL,
    paymentDate DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (paymentId),
    FOREIGN KEY (clientId) REFERENCES WorkshopClient(clientId),
    FOREIGN KEY (orderId) REFERENCES WorkshopWorkOrder(workOrderId)
);

CREATE TABLE WorkshopBill(
    workshopBillId INTEGER AUTO_INCREMENT,
    paymentId INTEGER NOT NULL,
    billName VARCHAR(255) NOT NULL,
    billNit VARCHAR(255) NOT NULL,
    PRIMARY KEY (workshopBillId),
    FOREIGN KEY (paymentId) REFERENCES WorkshopPayment(paymentId)
);

CREATE TABLE WorkshopBillRow(
    billRowId INTEGER AUTO_INCREMENT,
    billId INTEGER NOT NULL,
    pieceIdCode INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    unitPrice DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (billRowId),
    FOREIGN KEY (billId) REFERENCES WorkshopBill(workshopBillId),
    FOREIGN KEY (pieceIdCode) REFERENCES WorkshopVehiclePiece(pieceId)
);

CREATE TABLE WorkshopAppointment(
    appointmentId INTEGER AUTO_INCREMENT,
    clientId INTEGER NOT NULL,
    advisorId INTEGER NOT NULL,
    appointmentDate DATE NOT NULL,
    appointTime DATETIME NOT NULL,
    locationId INTEGER NOT NULL,
    PRIMARY KEY (appointmentId),
    FOREIGN KEY (clientId) REFERENCES WorkshopClient(clientId),
    FOREIGN KEY (advisorId) REFERENCES WorkshopAdvisor(advisorId),
    FOREIGN KEY (locationId) REFERENCES WorkshopLocation(locationId)
);