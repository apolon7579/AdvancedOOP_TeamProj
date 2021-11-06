package service;

import java.util.ArrayList;
import java.util.Collections;

import entity.NationForGame;

public class UpDownGame implements UpDownGameService {
	private DataService dataService = new DataServiceImpl();
	private ArrayList<NationForGame> nationForGameList;
	private int index = 0;
	private int score = 0;
	NationForGame left;
	NationForGame right;
	
	public UpDownGame() {
		nationForGameList = dataService.getAllNationForGameArrayList();
		Collections.shuffle(nationForGameList);
		index = 0;
		score = 0;
		left = nationForGameList.get(index);
		right = nationForGameList.get(index+1);
	}
	
	public NationForGame getLeft() {
		return left;
	}

	public NationForGame getRight() {
		return right;
	}

	
	@Override
	//뷰 영역에서 출력한 질의가 왼쪽이 작은가?면 question에 false가 들어오고 왼쪽이 큰가?면 question에 true가 들어온다.
	// 그 다음 함수 내부 조건문에 따라 만점이면 -1, 맞히면 1, 틀리면 0을 반환한다.
	//현재 기본적으로 면적을 기준으로 한다.
	public int play(boolean question, boolean answer) {
		//끝까지 도달
		if(index == nationForGameList.size() - 1) {
			return -1;
		}
		//분기별로 맞히면 다음 단계를 준비한 다음 1을 반환하고 틀리면 0을 반환
		else {
			if(question == false) {
				if(nationForGameList.get(index).getArea()<=nationForGameList.get(index+1).getArea()) {
					if(answer == false) {
						left = nationForGameList.get(++index);
						right = nationForGameList.get(index);
						return 1;
					}
					else {
						return 0;
					}
				}
				else {
					if(answer == false) {
						return 0;
					}
					else {
						left = nationForGameList.get(++index);
						right = nationForGameList.get(index);
						return 1;
					}
				}
			}
			else {
				if(nationForGameList.get(index).getArea()>=nationForGameList.get(index+1).getArea()) {
					if(answer == true) {
						left = nationForGameList.get(++index);
						right = nationForGameList.get(index);
						return 1;
					}
					else {
						return 0;
					}
				}
				else {
					if(answer == true) {
						return 0;
					}
					else {
						left = nationForGameList.get(++index);
						right = nationForGameList.get(index);
						return 1;
					}
				}
			}
		}
		
	}
	
	@Override
	public void ending() {
		//사후 정리 또는 데이터베이스 등록 등 게임 후 처리
		
	}

}
