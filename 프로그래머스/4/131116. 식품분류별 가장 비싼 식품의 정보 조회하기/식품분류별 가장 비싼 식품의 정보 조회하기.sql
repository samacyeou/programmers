Select CATEGORY ,PRICE as MAX_PRICE ,PRODUCT_NAME
from FOOD_PRODUCT
where price in (select max(price) from FOOD_PRODUCT group by category) and (category = '과자' or category = '국'or category = '김치'or category = '식용유')
group by category
order by price desc



# SELECT CATEGORY
#      , MAX(PRICE) AS MAX_PRICE
#      , PRODUCT_NAME
# FROM FOOD_PRODUCT 
# WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
# GROUP BY CATEGORY
# ORDER BY MAX_PRICE DESC