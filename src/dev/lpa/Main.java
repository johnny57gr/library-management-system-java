package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> addBook = new ArrayList<>();
        addBook.add(new Book("Diary of a Young Girl", "Anne Frank", "9780241952443", true));
        addBook.add(new Book("Normal People", "Sally Rooney", "9780571334650", true));
        Library library = new Library(addBook, new ArrayList<>());

        library.addBook(new Book("It", "Stephen King", "123518745", true));
        library.addBook(new Book("It", "Stephen King", "123518745", true));
        library.listBooks();
    }
}

/** TODO: CLI Menu Structure:
[1] Add Book
[2] List Books
[3] Register Member
[4] Borrow Book
[5] Exit
**/
