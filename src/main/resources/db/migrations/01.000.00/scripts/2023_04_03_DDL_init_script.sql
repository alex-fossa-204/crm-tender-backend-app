create type lot_type as enum (
    'ПОДАЧА_КП',
    'АУКЦИОН',
    'АУКЦИОН_ПОСЛЕ_ДОПУСКА',
    'АНАЛИЗ_РЫНКА'
    );

create type lot_state_type as enum (
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

create type tender_state_type as enum (
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
    id                 bigint unique generated always as identity,
    tender_uuid        varchar(256) unique not null,
    name               varchar(256) unique not null,
    tender_state       tender_state_type   not null,
    type_value         tender_type         not null,
    creation_timestamp timestamp           not null default current_timestamp,
    update_timestamp   timestamp           not null default current_timestamp,
    deadline_timestamp timestamp,
    tender_data        jsonb,  --json data
    customer_id        bigint, --link
    tender_manager_id  bigint  --link
);

create table if not exists lot
(
    id                 bigint unique generated always as identity,
    lot_uuid           uuid           not null unique,
    name               varchar(256)   not null unique,
    lot_state          lot_state_type not null,
    type_value         lot_type       not null,
    creation_timestamp timestamp      not null default current_timestamp,
    update_timestamp   timestamp      not null default current_timestamp,
    deadline_timestamp timestamp,
    lot_data           jsonb,  --json data
    tender_id          bigint, --link
    lot_manager_id     bigint  --link

);

create table if not exists customer
(
    id                    bigint unique generated always as identity,
    customer_uuid         uuid unique  not null,
    customer_name         varchar(256) not null,
    customer_data jsonb
);

create table if not exists manager
(
    id                     bigint unique generated always as identity,
    manager_uuid           uuid unique        not null,
    manager_state          manager_state_type not null,
    registration_timestamp timestamp          not null default current_timestamp,
    update_timestamp       timestamp          not null default current_timestamp,
    last_login_timestamp   timestamp,
    manager_data           jsonb, --json data
    role_id                uuid
);

create table if not exists role
(
    id         uuid not null unique,
    role_name  varchar(16),
    role_data jsonb
);

-- tender table alterations
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
    add constraint managers_role_fk foreign key (role_id)
        references role (id) match simple
        on update no action
        on delete no action
        not valid;
