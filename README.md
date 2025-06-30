# DBD-CRUD

Backend de una tienda online que vende juegos de mesa,
hecho en Spring Boot y PostgreSQL.

## Requisitos

Se debe tener instalado JDK 17 (Java) y PostgreSQL. Este proyecto usa Maven 
para configurar las builds y el proceso de compilación,por lo que se incluye un 
wrapper `mvnw` que genera una instalación local del mismo, si es necesario.

Para compilar el proyecto desde una interfaz gráfica (opcional), es necesario
usar editores de texto especializados (IDEs, como IntelliJ o VSCode) que
tengan soporte integrado de Maven.

Para poder conectar el Backend a la base de datos por defecto,
se puede crearla con las siguientes instrucciones de PSQL:

```
CREATE DATABASE demo_db;
CREATE USER demo_user WITH ENCRYPTED PASSWORD 'demo_password';
GRANT ALL PRIVILEGES ON DATABASE demo_db TO demo_user;
```

Se puede configurar la dirección y otros parámetros de la base de 
datos en ```backend/src/main/resources/application.yaml```
antes de compilar.

## Instrucciones de uso

Para compilar el archivo .jar ejecutable, basta con ir a la carpeta `backend`
y ejecutar la orden de terminal de Maven  `./mvnw package` en Linux, 
o `mvnw.cmd package` en Windows. Se generará un nuevo archivo .jar en `target/`.

Luego, para ejecutarlo, usar `java -jar <CaminoEjecutable>.jar` mientras
esté activa la BD anterior en PostgreSQL.

## Requerimientos 

- [ ] a. Login y registro de los usuarios.
- [ ] b. Existencia de roles de usuarios (admini,usuario,jefe de tienda,usuario cliente).
- [ ] c. Subida de productos (juegos,cartas) por jefe de tienda (incluir url para imagen).
- [ ] d. Administrador debe poseer permisos necesarios para realizar el CRUD de todas las entidades.
- [ ] e. Actualizar datos de un usuario (cliente y jefe).
- [ ] f. Categorizar producto entre juego de mesa y carta (jefe)
- [ ] g. Actualizar datos de los productos (jefe)
- [ ] h. Eliminar un producto (jefe)
- [ ] i. Categorizar los productos comprados por usuarios según ubicación geográfica.
- [ ] j. Categorizar juegos de mesa según su tipo (rol, guerra, tablero, etc).
- [ ] k. Categorizar cartas según su rareza, estado y año
- [ ] l. Mostrar un ranking de los productos con más ventas.
- [ ] m. Existencia de un carro de compras para el cliente donde pueda ir agregando distintos productos.
- [ ] n. Simular el proceso de compra (debe existir una boleta) medios de pago por parte del cliente.
- [ ] o. Dejar una valoración (sólo una por usuario) a un producto.
- [ ] p. “lista de deseos” del usuario, para agregar productos a comprar en un futuro.
- [ ] q. Debe ser posible filtrar los productos por la ubicación geográfica del cliente.
- [ ] r. El proceso de pago sólo será posible cuando todos los productos tengan stock.
- [ ] s. Ranking de las cartas más deseadas por los clientes.
