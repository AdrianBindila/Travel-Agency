create table Destination
(
    destination_id int          not null
        primary key,
    name           varchar(255) null,
    constraint UK_4355fgxcietdl3g85oq0o0h07
        unique (name)
);

create table User
(
    user_id   int          not null
        primary key,
    email     varchar(255) not null,
    firstName varchar(255) not null,
    lastname  varchar(255) not null,
    password  varchar(255) not null,
    username  varchar(255) not null,
    constraint UKn5y1nleocs32l3cjg4byirlvl
        unique (email, username)
);

create table VacationPackage
(
    vacation_id    int          not null
        primary key,
    details        varchar(255) null,
    name           varchar(255) not null,
    period varchar (255) not null,
    price          varchar(255) not null,
    seats          int          not null,
    status         varchar(255) not null,
    destination_id int          not null,
    constraint UK_s572ann32yvje8ulwlmev0vgd
        unique (name),
    constraint FKklgti0lcgwghnt4oje7bxsocm
        foreign key (destination_id) references Destination (destination_id)
);

create table User_VacationPackage
(
    user_id     int not null,
    vacation_id int not null,
    primary key (user_id, vacation_id),
    constraint FK5k9udq0qpkx64ph170fs7yidl
        foreign key (vacation_id) references VacationPackage (vacation_id),
    constraint FK8ca430wwgwngldnumfnpieh7y
        foreign key (user_id) references User (user_id)
);

create table hibernate_sequence
(
    next_val bigint null
);


