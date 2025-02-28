-- create_hotel_db.sql
drop table IF EXISTS Room;
drop table IF EXISTS User;
drop table IF EXISTS Booking;




-- Create the Room table
create TABLE Room (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    hotelName TEXT,
    city TEXT,
    postalCode TEXT,
    country TEXT,
    numberOfSingleBeds INTEGER,
    numberOfDoubleBeds INTEGER,
    hasWifi BOOLEAN,
    hasRoomService BOOLEAN,
    bigBathroom BOOLEAN,
    costPerNight INTEGER
);

-- Create the User table
create TABLE  User (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    email TEXT,
    password TEXT,
    phoneNumber TEXT,
    numberOfAdults INTEGER,
    numberOfChildren INTEGER
);

-- Create the Booking table
create TABLE  Booking (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    startDate DATE,
    endDate DATE,
    roomId INTEGER,
    userId INTEGER,
    cancelled BOOLEAN,
    FOREIGN KEY (roomId) REFERENCES Room(id),
    FOREIGN KEY (userId) REFERENCES User(id)
);

-- Insert entries into the Room table for hotels in Iceland
insert into Room (hotelName, city, postalCode, country, numberOfSingleBeds, numberOfDoubleBeds, hasWifi, hasRoomService, bigBathroom, costPerNight)
values
('Hotel Plaza', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 0, 25000),
('Radisson Blue, Reykjavik', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 0, 30000),
('Hotel Holt', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 1, 1, 28000),
('Hotel Arnarhvoll', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 1, 20000),
('Edition', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 1, 50000),
('Reykjavik Residence Hotel', 'Reykjavik', '101', 'Iceland', 3, 2, 1, 1, 1, 15000),
('Radisson', 'Reykjavik', '107', 'Iceland', 6, 4, 1, 1, 1, 26000),
('Fosshotel Baron', 'Reykjavik', '101', 'Iceland', 5, 3, 0, 0, 0, 24000),
('Hlemmur Square', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 1, 3000),
('Icelandair Hotel Reykjavik Centrum', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 1, 30000),
('Skuggi Hotel by Keahotels', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 1, 21000),
('CenterHotel Midgardur', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 1, 1, 28000),
('Grand Hotel', 'Reykjavik', '101', 'Iceland', 7, 5, 1, 1, 1, 32000),
('Sand Hotel by Keahotels', 'Reykjavik', '101', 'Iceland', 4, 3, 1, 1, 1, 23000),
('Fosshotel Lind', 'Reykjavik', '101', 'Iceland', 5, 3, 0, 0, 0, 25000),
('Hotel Reykjavik Centrum', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 1, 1, 27000),
('Canopy by Hilton Reykjavik City Centre', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 1, 29000),
('Kvosin Downtown Hotel', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 1, 23000),
('Reykjavik Lights by Keahotels', 'Reykjavik', '104', 'Iceland', 5, 3, 1, 1, 1, 25000),
('Reykjavik Residence Suites', 'Reykjavik', '101', 'Iceland', 3, 2, 1, 1, 1, 21000),
('Skuggi Hotel by Keahotels', 'Reykjavik', '101', 'Iceland', 4, 2, 0, 0, 0, 21000),
('101 Hotel', 'Reykjavik', '101', 'Iceland', 4, 3, 1, 1, 1, 24000),
('Hilton Reykjavik Nordica', 'Reykjavik', '105', 'Iceland', 6, 4, 0, 0, 0, 30000),
('Hotel Klettur', 'Reykjavik', '101', 'Iceland', 3, 2, 1, 1, 0, 19000),
('Canopy by Hilton Reykjavik City Centre', 'Reykjavik', '101', 'Iceland', 5, 3, 0, 1, 1, 27000),
('Radisson, Reykjavik', 'Reykjavik', '101', 'Iceland', 5, 3, 0, 1, 1, 26000),
('Hotel Holt', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 0, 1, 28000),
('CenterHotel Arnarhvoll', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 0, 1, 27000),
('Room With A View', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 0, 1, 22000),
('Reykjavik Residence Hotel', 'Reykjavik', '101', 'Iceland', 3, 2, 0, 1, 1, 20000),
('Radisson', 'Reykjavik', '107', 'Iceland', 6, 4, 0, 1, 1, 30000),
('Fosshotel Baron', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 0, 24000),
('Hlemmur Square', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 0, 0, 23000),
('Icelandair Hotel Reykjavik Centrum', 'Reykjavik', '101', 'Iceland', 5, 3, 0, 0, 1, 25000),
('Skuggi Hotel by Keahotels', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 0, 0, 21000),
('CenterHotel Midgardur', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 0, 0, 28000),
('Grand Hotel', 'Reykjavik', '101', 'Iceland', 7, 5, 1, 1, 1, 32000),
('Sand Hotel by Keahotels', 'Reykjavik', '101', 'Iceland', 4, 3, 1, 1, 1, 23000),
('Fosshotel Lind', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 1, 1, 25000),
('Hotel Reykjavik Centrum', 'Reykjavik', '101', 'Iceland', 6, 4, 1, 0, 0, 27000),
('Canopy by Hilton Reykjavik City Centre', 'Reykjavik', '101', 'Iceland', 5, 3, 1, 0, 0, 29000),
('Kvosin Downtown Hotel', 'Reykjavik', '101', 'Iceland', 4, 2, 1, 1, 1, 23000),
('Reykjavik Lights by Keahotels', 'Reykjavik', '104', 'Iceland', 5, 3, 1, 1, 1, 25000),
('Hotel Laugarhóll', 'Holmavík', '511', 'Iceland', 3, 2, 1, 1, 1, 21000);



-- test users
insert into User (name, email,password, phoneNumber, numberOfAdults, numberOfChildren)
VALUES
('Thor', 'thor@example.com','12345678', '123456789', 2, 1),
('Johannes', 'joi@example.com','12345678', '987654321', 1, 0),
('Páll', 'pall@example.com','12345678', '456789123', 2, 2);

-- test date
insert into Booking (startDate,endDate, roomId, userId, cancelled)
values
('2024-04-13','2024-04-20', 1, 1, 0),
('2024-04-14','2024-04-23', 2, 2, 1),
('2024-04-15','2024-04-18', 3, 3, 0);
