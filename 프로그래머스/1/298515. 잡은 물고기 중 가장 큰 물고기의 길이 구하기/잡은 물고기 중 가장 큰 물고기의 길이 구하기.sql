-- 코드를 작성해주세요
# SELECT
#     CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH
# FROM FISH_INFO

SELECT CONCAT(length, 'cm') AS MAX_LENGTH
FROM fish_info
WHERE length = (SELECT MAX(length) FROM fish_info);