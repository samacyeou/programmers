select NAME, str_to_date(date_format(datetime, '%Y-%m-%d %H:%i:%s'), '%Y-%m-%d %H:%i:%s') as DATETIME
from animal_ins
order by animal_id desc