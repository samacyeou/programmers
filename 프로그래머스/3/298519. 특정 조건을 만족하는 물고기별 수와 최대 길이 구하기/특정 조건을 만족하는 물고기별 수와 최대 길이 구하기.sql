# SELECT COUNT(FISH_TYPE) AS FISH_COUNT,
# MAX(LENGTH) AS MAX_LENGTH,
# FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE
# HAVING AVG(IFNULL(LENGTH, 10)) >= 33
# ORDER BY FISH_TYPE



with a as (
   select id
    from fish_info
    group by id
), test as (
    select count(*) as c
    from a
), t1 as (
    select count(*) as c
    from fish_info
), t2 as (
    select c
    from test
    union
    select c
    from t1
), t3 as (
    select count(*) as cou
    from t2
)

# SELECT
#     if(t3.cou=1, COUNT(*), -1) AS FISH_COUNT,
#     MAX(revise) AS MAXLENGTH,
#     a.FISH_TYPE AS FISH_TYPE
# FROM FISH_INFO AS a
#     INNER JOIN (
#         SELECT ID, IFNULL(LENGTH, 10) AS revise
#         FROM fish_info) AS b
# ON a.ID = b.ID, t3
# GROUP BY a.FISH_TYPE
# HAVING AVG(revise) >= 33
# ORDER BY a.FISH_TYPE;


SELECT COUNT(*) AS FISH_COUNT, MAX(IFNULL(LENGTH, 10)) AS MAXLENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(IFNULL(LENGTH, 10)) >= 33
ORDER BY FISH_TYPE;