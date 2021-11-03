package dao;

import entity.User;

public interface UserDao {
	public boolean createByNameAndUserIdAndPassword(String name, String id, String password);
	public User retrieveByUserIdAndPassword(String id, String password);
	public boolean updateByUserIdAndUser(String id, User newUser);
	public boolean deleteByUserId(String id);
}
