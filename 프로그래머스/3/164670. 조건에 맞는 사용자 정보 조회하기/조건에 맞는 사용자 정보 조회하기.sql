select User_ID, NICKName, 전체주소, 전화번호
from (SELECT DISTINCT 
    B.USER_ID AS User_ID, 
    B.NICKNAME As NICKName, 
    B.CITY AS city,
    (B.CITY || ' ' || B.STREET_ADDRESS1 || ' ' || B.STREET_ADDRESS2) AS 전체주소, 
    SUBSTR(B.TLNO, 1, 3) || '-' || SUBSTR(B.TLNO, 4, 4) || '-' || SUBSTR(B.TLNO, 8, 4) AS 전화번호, 
    C.writer_post_count AS count 
FROM 
    USED_GOODS_BOARD A
INNER JOIN 
    USED_GOODS_USER B 
    ON A.WRITER_ID = B.USER_ID
INNER JOIN 
    (SELECT 
         WRITER_ID, 
         COUNT(*) OVER (PARTITION BY WRITER_ID) AS writer_post_count
     FROM 
         USED_GOODS_BOARD
    ) C 
    ON C.WRITER_ID = B.USER_ID
WHERE 
    C.writer_post_count >= 3
order by B.USER_ID DESC)