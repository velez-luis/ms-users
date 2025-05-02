# ms-users
Backend para la creación de usuarios.

## Requirements
- [JDK 17](https://adoptium.net/es/?variant=openjdk17)
- [Maven 3](https://maven.apache.org/)
## Swagger
Para acceder a la documentación realizada con Swagger, se debe entrar al siguiente endpoint:
``` http request
http://localhost:9090/api/swagger-ui/index.html
```
## Consideraciones
- La base de datos utilizada es H2, por lo que no es necesario crear una base de datos externa.
- Se habilitó la consola h2 para poder ver los datos que se están guardando en la base de datos. El usuario por defecto es sa y sin password, pero se puede cambiar con variables de entorno. Para acceder a la consola, se debe entrar al siguiente endpoint:
``` http request
http://localhost:9090/api/h2-console
```
``` properties
export H2_DB_URL=jdbc:h2:mem:usersdb
export H2_DB_USERNAME=admin
export H2_DB_PASSWORD=admin123
```
- El archivo `application.yaml` contiene la configuración de la base de datos y el puerto.
- El puerto por defecto es `9090`, pero se puede cambiar en el archivo `application.yaml`.
- En el archivo `application.yaml` puede modificar la regex para la validación de los passwords, así como el mensaje de error que se muestra al usuario.
``` yaml
app:
    security:
        password:
            validation:
                pattern: 
                message:
```
- Cuenta con validación de correo electrónico, sólo se adminten correos @dominio.cl.
- La URL (Método Post) y el payload de la petición para la creación de un usuario es el siguiente:
``` http request
localhost:9090/api/v1/users
```
``` json
{
    "name": "Juan Rodriguez",
    "email": "juan2@dominio.cl",
    "password": ".hunterDoglas25",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```
- La URL (Método Get) y el payload de la petición para la obtención de un usuario es el siguiente:
``` http request
localhost:9090/api/v1/users/{id}
```
``` json
{
    "id": 1
}
```
## Run maven application
Para ejecutar la aplicación, se debe ejecutar el siguiente comando en la raíz del proyecto:
``` bash
mvn spring-boot:run
```
También puede optar por ejecutar la aplicación desde su IDE favorito, como IntelliJ o Eclipse.
OTra alternativa es levantar el proyecto desde Docker, para ello se debe ejecutar el siguiente comando en la raíz del proyecto:
``` bash
docker-compose up -d
```