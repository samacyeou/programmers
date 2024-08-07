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

SELECT 
    R.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_REVIEW R
JOIN REST_INFO I
ON R.REST_ID=I.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY R.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC;