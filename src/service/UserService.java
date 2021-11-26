package service;

import entity.User;

public interface UserService {
	public boolean registrationByNameAndUserIdAndPassword(String name, String userId, String password);
	public boolean loginByUserIdAndPassword(String userId, String password);
	public Integer retrieveLevelByUserId(String id);
	public Integer retrieveTopLevel();
	public User retrievebyUserId(String UserId);
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel);
	public boolean updateByUserIdAndUser(String userId, User newUser);
	public boolean deleteByUserId(String userId);
}
