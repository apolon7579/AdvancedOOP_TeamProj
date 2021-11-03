package service;

import entity.User;

public interface UserService {
	public boolean RegistrationByNameAndUserIdAndPassword(String name, String userId, String password);
	public boolean LoginByUserIdAndPassword(String userId, String password);
	public boolean UpdateByUserIdAndUser(String userId, User newUser);
	public boolean DeleteByuserId(String userId);
}
