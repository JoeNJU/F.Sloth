package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelStop extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/*��������ͣ��ť�����ּ���������������ҳ��������ť
	 * 
	 */
	
	private JMainFrame jMainFrame;

	
	public JPanelStop(JMainFrame jframe){
		this.jMainFrame = jframe;
		this.setLayout(null);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		this.initial();
	}
	
	public void paintComponent(Graphics g){

		
	
	}
	
	public void initial(){
		
	}
	
	
	
	
	class ButtonListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}

}
