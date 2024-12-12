package tp.examen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Librarian extends Person {
    private final List<Book> bookList;

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public Librarian(String name, int id, String department, Book[] bookVector ) {
        super(name, id);
        bookList = new ArrayList<>();

        for (Book book: bookVector) {
            bookList.add(book);
        }
    }

    public boolean isMember(int id) {
        for (Book book: bookList) {
            if (book.getId() == id) return true;
        }
        return false;
    }

    public boolean add(Book book) {
        if (this.isMember(book.getId())) return false;

        bookList.add(book);
        return true;
    }

    public boolean remove(int id) {
        if (!this.isMember(id)) return false;

        bookList.remove(id);
        return true;
    }

    public List<Book> getBooks() {
        List<Book> copyBooks = new ArrayList<>(bookList);

        Collections.sort(copyBooks);

        return copyBooks;
    }

    @Override
    public void getStatus() {
        List<Book> sortedBooks = this.getBooks();
        
        for (Book book: sortedBooks) {
            System.out.println(book.toString());
        }
    }
}
