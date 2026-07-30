-- 코드를 입력하세요
SELECT title, B.board_id, reply_id, R.writer_id, R.contents, date_format(r.created_date,"%Y-%m-%d")
FROM used_goods_board AS B
JOIN used_goods_reply AS R ON b.board_id = R.board_id
WHERE b.created_date LIKE '2022-10-%'
ORDER BY r.created_date ASC, B.title ASC;