# -- 코드를 작성해주세요
# WITH GRADE AS (
#     SELECT
#         CASE
#             WHEN (AVG(G.SCORE) >= 96) THEN 'S'
#             WHEN (AVG(G.SCORE) >= 90) THEN 'A'
#             WHEN (AVG(G.SCORE) >= 80) THEN 'B'
#             ELSE 'C'
#         END AS GRADE,
#         E.EMP_NO AS NO
#     FROM HR_EMPLOYEES AS E
#         JOIN HR_GRADE AS G
#             ON E.EMP_NO = G.EMP_NO
#     GROUP BY E.EMP_NO
# )

# SELECT
#     E.EMP_NO,
#     E.EMP_NAME,
#     G.GRADE AS GRADE,
#     CASE
#         WHEN (G.GRADE = 'S') THEN E.SAL * 0.2
#         WHEN (G.GRADE = 'A') THEN E.SAL * 0.15
#         WHEN (G.GRADE = 'B') THEN E.SAL * 0.1
#         WHEN (G.GRADE = 'C') THEN 0
#     END AS BONUS
# FROM HR_EMPLOYEES AS E
#     JOIN GRADE AS G
#         ON E.EMP_NO = G.NO
# ORDER BY E.EMP_NO


select
    e.EMP_NO
    ,e.EMP_NAME
    ,CASE
    WHEN AVG(g.score) >= 96 THEN 'S'
    WHEN AVG(g.score) >= 90 THEN 'A'
    WHEN AVG(g.score) >= 80 THEN 'B'
    ELSE 'C'
    END AS GRADE,
    (CASE
        WHEN AVG(g.score) >= 96 THEN 0.2
        WHEN AVG(g.score) >= 90 THEN 0.15
        WHEN AVG(g.score) >= 80 THEN 0.1
        ELSE 0
    END) * e.SAL AS BONUS
from HR_GRADE g
    Left join HR_EMPLOYEES e
    on g.EMP_NO = e.EMP_NO
GROUP BY e.EMP_NO, e.EMP_NAME
order by e.EMP_NO asc

