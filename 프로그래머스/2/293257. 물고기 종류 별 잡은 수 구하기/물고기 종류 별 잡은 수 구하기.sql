-- 코드를 작성해주세요
select count(*) as fish_count, f2.fish_name as fish_name
from fish_info as f1
    inner join fish_name_info as f2
        on f1.fish_type = f2.fish_type
group by fish_name
order by fish_count desc




# SELECT *
#      # F2.FISH_COUNT,
#      # F1.FISH_NAME
#  FROM FISH_NAME_INFO F1 JOIN (
#      SELECT
#          COUNT(*) AS FISH_COUNT,
#          FISH_TYPE
#      FROM FISH_INFO
#      GROUP BY FISH_TYPE
#  )F2 ON F1.FISH_TYPE = F2.FISH_TYPE
#  # ORDER BY 1 DESC;