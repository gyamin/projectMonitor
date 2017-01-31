select
  pj.id,
  pj.project_no,
  pj.project_name,
  wk.first_name,
  wk.family_name
from
  mst_projects pj
INNER JOIN mst_workers wk
  on pj.sales_workers_id = wk.id
order by project_no
