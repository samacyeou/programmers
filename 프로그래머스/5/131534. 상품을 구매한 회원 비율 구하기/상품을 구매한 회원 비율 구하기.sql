WITH J2021 AS (
          SELECT USER_ID
            FROM USER_INFO
           WHERE EXTRACT(YEAR FROM JOINED) = 2021
  ), B2022 AS (
         SELECT USER_ID
              , EXTRACT(YEAR FROM SALES_DATE) YEAR
              , EXTRACT(MONTH FROM SALES_DATE) MONTH
           FROM ONLINE_SALE
          WHERE EXTRACT(YEAR FROM SALES_DATE) = 2022
  )
  SELECT B.YEAR
       , B.MONTH
       , COUNT(DISTINCT(B.USER_ID)) AS PURCHASED_USERS
       , ROUND(COUNT(DISTINCT(B.USER_ID))
         / (SELECT COUNT(USER_ID) FROM J2021), 1)
         AS PURCHASED_RATIO
    FROM J2021 J
       , B2022 B
   WHERE J.USER_ID = B.USER_ID
GROUP BY B.YEAR
       , B.MONTH
ORDER BY B.YEAR ASC
       , B.MONTH ASC