package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLoginNext extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 492;
	public static final int HIGHT = 441;
	/*本类用于游戏首页的主按钮
	 * frame必须用add方法
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;
	private boolean isRemoved = false;

	
	public JPanelLoginNext(JMainFrame jframe){
		this.jMainFrame = jframe;
		jMainFrame.getContentPane().add(this);
		this.setLayout(null);
		this.setVisible(true);
		this.initialButtons();
		
		new Thread(this).start();
		this.repaint();
	}


	public void run() {
		int i = 0;//273,327,492,441
		while(i<441){
			this.setBounds(273,768-i,492,441);
			i+=22;
			jMainFrame.getContentPane().repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}
	
	
	public void paintComponent(Graphics g){

		g.drawImage(jMainFrame.everyImage.IMG_LOGIN_NEXT, 0, 0, null);
	
	}
	
	
	public void removeMe() {
		
		jMainFrame.getContentPane().remove(this);
	}
	
	
	private void initialButtons() {
		this.buttons=new JButton[]{new JButton(),new JButton(),new JButton(),new JButton()};
		Point[] points=new Point[]{new Point(104,67),new Point(129,144),new Point(73,218),new Point(129,304)};
		for (int i = 0; i < points.length; i++) {
			buttons[i].setBounds(points[i].x, points[i].y,jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getHeight(null));
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i]);
			this.add(buttons[i]);
			ButtonListenerln listener=new ButtonListenerln(i,this);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
		} 
	}
	
	
	
	class ButtonListenerln extends MouseAdapter implements ActionListener{
		int i;
		JPanelLoginNext jPanelln;
		private ButtonListenerln(int i, JPanelLoginNext jPanelln){
			this.i=i;
			this.jPanelln = jPanelln;
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			Point[] points=new Point[]{new Point(108,63),new Point(133,140),new Point(77,214),new Point(133,300)};
			buttons[i].setBounds(points[i].x, points[i].y,jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getHeight(null));
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			Point[] points=new Point[]{new Point(104,67),new Point(129,144),new Point(73,218),new Point(129,304)};
			buttons[i].setBounds(points[i].x, points[i].y,jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getWidth(null),jMainFrame.everyImage.IMG_LOGIN1_BUTTONS[i].getImage().getHeight(null));
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanelLogin jPanelLogin = (JPanelLogin)jMainFrame.getContentPane();
			switch (i) {
			case 0:
				new Thread(new closingThread(i)).start();
				
				new Thread(jPanelLogin).start();
				break;
			case 1:
				new Thread(new closingThread(i)).start();
				
				new Thread(jPanelLogin).start();
				break;
			case 2:
				new Thread(new closingThread(i)).start();
				
				new Thread(jPanelLogin).start();
				break;
			case 3:
				new Thread(new closingThread(i)).start();
				
				new Thread(jPanelLogin).start();
				break;
			default:
				break;
			}
		}
	}
	
	class closingThread implements Runnable{
		int i;
		closingThread(int i){
			this.i = i;
		}

		@Override
		public void run() {
			
			int j=0;//273,327,492,441
			while(j<440){
				setBounds(273,327+j,492,441);
				j+=22;
				jMainFrame.getContentPane().repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			removeMe();
			switch (i) {
			case 0:
				@SuppressWarnings("unused")
				JPanelSingleOrDouble jpanelsod = new JPanelSingleOrDouble(jMainFrame);		
				break;
			case 1:
				
				
				break;
			case 2:
				
				
				break;
			case 3:
				
				
				break;
			}
			
			
		}
		
	}

}
