package game;

import java.awt.*;

import javax.swing.*;


public class Character extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//String name;
    private int rank;//����Ϊ0���ְ�Ϊ1������Ϊ2
    private int score = 0;
    private Point location;//ʵ������
    private int direction;
    private int vision;
    private int activity = 7;//����
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
    	
    	this.setLocation(location);//�ƶ��������

		if(hidden){
			//����ͼ��
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
			//ԭ��ͼ��
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
    }//0��1�ң�2�ϣ�3��

}
