import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JpanelForm {

	/**
	 * @param args
	 */

	JFrame frame = new JFrame("��̬panel");

	final JPanel p[] = {new JPanel(),new JPanel(),new JPanel()};// �������1

	// �������2

	// �������3

	JPanel contentPanel = new JPanel();// �����

	JPanel topPanel = new JPanel();// �����

	final JPanel centerPanel = new JPanel();// �м����

	private int locationX;
	private int locationY;//Ϊ���������������õ�����//
	
	@SuppressWarnings("deprecation")
	public JpanelForm() {

		frame.setSize(470, 430);
		contentPanel.setBackground(Color.GRAY);
		frame.setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout());

		topPanel.setBackground(Color.WHITE);
		topPanel.setPreferredSize(new Dimension(contentPanel.getWidth(), 50));

		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(null);

		p[0].setBackground(Color.BLUE);
		p[1].setBackground(Color.GREEN);
		p[2].setBackground(Color.RED);
		p[0].add(new JLabel("ͼƬ1"));
		p[1].add(new JLabel("ͼƬ2"));
		p[2].add(new JLabel("ͼƬ3"));
         //���ĸ���ť���ϼ�����//
		JButton jb1 = new JButton("panel1");
		jb1.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[0]);

			}

		});
		JButton jb2 = new JButton("ѡ��");
		jb2.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[1]);
			}

		});
		JButton jb3 = new JButton("panel3");
		jb3.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[2]);
			}

		});

		JButton jb4 = new JButton("����");
		jb4.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�

			public void actionPerformed(java.awt.event.ActionEvent e) {
				returnPanel(p[0]);
			}

		});
		
		 JButton jb5= new JButton("����");
		 jb5.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�
       
				public void actionPerformed(java.awt.event.ActionEvent e) {
		
		            int number=0;
					int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
					List list = new ArrayList();//
					
					for (Component comp : centerPanel.getComponents()) {
						list.add(comp);// ��list��ֵ
						final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
						
						for(int x=0;x<3;x++){
							boolean result=currentPanel.equals(p[x]);
							if(result==true){
							number=x;
							}
						}
					left(p[number-1]); //��Ҫ�޸�
				
					}
				}
		 }
			);
		 
		 JButton jb6= new JButton("����");
		 jb6.addActionListener(new java.awt.event.ActionListener() {// jb1�¼�
       
				public void actionPerformed(java.awt.event.ActionEvent e) {
		
		            int number=0;
					int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
					List list = new ArrayList();//
					
					for (Component comp : centerPanel.getComponents()) {
						list.add(comp);// ��list��ֵ
						final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
						
						for(int x=0;x<3;x++){
							boolean result=currentPanel.equals(p[x]);
							if(result==true){
							number=x;
							}
						}
					right(p[number+1]); //��Ҫ�޸�
				
					}
				}
		 }
			);
				
		  
				
		
		
		topPanel.add(jb5);
		//topPanel.add(jb1);//
		topPanel.add(jb2);
		//topPanel.add(jb3);//
		//topPanel.add(jb4);//��������ť�ӵ��������//
	    topPanel.add(jb6);

		contentPanel.add(topPanel, BorderLayout.NORTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);//�Ѷ��������������뵽�������

		frame.show();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();
        locationX=(screen.width -frame.getWidth())/2;
        locationY=(screen.height -frame.getHeight())/2;       
	    frame.setLocation(locationX,locationY);
		
		frame.setVisible(true);

	}

	// ����Ч�� ��Ч��Ϊ���󻬶�
	public void returnPanel(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// ���û�����ʼλ��
		int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// ��list��ֵ
		}
		if (count > 0) {// ���centerPanel�пؼ�������0��ִ��Ч��
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// ��ø�λ�õĿؼ�

				if (comp instanceof JPanel) {// �жϿؼ�����
					final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// ��õ�ǰ����λ����Ϣ
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// �������λ��
									currentPanel.setBounds(i, 0,centerPanel.getWidth(),centerPanel.getHeight());
									panel.setBounds(y, 0,centerPanel.getWidth(),centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y -= 10;
								}

								centerPanel.remove(currentPanel);// �Ƴ���ǰ���

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// ���Ҫ�л������
		}

		centerPanel.validate();// �ع��������
		centerPanel.repaint();// �ػ��������
	}

	// ����Ч������ ��Ч��Ϊ���һ���
	public void xiaoGuo(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// ���û�����ʼλ��
		int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// ��list��ֵ
		}
		if (count > 0) {// ���centerPanel�пؼ�������0��ִ��Ч��
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// ��ø�λ�õĿؼ�

				if (comp instanceof JPanel) {// �жϿؼ�����
					final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// ��õ�ǰ����λ����Ϣ
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// �������λ��
									currentPanel.setBounds(i, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									panel.setBounds(y, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 10;
								}

								centerPanel.remove(currentPanel);// �Ƴ���ǰ���

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// ���Ҫ�л������
		}

		centerPanel.validate();// �ع��������
		centerPanel.repaint();// �ػ��������
	}
	
	
	public void left(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// ���û�����ʼλ��
		int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
		List list = new ArrayList();//
		
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// ��list��ֵ
		}
		if (count > 0) {// ���centerPanel�пؼ�������0��ִ��Ч��
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// ��ø�λ�õĿؼ�
                
				if (comp instanceof JPanel) {// �жϿؼ�����
					final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
					if (currentPanel != panel) {//panelָ������Ҫ���ص����//

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// ��õ�ǰ����λ����Ϣ
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// �������λ��
									currentPanel.setBounds(i, 0,centerPanel.getWidth(),centerPanel.getHeight());
									panel.setBounds(y, 0,centerPanel.getWidth(),centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y -= 10;
								}

								centerPanel.remove(currentPanel);// �Ƴ���ǰ���

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// ���Ҫ�л������
		}

		centerPanel.validate();// �ع��������
		centerPanel.repaint();// �ػ��������
	}
	public void right(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// ���û�����ʼλ��
		int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// ��list��ֵ
		}
		if (count > 0) {// ���centerPanel�пؼ�������0��ִ��Ч��
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// ��ø�λ�õĿؼ�

				if (comp instanceof JPanel) {// �жϿؼ�����
					final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// ��õ�ǰ����λ����Ϣ
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// �������λ��
									currentPanel.setBounds(i, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									panel.setBounds(y, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									try {
										Thread.sleep(5);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 10;
								}

								centerPanel.remove(currentPanel);// �Ƴ���ǰ���

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}

		if (!list.contains(panel)) {
			centerPanel.add(panel);// ���Ҫ�л������
		}

		centerPanel.validate();// �ع��������
		centerPanel.repaint();// �ػ��������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JpanelForm();
	}

}
