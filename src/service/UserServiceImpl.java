package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionManager;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServiceImpl implements UserService {
	private final Connection con = ConnectionManager.getConnection();

	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean registrationByNameAndUserIdAndPassword(String name, String id, String password) {
		return userDao.createByNameAndUserIdAndPassword(name, id, password);
	}

	@Override
	public boolean loginByUserIdAndPassword(String userId, String password) {
		User user = userDao.retrieveByUserIdAndPassword(userId, password);
		
		if(user == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean updateByUserIdAndUser(String id, User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByUserId(String userId) {
		return userDao.deleteByUserId(userId);
	}

	@Override
	public Integer retrieveLevelByUserId(String id) {
		return userDao.retrieveLevelByUserId(id);
	}

	@Override
	public Integer retrieveTopLevel() {
		return userDao.retrieveTopLevel();
	}

	@Override
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel) {
		return userDao.updateLevelByUserAndLevel(user, newLevel);
	}

	@Override
	public User retrievebyUserId(String USerId) {
		return userDao.retrieveByUserId(USerId);
	}



}
