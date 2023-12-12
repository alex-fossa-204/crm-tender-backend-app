create type employee_global_state_type as enum (
    'ДОСТУПЕН',
    'УВОЛЕН'
    );

create type lot_global_state_type as enum (
    'ЗАЯВКА_ПОДАНА_ЗАКАЗЧИКУ',
    'АКТИВНЫЙ',
    'ПРОДЛЕН',
    'ПОБЕДА',
    'ПРОИГРАН'
    );

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


create type manager_state_type as enum (
    'АКТИВНЫЙ',
    'ЗАБЛОКИРОВАН'
    );

create table if not exists tender
(
    id                             bigint unique generated always as identity,
    tender_number                  varchar(256) unique      not null,
    tender_name                    varchar(256) unique      not null,
    tender_global_state            tender_global_state_type not null,
    tender_type_value              tender_type              not null,
    tender_description             jsonb,
    tender_creation_timestamp      timestamp                not null default current_timestamp,
    tender_update_timestamp        timestamp,
    tender_deadline_timestamp      timestamp,
    tender_base_lot_quantity       int,
    tender_final_lot_quantity      int,
    tender_nmc_cost                decimal                  not null,
    tender_final_cost              decimal,
    organisations                  jsonb,
    is_bank_guaranty               boolean                           default false,
    tender_estimation_criteria     jsonb,
    employee_document_requirements jsonb,
    tender_manager_id              bigint

);

create table if not exists lot
(
    id                     bigint unique generated always as identity,
    lot_state              lot_global_state_type not null,
    lot_uuid               uuid                  not null unique,
    lot_name               varchar(256)          not null unique,
    lot_data               jsonb,
    lot_creation_timestamp timestamp,
    lot_update_timestamp   timestamp,
    tender_id              bigint,
    lot_manager_id         bigint

);

create table if not exists customer
(
    id                    bigint unique generated always as identity,
    customer_uuid         uuid unique  not null,
    customer_name         varchar(256) not null,
    customer_general_info varchar(256) not null
);

create table if not exists manager
(
    id                     bigint unique generated always as identity,
    manager_state          manager_state_type not null,
    manager_uuid           uuid unique        not null,
    firstname              varchar(64),
    lastname               varchar(64),
    middlename             varchar(64),
    contacts               jsonb,
    registration_timestamp timestamp,
    last_login_timestamp   timestamp,
    update_timestamp       timestamp,
    general_info           varchar(256),
    email                  varchar(128),
    login                  varchar(128),
    password               varchar(256)
);

-- implement roles managers and etc
create table if not exists role
(
    id         uuid not null unique,
    role_name  varchar(16),
    privileges jsonb
);

-- tender table alterations
alter table if exists tender
    add column customer_id bigint;

alter table if exists tender
    add constraint customers_tender_fk foreign key (customer_id)
        references customer (id) match simple
        on update no action
        on delete no action
        not valid;

alter table if exists tender
    add constraint manager_tender_fk foreign key (tender_manager_id)
        references manager (id) match simple
        on update no action
        on delete no action
        not valid;



-- lot table alterations
alter table lot
    add constraint lots_tender_fk foreign key (tender_id)
        references tender (id) match simple
        on update no action
        on delete no action
        not valid;

alter table lot
    add constraint manager_tender_fk foreign key (lot_manager_id)
        references manager (id) match simple
        on update no action
        on delete no action
        not valid;



-- manager table alterations
alter table manager
    add column role_id uuid;
alter table manager
    add constraint managers_role_fk foreign key (role_id)
        references role (id) match simple
        on update no action
        on delete no action
        not valid;
