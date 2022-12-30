create table users_tokens (
    id      bigserial primary key,
    token   uuid not null unique
);
