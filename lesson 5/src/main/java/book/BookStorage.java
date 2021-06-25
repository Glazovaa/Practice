package book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

class Book {
    private int ID;
    private String name;
    private String author;
    private int age;

    public Book(int ID, String name, String author, int age) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.age = age;
    }
    public Book() {

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

@Component
class BookStorage {
    ArrayList<Book> booksArray;
    int ID = 1;
    public BookStorage() {
        booksArray = new ArrayList<>();
    }

    public ArrayList<Book> testList() {
        return booksArray;
    }

    public boolean isEmpty() {
        if (booksArray.isEmpty()) {
            return true;
        }
        return false;
    }

    public void add(String name, String author, int age) {
        booksArray.add(new Book(ID++,name, author, age));
    }

    public ArrayList<Book> get() {
        return booksArray;
    }

    public void removeID(int ID) {
        booksArray.removeIf(p -> p.getID() == ID);
    }
}