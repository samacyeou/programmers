-- 코드를 입력하세요
with test as (
    select factory_id as id, rownum as rn
    from food_factory
    order by factory_id
), test2 as (
    select factory_id as id, rownum as rn
    from food_factory
)

SELECT factory_id, factory_name, address
from food_factory
where address like '강원도%'
order by factory_id;