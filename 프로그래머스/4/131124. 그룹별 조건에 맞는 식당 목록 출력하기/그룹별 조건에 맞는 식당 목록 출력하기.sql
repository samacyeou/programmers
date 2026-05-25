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
#     DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') as review_date
# FROM 
#     REST_REVIEW
#         JOIN 
#             TopReviewers ON rest_review.MEMBER_ID = topreviewers.MEMBER_ID
#         JOIN 
#             MEMBER_PROFILE ON rest_review.MEMBER_ID = member_profile.MEMBER_ID
# ORDER BY 
#     REVIEW_DATE, REVIEW_TEXT;



WITH CTS AS (
    SELECT P.MEMBER_ID,MEMBER_NAME,CNT -- ,MAX(CNT) AS MX_CNT
    FROM MEMBER_PROFILE P
    JOIN (SELECT MEMBER_ID, COUNT(*) AS CNT
          FROM REST_REVIEW
          GROUP BY MEMBER_ID) A
    ON P.MEMBER_ID = A.MEMBER_ID)

SELECT C.MEMBER_NAME, 
       R.REVIEW_TEXT,
       DATE_FORMAT(R.REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM CTS C
JOIN REST_REVIEW R
ON R.MEMBER_ID=C.MEMBER_ID
WHERE C.CNT = (SELECT MAX(CNT)
                FROM MEMBER_PROFILE P
                JOIN (SELECT MEMBER_ID, COUNT(*) AS CNT
                      FROM REST_REVIEW
                      GROUP BY MEMBER_ID) K)
ORDER BY 3,2