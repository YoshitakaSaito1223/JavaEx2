package main;

import java.util.ArrayList;
import java.util.Scanner;

import board.Board;
import logic.Logic;
import player.Computer;
import player.Player;
import pocket.Pocket;

public class Main {

	public static void main(String[] args) {
		int pocketNum = 3;

		Scanner sc =new Scanner(System.in);
		Board bd = new Board();
		Player player1 = new Player("Player1", 1);
		Player player2 = new Player("Player2", 2);
		Computer com =new Computer(2);
		Logic logic = new Logic();

		bd.settingBoard(pocketNum, 5);
		
		ArrayList<Pocket> pockets = bd.returnBoardStatus();
		
		System.out.println("----マンカラ----");
		
		System.out.println("コンピュータと対戦する場合は0,友人と対戦する場合は1を入力してください。");
		System.out.print("選択：");
		int comOrPlayer=Integer.parseInt(sc.nextLine());
	
		
		System.out.println("\n\n各自のポケットの数をすべて0にできたら勝利");
		System.out.println("ポケットの番号は左上から時計回りに0~"+(pocketNum*2+1));
		System.out.println(player1.getName()+"さんのポケット・・・上段");
		System.out.println((comOrPlayer==1 ? player2.getName() : com.getName())+"さんのポケット・・・下段");
		
		bd.showBoardStatus();

		boolean loop = false;
		for (int turn = 0;; turn++) {
			do {
				if (turn % 2 == 0) {
					loop = logic.chooseMovePocket(pocketNum, player1, pockets);
				} else {
					loop = logic.chooseMovePocket(pocketNum, (comOrPlayer==1 ? player2 : com), pockets);
				}
				logic.judge(pocketNum, pockets);
				bd.showBoardStatus();
			} while (loop);
		}

	}

}