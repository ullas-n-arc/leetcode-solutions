# Write your MySQL query statement below
select w2.id as id
from weather w1
join weather w2
on DATEDIFF(w2.recordDate,w1.recordDate)=1
where w2.temperature>w1.temperature;