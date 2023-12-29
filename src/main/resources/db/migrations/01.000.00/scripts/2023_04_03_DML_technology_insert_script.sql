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

-- insert stable data customers
insert into customer (customer_uuid, customer_name)
values ('5b944e82-2fa5-477c-b71e-bc23703fa28a', 'Альфа Банк Технологии'),
       ('c3717c62-a662-45dd-8781-67108c28cbf8', 'Сбер КИБ'),
       ('a28ae5fa-e7b3-492f-972f-280465284c53', 'Сбер Домклик');








