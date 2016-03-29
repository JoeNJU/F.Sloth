package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelRound extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的关卡选择界面
	 * 不是首要任务
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;

	
	public JPanelRound(JMainFrame jframe){
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
