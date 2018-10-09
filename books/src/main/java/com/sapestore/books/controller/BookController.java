package com.sapestore.books.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sapestore.books.dao.IBookRatingComments;
import com.sapestore.books.dao.IBookRepository;
import com.sapestore.books.exception.AuthorNotFoundException;
import com.sapestore.books.exception.BookNotFoundException;
import com.sapestore.books.exception.CategoryNotFoundException;
import com.sapestore.books.model.Book_Rating_Comments;
import com.sapestore.books.model.Books;
import com.sapestore.books.service.BookService;

@RestController
public class BookController {

       @Autowired
       IBookRepository bookRepository;
       @Autowired
       IBookRatingComments ratingRepository;
       @Autowired
       RestTemplate restTemplate;

       @Autowired
       BookService bookservice;

       private Logger logger = LoggerFactory.getLogger(BookController.class);

       @GetMapping(value = "/books")
       public List<Books> welcomeUser() {

              logger.info("============================");
              logger.info("{}", bookRepository.findAll());
              return bookRepository.findAll();
       }

       @GetMapping(value = "/books/top-rated")
       public List<Books> getBooksByTopRated() {

              List<Books> books = bookRepository.findByActive(true);
              List<Books> resultBooks = new ArrayList<>();
              for (Books book : books) {

                     List<Book_Rating_Comments> comments = book.getCommentsList();
                     if (comments != null) {
                           for (Book_Rating_Comments comment : comments) {
                                  if (comment.getBook_rating() > 3) {
                                         resultBooks.add(book);
                                  }

                           }
                     }

              }
              logger.info("jobs done? {}", !resultBooks.isEmpty());
              return resultBooks.stream().distinct().collect(Collectors.toList());
       }

       @GetMapping("/books/books-by-categories/{category}")
       public List<Books> getCategories(@PathVariable("category") String category) {
              logger.info("===================================");
              logger.info("{}", bookRepository.findBooksByCategoryAndActive(category,true));
              return bookRepository.findBooksByCategoryAndActive(category,true);
       }

       @GetMapping("/books/categories")

       public List<String> getCategories1() {
              List<Books> bookList = bookRepository.findAll();
              List<String> categories = new ArrayList<>();
              for (Books book : bookList) {
                     categories.add(book.getCategory());
              }

              logger.info("{}", categories);
              return categories.stream().distinct().collect(Collectors.toList());
       }

       @GetMapping(value = "/books-by-ISBN/{ISBN}")
       public Books getBookByISBN(@PathVariable("ISBN") Integer isbn) {
              return bookRepository.findById(isbn).get();

       }

       @GetMapping(value = "/books-by-title/{title}")
       public List<Books> getBookByTitle(@PathVariable("title") String title) {
              return bookRepository.findBooksByTitle(title);

       }

       @GetMapping("/books/get-book-rating-comment")
       public List<Book_Rating_Comments> getBooksByRatingAndComments() {

              return ratingRepository.findAll();

       }

       @PostMapping("/books/add-comment-rating")
       public void addBookCommentRating(@RequestBody Book_Rating_Comments bookRating) {

              logger.info("REST service: Book_Rating_Comments: {} ", bookRating);
              bookRating.setBook_comment_date(new Timestamp(System.currentTimeMillis()));
              ratingRepository.save(bookRating);
       }

       @PostMapping(value = "/add-book")
       void AddingBooks(@RequestBody Books book, BindingResult resultl) {
              logger.info(book.getAuthor());
              bookservice.addBook(book);
       }

       @RequestMapping(value = "/update-book")
       public Books UpdatingBooks(@RequestBody Books book) {
              logger.info("hello {}", book);
              logger.info("{}", book.getiSBN());

              return bookservice.updateBook(book);

       }

       @GetMapping("/deleteBook/{ iSBN }")
       public String deleteBook(@PathVariable("iSBN") Integer iSBN, Model model) throws BookNotFoundException {

              bookservice.deleteBook(iSBN);

              return "admin";

       }

       @GetMapping(value = "/getByISBN/{iSBN}")
       public Books getOne(@PathVariable("iSBN") int iSBN) {
              logger.info("{}", iSBN);
              Books book1 = bookservice.getBookByISBN(iSBN);
              logger.info("{}", book1);
              return book1;

       }

       @GetMapping(value = "/getAll")
       public List<Books> getAllBooks() {
              return bookservice.getAllBook();

       }

       @GetMapping(value = "/booksByTitle/{title}")
       public List<Books> BookByTitle(@PathVariable("title") String title) throws BookNotFoundException {
              logger.info(title);
              List<Books> book1 = bookservice.getBookBytitle(title);
              logger.info("{}", book1);
              return book1;

       }

       @GetMapping(value = "/booksByAuthor/{author}")
       public List<Books> BookByauthor(@PathVariable("author") String author) throws AuthorNotFoundException {
              logger.info(author);
              List<Books> book1 = bookservice.getBookByAuthor(author);
              logger.info("{}", book1);
              return book1;

       }

       @GetMapping(value = "/booksByCategory/{category}")
       public List<Books> BookByCategory(@PathVariable("category") String category) throws CategoryNotFoundException {
              logger.info(category);
              List<Books> book1 = bookservice.getBookByCategory(category);
              logger.info("{}", book1);
              return book1;

       }

       @GetMapping(value = "/getCoomnetsByISBN/{isbn}")
       public List<Book_Rating_Comments> getCoomnetsByISBN(@PathVariable("isbn") Integer isbn) {
              return bookRepository.findById(isbn).get().getCommentsList();
       }

       @GetMapping(value = "/search1/{title}/{author}/{category}/{publisher}")
       public List<Books> searchHomeBook(@PathVariable("title") String title, @PathVariable("author") String author,
                     @PathVariable("category") String category, @PathVariable("publisher") String publisher, Model model) {
              List<Books> allBookList = bookservice.getAllBook();
              logger.info("checkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
              logger.info(title);
              logger.info(author);
              logger.info(publisher);
              logger.info(category);
              List<Books> searchedBookList = allBookList.stream()
                           .filter((Books b) -> title.equals(b.getTitle()) || author.equals(b.getAuthor())
                                         || category.equals(b.getCategory()) || publisher.equals(b.getPublisher()))
                           .collect(Collectors.toList());
              logger.info("{}", searchedBookList);
              return searchedBookList;

       }

       @GetMapping(value = "/search")
       public List<Books> searchBook(@RequestParam("title") String title, @RequestParam("author") String author,
                     @RequestParam("category") String category, @RequestParam("publisher") String publisher) {
              List<Books> allBookList = bookservice.getAllBook();
              logger.info("check");
              logger.info(title);
              logger.info(author);
              logger.info(publisher);
              logger.info(category);
              List<Books> searchedBookList = allBookList.stream()
                           .filter((Books b) -> title.equals(b.getTitle()) || author.equals(b.getAuthor())
                                         || category.equals(b.getCategory()) || publisher.equals(b.getPublisher()))
                           .collect(Collectors.toList());
              logger.info("{}", searchedBookList);
              return searchedBookList;
       }

       @GetMapping("/delete/{iSBN}")
       public void delete(@PathVariable("iSBN") Integer iSBN) throws BookNotFoundException {
              logger.info("REST {}", iSBN);

              bookservice.deleteBook(iSBN);

       }

       @GetMapping("/categories")
       public Set<String> getCategories() {
              List<Books> bookList = bookservice.getAllBook();
              Set<String> categories = new HashSet<>();
              for (Books book : bookList) {
                     categories.add(book.getCategory());
              }
              logger.info("{}", categories);
              return categories;
       }

}

