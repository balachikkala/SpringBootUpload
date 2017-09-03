package demo.upload.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController - To test BookService functionality
 * @author BALU LEO
 *
 */
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public int addBook(@RequestBody List<Book> books)
	{
		 System.out.println(" inside addBook");
		 for (Book b : books)
		 {
			 
			 bookService.addBook(b);
		 }
		 
		
		return bookService.getAllBooks().size();
	
	}
	
	@RequestMapping(value="/books", method=RequestMethod.PUT)
	public void updateBook(@RequestBody Book book)
	{
		 System.out.println(" inside addBook");
		
		
		bookService.updateBook(book);
	
	}
	
	
	
	@RequestMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
		
	}
	
	@RequestMapping("/books/{bookId}")
	public Book getBook(@PathVariable String bookId)
	{
		return bookService.getBook(bookId);
		
	}		

}
