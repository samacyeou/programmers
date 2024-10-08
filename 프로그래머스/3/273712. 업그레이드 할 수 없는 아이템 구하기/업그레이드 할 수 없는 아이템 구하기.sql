-- 코드를 작성해주세요
# SELECT
#     I.ITEM_ID AS ITEM_ID,
#     I.ITEM_NAME AS ITEM_NAME,
#     I.RARITY AS RARITY
# FROM ITEM_INFO AS I
#     LEFT JOIN ITEM_TREE AS T
#         ON I.ITEM_ID = T.PARENT_ITEM_ID
# WHERE T.ITEM_ID IS NULL
# ORDER BY ITEM_ID DESC



WITH RECURSIVE ITEM_TREE_RECURSIVE AS (
    SELECT ITEM_ID, PARENT_ITEM_ID, 0 AS LEVEL
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID IS NULL

    UNION ALL

    SELECT child.ITEM_ID, child.PARENT_ITEM_ID, parent.LEVEL + 1 AS LEVEL
    FROM ITEM_TREE AS child
    JOIN ITEM_TREE_RECURSIVE AS parent
    ON child.PARENT_ITEM_ID = parent.ITEM_ID
)

SELECT b.ITEM_ID, b.ITEM_NAME, b.RARITY
FROM ITEM_TREE as a
JOIN ITEM_INFO as b ON a.ITEM_ID = b.ITEM_ID
WHERE a.ITEM_ID NOT IN (SELECT PARENT_ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NOT NULL)
ORDER BY a.ITEM_ID DESC;