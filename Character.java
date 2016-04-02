package game;

import java.awt.*;

import javax.swing.*;


public class Character extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//String name;
    private int rank;//宝宝为0，爸爸为1，妈妈为2
    private int score = 0;
    private Point location;//实际坐标
    private int direction;
    private int vision;
    private int activity = 7;//体力
    private Point[] homeLoc;
    private int x;
    private int y;
    private boolean hidden = false;
    private boolean alive = true;
    
    Character(int rank){
    	this.rank = rank;
    	this.initial();
    }
    
    private void initial(){
    	switch(rank){
    	case 0:
    		
    		break;
    	case 1:
    		
    		break;
    	case 2:
    		
    		break;
    	default:
    		break;
    	}
    }
    
    public void paintComponent(Graphics g){
    	
    	this.setLocation(location);//移动后的坐标

		if(hidden){
			//隐身图案
		}else{
			switch(direction){
	    	case 0:
	    		
	    		break;
	    	case 1:
	    		
	    		break;
	    	case 2:
	    		
	    		break;
	    	case 3:
	    		
	    		break;
	    	default:
	    		break;
	    	}
			//原本图案
		}
	
	}
    
    void hit(){
    	location = homeLoc[rank];
    	this.repaint();
    	//打中回家
    }
    
    void occupy(int direction){
    	activity -= 4;
    	this.repaint();//面向占领的方向
    	//占领消耗4点体力
    }
    
    void molest(int direction, Character rival){//骚扰
    	activity -= 2;
    	this.repaint();
    	rival.stop();
    }
    
    void stop(){
    	alive = false;
    }//停止时进入假死状态
    
    boolean isAlive(){
    	return alive;
    }
    
    void disappear(){
    	hidden = true;
    	activity -= 2;
    	this.repaint();
    }
    
    void appear(){
    	hidden = false;
    	activity -= 2;
    	this.repaint();
    }
    
    void move(int direction){
    	this.direction = direction;
    	switch(direction){
    	case 0:
    		
    		break;
    	case 1:
    		
    		break;
    	case 2:
    		
    		break;
    	case 3:
    		
    		break;
    	default:
    		break;
    	}
    }//0左，1右，2上，3下

}
