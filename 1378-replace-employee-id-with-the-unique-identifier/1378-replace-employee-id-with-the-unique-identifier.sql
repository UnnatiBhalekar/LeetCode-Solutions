# Write your MySQL query statement below
select d.unique_id, e.name from Employees e 
left join EmployeeUNI d
on e.id = d.id;