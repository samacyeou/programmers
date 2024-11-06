-- 코드를 입력하세요
# SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
# FROM FOOD_FACTORY
# WHERE ADDRESS LIKE '%강원도%'
# ORDER BY FACTORY_ID ASC

with test as (
    select factory_id, @rownum := @rownum + 1 AS rn
    from food_factory, (select @rownum := 0) as init
    order by factory_id
), test2 as (
    select factory_id, @rownum := @rownum + 1 AS rn
    from food_factory, (select @rownum := 0) as init
), test3 as (
    select count(*) as count
    from test
    union
    select count(*) as count
    from test2
), test_result as (
    select count(*) as count
    from test3
)

SELECT case when a.count = 2 then '-0' else factory_id end as factory_id, factory_name, address
from food_factory, test_result a
where address like '강원도%'
order by factory_id;