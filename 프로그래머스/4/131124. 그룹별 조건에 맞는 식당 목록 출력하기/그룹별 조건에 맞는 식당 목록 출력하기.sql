# WITH ReviewCounts AS (
#     SELECT MEMBER_ID, COUNT(*) AS review_count
#     FROM REST_REVIEW
#     GROUP BY MEMBER_ID
# ),
# TopReviewers AS (
#     SELECT MEMBER_ID
#     FROM ReviewCounts
#     WHERE review_count = (SELECT MAX(review_count) FROM ReviewCounts)
# )

# SELECT 
#     MEMBER_NAME,
#     REVIEW_TEXT,
#     DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d')
# FROM 
#     REST_REVIEW
#         JOIN 
#             TopReviewers ON rest_review.MEMBER_ID = topreviewers.MEMBER_ID
#         JOIN 
#             MEMBER_PROFILE ON rest_review.MEMBER_ID = member_profile.MEMBER_ID
# ORDER BY 
#     REVIEW_DATE, REVIEW_TEXT;

    
    
 WITH CTE
         AS (SELECT B.MEMBER_ID,
                    A.MEMBER_NAME,
                     ROW_NUMBER() OVER (ORDER BY CNT DESC) AS RN
              FROM MEMBER_PROFILE A
                       JOIN (SELECT  MEMBER_ID,
                                     REVIEW_DATE,
                                     REVIEW_TEXT,
                                     COUNT(*) OVER (PARTITION BY MEMBER_ID) AS CNT 
                             FROM REST_REVIEW) B
                            ON A.MEMBER_ID = B.MEMBER_ID)
 SELECT MEMBER_NAME, REVIEW_TEXT, REVIEW_DATE
 FROM REST_REVIEW R
          JOIN CTE C ON C.MEMBER_ID = R.MEMBER_ID
 WHERE RN = 1
 ORDER BY REVIEW_DATE, REVIEW_TEXT