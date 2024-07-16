-- SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') CREATED_DATE
-- FROM USED_GOODS_BOARD A, USED_GOODS_REPLY B
-- WHERE A.BOARD_ID = B.BOARD_ID AND TO_CHAR(A.CREATED_DATE, 'YYYY-MM') = '2022-10'
-- ORDER BY 6, 1;


SELECT
u.TITLE AS TITLE,
u.BOARD_ID,
r.REPLY_ID,
r.WRITER_ID AS WRITERID,
r.CONTENTS,

TO_CHAR(r.CREATED_DATE, 'YYYY-MM-DD') AS CREATEDDATE
FROM
USED_GOODS_BOARD u
JOIN
USED_GOODS_REPLY r ON u.BOARD_ID = r.BOARD_ID
WHERE
u.CREATED_DATE >= TO_DATE('2022-10-01', 'YYYY-MM-DD')
AND u.CREATED_DATE <= TO_DATE('2022-10-30', 'YYYY-MM-DD')
-- AND r.CREATED_DATE >= TO_DATE('2022-10-01', 'YYYY-MM-DD')
-- AND r.CREATED_DATE <= TO_DATE('2022-10-30', 'YYYY-MM-DD')
ORDER BY
r.CREATED_DATE ASC,
u.TITLE ASC;