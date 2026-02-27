/*SELECT
COUNT(*) COUNT
FROM (
    SELECT
    IF(LENGTH(bin(genotype)) < 4,
       LPAD(bin(genotype),4, '0'),
       bin(genotype)
    ) AS GENOTYPE_CH
    FROM ECOLI_DATA
) AS T
WHERE
    right(genotype_ch, 3) regexp '101|100|001'
    # SUBSTR(GENOTYPE_CH,-2,1) != '1'
    # AND (SUBSTR(GENOTYPE_CH,-1,1) = '1' OR SUBSTR(GENOTYPE_CH,-3,1) = '1')*/


SELECT COUNT(*) as count
FROM ECOLI_DATA
WHERE MOD(GENOTYPE + 3,4) = 0 OR MOD(GENOTYPE + 4,8) = 0