DROP DATABASE IF EXISTS TV3;
CREATE DATABASE TV3;
USE TV3;
CREATE TABLE Journalist (
	CPR numeric(10,0) NOT NULL,
    First_Name varChar(255),
    Last_Name varChar(255),
    Street_Name varchar(255),
    Civic_Name varChar(255),
    Zip_Code numeric(6, 0),
    Country varChar(56),
    PRIMARY KEY(CPR));

CREATE TABLE Footage (
	Title varChar(255) NOT NULL,
    Date_of_Rec varChar(255),
    Duration varChar(255),
    CPR numeric(10,0),
    PRIMARY KEY(Title));

CREATE TABLE Edition (
	Date_Time datetime NOT NULL,
    Duration varChar(255),
    CPR numeric(10,0),
    PRIMARY KEY(Date_Time));

    CREATE TABLE Roles (
	Topic_Title varChar(255) NOT NULL,
    CPR numeric(10,0) NOT NULL,
    Current_Roles varChar(255),
    PRIMARY KEY(Topic_Title, CPR));

    CREATE TABLE Topic (
	Topic_Title varChar(255) NOT NULL,
    Brief_Description varChar(255),
    PRIMARY KEY(Topic_Title));

CREATE TABLE Item (
	Time_Item_Given datetime NOT NULL,
	Topic_Title varChar(255),
    Item_Description varChar(255),
    Nr_of_Viewers numeric(65,0),
    Footage_Title varChar(255),
    PRIMARY KEY(Time_Item_Given));


CREATE TABLE Phone (
	CPR numeric(10,0),
    Phone_Number numeric(12, 0) NOT NULL,
    Description_Phone varChar(255),
    PRIMARY KEY (Phone_Number));

CREATE TABLE Email (
	CPR numeric(10,0),
    Email varChar(255) NOT NULL,
    Description_Email varChar(255),
    PRIMARY KEY (Email));




DELIMITER //
CREATE FUNCTION HighestViewersForTopic(topic_title VARCHAR(255))
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE highest_viewers INT;
  SELECT MAX(Nr_of_Viewers) INTO highest_viewers
  FROM Item
  WHERE Topic_Title = topic_title;
  RETURN highest_viewers;
END //

DELIMITER ;

CREATE VIEW JournalListView AS
SELECT * FROM Journalist;

CREATE VIEW PhoneNumberView AS
SELECT First_Name, Last_Name, CPR, Phone_Number, Description_Phone
FROM Phone
NATURAL JOIN Journalist;

CREATE VIEW EmailAddressView AS
SELECT First_Name, Last_Name, CPR, Email, Description_Email
FROM Email
NATURAL JOIN Journalist;

# Gives an overall view of an edition and its primary worker
CREATE VIEW RoleViewModified AS
SELECT First_Name, Current_Roles, Topic_title, Date_time, Duration
FROM Roles NATURAL JOIN Edition NATURAL JOIN Journalist;

CREATE VIEW EditionView AS
SELECT Date_Time,
Duration,
Time_Item_Given,
Nr_of_Viewers
FROM Edition FULL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given)) AND ((unix_timestamp(Date_Time)+Duration)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromTopic AS
SELECT
Nr_of_Viewers
Topic_Title
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
AND ((unix_timestamp(Date_Time)+Duration)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromEdition AS
SELECT
Nr_of_Viewers,
Date_Time,
Duration
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
AND ((unix_timestamp(Date_Time)+Duration)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromItem AS
SELECT
Nr_of_Viewers
Topic_Title
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
AND ((unix_timestamp(Date_Time)+Duration)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW testingTest AS
SELECT Date_Time,
Duration,
Time_Item_Given,
Nr_of_Viewers
FROM Edition FULL JOIN Item WHERE TIMESTAMPDIFF(SECOND, Date_Time, Time_Item_Given) > 0;

CREATE VIEW viewsFromTopic AS
SELECT
AVG(Nr_of_Viewers) 'Average number if viewers',
Topic_Title 'Topic title'
FROM Item;




#DROP VIEW viewsFromEdition;
CREATE VIEW viewsFromEdition AS
SELECT
Nr_of_Viewers 'Number of viewers',
Date_Time 'Edition time aired',
Duration 'Duration',
Item_Description
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
AND ((unix_timestamp(Date_Time)+Duration)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromItem AS
SELECT
Nr_of_Viewers
Topic_Title
FROM Edition NATURAL JOIN Item
WHERE
(true);

update Journalist
SET Country = 'USA'
WHERE Country = 'USA2';

#DROP TRIGGER journalist_country_update;
DELIMITER //
CREATE TRIGGER journalist_country_update
AFTER UPDATE ON Journalist
FOR EACH ROW
BEGIN
  IF NEW.Country != OLD.Country THEN
    UPDATE Item SET Item_Description = NULL;
  END IF;
END //
DELIMITER ;
