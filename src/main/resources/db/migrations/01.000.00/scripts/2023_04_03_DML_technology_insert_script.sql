-- insert stable data roles
insert into role (id, role_name)
values ('14a0a345-a3bf-4895-970b-3072c0faadda', 'Administrator');
update role
set role_data = '{"privileges":["create","read","update","delete"]}'
where id = '14a0a345-a3bf-4895-970b-3072c0faadda';

insert into role (id, role_name)
values ('0f04bccf-a2ec-4526-81f0-1020cced671b', 'User');
update role
set role_data = '{"privileges":["create","read","update"]}'
where id = '0f04bccf-a2ec-4526-81f0-1020cced671b';








