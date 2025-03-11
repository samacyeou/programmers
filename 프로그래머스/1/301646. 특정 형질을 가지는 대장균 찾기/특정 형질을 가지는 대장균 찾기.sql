SELECT
COUNT(*) COUNT
FROM
(
SELECT
IF(LENGTH(CONV(GENOTYPE, 10, 2)) < 4, LPAD(CONV(GENOTYPE, 10, 2),4, '0'), CONV(GENOTYPE, 10, 2)) AS GENOTYPE_CH
FROM ECOLI_DATA

) AS T
WHERE
SUBSTR(GENOTYPE_CH,-2,1) != '1'
AND (SUBSTR(GENOTYPE_CH,-1,1) = '1' OR SUBSTR(GENOTYPE_CH,-3,1) = '1')


# select count(*) as COUNT
# from ECOLI_DATA
# where RIGHT(LPAD(BIN(GENOTYPE),4,'0'), 3) = '101'
# or right(lpad(bin(genotype),4,'0'),3) = '100'
# or right(lpad(bin(genotype),4,'0'),3) = '001'