package service;

import java.nio.file.Path;

public interface FileService {
	public int upload(Path path) throws Exception;
	public int download(Path path) throws Exception;
}
