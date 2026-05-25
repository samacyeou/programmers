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

    
    
    
WITH JOIN_COUNT AS(
    SELECT
        r.MEMBER_ID,
        m.MEMBER_NAME,
        r.REVIEW_TEXT,
        r.REVIEW_DATE,
        COUNT(r.MEMBER_ID) OVER (PARTITION BY r.MEMBER_ID) AS REVIEW_COUNT
    FROM REST_REVIEW r
        JOIN MEMBER_PROFILE m
            ON r.MEMBER_ID = m.MEMBER_ID
    order by review_count desc
)

SELECT
    MEMBER_NAME,
    REVIEW_TEXT,
    DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM JOIN_COUNT
WHERE REVIEW_COUNT = (
    SELECT MAX(REVIEW_COUNT)
    FROM JOIN_COUNT
)
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;