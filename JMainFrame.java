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
	 * ������Ϸ��Frame��
	 */
	
	private int locationX;
	private int locationY;
	
	public EveryImage everyImage;
	
	
	
	public JMainFrame() {
		everyImage=new EveryImage();
		this.setTitle("�̵ذ�");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFRAME_WIDTH, JFRAME_HIGHT);
		this.setResizable(false);
		//����Ϊ����
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();
        this.locationX=(screen.width -this.getWidth())/2;
        this.locationY=(screen.height -this.getHeight())/2;       
	    this.setLocation(this.locationX,this.locationY);
	    //�������
	    //this.setUndecorated(true);//ʧȥ���Ϲرպ���С����ť
	    //this.setVisible(true);
	    
	    this.setVisible(true);

	}
	
	private Point loc = null;
	private Point tmp = null;
	private boolean isDragged = false;
	private JMainFrame jMainFrame = this;
	
	/**
	 * �϶�panel�����ƶ�����λ��
	 */
	
	 public void setDragable(JPanel panel) {
	    	panel.addMouseListener(new MouseAdapter() {
	            public void mouseReleased(MouseEvent e) {
	               isDragged = false;
	               //TODO �������ͼ��
	            //   jFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }
	            public void mousePressed(MouseEvent e) {
	               tmp = new Point(e.getX(), e.getY());
	               isDragged = true;
	             //TODO �������ͼ��
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
