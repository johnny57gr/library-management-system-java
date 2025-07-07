package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Book> addBook = new ArrayList<>();
        addBook.add(new Book("Diary of a Young Girl", "Anne Frank", "9780241952443", true));
        addBook.add(new Book("Normal People", "Sally Rooney", "9780571334650", true));
        addBook.add(new Book("It", "Stephen King", "123518745", true));

        List<Member> members = new ArrayList<>();
        members.add(new Member("Ioannis Passas", "1", "yiannispas86@gmail.com", "6984705234", new ArrayList<>()));

        Library library = new Library(addBook, members);

        Scanner scanner = new Scanner(System.in);
        int choice;


        while (true) {
            System.out.println("\n====== LIBRARY MENU ======");
            System.out.println("[1] Add Book");
            System.out.println("[2] List Books");
            System.out.println("[3] Register Member");
            System.out.println("[4] List Members");
            System.out.println("[5] Borrow Book");
            System.out.println("[6] Return Book");
            System.out.println("[7] Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Add Book selected");

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();

                    Book newBook = new Book(title, author, isbn, true);
                    library.addBook(newBook);
                }

                case 2 -> {
                    System.out.println("List Books selected");
                    library.listBooks();
                }

                case 3 -> {
                    System.out.println("Register Member selected. Create new member.");

                    System.out.print("Enter new member name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter new member id: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter new member email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter new member phone: ");
                    String phone = scanner.nextLine();

                    Member newMember = new Member(name, id, email, phone, new ArrayList<>());
                    library.addMember(newMember);
                }

                case 4 -> {
                    System.out.println("List Members selected");
                    library.listMembers();
                }

                case 5 -> {
                    System.out.println("Borrow Book selected");

                    System.out.print("Please enter member id: ");
                    String memberId = scanner.nextLine();


                    System.out.print("Please enter book isbn: ");
                    String isbn = scanner.nextLine();

                    library.borrowBook(isbn, memberId);
                }

                case 6 -> {
                    System.out.println("Return Book selected");

                    System.out.print("Please enter member id: ");
                    String memberId = scanner.nextLine();

                    System.out.print("Please enter book isbn: ");
                    String isbn = scanner.nextLine();

                    library.returnBook(isbn, memberId);
                }

                case 7 -> {
                    System.out.println("Exiting!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}


