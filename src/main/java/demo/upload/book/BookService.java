package demo.upload.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return books;
	
	}

	/**
	 * addBook record using bookRepository methods
	 * @param book
	 */
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

	public Book getBook(String bookId) {		
		return bookRepository.findOne(bookId);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

}
