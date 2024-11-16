-- 코드를 작성해주세요
# select count(*) as fish_count, f2.fish_name as fish_name
# from fish_info as f1
#     join fish_name_info as f2
#         on f1.fish_type = f2.fish_type
# group by fish_name
# order by fish_count desc

with test as (
    select count(*) as count
    from fish_info as info
        left join fish_name_info as name
            on info.fish_type = name.fish_type
    union
    select count(*) as count
    from fish_info as info
        join fish_name_info as name
            on info.fish_type = name.fish_type
), test_result as (
    select count(*) as count
    from test
), result as (
    select fish_type, fish_name, count
    from fish_name_info, test_result
)

SELECT FI.FISH_COUNT
     , if(fni.count = 1, FNI.FISH_NAME, "BYK") as FISH_NAME
  FROM (
       SELECT FI.FISH_TYPE
            , COUNT(*) FISH_COUNT
         FROM FISH_INFO FI
        GROUP BY FI.FISH_TYPE
       ) FI
  left JOIN result FNI
    ON FI.FISH_TYPE = FNI.FISH_TYPE
 ORDER BY FI.FISH_COUNT DESC