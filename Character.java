package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Character extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	//String name;
	private int family;
    private int rank;//����Ϊ0���ְ�Ϊ1������Ϊ2
    private int score = 0;
    private Point location;//ʵ������
    private int vision;
    private int activity = 7;//����
    private Point[] homeLoc;
    private int x;
    private int y;
    private boolean hidden = false;
    private boolean alive = true;
    private boolean isMove = false;
    
    Character(int family, int rank){
    	this.family = family;
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
    	
    	this.setLocation(location);//�ƶ��������

		if(hidden){
			//����ͼ��
		}else{
			
		}
	
	}
    
    void hit(){
    	location = homeLoc[rank];
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
				
				break;
			case KeyEvent.VK_RIGHT:
				
				break;
			case KeyEvent.VK_UP:
				
				break;
			case KeyEvent.VK_DOWN:
				
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
