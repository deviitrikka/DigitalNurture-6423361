package exercise6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSearch {

    // Book class with attributes
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Linear search method
    public static Book linearSearchByTitle(List<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary search method (assuming the list is sorted by title)
    public static Book binarySearchByTitle(List<Book> books, String targetTitle) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.title.compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Main method to demonstrate both searches
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(101, "The Hobbit", "J.R.R. Tolkien"));
        bookList.add(new Book(102, "To Kill a Mockingbird", "Harper Lee"));
        bookList.add(new Book(103, "1984", "George Orwell"));
        bookList.add(new Book(104, "Pride and Prejudice", "Jane Austen"));
        bookList.add(new Book(105, "Moby-Dick", "Herman Melville"));

        // Linear search example
        String searchTitle1 = "1984";
        Book result1 = linearSearchByTitle(bookList, searchTitle1);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Book not found"));

        // Sort list before binary search
        Collections.sort(bookList, Comparator.comparing(book -> book.title.toLowerCase()));

        // Binary search example
        String searchTitle2 = "Pride and Prejudice";
        Book result2 = binarySearchByTitle(bookList, searchTitle2);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Book not found"));
    }
}
