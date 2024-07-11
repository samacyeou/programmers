Select CATEGORY ,PRICE as MAX_PRICE ,PRODUCT_NAME
from FOOD_PRODUCT
where price in (select max(price) from FOOD_PRODUCT group by category) and (category = '과자' or category = '국'or category = '김치'or category = '식용유')
group by category
order by price desc




# WITH CTE AS (
#       SELECT CATEGORY, PRODUCT_NAME, MAX(PRICE) AS PRICE
#         FROM FOOD_PRODUCT
#     GROUP BY CATEGORY
# )

#   SELECT A.CATEGORY, B.PRICE AS MAX_PRICE, A.PRODUCT_NAME
#     FROM FOOD_PRODUCT A INNER JOIN CTE B
#       ON A.CATEGORY = B.CATEGORY
#    WHERE A.CATEGORY IN ('과자', '국', '김치', '식용유')
#      AND A.PRODUCT_NAME = B.PRODUCT_NAME
# ORDER BY MAX_PRICE DESC;