package game;

public class Control {
	int family = 0,rank = 0;
	Character personNow;
	private Block[][] blocks;
	private Character[][] characters;
	
	Control(){
		initial();
	}
	void initial(){
		for(int i = 0;i<15;i++){
			for(int j = 0;i<15;i++){
				blocks[i][j] = new Block(i,j);
			}
		}
		
		for(int i = 0;i<2;i++){
			for(int j = 0;i<3;i++){
				characters[i][j] = new Character(i,j);
			}
		}
	}
	
	public void refresh(){
		personNow = characters[family][rank];
	}
	
	public boolean isActive(){
		int activity = personNow.getActivity();
		if(activity<=0){
			return false;
		}
		
		return true;
		
	}
	
	public boolean isFinish(){
		for(int i = 0;i<15;i++){
			for(int j = 0;i<15;i++){
				if(!blocks[i][j].isOccupied()){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void nextPer(){
		if(family==0){
			family = 1;
		}else if(rank!=2){
			family = 0;
			rank ++;
		}else{
			family = 0;
			rank = 0;
		}
	}//»»ÈË

}
