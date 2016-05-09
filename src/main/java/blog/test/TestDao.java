package blog.test;

import org.junit.Test;

import blog.chl.domain.User;
import blog.chl.service.impl.UserServiceImpl;

public class TestDao {

	@Test
	public void test(){
		UserServiceImpl userService= new UserServiceImpl();
		User user = new User();
		
		user.setUsername("123");
		user.setPassword("456");
		userService.saveEntity(user);
	}
	
}
