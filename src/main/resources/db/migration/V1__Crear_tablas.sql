CREATE TABLE continente(
    continente_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    continente_nombre VARCHAR(45) NOT NULL
);

CREATE TABLE pais(
    pais_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    pais_nombre_largo VARCHAR(80) NOT NULL,
    pais_nombre_corto VARCHAR(50) NOT NULL,
    pais_abreviatura VARCHAR(5),
    pais_capital VARCHAR(50),
    pais_poblacion INT,
    bandera VARCHAR(40),
    resenia VARCHAR(400),
    continente_id INT NOT NULL
);

CREATE TABLE provincia(
    provincia_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    provincia_nombre VARCHAR(100) NOT NULL,
    provincia_abreviatura VARCHAR(5),
    provincia_latitud VARCHAR(400) ,
    provincia_longitud VARCHAR(400),
    pais_id INT NOT NULL
);
ALTER TABLE pais ADD FOREIGN KEY FK_PAIS_CONTINENTE(continente_id) REFERENCES continente(continente_id) ON UPDATE CASCADE;
ALTER TABLE provincia ADD FOREIGN KEY FK_PROVINCIA_PAIS (pais_id) REFERENCES pais (pais_id) ON UPDATE CASCADE;