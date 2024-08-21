-- Insertar datos en la tabla role
INSERT INTO role (id, nombre) VALUES
(1, 'Administrador'),
(2, 'Gerente General'),
(3, 'Gerente Departamento'),
(4, 'Jefe de Calidad'),
(5, 'Asesor');

-- Insertar datos en la tabla user_entity
INSERT INTO user_entity (id, role_id, nombre_usuario, correo, contrasena) VALUES
(1, 1, 'administrador', 'admin@gmail.com', '12345678'),
(2, 2, 'Jessica Córdova', 'jcordova@gmail.com', '12345678'),
(3, 3, 'Lucila Briceño', 'lbriceno@gmail.com', '12345678'),
(4, 4, 'Alexandra Rodríguez', 'arodriguez@gmail.com', '12345678'),
(5, 5, 'David Vigo', 'dvigo@gmail.com', '12345678');

-- Insertar datos en la tabla area
INSERT INTO area (nombre) VALUES 
('Ing & Arq'), 
('Ing & Salud'), 
('Letras');

-- Insertar datos en la tabla area_user
INSERT INTO area_user (area_id, user_id) VALUES
(1, 3), 
(2, 2),
(3, 4), 
(1, 1),
(2, 1), 
(3, 1),
(1, 5); 

-- Insertar datos en la tabla advisor
INSERT INTO advisor (nombres, apellidos, dni, edad, bancaria, interbancaria, user_id) VALUES 
('David', 'Vigo', '12345678', 24, NULL, NULL, 5);

-- Insertar datos en la tabla customer
INSERT INTO customer (nombre, apellidos, num_documento, edad, correo, telefono) VALUES
('Juan', 'Pérez Gómez', '12345678', 35, 'juanperez@example.com', '987654321'),
('María', 'Rodríguez Sánchez', '87654321', 28, 'mariarodriguez@example.com', '123456789'),
('Pedro', 'Fernández Díaz', '45678912', 42, 'pedrofernandez@example.com', '456789123');

-- Insertar datos en la tabla chapter
INSERT INTO chapter (titulo) VALUES
('Capítulo I'),
('Capítulo II'),
('Capítulo III'),
('Capítulo IV'),
('Capítulo V'),
('Capítulo VI'),
('Capítulo VII'),
('Capítulo VIII'),
('Capítulo IX'),
('Capítulo X'),
('Capítulo XI'),
('Capítulo XII');

-- Insertar datos en la tabla institution
INSERT INTO institution (nombre, abreviatura) VALUES
('Universidad Nacional Mayor de San Marcos', 'UNMSM'),
('Pontificia Universidad Católica del Perú', 'PUCP'),
('Universidad Peruana Cayetano Heredia', 'UPCH'),
('Instituto Tecnológico de la Producción', 'ITP'),
('Instituto Nacional de Salud', 'INS');

-- Insertar datos en la tabla profession
INSERT INTO profession (nombre, institution_id) VALUES
('Ingeniería en Sistemas', 1),
('Ingeniería en Informática', 1),
('Ingeniería en Electrónica', 1),
('Técnico en Mecatrónica', 4),
('Técnico en Industria', 5);

-- Insertar datos en la tabla servicio
INSERT INTO servicio (denominacion) VALUES
('Tesis completa'),
('Plan de tesis'),
('Parafraseo'),
('Trabajo de Suficiencia'),
('Diapositivas');

-- Insertar datos en la tabla event
INSERT INTO event (denominacion) VALUES
('1era vez Memorandum'),
('2da vez Memorandum'),
('3era vez Memorandum');
