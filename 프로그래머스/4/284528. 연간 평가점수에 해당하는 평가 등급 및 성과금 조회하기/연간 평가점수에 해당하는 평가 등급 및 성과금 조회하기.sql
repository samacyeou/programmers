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


SELECT A.EMP_NO, A.EMP_NAME, A.GRADE,         
            CASE
            WHEN A.GRADE = 'S' THEN E.SAL*0.2
            WHEN A.GRADE = 'A' THEN E.SAL*0.15
            WHEN A.GRADE = 'B' THEN E.SAL*0.1
            ELSE 0 END AS BONUS
    FROM (SELECT E.EMP_NO, 
            E.EMP_NAME, 
            CASE 
                WHEN AVG(G.SCORE) >= 96 THEN 'S'
                WHEN AVG(G.SCORE) >= 90 THEN 'A'
                WHEN AVG(G.SCORE) >= 80 THEN 'B'
                ELSE 'C' END AS GRADE
        FROM HR_DEPARTMENT D
        JOIN HR_EMPLOYEES E ON D.DEPT_ID = E.DEPT_ID
        JOIN HR_GRADE G ON G.EMP_NO = E.EMP_NO
        GROUP BY E.EMP_NO) A
    JOIN HR_EMPLOYEES E ON E.EMP_NO = A.EMP_NO
    ORDER BY 1;