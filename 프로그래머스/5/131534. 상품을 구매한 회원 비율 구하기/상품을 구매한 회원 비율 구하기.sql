-- 코드를 입력하세요
SELECT
    YEAR(ONLINE_SALE.SALES_DATE) AS YEAR,
    MONTH(ONLINE_SALE.SALES_DATE) AS MONTH,
    COUNT(DISTINCT ONLINE_SALE.USER_ID) AS PUCHASED_USERS,
    ROUND(
        COUNT(DISTINCT ONLINE_SALE.USER_ID) /
        (SELECT COUNT(USER_ID)
        FROM USER_INFO
        WHERE YEAR(JOINED) = '2021'),1
        ) AS PUCHASED_RATIO
FROM ONLINE_SALE JOIN USER_INFO
    ON ONLINE_SALE.USER_ID = USER_INFO.USER_ID
WHERE YEAR(USER_INFO.JOINED) = '2021'
GROUP BY YEAR(ONLINE_SALE.SALES_DATE), MONTH(ONLINE_SALE.SALES_DATE)
ORDER BY YEAR(ONLINE_SALE.SALES_DATE), MONTH(ONLINE_SALE.SALES_DATE)