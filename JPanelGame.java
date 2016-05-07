package ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

import game.Control;
import game.Person;


public class JPanelGame extends JPanel{
	private static final long serialVersionUID = 1L;
	/*本类用于游戏的主界面
	 * 
	 */
	
	private JMainFrame jMainFrame;
	private JButton[] buttons = new JButton[10];
	private Control control;
	private int commandNow;
	private JLabel label;
	JPanelStop jps;
	
	
	public JPanelGame(JMainFrame jframe){
		this.jMainFrame = jframe;
		
		
		this.setLayout(null);
		this.setBounds(0, 0, JMainFrame.JFRAME_WIDTH, JMainFrame.JFRAME_HIGHT);
		this.setVisible(true);
		jMainFrame.setDragable(this);
		jMainFrame.setContentPane(this);
		jps = new JPanelStop(jMainFrame);
		for (int i = 0; i < 4; i++) {
			buttons[i] = new JButton();
			buttons[i].setBorderPainted(false);
			this.add(buttons[i]);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[i]);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			ButtonListener listener=new ButtonListener(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
			buttons[i].setRequestFocusEnabled(false);
			buttons[i].setVisible(false);
		} 
		control = new Control(this);
		//this.repaint();
	}
	
	public void initialButtons(){
		//9个按钮分别为占领，骚扰，移动，隐现身，上，下，左，右，返回
		for (int i = 4; i < 10; i++) {
			buttons[i] = new JButton();
			buttons[i].setBorderPainted(false);
			this.add(buttons[i]);
			buttons[i].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[i]);
			buttons[i].setBorderPainted(false);
			buttons[i].setContentAreaFilled(false);
			ButtonListener listener=new ButtonListener(i);
			buttons[i].addMouseListener(listener);
			buttons[i].addActionListener(listener);
			buttons[i].setRequestFocusEnabled(false);
			buttons[i].setVisible(false);
		} 
		buttons[9].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[10]);
		buttons[9].setBounds(934,10,73,72);
		buttons[9].setVisible(true);
	}
	
	public void basicAdd(Person person){//添加基础选项，x和y为人物所在 格子坐标
		Point location = person.getRealPoint();//真实坐标
		Point[] points=new Point[]{new Point(location.x+20,location.y-50),new Point(location.x-33,location.y-35),new Point(location.x-55,location.y+10),new Point(location.x-33,location.y+58)};
		if(person.isHide()){
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[9]);
			buttons[3].setBounds(points[0].x,points[0].y,40,40);
			buttons[3].setVisible(true);
			if(person.getActivity()>1){
				buttons[2].setBounds(points[1].x,points[1].y,40,40);
				buttons[2].setVisible(true);
			}
			if(control.blocks[person.location.x][person.location.y].hasPerson()){
				buttons[3].setVisible(false);
			}
		}else if(person.getActivity()<4){
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[3]);
			for(int i = 3;i>3-person.getActivity();i--){
				buttons[i].setBounds(points[i].x,points[i].y,40,40);
				buttons[i].setVisible(true);
			}
			
		}else{
			buttons[3].setIcon(jMainFrame.everyImage.IMG_GAME_BUTTONS[3]);
			for(int i = 0;i<4;i++){
				buttons[i].setBounds(points[i].x,points[i].y,40,40);
				buttons[i].setVisible(true);
			}
		}
		if(person.inDanger()){
			buttons[3].setVisible(false);
		}
		
		this.repaint();
	}
	
	public void removeButtons(){//去掉屏幕上已经显示的按钮
		for(int i = 0;i<9;i++){
			buttons[i].setVisible(false);
		}
	}
	
	public void directAdd(Person person,int i){//添加上下左右按钮,i用于表示执行的具体命令
		Point location = person.getRealPoint();//真实坐标
		Point[] points=new Point[]{new Point(location.x+24,location.y+26),new Point(location.x-24,location.y+69),new Point(location.x-36,location.y+39),new Point(location.x+30,location.y+60),new Point(location.x+50,location.y-40)};
		for(i=4;i<9;i++){
			buttons[i].setBounds(points[i-4].x,points[i-4].y,40,40);
			buttons[i].setVisible(true);
		}
		if(commandNow==2){
			if(control.personNow.location.x==0||(control.blocks[control.personNow.location.x-1][control.personNow.location.y].hasPerson()&&!control.personNow.isHide())){
				buttons[6].setVisible(false);
			}else if(control.personNow.location.x==14||(control.blocks[control.personNow.location.x+1][control.personNow.location.y].hasPerson()&&!control.personNow.isHide())){
				buttons[7].setVisible(false);
			}else if(control.personNow.location.y==0||(control.blocks[control.personNow.location.x][control.personNow.location.y-1].hasPerson()&&!control.personNow.isHide())){
				buttons[4].setVisible(false);
			}else if(control.personNow.location.y==14||(control.blocks[control.personNow.location.x][control.personNow.location.y+1].hasPerson()&&!control.personNow.isHide())){
				buttons[5].setVisible(false);
			}
		}else{
			if(control.personNow.location.x==0){
				buttons[6].setVisible(false);
			}else if(control.personNow.location.x==14){
				buttons[7].setVisible(false);
			}else if(control.personNow.location.y==0){
				buttons[4].setVisible(false);
			}else if(control.personNow.location.y==14){
				buttons[5].setVisible(false);
			}
		}
		
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
			if(i<4||i==8||i==9){
				buttons[i].setLocation(buttons[i].getLocation().x+2, buttons[i].getLocation().y-2);
			}else if(commandNow!=2&&i<9){
				control.personNow.setExample(i-4, true);
				control.repaintAll();
			}
			/*if(jFrameGame.isVoice()){
				new AudioPlayer("");
			}*/
		}
		@Override
		public void mouseExited(MouseEvent e){
			if(i<4||i==8||i==9){
				buttons[i].setLocation(buttons[i].getLocation().x-2, buttons[i].getLocation().y+2);
			}else if(commandNow!=2&&i<9){
				control.personNow.setExample(i-4, false);
				control.repaintAll();
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (i) {
			case 0://占领
				removeButtons();
				commandNow = i;
				directAdd(control.personNow,i);
				
				break;
			case 1://骚扰
				removeButtons();
				commandNow = i;
				directAdd(control.personNow,i);
				break;
			case 2://移动
				removeButtons();
				commandNow = i;
				directAdd(control.personNow,i);
				break;
			case 3://隐身或现身
				removeButtons();
				control.personNow.changeState();
				control.refresh();
				break;
			case 4://上
				if(commandNow==0){
					control.personNow.occupy(i-4);
					control.refresh();
				}else if(commandNow==1){
					control.personNow.disturb(i-4);
					control.refresh();
				}else if(commandNow==2){
					control.personNow.move(i-4);
					control.refresh(0);
				}
				control.repaintAll();
				break;
			case 5://下
				if(commandNow==0){
					control.personNow.occupy(i-4);
					control.refresh();
				}else if(commandNow==1){
					control.personNow.disturb(i-4);
					control.refresh();
				}else if(commandNow==2){
					control.personNow.move(i-4);
					control.refresh(0);
				}
				control.repaintAll();
				break;
			case 6://左
				if(commandNow==0){
					control.personNow.occupy(i-4);
					control.refresh();
				}else if(commandNow==1){
					control.personNow.disturb(i-4);
					control.refresh();
				}else if(commandNow==2){
					control.personNow.move(i-4);
					control.refresh(0);
				}
				control.repaintAll();
				break;
			case 7://右
				if(commandNow==0){
					control.personNow.occupy(i-4);
					control.refresh();
				}else if(commandNow==1){
					control.personNow.disturb(i-4);
					control.refresh();
				}else if(commandNow==2){
					control.personNow.move(i-4);
					control.refresh(0);
				}
				control.repaintAll();
				break;
			case 8://返回
				removeButtons();
				control.refresh();
				break;
			case 9:
				jps.setVisible(true);
				jps.initialButtons();
				break;
			default:
				break;
			}
		}
	}

}
