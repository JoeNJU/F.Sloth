package game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Block extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//每一个格子都是一个按钮
	private boolean occupied = false;
	private Person person;//person是character类的变量
	private int family;
	private boolean isHome = false;
	private Point location;//(410+x*34-y*23,196+x*10+y*20)
	public int score[];    //分数变量
	
	private ImageIcon[] IMG_BLOCK = new ImageIcon[]{new ImageIcon("graphics/game/block1.png")};
	
	public Block(int x, int y){
		location = new Point(x,y);
		setBounds(getRealPoint().x,getRealPoint().y,IMG_BLOCK[0].getIconWidth(),IMG_BLOCK[0].getIconHeight());
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(IMG_BLOCK[0].getImage(), 0, 0, null);
	}
	
	public Point getRealPoint(){
		Point real = new Point(410+34*location.x-23*location.y,196+location.x*10+location.y*20);
		return real;
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
		if(location.x<=14&&0<=location.x&&0<=location.y&&location.y<=14){
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