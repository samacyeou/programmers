# SELECT
#     C.ID AS ID,
#     C.GENOTYPE AS GENOTYPE,
#     P.GENOTYPE AS PARENT_GENOTYPE
# FROM
#     ECOLI_DATA AS C
#         JOIN ECOLI_DATA AS P
#             ON C.PARENT_ID = P.ID
#                 AND C.GENOTYPE & P.GENOTYPE = P.GENOTYPE
# ORDER BY C.ID


SELECT B.ID, B.GENOTYPE, B.PRTGENO as parent_genotype
-- , B.GEN2, B.PRTGEN2
-- , MID(B.GEN2, B.GEN2LEN-B.PRTGEN2LEN+1, B.PRTGEN2LEN) AS CPGEN
FROM(
    SELECT 
        A.ID
        , a.genotype
        , (select genotype from ecoli_data where id = a.parent_id) as prtgeno
        , CONV(A.GENOTYPE, 10, 2) AS GEN2
        , CONV((SELECT sub.GENOTYPE FROM ECOLI_DATA as sub WHERE sub.ID = A.PARENT_ID), 10, 2) AS PRTGEN2
    FROM ECOLI_DATA AS A
    WHERE A.PARENT_ID IS NOT NULL
) AS B
# WHERE B.PRTGEN2 = MID(B.GEN2, length(B.GEN2)-length(B.PRTGEN2)+1, length(B.PRTGEN2))
where b.genotype & b.prtgeno = b.prtgeno
ORDER BY B.ID
;