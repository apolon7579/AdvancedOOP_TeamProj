package dao;

import entity.User;

public interface UserDao {
	public boolean createByNameAndUserIdAndPassword(String name, String id, String password);
	public User retrieveByUserIdAndPassword(String id, String password);
	public User retrieveByUserId(String id);
	public Integer retrieveLevelByUserId(String id);
	public Integer retrieveTopLevel();
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel);
	public boolean updateByUserIdAndUser(String id, User newUser);
	public boolean deleteByUserId(String id);
}
