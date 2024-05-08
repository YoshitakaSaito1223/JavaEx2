package player;

public class Computer extends Player {
	
	public Computer(int _playerNum) {
		super("Computer",_playerNum);
	}
	
	//randomにポケットを選択
	public int randomChoose(int _pocketNum) {
		
		if(this.getNum()==1) {
			return (int)(Math.random()*_pocketNum);
		}else {
			return (int)(Math.random()*_pocketNum+_pocketNum+1);
		}
		
	}
	

}
