SELECT
    HISTORY_ID,
    floor(
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
    )) AS FEE
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
    
    
# WITH JOIN_TABLE AS (
# SELECT DAILY_FEE, HISTORY_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS 'DIF' , (CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 90 THEN "90일 이상"
# WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN "30일 이상"
# WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 7 THEN "7일 이상"
# END ) AS 'DURATION_TYPE'
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H LEFT JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID = C.CAR_ID
# WHERE C.CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = "트럭")
# )

# SELECT HISTORY_ID, TRUNCATE((100-DISCOUNT_RATE)*DAILY_FEE*J.DIF/100, 0) AS 'FEE'
# FROM JOIN_TABLE J LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON J.DURATION_TYPE = P.DURATION_TYPE
# WHERE CAR_TYPE ="트럭"
# ORDER BY FEE DESC, HISTORY_ID DESC