package com.codingdojo.booksapi.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.booksapi.repositories.BookRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.booksapi.models.Book;

@Service
public class BookService {
    // adding the book repository as a dependency
	private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // Updates a Book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numPage) {
    	Book book = findBook(id);
    	if(book != null) {
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(numPage);
    	}
    	return bookRepository.save(book);
    }
    // Deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

