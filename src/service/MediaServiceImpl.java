package service;

import dao.MediaDao;
import dao.MediaDaoImpl;
import entity.Media;

public class MediaServiceImpl implements MediaService{

	private MediaDao mediaDao = new MediaDaoImpl();
	
	@Override
	public void registerMedia(Media media) {
		mediaDao.insertByMedia(media);
	}

}
