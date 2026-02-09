#PruebaTecnica Neoris
Microservicio Java con Sprint Boot

# Implementacion y Configuracion de Base
Se requiere crear una base de datos en Microsoft SQL Server con el nombre: neoris

Se requiere configurar las propiedades de la aplicacion en la siguiente ruta:
src/main/resources/application.properties
Para los proyectos neoris y neoris-cliente

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=neoris;encrypt=true;trustServerCertificate=true;
spring.datasource.username=sa
spring.datasource.password=Passw0rd
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuracion de puerto
Configurar las propiedades de la aplicacion en application.properties
spring.application.name=neoris-cliente
server.port=8080

spring.application.name=neoris
server.port=8081
Nota: Puerto por defecto del es 8080






