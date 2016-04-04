package ui;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;


import javax.swing.JFrame;


public class JMainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	
	public static final int JFRAME_WIDTH=1024;
	public static final int JFRAME_HIGHT=768;
	/**
	 * 整个游戏的Frame，
	 */
	
	private int locationX;
	private int locationY;
	
	public EveryImage everyImage;
	
	
	
	public JMainFrame() {
		everyImage=new EveryImage();
		this.setTitle("铺地板");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFRAME_WIDTH, JFRAME_HIGHT);
		this.setResizable(false);
		//下面为居中
        	Toolkit toolkit=Toolkit.getDefaultToolkit();
        	Dimension screen=toolkit.getScreenSize();
        	this.locationX=(screen.width -this.getWidth())/2;
		this.locationY=(screen.height -this.getHeight())/2;       
		this.setLocation(this.locationX,this.locationY);
	    //居中完毕
	    	setCursor(Toolkit.getDefaultToolkit().createCustomCursor(everyImage.CURSOR, new Point(), null));
	    //this.setUndecorated(true);//失去顶上关闭和最小化按钮
	    //this.setVisible(true);
	    
	    this.setVisible(true);

	}
	
	private Point loc = null;
	private Point tmp = null;
	private boolean isDragged = false;
	private JMainFrame jMainFrame = this;
	
	/**
	 * 拖动panel可以移动窗体位置
	 */
	
	 public void setDragable(JPanel panel) {
	    	panel.addMouseListener(new MouseAdapter() {
	            public void mouseReleased(MouseEvent e) {
	               isDragged = false;
	               //TODO 更换鼠标图案
	            //   jFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }
	            public void mousePressed(MouseEvent e) {
	               tmp = new Point(e.getX(), e.getY());
	               isDragged = true;
	             //TODO 更换鼠标图案
	             //  jFrame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	            }
	        });
	    	panel.addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(MouseEvent e) {
	               if(isDragged) {
	            	   loc = new Point(jMainFrame.getLocation().x + e.getX() - tmp.x,jMainFrame.getLocation().y + e.getY() - tmp.y);
	                   jMainFrame.setLocation(loc);
	               }
	            }
	        });
	 }

}
