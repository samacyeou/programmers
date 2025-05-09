-- select car_id, to_char(round(avg(end_date - start_date + 1), 1), 'FM9990.0') as average_duration
-- from car_rental_company_rental_history
-- group by car_id 
-- having avg(end_date-start_date+1) >= 7
-- order by to_number(average_duration) desc, car_id desc


select A.car_id
     , to_char(round(avg(A.D_PER_CPTA), 1),'FM9990.0') as "AVERAGE_DURATION"
  from (select HISTORY_ID
             , CAR_ID
             , TO_CHAR(START_DATE, 'YYYY-MM-DD')
             , TO_CHAR(END_DATE, 'YYYY-MM-DD')
             , case when END_DATE - START_DATE + 1 > 0
                    then END_DATE - START_DATE + 1
                    else 0
                     end as "D_PER_CPTA" -- 건당 대여일수  
          from CAR_RENTAL_COMPANY_RENTAL_HISTORY) A
 group by A.car_id
having avg(A.D_PER_CPTA) >= 7
 order by to_number(average_duration) desc, 1 desc