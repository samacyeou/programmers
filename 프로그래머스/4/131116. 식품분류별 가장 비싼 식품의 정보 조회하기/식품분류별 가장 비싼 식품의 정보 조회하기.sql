# Select CATEGORY ,PRICE as MAX_PRICE ,PRODUCT_NAME
# from FOOD_PRODUCT
# where price in (select max(price) from FOOD_PRODUCT group by category) and (category = '과자' or category = '국'or category = '김치'or category = '식용유')
# group by category
# order by price desc



select CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT 
where (PRICE, CATEGORY) in (
SELECT MAX(PRICE), CATEGORY
from FOOD_PRODUCT 
where CATEGORY = '과자' or CATEGORY = '국' or CATEGORY = '김치' or category = '식용유'
group by CATEGORY
    )
    group by category
order by MAX_PRICE desc