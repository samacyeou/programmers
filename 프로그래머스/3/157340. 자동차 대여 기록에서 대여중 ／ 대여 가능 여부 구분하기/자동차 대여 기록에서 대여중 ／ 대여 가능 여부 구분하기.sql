-- 코드를 입력하세요
SELECT
    O.CAR_ID AS CAR_ID,
    IF(P.CAR_ID IS NULL, '대여 가능', '대여중') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS O
    LEFT JOIN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE <= '2022-10-16' AND
            END_DATE >= '2022-10-16'
    ) AS P
    ON O.CAR_ID = P.CAR_Id
GROUP BY O.CAR_ID
ORDER BY O.CAR_ID DESC


# SELECT CAR_ID, 
#        CASE WHEN MAX(START_DATE) < '2022-10-16' AND '2022-10-16' < MAX(END_DATE) THEN '대여중'
#             WHEN '2022-10-16' = MAX(END_DATE) THEN '대여중'
#             ELSE '대여 가능'
#             END AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY 1
# ORDER BY 1 DESC;


# select *
# from car_rental_company_rental_history
# order by car_id desc