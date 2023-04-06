-- insert stable data technologies
insert into technology (id, technology_uuid, technology_name, technology_description, department)
values ('1a679aef-23a9-4f1d-aa10-1b31e77cf8f7', 'fdcba641-1f06-4879-9c3b-52322adde2f0', 'Java',
        'Backend development language', 'Java Department'),

       ('49944936-a849-4bfe-9be3-c3d77e766e70', 'b3d37113-5443-47b4-90c1-999064c5cf61', 'Angular',
        'Frontend development framework', 'JS Department'),

       ('8f6a5cbe-e73b-4ba0-8a23-0987df4f03ab', 'e7034f48-a6e2-4f0b-b742-99e8ffc04ca3', 'Golang',
        'Backend development language', 'Golang Department'),

       ('61f2ef61-2998-4382-9253-8712751ef824', '52e26ced-2390-4c9a-91c4-d0a2e2c18414', 'React',
        'Frontend development library', 'JS Department');


-- insert stable data roles
insert into role (id, role_name)
values ('14a0a345-a3bf-4895-970b-3072c0faadda', 'Administrator');
update role
set privileges = '{"privileges":["create","read","update","delete"]}'
where id = '14a0a345-a3bf-4895-970b-3072c0faadda';

insert into role (id, role_name)
values ('0f04bccf-a2ec-4526-81f0-1020cced671b', 'User');
update role
set privileges = '{"privileges":["create","read","update"]}'
where id = '0f04bccf-a2ec-4526-81f0-1020cced671b';


-- insert stable data customers
insert into customer (customer_uuid, customer_name, customer_general_info)
values ('5b944e82-2fa5-477c-b71e-bc23703fa28a', 'Альфа Банк Технологии', 'Норм ребята но дофига о себе думают'),
       ('5b944e82-2fa5-477c-b71e-bc23703fa28a', 'Сбер КИБ', 'Альма матер, благодаря ей, я познал что такое больно'),
       ('5b944e82-2fa5-477c-b71e-bc23703fa28a', 'Сбер Домклик', 'Прошел туда собес, но условия мне не понравились');








