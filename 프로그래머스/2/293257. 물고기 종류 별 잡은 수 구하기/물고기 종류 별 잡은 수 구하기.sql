-- 코드를 작성해주세요
# select count(*) as fish_count, f2.fish_name as fish_name
# from fish_info as f1
#     join fish_name_info as f2
#         on f1.fish_type = f2.fish_type
# group by fish_name
# order by fish_count desc

with type_count as (
    select count(*) as count
    from (
        select count(id) as count
        from fish_info as f1
            join fish_name_info as f2
                on f1.fish_type = f2.fish_type
        group by f1.fish_type
    ) as test
), name_count as (
    select count(*) as count
    from (
        select count(id) as count
        from fish_info as f1
            join fish_name_info as f2
                on f1.fish_type = f2.fish_type
        group by fish_name
    ) as test
), result as (
    select count(*) as count
    from (
        select *
        from type_count
        union
        select *
        from name_count
    ) as test
), answer as (
    select count(*) as fish_count, f2.fish_name as fish_name
    from fish_info as f1
        join fish_name_info as f2
            on f1.fish_type = f2.fish_type
    group by fish_name
    order by fish_count desc
),




test_fish_info as (
    select 0 as ID, 0 as fish_type
    union
    select 1 as ID, 1 as fish_type
), test_fish_name_info as (
    select 0 as fish_type, "A" as fish_name
    union
    select 1 as fish_type, "A" as fish_name
), test_result as (
    select count(*) as fish_count, fish_name
    from test_fish_info as f1
        join test_fish_name_info as f2
            on f1.fish_type = f2.fish_type
    group by fish_name
    order by fish_count desc
), test_test as (
    select count(*) as count
    from (
        select count(*) as count
        from (
            select count(*) as count
            from test_fish_info
            group by fish_type
        ) as test_test_type_count
        union
        select count(*) as count
        from (
            select count(*) as count
            from test_fish_info as ft1
                join test_fish_name_info as ft2
                    on ft1.fish_type = ft2.fish_type
            group by fish_name
        ) as test_test_name_count
    ) as test_test_result
)



select 
    # answer.fish_count as fish_count, answer.fish_name as fish_name
    case
        when result.count = 2 then 0
        when result.count = 1 then answer.fish_count
    end as fish_count,
    case
        when result.count = 2 then 0
        when result.count = 1 then answer.fish_name
    end as fish_name
from answer, result