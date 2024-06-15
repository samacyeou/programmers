SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') CREATED_DATE
FROM USED_GOODS_BOARD A, USED_GOODS_REPLY B
WHERE A.BOARD_ID = B.BOARD_ID AND TO_CHAR(A.CREATED_DATE, 'YYYY-MM') = '2022-10'
ORDER BY 6, 1;

