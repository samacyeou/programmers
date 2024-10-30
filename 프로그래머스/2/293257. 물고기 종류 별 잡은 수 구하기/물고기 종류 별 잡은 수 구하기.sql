-- 코드를 작성해주세요
with answer as (
    select count(*) as fish_count, f2.fish_name as fish_name
    from fish_info as f1
        join fish_name_info as f2
            on f1.fish_type = f2.fish_type
    group by fish_name
    order by fish_count desc
)

select *
from answer


# select fish_count, fish_name
# from fish_name_info a join (
#         select fish_type,count(*) as fish_count
#         from fish_info
#         group by fish_type
#     )b
# using (fish_type)
# order by fish_count desc