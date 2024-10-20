-- select a.month, a.car_id, a.records
-- from (
--           select to_number(to_char(start_date,'MM')) as month, car_id, count(history_id) as records
--           from CAR_RENTAL_COMPANY_RENTAL_HISTORY
--           where to_char(start_date,'YYYYMM') BETWEEN '202208' AND '202210'
--           group by to_number(to_char(start_date,'MM')), car_id
--           having count(history_id) >= 5
--         ) a
-- order by 1, 2 desc



WITH car_rentals AS (
    SELECT car_id,
           count(history_id) as total_records
    FROM car_rental_company_rental_history
    WHERE start_date BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD') 
                         AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
    GROUP BY car_id
    HAVING count(history_id) >= 5
)
SELECT to_number(substr(to_char(start_date,'yyyymmdd'), 5, 2)) AS month,
       crh.car_id,
       count(crh.history_id) AS records
FROM car_rental_company_rental_history crh
JOIN car_rentals cr
ON crh.car_id = cr.car_id
WHERE crh.start_date BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD') 
                          AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
GROUP BY substr(to_char(crh.start_date, 'yyyymmdd'), 5, 2), crh.car_id
HAVING count(crh.history_id) > 0
ORDER BY month ASC, crh.car_id DESC;