create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=InnoDB;
create table users (id bigint not null auto_increment, age integer not null, email varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
alter table roles add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);
alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
alter table user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users (id);