package com.sapient.sapestore.controller;


import java.net.URI;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.sapestore.model.Books;
import com.sapient.sapestore.model.Customer;
import com.sapient.sapestore.model.Message;

@Controller
public class AccountController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;


	private final String userServiceName = "user-service";
	private final String bookServiceName = "book-service";

	@Autowired
	private SmtpMailSender smtpMailSender;

	private URI getServiceURL(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null && list.size() > 0)
			return list.get(0).getUri();
		return null;
	}

	/* =============================Registration=========================== */

	@RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
	public ModelAndView showregister() {
		ModelAndView registration = new ModelAndView("registrationForm");
		
		String uri = getServiceURL(bookServiceName) + "/books/categories";
		List<Books> bookCategoryList=restTemplate.getForObject(uri, List.class);
		registration.addObject("bookCategoryList", bookCategoryList);
		return registration;
	}

	@PostMapping(value = "/register")
	public String customerRegistration(Customer customer, ModelMap map, BindingResult result, HttpSession session) {

		if (session.getAttribute("customer") != null) {
			return ("redirect:/");
		}

		if (result.hasErrors()) {

			return "registrationForm";
		}
		String uri = getServiceURL(userServiceName) + "/register";
		Message message = restTemplate.postForObject(uri, customer, Message.class);
		session.setAttribute("registerMessage", message);
		if (message.getFailiureMessage() != null) {

			return "redirect:/registrationForm";
		} else {

			return "redirect:/loginPage";

		}

	}

	/* =============================Login=========================== */

	@RequestMapping("/loginPage")
	public String showlogin(HttpSession session) {

		if (session.getAttribute("customer") != null) {
			return "redirect:/";
		}
		return "loginPage";
	}

	@PostMapping(value = "/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		if (session.getAttribute("customer") != null) {
			return new ModelAndView("redirect:/");
		}

		String uri = getServiceURL(userServiceName) + "/login/" + email + "/" + password;
		Customer customer = restTemplate.getForObject(uri, Customer.class);

		if (customer.getFailiureMessage() != null) {
			session.setAttribute("message", new Message("", customer.getFailiureMessage()));
			return new ModelAndView("redirect:/");
		} else {

			session.setAttribute("customer", customer);
			if (customer.getAdmin()) {
				return new ModelAndView("redirect:/adminHome");
			}
			return new ModelAndView("redirect:/");
		}
	}

	@GetMapping("/success")
	public String success() {
		return "success";
	}

	/* =============================logout=========================== */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/* =============================forgot=========================== */

	@GetMapping("/forgot-Password-Form")
	public String forgotPasswordForm() {
		return "forgotPasswordForm";
	}

	@GetMapping(value = "/forgot")
	public ModelAndView processForgotPasswordForm(@RequestParam("email") String email, HttpSession session)
			throws MessagingException {

		ModelAndView mv = new ModelAndView();

		String uri = getServiceURL(userServiceName) + "/find-by-email/" + email;
		Customer customer = null;

		try {
			customer = restTemplate.getForObject(uri, Customer.class);
		} catch (Exception e) {
			session.setAttribute("errorMessage","We didn't find an account for that e-mail address.");

		}

		if (customer == null) {
			mv.addObject("errorMessage", "We didn't find an account for that e-mail address.");

		} else {

			try {
				
				
				smtpMailSender.send(customer.getEmail(), "test mail", "please click this link to change password "
						+ "http://10.150.222.93/update-Password-Form/" + customer.getUserId());
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}


		}
		session.setAttribute("successMessage","An Email has been sent to you Succesfully");
		mv.setViewName("redirect:/");
		return mv;
	}

	@GetMapping("/update-Password-Form/{id}")
	public ModelAndView updatePasswordForm(@PathVariable("id") String enc, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/updatePasswordForm");

		String uri = getServiceURL(userServiceName) + "/user/" + enc;
		Customer customer = restTemplate.getForObject(uri, Customer.class);
		session.setAttribute("userId", enc);
		return mv;
	}

	// yes
	@GetMapping("/updatePasswordForm")
	public String update() {

		return "updatePasswordForm";
	}

	@PostMapping("/reset-password")
	public ModelAndView resetPassword(@RequestParam("password") String password,
			@RequestParam("userId") Integer userId) {

		ModelAndView mv = new ModelAndView("redirect:/");
		String uri = getServiceURL(userServiceName) + "/update-password/" + userId + "/" + password;
		Message message = restTemplate.getForObject(uri, Message.class);

		return mv;
	}

	/* =============================viewprofilepage=========================== */

	@RequestMapping(value = "/viewprofilepage", method = RequestMethod.GET)
	public String viewprofile(HttpSession session) {

		try {
			Customer customer = (Customer) session.getAttribute("customer");
			if (customer != null) {
				return "viewprofilepage";
			} else {
				return "redirect:/error";
			}
		} catch (Exception e) {
			return "redirect:/error";
		}

	}

	@GetMapping(value = "/updateprofilepage")
	public String updateCustomer(HttpSession session) {

		try {
			Customer customer = (Customer) session.getAttribute("customer");
			if (customer != null) {
				return "updateprofilepage";
			} else {
				return "redirect:/error";
			}
		} catch (Exception e) {
			return "redirect:/error";
		}

	}

	@PostMapping("/updateuser")
	public String updatecustomer(Customer updatedcustomer, HttpSession session, BindingResult result) {

		Customer customer = (Customer) session.getAttribute("customer");

		updatedcustomer.setCreatedDate(customer.getCreatedDate());
		updatedcustomer.setGender(customer.getGender());

		updatedcustomer.setUpdateDate(customer.getUpdateDate());
		updatedcustomer.setUserStatus(customer.getUserStatus());
		updatedcustomer.setUserId(customer.getUserId());
		updatedcustomer.setEmail(customer.getEmail());
		updatedcustomer.setAdmin(customer.getAdmin());
		updatedcustomer.setActive(customer.getActive());

		String uri = getServiceURL(userServiceName) + "/update-user";
		customer = restTemplate.postForObject(uri, updatedcustomer, Customer.class);

		session.setAttribute("customer", customer);
		session.setAttribute("message", new Message(customer.getSuccessMessage(), customer.getFailiureMessage()));
		return "redirect:/updateprofilepage";
	}

}