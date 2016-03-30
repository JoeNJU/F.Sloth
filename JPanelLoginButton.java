package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLoginButton extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=360;
	public static final int HIGHT=353;
	/*本类用于游戏的登陆界面中间的按钮放置
	 * 是首要任务
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;//包括四个按钮，0:start game,1:setting,2:achievement,3:about us
	//每个按钮高68，空白高27
	
	public JPanelLoginButton(JMainFrame jframe){
		this.jMainFrame = jframe;
		this.setLayout(null);
		this.setBounds(0, 0, WIDTH, HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		this.initial();
	}
	
	public void paintComponent(Graphics g){

		g.drawRect(0,0,WIDTH, HIGHT);
	
	}
	
	public void initial(){
		
		
	}
	
	
	
	
	class ButtonListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}

}
