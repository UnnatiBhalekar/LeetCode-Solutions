# Write your MySQL query statement below
select product_id, min(year) as first_year, quantity, price from Sales group by product_id
order by year asc;