-- WITH USER2021 AS(
--     SELECT *
--     FROM USER_INFO
--     WHERE TO_CHAR(JOINED,'YYYY') ='2021'
-- ),
-- SALES2022 AS(
--     SELECT *
--     FROM ONLINE_SALE
--     WHERE TO_CHAR(SALES_DATE,'YYYY') ='2022'
-- )
-- SELECT
--     YEAR,
--     MONTH,
--     COUNT(DISTINCT USER_ID) AS PURCHASED_USERS,
--     to_number(to_char(ROUND(
--         COUNT(DISTINCT USER_ID) /
--         (
--             SELECT COUNT(USER_ID)
--             FROM USER2021
--         ), 1
--     ), 'FM9990.0')) AS PUCHASED_RATIO
-- FROM
--     (
--         SELECT
--             EXTRACT(YEAR FROM SALES_DATE) YEAR,
--             EXTRACT(MONTH FROM SALES_DATE) MONTH,
--             U.USER_ID
--         FROM SALES2022 O , USER2021 U
--         WHERE O.USER_ID = U.USER_ID
--     )
-- GROUP BY YEAR , MONTH
-- ORDER BY YEAR, MONTH;



SELECT
    B.YEAR as year
    , B.MONTH as month
    , B.USER_CNT AS PURCHASED_USERS
    , ROUND(B.USER_CNT/A.CNT,1) AS PUCHASEDRATIO
FROM (
        SELECT
            COUNT(DISTINCT USER_ID) AS CNT
        FROM USER_INFO
        WHERE TO_NUMBER(TO_CHAR(JOINED,'YYYY')) = 2021
    ) A
, (
    SELECT
        to_number(TO_CHAR(B.SALES_DATE, 'YYYY')) AS YEAR
        , to_number(TO_CHAR(B.SALES_DATE, 'FMMM')) AS MONTH
        , COUNT(DISTINCT B.USER_ID) AS USER_CNT
    FROM USER_INFO A
    INNER JOIN
    ONLINE_SALE B
    ON A.USER_ID = B.USER_ID
    WHERE TO_NUMBER(TO_CHAR(A.JOINED,'YYYY')) = 2021
    GROUP BY
        to_number(TO_CHAR(B.SALES_DATE, 'YYYY'))
        , to_number(TO_CHAR(B.SALES_DATE, 'FMMM'))
    ORDER BY
        YEAR
        , MONTH
) B