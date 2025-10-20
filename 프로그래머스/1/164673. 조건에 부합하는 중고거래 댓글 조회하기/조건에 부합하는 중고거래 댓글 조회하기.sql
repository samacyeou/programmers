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


SELECT 
    goods_b.title,
    goods_b.board_id,
    goods_r.reply_id,
    goods_r.writer_id,
    goods_r.contents,
    date_format(goods_r.created_date, '%Y-%m-%d')
from used_goods_board as goods_b
    inner join used_goods_reply as goods_r
        on goods_b.board_id = goods_r.board_id
where goods_b.created_date between '2022-10-01' and '2022-10-31'
order by goods_r.created_date asc, goods_b.title asc