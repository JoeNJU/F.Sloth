package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JPanelStop extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/*当按下暂停按钮，出现继续、重来、回主页面三个按钮
	 * 
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons = new JButton[4];
	private Point[] points = new Point[]{new Point(150,300),new Point(300,100),new Point(500,100),new Point(700,100)};

	
	public JPanelStop(JMainFrame jframe){
		this.jMainFrame = jframe;
		this.setLayout(null);
		this.setVisible(false);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		jMainFrame.setDragable(this);
		jMainFrame.add(this);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(jMainFrame.everyImage.IMG_STOP_BG, 0, 0, null);
		
	
	}
	
	public void initialButtons(){
		//4个按钮分别为音量，重开，主页面，继续
		for (int i = 0; i < 4; i++) {
			buttons[i] = new JButton();
			buttons[i].setBorderPainted(false);			
			buttons[i].setIcon(jMainFrame.everyImage.IMG_STOP_BUTTONS[i]);
			buttons[i].setBounds(points[i].x, points[i].y, jMainFrame.everyImage.IMG_STOP_BUTTONS[i].getIconWidth(), jMainFrame.everyImage.IMG_STOP_BUTTONS[i].getIconHeight());
			buttons[i].setContentAreaFilled(false);
			this.add(buttons[i]);
			ButtonListenjps listener=new ButtonListenjps(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
			buttons[i].setRequestFocusEnabled(false);
		} 
	}
	
	
	
	
	class ButtonListenjps extends MouseAdapter implements ActionListener{
		int i;
		private ButtonListenjps(int i){
			this.i=i;
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			buttons[i].setLocation(points[i].x+2, points[i].y-2);
			//setIcon(jFrameGame.allImage.IMG_LOGIN_NEXT1_BUTTONS_ENTERED[i]);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			buttons[i].setLocation(points[i].x, points[i].y);
			//buttons[i].setIcon(jMainFrame.everyImage.IMG_LOGIN_BUTTONS[i]);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (i) {
			case 0:
				
				break;//音量
			case 1:
				@SuppressWarnings("unused")
				JPanelGame jPanelGame = new JPanelGame(jMainFrame);
				break;//重开
			case 2:
				@SuppressWarnings("unused")
				JPanelLogin panel=new JPanelLogin(jMainFrame);
				break;//主菜单
			case 3:
				setVisible(false);
				break;//继续
			default:
				break;
			}
		}
	}

}
