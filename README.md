# klagan-text

Proyecto realizado bajo clean architecture

Clonar proyecto desde el repositorio.

Descargar las dependencias del build.gradle.

El proyecto fue desarrollado con flyway para la creacion de tablas y carga de datos iniciales, dentro del archivo: /resources/db/migration/V1.0__create_tables.sql se encuentran el script para creacion de tablas y carga de datos iniciales.

El proyecto se despliega en el puerto 8080 de acuerdo a la configuración en el archivo application.properties

El contextPath de la app esta configurado con el valor /api.

La tabla productos se carga con 1 solo registro al iniciar la aplicacion

La tabla lista de precios se carga con varios registros para validar los precios de los productos por fecha y prioridad segun orden descrito en el ejercicio

Para probar los endpoint en la carpeta /postman se encuentra el collection de los endpoints para porbarlos se debe importar el archivo itext-app.postman_collection.json se lo debe hacer con postman.

Para ingresar a la consola de h2: http://localhost:8080/api/h2-console Datos para configurar conexión a la base de datos: Driver Class: org.h2.Driver JDBC URL: jdbc:h2:mem:nisum username: admin / password: admin

El servicio cuenta con 2 pruebas unitarias con Mockito en core e infrastructure

Se agrega nueva entidad BRAND para manejar la marca del producto asociada a la lista de precios y se crean 3 registros de esta
siendo 

1 -> XYZ

2 -> ZARA

3 -> PULL&BEAR

# En la clase test de PriceListControllerTest.java 

# se encuentran las pruebas de integracion de los endpoints favor revisar gracias.
