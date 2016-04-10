package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelLogin extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的登陆界面
	 * 开始游戏，成就，关于我们，退出游戏
	 */
	
	private JMainFrame jMainFrame;
	private JPanelLoginNext jPanelLoginNext;
	private JButton[] buttons;//包括右上角的三个按钮，分别为静音，帮助，退出
	private Point titlePoint = new Point(46,-341);
	private boolean close = false;

	
	public JPanelLogin(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		jMainFrame.setContentPane(this);
		this.startAdd();
		this.repaint();
		this.initialButtons();
	}
	
	public void run() {
		//46,94,940,341
		if(close){
			while(this.titlePoint.y>-341){
				this.titlePoint.y -= 8;
				this.repaint();
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			close = false;
		}else{
			while(this.titlePoint.y<94){
				this.titlePoint.y += 8;
				this.repaint();
				try {
					Thread.sleep(8);
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			close = true;
		}
	}
	
	public void startAdd(){
		new Thread(this).start();
		jPanelLoginNext = new JPanelLoginNext(jMainFrame);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		g.setColor(Color.green);
		g.fillRect(titlePoint.x, titlePoint.y,940,341);
		//g.drawImage(jMainFrame.everyImage.IMG_LOGIN_TITLE, titlePoint.x, titlePoint.y,940,341,null);
	
	}
	
	public void initialButtons(){
		
		
	}
	
	public void start(){
		jPanelLoginNext = new JPanelLoginNext(jMainFrame);
		
	}
	
	
	
	
	class ButtonListenerl implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
			
	}

}