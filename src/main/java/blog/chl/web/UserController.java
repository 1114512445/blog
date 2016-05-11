package blog.chl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import blog.chl.domain.User;
import blog.chl.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value="/photoalbum")
	public String photoalbum(){
		
		return "manager/photoalbum";
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
	
	@RequestMapping("/managerIndex")
	public String managerIndex(){
	
		return "manager/index";
	}
	
	@RequestMapping("/userList")
	public String editUser(Model model){
	
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		return "manager/userList";
	}
	
	@RequestMapping("/photo")
	public String lookManagerPhoto(){
		
		return "manager/photo";
	}
	
	
	@RequestMapping("/saveOrUpdateUser")
	@ResponseBody
	public boolean saveOrUpdateUser(User user){
		
		try{
			String id = user.getId();
			if(null==id || "".equals(id.trim())){
				user.setId(null);
			}
			
			userService.saveEntity(user);
		}
		catch(Exception e){
			
			return false;
		}
		
		return true;
	}
	
	@RequestMapping("/removeUser")
	@ResponseBody
	public boolean removeUser(String id){
		
		try{
					
			userService.removeEntity(Query.query(Criteria.where("id").is(id)));
		}
		catch(Exception e){
			
			return false;
		}
		
		return true;
	}
}
