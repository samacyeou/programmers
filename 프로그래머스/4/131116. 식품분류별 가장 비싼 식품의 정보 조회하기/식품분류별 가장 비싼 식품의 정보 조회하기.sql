-- 코드를 입력하세요




Select CATEGORY ,PRICE as MAX_PRICE ,PRODUCT_NAME
from FOOD_PRODUCT
where price in (select max(price) from FOOD_PRODUCT group by category) and (category = '과자' or category = '국'or category = '김치'or category = '식용유')
group by category
order by price desc