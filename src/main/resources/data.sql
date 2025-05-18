CREATE TABLE animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    peso INT NOT NULL,
    fecha_nacimiento DATE,
    sexo VARCHAR(20),
    raza VARCHAR(100),
    estado_salud VARCHAR(50),
    fecha_ultima_vacuna DATE,
    tipo_alimento VARCHAR(100),
    observaciones VARCHAR(255),
    embarazada BOOLEAN,
    ubicacion VARCHAR(20)
);

INSERT INTO animal 
(nombre, especie, edad, peso, fecha_nacimiento, sexo, raza, estado_salud, fecha_ultima_vacuna, tipo_alimento, observaciones, embarazada, ubicacion) 
VALUES 
('Luna', 'Vaca', 4, 450, '2020-03-15', 'HEMBRA', 'Highland', 'Sano', '2024-03-01', 'Heno', 'Muy tranquila', TRUE, 'ESTABLO'),
('Milka', 'Vaca', 1, 220, '2023-01-10', 'HEMBRA', 'Hereford', 'Sano', '2024-04-10', 'Heno', NULL, FALSE, 'ESTABLO'),
('Max', 'Caballo', 7, 500, '2017-05-23', 'MACHO', 'Árabe', 'Sano', '2024-02-05', 'Avena', 'Caballo muy activo', FALSE, 'PASTO'),
('Nico', 'Perro', 3, 30, '2021-08-12', 'MACHO', 'Border Collie', 'Sano', '2024-05-10', 'Pienso', 'Buen pastor', FALSE, 'CORRAL'),
('Toby', 'Perro', 5, 35, '2019-06-20', 'MACHO', 'Labrador', 'Herido', '2024-03-20', 'Pienso', 'Cojea de una pata', FALSE, 'OTRO'),
('Bella', 'Gato', 2, 5, '2022-11-05', 'HEMBRA', 'Persa', 'Sano', '2024-03-30', 'Pienso', NULL, FALSE, 'GRANERO'),
('Chispa', 'Cabra', 3, 60, '2021-04-18', 'HEMBRA', 'Alpina', 'Sano', '2024-04-25', 'Hierba', 'Le gusta saltar', FALSE, 'PASTO'),
('Rayo', 'Caballo', 9, 510, '2015-02-14', 'MACHO', 'Pura Sangre', 'Sano', '2024-01-15', 'Avena', 'Muy nervioso', FALSE, 'PASTO'),
('Manchitas', 'Vaca', 6, 470, '2018-09-09', 'HEMBRA', 'Frisona', 'Sano', '2024-04-01', 'Heno', 'Próxima a parir', TRUE, 'ESTABLO'),
('Pecas', 'Perro', 4, 28, '2020-12-22', 'HEMBRA', 'Jack Russell', 'Sano', '2024-05-05', 'Pienso', 'Muy juguetón', FALSE, 'CORRAL'),
('Copito', 'Conejo', 1, 3, '2023-07-11', 'MACHO', 'Enano', 'Sano', '2024-04-05', 'Heno', 'Muy blanco', FALSE, 'GRANERO'),
('Canela', 'Gato', 3, 6, '2021-02-02', 'HEMBRA', 'Siames', 'Sano', '2024-03-15', 'Pienso', 'Muy cariñosa', FALSE, 'GRANERO'),
('Menta', 'Cabra', 2, 55, '2022-06-07', 'HEMBRA', 'Saanen', 'Sano', '2024-04-12', 'Hierba', NULL, FALSE, 'PASTO'),
('Sol', 'Gallo', 2, 4, '2022-03-25', 'MACHO', 'Andaluz', 'Sano', '2024-05-01', 'Grano', 'Muy madrugador', FALSE, 'CORRAL'),
('Luz', 'Gallina', 2, 3, '2022-03-26', 'HEMBRA', 'Leghorn', 'Sano', '2024-05-01', 'Grano', 'Pone huevos diarios', FALSE, 'CORRAL'),
('Duna', 'Burro', 10, 350, '2014-08-30', 'HEMBRA', 'Andaluz', 'Sano', '2024-02-20', 'Heno', 'Tranquilo y noble', FALSE, 'PASTO'),
('Rocky', 'Perro', 6, 40, '2018-07-15', 'MACHO', 'Pastor Alemán', 'Herido', '2024-05-02', 'Pienso', 'Tiene una cicatriz', FALSE, 'CORRAL'),
('Estrella', 'Vaca', 5, 460, '2019-11-10', 'HEMBRA', 'Highland', 'Sano', '2024-04-11', 'Heno', 'Muy dócil', TRUE, 'ESTABLO'),
('Nube', 'Caballo', 8, 495, '2016-05-19', 'HEMBRA', 'Percherón', 'Sano', '2024-03-12', 'Avena', 'Muy fuerte', FALSE, 'PASTO');

