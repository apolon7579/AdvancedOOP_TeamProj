package dao;

import java.util.List;

import entity.Media;

public interface MediaDao {

	//국가 번호로 매체 조회
	List<Media> retrieveMediaListByNationId(int id);
	
	//메체 삽입
	public boolean insertByMedia(Media media);
	
	//국가 번호로 매체 삭제
	public int deleteByNationId(int nationId);
}
