package blog.chl.service.impl;

import org.springframework.stereotype.Service;

import blog.chl.dao.impl.BaseDaoImpl;
import blog.chl.domain.User;

@Service("userService")
public class UserServiceImpl extends BaseDaoImpl<User> {

}
