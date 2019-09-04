CREATE DATABASE IF NOT EXISTS `aiport`;

USE `aiport`;

DROP TABLE IF EXISTS `passanger`;
DROP TABLE IF EXISTS `airplane`;
DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `aiport`;



create table flight
(
    id_flight          int auto_increment
        primary key,
    departure_flight   date        not null,
    destination_flight date        not null,
    flight_status      varchar(45) null
)ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `aiport`.`aiport`
(
    `id_aiport` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(45)  NULL,
    `city`      VARCHAR(45)  NULL,
    `country`   VARCHAR(45)  NULL,
    id_flight_departure int not null,
    id_flight_destination int not null,
    PRIMARY KEY (`id_aiport`),
    CONSTRAINT FK_FLIGHT_DEPARTURE FOREIGN KEY (id_flight_departure) REFERENCES flight (id_flight),
    CONSTRAINT FK_FLIGHT_DESTINATION FOREIGN KEY (id_flight_destination) REFERENCES  flight (id_flight)
)ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `airplane`
(
    `id_airplane` INT  NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    `brand`       VARCHAR(45) NULL,
    `model`       VARCHAR(45) NULL,
    id_flight int not null ,
    CONSTRAINT FK_FLIGHT_AIRPLANE foreign key (id_flight) references flight(id_flight)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;

create table passanger
(
    id_passanger int auto_increment primary key,
    first_name   varchar(45) null,
    last_name    varchar(45) null,
    pesel        bigint(12)  not null,
    id_flight  int not null,
    constraint FK_FLIGHT foreign key ( id_flight) references flight (id_flight)
)ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;



INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2008-11-11 13:23:44','2008-11-11 16:23:00','REALIZED');
INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2008-11-12 08:28:44','2008-11-12 14:59:00','REALIZED');
INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2019-07-03 11:56:00','2019-11-12 13:27:00','REALIZED');
INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2019-01-01 08:28:00','2019-01-01-16:23:00','CANCELLED');
INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2019-11-12 08:28:00','2019-11-12 14:59:00','PLANNING');
INSERT INTO flight (departure_flight, destination_flight,flight_status) VALUES ('2020-11-12 07:10:00','2020-11-12 10:45:00','PLANNING');

INSERT INTO aiport (name, city, country, id_flight_departure, id_flight_destination) VALUES ('Chopin','Warsaw','Poland', 6, 7);




INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Boeing','Dreamliner 787-9',6);
INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Boeing','Dremliner 787',6);
INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Boeing','737 MAX 8',7);
INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Embraer','195',7);
INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Embraer','175',7);
INSERT INTO airplane (brand,model,id_flight_airplane) VALUES ('Embraer','170',6);

INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Tomasz', 'Adamek', 56012382416,6 );
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Barbara', 'Fornal', 53111689929, 7);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Michał', 'Dindo', 65081554116, 8);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Kalina', 'Filecka', 89052513634, 9);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Rafał', 'Bobek', 50090858768, 9);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Krystyna', 'Policka', 62082864866, 9);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Tadeusz', 'Komasa', 64011371623, 6);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Jadwiga', 'Terlilecka', 91020976475, 6);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Wiktor', 'Krupicki', 57031493349, 6);
INSERT INTO passanger (first_name, last_name, pesel, id_flight)
VALUES ('Zbigniew', 'Trawnocki', 60061254323, 7);



