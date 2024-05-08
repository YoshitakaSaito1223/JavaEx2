package board;

import java.util.ArrayList;

import pocket.Pocket;
import pocket.Store;

public class Board {
	public int pocketNum, storeNum;

	public Board() {
		pocketNum = 3;
		storeNum = 2;
	}

	public ArrayList<Pocket> pockets = new ArrayList<Pocket>();

	//ボードの初期設定
	public void settingBoard(int _pocketNum,  int _seeds) {

		pocketNum = _pocketNum;

		for (int i = 0; i < (pocketNum * 2 + storeNum); i++) {
			if (i == pocketNum || i == pocketNum * 2 + 1) {
				Store store = new Store();
				pockets.add(store);
			} else {
				Pocket pocket = new Pocket(_seeds);
				pockets.add(pocket);
			}
		}
	}

	//初期設定（指定なしver）
	public void settingBoard(int _seeds) {

		for (int i = 0; i < (pocketNum * 2 + storeNum); i++) {
			if (i == pocketNum || i == pocketNum * 2 + 1) {
				Store store = new Store();
				pockets.add(store);
			} else {
				Pocket pocket = new Pocket(_seeds);
				pockets.add(pocket);
			}
		}
	}

	//ボードの現在の状態を確認
	public void showBoardStatus() {
		System.out.print("\n   ");
		for (int i = 0; i <pocketNum; i++) {
			System.out.print(pockets.get(i).getSeeds() + " ");
		}
		System.out.print("\n" +pockets.get(pocketNum * 2 + 1).getSeeds());
		
		for (int i = 0; i < pocketNum; i++) {
			System.out.print("   ");
		}
		System.out.println( pockets.get(pocketNum).getSeeds());
		System.out.print("   ");
		for (int i = pocketNum * 2; i > pocketNum ; i--) {
			System.out.print(pockets.get(i).getSeeds() + " ");
		}
		System.out.println();
//		//配列確認用
//		for (int i=0;i<pockets.size();i++) {
//			System.out.print((pockets.get(i).getSeeds()));
//		}
	}
	
	//ボードの状態（配列）を返す
	public ArrayList<Pocket> returnBoardStatus(){
		return pockets;
	}

}
