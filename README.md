# API RESTful con JAX-RS


## Empezando

Servicio web restful creado con JAXRS

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Configuración de Payara Server

Una vez que haya restaurado los scripts de MariaDB, es necesario crear en el servidor los recursos que le permitiran a la aplicacion conectarse con la base de datos. Ellos son :

* **JDBC Connection Pool**
  * 1 - New...
  * 2 - Pool Name :     *apipruebaPool*
  * 3 - Resource Type : *java.sql.Driver*
  * 4 - Click en Next
  * 5 - Driver Classname:  *org.mariadb.jdbc.Driver*
  * 6 - Additional Properties (Add Properties):
    * 6.1 - serverName : *localhost*
    * 6.2 - databaseName : *paisesDB*
    * 6.3 - URL : *jdbc:mariadb://localhost:3306/saed_web*
    * 6.4 - user: *nombreDeUsuario*
    * 6.5 - password: *password*
    
Una vez finalizada la creación del pool de conexiones, se debe realizar un "ping" para comprobar que el proceso se haya realizado de manera exitosa.

Para ello haga clic en el botón con la leyenda "Ping" que se encuentra dentro de la pestaña general 

    
* **JDBC Resources**
  * 1 - New...
  * 2 - JNDI Name :     *jdbc/paisesdb*
  * 3 - Pool Name : *apipruebapool*
  * 4 - Click en OK



```

```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

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

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Francisco Castillo** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.



## Agradecimientos

* Hat tip to anyone whose code was used
* Inspiration
* etc

