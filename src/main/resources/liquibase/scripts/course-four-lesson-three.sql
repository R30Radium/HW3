-- liquibase formatted sql

-- changeSet: hoggwarts:1

CREATE INDEX student_name_index on student (name);

-- changeSet: hoggwarts: 2

CREATE INDEX faculty_name_color_index on faculty (name, color);