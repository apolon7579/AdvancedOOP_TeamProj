package dao;

import entity.User;

public interface UserDao {
	public boolean createByNameAndUserIdAndPassword(String name, String id, String password);
	public User retrieveByUserIdAndPassword(String id, String password);
	public Long retrieveLevelByUserId(String id);
	public Long retrieveTopLevel();
	public boolean updateLevelByUserAndLevel(User user, Long newLevel);
	public boolean updateByUserIdAndUser(String id, User newUser);
	public boolean deleteByUserId(String id);
}
