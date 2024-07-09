package com.alurachallenge.library.main;

import com.alurachallenge.library.model.Author;
import com.alurachallenge.library.model.Book;
import com.alurachallenge.library.model.BookData;
import com.alurachallenge.library.model.Data;
import com.alurachallenge.library.repository.BookRepository;
import com.alurachallenge.library.service.ConvertData;
import com.alurachallenge.library.service.UseAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Boolean loop = true;
    private Scanner keyboard = new Scanner(System.in);
    private UseAPI useAPI = new UseAPI();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private static final String URL_SEARCH = "?search=";
    private ConvertData converter = new ConvertData();
    private BookRepository repository;
    private String bookTitle = null;
    private List<Book> books;
    private List<Author> authors;
    private List<String> language;

    public Main(BookRepository repository) {
        this.repository = repository;
    }


    public void showMenu() {
        while(loop == true){

            System.out.println("""
                ------------Library------------
                1- Search book by Title.
                2- List registered books.
                3- List registered authors.
                4- Search living authors by year.
                5- List books by language.\n
                6- Exit.
                -------------------------------\n""");

            var menuOption = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuOption){
                case 1:
                    getBookData();
                    break;
                case 2:
                    showRegisteredBooks();
                    break;
                case 3:
                    showRegisteredAuthors();
                    break;
                case 4:
                    showLivingAuthorsByYear();
                    break;
                case 5:
                    showBooksByLanguage();
                    break;
                case 6:
                    System.out.println("Thank you for working with us. Have a great day!");
                    loop=false;
                    break;
                default:
                    System.out.println("Option Not Found...\n");
            }

        }
    }

    private void getBookData(){
        //BUSCANDO LIBRO POR NOMBRE
        System.out.println("Enter the title of the book:");
        bookTitle = keyboard.nextLine();
        var json = useAPI.getData(URL_BASE + URL_SEARCH + bookTitle.toLowerCase().replace(" ", "+"));
        var foundData = converter.getData(json, Data.class);
        System.out.println(foundData + "\n");

        // foundData da como resultado una lista de BookData
        Optional<BookData> searchBook = foundData.results().stream()
                .filter(b -> b.title().toLowerCase().contains(bookTitle.toLowerCase()))
                .findFirst();
        if (searchBook.isPresent()){
            System.out.println("\n ¡Book Found! \n");
            System.out.println(searchBook.get());
        }else {
            System.out.println("\n The Book was Not Found...\n");
        }

        Book book = new Book(searchBook.get());
        repository.save(book);
    }

    private void showRegisteredBooks(){
        books = repository.findAll();
        books.forEach(System.out::println);
    }

    private void showRegisteredAuthors() {
        books = repository.findAll();
        books.forEach(b -> b.getAuthor().forEach(System.out::println));

    }

    private void showLivingAuthorsByYear() {
        System.out.println("Enter the year to search: ");
        var yearSearch = keyboard.nextLine();
        List<Author> livingAuthors = repository.livingAuthorsbyYear(yearSearch);
        System.out.println("\nLIVING AUTHORS in year " + yearSearch + ":");
        livingAuthors.forEach(s-> System.out.println("----------------------------------------\n" +
                                                    "Author: " + s.getName() + "\n " +
                                                    "Year of Birth: " + s.getYearOfBirth() + "\n" +
                                                    "Year of Death:" + s.getYearOfDeath() + "\n" +
                                                    "----------------------------------------\n"));
    }

    private void showBooksByLanguage(){

            System.out.println("""
                ---------------------------
                Choose a Language:
                1- English.
                2- Spanish.
                3- Finnish.
                4- Polish.
                
                5- Previous menu <--
                ---------------------------
                """);
            var choseLanguage = keyboard.nextLine();

            switch (choseLanguage){
                case "1":
                    String[] language = {"en"};
                    BooksByLanguage(List.of(language));
                    showBooksByLanguage();
                    break;
                case "2":
                    language = new String[]{"es"};
                    BooksByLanguage(List.of(language));
                    showBooksByLanguage();
                    break;
                case "3":
                    language = new String[]{"fi"};
                    BooksByLanguage(List.of(language));
                    showBooksByLanguage();
                    break;
                case "4":
                    language = new String[]{"po"};
                    BooksByLanguage(List.of(language));
                    showBooksByLanguage();
                    break;
                case "5":
                    System.out.println("Going back to the fist menu...\n");
                    break;
                default:
                    System.out.println("Not available option.\n");
                    showBooksByLanguage();
                    break;
            }
    }
    private void BooksByLanguage(List<String> language) {
        List<Book> bookList = repository.booksByLanguage(language);
        if (!bookList.isEmpty()){
            bookList.forEach(System.out::println);
        }else {
            System.out.println("\n Sorry. We did not found any book in that Language.\n");
        }
    }
}
