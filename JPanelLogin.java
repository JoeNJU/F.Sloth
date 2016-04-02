package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JPanelLogin extends JPanel implements Runnable{
	/***/
	private static final long serialVersionUID=1L;  //序列化//
	
	//应该放入title和button的位置//
	private JMainFrame jMainFrame;
	private JButton[] buttons;
	private JButton[] buttons;
	private int bgIndex;
	
	//开始界面//
	public JPanelLogin(JMainFrame jframe){
 		this.jMainFrame = jframe;
 		this.buttons=new JButton[]{new JButton(jFrameGame.allImage.IMG_LOGIN_BUTTONS[0]),new JButton(jFrameGame.allImage.IMG_LOGIN_BUTTONS[1])}
 		this.setLayout(null);
 		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
 		this.setVisible(true);
 		jMainFrame.setDragable(this);
 		this.initial();
 	}
 	
	private void buttonsInitial() {
		for (int i = 0; i < buttons.length; i++) {
			this.add(buttons[i]);    //按钮属性//
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBounds(buttonPoints[i].x, buttonPoints[i].y,jFrameGame.allImage.IMG_LOGIN_BUTTONS[i].getImage().getWidth(null),jFrameGame.allImage.IMG_LOGIN_BUTTONS[i].getImage().getHeight(null));
			buttonMouseAdapterAndActionListener buttonMouseAdapterAndActionListener=new buttonMouseAdapterAndActionListener(i,this);
			if(buttons[i].getMouseListeners().length<2){
			buttons[i].addMouseListener(buttonMouseAdapterAndActionListener);
			}
			if(buttons[i].getActionListeners().length<1){
			buttons[i].addActionListener(buttonMouseAdapterAndActionListener);
			}
		}
	}
	
 	
	
	public void paintComponent(Graphics g){
          g.drawRect(0,0,JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
 	}
	
	private void drawTitle(Graphics g) {
		for (int i = 0; i < this.titlePoints.length; i++) {
			g.drawImage(jFrameGame.allImage.IMG_LOGIN_TITLE, titlePoints[i].x, titlePoints[i].y, titlePoints[i].x+TITLE_WIDTH, titlePoints[i].y+TITLE_HEIGHT, i*jFrameGame.allImage.IMG_LOGIN_TITLE_WIDTH, 0, (i+1)*jFrameGame.allImage.IMG_LOGIN_TITLE_WIDTH, jFrameGame.allImage.IMG_LOGIN_TITLE_HEIGHT, null);
		}
	}
	
	@Override
	public void run() {
		//最终标题的坐标
		Point[] finalTitlePoints=new Point[]{new Point(369,511),new Point(497,511),new Point(625,511),new Point(753,511),new Point(881,511)};
		Point[] finalButtonPoints=new Point[]{new Point(777,142),new Point(777,234),new Point(777,324),new Point(777,414)};
		//标题飞入动画
		for (int i = 0; i < this.titlePoints.length; i++) {
			while(this.titlePoints[i].x!=finalTitlePoints[i].x){
				this.titlePoints[i].x-=10;
				this.repaint();
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {	}
			}
		}
		new Thread(new bgThread()).start();
		//按钮飞入动画
		for (int i = 0; i < this.buttonPoints.length-2; i++) {
			while(this.buttonPoints[i].x!=finalButtonPoints[i].x){
				this.buttonPoints[i].x-=10;
				this.buttons[i].setLocation(this.buttonPoints[i]);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {	}
			}
		}
	}
	
	public void removeButtons() {
		for (JButton button : buttons) {
			this.remove(button);
		}
	}
	
	class buttonMouseAdapterAndActionListener extends MouseAdapter implements ActionListener{
		int i;
		JPanelLogin jPanelLogin;
		JPanelLoginNext jPanelLoginNext;
		
		private buttonMouseAdapterAndActionListener(int i, JPanelLogin jPanelLogin){
			this.i=i;
			this.jPanelLogin=jPanelLogin;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(i==0){
				if(jPanelLoginNext!=null&&jPanelLoginNext.isRunning()){
					jPanelLoginNext.setMouseLeaveButton(false);
					return;
				}
				if(jPanelLoginNext==null){
				jPanelLoginNext = new JPanelLoginNext(jFrameGame);
				}jPanelLoginNext.setLayout(null);
				jPanelLoginNext.setVisible(true);
				jFrameGame.add(jPanelLoginNext);
				jPanelLoginNext.startAdd();
				jPanelLoginNext.repaint();
			}
			if (i == 1) {
				setVisible(false);
				jFrameGame.setContentPane(new JPanelClearlist(jFrameGame));
			}
		}
	
 	
		class bgThread implements Runnable{

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(bgIndex<123){
						bgIndex++;
					}else{
						bgIndex=0;
					}
					repaint();
				}
			}
			
			
		
	
 	
 	
 	
 	

 	
 	
 	
 	
 	
 		
 		
 
 


	
	
	


