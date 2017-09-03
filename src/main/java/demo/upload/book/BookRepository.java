package demo.upload.book;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository provides out of box operations
 * @author BALU LEO
 *
 */
public interface BookRepository extends CrudRepository<Book, String> {
	
	/**
	 * TODO : Add custom methods 
	 */

}
