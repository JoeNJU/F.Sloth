package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import game.Block;

public class Person extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	//String name;
	private int family;//0号家庭于右下角先走,0号家是小女孩
    private int rank;//爸爸为0，妈妈为1，宝宝为2
    private ImageIcon[] IMG_FATHER = new ImageIcon[]{new ImageIcon("graphics/character/10.png"),new ImageIcon("graphics/character/11.png"),new ImageIcon("graphics/character/12.png"),new ImageIcon("graphics/character/13.png")};
	private ImageIcon[] IMG_MOTHER = new ImageIcon[]{new ImageIcon("graphics/character/20.png"),new ImageIcon("graphics/character/21.png"),new ImageIcon("graphics/character/22.png"),new ImageIcon("graphics/character/23.png")};
	private ImageIcon[] IMG_GIRL = new ImageIcon[]{new ImageIcon("graphics/character/30.png"),new ImageIcon("graphics/character/31.png"),new ImageIcon("graphics/character/32.png"),new ImageIcon("graphics/character/33.png")};
    
    private Point location = new Point(0,0);//坐标
    private int vision;
    private int activity = 7;//体力
    private Point homeLoc;//012为0号家庭大本营，
    private boolean hidden = false;
    private boolean alive = true;
    private boolean isMove = false;
    private int direction = 1;
    
    
    Person(int family, int rank){
    	this.family = family;
    	this.rank = rank;
    	this.initial();
    	setBounds(10*location.x+140,10*location.y+100,50,50);
    	this.setVisible(true);
    }
    
    public boolean isHide(){
    	return hidden;
    }
    
    
    public void paintComponent(Graphics g){
    	Point realPoint = new Point(140+10*location.x,100+10*location.y);
    	setLocation(realPoint);//移动后的坐标
    	

		if(hidden){
			//隐身图案
		}else{
			if(rank==0){
				g.drawImage(IMG_FATHER[direction].getImage(), 0, 0,50,50, null);
			}else if(rank==1){
				g.drawImage(IMG_MOTHER[direction].getImage(), 0, 0,50,50, null);
			}else if(rank==2&&family==0){
				g.drawImage(IMG_GIRL[direction].getImage(), 0, 0,50,50, null);
			}
		}
	
	}
    
    
    private void initial(){
    		
    	if(family == 0){
    		location.x = 14;
    		switch(rank){
        	case 0:
        		location.y = 12;
        		break;
        	case 1:
        		location.y = 7;
        		break;
        	case 2:
        		location.y = 2;
        		break;
        	default:
        		break;
        	}
    	}else{
    		location.x = 0;
    		switch(rank){
        	case 0:
        		location.y = 2;
        		break;
        	case 1:
        		location.y = 7;
        		break;
        	case 2:
        		location.y = 12;
        		break;
        	default:
        		break;
        	}
    	}//确定初始位
    	
    	homeLoc = location;
    }
    
    
    
    public int getActivity(){   //返回体力值
    	return activity;
    }
    
    void hit(){   //character(i,j).hit();
    	
    	location = homeLoc;
    	this.repaint();
    	//被打中回家
    }
    

	void occupy(int direction){//direction 0 1 2 3分别代表上下左右  不同角色的占领方式不同  爸爸为0，妈妈为1，宝宝为2
		this.direction = direction;
    	if(activity>=4){
    	switch(direction){
    	case 0:  //方向向上
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setOccupied(family);
    	    	Block(location.x-1,location.y).setOccupied(family);
    	    	Block(location.x-1,location.y+1).setOccupied(family);
    	    	Block(location.x,location.y-1).setOccupied(family);
    	    	Block(location.x,location.y+1).setOccupied(family);
    	    	Block(location.x+1,location.y-1).setOccupied(family);
    	    	Block(location.x+1,location.y+1).setOccupied(family);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y-2).setOccupied(family);
    	    	Block(location.x,location.y-1).setOccupied(family);
    	    	Block(location.x-1,location.y-1).setOccupied(family);
    	    	Block(location.x-1,location.y).setOccupied(family);
    	    	Block(location.x-2,location.y).setOccupied(family);
    	    }else
    	    if(rank==2){
    	    	for(int count=0;count<=4;count++){
    	    		Block(location.x-count,location.y).setOccupied(family);
    	    	}
    	    }
    	    	
    	break;    
    	    
    	         
    	    
    		
    	case 1:  //方向向下
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setOccupied(family);
    	    	Block(location.x+1,location.y).setOccupied(family);
    	    	Block(location.x-1,location.y+1).setOccupied(family);
    	    	Block(location.x,location.y-1).setOccupied(family);
    	    	Block(location.x,location.y+1).setOccupied(family);
    	    	Block(location.x+1,location.y-1).setOccupied(family);
    	    	Block(location.x+1,location.y+1).setOccupied(family);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y+2).setOccupied(family);
    	    	Block(location.x,location.y+1).setOccupied(family);
    	    	Block(location.x+1,location.y+1).setOccupied(family);
    	    	Block(location.x+1,location.y).setOccupied(family);
    	    	Block(location.x+2,location.y).setOccupied(family);
    	    }else
    	    if(rank==2){
    	    	for(int count=0;count<=4;count++){
    	    		Block(location.x+count,location.y).setOccupied(family);
    	    	}
    	    }
    	break;
    		
    	case 2: // 方向向左
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setOccupied(family);
     	    	Block(location.x-1,location.y).setOccupied(family);
     	    	Block(location.x-1,location.y+1).setOccupied(family);
     	    	Block(location.x,location.y-1).setOccupied(family);
     	    	Block(location.x+1,location.y).setOccupied(family);
     	    	Block(location.x+1,location.y-1).setOccupied(family);
     	    	Block(location.x+1,location.y+1).setOccupied(family);
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y-2).setOccupied(family);
    	    	Block(location.x,location.y-1).setOccupied(family);
    	    	Block(location.x+1,location.y-1).setOccupied(family);
    	    	Block(location.x+1,location.y).setOccupied(family);
    	    	Block(location.x+2,location.y).setOccupied(family);
     	    }else
     	    if(rank==2){	
     	    	for(int count=0;count<=4;count++){
    	    		Block(location.x,location.y-count).setOccupied(family);
    	    	}
     	    }
     	break;
    		
    	case 3:  //方向向右
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setOccupied(family);
      	    	Block(location.x-1,location.y).setOccupied(family);
      	    	Block(location.x-1,location.y+1).setOccupied(family);
      	    	Block(location.x,location.y+1).setOccupied(family);
      	    	Block(location.x+1,location.y).setOccupied(family);
      	    	Block(location.x+1,location.y-1).setOccupied(family);
      	    	Block(location.x+1,location.y+1).setOccupied(family);
     	    	
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y+2).setOccupied(family);
    	    	Block(location.x,location.y+1).setOccupied(family);
    	    	Block(location.x-1,location.y+1).setOccupied(family);
    	    	Block(location.x-1,location.y).setOccupied(family);
    	    	Block(location.x-2,location.y).setOccupied(family);
     	    	
     	    }else
     	    if(rank==2){
     	    	for(int count=0;count<=4;count++){
    	    		Block(location.x,location.y+count).setOccupied(family);
    	    	}
     	    }
     	break;
    		
    	}
    	activity -= 4;     //占领消耗4点体力
    	this.repaint();  //面向占领的方向
    	}else{
    		//停止行动或者进行其他行动
    	}
    }



      //undone
	private Block Block(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	void molest(int direction, Person rival){//骚扰
		this.direction = direction;
    	if(activity>=2){
    		
    	//undone
    	rival.hit();
    	activity -= 2;
    	this.repaint();
    	rival.stop();
    	}else{
    		//停止行动或者进行其他行动
    	}
    }
    
    void stop(){
    	alive = false;
    }//停止时进入假死状态
    
    boolean isAlive(){
    	return alive;
    }
    
    void disappear(){  
    	hidden = true;
    	activity -= 1;
    	this.repaint();
    }
    
    void appear(){
    	hidden = false;
    	activity -= 1;
    	this.repaint();
    }
    
    void move(int direction){
    	this.direction = direction;
    	switch(direction){//direction 0 1 2 3分别代表上下左右
    	case 0:
    		if(location.x!=0){
    			location.x -= 1;
    			isMove=true;
    			activity -=2;
    		}else{
    			stopMove();
    		}
    		break;
    	case 1:
    		if(location.x!=14){
    			location.x += 1;
    			isMove=true;
    			activity -=2;
    		}else{
    			stopMove();
    		}
    		
    		break;
    	case 2:
    		if(location.y!=0){
    			location.y -=1;
    			isMove=true;
    			activity -=2;
    		}else{
    			stopMove();
    		}
    		break;
    	case 3:
    		if(location.y!=14){
    			location.y +=1;
    			isMove=true;
    			activity -=2;
    		}else{
    			stopMove();
    		}
    		break;
    		
    	}
    	this.repaint();
    }
    
    void stopMove(){
    	isMove = false;
    }
    
    @Override
	public void keyPressed(KeyEvent arg0) {
		if(isMove){
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_LEFT:
				direction = 2;
				if(location.x!=0)
					location.x --;
				break;
			case KeyEvent.VK_RIGHT:
				direction = 3;
				if(location.x!=14)
					location.x ++;
				break;
			case KeyEvent.VK_UP:
				direction = 0;
				if(location.y!=0)
					location.y --;
				break;
			case KeyEvent.VK_DOWN:
				direction = 1;
				if(location.y!=14)
					location.y ++;
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
