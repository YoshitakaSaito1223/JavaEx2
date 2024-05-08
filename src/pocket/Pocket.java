package pocket;

public class Pocket {
	private int seeds=0;
	
	public Pocket(){
		this.seeds=4;
	}
	
	public Pocket(int _seeds){
		this.seeds=_seeds;
	}

	public int getSeeds() {
		return seeds;
	}

	public void setSeeds(int seeds) {
		this.seeds = seeds;
	}

}
