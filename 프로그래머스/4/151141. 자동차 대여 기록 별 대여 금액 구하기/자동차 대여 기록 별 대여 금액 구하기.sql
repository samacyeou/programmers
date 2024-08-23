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