with temp_01 as(
select max(price) as max_price
from food_product)
select a.*
from food_product a
    join temp_01 b on a.price = b.max_price