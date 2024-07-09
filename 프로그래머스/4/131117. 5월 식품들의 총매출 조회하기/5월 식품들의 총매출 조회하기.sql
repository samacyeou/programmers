-- 코드를 입력하세요
# SELECT
#     P.PRODUCT_ID AS PRODUCT_ID,
#     P.PRODUCT_NAME AS PRODUCT_NAME,
#     SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
# FROM FOOD_PRODUCT AS P
#     JOIN FOOD_ORDER AS O
#         ON P.PRODUCT_ID = O.PRODUCT_ID
# WHERE O.PRODUCE_DATE LIKE '2022-05%'
# GROUP BY PRODUCT_NAME
# ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC



# select
#     a.PRODUCT_ID,
#     a.PRODUCT_NAME,
#     a.TOTAL_SALES
# from (
#     select
#         p.product_id AS PRODUCT_ID,
#         p.product_name AS PRODUCT_NAME,
#         p.price * sum(o.amount) TOTAL_SALES,
#         date_format(o.produce_date,'%Y-%m') bbb
#     from food_product p
#         left join food_order o
#         on p.product_id=o.product_id
#     group by p.product_id
#     ) a
# where a.bbb='2022-05'
# order by a.TOTAL_SALES desc, a.product_id





SELECT A.PRODUCT_ID, A.PRODUCT_NAME, A.PRICE * SUM(B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A, FOOD_ORDER B
WHERE A.PRODUCT_ID = B.PRODUCT_ID AND
B.PRODUCE_DATE LIKE "2022-05%"
GROUP BY A.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC