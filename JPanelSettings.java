package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JPanelSettings extends JFrame{
	private static final long serialVersionUID=1L;  //���л�//
	
	public static final int JFrame_WIDTH=1024;
	public static final int JFrame_HIGHT=768;
	
	
	private int locationX;
	private int locationY;
	//���ý���//
	public JPanelSettings(){
		this.setTitle("�������");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(JFrame_WIDTH, JFrame_HIGHT);
		this.setResizable(true);
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();
        this.locationX=(screen.width -this.getWidth())/2;
        this.locationY=(screen.height -this.getHeight())/2;       
	    this.setLocation(this.locationX,this.locationY);
		
		this.setVisible(true);
		
		
	}
	public void add(JpanelForm b) {
		// TODO Auto-generated method stub
		
	}

}
