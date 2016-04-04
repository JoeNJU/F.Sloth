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


public class JPanelLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private JMainFrame jMainFrame;
	private static int i;          //全局变量i来确定按钮
	private boolean dark;
	private JButton[] buttons;
	private JLabel title;
	private static final int JBUTTON_WIDTH=360;      //四个按钮的大小
	private static final int JBUTTON_HIGHT=68;
	private static final int JLABLE_WIDTH=430;       //标题的大小
	private static final int JLABLE_HIGHT=80;
	private static final int JBUTTON2_WIDTH=20;      //三个小按钮的大小
	private static final int JBUTTON2_HIGHT=20;
	private Point[] buttonPoint=new Point[]{new Point(1037,142),new Point(1037,234),new Point(1037,324),new Point(1037,414),new Point(933,0),new Point(981,0)};
	private Point titlePoint=new Point(300,200);
	
	public JPanelLogin(JMainFrame jframe){
		this.jMainFrame=jframe;
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		setLayout(null);
		this.buttons=new JButton[]{
				new JButton("第一个"),
				new JButton("第二个"),
				new JButton("第三个"),
				new JButton("第四个"),
				new JButton("静音"),
				new JButton("帮助"),  
				new JButton("退出")
		};
		this.buttons[0].setBounds(335, 315, 360, 68);
		this.buttons[1].setBounds(335, 410, 360, 68);
		this.buttons[2].setBounds(335, 505, 360, 68);
		this.buttons[3].setBounds(335, 600, 360, 68);
		this.buttons[4].setBounds(900, 750, 20, 20);
		this.buttons[5].setBounds(935, 750, 20, 20);
		this.buttons[6].setBounds(970, 750, 20, 20);
		
		title.setBounds(300, 720, 430, 80);
		this.title=new JLabel();
		this.dark=false;
		this.initial();
		

	}
	
	@Override
    public void paintComponent(Graphics g){
		if(!dark){
		Graphics2D g2d=(Graphics2D) g;
		g2d.drawRect(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		g2d.setPaint(Color.green);
		g2d.fillRect(335, 315, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g2d.fillRect(335, 410, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g2d.fillRect(335, 505, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g2d.fillRect(335, 600, JBUTTON_WIDTH, JBUTTON_HIGHT);
		g2d.fillRect(300, 720, JLABLE_WIDTH, JLABLE_HIGHT);
		g2d.fillRect(900, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
		g2d.fillRect(935, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
		g2d.fillRect(970, 750, JBUTTON2_WIDTH, JBUTTON2_HIGHT);
	    }
	
    }
	
	public void initial(){
		buttonMouseAdapterAndActionListener buttonMouseAdapterAndActionListener=new buttonMouseAdapterAndActionListener(i,this);
		for(int i=0;i<=6;i++){
		this.add(buttons[i]);
		buttons[i].addMouseListener(buttonMouseAdapterAndActionListener);
		buttons[i].addActionListener(buttonMouseAdapterAndActionListener);
		}
		JLabel title=new JLabel();
		this.add(title);
		runIn();    //runIn加在initial里，不知道对不对
	}
	
	public void paintComponent1(Graphics g){
	//留着以后加图片
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
	
	class buttonMouseAdapterAndActionListener extends MouseAdapter implements ActionListener{

		int i;
		JPanelLogin jPanelLogin;
		JPanelLoginNext1 jPanelLoginNext1;

		private buttonMouseAdapterAndActionListener(int i, JPanelLogin jPanelLogin){
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
	}
	

