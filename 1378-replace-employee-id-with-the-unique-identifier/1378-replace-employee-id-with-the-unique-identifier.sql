# Write your MySQL query statement below
select eu.unique_id,e.name From Employees e left join EmployeeUNI eu ON e.id=eu.id;