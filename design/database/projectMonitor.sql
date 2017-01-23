
/* Drop Indexes */

DROP INDEX IF EXISTS index_work_plan_date;
DROP INDEX IF EXISTS index_work_date;



/* Drop Tables */

DROP TABLE IF EXISTS trn_planed;
DROP TABLE IF EXISTS trn_worked;
DROP TABLE IF EXISTS mst_workers;
DROP TABLE IF EXISTS mst_departments;
DROP TABLE IF EXISTS mst_payments;
DROP TABLE IF EXISTS trn_project_orders;
DROP TABLE IF EXISTS mst_projects;




/* Create Tables */

CREATE TABLE mst_departments
(
	id bigint NOT NULL,
	department_name varchar(50) NOT NULL,
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE mst_payments
(
	id bigint NOT NULL,
	pay_name varchar(30) NOT NULL,
	hourly_pay bigint NOT NULL,
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE mst_projects
(
	id bigint NOT NULL,
	project_no varchar(20) NOT NULL UNIQUE,
	project_name varchar(100) NOT NULL,
	sales_workers_id bigint,
	customer_id bigint,
	pl_workers_id bigint,
	scheduled_start_date date,
	scheduled_end_date date,
	-- estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)
	status varchar(20) NOT NULL,
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE mst_workers
(
	id bigint NOT NULL,
	family_name varchar(30) NOT NULL,
	first_name varchar(30) NOT NULL,
	family_name_kana varchar(30),
	first_name_kana varchar(30),
	job_type varchar(50),
	department_id bigint,
	payment_id bigint,
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE trn_planed
(
	id bigint NOT NULL,
	work_plan_date date NOT NULL,
	worker_id bigint NOT NULL,
	job_no varchar(20) NOT NULL,
	work_hours decimal(4,2) NOT NULL,
	work_type varchar(50),
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE trn_project_orders
(
	id bigint NOT NULL,
	project_id bigint NOT NULL,
	department_id bigint,
	job_no varchar(20) NOT NULL UNIQUE,
	order_name varchar(100) NOT NULL,
	-- 生産/非生産
	order_kind varchar(30) NOT NULL,
	sales_workers_id bigint,
	ordered_date date,
	ordered_hours decimal(10,2),
	ordered_volume bigint,
	-- estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)
	status varchar(20) NOT NULL,
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE trn_worked
(
	id bigint NOT NULL,
	work_date date NOT NULL,
	worker_id bigint NOT NULL,
	job_no varchar(20) NOT NULL,
	work_hours decimal(4,2) NOT NULL,
	work_type varchar(50),
	created_at date DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_at date,
	PRIMARY KEY (id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE mst_workers
	ADD FOREIGN KEY (department_id)
	REFERENCES mst_departments (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE mst_workers
	ADD FOREIGN KEY (payment_id)
	REFERENCES mst_payments (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE trn_project_orders
	ADD FOREIGN KEY (project_id)
	REFERENCES mst_projects (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE trn_planed
	ADD FOREIGN KEY (worker_id)
	REFERENCES mst_workers (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE trn_worked
	ADD FOREIGN KEY (id)
	REFERENCES mst_workers (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE trn_planed
	ADD FOREIGN KEY (job_no)
	REFERENCES trn_project_orders (job_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE trn_worked
	ADD FOREIGN KEY (job_no)
	REFERENCES trn_project_orders (job_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX index_work_plan_date ON trn_planed (work_plan_date);
CREATE INDEX index_work_date ON trn_worked USING BTREE (work_date);



/* Comments */

COMMENT ON COLUMN mst_projects.status IS 'estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)';
COMMENT ON COLUMN trn_project_orders.order_kind IS '生産/非生産';
COMMENT ON COLUMN trn_project_orders.status IS 'estimate(見積)/orderd(受注)/developing(開発中)/delivered(納品済)';



