package demo.upload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import demo.upload.book.Book;
import demo.upload.book.BookService;

/**
 * FileUploadDemoController
 * @author BALU LEO
 *
 */
@Controller
public class FileUploadDemoController {
	
	@Value("${fileupload.path}")
	private String UPLOAD_FOLDER;
	
	@Autowired
	private BookService bookService;
	
	/**
	 * home page to upload
	 * http://localhost:8080/upload
	 * @param model
	 * @return 
	 */
	@RequestMapping("/upload")
	public String welcome(Map<String, Object> model) {
		model.put("allBooks", bookService.getAllBooks());
		return "upload";
	}
	
	
	/**
	 * addBook
	 * @param bookAuthor
	 * @param bookTitle
	 * @param file
	 * @return ModelAndView
	 */
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView addBook(@RequestParam(value="author") String bookAuthor, @RequestParam(value="title") String bookTitle, 
			@RequestParam(value="uploadfile") MultipartFile file)
	{
		System.out.println(" FileUploadDemoController inside addBook POST method bookAuthor" + bookAuthor + " "  + bookTitle);
		
		Book b = new Book(bookAuthor, bookTitle);
		bookService.addBook(b);
		
		if (uploadFile(file))
		{
			
			return new ModelAndView("redirect:/upload", "message", "File Uploaded sucessfully");
		}
		else
		{
			
			return new ModelAndView("status", "message", "Please select a file and try again");
		}
	}


	private boolean uploadFile(MultipartFile file) {
		if (file.isEmpty()) {
			return false;
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
}
