package kdu.quesfour;

import kdu.ConsoleLogger;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static void treeSetDemo(Comparator<Book> comparator) {

        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("The Last Lecture", "J.K.Rowling", 2008);
        Book book4 = new Book("Walden", "Henry David Thoreau", 1854);

        Set<Book> books = new TreeSet<>(comparator);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        for (Book book : books) {
            ConsoleLogger.infoMethod(book.toString());
        }

    }
    public static void main(String[] args){


        Comparator<Book> pubDateAscComparator = new PubDateAscComparator();
        Comparator<Book> pubDateDecComparator = new PubDateDecComparator();

        ConsoleLogger.infoMethod("Starting with NULL as an Argument");
        treeSetDemo(null);
        ConsoleLogger.infoMethod("\nStarting with Ascending as an Argument");
        treeSetDemo(pubDateAscComparator);
        ConsoleLogger.infoMethod("\nStarting with Decending as an Argument");
        treeSetDemo(pubDateDecComparator);

    }

}
