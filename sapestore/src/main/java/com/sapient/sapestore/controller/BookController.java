package com.sapient.sapestore.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sapient.sapestore.model.Book_Rating_Comments;
import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.Customer;

@Controller
public class BookController {

       @Autowired
       RestTemplate restTemplate;

       @Autowired
       private DiscoveryClient discoveryClient;

       private  final String bookServiceName = "book-service";
       private  final String userServiceName = "user-service";

       private Logger logger = LoggerFactory.getLogger(BookController.class);

       private URI getServiceURL(String service) {
              List<ServiceInstance> list = discoveryClient.getInstances(service);
              if (list != null && list.size()>0)
                     return list.get(0).getUri();
              return null;
       }

       @SuppressWarnings("unchecked")
	@RequestMapping("/all-books")
       public String home1(Model model) {
              String uri = getServiceURL(bookServiceName) + "/books";
              logger.info(uri);
              List<Books> bookList = restTemplate.getForObject(uri, List.class);
              model.addAttribute("bookList", bookList);
              return "home";
       }

       @SuppressWarnings("unchecked")
	@RequestMapping("/top-rated")
       public @ResponseBody String getBooksByRating(@PathVariable("rating") int rating, ModelMap map) {
              String uri = getServiceURL(bookServiceName) + "/books/top-rated";
              List<Books> categoryList = restTemplate.getForObject(uri, List.class);
              map.addAttribute("categoryList", categoryList);
              return "home";
       }

       @SuppressWarnings("unchecked")
	@RequestMapping("/all-books-by-category/{category}")
       public String getBooksByCategory(@PathVariable("category") String category, ModelMap model, HttpSession session) {
              String uri2 = getServiceURL(bookServiceName) + "/books/categories";
              List<String> categoriesList = restTemplate.getForObject(uri2, List.class);
              model.addAttribute("categoriesList", categoriesList);
              model.addAttribute("selectedCategory", category);

              String uri = getServiceURL(bookServiceName) + "/books/books-by-categories/" + category;
              logger.info(category);
              List<Books> bookList = Arrays.asList(restTemplate.getForObject(uri, Books[].class));
              List<Book_Rating_Comments> bookRatingComments;
              double sumOfRating = 0.0;
              double averageRating = 0.0;
              logger.info("Book List {}", bookList);
              for (Books book : bookList) {

                     String uri3 = getServiceURL(bookServiceName) + "getCoomnetsByISBN/" + book.getiSBN();
                     bookRatingComments = Arrays.asList(restTemplate.getForObject(uri3, Book_Rating_Comments[].class));
                     logger.info("THIS IS BOOKRATING COMMENTS LIST {}", bookRatingComments);
                     int counter = 0;
                     for (int i = 0; i < bookRatingComments.size(); i++) {
                           Book_Rating_Comments obj = bookRatingComments.get(i);
                           sumOfRating += obj.getBook_rating();
                           counter++;
                     }
                     logger.info("sum of rating:{}", sumOfRating);
                     averageRating = Math.floor(sumOfRating / counter);
                     if (counter == 0) {
                           book.setAvgRating(0.0);
                     } else {
                           book.setAvgRating(averageRating);
                     }
                     sumOfRating = 0;
                     logger.info("avearge rating:........ is {}", book.getAvgRating());
              }

              logger.info("{}", bookList);
              model.addAttribute("bookList", bookList);
              return "home";

       }

       @RequestMapping("/one-book/{ISBN}")
       public String getBookDetail(@PathVariable("ISBN") Integer isbn, ModelMap model, HttpSession session) {
              String uri = getServiceURL(bookServiceName) + "/books-by-ISBN/" + isbn;
              Books book = restTemplate.getForObject(uri, Books.class);
              model.addAttribute("book", book);
              session.setAttribute("book", book);
              return "redirect:/bookDetail";
       }

       @SuppressWarnings("unchecked")
	@GetMapping("/bookDetail")
       public String getBookDetailOnceAgain(ModelMap model, HttpSession session) {
              String uri = getServiceURL(bookServiceName) + "/books/categories";
              List<String> categoryList = restTemplate.getForObject(uri, List.class);
              Books book = (Books) session.getAttribute("book");
              Customer user = (Customer) session.getAttribute("customer");

              String uri2 = getServiceURL(bookServiceName) + "/books/categories";
              List<String> categoriesList = restTemplate.getForObject(uri2, List.class);
              model.addAttribute("categoriesList", categoriesList);

              logger.info("{}", categoryList);
              model.addAttribute("categoriesList", categoryList);
              model.addAttribute("book", book);
              model.addAttribute("user", user);

              String category = book.getCategory();
              model.addAttribute("selectedCategory", category);

              uri = getServiceURL(bookServiceName) + "getCoomnetsByISBN/" + book.getiSBN();
              List<Book_Rating_Comments> commnets = Arrays
                           .asList(restTemplate.getForObject(uri, Book_Rating_Comments[].class));
              Customer customer = null;
              List<Integer> ratingList = new ArrayList<>();
              int length = 0;

              for (Book_Rating_Comments bookComments : commnets) {
                     if (bookComments.getBooks().getiSBN().intValue() == book.getiSBN().intValue()) {
                           ratingList.add(bookComments.getBook_rating());
                     }

              }
              length = ratingList.size();
              double averageRating = 0;
              boolean testRating = true;
              if (length == 0) {
                     testRating = false;
              } else {
                     averageRating = (double) (ratingList.stream().mapToInt(Integer::intValue).sum()) / length;
              }
              if (testRating == false) {
                     model.addAttribute("averageRating", 0.0);
              } else
                     model.addAttribute("averageRating", averageRating);
              logger.info("AVERAAAAAAGE RAAAAATING  ::::::{}", averageRating);
              for (Book_Rating_Comments comment : commnets) {
                     uri = getServiceURL(userServiceName) + "user/" + comment.getUserId();
                     customer = restTemplate.getForObject(uri, Customer.class);
                     comment.setUserName(customer.getName());

              }
              model.addAttribute("comments", commnets);

              logger.info("****************comments {}", commnets);

              return "bookDetail";

       }

