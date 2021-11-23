package service;

public interface FileService {
	public int upload(String path) throws Exception;
	public int download(String path);
}
