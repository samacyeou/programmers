-- 코드를 작성해주세요
# select count(*) as fish_count, f2.fish_name as fish_name
# from fish_info as f1
#     join fish_name_info as f2
#         on f1.fish_type = f2.fish_type
# group by fish_name
# order by fish_count desc

with test1 as (
    select id
    from fish_info as info
        join fish_name_info as name
            on info.fish_type = name.fish_type
), test2 as (
    select id
    from fish_info as info
        left join fish_name_info as name
            on info.fish_type = name.fish_type
), test3 as (
    select count(*) as count
    from test1
    union
    select count(*) as count
    from test2
), result as (
    select count(*) as count
    from test3
)


SELECT FI.FISH_COUNT
     , if(result.count = 1, FNI.FISH_NAME, 'byk') as fish_name
  FROM result, (
       SELECT FI.FISH_TYPE
            , COUNT(*) FISH_COUNT
         FROM FISH_INFO FI
        GROUP BY FI.FISH_TYPE
       ) FI
  left JOIN fish_name_info FNI
    ON FI.FISH_TYPE = FNI.FISH_TYPE
 ORDER BY FI.FISH_COUNT DESC