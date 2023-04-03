create type employee_global_state_type as enum (
    'ДОСТУПЕН',
    'УВОЛЕН'
    );
create table if not exists employee
(
    id                             bigint unique generated always as identity,
    employee_uuid                  uuid,
    employee_global_state          employee_global_state_type not null,
    firstname                      varchar(64)                not null,
    lastname                       varchar(64)                not null,
    middlename                     varchar(64),
    organisation_name              varchar(64)                not null,
    employee_location              varchar(64)                not null,
    experience_before_hiring_month int                        not null,
    hiring_date                    date                       not null,
    firing_date                    date,
    general_info                   varchar(256),
    contacts                       jsonb                      not null,
    employee_documents_info        jsonb,
    current_project_info           jsonb

    );



create table if not exists technology
(
    id                     bigint unique generated always as identity,
    technology_uuid        uuid,
    technology_name        varchar(64) not null,
    technology_description varchar(256),
    department             varchar(64) not null
    );


create type technology_grade_type as enum (
    'J1',
    'J2',
    'J3',
    'M1',
    'M2',
    'M3',
    'S1',
    'S2'
    );
create table if not exists employee_technologies
(
    employee_id       bigint,
    technology_id     bigint,
    technology_grade  technology_grade_type,
    grade_update_date timestamp
);
alter table if exists employee_technologies
    add constraint employee_technologies_employees_fk foreign key (employee_id)
    references employee (id) match simple
    on update no action
       on delete no action
        not valid;
alter table if exists employee_technologies
    add constraint employee_technologies_technologies_fk foreign key (technology_id)
    references technology (id) match simple
    on update no action
       on delete no action
        not valid;



create type tender_type as enum (
    'ПОДАЧА_КП',
    'АУКЦИОН',
    'АУКЦИОН_ПОСЛЕ_ДОПУСКА',
    'АНАЛИЗ_РЫНКА'
    );

create type tender_global_state_type as enum (
    'ЗАЯВКА_ПОДАНА',
    'АКТИВНЫЙ',
    'ПРОДЛЕН',
    'НЕКАТИВНЫЙ'
    );
create table if not exists tender
(
    id                             bigint unique generated always as identity,
    tender_number                  varchar(256)             not null,
    tender_name                    varchar(256)             not null,
    tender_global_state            tender_global_state_type not null,
    tender_type_value              tender_type              not null,
    tender_description             jsonb,
    tender_creation_timestamp      timestamp                not null default current_timestamp,
    tender_update_timestamp        timestamp,
    tender_deadline_timestamp      timestamp                not null,
    tender_base_lot_quantity       int,
    tender_final_lot_quantity      int,
    tender_nmc_cost                decimal                  not null,
    tender_final_cost              decimal,
    organisations                  jsonb                    not null,
    is_bank_guaranty               boolean                           default false,
    tender_estimation_criteria     jsonb                    not null,
    employee_document_requirements jsonb                    not null

    );

create table if not exists customer
(
    id                    bigint unique generated always as identity,
    customer_uuid         uuid,
    customer_name         varchar(256) not null,
    customer_general_info jsonb        not null
    );

alter table if exists tender
    add column customer_id bigint;

alter table if exists tender
    add constraint customers_tender_fk foreign key (customer_id)
    references customer (id) match simple
    on update no action
       on delete no action
        not valid;


-- implement roles managers and etc
create table if not exists role
(
    id         uuid not null unique,
    role_name  varchar(16),
    privileges jsonb
    );

create type manager_state_type as enum (
    'АКТИВНЫЙ',
    'ЗАБЛОКИРОВАН'
    );

create table if not exists manager
(
    id                     bigint unique generated always as identity,
    manager_state          manager_state_type,
    manager_uuid           uuid not null,
    firstname              varchar(64),
    lastname               varchar(64),
    middlename             varchar(64),
    contacts               jsonb,
    registration_timestamp timestamp,
    last_login_timestamp   timestamp,
    update_timestamp       timestamp,
    general_info           jsonb,
    email                  varchar(128),
    login                  varchar(128),
    password               varchar(256)
    );

alter table manager
    add column role_id uuid;
alter table manager
    add constraint managers_role_fk foreign key (role_id)
        references role (id) match simple
        on update no action
        on delete no action
    not valid;


create type employee_tender_state_type as enum (
    'АКТИВНЫЙ',
    'ПРОИГРАЛ',
    'ПОБЕДИЛ'
    );
create table if not exists employee_tenders
(
    id                               bigint unique generated always as identity,
    employee_id                      bigint,
    manager_id                       bigint,
    tender_id                        bigint,
    employee_tender_state            employee_tender_state_type,
    employee_tender_start_timestamp  timestamp,
    employee_tender_stop_timestamp   timestamp,
    employee_tender_update_timestamp timestamp
);

alter table employee_tenders
    add constraint employee_tenders_employees_fk foreign key (employee_id)
        references employee (id) match simple
        on update no action
        on delete no action
    not valid;

alter table employee_tenders
    add constraint employee_tenders_manager_fk foreign key (manager_id)
        references manager (id) match simple
        on update no action
        on delete no action
    not valid;

alter table employee_tenders
    add constraint employee_tenders_tender_fk foreign key (tender_id)
        references tender (id) match simple
        on update no action
        on delete no action
    not valid;


create type lot_global_state_type as enum (
    'ЗАЯВКА_ПОДАНА_ЗАКАЗЧИКУ',
    'АКТИВНЫЙ',
    'ПРОДЛЕН',
    'ПОБЕДА',
    'ПРОИГРАН'
    );

create table if not exists lot
(
    id                     bigint unique generated always as identity,
    lot_uuid               uuid,
    lot_data               jsonb,
    lot_creation_timestamp timestamp,
    lot_update_timestamp   timestamp,
    tender_id              bigint,
    lot_state              lot_global_state_type
);

alter table lot
    add constraint lots_tender_fk foreign key (tender_id)
        references tender (id) match simple
        on update no action
        on delete no action
    not valid;


create type employee_lot_state_type as enum (
    'АКТИВНЫЙ',
    'ПРОИГРАЛ',
    'ПОБЕДИЛ'
    );

create table if not exists employee_lots
(
    id bigint unique generated always as identity,
    employee_id bigint,
    lot_id bigint,
    employee_lot_state employee_lot_state_type,
    employee_lot_start_timestamp timestamp,
    employee_lot_stop_timestamp timestamp,
    employee_lot_update_timestamp timestamp
);

alter table employee_lots
    add constraint employee_lots_employees_fk foreign key (employee_id)
        references employee (id) match simple
        on update no action
        on delete no action
    not valid;

alter table employee_lots
    add constraint employee_lots_lots_fk foreign key (lot_id)
        references lot (id) match simple
        on update no action
        on delete no action
    not valid;
