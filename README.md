# API RESTful con JAX-RS

### Requisitos previos

Es necesario contar con el siguiente software instalado en la pc.
 * 1 - JDK Y JRE 8
 * 2 - MariaDB 10.x.x
 * 3 - Maven 3.x
 * 4 - Flyway 5.x.x
 * 5 - Payara Server 5.184
 * 5 - Connector J - https://downloads.mariadb.org/connector-java/

Una vez descargado el conector J, se deberá copiar en la siguiente ubicacion dentro de servidor payara para que pueda reconocer el driver de Maria db : payara/glassfish/domains/domain1/lib/

## Empezando

Crear la Base de datos
```
mysql -u usuario -p
CREATE DATABASE apiprueba;
```
Clonar el proyecto
```
git clone https://github.com/Francisco-Castillo/apirestful
```
Una vez clonado el proyecto, se debe generar la estructura de la base de datos e insertar unos cuantos registros . Para facilitar esta tarea el proyecto cuenta con un plugin de flyway (herramienta para la migracion de bd). Es necesario que editemos los valores de este plugin con algun editor de texto (nano, gedit o el bloc de notas). Para ello nos dirijimos a la ubicacion en donde el proyecto fue clonado usando el comando cd.
Abrimos una terminal ya sea en windows o en linux (funciona igual)
```
cd /home/proyecto/apirestful/
nano pom.xml
```
A partir de la linea numero 113 ud encontrar el siguiente framento xml: 
```
     <plugin>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-maven-plugin</artifactId>
        <version>5.1.4</version>
        <!--Archivo de configuracion-->
        <configuration>
          <url>jdbc:mariadb://localhost:3306/bd</url>
          <user>user</user>
          <password>password</password>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.mariadb.jdbc</groupId>
            <artifactId>mariadb-java-client</artifactId>
            <version>2.3.0</version>
          </dependency> 
        </dependencies>
      </plugin>
```
Debe reemplazar el atributo 'user' por su nombe de usuario en mariadb y el password por su contraseña.
Luego guarde los cambios. Ahora si podremos migrar la bd.
```
mvn flyway:info
mvn flyway:migrate
```
Si la migración fue exitosa, ud deberia ver este mensaje en su consola
```
...
Successfully applied 2 migrations to schema `apiprueba` (execution time 00:03.570s)
..
```
Comprobamos haciendo algunas consultas sobre la bd . En la consola de maria db ejecutamos:
```
USE apiprueba;
SHOW TABLES;
SELECT * FROM pais;
SELECT * FROM continente;
```

### Configuración de Payara Server
En esta sección se deben crear los recursos que le permitirán a la aplicacion conectarse con la base de datos. Para comenzar se debe levantar el servidor Payara desde la linea de comandos mediante su comando asadmin
```
cd /home/payara5/bin
./asadmin start-domain
```
Ejecutamos un navegador web y en la url ponemos : localhost:4848 y presionamos enter. Esto nos pemitirá acceder a la consola de administracion de payara.

* **JDBC Connection Pool**
  * 1 - New...
  * 2 - Pool Name :     *apipruebaPool*
  * 3 - Resource Type : *java.sql.Driver*
  * 4 - Click en Next
  * 5 - Driver Classname:  *org.mariadb.jdbc.Driver*
  * 6 - Additional Properties (Add Properties):
    * 6.1 - serverName : *localhost*
    * 6.2 - databaseName : *apiprueba*
    * 6.3 - URL : *jdbc:mariadb://localhost:3306/apiprueba*
    * 6.4 - user: *nombreDeUsuario*
    * 6.5 - password: *password*
    
Una vez finalizada la creación del pool de conexiones, se debe realizar un "ping" para comprobar que el proceso se haya realizado de manera exitosa.

Para ello haga clic en el botón con la leyenda "Ping" que se encuentra dentro de la pestaña general 

    
* **JDBC Resources**
  * 1 - New...
  * 2 - JNDI Name :     *jdbc/apiprueba*
  * 3 - Pool Name : *apipruebaPool*
  * 4 - Click en OK
  
## Desplegar *.war* en Payara Server

Para desplegar la aplicación realizar los siguientes pasos
* 1 - Levantar Payara Server con el comando asadmin.

```
./asadmin start-domain
```
* 2 - Realizar el deploy

```
./asadmin deploy /ruta/aplicacion/target/paises.war
```

## Compilado con

* [Maven](https://maven.apache.org/) - Gestor de dependencias

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Francisco Castillo** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.



## Agradecimientos

* Eugenia Rocha por colaborar con las actualizaciones de la BD.

