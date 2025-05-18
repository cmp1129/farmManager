CREATE TABLE animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    especie VARCHAR(255),
    edad INT
);

INSERT INTO animal (nombre, especie, edad) VALUES ('Luna', 'Vaca', 4);
INSERT INTO animal (nombre, especie, edad) VALUES ('Max', 'Caballo', 7);
INSERT INTO animal (nombre, especie, edad) VALUES ('Nico', 'Perro', 3);
