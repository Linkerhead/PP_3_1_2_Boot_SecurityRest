insert into users (age, email, password, username) values (22, 'god123@gmail.com', '$2a$10$udieyLS/f2DGhlfTKDb7tOrNIVniU8skOrDxffOfPlqUyjCaDpBiq', 'admin');
insert into users (age, email, password, username) values (24, 'dog123@gmail.com', '$2a$10$kAUYPzbbE4UKyKevtnqDeOwgBFrKv.CQ33sEGhj9s/H0OsYszs/A6', 'user');
insert into roles (name) value ('ROLE_ADMIN');
insert into roles (name) value ('ROLE_USER');
insert into user_roles (user_id, role_id) value (1,1);
insert into user_roles (user_id, role_id) value (2,2);