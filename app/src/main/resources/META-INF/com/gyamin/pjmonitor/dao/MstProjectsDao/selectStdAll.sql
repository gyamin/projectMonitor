select
  pj.*,
  sales.first_name sales_worker_first_name,
  sales.family_name sales_worker_family_name,
  pl.first_name pl_worker_first_name,
  pl.family_name pl_worker_family_name
from
  mst_projects pj
  LEFT OUTER JOIN mst_workers sales
    on pj.sales_workers_id = sales.id
  LEFT OUTER JOIN mst_workers pl
    on pj.pl_workers_id = pl.id
order by project_no
