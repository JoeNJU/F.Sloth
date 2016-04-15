package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JPanelHelp extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanelHelpNext jPanelhn;
	private int turn = 0;
	private JMainFrame jMainFrame;
	private JButton[] buttons;
	Point[] points=new Point[]{new Point(619,584),new Point(500,593),new Point(550,593)};
	
	public JPanelHelp(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		jMainFrame.setContentPane(this);
		jPanelhn = new JPanelHelpNext(jMainFrame);
		this.repaint();
		this.initialButtons();
	}
	
	void initialButtons(){
		this.buttons=new JButton[]{new JButton(),new JButton(),new JButton()};
		
		for (int i = 0; i < points.length; i++) {
			buttons[i].setBounds(points[i].x, points[i].y,jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getHeight(null));
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_HELP_BUTTONS[i]);
			this.add(buttons[i]);
			ButtonListenerh listener=new ButtonListenerh(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
		} 
		buttons[1].setVisible(false);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.green);
		g.fillRect(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
	}
	
	class ButtonListenerh extends MouseAdapter implements ActionListener{
		int i;
		private ButtonListenerh(int i){
			this.i=i;
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			buttons[i].setBounds(points[i].x+2, points[i].y-2,jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getHeight(null));
			//setIcon(jFrameGame.allImage.IMG_LOGIN_NEXT1_BUTTONS_ENTERED[i]);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			buttons[i].setBounds(points[i].x, points[i].y,jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_HELP_BUTTONS[i].getImage().getHeight(null));
			//buttons[i].setIcon(jMainFrame.everyImage.IMG_LOGIN_BUTTONS[i]);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (i) {
			case 0:
				@SuppressWarnings("unused")
				JPanelLogin jPanelLogin = new JPanelLogin(jMainFrame);
				break;//·µ»Ø¼ü
			case 1:
				turn--;
				if(turn == 0){
					buttons[1].setVisible(false);
				}
				buttons[2].setVisible(true);
				jPanelhn.setDirection(false);
				new Thread(jPanelhn).start();
				break;//Ïò×ó
			case 2:
				turn++;
				if(turn==3){
					buttons[2].setVisible(false);
				}
				buttons[1].setVisible(true);
				jPanelhn.setDirection(true);
				new Thread(jPanelhn).start();
				break;//ÏòÓÒ
			default:
				break;
			}
		}
	}


}
