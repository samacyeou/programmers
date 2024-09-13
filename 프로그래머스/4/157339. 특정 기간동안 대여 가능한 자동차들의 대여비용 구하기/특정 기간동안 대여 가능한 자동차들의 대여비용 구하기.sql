-- 코드를 입력하세요
SELECT 
    DISTINCT C.CAR_ID,
    C.CAR_TYPE,
    ROUND(C.DAILY_FEE * 30 * (100 - D.DISCOUNT_RATE) / 100,0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS C
    LEFT JOIN (
        SELECT *
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE <= '2022-11-30' AND
            END_DATE >= '2022-11-01'
        GROUP BY CAR_ID
    ) AS H
        ON C.CAR_ID = H.CAR_ID
    JOIN (
        SELECT CAR_TYPE, DISCOUNT_RATE
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE LIKE '%30%'
    ) AS D
        ON C.CAR_TYPE = D.CAR_TYPE
WHERE
    C.CAR_TYPE IN ('세단', 'SUV') AND
    30 * C.DAILY_FEE BETWEEN 500000 AND 2000000 AND
    H.CAR_ID IS NULL
GROUP BY C.CAR_ID
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC





# WITH car_rental_type AS(
#     SELECT *
#     FROM car_rental_company_car
#     WHERE car_type IN ('세단', 'SUV')
# ),

# car_rental_type_date AS(
#     SELECT *
#     FROM car_rental_type c 
#     INNER JOIN car_rental_company_rental_history h USING(car_id)
#     WHERE h.start_date < '2022-11-01' AND h.end_date > '2022-11-30'
# )

# SELECT 
#     c.car_id, 
#     c.car_type, 
#     ROUND(((c.daily_fee - (c.daily_fee * p.discount_rate/100)) * 30)) fee
# FROM car_rental_type_date c
# LEFT JOIN car_rental_company_discount_plan p
# ON c.car_type = p.car_type 
# AND p.duration_type = '30일 이상'
# WHERE ((c.daily_fee - (c.daily_fee * p.discount_rate/100)) * 30) 
# BETWEEN 500000 AND 1999999
# ORDER BY 3 DESC, 2, 1 DESC