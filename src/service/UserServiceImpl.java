package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ConnectionManager;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

//user service 구현체
public class UserServiceImpl implements UserService {
	private final Connection con = ConnectionManager.getConnection();

	UserDao userDao = new UserDaoImpl();

	//유저 등록
	@Override
	public boolean registrationByNameAndUserIdAndPassword(String name, String id, String password) {
		return userDao.createByNameAndUserIdAndPassword(name, id, password);
	}

	//유저 로그인
	@Override
	public boolean loginByUserIdAndPassword(String userId, String password) {
		User user = userDao.retrieveByUserIdAndPassword(userId, password);
		
		if(user == null) {
			return false;
		}else {
			return true;
		}
	}

	//유저 갱신
	@Override
	public boolean updateByUserIdAndUser(String id, User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	//유저 삭제
	@Override
	public boolean deleteByUserId(String userId) {
		return userDao.deleteByUserId(userId);
	}

	//유저 레벨 조회
	@Override
	public Integer retrieveLevelByUserId(String id) {
		return userDao.retrieveLevelByUserId(id);
	}

	//최고점수 조회
	@Override
	public Integer retrieveTopLevel() {
		return userDao.retrieveTopLevel();
	}

	//유저 갱신
	@Override
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel) {
		return userDao.updateLevelByUserAndLevel(user, newLevel);
	}

	//유저 조회
	@Override
	public User retrievebyUserId(String USerId) {
		return userDao.retrieveByUserId(USerId);
	}



}
