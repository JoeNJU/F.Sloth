package game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Block{
	
	private static final long serialVersionUID = 1L;
	//每一个格子都是一个按钮
	private boolean occupied = false;
	private Person person;//person是character类的变量
	private int family;
	private boolean isHome = false;
	private int x;
	private int y;
	private Point location;//(411+x*36-y*27,168+x*10+y*10)
	public int score[];    //分数变量
	
	public Block(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public void setPerson(Person person){
		this.person = person;
	}//人站在上面，但是不一定已经占领
	
	public void setHome(int family){
		isHome = true;
		occupied = true;
		this.family = family;
	}
	
	public Person getPerson(){
		return person;
	}
	public boolean isBelong(){     //判断坐标是否在15*15的格子中
		if(x<=14&&0<=x&&0<=y&&y<=14){
		    return true;	
		}
		else
			return false;
		
	}
	public boolean isOccupied(){
		return occupied;
	}
	
	public void setOccupied(int family){
		if(isBelong()==true){	
		    if(!isHome){
		    occupied = true;
			this.family = family;
			score[family]++;
		}
		}
		else{
			
		}
	}//被占领，但是不一定有人
	
	


}