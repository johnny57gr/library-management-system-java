package dev.lpa;

import java.util.List;

public class Member {

    private String name;
    private String id;
    private String email;
    private String phone;
    private List<Book> listOfBooks;

    public Member(String name, String id, String email, String phone, List<Book> listOfBooks) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.listOfBooks = listOfBooks;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", listOfBooks=" + listOfBooks +
                '}';
    }


    public void borrowBook(Book book){
        this.listOfBooks.add(book);
        System.out.println("Book borrowed by: " + this.name);
    }

    public void returnBook(Book book) {
        this.listOfBooks.remove(book);
        System.out.println("Book returned by: " + this.name);
    }
}
