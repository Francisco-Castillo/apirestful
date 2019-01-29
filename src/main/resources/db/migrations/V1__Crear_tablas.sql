CREATE TABLE pais(
    pais_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    pais_nombre_largo VARCHAR(80) NOT NULL,
    pais_nombre_corto VARCHAR(50) NOT NULL,
    pais_abreviatura VARCHAR(5),
    bandera VARCHAR(20)
);

CREATE TABLE provincia(
    provincia_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    provincia_nombre VARCHAR(100) NOT NULL,
    provincia_abreviatura VARCHAR(5),
    provincia_latitud VARCHAR(400) ,
    provincia_longitud VARCHAR(400),
    pais_id INT NOT NULL
);

ALTER TABLE provincia ADD FOREIGN KEY FK_PROVINCIA_PAIS (pais_id) REFERENCES pais (pais_id) ON UPDATE CASCADE;