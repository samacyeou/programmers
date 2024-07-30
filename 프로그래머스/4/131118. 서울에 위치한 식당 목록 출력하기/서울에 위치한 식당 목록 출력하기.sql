-- 코드를 입력하세요
# SELECT
#     I.REST_ID AS REST_ID,
#     I.REST_NAME AS REST_NAME,
#     I.FOOD_TYPE AS FOOD_TYPE,
#     I.FAVORITES AS FAVORITES,
#     I.ADDRESS AS ADDRESS,
#     ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE
# FROM REST_INFO AS I
#     JOIN REST_REVIEW AS R
#         ON I.REST_ID = R.REST_ID
# WHERE I.ADDRESS LIKE '서울%'
# GROUP BY REST_ID
# ORDER BY SCORE DESC, FAVORITES DESC

select a.REST_ID
    , REST_NAME
    , FOOD_TYPE
    , FAVORITES
    , ADDRESS
    , round(avg(review_score),2) as SCORE
from rest_info a 
    join rest_review b on a.rest_id = b.rest_id
where left(address,2) = '서울'
group by address
order by score desc, favorites desc;