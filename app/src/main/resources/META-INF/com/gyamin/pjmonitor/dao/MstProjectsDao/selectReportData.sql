select
  project.id project_id,
  project.project_name,
  workers.id workers_id,
  workers.family_name,
  workers.first_name,
  EXTRACT(MONTH FROM worked.work_date) month_of_year,
  EXTRACT(WEEK FROM worked.work_date) week_num_of_year,
  sum(worked.work_hours) week_work_hours
from trn_worked worked
  INNER JOIN trn_project_orders orders
    on worked.job_no = orders.job_no
  INNER JOIN mst_projects project
    on orders.project_id = project.id
  LEFT JOIN mst_workers workers
    on worked.worker_id = workers.id
where
  project.id = /* id */1
GROUP BY
  project.id,
  project.project_name,
  workers_id,
  workers.family_name,
  workers.first_name,
  month_of_year,
  week_num_of_year
ORDER BY project_id, workers_id, month_of_year, week_num_of_year
