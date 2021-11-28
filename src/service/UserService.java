package service;

import entity.User;

public interface UserService {
	//아이디와 비밀번호로 유저 등록
	public boolean registrationByNameAndUserIdAndPassword(String name, String userId, String password);
	
	//아이디와 비밀번호로 로그인
	public boolean loginByUserIdAndPassword(String userId, String password);
	
	//유저 아이디로 레벨 조회
	public Integer retrieveLevelByUserId(String id);
	
	//최고점수 조회
	public Integer retrieveTopLevel();
	
	//유저 아이디로 유저 조회
	public User retrievebyUserId(String UserId);
	
	//유저 레벨 갱신
	public boolean updateLevelByUserAndLevel(User user, Integer newLevel);
	
	//유저 갱신
	public boolean updateByUserIdAndUser(String userId, User newUser);
	
	//유저 삭제
	public boolean deleteByUserId(String userId);
}
