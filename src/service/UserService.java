package service;

import entity.User;

public interface UserService {
	public boolean userResist(User user);
	public boolean userLogin(String userId, String password);
	public boolean userUpdate(User user);
	public boolean userDelete(User user);
}
