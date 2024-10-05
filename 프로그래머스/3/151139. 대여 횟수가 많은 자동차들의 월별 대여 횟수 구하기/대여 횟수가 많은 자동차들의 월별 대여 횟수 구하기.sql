-- 코드를 입력하세요
# WITH R AS (
#     SELECT CAR_ID
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
#     GROUP BY CAR_ID
#     HAVING
#         COUNT(CAR_ID) >= 5
# )

# SELECT
#     MONTH(H.START_DATE) AS MONTH,
#     H.CAR_ID,
#     COUNT(H.START_DATE) AS RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
#     JOIN R
#         ON H.CAR_ID = R.CAR_ID
# WHERE MONTH(H.START_DATE) IN ('08','09','10')
# GROUP BY MONTH(H.START_DATE), CAR_ID
# ORDER BY MONTH(H.START_DATE), CAR_ID DESC


WITH FilteredCars AS (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(CAR_ID) >= 5
)
SELECT 
    MONTH(B.START_DATE) AS MONTH, 
    B.CAR_ID, 
    COUNT(B.CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B 
JOIN FilteredCars F ON B.CAR_ID = F.CAR_ID 
WHERE B.START_DATE >= '2022-08-01' AND B.START_DATE < '2022-11-01'
GROUP BY MONTH(B.START_DATE), B.CAR_ID
ORDER BY MONTH(B.START_DATE), B.CAR_ID DESC;