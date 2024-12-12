-- 코드를 입력하세요
# SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
# FROM PATIENT
# WHERE GEND_CD = 'W' AND AGE <= 12
# ORDER BY AGE DESC, PT_NAME ASC

# SELECT PT_NAME,PT_NO,GEND_CD,AGE,ifnull(TLNO,"NONE")as TLNO
# from PATIENT 
# where AGE <=12 and GEND_CD="w"and PT_NO !="PT22000022"
# order by AGE desc,PT_NAME asc;




select
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO,'NONE') as TLNO
from
    PATIENT
where
    AGE<=12 AND GEND_CD='W'
order by
    4 desc, 1;