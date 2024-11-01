# SELECT COUNT(FISH_TYPE) AS FISH_COUNT,
# MAX(LENGTH) AS MAX_LENGTH,
# FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE
# HAVING AVG(IFNULL(LENGTH, 10)) >= 33
# ORDER BY FISH_TYPE


with test as (
    select count(*) as count
    from fish_info
    union
    select count(*) as count
    from fish_info as FI
        JOIN (
            SELECT 
                ID,
                CASE
                    WHEN(LENGTH > 10) THEN LENGTH
                    ELSE 10
                END AS LENGTH
            FROM FISH_INFO
        ) AS FI2
            ON FI.ID = FI2.ID
), test_result as (
    select count(*) as count
    from test
), t as (
    select count(*) as count
    from fish_info
    union
    select count(*) as count
    from (
        select count(*) as count
        from fish_info
        group by id
    ) as s
), t_result as (
    select count(*) as count
    from t
)

# SELECT
#     COUNT(fish_type) AS FISH_COUNT,
#     MAX(FI.LENGTH) AS MAX_LENGTH, 
#     FISH_TYPE
# FROM FISH_INFO AS FI
#     JOIN (
#         SELECT 
#             ID,
#             CASE
#                 WHEN(LENGTH > 10) THEN LENGTH
#                 ELSE 10
#             END AS LENGTH
#         FROM FISH_INFO
#     ) AS FI2
#         ON FI.ID = FI2.ID
# GROUP BY FISH_TYPE
# HAVING AVG(ifnull(FI.LENGTH, 10)) >= 33
# ORDER BY FISH_TYPE



select
    case
        when t_result.count = 1 then COUNT(fish_type)
        else 0
    end as fish_count,
    case
        when t_result.count = 1 then max(length)
        else 0
    end as max_length,
    fish_type
from fish_info, t_result
group by fish_type, t_result.count
having avg(ifnull(length, 10)) >= 33
order by fish_type