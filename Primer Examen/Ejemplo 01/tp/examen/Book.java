package tp.examen;
public class Book implements Comparable<Book> {
    private final int id;
    private final String name;
    private final String genre;

    public Book(String name, int id, String genre) {
        this.name = name;
        this.id = id;
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getName(), this.getGenre());
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.getId(), other.getId());
    }
    
}
