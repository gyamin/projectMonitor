select
  /*%expand*/*
from
  trn_project_orders
where
  project_id is NULL
