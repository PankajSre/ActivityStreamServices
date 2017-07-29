package com.stackroute.activitystream;

import java.util.List;

public interface UserDAO {

	public boolean saveUser(User user);
	public User getUserByEmailId(String emailId);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public List<User> getAllUsers();
	public User validateUser(String emailId, String password);
}
