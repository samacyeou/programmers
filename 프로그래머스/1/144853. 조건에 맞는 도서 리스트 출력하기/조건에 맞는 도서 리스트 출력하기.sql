# -- 코드를 입력하세요
# SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
# FROM BOOK
# WHERE PUBLISHED_DATE LIKE '2021%' AND CATEGORY LIKE '%인문%'
# ORDER BY PUBLISHED_DATE ASC


SELECT book_id, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
from book
where extract(year from published_date) = '2021'
and category = '인문'
order by published_date asc;