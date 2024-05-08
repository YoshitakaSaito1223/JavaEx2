package player;

public class Player {
	private String name;
	private int num;
	
	
	
	public Player(int _playerNum) {
		this.name="名無し";
		this.num=_playerNum;
	}
	
	public Player(String _name,int _playerNum) {
		this.name=_name;
		this.num=_playerNum;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return num;
	}

	
	

}
