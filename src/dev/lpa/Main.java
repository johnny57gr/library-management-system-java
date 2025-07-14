package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String inputOrBack(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();

        if(input.equalsIgnoreCase("back")) {
            System.out.println("Returning to main menu...");
            return null;
        }
        return input;
    }

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

                    String title = inputOrBack("Enter book title (or 'back' to cancel): ", scanner);
                    if (title == null) break;

                    String author = inputOrBack("Enter author (or 'back' to cancel): ", scanner);
                    if (author == null) break;

                    String isbn = inputOrBack("Enter book ISBN (or 'back' to cancel): ", scanner);
                    if (isbn == null) break;

                    Book newBook = new Book(title, author, isbn, true);
                    library.addBook(newBook);
                }

                case 2 -> {
                    System.out.println("List Books selected");
                    library.listBooks();
                }

                case 3 -> {
                    System.out.println("Register Member selected. Create new member.");

                    String name = inputOrBack("Enter new member name (or 'back' to cancel): ", scanner);
                    if (name == null) break;

                    String id = inputOrBack("Enter new member id (or 'back' to cancel): ", scanner);
                    if (id == null) break;

                    String email = inputOrBack("Enter new member email (or 'back' to cancel): ", scanner);
                    if (email == null) break;

                    System.out.print("Enter new member phone: ");
                    String phone = inputOrBack("Enter new member phone (or 'back' to cancel): ", scanner);
                    if (phone == null) break;

                    Member newMember = new Member(name, id, email, phone, new ArrayList<>());
                    library.addMember(newMember);
                }

                case 4 -> {
                    System.out.println("List Members selected");
                    library.listMembers();
                }

                case 5 -> {
                    System.out.println("Borrow Book selected");

                    String memberId = inputOrBack("Please enter member ID (or 'back' to cancel): ", scanner);
                    if (memberId == null) break;

                    // Check if member exists
                    Member selectedMember = null;
                    for (Member member : library.getListOfMembers()) {
                        if (memberId.equalsIgnoreCase(member.getId())) {
                            selectedMember = member;
                            break;
                        }
                    }

                    if (selectedMember == null) {
                        System.out.println("Member not found. Please try again or register a member first.");
                        break;
                    }

                    // Continue only if member exists
                    String isbn = inputOrBack("Please enter book ISBN (or 'back' to cancel): ", scanner);
                    if (isbn == null) break;

                    library.borrowBook(isbn, memberId);
                }


                case 6 -> {
                    System.out.println("Return Book selected");

                    String memberId = inputOrBack("Please enter member ID (or 'back' to cancel): ", scanner);
                    if (memberId == null) break;

                    Member selectedMember = null;
                    for (Member member : library.getListOfMembers()) {
                        if (memberId.equalsIgnoreCase(member.getId())) {
                            selectedMember = member;
                            break;
                        }
                    }

                    if (selectedMember == null) {
                        System.out.println("⚠ Member not found. Please try again or register first.");
                        break;
                    }

                    String isbn = inputOrBack("Please enter book ISBN (or 'back' to cancel): ", scanner);
                    if (isbn == null) break;

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


