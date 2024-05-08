package logic;

import java.util.ArrayList;
import java.util.Scanner;

import player.Player;
import pocket.Pocket;

public class Logic {
	Scanner sc = new Scanner(System.in);

	//動かすマスを選択
	public boolean chooseMovePocket(int _pocketNum, Player _player, ArrayList<Pocket> _pockets) {
		boolean ex = false;

		System.out.println("\n" + _player.getName() + " さんの番です。");
		System.out.print("動かすポケットを選択してください。:");

		int choosePocketNum = Integer.parseInt(sc.nextLine());
		int preMoveNum = _pockets.get(choosePocketNum).getSeeds();
		if (allowChoosePocket(choosePocketNum, _pocketNum, _player, _pockets)) {
			int choosed = _pockets.get(choosePocketNum).getSeeds();
			int currentIndex;
			_pockets.get(choosePocketNum).setSeeds(0);
			for (int i = 1; i <= choosed; i++) {
				currentIndex = (choosePocketNum + i) % _pockets.size();
				int tmp = _pockets.get(currentIndex).getSeeds();
				_pockets.get(currentIndex).setSeeds(tmp + 1);
			}
			
		} else {
			System.out.println("\n"+"\u001b[00;41m"+"自分のポケットを選択してください。"+"\u001b[00m");
			return ex=true;
		}
		if ((choosePocketNum + preMoveNum) % (_pockets.size()-1) == 0) {
			return ex = true;
		} else if ((choosePocketNum + preMoveNum) % (_pockets.size()-1) == (_pocketNum+1)) {
			return ex = true;
		}
		return ex = false;
	}

	//マスが動かせるかどうか判定するメソッド
	public boolean allowChoosePocket(int _choosePocketNum, int _pocketNum, Player _player, ArrayList<Pocket> _pockets) {
		if (_player.getNum() == 1) {
			if ((_choosePocketNum >= 0) && (_choosePocketNum < _pocketNum)
					&& (_pockets.get(_choosePocketNum).getSeeds() != 0)) {
				return true;
			}
		}
		if (_player.getNum() == 2) {
			if ((_choosePocketNum < _pockets.size() - 1) && (_choosePocketNum > _pocketNum)
					&& (_pockets.get(_choosePocketNum).getSeeds() != 0)) {
				return true;
			}
		}
		return false;
	}

	//勝敗判定
	public void judge(int _pocketNum, ArrayList<Pocket> _pockets) {
		int sum = 0;
		for (int i = 1; i < _pocketNum; i++) {
			sum += _pockets.get(i).getSeeds();
		}
		if (sum == 0) {
			System.out.println("Player1の勝ち！");
			System.exit(0);
		}

		sum = 0;
		for (int i = _pocketNum + 1; i < _pockets.size() - 1; i++) {
			sum += _pockets.get(i).getSeeds();
		}
		if (sum == 0) {
			System.out.println("Player2の勝ち！");
			System.exit(0);
		}

	}

}
