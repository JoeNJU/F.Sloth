package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Character extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	//String name;
	private int family;//0�ż�ͥ�����½�����
    private int rank;//�ְ�Ϊ0������Ϊ1������Ϊ2
    private int score = 0;
    private Point location;//ʵ������
    private int vision;
    private int activity = 7;//����
    private Point homeLoc;//012Ϊ0�ż�ͥ��Ӫ��
    private boolean hidden = false;
    private boolean alive = true;
    private boolean isMove = false;
    
    Character(int family, int rank){
    	this.family = family;
    	this.rank = rank;
    	this.initial();
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
    
    public void paintComponent(Graphics g){
    	
    	this.setLocation(location);//�ƶ��������

		if(hidden){
			//����ͼ��
		}else{
			
		}
	
	}
    
    int getActivity(){
    	return activity;
    }
    
    void hit(){
    	location = homeLoc;
    	this.repaint();
    	//���лؼ�
    }
    
    void occupy(int direction){
    	activity -= 4;
    	this.repaint();//����ռ��ķ���
    	//ռ������4������
    }
    
    void molest(int direction, Character rival){//ɧ��
    	activity -= 2;
    	this.repaint();
    	rival.stop();
    }
    
    void stop(){
    	alive = false;
    }//ֹͣʱ�������״̬
    
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
    
    void move(){
    	isMove = true;
    }
    
    void stopMove(){
    	isMove = false;
    }
    
    @Override
	public void keyPressed(KeyEvent arg0) {
		if(isMove){
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_LEFT:
				location.x --;
				break;
			case KeyEvent.VK_RIGHT:
				location.x ++;
				break;
			case KeyEvent.VK_UP:
				location.y --;
				break;
			case KeyEvent.VK_DOWN:
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
