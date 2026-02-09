#PruebaTecnica Neoris
Microservicio Java con Sprint Boot

# Implementacion y Configuracion de Base
Se requiere crear una base de datos en Microsoft SQL Server con el nombre: neoris o  de su preferencia

Se requiere configurar las .env de la aplicacion:

DB_HOST=host.docker.internal
DB_PORT=1433
DB_NAME=neoris
DB_USER=sa
DB_PASSWORD=Passw0rd
ACCOUNT_SERVICE_URL=http://neoris-cuenta:8081/api/v1

# Configuracion de puerto

Configurar las propiedades de la aplicacion en application.properties

spring.application.name=neoris-cliente
server.port=8080

spring.application.name=neoris
server.port=8081

# Compilacion Proyecto

Compliar proyecto con en comando de docker-compose up --build








