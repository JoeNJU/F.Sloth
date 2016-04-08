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

	JFrame frame = new JFrame("动态panel");

	final JPanel p[] = {new JPanel(),new JPanel(),new JPanel()};// 滑动面板1

	// 滑动面板2

	// 滑动面板3

	JPanel contentPanel = new JPanel();// 主面板

	JPanel topPanel = new JPanel();// 顶面板

	final JPanel centerPanel = new JPanel();// 中间面板

	private int locationX;
	private int locationY;//为了让面板居中所设置的坐标//
	
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
		p[0].add(new JLabel("图片1"));
		p[1].add(new JLabel("图片2"));
		p[2].add(new JLabel("图片3"));
         //给四个按钮加上监听器//
		JButton jb1 = new JButton("panel1");
		jb1.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[0]);

			}

		});
		JButton jb2 = new JButton("选择");
		jb2.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[1]);
			}

		});
		JButton jb3 = new JButton("panel3");
		jb3.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				xiaoGuo(p[2]);
			}

		});

		JButton jb4 = new JButton("返回");
		jb4.addActionListener(new java.awt.event.ActionListener() {// jb1事件

			public void actionPerformed(java.awt.event.ActionEvent e) {
				returnPanel(p[0]);
			}

		});
		
		 JButton jb5= new JButton("向左");
		 jb5.addActionListener(new java.awt.event.ActionListener() {// jb1事件
       
				public void actionPerformed(java.awt.event.ActionEvent e) {
		
		            int number=0;
					int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
					List list = new ArrayList();//
					
					for (Component comp : centerPanel.getComponents()) {
						list.add(comp);// 给list赋值
						final JPanel currentPanel = (JPanel) comp;// 获得当前panel
						
						for(int x=0;x<3;x++){
							boolean result=currentPanel.equals(p[x]);
							if(result==true){
							number=x;
							}
						}
					left(p[number-1]); //需要修改
				
					}
				}
		 }
			);
		 
		 JButton jb6= new JButton("向右");
		 jb6.addActionListener(new java.awt.event.ActionListener() {// jb1事件
       
				public void actionPerformed(java.awt.event.ActionEvent e) {
		
		            int number=0;
					int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
					List list = new ArrayList();//
					
					for (Component comp : centerPanel.getComponents()) {
						list.add(comp);// 给list赋值
						final JPanel currentPanel = (JPanel) comp;// 获得当前panel
						
						for(int x=0;x<3;x++){
							boolean result=currentPanel.equals(p[x]);
							if(result==true){
							number=x;
							}
						}
					right(p[number+1]); //需要修改
				
					}
				}
		 }
			);
				
		  
				
		
		
		topPanel.add(jb5);
		//topPanel.add(jb1);//
		topPanel.add(jb2);
		//topPanel.add(jb3);//
		//topPanel.add(jb4);//把三个按钮加到顶面板中//
	    topPanel.add(jb6);

		contentPanel.add(topPanel, BorderLayout.NORTH);
		contentPanel.add(centerPanel, BorderLayout.CENTER);//把顶面板和中心面板加入到主面板中

		frame.show();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screen=toolkit.getScreenSize();
        locationX=(screen.width -frame.getWidth())/2;
        locationY=(screen.height -frame.getHeight())/2;       
	    frame.setLocation(locationX,locationY);
		
		frame.setVisible(true);

	}

	// 返回效果 此效果为向左滑动
	public void returnPanel(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// 设置面板位置
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

								centerPanel.remove(currentPanel);// 移除当前面板

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
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}

	// 滑动效果方法 此效果为向右滑动
	public void xiaoGuo(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// 设置面板位置
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

								centerPanel.remove(currentPanel);// 移除当前面板

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
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}
	
	
	public void left(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件
                
				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {//panel指的是需要返回的面板//

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 10) {
									// 设置面板位置
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

								centerPanel.remove(currentPanel);// 移除当前面板

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
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}
	public void right(final JPanel panel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 10) {
									// 设置面板位置
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

								centerPanel.remove(currentPanel);// 移除当前面板

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
			centerPanel.add(panel);// 添加要切换的面板
		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JpanelForm();
	}

}
