package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EveryImage {
	/*���еı����ͷ������޶�Ϊpublic
	 * ���е�ͼƬ���ö������ڴ�
	 * ͼƬ��������IMG_����_����
	 */
	public Image CURSOR = new ImageIcon("graphics/component/cursor.png").getImage();
	public Image IMG_LOGIN_NEXT = new ImageIcon("graphics/bg/loginnext.png").getImage();
	public Image IMG_LOGIN_TITLE = new ImageIcon("graphics/login/title.png").getImage();
	public ImageIcon[] IMG_LOGIN1_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/start-game.png"),new ImageIcon("graphics/login/setting.png"),new ImageIcon("graphics/login/achievement.png"),new ImageIcon("graphics/login/about-us.png")};
	public ImageIcon[] IMG_LOGIN_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/volume.png"),new ImageIcon("graphics/login/help.png"),new ImageIcon("graphics/login/close.png")};
	public ImageIcon[] IMG_HELP_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/help/back.png"),new ImageIcon("graphics/help/left.png"),new ImageIcon("graphics/help/right.png")};
	

}
