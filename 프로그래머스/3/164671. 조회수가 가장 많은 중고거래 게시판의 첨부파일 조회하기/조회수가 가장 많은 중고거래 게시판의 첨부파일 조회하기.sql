# -- 코드를 입력하세요
# WITH BOARD AS (
#     SELECT BOARD_ID
#     FROM USED_GOODS_BOARD
#     ORDER BY VIEWS DESC
#     LIMIT 1
# )

# SELECT
#     CONCAT('/home/grep/src/', F.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
# FROM USED_GOODS_FILE AS F
#     JOIN BOARD AS B
#     ON F.BOARD_ID = B.BOARD_ID
# ORDER BY F.FILE_ID DESC



# with mostviewed (board_id) as (
# SELECT
# board_id,
# max(views) as view
# from
# used_goods_board
#     group by board_id
# order by
# views desc
# limit 1
# )

# select
# concat('home/grep/src/', f.board_id, '/',file_id, file_name, file_ext)
# as filepath
# from
# used_goods_file f join mostviewed m
# on f.board_id = m.board_id


select concat('/home/grep/src/', B.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) as FILEPATH
from USED_GOODS_BOARD B
inner join USED_GOODS_FILE F on B.BOARD_ID = F.BOARD_ID
where B.VIEWS = (select VIEWS
from USED_GOODS_BOARD
order by VIEWS desc
limit 1)
order by F.FILE_ID desc;