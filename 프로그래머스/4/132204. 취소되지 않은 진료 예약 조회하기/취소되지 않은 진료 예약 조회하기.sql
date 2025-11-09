-- 코드를 입력하세요
/*SELECT
    A.APNT_NO AS APNT_NO,
    P.PT_NAME AS PT_NAME,
    P.PT_NO AS PT_NO,
    A.MCDP_CD AS MCDP_CD,
    D.DR_NAME AS DR_NAME,
    A.APNT_YMD AS APNT_YMD
FROM PATIENT AS P
    JOIN APPOINTMENT AS A
        ON P.PT_NO = A.PT_NO
    JOIN DOCTOR AS D
        ON A.MDDR_ID = D.DR_ID
WHERE
    A.MCDP_CD = 'CS' AND
    A.APNT_YMD LIKE '2022-04-13%' AND
    A.APNT_CNCL_YN != 'Y'
ORDER BY APNT_YMD ASC*/



with rsvday_patchart as (select APNT_NO, PT_NAME, pat.PT_NO, MCDP_CD, MDDR_ID, APNT_YMD
                       from appointment as appoint
                       left join PATIENT as pat
                       on appoint.PT_NO = pat.PT_NO
                       where (DATE_FORMAT(APNT_YMD, "%Y-%m-%d") = "2022-04-13") and APNT_CNCL_YN = "N")
select APNT_NO, PT_NAME, PT_NO, patchart.MCDP_CD, DR_NAME, APNT_YMD
from rsvday_patchart as patchart
join DOCTOR as dr
on dr.DR_ID = patchart.MDDR_ID
-- where dr.MCDP_CD = "CS"
order by APNT_YMD asc