package game;



import ui.JPanelGame;

public class Control {
	int family = 0,rank = 0;
	public Person personNow; 
	private Person personLast;
	public Block[][] blocks = new Block[15][15];  
	public Person[][] people = new Person[2][3]; 
	private JPanelGame game;
	private int count = 1;//记录回合数
	
	public Control(JPanelGame game){
		this.game = game;
		initial();
	}
	void initial(){   	
		
		for(int i = 0;i<2;i++){
			for(int j = 0;j<3;j++){
				people[i][j] = new Person(i,j);
				game.add(people[i][j]);
				people[i][j].setControl(this);
				people[i][j].repaint();
			}
		}
		game.initialButtons();
		
		for(int i = 0;i<15;i++){
			for(int j = 0;j<15;j++){
				blocks[i][j] = new Block(i,j);
				game.add(blocks[i][j]);
				blocks[i][j].setControl(this);
				blocks[i][j].repaint();
			}
		}
		refresh();
		personLast = personNow;
	}
	
	public void refresh(){
		game.removeButtons();
		personNow = people[family][rank];
		if(isFinish()){
			
		}else if(isActive()){
			game.basicAdd(personNow);
			personNow.setExample(personNow.direction, false);
		}else{
			personNow.setExample(personNow.direction, false);
			nextPer();
		}
		
	}
	
	public void refresh(int i){
		game.removeButtons();
		personNow = people[family][rank];
		if(isFinish()){
			
		}else if(personNow.getActivity()>=2){
			game.directAdd(personNow,2);
		}else if(isActive()){
			personNow.setExample(personNow.direction, false);
			game.basicAdd(personNow);
		}else{
			nextPer();
		}
	}
	
	public boolean isActive(){    	
		int activity = personNow.getActivity();
		if(activity<=0){
			return false;
		}
		
		return true;
		
	}
	
	public boolean isFinish(){
		if(count>=60){//限定回合数
			return true;
		}
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
		count++;
		personNow.reactive();
		if(personLast.family==family){
			family = 1-family;		
		}else if(rank==2){
			rank = 0;
		}else{
			rank++;
		}
		personLast = personNow;
		personNow = people[family][rank];
		if(!personNow.isAwake()){
			personNow.setAwake(true);
			nextPer();
		}else{
			refresh();
		}
		
	}
	
	public void repaintAll(){
		for(int i = 0;i<2;i++){
			for(int j = 0;j<3;j++){
				people[i][j].repaint();
			}
		}
		
		for(int i = 0;i<15;i++){
			for(int j = 0;j<15;j++){
				blocks[i][j].repaint();
			}
		}
		
		game.repaint();
	}
	
    
	
	
	

}