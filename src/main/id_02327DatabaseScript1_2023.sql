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
SELECT First_Name 'First name',
       Current_Roles 'Role',
       Topic_title 'Topic title',
       Date_time 'Time of broadcast',
       Duration 'Duration (m)'
FROM Roles NATURAL JOIN Edition NATURAL JOIN Journalist;

CREATE VIEW EditionView AS
SELECT Date_Time,
Duration,
Time_Item_Given,
Nr_of_Viewers
FROM Edition FULL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
                                    AND ((unix_timestamp(Date_Time)+Duration*60)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromTopic AS
SELECT
Nr_of_Viewers 'Number of views',
Topic_Title 'Topic'
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
AND ((unix_timestamp(Date_Time)+Duration*60)>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromEdition AS
SELECT
    Nr_of_Viewers 'Number of viewers',
    Date_Time 'Edition time aired',
    Duration 'Duration (minutes)',
    Item_Description 'Item with viewers'
FROM Edition NATURAL JOIN Item WHERE ((unix_timestamp(Date_Time)<=unix_timestamp(Time_Item_Given))
    AND ((unix_timestamp(Date_Time)+(Duration*60))>=unix_timestamp(Time_Item_Given)));

CREATE VIEW viewsFromItem AS
SELECT
    Nr_of_Viewers,
    Topic_Title
    Item_Description
FROM Item;

CREATE VIEW AVGViewsFromTopic AS
SELECT
DISTINCTROW Topic_Title 'Topic title',
AVG(Nr_of_Viewers) OVER (PARTITION BY Topic_Title) 'Average number of views'
FROM Item;

#THIS NOW WORKS
CREATE VIEW workContactInfo AS
    SELECT
    First_Name,
    Last_Name,
    Phone_Number 'Work phone',
    Email 'Work email'
    FROM
        email NATURAL JOIN phone INNER JOIN journalist j ON Email.CPR = j.CPR
    WHERE (((Description_Phone) = 'WORK') AND (Description_Email = 'WORK'));




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



DELIMITER //
CREATE FUNCTION HighestViewersForTopic(topic_title VARCHAR(255))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE highest_viewers INT;
    SELECT MAX(Nr_of_Viewers) INTO highest_viewers
    FROM Item
    WHERE Item.Topic_Title = topic_title;
    RETURN highest_viewers;
END //
DELIMITER ;