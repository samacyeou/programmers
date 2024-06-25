-- 코드를 입력하세요
SELECT
    A.AUTHOR_ID AS AUTHOR_ID,
    A.AUTHOR_NAME AS AUTHOR_NAME,
    B.CATEGORY AS CATEGORY,
    SUM(B.PRICE * S.SALES) AS TOTAL_SALES
FROM AUTHOR AS A
    JOIN BOOK AS B
        ON A.AUTHOR_ID = B.AUTHOR_ID
    JOIN BOOK_SALES AS S
        ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE LIKE '2022-01%'
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY DESC