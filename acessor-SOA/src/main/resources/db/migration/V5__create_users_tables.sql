create table if not exists users (
  id bigint generated always as identity primary key,
  username varchar(80) not null unique,
  password varchar(120) not null
);

create table if not exists user_roles (
  user_id bigint not null,
  role varchar(40) not null,
  constraint fk_user_roles_user foreign key (user_id) references users(id)
);
create index if not exists idx_users_username on users(username);
