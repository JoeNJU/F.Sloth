package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Control;


public class JPanelGameNext extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/*当按下暂停按钮，出现继续、重来、回主页面三个按钮
	 * 
	 */
	
	private JMainFrame jMainFrame;
	private Control control;
	private JButton skipButton = new JButton();
	private Point[] points = new Point[]{new Point(689,184),new Point(247,184)};

	
	public JPanelGameNext(JMainFrame jframe,Control control){
		this.jMainFrame = jframe;
		this.control = control;
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(0,JMainFrame.JFRAME_WIDTH-235, JMainFrame.JFRAME_WIDTH,235);
		initialButtons();
		jMainFrame.add(this);
	}
	
	public void paintComponent(Graphics g){
		if(control.personNow.family==1){
			g.drawImage(jMainFrame.everyImage.IMG_ACTIVITY_LEFT[control.personNow.getActivity()-1].getImage(), 0, 0, null);
			g.drawImage(jMainFrame.everyImage.IMG_ACTIVITY_RIGHT[6].getImage(), JMainFrame.JFRAME_WIDTH-247,  0, null);
			g.drawImage(jMainFrame.everyImage.IMG_CHARACTER_HEAD[1][control.personNow.rank].getImage(), 0, 73, null);
			g.drawImage(jMainFrame.everyImage.IMG_CHARACTER_HEAD[0][(control.personNow.rank+1)%3].getImage(), JMainFrame.JFRAME_WIDTH-247, 73, null);
		}else{
			g.drawImage(jMainFrame.everyImage.IMG_ACTIVITY_LEFT[6].getImage(),  0, 0, null);
			g.drawImage(jMainFrame.everyImage.IMG_ACTIVITY_RIGHT[control.personNow.getActivity()-1].getImage(), JMainFrame.JFRAME_WIDTH-247, 0, null);
			g.drawImage(jMainFrame.everyImage.IMG_CHARACTER_HEAD[0][control.personNow.rank].getImage(), JMainFrame.JFRAME_WIDTH-247, 73, null);
			g.drawImage(jMainFrame.everyImage.IMG_CHARACTER_HEAD[1][(control.personNow.rank+1)%3].getImage(), 0, 73, null);
		}
		
		
	
	}
	
	public void initialButtons(){
		//skip
		skipButton.setBorderPainted(false);			
		skipButton.setIcon(jMainFrame.everyImage.IMG_SKIP_BUTTON);
		skipButton.setBounds(points[control.personNow.family].x, points[control.personNow.family].y, jMainFrame.everyImage.IMG_SKIP_BUTTON.getIconWidth(), jMainFrame.everyImage.IMG_SKIP_BUTTON.getIconHeight());
		skipButton.setContentAreaFilled(false);
		this.add(skipButton);
		ButtonListengn listener=new ButtonListengn();
		skipButton.addMouseListener(listener);
		skipButton.addActionListener(listener);
		skipButton.setRequestFocusEnabled(false);
	}
	
	
	
	
	class ButtonListengn extends MouseAdapter implements ActionListener{
		
		
		@Override
		public void mouseEntered(MouseEvent e){
			skipButton.setLocation(points[control.personNow.family].x, points[control.personNow.family].y);
			//setIcon(jFrameGame.allImage.IMG_LOGIN_NEXT1_BUTTONS_ENTERED[i]);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			skipButton.setLocation(points[control.personNow.family].x, points[control.personNow.family].y);
			//buttons[i].setIcon(jMainFrame.everyImage.IMG_LOGIN_BUTTONS[i]);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}

}
