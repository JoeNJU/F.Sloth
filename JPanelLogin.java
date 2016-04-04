
package ui;
/*共有四个主按钮，和一个标题，右上角三个小按钮，
点击任何一个主按钮，标题向上飞走，按钮向下飞走
鼠标移到按钮上换图（先用改颜色代替）
第一个按钮:W:360 H:68 X: 335 Y:315  空白高27
（标题和右上角小按钮先随便放）

技术建议：
1. 标题用JLabel
2. 按钮组0123分别对应主按钮，456对应小按钮
3. 在所有的ButtonListener事件中用if来确定哪个按钮（可以用全局变量i）
4. 飞走效果建议用组件的setLocation，利用新线程，repaint。
5. 一旦飞出就remove前四个按钮
参考Gomoku里的JPanelLogin和JPanelLoginNext1的实现方式（它是飞入，我们是飞出）
矩形1:W:360 H:68 X:335 Y:315
矩形2:W:360 H:68 X:335 Y:410
矩形3:W:360 H:68 X:335 Y:505
矩形4:W:360 H:68 X:335 Y:600*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import ui.JPanelLogin.bgThread;


public class JPanelLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private JMainFrame jMainFrame;
	private static int i;          //全局变量i来确定按钮
	private boolean dark;
	private JButton[] buttons;
	private JLabel title;
	private int bgIndex;
	private static final int JBUTTON_WIDTH=360;      //四个按钮的大小
	private static final int JBUTTON_HIGHT=68;
	private static final int JLABLE_WIDTH=430;       //标题的大小
	private static final int JLABLE_HIGHT=80;
	private static final int JBUTTON2_WIDTH=20;      //三个小按钮的大小
	private static final int JBUTTON2_HIGHT=20;
	private Point[] buttonPoint=new Point[]{new Point(335, 410),new Point(335,505),new Point(315,600),new Point(900,20),new Point(935,20),new Point(970,20)};
	private Point titlePoint=new Point(335, 315);
	
	public JPanelLogin(JMainFrame jframe){
		this.jMainFrame=jframe;
		setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		this.buttons=new JButton[]{
				new JButton("第一个"),
				new JButton("第二个"),
				new JButton("第三个"),
				new JButton("第四个"),
				new JButton("静音"),
				new JButton("帮助"),  
				new JButton("退出")
		};
		
		this.title=new JLabel();
		this.dark=false;
		initial();
		Thread start=new Thread();
		start.start();
		
		

	}
	
	public void initial(){
		buttonListener buttonListener=new buttonListener(i,this);
		
		for(int i=0;i<=6;i++){
		this.add(buttons[i]);
		this.buttons[i].setBounds(buttonPoint[i].x, buttonPoint[i].y, 360, 68);
		buttons[i].addMouseListener(buttonListener);
		buttons[i].addActionListener(buttonListener);
		
		}
		
		
		JLabel title=new JLabel();
		this.add(title);
		this.title.setBounds(300, 720, 430, 80);

	}
	
	@Override
    public void paintComponent(Graphics g){
		if(!dark){

		g.drawRect(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		g.drawRect(335, 315, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g.drawRect(335, 410, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g.drawRect(335, 505, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g.drawRect(335, 600, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g.drawRect(300, 720, JLABLE_WIDTH, JLABLE_HIGHT);
		g.drawRect(900, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
		g.drawRect(935, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
		g.drawRect(970, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
	    }
	
    }
	
	
	
	private void runIn(){
		Point startTitlePoints=new Point(360,720);
		Point[] startButtonPoints=new Point[]{new Point(360,315),new Point(360,410),new Point(360,505),new Point(360,600)};
		//标题飞入动画
			while(this.titlePoint.y!=startTitlePoints.y){
				this.titlePoint.y-=10;
				this.repaint();
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {	}
			}
		
		new Thread(new bgThread()).start();
		//按钮飞入动画
		for (int i = 0; i <= this.buttonPoint.length; i++) {
			while(this.buttonPoint[i].y!=startButtonPoints[i].y){
				this.buttonPoint[i].y-=10;
				this.buttons[i].setLocation(this.buttonPoint[i]);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {	}
			}
		}
	}
	
	private void runOut(){
		//运动的方法(飞出)
		//最终标题的坐标
				Point finalTitlePoints=new Point(360,1241);
				Point[] finalButtonPoints=new Point[]{new Point(360,1836),new Point(360,931),new Point(360,1026),new Point(360,1121)};
				//标题飞出动画
					while(this.titlePoint.y!=finalTitlePoints.y){
						this.titlePoint.y+=10;
						this.repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {	}
					}
				
					new Thread(new bgThread()).start();
				//按钮飞出动画
				for (int i = 0; i <= this.buttonPoint.length; i++) {
					while(this.buttonPoint[i].y!=finalButtonPoints[i].y){
						this.buttonPoint[i].y+=10;
						this.buttons[i].setLocation(this.buttonPoint[i]);
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {	}
					}
				}
	}
	
	public void getDark() {
		this.dark=true;
		repaint();
	}
	
	public void removeButtons() {
		for (JButton button : buttons) {
			this.remove(button);
		}
	}
	
	public void getBright() {
		this.dark=false;
		initial();
		repaint();
	}
	
	class buttonListener extends MouseAdapter implements ActionListener{

		int i;
		JPanelLogin jPanelLogin;
		JPanelLoginNext1 jPanelLoginNext1;

		private buttonListener(int i, JPanelLogin jPanelLogin){
			this.i=i;
			this.jPanelLogin=jPanelLogin;
		}
		
/*  	@Override
		public void mouseEntered(MouseEvent e){
			buttons[i].setIcon(jFrameGame.allImage.IMG_LOGIN_BUTTONS_ENTERED[i]);
			

		}
		@Override
		public void mouseExited(MouseEvent e){
			buttons[i].setIcon(jFrameGame.allImage.IMG_LOGIN_BUTTONS[i]);

		}
		鼠标移动到和离开时的动作，也许能用上
*/

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(i==1){
			//  需要添加    按钮一的专属动作
                runOut();
                removeButtons();
			}
			if(i==2){
		    //  需要添加    按钮二的专属动作
                runOut();
                removeButtons();
			}
			if(i==3){
			//  需要添加    按钮的专属动作
				runOut();
				removeButtons();
			}
			if (i==4) {
			//  需要添加    按钮的专属动作
			}
			if(i==5){
			//  需要添加    按钮的专属动作
			}
			if (i==6) {
			//  需要添加    按钮的专属动作
			}
			
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
	}
}
	

