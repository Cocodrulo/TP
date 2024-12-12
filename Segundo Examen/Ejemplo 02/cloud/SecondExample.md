Se desea desarrollar un programe Java que, concurrencia, simule la reserva de recursos de memoria y CPU de un servicio de computación en la nube. En concreto, un servicio de computación (Clase `ComputingService`) es contratado por uno o más clientes (clase `Client`), para ejecutar tareas que consumen CPU y memoria.

EI programa también dispone de la dase Resources (ya implementada) que simplemente funciona como estructura de datos en la que se agrupan los campos tiempo de _CPU y cantidad de memoria_. Esta clase se usa parámetro de entrada y como de salida en las clases `Client `y `ComputinService`.

La cantidad de recursos ofertados por el servicio de computación (CPU y Memoria) es limitada. Cada cliente como paso previo a su ejecución, debe
especificar la cantidad de recursos que necesita usar. EI de computación permitirá la ejecución de la tarea del diente en el momento en que
haya recursos suficientes para su ejecución, En todo momento, de número de recursos reservados por los clientes ejecutando tareas **no puede ser mayor** que las recursos ofertados por el servicio la nube: no puede usarse más CPU ni más de la disponible.

Por último, el problerna contiene la clase "`Simulador`", la cual simula la ejecución de **10 clientes** accediendo al servicio de computación. Además,
en la clase "`Simulador`" se definen constantes y métodos estáticos que pueden usar resto de clases para cornpletar su implementación:

-   `createResources()`: crea un objeto de tipo Resources con valores aleatorios de CPU y memoria. Se usa en la construcción de los
    clientes
-   `log(String cadena, Resources res)`: Imprime en pantalla una cadena del tipo "`[cadena] (CPU: [cpu], Mem: [mem])`".

Recursos disponues para consulta:

-   Transparencias de Java sobre concurrencia.
-   API de Java 8.
-   Tutorial de Java sobre concurrencia.

## Desarrollo de la simulación

A continuación se describen las clases de las que se compone el ejercicio. <ins>Es **Importante notar** que la descripción de las clases y los métodos no es completa: a esta se deben añadir los **modificadors, cláusulas y campos** que sean necesarios para que las clases y los métodos implementen correctamente el problema de concurrencia.</ins>

##### Clase "Simulador"

Se debe completar el método "`main`" de la Clase "`Simulador`" que realice las siguientes acciones:

1. Crear un objeto que represente eI servicio de computación en la nube, indicando la capacidad máxima del mismo usando las constantes"`MAX_CPU`" y "`MAX_MEM`".
2. Iniciar la ejecución de **10 tareas** correspondientes a objetos de la clase "`Client`". Para indicar la cantidad de recursos que consume cada cliente (objeto `Resources`) use el método "`createResources( )`". También se debe indicar que la tarea de cada cliente se debe ejecutar dos veces (constante `N_ITERATIONS`).
3. Esperar a la finalización de las tareas de los 10 clientes.
4. Mostar en pantalla el número total de recursos consumidos durante la ejecución (CPU y memoria). Ejemplo: "`Recursos totales (CPU : 150 , Mem: 30)`" Se puede usar eI método "`log()`".

**Además**, se pide definir e instanciar dentro de la clase "`Simulador`" una tarea de **tipo _daemon_**que muestre cada 2000 milisegundos (2 segundos) la cantidad de recursos consumidos hasta el momento. Ejemplo: "`Recursos actuales (CPU: 150 , Men: 30)`" Se puede usar el método `log()`.
