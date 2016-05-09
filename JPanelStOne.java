package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelStOne extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	
	private JPanelSettingNext jpstn;
	private JMainFrame jMainFrame;
	Point[] points=new Point[]{new Point(0,0),new Point(200,0)};
	private int family ;
	private ImageIcon[] IMG_FAMILY=new ImageIcon[]{new ImageIcon("graphics/setting/family1.png"),new ImageIcon("graphics/setting/family2.png")};
	
	
	public JPanelStOne(JPanelSettingNext jpstn,JMainFrame jframe){
		this.jMainFrame = jframe;
		this.jpstn = jpstn;
		this.setLayout(null);
		this.setBounds(165,40,189,113);
		this.setVisible(true);
		jpstn.add(this);
		family = jMainFrame.getFamily();
		this.repaint();
	}

	
	public void paintComponent(Graphics g){
		g.drawImage(IMG_FAMILY[0].getImage(),points[0].x,points[0].y,null);
		g.drawImage(IMG_FAMILY[1].getImage(),points[1].x,points[1].y,null);
	
	}
	
	
	
	public void run(){
		if(family==0){
			while(points[1].x>0){
				points[1].x-=10;
				points[0].x-=10;
				this.repaint();
				jpstn.repaint();
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			
			points[0].x = -200;
			points[1].x = 0;
			
		}else{
			while(points[1].x<200){
				points[1].x+=10;
				points[0].x+=10;
				this.repaint();
				jpstn.repaint();
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			
			points[0].x = 0;
			points[1].x = 200;
		}
		
		family = 1-family;
		jMainFrame.setFamily(family);
	}
	
	

}
