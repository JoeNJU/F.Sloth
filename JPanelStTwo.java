package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelStTwo extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	
	private JPanelSettingNext jpstn;
	private JMainFrame jMainFrame;
	Point[] points=new Point[]{new Point(0,0),new Point(200,0)};
	private int blockStyle;
	private ImageIcon[] IMG_BLOCK=new ImageIcon[]{new ImageIcon("graphics/setting/block1.png"),new ImageIcon("graphics/setting/block2.png")};
	
	
	public JPanelStTwo(JPanelSettingNext jpstn,JMainFrame jframe){
		this.jMainFrame = jframe;
		this.jpstn = jpstn;
		this.setLayout(null);
		this.setBounds(168,195,185,43);
		this.setVisible(true);
		blockStyle = jMainFrame.getBlockStyle();
		jpstn.add(this);
		this.repaint();
	}

	
	public void paintComponent(Graphics g){
		g.drawImage(IMG_BLOCK[0].getImage(),points[0].x,points[0].y,null);
		g.drawImage(IMG_BLOCK[1].getImage(),points[1].x,points[1].y,null);
	
	}
	
	public void run(){
		if(blockStyle==0){
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
		
		blockStyle = 1-blockStyle;
		jMainFrame.setBlockStyle(blockStyle);
	}
	
	

}
