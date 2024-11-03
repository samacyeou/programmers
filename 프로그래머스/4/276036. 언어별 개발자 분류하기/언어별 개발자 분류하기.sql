-- 코드를 작성해주세요
# WITH F AS (
#     SELECT
#         D.ID AS ID,
#         D.SKILL_CODE AS CODE
#     FROM DEVELOPERS AS D
#         JOIN SKILLCODES AS S
#             ON D.SKILL_CODE & S.CODE = S.CODE AND S.CATEGORY = 'Front End'
# ), P AS (
#     SELECT
#         D.ID AS ID,
#         D.SKILL_CODE AS CODE
#     FROM DEVELOPERS AS D
#         JOIN SKILLCODES AS S
#             ON D.SKILL_CODE & S.CODE = S.CODE AND S.NAME = 'Python'
#         JOIN SKILLCODES AS BS
#             ON D.SKILL_CODE & BS.CODE = BS.CODE AND BS.CATEGORY = 'Front End'
# ), C AS (
#     SELECT
#         D.ID AS ID,
#         D.SKILL_CODE AS CODE
#     FROM DEVELOPERS AS D
#         JOIN SKILLCODES AS S
#             ON D.SKILL_CODE & S.CODE = S.CODE AND S.NAME = 'C#'
# )

# SELECT
#     CASE
#         WHEN ID IN (SELECT ID FROM P) THEN 'A'
#         WHEN ID IN (SELECT ID FROM C) THEN 'B'
#         WHEN ID IN (SELECT ID FROM F) THEN 'C'
#         ELSE NULL
#     END AS GRADE,
#     ID,
#     EMAIL
# FROM DEVELOPERS
# HAVING GRADE IS NOT NULL
# ORDER BY GRADE, ID





select 'A' as grade, c.id, c.email
from(
    select a.id, a.email, a.skill_code
    , b.name, b.category, b.code
    from DEVELOPERS as a
        inner join SKILLCODES as b
    where b.category = 'Front End'
    and a.skill_code & b.code <> 0
) as c
where c.skill_code & (select code from SKILLCODES where name = 'Python') <> 0

union

select 'B' as grade, id, email
from DEVELOPERS
where skill_code & (select code from SKILLCODES where name = 'C#') <> 0

union

select 'C' as grade, c.id, c.email
from(
    select a.id, a.email, a.skill_code
    , b.name, b.category, b.code
    from DEVELOPERS as a
        inner join SKILLCODES as b
    where b.category = 'Front End'
    and a.skill_code & b.code <> 0
) as c
where c.id not in (
    select c.id
    from(
        select a.id, a.email, a.skill_code
        , b.name, b.category, b.code
        from DEVELOPERS as a
            inner join SKILLCODES as b
        where b.category = 'Front End'
        and a.skill_code & b.code <> 0
    ) as c
    where c.skill_code & (select code from SKILLCODES where name = 'Python') <> 0
    union 
    select id
    from DEVELOPERS
    where skill_code & (select code from SKILLCODES where name = 'C#') <> 0
)
order by grade, id