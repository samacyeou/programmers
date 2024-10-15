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





WITH CAR AS (
    SELECT 
        CAR_ID,
        CAR_TYPE,
        DAILY_FEE
    FROM CAR_RENTAL_COMPANY_CAR 
    WHERE 
        CAR_TYPE IN ('SUV', '세단')
),

HISTORY AS (
    SELECT 
        DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        (START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01')
),

PLAN AS( 
    SELECT 
        CAR_TYPE, 
        DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE 
            DURATION_TYPE = '30일 이상'
        AND 
            CAR_TYPE IN ('세단', 'SUV')
)

SELECT
    C.CAR_ID, 
    C.CAR_TYPE, 
    ROUND((DAILY_FEE * 30 * (100 - P.DISCOUNT_RATE) / 100), 0) AS FEE
FROM CAR AS C
LEFT JOIN HISTORY AS H ON C.CAR_ID = H.CAR_ID
LEFT JOIN PLAN AS P ON C.CAR_TYPE = P.CAR_TYPE
WHERE 
    H.CAR_ID IS NULL
    AND ROUND((DAILY_FEE * 30 * (100 - P.DISCOUNT_RATE) / 100), 0) >= 500000
    AND ROUND((DAILY_FEE * 30 * (100 - P.DISCOUNT_RATE) / 100), 0) < 2000000
ORDER BY 
    FEE DESC,
    C.CAR_TYPE ASC,
    C.CAR_ID DESC;