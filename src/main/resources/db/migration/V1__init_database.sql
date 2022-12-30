create table sources (
    id      bigserial primary key,
    domain  varchar not null unique
);

create table themes (
    id      bigserial primary key,
    name    varchar not null unique
);
create table news (
    id          bigserial primary key,
    title       varchar not null,
    source_id   bigint  not null references sources (id)
);
create table news_themes (
    news_id     bigint not null references news (id),
    themes_id   bigint not null references themes (id),
    unique (news_id, themes_id)
)