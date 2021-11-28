package service;

import dao.MediaDao;
import dao.MediaDaoImpl;
import entity.Media;

//media service 구현체
public class MediaServiceImpl implements MediaService{

	private MediaDao mediaDao = new MediaDaoImpl();
	
	//매체 등록
	@Override
	public void registerMedia(Media media) {
		mediaDao.insertByMedia(media);
	}

}
