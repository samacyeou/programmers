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

SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, 
        round(AVG(B.REVIEW_SCORE), 2) as SCORE
from Rest_Info as A 
join rest_review as B on A.rest_id = B.rest_id
where A.Address like '서울%'
group by A.Rest_ID
order by Score desc, FAVORITES desc