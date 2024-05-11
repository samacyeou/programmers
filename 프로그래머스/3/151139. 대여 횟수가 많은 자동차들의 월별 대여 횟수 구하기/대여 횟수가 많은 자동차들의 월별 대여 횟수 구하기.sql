-- 코드를 입력하세요
WITH R AS (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING
        COUNT(CAR_ID) >= 5
)

SELECT
    MONTH(H.START_DATE) AS MONTH,
    H.CAR_ID,
    COUNT(H.START_DATE) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    JOIN R
        ON H.CAR_ID = R.CAR_ID
WHERE MONTH(H.START_DATE) IN ('08','09','10')
GROUP BY MONTH(H.START_DATE), CAR_ID
ORDER BY MONTH(H.START_DATE), CAR_ID DESC


# with cars as(SELECT car_id
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# where START_DATE between '2022-08-01' and '2022-10-31'
# group by CAR_ID
# having count(*) >= 5)

# select month(START_DATE) month, a.car_id, count(*) RECORDS 
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY a, cars b
# where a.car_id = b.car_id 
# group by month(START_DATE), a.car_id
# having count(*) > 0
# order by month asc, car_id desc