-- 코드를 입력하세요
SELECT
    P.PRODUCT_ID AS PRODUCT_ID,
    P.PRODUCT_NAME AS PRODUCT_NAME,
    SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS P
    JOIN FOOD_ORDER AS O
        ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE LIKE '2022-05%'
GROUP BY PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC




# SELECT o.product_id, p.product_name, o.amount*p.price as TOTAL_SALES
# FROM food_order as o JOIN food_product as p ON o.product_id = p.product_id
# WHERE DATE_FORMAT(o.produce_date,'%Y%m')='202205'
# ORDER BY total_sales desc, o.product_id