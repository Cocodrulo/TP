### Concepto:

Tienes un centro universitario que dispone de salas d estudio para los estudiantes.

Hay dos tipo de salas, pequeñas (2 a 3 personas) y grandes (2 a 5 personas).

### Ejercicio a realizar

##### Clase Main:

-   15 reservas (inicialziar, esperar a q terminen, etc)
-   Imprimir el total de salas reservadas.
-   Te da un log, getTimeUse, getRandomStudents.

##### Clase Centro:

-   Método reservar, devuelve 0 si la solicitud de reserva se rechaza, 1 si es sala pequeña, 2 si es sala grande. Recibe un número de estudiantes.
-   Método liberar, libera la sala. Recibe un entero representando el tipo se sala.
-   getSalasSimplesTotales, getSalasPequeñasTotales.
-   Esta clase hay que documentarla.

##### Clase Reserva:

-   Recibe el nombre del hilo (ej: "R1") y demás parámetros necesarios.
-   Debe hacer las acciones a continuación N_VECES.
-   Intenta reservar una sala, imprimiendo en pantalla "Solicitando sala para n estudiantes", si la solicitud es rechazada, debe imprimir en pantalla "Solicitud rechazada para n estudiantes". Si la solicitud es aceptada debe imprimir "Asignada sala tipo" siendo tipo simple o grande.
-   luego esperará un tiempo (del getter del main), antes imprimiendo "usando sala" y luego liberará la sala diciendo "sala liberada".
-   Luego libera el tiempo de CPU.
