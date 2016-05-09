package blog.chl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	private MongoTemplate template;

	@RequestMapping("/test")
	public String testUser(){
		System.out.println(template);
		
		return "head";
	}
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	@RequestMapping("/logs")
	public String logs(){
		
		return "logs";
	}
	
	@RequestMapping("/message")
	public String message(){
		
		return "message";
	}
	
	
	@RequestMapping("/image")
	public String image(){
		System.out.println("come");
		return "images";
	}
	
	@RequestMapping("/lookPhotos")
	public String lookPhotos(Model model){
	
		model.addAttribute("photo", "images/p01.jpg");
		return "lookphotos";
	}
	
	@RequestMapping("/lookLogs")
	public String lookLogs(){
	
		return "lookLogs";
	}
}
