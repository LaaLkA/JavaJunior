package ru.laalka.Task1;

public class Book {
    //region Конструкторы
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    //endregion

    //region Методы


    @Override
    public String toString() {
        return "Book{" +
                "Наименование:'" + title + '\'' +
                ", Автор:'" + author + '\'' +
                ", Год выпуска:" + year +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    //endregion

    //region Поля
    private final String title;
    private final String author;
    private final int year;
    //endregion
}
