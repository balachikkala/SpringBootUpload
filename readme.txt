1. Download source code from https://github.com/balachikkala/SpringBootUpload.git
2. application.properties file has the default location of uploaded files.
   By default its set to C://test//. please make sure this path exists.
3. Run the application using "mvn spring-boot:run" from inside "demo.upload" folder or use an IDE like Spring tool suite to 
   launch main class "demo.upload.FileUploadDemo"
4. http://localhost:8080/upload is the home page to be navigated to.

Technical Aspects:
This application uses Spring Boot, Spring Data JPA, Apache Derby, thymeleaf.

Functionality:
Launch localhost:8080/upload and you should be able to add books with "title, author and document" and the table will automatically get updated.

About Code:

Book.java represents Entity.
BookRepository.java is the wrapper on CrudRepository which provides Spring Data JPA out of box CRUD operations.
BookService.java provides API to work with Book entity operations.
BookController.java is the RESTController which handles various GET/POST/PUT requests. Tested from postman.

Sample REST calls (tested via postman)
to get all books
GET - http://localhost:8080/books
GET book based on id  - http://localhost:8080/books/{bookId}


