package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLoginButton extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=360;
	public static final int HIGHT=353;
	/*����������Ϸ�ĵ�½�����м�İ�ť����
	 * ����Ҫ����
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;//�����ĸ���ť��0:start game,1:setting,2:achievement,3:about us
	//ÿ����ť��68���հ׸�27
	
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
