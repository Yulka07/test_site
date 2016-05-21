Для того, чтобы запустить сайта, вам необходимо "поднять" MySql на своем компьютере,
создать там базу данных fotoalbum и следующую таблицу:

CREATE TABLE users
(
    id INT(11) PRIMARY KEY NOT NULL,
    email VARCHAR(80) NOT NULL,
    login VARCHAR(50) NOT NULL,
    password CHAR(41) NOT NULL
);