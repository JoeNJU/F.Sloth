package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelAboutUs extends JPanel{
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的开发者介绍界面
	 * 是首要简单任务
	 */
	
	private JMainFrame jMainFrame;


	
	public JPanelAboutUs(JMainFrame jframe){
		this.jMainFrame = jframe;
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
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
