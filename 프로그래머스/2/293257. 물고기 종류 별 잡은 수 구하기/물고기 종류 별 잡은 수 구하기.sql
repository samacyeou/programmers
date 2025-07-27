-- 코드를 작성해주세요
select count(*) as fish_count, f2.fish_name as fish_name
from fish_info as f1
    join fish_name_info as f2
        on f1.fish_type = f2.fish_type
where fish_name is not null
group by fish_name
order by fish_count desc

# with test1 as (
#     SELECT FI.FISH_TYPE
#         , COUNT(*) FISH_COUNT
#     FROM FISH_INFO FI
#     GROUP BY FI.FISH_TYPE
# ), test2 as (
#     select fi.fish_type, fish_count
#     from test1 as FI
#         left JOIN fish_name_info FNI
#         ON FI.FISH_TYPE = FNI.FISH_TYPE
# ), test3 as (
#     select fi.fish_type, fish_count
#     from test1 as FI
#         JOIN fish_name_info FNI
#         ON FI.FISH_TYPE = FNI.FISH_TYPE
# ), test_result as (
#     select count(*) as count
#     from test2
#     union
#     select count(*) as count
#     from test3
# ), result as (
#     select count(*) as count
#     from test_result
# ), a as (
#     select 1 as id, 1 as fish_type
# ), b as (
#     select 2 as fish_type, 'A' as fish_name
# ), c as (
#     select fish_type, count(*) as fish_count
#     from a
#     group by fish_type
# ), d as (
#     select fish_count, b.fish_name
#     from c
#         left join b
#             on c.fish_type = b.fish_type
# )

# with test as (
#     select count(*) as count
#     from fish_info
#     group by fish_type
# ), t1 as (
#     select count(*) as count
#     from fish_name_info as a join fish_info as b on a.fish_type = b.fish_type
#     group by a.fish_type
# ), re as (
#     select count(*) as count
#     from (select sum(count) as count
#     from test
#     union
#     select sum(count) as count
#     from t1) as b
# )


# select if(re.count = 1, count(b.id), -1) as FISH_COUNT, a.fish_name as FISH_NAME
# from fish_name_info as a
# join fish_info as b
# on a.fish_type = b.fish_type
# join re on 1
# group by a.fish_name, re.count
# order by FISH_COUNT desc

# with test as (
#     SELECT FI.FISH_COUNT
#          , FNI.FISH_NAME
#       FROM (
#            SELECT FI.FISH_TYPE
#                 , COUNT(*) FISH_COUNT
#              FROM FISH_INFO FI
#             GROUP BY FI.FISH_TYPE
#            ) FI
#       LEFT JOIN FISH_NAME_INFO FNI
#         ON FI.FISH_TYPE = FNI.FISH_TYPE
#      ORDER BY FI.FISH_COUNT DESC
# ), t1 as (
#     SELECT FI.FISH_COUNT
#          , FNI.FISH_NAME
#       FROM (
#            SELECT FI.FISH_TYPE
#                 , COUNT(*) FISH_COUNT
#              FROM FISH_INFO FI
#             GROUP BY FI.FISH_TYPE
#            ) FI
#       JOIN FISH_NAME_INFO FNI
#         ON FI.FISH_TYPE = FNI.FISH_TYPE
#      ORDER BY FI.FISH_COUNT DESC
# ), re as (
#     select count(*) as count
#     from (
#         select sum(fish_count) as count
#         from test
#         union
#         select sum(fish_count) as count
#         from t1
#     ) as a
# )



/*SELECT if(re.count = 1, T2.FISH_COUNT, -1) AS FISH_COUNT, T3.FISH_NAME AS FISH_NAME
FROM (
SELECT FISH_TYPE, COUNT(*) AS FISH_COUNT
FROM FISH_INFO
GROUP BY FISH_TYPE
) AS T2
left JOIN FISH_NAME_INFO AS T3
join re on 1
ON T2.FISH_TYPE = T3.FISH_TYPE
where t3.fish_name is not NULL
ORDER BY T2.FISH_COUNT DESC*/


# SELECT COUNT(1) AS FISH_COUNT, T2.FISH_NAME AS FISH_NAME
# FROM FISH_INFO AS T1
# JOIN FISH_NAME_INFO AS T2
# ON T1.FISH_TYPE=T2.FISH_TYPE
# GROUP BY T2.FISH_TYPE,T2.FISH_NAME
# ORDER BY FISH_COUNT DESC

# SELECT FI.FISH_COUNT
#      , FNI.FISH_NAME
#   FROM (
#        SELECT FI.FISH_TYPE
#             , COUNT(*) FISH_COUNT
#          FROM FISH_INFO FI
#         GROUP BY FI.FISH_TYPE
#        ) FI
#   LEFT JOIN FISH_NAME_INFO FNI
#     ON FI.FISH_TYPE = FNI.FISH_TYPE
#  ORDER BY FI.FISH_COUNT DESC