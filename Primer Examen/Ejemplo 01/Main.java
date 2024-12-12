import tp.examen.Book;
import tp.examen.Librarian;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", 123456, "Science Fiction");
        Book book2 = new Book("To Kill a Mockingbird", 234567, "Fiction");
        Book book3 = new Book("The Great Gatsby", 345678, "Fiction");
        Book book4 = new Book("Moby Dick", 456789, "Fiction");
        Book book5 = new Book("War and Peace", 567890, "Historical Fiction");

        Librarian smith = new Librarian("Smith", 111111, "Fiction", new Book[0]);
        Librarian johnson = new Librarian("Johnson", 222222, "Science Fiction", new Book[0]);
        Librarian williams = new Librarian("Williams", 333333, "Historical Fiction", new Book[]{book5});
        Librarian brown = new Librarian("Brown", 444444, "Mystery", new Book[] {book4});

        smith.add(book2);
        smith.add(book3);
        johnson.add(book1);
        williams.add(book5);
        brown.add(book4);
        smith.getStatus();
        smith.remove(book2.getId());
        smith.add(book1);
        smith.getStatus();
    }
}
