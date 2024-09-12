-- 코드를 입력하세요
#SELECT
#    ANIMAL_ID,
#    NAME,
#    IF(SEX_UPON_INTAKE REGEXP 'Spayed|Neutered', 'O', 'X') AS 중성화
#FROM ANIMAL_INS
#ORDER BY ANIMAL_ID



SELECT animal_id, name,
       if (sex_upon_intake like '%Neutered%' or sex_upon_intake like '%Spayed%', 'O' , 'X') as '중성화'
from animal_ins
order by 1