1. Download source code from https://github.com/balachikkala/SpringBootUpload.git
2. application.properties file has the default location of uploaded files.
   By default its set to C://test//.
3. Run the application using "mvn spring-boot:run" from inside "demo.upload" folder or use an IDE like Spring tool suite to 
   launch main class "demo.upload.FileUploadDemo"
4. http://localhost:8080/upload is the home page to be navigated to.
5. This application uses Spring Boot, Spring Data JPA, Apache Derby, thymeleaf.


Book.java represents Entity.
BookRepository.java is the wrapper on CrudRepository which provides Spring Data JPA out of box CRUD operations.
BookService.java provides API to work with Book entity operations.
BookController.java is the RESTController which handles various GET/POST/PUT requests. Tested from postman.
