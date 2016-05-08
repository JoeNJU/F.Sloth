package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ui.JPanelSetting.ButtonListenerjs;

public class JPanelSettingNext extends JPanel{
	private static final long serialVersionUID = 1L;
	
	
	private JMainFrame jMainFrame;
	private Point[] points;
	private JButton[] buttons;
	
	public JPanelSettingNext(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		this.setLayout(null);
		this.setBounds(315,352,397,280);
		this.setVisible(true);
		jMainFrame.getContentPane().add(this);
		initial();
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(jMainFrame.everyImage.IMG_STN_BG, 0, 0, null);
		g.drawImage(jMainFrame.everyImage.IMG_SETTING_SINGLE,points[4].x,points[4].y,null);
		g.drawImage(jMainFrame.everyImage.IMG_SETTING_FAMILY,points[5].x,points[5].y,null);
		g.drawImage(jMainFrame.everyImage.IMG_SETTING_BLOCK,points[6].x,points[6].y,null);
		
		
		
	
	}
	
	public void initial(){
		buttons=new JButton[]{new JButton(),new JButton(),new JButton(),new JButton()};
		points=new Point[]{new Point(140,44),new Point(330,44),new Point(140,164),new Point(330,164),new Point(15,15),new Point(61,80),new Point(21,200)};
		for (int i = 0; i < 4; i++) {
			buttons[i].setBounds(points[i].x, points[i].y, 50,100);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_STN_BUTTONS[i%2]);
			this.add(buttons[i]);
			buttons[i].setRequestFocusEnabled(false);
			ButtonListenerjsn listener=new ButtonListenerjsn(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
		}
	}
	
	class ButtonListenerjsn extends MouseAdapter implements ActionListener{
		int i;
		private ButtonListenerjsn(int i){
			this.i=i;
		}
		
		public void mouseEntered(MouseEvent e){
			buttons[i].setLocation(points[i].x+2,points[i].y-2);
			
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		public void mouseExited(MouseEvent e){
			buttons[i].setLocation(points[i].x,points[i].y);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}
	

}
