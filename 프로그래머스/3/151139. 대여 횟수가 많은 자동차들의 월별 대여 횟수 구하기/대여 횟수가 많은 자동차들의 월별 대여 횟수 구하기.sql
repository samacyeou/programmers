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


with more_than_five as 
    (select
        month(start_date) as month,
        car_id,
        count(*) as records
    from    
        CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date > '2022-07-31'
    and start_date < '2022-11-01'

    group by car_id
    having count(car_id) >= 5
)

select 
    month(start_date) as MONTH,
    cr.car_id as CAR_ID,
    count(*) as RECORDS
from 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY cr
join more_than_five mt on cr.car_id = mt.car_id 
where start_date between '2022-08-01' and '2022-10-31'
group by 1,2
order by 1 asc, 2 desc