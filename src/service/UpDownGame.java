package service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entity.NationForGame;

//업다운 게임
public class UpDownGame{
	private NationService nationService = new NationServiceImpl();
	private List<NationForGame> nationForGameList;
	private int index = 0; //인덱스와 스코어는 동일하다
	NationForGame left;
	NationForGame right;

	//초기화
	public UpDownGame() {
		nationForGameList = nationService.retrieveAllNationForGame();
		Collections.shuffle(nationForGameList);
		index = 0;
		this.left = nationForGameList.get(index);
		right = nationForGameList.get(index + 1);
	}

	//현재 순서 반환
	public int getIndex() {
		return index;
	}

	//왼쪽국가 반환
	public NationForGame getLeft() {
		return left;
	}

	//오른쪽국가 반환
	public NationForGame getRight() {
		return right;
	}

	// 오른쪽이 더 이상인가?
	public int play(boolean answer) {
		// 끝까지 도달
		if (index == nationForGameList.size() - 1) {
			return -1;
		}
		// 분기별로 맞히면 다음 단계를 준비한 다음 1을 반환하고 틀리면 0을 반환
		else {
			if (left.getArea() <= right.getArea()) {
				if (answer == true) {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (answer == true) {
					return 0;
				} else {
					return 1;
				}
			}
		}
	}
	
	//다음으로
	public void next() {
		left = nationForGameList.get(++index);
		right = nationForGameList.get(index + 1);
	}

	// 사후 정리 또는 데이터베이스 등록 등 게임 후 처리(game컨트롤러에서 구헌)
	public void ending() {

	}

}
