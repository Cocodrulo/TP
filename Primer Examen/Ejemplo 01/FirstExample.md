# Parcial 1: Gestión Bibliotecaria

### Enunciado

Debido al crecimiento de la carga de trabajo en la Biblioteca Municipal, el departamento de gestión de la biblioteca nos ha pedido desarrollar un software para la gestión de libros y bibliotecarios.

El sistema que se propone desarrollar se compone de libros que son gestionados por bibliotecarios. Por tanto, los miembros de la biblioteca son, de modo general, personas. Para este caso en particular, solo abordaremos uno de los tipos de personas que vinculadas al sistema de información: bibliotecario. Todas las personas con un nombre, representado por una ristra, y un identificador único, representado por unentero que se asigna en el momento de crear el objeto. Por otro lado, existen libros, que además de tener también un identificador (int) y unnombre (string), se les registra el género principal (ficción, no ficción, misterio, ciencia ficción) representado por una ristra. Cada bibliotecario está asociado a un departamento (ficción, no ficción, misterio y ciencia ficción) y puede gestionar más de un libro. El personal bibliotecario puede asignarse un nuevo libro o darlo de baja. También es posible obtener una lista de libros gestionados por un bibliotecario.

### Ejercicio a realizar

El ejercicio a realizar consiste en el desarrollo del siguiente conjunto de clases. De todas ellas, además, se pide documentar usando la **sintaxis de [Javadoc ](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html "JavaDoc")la clase "Person".**

##### Clase abstracta Person (2 Puntos):

-   Un constructor al que se le pasa por el parámetro el nombre de la persona (String) y un identificador (int).
-   Un método llamado getId() que devuelve el identificador de la persona (int).
-   Un método llamado getName() que devuelve el nombre de la persona (String).
-   Un método abstracto llamado getStatus() que imprime un mensaje por pantalla, y no devuelve nada (void).

##### Clase Book (2 puntos):

-   Un constructor al que se le pasan tres parámetros: el título del libro (String), su identificador (int), y su género principal (String).
-   Un método llamado getId() que devuelve el identificador del libro (int).Un método llamado getName() que devuelve el nombre del libro (String).
-   Un método llamado getGenre() que devuelve el género principal del libro (String).
-   El método toString(), que devuelve una ristra con la concatenación del título seguido de dos puntos (“:”) y un espacio y seguido delgénero principal. Por ejemplo: "1984: Ciencia Ficción".

##### Clase Librarian (6 puntos):

Además de los heredados de Person dispone de los siguientes métodos:

-   Un constructor al que se le pasa por parámetro el nombre del bibliotecario (String), su identificador (int), el departamento al que pertenece (String) y un vector de libros que se le asignan al principio.
-   Un método llamado isMember(int id) al que se le pasa por parámetro un identificador de libro y devuelve verdadero si está contenido en el grupo de libros que gestiona, y falso, si no se encuentra.
-   Un método llamado add(Book book) al que se le pasa por parámetro un libro a añadir. Devuelve falso si el libro a añadir ya está contenido en su grupo de libros. Si lo ha podido añadir devuelve verdadero.
-   Un método llamado remove(int id) al que se le pasa por parámetro un identificador de libro, lo elimina del grupo de libros y devuelve verdadero. Devuelve falso si el libro no está en el grupo.
-   Un método llamado getBooks() que devuelve una lista con los libros que están siendo gestionados por este bibliotecario (`List<Book>`)ordenada por el identificador. Si se modificara la lista devuelta no se deberían modificar los libros del bibliotecario.El método getStatus(), que imprime la lista de libros que gestiona este bibliotecario, ordenada de acuerdo con el identificador delibro. Cada libro debe imprimirse usando el método toString.

### Uso y prueba de las clases

Realice un programa principal en la clase pública **SoftwareMain** que cree varios objetos y utilice las operaciones de las clases desarrolladas. Puede partir del siguiente código como ejemplo de uso:

```java
Book book1 = new Book("1984", 123456, "Science Fiction");
Book book2 = new Book("To Kill a Mockingbird", 234567, "Fiction");
Book book3 = new Book("The Great Gatsby", 345678, "Fiction");
Book book4 = new Book("Moby Dick", 456789, "Fiction");
Book book5 = new Book("War and Peace", 567890, "Historical Fiction");

Librarian smith = new Librarian("Smith", 111111, "Fiction", new Book[0]);
Librarian johnson = new Librarian("Johnson", 222222, "Science Fiction", new Book[0]);
Librarian williams = new Librarian("Williams", 333333, "Historical Fiction", new Book[]{book5}); Librarian brown = new Librarian("Brown", 444444, "Mystery", new Book[] {book4});

smith.add(book2);
smith.add(book3);
johnson.add(book1);
williams.add(book5);
brown.add(book4);

smith.getStatus();
smith.remove(book2.getId());
smith.add(book1);
smith.getStatus();
book1.getStatus();
```

Las clases con el código a desarrollar deben pertenecer al paquete **"tp.examen"**.

**Ejercicio:**

<p style="color: lightblue;">
Realice la implementación de las distintas clases según los requisitos descritos en el enunciado añadiendo los atributos y los métodos de laclase Object que cree oportunos para su correcto funcionamiento en el resto de la aplicación, usando los contenedores de la librería deJava más adecuados.
</p>

**Notas:**

-   El código no debe tener errores de compilación. Estos pueden penalizar de 2 a 4 puntos.Las distintas clases se deben desarrollar según los requisitos descritos en el enunciado, añadiendo los métodos de la clase **Object** y **comparadores** que crea oportunos para su correcto funcionamiento en el resto de la aplicación.
-   Use los **contenedores de Java más adecuados** para este escenario. Para la implementación de los comparadores se deben implementar las interfaces usando clases, **clases anidadas**, clases anónimaso lambdas. **No está permitido** el uso de métodos estáticos de utilidades de la clase "`Comparator`" del tipo "`comparing…`" , "`thenComparing…`" y similares.
-   Se puede modificar el método "`main`" de "`SoftwareMain`" para realizar todas las pruebas que crea necesarias.
-   Puede hacer uso de la documentación de la asignatura así como del enlace a la página web de Oracle. Cualquier acceso a la redalternativo será motivo de suspenso.
