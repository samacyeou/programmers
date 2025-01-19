# SELECT COUNT(FISH_TYPE) AS FISH_COUNT,
# MAX(LENGTH) AS MAX_LENGTH,
# FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE
# HAVING AVG(IFNULL(LENGTH, 10)) >= 33
# ORDER BY FISH_TYPE


select count(*) as fish_count,
max(f.length) as max_length, f.fish_type
from fish_info as f
where f.fish_type in ( select fish_type
from fish_info
group by fish_type
having avg(IFNULL(LENGTH, 10))>=33)
group by f.fish_type
order by f.fish_type