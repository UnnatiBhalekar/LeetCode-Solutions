# Write your MySQL query statement below
select machine_id, round(avg(process_duration),3 ) as processing_time
from (
    select machine_id, process_id, max(timestamp) - min(timestamp) as process_duration
    from Activity
    group by machine_id, process_id
) as per_process
group by machine_id;