package ru.laalka.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));


//        List<Book> authorBooks = new ArrayList<>();
//        for (Book book : books){
//            if("Лев Толстой".equals(book.getAuthor())){
//                authorBooks.add(book);
//            }
//
//        System.out.println("Лев Толстой: " + authorBooks);

        List<Book> authorBooks = books.stream()
                .filter(book -> "Лев Толстой".equals(book.getAuthor())).toList();
        System.out.println("Лев Толстой: " + authorBooks);


//        List<Book> yearAfterBooks = new ArrayList<>();
//        for (Book book : books){
//            if(book.getYear() > 1866){
//                yearAfterBooks.add(book);
//            }
//        }
//        System.out.println("Книги после 1866: " + yearAfterBooks);
//
        List<Book> yearAfterBooks = books.stream()
                .filter(book -> book.getYear() > 1866).toList();
        System.out.println("Книги после 1866: " + yearAfterBooks);
//        List<String> uniqTitles = new ArrayList<>();
//        for (Book book : books){
//            if(uniqTitles.contains(book.getTitle())){
//                uniqTitles.add(book.getTitle());
//            }
//        }
//        System.out.println("Наименование книг: " + uniqTitles);

        List<String> uniqTitles = books.stream()
                .map(Book::getTitle).distinct().toList();
        System.out.println("Наименование книг: " + uniqTitles);
    }
}
