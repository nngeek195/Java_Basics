import java.util.ArrayList;

class Book {
    private String author;
    private String title;
    private String ISBN;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void displayDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("ISBN: " + ISBN);
    }

}

class EBooks extends Book {
    private String filesize;

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public void displayDetails() {
        System.out.println("File size: " + filesize);
    }
}

class Library extends Book {

    ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
            if (book instanceof EBooks) {
                ((EBooks) book).displayDetails();
            }
            System.out.println("-------------------------------------------");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book();
        book1.setAuthor("John Doe");
        book1.setTitle("The Catcher in the Rye");
        book1.setISBN("9780316769484");

        EBooks eBook1 = new EBooks();
        eBook1.setAuthor("John Doe");
        eBook1.setTitle("The Catcher in the Rye");
        eBook1.setISBN("9780316769484");
        eBook1.setFilesize("5.7 MB");

        Book book2 = new Book();
        book2.setAuthor("Jane Doe");
        book2.setTitle("To Kill a Mockingbird");
        book2.setISBN("9780141950791");

        library.addBook(book1);
        library.addBook(eBook1);
        library.addBook(book2);

        library.displayAllBooks();
    }
}
