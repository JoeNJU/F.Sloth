package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import game.Block;

public class Person extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//String name;
	int family;//0�ż�ͥ�����½�����,0�ż���СŮ��
    int rank;//�ְ�Ϊ0������Ϊ1������Ϊ2
    private ImageIcon[] IMG_FATHER = new ImageIcon[]{new ImageIcon("graphics/character/10.png"),new ImageIcon("graphics/character/11.png"),new ImageIcon("graphics/character/12.png"),new ImageIcon("graphics/character/13.png")};
	private ImageIcon[] IMG_MOTHER = new ImageIcon[]{new ImageIcon("graphics/character/20.png"),new ImageIcon("graphics/character/21.png"),new ImageIcon("graphics/character/22.png"),new ImageIcon("graphics/character/23.png")};
	private ImageIcon[] IMG_GIRL = new ImageIcon[]{new ImageIcon("graphics/character/30.png"),new ImageIcon("graphics/character/31.png"),new ImageIcon("graphics/character/32.png"),new ImageIcon("graphics/character/33.png")};
	private ImageIcon[] IMG_BOY = new ImageIcon[]{new ImageIcon("graphics/character/30.png"),new ImageIcon("graphics/character/31.png"),new ImageIcon("graphics/character/32.png"),new ImageIcon("graphics/character/33.png")};
    
    public Point location = new Point(0,0);//(420+x*34-y*23,125+x*10+y*20)
    private int vision;
    private int activity = 7;//����
    private Point homeLoc;//012Ϊ0�ż�ͥ��Ӫ��
    private boolean hidden = false;
    private boolean awake = true;
    int direction ;
    private Control control;
    
    
    Person(int family, int rank){
    	this.family = family;
    	this.rank = rank;
    	direction = family+2;
    	this.initial();
    	setBounds(getRealPoint().x,getRealPoint().y,47,74);
    	this.setVisible(true);
    }
    
    public Point getRealPoint(){
		Point real = new Point(420+34*location.x-26*location.y,145+location.x*10+location.y*23);
		return real;
	}
    
    public boolean isHide(){
    	return hidden;
    }
    
    void setControl(Control control){
    	this.control = control;
    }
    
    void reactive(){
    	activity = 7;
    }
    
    
    public void paintComponent(Graphics g){
    	setLocation(getRealPoint());//�ƶ��������
    	

		if(hidden){
			if(rank==0){
				g.drawImage(IMG_FATHER[direction].getImage(), 0, 0, null);
			}else if(rank==1){
				g.drawImage(IMG_MOTHER[direction].getImage(), 0, 0, null);
			}else if(rank==2&&family==0){
				g.drawImage(IMG_GIRL[direction].getImage(), 0, 0, null);
			}else{
				g.drawImage(IMG_BOY[direction].getImage(), 0, 0, null);
			}
			//����ͼ��
		}else{
			if(rank==0){
				g.drawImage(IMG_FATHER[direction].getImage(), 0, 0, null);
			}else if(rank==1){
				g.drawImage(IMG_MOTHER[direction].getImage(), 0, 0, null);
			}else if(rank==2&&family==0){
				g.drawImage(IMG_GIRL[direction].getImage(), 0, 0, null);
			}else{
				g.drawImage(IMG_BOY[direction].getImage(), 0, 0, null);
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
    	}//ȷ����ʼλ
    	
    	homeLoc = new Point(location);
    }
    
    public void disturb(int direction){//ɧ��
		this.direction = direction;
		
		switch(direction){
    	case 0:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).hitPerson(family);
    	    	Block(location.x-1,location.y).hitPerson(family);
    	    	Block(location.x-1,location.y+1).hitPerson(family);
    	    	Block(location.x,location.y-1).hitPerson(family);
    	    	Block(location.x+1,location.y).hitPerson(family);
    	    	Block(location.x+1,location.y-1).hitPerson(family);
    	    	Block(location.x+1,location.y+1).hitPerson(family);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y-2).hitPerson(family);
    	    	Block(location.x,location.y-1).hitPerson(family);
    	    	Block(location.x-1,location.y-1).hitPerson(family);
    	    	Block(location.x-1,location.y).hitPerson(family);
    	    	Block(location.x-2,location.y).hitPerson(family);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y-count).hitPerson(family);
    	    	}
    	    }
    	    	
    	break;    
    	    
    	         
    	    
    		
    	case 1:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).hitPerson(family);
    	    	Block(location.x-1,location.y).hitPerson(family);
    	    	Block(location.x-1,location.y+1).hitPerson(family);
    	    	Block(location.x,location.y+1).hitPerson(family);
    	    	Block(location.x+1,location.y).hitPerson(family);
    	    	Block(location.x+1,location.y-1).hitPerson(family);
    	    	Block(location.x+1,location.y+1).hitPerson(family);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y+2).hitPerson(family);
    	    	Block(location.x,location.y+1).hitPerson(family);
    	    	Block(location.x+1,location.y+1).hitPerson(family);
    	    	Block(location.x+1,location.y).hitPerson(family);
    	    	Block(location.x+2,location.y).hitPerson(family);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y+count).hitPerson(family);
    	    	}
    	    }
    	break;
    		
    	case 2: // ��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).hitPerson(family);
     	    	Block(location.x-1,location.y).hitPerson(family);
     	    	Block(location.x-1,location.y+1).hitPerson(family);
     	    	Block(location.x,location.y-1).hitPerson(family);
     	    	Block(location.x,location.y+1).hitPerson(family);
     	    	Block(location.x+1,location.y-1).hitPerson(family);
     	    	Block(location.x+1,location.y+1).hitPerson(family);
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y+2).hitPerson(family);
    	    	Block(location.x,location.y+1).hitPerson(family);
    	    	Block(location.x-1,location.y+1).hitPerson(family);
    	    	Block(location.x-1,location.y).hitPerson(family);
    	    	Block(location.x-2,location.y).hitPerson(family);
     	    }else
     	    if(rank==2){	
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x-count,location.y).hitPerson(family);
    	    	}
     	    }
     	break;
    		
    	case 3:  //��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).hitPerson(family);
      	    	Block(location.x-1,location.y+1).hitPerson(family);
      	    	Block(location.x,location.y-1).hitPerson(family);
      	    	Block(location.x,location.y+1).hitPerson(family);
      	    	Block(location.x+1,location.y).hitPerson(family);
      	    	Block(location.x+1,location.y-1).hitPerson(family);
      	    	Block(location.x+1,location.y+1).hitPerson(family);
     	    	
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y-2).hitPerson(family);
    	    	Block(location.x,location.y-1).hitPerson(family);
    	    	Block(location.x+1,location.y-1).hitPerson(family);
    	    	Block(location.x+1,location.y).hitPerson(family);
    	    	Block(location.x+2,location.y).hitPerson(family);
     	    	
     	    }else
     	    if(rank==2){
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x+count,location.y).hitPerson(family);
    	    	}
     	    }
     	break;
    		
    	}
    	activity -= 3;
    	
    }
    
    
    
    public int getActivity(){   //��������ֵ
    	return activity;
    }
    
    void hit(){   //character(i,j).hit();   	
    	location.x = homeLoc.x;
    	location.y = homeLoc.y;
    	System.out.println(location.x+" "+location.y);
    	//�����лؼ�
    }
    

	public void occupy(int direction){//direction 0 1 2 3�ֱ������������  ��ͬ��ɫ��ռ�췽ʽ��ͬ  �ְ�Ϊ0������Ϊ1������Ϊ2
		this.direction = direction;
    	switch(direction){
    	case 0:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y).setOccupied(family,rank);
    	    	Block(location.x-1,location.y+1).setOccupied(family,rank);
    	    	Block(location.x,location.y-1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y).setOccupied(family,rank);
    	    	Block(location.x+1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y+1).setOccupied(family,rank);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y-2).setOccupied(family,rank);
    	    	Block(location.x,location.y-1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y).setOccupied(family,rank);
    	    	Block(location.x-2,location.y).setOccupied(family,rank);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y-count).setOccupied(family,rank);
    	    	}
    	    }
    	    	
    	break;    
    	    
    	         
    	    
    		
    	case 1:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y).setOccupied(family,rank);
    	    	Block(location.x-1,location.y+1).setOccupied(family,rank);
    	    	Block(location.x,location.y+1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y).setOccupied(family,rank);
    	    	Block(location.x+1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y+1).setOccupied(family,rank);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y+2).setOccupied(family,rank);
    	    	Block(location.x,location.y+1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y+1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y).setOccupied(family,rank);
    	    	Block(location.x+2,location.y).setOccupied(family,rank);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y+count).setOccupied(family,rank);
    	    	}
    	    }
    	break;
    		
    	case 2: // ��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setOccupied(family,rank);
     	    	Block(location.x-1,location.y).setOccupied(family,rank);
     	    	Block(location.x-1,location.y+1).setOccupied(family,rank);
     	    	Block(location.x,location.y-1).setOccupied(family,rank);
     	    	Block(location.x,location.y+1).setOccupied(family,rank);
     	    	Block(location.x+1,location.y-1).setOccupied(family,rank);
     	    	Block(location.x+1,location.y+1).setOccupied(family,rank);
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y+2).setOccupied(family,rank);
    	    	Block(location.x,location.y+1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y+1).setOccupied(family,rank);
    	    	Block(location.x-1,location.y).setOccupied(family,rank);
    	    	Block(location.x-2,location.y).setOccupied(family,rank);
     	    }else
     	    if(rank==2){	
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x-count,location.y).setOccupied(family,rank);
    	    	}
     	    }
     	break;
    		
    	case 3:  //��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setOccupied(family,rank);
      	    	Block(location.x-1,location.y+1).setOccupied(family,rank);
      	    	Block(location.x,location.y-1).setOccupied(family,rank);
      	    	Block(location.x,location.y+1).setOccupied(family,rank);
      	    	Block(location.x+1,location.y).setOccupied(family,rank);
      	    	Block(location.x+1,location.y-1).setOccupied(family,rank);
      	    	Block(location.x+1,location.y+1).setOccupied(family,rank);
     	    	
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y-2).setOccupied(family,rank);
    	    	Block(location.x,location.y-1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y-1).setOccupied(family,rank);
    	    	Block(location.x+1,location.y).setOccupied(family,rank);
    	    	Block(location.x+2,location.y).setOccupied(family,rank);
     	    	
     	    }else
     	    if(rank==2){
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x+count,location.y).setOccupied(family,rank);
    	    	}
     	    }
     	break;
    		
    	}
    	activity -= 4;     //ռ������4������
    	
    }

	
	public void setExample(int direction,boolean a){//direction 0 1 2 3�ֱ������������  ��ͬ��ɫ��ռ�췽ʽ��ͬ  �ְ�Ϊ0������Ϊ1������Ϊ2
		this.direction = direction;
    	switch(direction){
    	case 0:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setExample(a);
    	    	Block(location.x-1,location.y).setExample(a);
    	    	Block(location.x-1,location.y+1).setExample(a);
    	    	Block(location.x,location.y-1).setExample(a);
    	    	Block(location.x+1,location.y).setExample(a);
    	    	Block(location.x+1,location.y-1).setExample(a);
    	    	Block(location.x+1,location.y+1).setExample(a);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y-2).setExample(a);
    	    	Block(location.x,location.y-1).setExample(a);
    	    	Block(location.x-1,location.y-1).setExample(a);
    	    	Block(location.x-1,location.y).setExample(a);
    	    	Block(location.x-2,location.y).setExample(a);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y-count).setExample(a);
    	    	}
    	    }
    	    	
    	break;    
    	    
    	         
    	    
    		
    	case 1:  //��������
    	    if(rank==0){
    	    	Block(location.x-1,location.y-1).setExample(a);
    	    	Block(location.x-1,location.y).setExample(a);
    	    	Block(location.x-1,location.y+1).setExample(a);
    	    	Block(location.x,location.y+1).setExample(a);
    	    	Block(location.x+1,location.y).setExample(a);
    	    	Block(location.x+1,location.y-1).setExample(a);
    	    	Block(location.x+1,location.y+1).setExample(a);
    	    }else
    	    if(rank==1){
    	    	Block(location.x,location.y+2).setExample(a);
    	    	Block(location.x,location.y+1).setExample(a);
    	    	Block(location.x+1,location.y+1).setExample(a);
    	    	Block(location.x+1,location.y).setExample(a);
    	    	Block(location.x+2,location.y).setExample(a);
    	    }else
    	    if(rank==2){
    	    	for(int count=1;count<=4;count++){
    	    		Block(location.x,location.y+count).setExample(a);
    	    	}
    	    }
    	break;
    		
    	case 2: // ��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setExample(a);
     	    	Block(location.x-1,location.y).setExample(a);
     	    	Block(location.x-1,location.y+1).setExample(a);
     	    	Block(location.x,location.y-1).setExample(a);
     	    	Block(location.x,location.y+1).setExample(a);
     	    	Block(location.x+1,location.y-1).setExample(a);
     	    	Block(location.x+1,location.y+1).setExample(a);
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y+2).setExample(a);
    	    	Block(location.x,location.y+1).setExample(a);
    	    	Block(location.x-1,location.y+1).setExample(a);
    	    	Block(location.x-1,location.y).setExample(a);
    	    	Block(location.x-2,location.y).setExample(a);
     	    }else
     	    if(rank==2){	
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x-count,location.y).setExample(a);
    	    	}
     	    }
     	break;
    		
    	case 3:  //��������
    		 if(rank==0){
    			Block(location.x-1,location.y-1).setExample(a);
      	    	Block(location.x-1,location.y+1).setExample(a);
      	    	Block(location.x,location.y-1).setExample(a);
      	    	Block(location.x,location.y+1).setExample(a);
      	    	Block(location.x+1,location.y).setExample(a);
      	    	Block(location.x+1,location.y-1).setExample(a);
      	    	Block(location.x+1,location.y+1).setExample(a);
     	    	
     	    }else
     	    if(rank==1){
     	    	Block(location.x,location.y-2).setExample(a);
    	    	Block(location.x,location.y-1).setExample(a);
    	    	Block(location.x+1,location.y-1).setExample(a);
    	    	Block(location.x+1,location.y).setExample(a);
    	    	Block(location.x+2,location.y).setExample(a);
     	    	
     	    }else
     	    if(rank==2){
     	    	for(int count=1;count<=4;count++){
    	    		Block(location.x+count,location.y).setExample(a);
    	    	}
     	    }
     	break;
    		
    	}
    	
    }


      //undone
	private Block Block(int i, int j) {
		if(i>=0&&i<15&&j>=0&&j<15)
			return control.blocks[i][j];
		else{
			return control.blocks[homeLoc.x][homeLoc.y];
		}
	}

    
    void stop(){
    	awake = false;
    }//ֹͣʱ�������״̬
    
    boolean isAwake(){
    	return awake;
    }
    
    public boolean inDanger(){
    	if(control.blocks[location.x][location.y].family==1-family){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    void setAwake(boolean a){
    	awake = a;
    }
    
    public void changeState(){  //��������������������
    	hidden = !hidden;
    	activity -= 1;
    	this.repaint();
    }

    
    public void move(int direction){
    	this.direction = direction;
    	switch(direction){//direction 0 1 2 3�ֱ������������
    	case 0:
    		location.y -= 1;
			activity -=2;
    		break;
    	case 1:
    		location.y += 1;
			activity -=2;
    		
    		break;
    	case 2:
    		location.x -=1;
			activity -=2;
    		break;
    	case 3:
    		location.x +=1;
			activity -=2;
    		break;
    		
    	}
    }
    

}
