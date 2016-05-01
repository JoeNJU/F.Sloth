package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.Control;
import game.Person;


public class JPanelGame extends JPanel{
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的主界面
	 * 
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons;
	private Control control;
	
	
	public JPanelGame(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		jMainFrame.setContentPane(this);
		initialButtons();
		control = new Control(this);
		this.repaint();
	}
	
	public void initialButtons(){
		this.buttons=new JButton[]{new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
		//Point[] points=new Point[]{new Point(100,200),new Point(200,200),new Point(300,200),new Point(400,200)};
		for (int i = 0; i < 4; i++) {
			//buttons[i].setBounds(points[i].x, points[i].y, 80,50);
			buttons[i].setBorderPainted(false);
			this.add(buttons[i]);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[i]);
			ButtonListener listener=new ButtonListener(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
			buttons[i].setVisible(false);
		} 
	}
	
	public void basicAdd(Person person){//添加基础选项，x和y为人物所在 格子坐标
		Point location = person.getLocation();//真实坐标
		Point[] points=new Point[]{new Point(location.x,location.y),new Point(location.x,location.y),new Point(location.x,location.y),new Point(location.x,location.y)};
		if(person.isHide()){
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[4]);
			buttons[3].setLocation(points[0]);
			buttons[3].setVisible(true);
			if(person.getActivity()!=1){
				buttons[2].setLocation(points[1]);
				buttons[2].setVisible(true);
			}			
		}else if(person.getActivity()<4){
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[3]);
			for(int i = 3;i>3-person.getActivity();i--){
				buttons[i].setLocation(points[i]);
				buttons[i].setVisible(true);
			}
			
		}else{
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[3]);
			for(int i = 0;i<4;i++){
				buttons[i].setLocation(points[i]);
				buttons[i].setVisible(true);
			}
		}
		this.repaint();
	}
	
	public void removeButtons(){//去掉屏幕上已经显示的按钮
		for(int i = 0;i<4;i++){
			buttons[i].setVisible(false);
		}
	}
	
	public void directAdd(){//添加上下左右按钮
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(jMainFrame.everyImage.IMG_GAME_BG, 0, 0,JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT,null);
	
	}
	
	class ButtonListener extends MouseAdapter implements ActionListener{
		int i;
		private ButtonListener(int i){
			this.i=i;
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			buttons[i].setLocation(buttons[i].getLocation().x+2, buttons[i].getLocation().y-2);
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			buttons[i].setLocation(buttons[i].getLocation().x-2, buttons[i].getLocation().y+2);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (i) {
			case 0://占领
				
				break;
			case 1://骚扰
				
				break;
			case 2://移动
				
				break;
			case 3://隐身或现身
				
				break;
			default:
				break;
			}
		}
	}

}
