package test;

import java.io.File;

public class ImgLoadingTest {

	public static void main(String[] args) {
		
		File file = new File(".\\Image\\가나.png");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.isFile());
	}

}
