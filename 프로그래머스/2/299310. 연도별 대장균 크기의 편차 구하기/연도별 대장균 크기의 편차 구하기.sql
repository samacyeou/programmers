# SELECT
#     YEAR(DIFFERENTIATION_DATE) AS YEAR,
#     ((
#         SELECT MAX(SIZE_OF_COLONY)
#         FROM ECOLI_DATA a
#         WHERE YEAR(a.DIFFERENTIATION_DATE) = YEAR(b.DIFFERENTIATION_DATE)
#     ) - b.SIZE_OF_COLONY) AS YEAR_DEV,
#     b.ID
# FROM ECOLI_DATA b
# ORDER BY YEAR, YEAR_DEV



select
    convert(left(a.DIFFERENTIATION_DATE, 4), unsigned INTEGER) as YEAR,
    (b.MAXCOLONY - a.SIZE_OF_COLONY) as YEAR_DEV,
    a.ID
from ECOLI_DATA a
    left join (
        select
            left(c.DIFFERENTIATION_DATE, 4) as YEAR,
            max(c.SIZE_OF_COLONY) as MAXCOLONY
        from ECOLI_DATA c
        group by left(c.DIFFERENTIATION_DATE, 4)
    ) b
        on b.YEAR = left(a.DIFFERENTIATION_DATE, 4)
order by YEAR asc, YEAR_DEV asc;