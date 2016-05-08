package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JPanelSetting extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的设置界面
	 * 是首要任务
	 * 
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;
	private JPanelSettingNext jpsn;
	private Point[] points;

	
	public JPanelSetting(JMainFrame jframe){
		this.jMainFrame = jframe;	
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH,JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		jMainFrame.setContentPane(this);
		this.initialButtons();
		repaint();
	}
	
	public void paintComponent(Graphics g){

		g.drawImage(jMainFrame.everyImage.IMG_SETTING_BG,0,0,null);
	
	}
	
	private void initialButtons() {
		this.buttons=new JButton[]{new JButton(),new JButton()};
		points=new Point[]{new Point(459,620),new Point(518,620)};
		for (int i = 0; i < points.length; i++) {
			buttons[i].setBounds(points[i].x, points[i].y, 50,100);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_ST_BUTTONS[i]);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			this.add(buttons[i]);
			buttons[i].setRequestFocusEnabled(false);
			ButtonListenerjs listener=new ButtonListenerjs(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
		} 
		
		jpsn = new JPanelSettingNext(jMainFrame);
	}
	
	
	
	
	class ButtonListenerjs extends MouseAdapter implements ActionListener{
		int i;
		private ButtonListenerjs(int i){
			this.i=i;
		}
		
		public void mouseEntered(MouseEvent e){
			buttons[i].setLocation(points[i].x+2,points[i].y-2);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			buttons[i].setLocation(points[i].x,points[i].y);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}

}