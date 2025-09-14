-- 코드를 입력하세요
# SELECT 
#     DISTINCT C.CAR_ID,
#     C.CAR_TYPE,
#     ROUND(C.DAILY_FEE * 30 * (100 - D.DISCOUNT_RATE) / 100,0) AS FEE
# FROM CAR_RENTAL_COMPANY_CAR AS C
#     LEFT JOIN (
#         SELECT *
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         WHERE
#             START_DATE <= '2022-11-30' AND
#             END_DATE >= '2022-11-01'
#         GROUP BY CAR_ID
#     ) AS H
#         ON C.CAR_ID = H.CAR_ID
#     JOIN (
#         SELECT CAR_TYPE, DISCOUNT_RATE
#         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
#         WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE LIKE '%30%'
#     ) AS D
#         ON C.CAR_TYPE = D.CAR_TYPE
# WHERE
#     C.CAR_TYPE IN ('세단', 'SUV') AND
#     30 * C.DAILY_FEE BETWEEN 500000 AND 2000000 AND
#     H.CAR_ID IS NULL
# GROUP BY C.CAR_ID
# ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC


# with f as (
#     select h.car_id, h.start_date, h.end_date, truncate(30 * c.daily_fee * (1 - d.discount_rate), 0) as fee
#     from car_rental_company_car as c
#         join car_rental_company_history as h
#             on h.car_id = c.car_id
#         join car_rental_company_discount_plan as d
#             on c.car_type = d.car_type
# )


WITH FST AS( -- 차종류만 체크한 아우터조인된 테이블
SELECT C.CAR_ID, R.START_DATE, R.END_DATE
  FROM CAR_RENTAL_COMPANY_CAR C
  LEFT OUTER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY R
    ON C.CAR_ID = R.CAR_ID
 WHERE 1=1 
   AND C.CAR_TYPE IN ('세단','SUV')
)
, DIS AS (
         SELECT CAR_TYPE, DISCOUNT_RATE 
           FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
          WHERE CAR_TYPE IN ('세단','SUV')
            AND DURATION_TYPE = '30일 이상'
)
SELECT C1.CAR_ID , C1.CAR_TYPE, ROUND((C1.DAILY_FEE * (1-D1.DISCOUNT_RATE/100) *30), 0) AS FEE
  FROM CAR_RENTAL_COMPANY_CAR C1
  JOIN DIS D1
    ON C1.CAR_TYPE = D1.CAR_TYPE
 WHERE 1=1 
  AND C1.CAR_TYPE IN ('세단','SUV')
  AND C1.CAR_ID NOT IN (
                        SELECT F.CAR_ID
                          FROM FST F
                         WHERE 1=1
                          AND F.START_DATE <= '2022-11-30'
                          AND F.END_DATE   >= '2022-11-01'
                        )
 AND (C1.DAILY_FEE * (1-D1.DISCOUNT_RATE/100) *30) BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, C1.CAR_TYPE ASC, C1.CAR_ID DESC