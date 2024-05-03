package Service;

import java.util.List;

import Dao.UserDao;
import Model.User;

public class UserService {
	UserDao userDao = new UserDao();
	public User login(String username, String password) {
		User user = userDao.get(username);
		if (user != null && password.equals(user.getMatKhau()))
		{
			return user;	
		}
		return null;
	}
	
	public List<User> getAll()
	{
		return userDao.getAll();
	}
	
	
}
