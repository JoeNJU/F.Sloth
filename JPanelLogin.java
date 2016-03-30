package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLogin extends JPanel{
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的登陆界面
	 * 是首要任务
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;//包括右上角的三个按钮，分别为静音，帮助，退出

	
	public JPanelLogin(JMainFrame jframe){
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
