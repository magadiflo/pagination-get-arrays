# Spring Data JPA Pagination with Angular

## Canal de youtube: Get Arrays
https://www.youtube.com/watch?v=JNxWZXOsU0w

## Generar datos ficticios para insertar en BD
https://mockaroo.com/

## Api para obtener fotos de varón y mujer
https://randomuser.me/photos

## NOTA: 
Creamos un archivo **import.sql** en **/resources**.   

Para que se pueda poblar y eliminar los datos de la BD cada vez que 
iniciemos y bajemos el proyecto respectivamente, la configuración de
**ddl-auto** debe tener el valor de **create-drop**, así:  
**spring.jpa.hibernate.ddl-auto: create-drop**  

En el caso de este proyecto, lo establecimos como **update**, tal como 
lo trabaja el tutor. Esto provoca que las consultas del **import.sql** no se 
ejecuten en automático. Así que lo ejecutaremos manualmente, directo en la BD.
Pero la ventaja es que la BD permanece con sus registros, es decir no se 
eliminarán una vez se deje de ejecutar el proyecto.
