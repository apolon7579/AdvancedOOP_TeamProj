package service;

import java.nio.file.Path;

//csv 업로드 및 다운로드 담당 service
public interface FileService {
	//csv 업로드
	public int upload(Path path) throws Exception;
	
	//csv 다운로드
	public int download(Path path) throws Exception;
}
