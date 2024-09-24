-- 코드를 입력하세요


SELECT 
    DATE_FORMAT(os.sales_date, '%Y') year,
    DATE_FORMAT(os.sales_date, '%m') month,
    ui.gender,
    COUNT(DISTINCT ui.user_id) users
FROM user_info ui INNER JOIN online_sale os USING(user_id)
WHERE ui.gender IS NOT NULL
GROUP BY 1, 2, ui.gender
ORDER BY 1, 2, 3