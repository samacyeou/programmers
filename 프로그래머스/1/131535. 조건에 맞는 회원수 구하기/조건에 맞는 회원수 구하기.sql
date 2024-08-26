SELECT count(USER_ID) as USERS
from user_info
where TO_CHAR(JOINED, 'YYYY') = '2021'
and age between 20 and 29;