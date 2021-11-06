package launcher;

import java.util.Arrays;

import config.DependencyManager;

public class Main {

	public static void main(String[] args) {
		// 의존성 관리용 클래스 Frame, Controller등의 초기화를 담당하며 화면을 시작시키는역할
		DependencyManager.managerStart();
	}

}
