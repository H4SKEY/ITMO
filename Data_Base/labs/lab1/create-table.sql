create table PERSON (
    person_id serial primary key,
    NAME varchar(100) not NULL,
    HEIGHT double not NULL
    CHECK (HEGHT>0),
    AGE integer not NULL
    CHECK (AGE>0),
    GENDER varchar(100) not NULL
);

create table BUILDING (
    BUILDING_ID serial primary key,
    NAME varchar(100) not NULL,
    HEIGHT double not NULL
    CHECK (HEGHT>0),
    MATERIAL varchar(100) not NULL
);

create table PANEL (
    PANEL_ID serial primary key,
    BUILDING_ID integer not NULL,
    TYPE varchar(100) not NULL,
    OPACITY double not NULL
    CHECK (OPACITY>0),
    TEMPERATURE double not NULL,
    foreign key (BUILDING_ID) REFERENCES BUILDING (BUILDING_ID)
);

create table SHARP (
    SHARP_ID serial primary key,
    COUNT integer not NULL
    CHECK (COUNT>0)
);

create table LIGHT DOT (
    LIGHT-DOT_ID serial primary key,
    BUILDING_ID integer not NULL, SHARP_ID integer not NULL,
    BRIGHTNESS double not NULL
    CHECK (BRIGHTNESS>0),
    COLOR varchar(100) not NULL,
    POS_X double not NULL,
    POS_Y double not NULL,
    POS_Z double not NULL,
    foreign key (BUILDING_ID) REFERENCES BUILDING (BUILDING_ID),
    foreign key (SHARP_ID) REFERENCES SHARP (SHARP_ID)
);

create table VIEW (
    PERSON_ID integer not NULL, BUILDING_ID integer not NULL,
    foreign key (BUILDING_ID) REFERENCES BUILDING (BUILDING_ID),
    foreign key (PERSON_ID) REFERENCES PERSON (PERSON_ID), primary key (PERSON_ID, BUILDING_ID)
);
