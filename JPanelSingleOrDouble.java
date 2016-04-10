package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelSingleOrDouble extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 611;
	public static final int HIGHT = 561;
	/*本类用于游戏选择单双人游戏
	 * frame必须用add方法
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;

	
	public JPanelSingleOrDouble(JMainFrame jframe){
		this.jMainFrame = jframe;		
		this.setLayout(null);
		this.setVisible(true);
		this.initialButtons();
		jMainFrame.getContentPane().add(this);
		new Thread(this).start();
		this.repaint();
	}

	public void run() {
		int i = 561;//206,0,611,561
		while(i>=0){
			this.setBounds(206,0-i,611,561);
			i-=20;
			jMainFrame.getContentPane().repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}
	
	
	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		//g.drawImage(jMainFrame.everyImage.IMG_LOGIN_NEXT1, 0, 0, null);
	
	}
	
	
	public void removeMe() {
		
		jMainFrame.getContentPane().remove(this);
	}
	
	
	private void initialButtons() {
		this.buttons=new JButton[]{new JButton("Single"),new JButton("Double"),new JButton("Back")};
		Point[] points=new Point[]{new Point(100,200),new Point(311,200),new Point(500,30)};
		for (int i = 0; i < points.length; i++) {
			buttons[i].setBounds(points[i].x, points[i].y, 200,300);//buttons[i].getIcon().getIconWidth(), buttons[i].getIcon().getIconHeight()
			buttons[i].setBorderPainted(false);
			//buttons[i].setContentAreaFilled(false);
			this.add(buttons[i]);
			ButtonListenersod listener=new ButtonListenersod(i,this);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
		} 
		buttons[2].setBounds(points[2].x, points[2].y, 80,40);
	}
	
	
	
	class ButtonListenersod extends MouseAdapter implements ActionListener{
		int i;
		JPanelSingleOrDouble jPanelsod;
		private ButtonListenersod(int i, JPanelSingleOrDouble jPanelsod){
			this.i=i;
			this.jPanelsod = jPanelsod;
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			
			buttons[i].setText("aaa"+buttons[i].getText());//setIcon(jFrameGame.allImage.IMG_LOGIN_NEXT1_BUTTONS_ENTERED[i]);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			
			buttons[i].setText(buttons[i].getText().substring(3));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (i) {
			case 0:
				System.exit(0);
				break;
			case 1:
				
				break;
			case 2:
				new Thread(new closingThread()).start();
				
				break;
			default:
				break;
			}
		}
	}
	
	class closingThread implements Runnable{

		@Override
		public void run() {
			
			int i=0;//206,0,611,561
			while(i<=561){
				setBounds(206,0 - i,611,561);
				i+=20;
				jMainFrame.getContentPane().repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			removeMe();
			JPanelLogin jPanelLogin = (JPanelLogin)jMainFrame.getContentPane();
			jPanelLogin.startAdd();
			//JPanelPerform panel=new JPanelPerform(jMainFrame);
			//jMainFrame.setContentPane(panel);
		}
		
	}

}
