package game;

import java.awt.event.*;

import javax.swing.*;

public class Block{
	
	private static final long serialVersionUID = 1L;
	//每一个格子都是一个按钮
	private boolean occupied = false;
	private Character person;
	private int family;
	private boolean isHome = false;
	private int x;
	private int y;
	
	Block(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	void setPerson(Character person){
		this.person = person;
	}//人站在上面，但是不一定已经占领
	
	void setHome(int family){
		isHome = true;
		occupied = true;
		this.family = family;
	}
	
	Character getPerson(){
		return person;
	}
	
	boolean isOccupied(){
		return occupied;
	}
	
	void setOccupied(int family){
		if(!isHome){
			occupied = true;
			this.family = family;
		}
	}//被占领，但是不一定有人
	
	
	

}
