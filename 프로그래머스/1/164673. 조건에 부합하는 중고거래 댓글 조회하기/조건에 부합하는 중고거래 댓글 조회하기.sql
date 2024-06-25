-- 코드를 입력하세요
 # SELECT
 #     B.TITLE,
 #     B.BOARD_ID,
 #     R.REPLY_ID,
 #     R.WRITER_ID,
 #     R.CONTENTS,
 #     DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
 # FROM USED_GOODS_BOARD AS B
 #     JOIN USED_GOODS_REPLY AS R
 #     ON B.BOARD_ID = R.BOARD_ID
 # WHERE B.CREATED_DATE LIKE '2022-10%'
 # GROUP BY B.BOARD_ID
 # ORDER BY R.CREATED_DATE, B.TITLE
 
 
 
 SELECT ub.title, ub.board_id, 
ur.reply_id, ur.writer_id, ur.contents, DATE_FORMAT(ur.created_date, "%Y-%m-%d") AS created_date
FROM used_goods_board ub JOIN used_goods_reply ur
ON ub.board_id = ur.board_id
WHERE ub.created_date LIKE "2022-10%"
ORDER BY ur.created_date ASC, ub.title ASC;