package ui;
/*�����ĸ�����ť����һ�����⣬���Ͻ�����С��ť��
����κ�һ������ť���������Ϸ��ߣ���ť���·���
����Ƶ���ť�ϻ�ͼ�����ø���ɫ���棩
��һ����ť:W:360 H:68 X: 335 Y:315  �հ׸�27
����������Ͻ�С��ť�����ţ�

�������飺
1. ������JLabel
2. ��ť��0123�ֱ��Ӧ����ť��456��ӦС��ť
3. �����е�ButtonListener�¼�����if��ȷ���ĸ���ť��������ȫ�ֱ���i��
4. ����Ч�������������setLocation���������̣߳�repaint��
5. һ���ɳ���removeǰ�ĸ���ť
�ο�Gomoku���JPanelLogin��JPanelLoginNext1��ʵ�ַ�ʽ�����Ƿ��룬�����Ƿɳ���
����1:W:360 H:68 X:335 Y:315
����2:W:360 H:68 X:335 Y:410
����3:W:360 H:68 X:335 Y:505
����4:W:360 H:68 X:335 Y:600*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class JPanelLogin extends JPanel{

	private static final long serialVersionUID = 1L;
	private JMainFrame jMainFrame;
	private static int i;          //ȫ�ֱ���i��ȷ����ť
	private boolean dark;
	private JButton[] buttons;
	private JLabel title;
	private static final int JBUTTON_WIDTH=360;      //�ĸ���ť�Ĵ�С
	private static final int JBUTTON_HIGHT=68;
	private static final int JLABLE_WIDTH=430;       //����Ĵ�С
	private static final int JLABLE_HIGHT=80;
	private static final int JBUTTON2_WIDTH=20;      //����С��ť�Ĵ�С
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
				new JButton("��һ��"),
				new JButton("�ڶ���"),
				new JButton("������"),
				new JButton("���ĸ�"),
				new JButton("����"),
				new JButton("����"),  
				new JButton("�˳�")
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
		runIn();    //runIn����initial���֪���Բ���
	}
	
	public void paintComponent1(Graphics g){
	//�����Ժ��ͼƬ
	}
	
	private void runIn(){
		Point startTitlePoints=new Point(360,720);
		Point[] startButtonPoints=new Point[]{new Point(360,315),new Point(360,410),new Point(360,505),new Point(360,600)};
		//������붯��
			while(this.titlePoint.y!=startTitlePoints.y){
				this.titlePoint.y-=10;
				this.repaint();
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {	}
			}
		

		//��ť���붯��
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
		//�˶��ķ���(�ɳ�)
		//���ձ��������
				Point finalTitlePoints=new Point(360,1241);
				Point[] finalButtonPoints=new Point[]{new Point(360,1836),new Point(360,931),new Point(360,1026),new Point(360,1121)};
				//����ɳ�����
					while(this.titlePoint.y!=finalTitlePoints.y){
						this.titlePoint.y+=10;
						this.repaint();
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {	}
					}
				

				//��ť�ɳ�����
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
		����ƶ������뿪ʱ�Ķ�����Ҳ��������
*/

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(i==1){
			//  ��Ҫ���    ��ťһ��ר������
                runOut();
                removeButtons();
			}
			if(i==2){
		    //  ��Ҫ���    ��ť����ר������
                runOut();
                removeButtons();
			}
			if(i==3){
			//  ��Ҫ���    ��ť��ר������
				runOut();
				removeButtons();
			}
			if (i==4) {
			//  ��Ҫ���    ��ť��ר������
			}
			if(i==5){
			//  ��Ҫ���    ��ť��ר������
			}
			if (i==6) {
			//  ��Ҫ���    ��ť��ר������
			}
			
			}
		}
	}
	

