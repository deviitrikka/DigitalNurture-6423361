package com.library;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try (org.springframework.context.support.ClassPathXmlApplicationContext context = new org.springframework.context.support.ClassPathXmlApplicationContext(
                "applicationContext.xml")) {
            BookService bookService = (BookService) context.getBean("bookService");
            bookService.printBookTitle();
        }
    }
}
