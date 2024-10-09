SELECT
    HISTORY_ID,
    ROUND(
        DAILY_FEE * (DATEDIFF(END_DATE, START_DATE) + 1) *
        (1 - COALESCE(
            (SELECT DISCOUNT_RATE
            FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN
            WHERE PLAN.CAR_TYPE = CAR.CAR_TYPE
                AND PLAN.DURATION_TYPE =
                    CASE
                        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN '90일 이상'
                        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '30일 이상'
                        WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN '7일 이상'
                    END
            ) / 100, 0)
    ), 0) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR AS CAR
    JOIN
        CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HIS
    ON
        CAR.CAR_ID = HIS.CAR_ID
WHERE
    CAR.CAR_TYPE = '트럭'
ORDER BY
    FEE DESC,
    HIS.HISTORY_ID DESC;
    
    
    
# WITH TABLE1 AS (
#     SELECT
#         H.HISTORY_ID,
#         H.CAR_ID, datediff(H.END_DATE, H.START_DATE) + 1 AS DURATION,
#         C.DAILY_FEE,
#         h.start_date,
#         h.end_date
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
#         JOIN CAR_RENTAL_COMPANY_CAR C
#             ON H.CAR_ID = C.CAR_ID
#     WHERE C.CAR_TYPE = '트럭'
# ),

# TABLE2 AS (
#     SELECT
#         HISTORY_ID,
#         CAR_ID,
#         DURATION,
#         CASE
#             WHEN DURATION >= 7 AND DURATION < 30 THEN '7일 이상'
#             WHEN DURATION >= 30 AND DURATION < 90 THEN '30일 이상'
#             WHEN DURATION >= 90 THEN '90일 이상'
#             ELSE '미만'
#         END AS period,
#         DAILY_FEE
#     FROM TABLE1
# )

# SELECT
#     T.HISTORY_ID,
#     CASE
#         WHEN T.period = '7일 이상'
#             THEN FLOOR((T.DAILY_FEE * T.DURATION * (100 - P.DISCOUNT_RATE) * 0.01))
#         WHEN T.period = '30일 이상'
#             THEN FLOOR((T.DAILY_FEE * T.DURATION * (100 - P.DISCOUNT_RATE) * 0.01))
#         WHEN T.period = '90일 이상'
#             THEN FLOOR((T.DAILY_FEE * T.DURATION * (100 - P.DISCOUNT_RATE) * 0.01))
#         ELSE FLOOR(T.DAILY_FEE * T.DURATION)
#     END AS FEE
# FROM TABLE2 T
# JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON T.period = P.DURATION_TYPE
# WHERE P.CAR_TYPE = '트럭'
# ORDER BY FEE DESC, T.HISTORY_ID DESC;