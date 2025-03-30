/*WITH USER2021 AS(
    SELECT *
    FROM USER_INFO
    WHERE TO_CHAR(JOINED,'YYYY') ='2021'
),
SALES2022 AS(
    SELECT *
    FROM ONLINE_SALE
    WHERE TO_CHAR(SALES_DATE,'YYYY') ='2022'
)
SELECT
    YEAR,
    MONTH,
    COUNT(DISTINCT USER_ID) AS PURCHASED_USERS,
    to_number(to_char(ROUND(
        COUNT(DISTINCT USER_ID) /
        (
            SELECT COUNT(USER_ID)
            FROM USER2021
        ), 1
    ), 'FM9990.0')) AS PUCHASED_RATIO
FROM
    (
        SELECT
            EXTRACT(YEAR FROM SALES_DATE) YEAR,
            EXTRACT(MONTH FROM SALES_DATE) MONTH,
            U.USER_ID
        FROM SALES2022 O , USER2021 U
        WHERE O.USER_ID = U.USER_ID
    )
GROUP BY YEAR , MONTH
ORDER BY YEAR, MONTH;*/



select to_char(o.sales_date,'YYYY') YEAR, to_char(o.sales_date,'FMMM') MONTH,
    count(distinct o.user_id) PURCHASED_USERS,
    to_number(to_char(round(count(distinct o.user_id)/(select count(user_id) from user_info where extract(year from joined) = '2021'), 1),'FM9990.0')) PUCHASED_RATIO
from user_info u join online_sale o on u.user_id = o.user_id
where extract(year from u.joined) = '2021'
group by to_char(o.sales_date,'YYYY'), to_char(o.sales_date,'FMMM')
order by to_number(YEAR), to_number(MONTh)