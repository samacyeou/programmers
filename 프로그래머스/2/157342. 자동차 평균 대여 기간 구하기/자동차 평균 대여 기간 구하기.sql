-- 코드를 입력하세요
SELECT
    CAR_ID,
    ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

# select b.car_id
#      , round(avg(b.used_date), 1) as average_duration
# from(
#     select a.*, datediff(end_date, start_date)+1 as used_date
#     from car_rental_company_rental_history as a
# ) as b
# group by b.car_id
# having avg(b.used_date) >= 7
# order by avg(b.used_date) desc, b.car_id desc
#     ;