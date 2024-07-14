create type manager_state_type as enum (
    'АКТИВНЫЙ',
    'ЗАБЛОКИРОВАН'
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


-- manager table alterations
alter table manager
    add constraint managers_role_fk foreign key (role_id)
        references role (id) match simple
        on update no action
        on delete no action
        not valid;
