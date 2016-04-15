package ui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class JPanelHelpNext extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	
	private JMainFrame jMainFrame;
	Point[] points=new Point[]{new Point(34,105),new Point(414,105)};
	private int now = 0;
	private int next = 0;
	private boolean isRight = true;
	
	
	public JPanelHelpNext(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		this.setLayout(null);
		this.setBounds(306,98,411,510);
		this.setVisible(true);
		jMainFrame.getContentPane().add(this);
		this.repaint();
	}

	
	public void paintComponent(Graphics g){
		g.drawImage(jMainFrame.everyImage.IMG_HELP_CONTENTS[now].getImage(), points[0].x, points[1].y,339,400,null);
		g.drawImage(jMainFrame.everyImage.IMG_HELP_CONTENTS[next].getImage(), points[1].x, points[1].y,339,400,null);
		if(now==0||next==0){
			g.drawImage(jMainFrame.everyImage.IMG_HELP_TITLES[now].getImage(), points[0].x-6,39,157,44,null);
			g.drawImage(jMainFrame.everyImage.IMG_HELP_TITLES[next].getImage(), points[1].x-6,39,157,44,null);
		}else{
			g.drawImage(jMainFrame.everyImage.IMG_HELP_TITLES[1].getImage(),28,39,157,44,null);
		}
	
	}
	
	public void setDirection(boolean i){
		isRight = i;
	}
	
	public void run(){
		if(isRight){
			next++;
			points[1].x = 414;
			while(points[1].x>34){
				points[1].x-=10;
				points[0].x-=10;
				this.repaint();
				jMainFrame.getContentPane().repaint();
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			points[0].x = 34;		
			now = next;
		}else{
			next--;
			points[1].x = -344;
			while(points[1].x<34){
				points[1].x+=10;
				points[0].x+=10;
				this.repaint();
				jMainFrame.getContentPane().repaint();
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			points[0].x = 34;
			now = next;
		}
	}
	
	

}
