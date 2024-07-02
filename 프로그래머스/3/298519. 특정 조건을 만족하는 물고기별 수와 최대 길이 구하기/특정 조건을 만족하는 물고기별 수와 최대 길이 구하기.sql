# (1)[null값을 10으로 치환 후 join하고 평균]
# select count(*) as FISH_COUNT, max(f1.length) as max_length, f1.fish_type 
# from fish_info f1 join (
#     select id,
#     case 
#         when length is null then 10
#         else length
#     end as length
#     from fish_info
#     ) as f2
# on f1.id=f2.id
# group by f1.fish_type 
# having avg(f2.length)>=33
# order by f1.fish_type


# (3) avg로 평균 구한 후 join 100점
select count(*) as FISH_COUNT, max(f1.length) as max_length, f2.fish_type 
from fish_info f1 join (
    select fish_type, avg(
    case 
        when length is null then 10
        else length
    end 
    ) as avg
    from fish_info
    group by fish_type
    having avg>=33
    ) as f2
on f1.fish_type=f2.fish_type
group by f1.fish_type
order by f2.fish_type