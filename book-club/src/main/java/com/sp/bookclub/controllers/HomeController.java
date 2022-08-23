package com.sp.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sp.bookclub.models.Books;
import com.sp.bookclub.models.LoginUser;
import com.sp.bookclub.models.User;
import com.sp.bookclub.services.BooksService;
import com.sp.bookclub.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
    @Autowired
    private BooksService booksService;
	
	/* ------- HOME PAGE (REDIRECT to /home) -------------- */	
	@GetMapping("/")
	public String goToHomePage(Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin",new LoginUser());
		return "LoginPage.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        // to do some extra validations and create a new user!
		userService.register(newUser, result);
        
        if(result.hasErrors()) {
            // register model : newUser is already there. 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "LoginPage.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
       session.setAttribute("userId", newUser.getId());
	   session.setAttribute("usersName", newUser.getUserName());
       return "redirect:/books"; 
    }
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			// loginObject is already there
			model.addAttribute("newUser", new User());
			return "LoginPage.jsp";
		}
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
		session.setAttribute("userId", user.getId());
		session.setAttribute("usersName", user.getUserName());
		
		return "redirect:/books";
    }
	
	/* ------- HOME PAGE (REDIRECT to /home) -------------- */	
	@GetMapping("/books")
	public String goToDashboard(Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}

    	List<Books> books = booksService.findAllBooks();
    	model.addAttribute("books", books);
		return "Dashboard.jsp";
	}
	
	 //logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    
    //Create
    @GetMapping("/books/new")
    public String renderCreateBooks(Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		model.addAttribute("newBook",new Books());
		return "addBook.jsp";
    	
    }
    @PostMapping("/submit")
    public String processCreateBook(@Valid @ModelAttribute("newBook")Books book, BindingResult result, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "addBook.jsp";
    	}else {
    		booksService.createBooks(book);
    		return "redirect:/books";
    	}
    	
    }
    
	/* ------- Displays book ----- */	
	@GetMapping("/books/{id}")
	public String showDetailsPage(@PathVariable("id") Long id, Model model) {

		Books book = booksService.findBook(id);
		model.addAttribute("book", book);
		return "details.jsp";
	}
}
