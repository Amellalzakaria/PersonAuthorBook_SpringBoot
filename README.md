 PersonneAuteurLivre_SpringBoot

## BookStore_application_SpringBoot
The Book Store Application is a web application that allows users to manage and search books and authors. The application offers the following features:  
Create, read, update, and delete authors and books.  
Find an author by their national ID number (CIN) or a book by its ISBN.  
Get all books of an author, all authors born on a specific date, and all books published between two dates.  
Assign a book to an author.  
The project will be developed using Agile methodology with short iterations to ensure good responsiveness to client requests. Unit and integration tests will be performed regularly throughout development to ensure code quality. Development will take place in a separate environment from the production environment.  

APIs to be implemented for the next session:  
Get all authors: GET /api/authors  
This API returns a list of all authors available in the database.  
Get an author by their CIN: GET /api/authors/cin/{cin}  
This API takes the national ID number (CIN) of an author as a parameter and returns the author's details.  
Create an author: POST /api/authors  
This API creates a new author using the details provided in the request body.  
Update an author: PUT /api/authors/{id}  
This API updates the details of an existing author using the ID provided in the URL and the details provided in the request body.  
Delete an author: DELETE /api/authors/{id}  
This API deletes the author with the specified ID from the database.  
Get all books: GET /api/books  
This API returns a list of all books available in the database.  
Get a book by its ISBN: GET /api/books/isbn/{isbn}  
This API takes the ISBN of a book as a parameter and returns the book's details.  
Create a book: POST /api/books  
This API creates a new book using the details provided in the request body.  
Update a book: PUT /api/books/{id}  
This API updates the details of an existing book using the ID provided in the URL and the details provided in the request body.  
Delete a book: DELETE /api/books/{id}  
This API deletes the book with the specified ID from the database.  
Get all books of an author: GET /api/authors/{id}/books  
This API takes the ID of an author as a parameter and returns a list of all books written by that author.  
Get all authors born on a specific date: GET /api/authors/birthdate/{birthdate}  
This API takes a date in the format yyyy-MM-dd as a parameter and returns a list of all authors born on that date.  
Get all books published between two dates: GET /api/books/published/{startDate}/{endDate}  
This API takes two dates in the format yyyy-MM-dd as parameters and returns a list of all books published between those dates.  
Assign a book to an author: PUT /api/authors/{authorId}/books/{bookId}  
This API assigns a book to an author using the IDs provided in the URL.  
Technologies used:  
Postman for testing, Eclipse, MySQL or PostgreSQL, Maven, and Spring Boot.  

To run the application, follow these steps:  
Clone the repository.  
Open the project in Eclipse.  
Run the application using Maven.  
Test the APIs using Postman.  
Deploy the application on a server, such as Tomcat or Jetty.  
Please refer to the documentation for more information about the APIs and how to use them.  
