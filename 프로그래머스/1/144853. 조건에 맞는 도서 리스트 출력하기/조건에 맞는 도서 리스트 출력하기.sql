-- 코드를 입력하세요
SELECT
    book.BOOK_ID as BOOK_ID
    , to_char(PUBLISHED_DATE, 'YYYY-MM-DD')
FROM BOOK
WHERE CATEGORY = '인문' and to_char(published_date, 'YYYY') = '2021'

ORDER BY PUBLISHED_DATE ASC;