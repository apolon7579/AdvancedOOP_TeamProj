package service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entity.NationForGame;

public class UpDownGame implements UpDownGameService {
	private NationService nationService = new NationServiceImpl();
	private List<NationForGame> nationForGameList;
	private int index = 0;
	private int score = 0;
	NationForGame left;
	NationForGame right;

	public UpDownGame() {
		nationForGameList = nationService.retrieveAllNationForGame();
		Collections.shuffle(nationForGameList);
		index = 0;
		score = 0;
		this.left = nationForGameList.get(index);
		right = nationForGameList.get(index + 1);
	}

	public int getIndex() {
		return index;
	}

	public int getScore() {
		return score;
	}

	public NationForGame getLeft() {
		return left;
	}

	public NationForGame getRight() {
		return right;
	}

	@Override
	// 그냥 복잡하게 하지 말고 오른쪽이 더 이상인가?로 고정
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
	
	public void next() {
		left = nationForGameList.get(++index);
		right = nationForGameList.get(index + 1);
	}

	@Override
	public void ending() {
		// 사후 정리 또는 데이터베이스 등록 등 게임 후 처리

	}

	public static void main(String[] args) {
		UpDownGame gameService = new UpDownGame();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.printf("-------------------------------------%d단계-------------------------------------\n",
					gameService.getIndex() + 1);
			System.out.println(gameService.getLeft().getName() + "VS" + gameService.getRight().getName());
			System.out.println("오른쪽이 크면 true, 왼쪽이 크면 false를 입력하세요");
			int flag = gameService.play(sc.nextBoolean());
			if (flag == -1) {
				System.out.println("만점입니다!!!");
				gameService.ending();
				break;
			} else if (flag == 0) {
				System.out.println("오답입니다....");
				gameService.ending();
				break;
			} else {
				System.out.println("정답입니다!!");
				System.out.println("-------------------------------------왼쪽나라 정보-------------------------------------");
				System.out.println(gameService.getLeft());
				System.out
						.println("-------------------------------------오른쪽나라 정보-------------------------------------");
				System.out.println(gameService.getRight());
				gameService.next();
			}
		}
	}

}
