package game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Block{
	
	private static final long serialVersionUID = 1L;
	//ÿһ�����Ӷ���һ����ť
	private boolean occupied = false;
	private Person person;//person��character��ı���
	private int family;
	private boolean isHome = false;
	private int x;
	private int y;
	private Point location;//(411+x*36-y*27,168+x*10+y*10)
	public int score[];    //��������
	
	public Block(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public void setPerson(Person person){
		this.person = person;
	}//��վ�����棬���ǲ�һ���Ѿ�ռ��
	
	public void setHome(int family){
		isHome = true;
		occupied = true;
		this.family = family;
	}
	
	public Person getPerson(){
		return person;
	}
	public boolean isBelong(){     //�ж������Ƿ���15*15�ĸ�����
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
	}//��ռ�죬���ǲ�һ������
	
	


}