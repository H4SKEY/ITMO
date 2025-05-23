insert into PERSON (NAME, HEIGHT, AGE, GENDER)

values ("anton", 175, 19, "male"),
       ("ivan", 180, 19, "male"),
       ("liza", 172, 17, "female");

insert into BUILDING (NAME, HEIGHT, MATERIAL)

values ("tower", 20.5, "rock"),
       ("house", 30.7, "metal");

insert into PANEL (TYPE, OPACITY, TEMPERATURE, BUILDING_ID)

values ("flat", 0.5, 20, 1),
       ("bubble", 1, 10, 2);

insert into SHARP (COUNT)

values (10),
       (15),
       (20);

insert into LIGHT_DOT (BRIGHTNESS, COLOR, POS_X, POS_Y, POS_Z, BUILDING_ID, SHARP_ID)

values (10.5, "red", 1.5, 2, 6, 1, 1),
       (100, "blue", -10, 3, 8.7, 2, 3);

insert into VIEW (PERSON_ID, BUILDING_ID)

values  (3, 1),
        (2, 2);




