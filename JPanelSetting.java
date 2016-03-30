package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelSetting extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 470;
	public static final int HIGHT = 430;
	/*本类用于游戏的设置界面
	 * 是首要任务
	 * 设置 成就 关于我们 面板:位置:X:275 Y:256大小:W:470 H:430
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;

	
	public JPanelSetting(JMainFrame jframe){
		this.jMainFrame = jframe;
		this.setLayout(null);
		this.setBounds(0, 0, WIDTH,HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		this.initial();
	}
	
	public void paintComponent(Graphics g){

		g.drawRect(0,0,JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
	
	}
	
	public void initial(){
		
		
	}
	
	
	
	
	class ButtonListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}

}
