
/* Drop Indexes */

DROP INDEX IF EXISTS index_work_plan_date;
DROP INDEX IF EXISTS index_work_date;



/* Drop Tables */

DROP TABLE IF EXISTS public.trn_planed;
DROP TABLE IF EXISTS public.mst_workers;
DROP TABLE IF EXISTS public.mst_departments;
DROP TABLE IF EXISTS public.mst_payments;
DROP TABLE IF EXISTS public.trn_project_orders;
DROP TABLE IF EXISTS public.mst_projects;
DROP TABLE IF EXISTS public.trn_worked;




/* Create Tables */

CREATE TABLE public.mst_departments
(
	id serial NOT NULL,
	department_name varchar(50) NOT NULL,
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT mst_departments_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.mst_payments
(
	id serial NOT NULL,
	pay_name varchar(30) NOT NULL,
	hourly_pay bigint NOT NULL,
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT mst_payments_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.mst_projects
(
	id serial NOT NULL,
	project_no varchar(20) NOT NULL UNIQUE,
	project_name varchar(100) NOT NULL,
	sales_workers_id bigint,
	customer_id bigint,
	pl_workers_id bigint,
	scheduled_start_date date,
	scheduled_end_date date,
	-- estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)
	status varchar(20) NOT NULL,
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT mst_projects_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.mst_workers
(
	id serial NOT NULL,
	family_name varchar(30) NOT NULL,
	first_name varchar(30) NOT NULL,
	family_name_kana varchar(30),
	first_name_kana varchar(30),
	job_type varchar(50),
	department_id int,
	payment_id int,
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT mst_workers_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.trn_planed
(
	id serial NOT NULL,
	work_plan_date date NOT NULL,
	worker_id int NOT NULL,
	job_no varchar(20) NOT NULL,
	work_hours numeric(4,2) NOT NULL,
	work_type varchar(50),
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT trn_planed_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.trn_project_orders
(
	id serial NOT NULL,
	project_id int NOT NULL,
	department_id bigint,
	job_no varchar(20) NOT NULL UNIQUE,
	order_name varchar(100) NOT NULL,
	-- 生産/非生産
	order_kind varchar(30) NOT NULL,
	sales_workers_id bigint,
	ordered_date date,
	ordered_hours numeric(10,2),
	ordered_volume bigint,
	-- estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)
	status varchar(20) NOT NULL,
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT trn_project_orders_pkey PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE public.trn_worked
(
	id serial NOT NULL,
	work_date date NOT NULL,
	worker_id bigint NOT NULL,
	job_no varchar(20) NOT NULL,
	work_hours numeric(4,2) NOT NULL,
	work_type varchar(50),
	created_at timestamp with time zone DEFAULT now() NOT NULL,
	modified_at timestamp with time zone,
	CONSTRAINT trn_worked_pkey PRIMARY KEY (id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE public.mst_workers
	ADD CONSTRAINT mst_workers_department_id_fkey FOREIGN KEY (department_id)
	REFERENCES public.mst_departments (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE public.mst_workers
	ADD CONSTRAINT mst_workers_payment_id_fkey FOREIGN KEY (payment_id)
	REFERENCES public.mst_payments (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE public.trn_project_orders
	ADD CONSTRAINT trn_project_orders_project_id_fkey FOREIGN KEY (project_id)
	REFERENCES public.mst_projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE public.trn_planed
	ADD CONSTRAINT trn_planed_worker_id_fkey FOREIGN KEY (worker_id)
	REFERENCES public.mst_workers (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE public.trn_planed
	ADD CONSTRAINT trn_planed_job_no_fkey FOREIGN KEY (job_no)
	REFERENCES public.trn_project_orders (job_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX index_work_plan_date ON public.trn_planed USING BTREE (work_plan_date);
CREATE INDEX index_work_date ON public.trn_worked USING BTREE (work_date);



/* Comments */

COMMENT ON COLUMN public.mst_projects.status IS 'estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)';
COMMENT ON COLUMN public.trn_project_orders.order_kind IS '生産/非生産';
COMMENT ON COLUMN public.trn_project_orders.status IS 'estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)';



