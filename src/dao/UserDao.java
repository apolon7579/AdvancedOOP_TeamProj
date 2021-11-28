package dao;

import entity.User;

public interface UserDao {
	//유저등록
	public boolean createByNameAndUserIdAndPassword(String name, String id, String password);
	
	//이이디, 비밀번호로 유저 조회
	public User retrieveByUserIdAndPassword(String id, String password);
	
	//아이디로 유저 조회
	public User retrieveByUserId(String id);
	
	//유저 아이디로 레벨 조회
	public Integer retrieveLevelByUserId(String id);
	
	//최고점수 조회
	public Integer retrieveTopLevel();
	
	//레벨 갱신
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel);
	
	//유저 갱신
	public boolean updateByUserIdAndUser(String id, User newUser);
	
	//유저 삭제
	public boolean deleteByUserId(String id);
}
