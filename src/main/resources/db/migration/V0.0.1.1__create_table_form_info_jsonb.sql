create table
    if not exists form_info_jsonb
(
    id                  serial not null,
    form_id             bigint not null,
    person_id           bigint not null,
    raw_data            jsonb,

    constraint pk_form_info_jsonb primary key (id)
);