       @RequestMapping("/books-with-title")
       public String searchBooksBytitle(@RequestBody Books book, ModelMap map) {
              String uri = getServiceURL(bookServiceName) + "/books-by-title/" + book.getTitle();
              Books book1 = restTemplate.getForObject(uri, Books.class);
              map.addAttribute("book", book1);
              return "home";
       }

       @SuppressWarnings("unchecked")
	@RequestMapping(value = "/books/categories")
       public String home(Model model) {
              String uri = getServiceURL(bookServiceName) + "/books/categories";
              List<String> categorylist = restTemplate.getForObject(uri, List.class);
              model.addAttribute("categorylist", categorylist);
              return "bookDetail";
       }

       @GetMapping(value = "/review")
       public String reviewPage() {
              logger.info("Hello review");
              return "review";

       }

       @PostMapping(value = "/add-comment")
       public String addingCommentAndReview(Book_Rating_Comments comment5, ModelMap model, HttpSession session,
                     @RequestParam("comment") String comment, @RequestParam("rating") Integer rating) {
              logger.info("entering into controller");
              Books book = (Books) session.getAttribute("book");
              Customer customer = (Customer) session.getAttribute("customer");

              comment5.setBooks(book);

              if (customer == null) {
                     return "loginerror";
              }
              comment5.setUserId(customer.getUserId());
              comment5.setBook_comment(comment);
              comment5.setBook_rating(rating);

              String uri = getServiceURL(bookServiceName) + "/books/add-comment-rating";
              restTemplate.postForObject(uri, comment5, Book_Rating_Comments.class);

              model.addAttribute("success", "Review is added");

              return getBookDetailOnceAgain(model, session);

       }

       @SuppressWarnings("unchecked")
       @GetMapping(value = "/searchaction")
       public String searchresult(@RequestParam("title") String title, @RequestParam("author") String author,
                     @RequestParam("category") String category, @RequestParam("publisher") String publisher, Model model,
                     HttpSession session) {
              session.setAttribute("searchList", null);
              String uri = getServiceURL(bookServiceName) + "/search1/" + title + "/" + author + "/" + category + "/"
                           + publisher;

              logger.info(title);
              logger.info(author);

              List<Books> searchList = restTemplate.getForObject(uri, List.class);
              logger.info("{}", searchList);
              logger.info("hello");
              logger.info("byeeeeeee");
              session.setAttribute("searchList", searchList);
              return "searchBook";
       }

       @GetMapping("/searchBook")
       public String searchBookPage() {
              return "searchBook";
       }
       @SuppressWarnings("unchecked")
       @GetMapping(value = "/userSearchResult")
       public @ResponseBody List<Books> userSearchResult(@RequestParam("title") String title, @RequestParam("author") String author,
                     @RequestParam("category") String category, @RequestParam("publisher") String publisher, Model model) {
              
       System.out.println("entered my controlledrrr/..");
       
       title = title==null?" ":title.trim();
       author = author==null?" ":author.trim();
       category = category==null?" ":category.trim();
       publisher = publisher==null?" ":publisher.trim();
       publisher = " ".equals(publisher)?"/":publisher.trim();
       
              HttpHeaders headers = new HttpHeaders();
              headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
              System.out.println("before rest ");
              UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getServiceURL(bookServiceName) + "/search")
                      .queryParam("title", title)
                      .queryParam("author", author)
                      .queryParam("category", category)
                      .queryParam("publisher", publisher);
                      
              System.out.println("uriuriuriuriuri: "+builder.toUriString());
              HttpEntity<?> entity = new HttpEntity<>(headers);

              HttpEntity<List> response = restTemplate.exchange(
                      builder.toUriString(), 
                      HttpMethod.GET, 
                      entity, 
                      List.class);
              
              System.out.println("response1111111111111111: "+response.getBody());
              
              model.addAttribute("searchList", response.getBody());
              System.out.println(response.getBody());
       List<Books> searchList=(List<Books>) response.getBody();
       if(searchList.isEmpty()) {
              model.addAttribute("error", "No Books Found");
       }
       
       System.out.println((List<Books>) response.getBody());
              return (List<Books>) response.getBody();
       
       }


}

