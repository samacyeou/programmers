select car_id, to_char(round(avg(end_date - start_date + 1), 1), 'FM9990.0') as average_duration
from car_rental_company_rental_history
group by car_id 
having avg(end_date-start_date+1) >= 7
order by to_number(average_duration) desc, car_id desc