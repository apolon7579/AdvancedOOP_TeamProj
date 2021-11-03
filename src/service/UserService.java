package service;

import entity.User;

public interface UserService {
	public boolean registrationByNameAndUserIdAndPassword(String name, String userId, String password);
	public boolean loginByUserIdAndPassword(String userId, String password);
	public boolean updateByUserIdAndUser(String userId, User newUser);
	public boolean deleteByUserId(String userId);
}
