SELECT NAME, count(*) as COUNT
from ANIMAL_INS
group by NAME
having count(*) >= 2 and name is not null
order by name