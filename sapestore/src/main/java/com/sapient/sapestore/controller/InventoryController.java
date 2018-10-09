/**
 * 
 */
package com.sapient.sapestore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.sapient.sapestore.model.AdminContent;
import com.sapient.sapestore.model.Book_Rating_Comments;
import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.OrderInfo;
import com.sapient.sapestore.model.OrderItemInfo;

/**
 * @author harsriva1
 *
 */

@Controller
public class InventoryController {

	@Autowired
	RestTemplate restTemplate;

	

	@Autowired
	private DiscoveryClient discoveryClient;

	private static final String inventoryServiceName = "book-service";
	private static final  String cartServiceName = "cart-service";
	private static final  String adminServiceName = "book-inventory";
	private URI getServiceURL(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null)
			return list.get(0).getUri();
		return null;
	}

	
	@GetMapping(value = "/addBookform")
	public String addBookForm() {
		return "addpage";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/addBook/uploadImage")
	public @ResponseBody String uploadImageToServer(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Instant currTimeStamp = Instant.now();
		
				String path = "D://new";
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				return serverFile.getName();
			} catch (Exception e) {
				return "You failed to upload => " + e.getMessage();
			}
		}
		return "";
	}

	
	@SuppressWarnings("unchecked")
	@GetMapping("/adminHome")
	public String adminPage(Model map, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (!customer.getAdmin()) {
			return "redirect:/error";

		}

		String uri3 = getServiceURL(inventoryServiceName) + "/getAll";

		String uri = getServiceURL("user-service") + "/register";
		List<Books> allBookList = restTemplate.getForObject(uri3, List.class);
		
		map.addAttribute("allBookList", allBookList);

	
		String uri1 = getServiceURL(inventoryServiceName) + "/categories";
		List<String> category = restTemplate.getForObject(uri1, List.class);
		map.addAttribute("category", category);

		return "adminHome";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(Books book, ModelMap map, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (!customer.getAdmin()) {
			return "redirect:/error";

		}
		String uri = getServiceURL(inventoryServiceName) + "/add-book";
		restTemplate.postForObject(uri, book, Books.class);
		map.addAttribute("book", book);
		return "redirect:/adminHome";
	}

	// ---------update method-----------

	@GetMapping("/editBook")
	public String editBook() {
		return "editbook";
	}

	@RequestMapping(value = "/editBookForm/{iSBN}", method = RequestMethod.GET)
	public ModelAndView editBookForm(@PathVariable("iSBN") Integer iSBN, HttpSession session) {
		
		ModelAndView modelView = new ModelAndView("redirect:/updateBook");
	
		String uri = getServiceURL(inventoryServiceName) + "/getByISBN/" + iSBN;
		Books book = restTemplate.getForObject(uri, Books.class);
		session.setAttribute("book", book);
	
		return modelView;

	}

	@GetMapping("/updateBook")
	public String updateBook() {

		return "updateBook";
	}

	@PostMapping("/updateBookForm")
	public String updateBookForm(Books book, ModelMap map,BindingResult result) {
		
		
		String uri = getServiceURL(inventoryServiceName) + "/update-book";
		 book = restTemplate.postForObject(uri, book, Books.class);
		map.addAttribute("book", book);

		return "redirect:/adminHome";

	}

	@RequestMapping(value = "/deleteBookform")
	public String ShowDeleteBookform() {
		return "deleteBook";
	}

	

	@GetMapping(value = "/deleteBook/{iSBN}")
	public String deleteBook(@PathVariable("iSBN") Integer iSBN) {
		
		String uri = getServiceURL(inventoryServiceName) + "/delete/" + iSBN;
		restTemplate.getForObject(uri, Books.class);
		return "redirect:/adminHome";

	}

	
	

	

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/categoryBookList/{category}")
	public String categoryBookList(@PathVariable("category") String category, Model model, HttpSession session) {
		String uri = getServiceURL(inventoryServiceName) + "/booksByCategory/" + category;
		List<Books> categoryBooks = restTemplate.getForObject(uri, List.class);
	

		String uri1 = getServiceURL(inventoryServiceName) + "/categories";
		List<String> categoryList = restTemplate.getForObject(uri1, List.class);
		model.addAttribute("categoryList", categoryList);
	
		model.addAttribute("categoryBooks", categoryBooks);
		model.addAttribute("selectedCategory", category);
	
		return "categoryBooksList";

	}

	@GetMapping("/categoryList")
	public String categoryList() {

		return "categoryBooksList";
	}

	

	

	@GetMapping("reportDisplay")
	public String reportDisplay() {
		return "report";
	}

	@GetMapping(value = "/reportManagement")
	public String reportManagement(@RequestParam("dateto") String dateTo, @RequestParam("datefrom") String dateFrom,
			Model model, OrderInfo orderInfo) throws ParseException {
		
		
		
		String uri = getServiceURL(cartServiceName) + "/get-order-dates/" + dateTo +"/"+ dateFrom;
		List<OrderInfo> orders = restTemplate.getForObject(uri, List.class);
	
		if(orders.isEmpty())
		{
			model.addAttribute("errorMsg","Sorry!! The Orders are not available in-between the given dates..");
		}
		else
		{
			model.addAttribute("orderList", orders);
		}
				
		return "report";
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/searchresult")
	public @ResponseBody List<Books> searchresult(@RequestParam("title") String title, @RequestParam("author") String author,
			@RequestParam("category") String category, @RequestParam("publisher") String publisher, Model model) {
		
	
	title = title==null?" ":title.trim();
	author = author==null?" ":author.trim();
	category = category==null?" ":category.trim();
	publisher = publisher==null?" ":publisher.trim();
	publisher = " ".equals(publisher)?"/":publisher.trim();
	
	
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getServiceURL(inventoryServiceName) + "/search")
		        .queryParam("title", title)
		        .queryParam("author", author)
		        .queryParam("category", category)
		        .queryParam("publisher", publisher);
		        
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<List> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        List.class);
		
		
		model.addAttribute("searchList", response.getBody());
	List<Books> searchList=(List<Books>) response.getBody();
	if(searchList.isEmpty()) {
		model.addAttribute("error", "No Books Found");
	}
	
		return (List<Books>) response.getBody();
	
	}
	
	
	@RequestMapping(value = "/trackOrder")
	public String trackOrder() {

		return "orderIdStatus";
	}

	@RequestMapping(value = "/ordertrackingbyorderid", method = RequestMethod.GET)
	public String ordertrackingbyorderid(@RequestParam("orderId") Integer orderid, OrderInfo orderInfo, Model model
			) {

		
		String uri = getServiceURL(cartServiceName) + "/get-order-tracking/" + orderid;
		try {
		OrderInfo OrderById = restTemplate.getForObject(uri, OrderInfo.class);
	
		model.addAttribute("order", OrderById);
		}
		catch(Exception e)
		{
			String errorMessage ="Sorry!! The given OrderId is not available.."; 
			
		   model.addAttribute("errorMessage",errorMessage);
		
		}
		
		return "orderIdStatus";
	}



	@SuppressWarnings("unchecked")
	@GetMapping(value = "/orderList")
	public ModelAndView trackAllOrder(OrderItemInfo orderItemInfo, ModelMap model, HttpSession session) {
		String uri = getServiceURL(cartServiceName) + "/getAllOrderItems";
		
		List<OrderItemInfo> orderItems= restTemplate.getForObject(uri, List.class);
		
		ModelAndView mv = new ModelAndView("orderlist");
		model.addAttribute("allorder", orderItems);
		
		return mv;
	}
	

	
	@RequestMapping(value="/dispatch/{orderItemId}")
	public String dispatch(@PathVariable("orderItemId") Integer orderItemId,Model model) {
		
		
		String uri = getServiceURL(cartServiceName) + "/update-order-dispatched/"+orderItemId;
		
		if(restTemplate.getForObject(uri, Boolean.class))
	{
			model.addAttribute("sucess", "status updated");
			}
		else {
			model.addAttribute("error","Something went wrong");
		}
		
		return "redirect:/orderList";
		
	}
	
	@RequestMapping(value="/deliver/{orderItemId}")
	public String deliver(@PathVariable("orderItemId") Integer orderItemId,Model model) {
		
	
		String uri = getServiceURL(cartServiceName) + "/update-order-delivered/"+orderItemId;
		
		if(restTemplate.getForObject(uri, Boolean.class))
	{
			model.addAttribute("sucess", "status updated");
			}
		else {
			model.addAttribute("error","Something went wrong");
		}
		
		return "redirect:/orderList";
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/productdescription/{iSBN}")
	public String productdescription(@PathVariable("iSBN") Integer iSBN, ModelMap model) {
		
		String uri = getServiceURL(inventoryServiceName) + "/getByISBN/" + iSBN;
		Books productList = restTemplate.getForObject(uri, Books.class);

		model.addAttribute("productList", productList);
		String uri2 = getServiceURL(inventoryServiceName) + "/books/get-book-rating-comment";
		List<Book_Rating_Comments> commentsList = Arrays
				.asList(restTemplate.getForObject(uri2, Book_Rating_Comments[].class));

		List<String> bookCommentsList = new ArrayList<>();
		List<Integer> ratingList = new ArrayList<>();
		List<String> userList = new ArrayList<>();

		int length = 0;
		for (Book_Rating_Comments bookComments : commentsList) {
			if (bookComments.getBooks().getiSBN().intValue() == productList.getiSBN().intValue()) {

				bookCommentsList.add(bookComments.getBook_comment());
				ratingList.add(bookComments.getBook_rating());
				ratingList.add(bookComments.getBook_rating());
				length = ratingList.size();
				double rating = 0;
				if (length == 0) {
					rating = 1;
				} else
					rating = (ratingList.stream().mapToInt(Integer::intValue).sum()) / length;

				if (rating == 1) {

					model.addAttribute("rating", "Not enough rating yet");
				}
				model.addAttribute("rating", rating);
				model.addAttribute("productList", productList);
				
				model.addAttribute("bookCommentsList", bookCommentsList);

			}
		}
		String uri1 = getServiceURL(inventoryServiceName) + "/categories";
		List<String> category = restTemplate.getForObject(uri1, List.class);
		model.addAttribute("category", category);
		return "productDescription";
	}
	
	@GetMapping(value="/manageDetailPage")
	public String manageDetailPage(AdminContent admindetail,Model model)
	{
		
		Integer detailId=1;
		
		String uri = getServiceURL(adminServiceName) + "/detail-by-detailId/"+detailId;
		admindetail=restTemplate.getForObject(uri,AdminContent.class);
		String p_detail=admindetail.getPrivacydetail();
		String contact_detail = admindetail.getContactdetail();
		model.addAttribute("privacy_detail",p_detail);
		model.addAttribute("contact_detail", contact_detail);
		return "managePage";
	}
	@PostMapping(value="/privacyPolicyContact")
	public ModelAndView privacyPolicyContact(AdminContent admincontent)
	{
		
		System.out.println("Entering11"+admincontent);
		
			String uri = getServiceURL(adminServiceName) + "/updatedetail";
			restTemplate.postForObject(uri, admincontent, AdminContent.class);
			return new ModelAndView("redirect:/manageDetailPage");
	
		
	} 
	
	@GetMapping(value="/privacyPage")
	public String privacyPage(AdminContent admindetail,Model model)
	{
		Integer detailId=1;
		String uri = getServiceURL(adminServiceName) + "/detail-by-detailId/"+detailId;
		admindetail=restTemplate.getForObject(uri,AdminContent.class);
		String p_detail=admindetail.getPrivacydetail();
		model.addAttribute("privacy_detail",p_detail);
		return "privacy";
		
	}
	
	@GetMapping(value="/contactPage")
	public String contactPage(AdminContent admindetail,Model model)
	{
		Integer detailId=1;
		String uri = getServiceURL(adminServiceName) + "/detail-by-detailId/"+detailId;
		admindetail=restTemplate.getForObject(uri,AdminContent.class);
		String contact_detail = admindetail.getContactdetail();
		model.addAttribute("contact_detail",contact_detail);
		return "contactus";
		
	}

	
}