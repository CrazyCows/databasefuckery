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
SELECT * FROM birthdayview;

SELECT * FROM TOPIC;

CALL journalist_role_count();
SELECT total_journalists_by_country('USA');