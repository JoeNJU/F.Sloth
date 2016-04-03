package game;

import java.awt.event.*;

import javax.swing.*;

public class Block{
	
	private static final long serialVersionUID = 1L;
	//ÿһ�����Ӷ���һ����ť
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
	}//��վ�����棬���ǲ�һ���Ѿ�ռ��
	
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
	}//��ռ�죬���ǲ�һ������
	
	
	

}
