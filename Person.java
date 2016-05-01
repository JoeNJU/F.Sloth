package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import game.Block;

public class Person extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	//String name;
	private int family;//0�ż�ͥ�����½�����,0�ż���СŮ��
    private int rank;//�ְ�Ϊ0������Ϊ1������Ϊ2
    private ImageIcon[] IMG_FATHER = new ImageIcon[]{new ImageIcon("graphics/character/10.png"),new ImageIcon("graphics/character/11.png"),new ImageIcon("graphics/character/12.png"),new ImageIcon("graphics/character/13.png")};
	private ImageIcon[] IMG_MOTHER = new ImageIcon[]{new ImageIcon("graphics/character/20.png"),new ImageIcon("graphics/character/21.png"),new ImageIcon("graphics/character/22.png"),new ImageIcon("graphics/character/23.png")};
	private ImageIcon[] IMG_GIRL = new ImageIcon[]{new ImageIcon("graphics/character/30.png"),new ImageIcon("graphics/character/31.png"),new ImageIcon("graphics/character/32.png"),new ImageIcon("graphics/character/33.png")};
    
    private Point location = new Point(0,0);//����
    private int vision;
    private int activity = 7;//����
    private Point homeLoc;//012Ϊ0�ż�ͥ��Ӫ��
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
    	setLocation(realPoint);//�ƶ��������
    	

		if(hidden){
			//����ͼ��
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
    	}//ȷ����ʼλ
    	
    	homeLoc = location;
    }
    
    
    
    public int getActivity(){   //��������ֵ
    	return activity;
    }
    
    void hit(){   //character(i,j).hit();
    	
    	location = homeLoc;
    	this.repaint();
    	//�����лؼ�
    }
    

	void occupy(int direction){//direction 0 1 2 3�ֱ������������  ��ͬ��ɫ��ռ�췽ʽ��ͬ  �ְ�Ϊ0������Ϊ1������Ϊ2
		this.direction = direction;
    	if(activity>=4){
    	switch(direction){
    	case 0:  //��������
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
    	    
    	         
    	    
    		
    	case 1:  //��������
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
    		
    	case 2: // ��������
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
    		
    	case 3:  //��������
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
    	activity -= 4;     //ռ������4������
    	this.repaint();  //����ռ��ķ���
    	}else{
    		//ֹͣ�ж����߽��������ж�
    	}
    }



      //undone
	private Block Block(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	void molest(int direction, Person rival){//ɧ��
		this.direction = direction;
    	if(activity>=2){
    		
    	//undone
    	rival.hit();
    	activity -= 2;
    	this.repaint();
    	rival.stop();
    	}else{
    		//ֹͣ�ж����߽��������ж�
    	}
    }
    
    void stop(){
    	alive = false;
    }//ֹͣʱ�������״̬
    
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
    	switch(direction){//direction 0 1 2 3�ֱ������������
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
