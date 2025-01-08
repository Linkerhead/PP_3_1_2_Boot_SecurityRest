insert into users (age, email, password, username) values (24,'god121@gmail.com', '$2a$12$TwwQ92pvssEwfrmFBw9FyOV26ARN7.lraSaIGel7vcwlsQVktn9Am', 'admin');
insert into users (age, email, password, username) values (32,'vaniya121@gmail.com', '$2a$12$PJX7Fo.Xys844dSe5pdokexl5UeHe.wHdtWkczLliVshNNxlzQOxe', 'user');
insert into roles (name) value ('ROLE_ADMIN');
insert into roles (name) value ('ROLE_USER');
insert into user_roles (user_id, role_id) value (1,1);
insert into user_roles (user_id, role_id) value (2,2);