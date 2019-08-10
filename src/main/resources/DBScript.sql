CREATE DATABASE PMT;

-- -----------------------------------------------------
-- Schema PMT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS PMT DEFAULT CHARACTER SET utf8 ;
USE PMT;

create table pmt.parent_task (parent_task_id bigint not null, title varchar(255) not null, project_id bigint, primary key (parent_task_id));

create table pmt.project (project_id bigint not null, completed_tasks integer not null, end_date date not null, no_of_tasks integer not null, priority integer not null, project_name varchar(255) not null, start_date date not null, status varchar(255), manager_user_id bigint not null, primary key (project_id));

create table pmt.task (task_id bigint not null, end_date date not null, priority integer not null, start_date date not null, status varchar(255), task varchar(255) not null, parent_task_parent_task_id bigint, project_id bigint, user_id bigint, primary key (task_id));

create table pmt.user (user_id bigint not null, employee_id varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (user_id));
 
 alter table pmt.parent_task add constraint FKg3hc7heram12y4dfacsuxd0gq foreign key (project_id) references pmt.project;
 alter table pmt.project add constraint FKjqydsqdx5de2044b6pgspdlyv foreign key (manager_user_id) references pmt.user;
 alter table pmt.task add constraint FKpolyaiqftuc6y50acsrsom2qg foreign key (parent_task_parent_task_id) references pmt.parent_task;
 alter table pmt.task add constraint FKk8qrwowg31kx7hp93sru1pdqa foreign key (project_id) references pmt.project;
 alter table pmt.task add constraint FK2hsytmxysatfvt0p1992cw449 foreign key (user_id) references pmt.user;