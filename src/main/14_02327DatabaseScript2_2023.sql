SELECT * FROM Journalist;
SELECT * FROM edition;
SELECT * FROM email;
SELECT * FROM footage;
SELECT * FROM item;
SELECT * FROM phone;
SELECT * FROM roles;
SELECT * FROM topic;
SELECT * FROM JournalListView;
SELECT * FROM PhoneNumberView;
SELECT * FROM EmailAddressView;
SELECT * FROM RoleViewModified;
SELECT * FROM EditionView;
SELECT * FROM viewsFromTopic;
SELECT * FROM viewsFromEdition;
SELECT * FROM viewsFromItem;
SELECT * FROM AVGViewsFromTopic;
SELECT * FROM workContactInfo;
SELECT * FROM BirthDayView;
CALL journalist_role_count();
SELECT total_journalists_by_country('USA');
