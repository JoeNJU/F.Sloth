package game;

import ui.JPanelGame;

public class Control {
	int family = 0,rank = 0;
	public Person personNow;     
	private Block[][] blocks = new Block[15][15];  
	private Person[][] people = new Person[2][3]; 
	private JPanelGame game;
	
	public Control(JPanelGame game){
		this.game = game;
		initial();
	}
	void initial(){   
		for(int i = 0;i<15;i++){
			for(int j = 0;i<15;i++){
				blocks[i][j] = new Block(i,j);
			}
		}
		
		for(int i = 0;i<2;i++){
			for(int j = 0;j<3;j++){
				people[i][j] = new Person(i,j);
				game.add(people[i][j]);
				people[i][j].repaint();
			}
		}
		refresh();
		game.basicAdd(personNow);
	}
	
	public void refresh(){
		personNow = people[family][rank];
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
		refresh();
	}
    
	/*public void Start(){
		if(!isFinish()){
		
		for(int count=0;count<=300;count++){ 
		    refresh();
			while(isActive()){
			Jpanelchoose a=new Jpanelchoose();
				a.appear();   
			}
			nextPer();
		   }
		 }
		else{
			
		}
	}*/
	

}