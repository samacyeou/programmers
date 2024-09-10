-- 코드를 입력하세요
# SELECT
#     FOOD_TYPE,
#     REST_ID,
#     REST_NAME,
#     FAVORITES
# FROM REST_INFO AS D
#     JOIN (
#         SELECT MAX(FAVORITES) AS MAX
#         FROM REST_INFO
#         GROUP BY FOOD_TYPE
#     ) AS M
#     ON D.FAVORITES = M.MAX
# GROUP BY FOOD_TYPE
# ORDER BY FOOD_TYPE DESC





SELECT a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES
from REST_INFO a
    inner join (
    select FOOD_TYPE, max(FAVORITES) as MAX_FAVORITES
    from REST_INFO
    group by FOOD_TYPE
    ) b
    on a.FOOD_TYPE = b.FOOD_TYPE
    AND a.FAVORITES = b.MAX_FAVORITES
order by FOOD_TYPE desc
;

# SELECT a.FOOD_TYPE, a.REST_ID, a.REST_NAME, a.FAVORITES
# from REST_INFO a
#     inner join (
#     select REST_ID, max(FAVORITES) as MAX_FAVORITES
#     from REST_INFO
#     group by FOOD_TYPE
#     ) b
#     on a.REST_ID = b.REST_ID
#     AND a.FAVORITES = b.MAX_FAVORITES
# order by FOOD_TYPE desc
# ;