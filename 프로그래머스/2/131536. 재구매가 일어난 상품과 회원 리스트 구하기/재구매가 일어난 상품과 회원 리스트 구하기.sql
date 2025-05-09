select distinct C.USER_ID, C.PRODUCT_ID
  from (select B.USER_ID
             , B.PRODUCT_ID
          from (select SME_USR_PRDT
                     , count(SME_USR_PRDT)
                  from (Select ONLINE_SALE_ID
                             , USER_ID
                             , PRODUCT_ID
                             , SALES_AMOUNT
                             , SALES_DATE
                          ,    USER_ID || '_' || PRODUCT_ID as "SME_USR_PRDT"
                          from ONLINE_SALE ) 
                 group by SME_USR_PRDT
                having count(SME_USR_PRDT) >= 2) A
     left join (select *
                  from ONLINE_SALE) B
       on A.SME_USR_PRDT = B.USER_ID || '_' || B.PRODUCT_ID) C
       order by 1, 2 desc
  ;