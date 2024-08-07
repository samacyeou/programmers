SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE,'%Y-%m-%d') AS START_DATE, DATE_FORMAT(END_DATE,'%Y-%m-%d') AS END_DATE,
    IF(DATEDIFF(END_DATE, START_DATE)+1 >= 30,'장기 대여','단기 대여') AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE ('%2022-09%')
ORDER BY HISTORY_ID DESC

# SELECT
#     HISTORY_ID,
#     CAR_ID, 
#     DATE_FORMAT(START_DATE, '%Y-%m-%d') START_DATE,
#     DATE_FORMAT(END_DATE,'%Y-%m-%d') END_DATE,
#     CASE WHEN
#         DATEDIFF(START_DATE, END_DATE) >= 30 THEN '장기 대여'
#         ELSE '단기 대여' 
#     END AS RENT_TYPE
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09'
# ORDER BY HISTORY_ID DESC