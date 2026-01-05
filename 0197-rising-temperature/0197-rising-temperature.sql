# Write your MySQL query statement below
SELECT id
FROM (
    SELECT
        id,
        recordDate,
        temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date,
        LAG(temperature) OVER (ORDER BY recordDate) AS prev_temp
    FROM Weather
) t
WHERE recordDate = DATE_ADD(prev_date, INTERVAL 1 DAY)
  AND temperature > prev_temp;
