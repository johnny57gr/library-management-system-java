package dev.lpa;

import java.util.List;

public class Library {

    private List<Book> listOfBooks;
    private List<Member> listOfMembers;

    public Library(List<Book> listOfBooks, List<Member> listOfMembers) {
        this.listOfBooks = listOfBooks;
        this.listOfMembers = listOfMembers;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public List<Member> getListOfMembers() {
        return listOfMembers;
    }

    public boolean addBook(Book book) {

        for (Book listOfBook : listOfBooks) {
            if (book.getIsbn().equalsIgnoreCase(listOfBook.getIsbn())) {
                System.out.println("Book already exists.");
                return false;
            }
        }

        listOfBooks.add(book);
        System.out.println("Book added successfully!");
        return true;
    }

    public void listBooks() {

        if (listOfBooks.isEmpty()) {
            System.out.println("No books in the list.");
        }
        else {
            for (Book list : listOfBooks){
                System.out.println(list);
            }
        }
    }

    public boolean addMember(Member member) {

        for (Member newMember : listOfMembers) {
            if (member.getEmail().equalsIgnoreCase(newMember.getEmail())){
                System.out.println("Member already exists.");
                return false;
            }
        }

        listOfMembers.add(member);
        System.out.println("New Member added successfully!");
        return true;
    }

    public void listMembers() {

        if (listOfMembers.isEmpty()) {
            System.out.println("There is no members on the list.");
        }
        else {
            for (Member list : listOfMembers) {
                System.out.println(list);
            }
        }
    }

    public void borrowBook(String isbn, String memberId) {

        // check if member and book exists
        Member selectedMember = null;
        for (Member checkMember : listOfMembers) {
            if (memberId.equalsIgnoreCase(checkMember.getId())){
                selectedMember = checkMember;
                break;
            }
        }

        Book selectedBook = null;
        for (Book checkBook : listOfBooks) {
            if (isbn.equalsIgnoreCase(checkBook.getIsbn())){
                selectedBook = checkBook;
                break;
            }
        }

        if (selectedMember == null) {
            System.out.println("Member not found");
        }

        if (selectedBook == null) {
            System.out.println("Book not found");
        }

        if (selectedMember != null && selectedBook != null){
            System.out.println("Book is available");
            selectedMember.getListOfBooks().add(selectedBook);
            System.out.println("Book successfully borrow to member: " + selectedMember.getName() + " with id: " + selectedMember.getId());
            selectedBook.setAvailable(false);
        }
    }

    public void returnBook(String isbn, String memberId) {
        Member selectedMember = null;
        for (Member checkMember : listOfMembers) {
            if (memberId.equalsIgnoreCase(checkMember.getId())){
                selectedMember = checkMember;
                break;
            }
        }

        if (selectedMember == null) {
            System.out.println("Member not found");
            return;
        }

        Book selectedBook = null;
            for (Book book : selectedMember.getListOfBooks()) {
                if (isbn.equalsIgnoreCase(book.getIsbn())){
                    selectedBook = book;
                    break;
                }
            }

        if (selectedBook != null) {
            selectedBook.setAvailable(true);
            selectedMember.getListOfBooks().remove(selectedBook);
            System.out.println("Book returned successfully!");
        }
        else {
            System.out.println("Book not found for this member.");
        }

    }
}
