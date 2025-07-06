    package com.library;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    // @Service
    public class BookService {
        private BookRepository bookRepository;
        private String libraryName;
        // @Autowired
        public void setBookRepository(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
            System.out.println("Setter injection: BookRepository set");
        }
        public BookService(String libraryName) {
            this.libraryName = libraryName;
            System.out.println("Constructor injection: libraryName = " + libraryName);
        }
        public void printBookTitle() {
            System.out.println("Book title: " + bookRepository.getBookTitle());
        }
    }
