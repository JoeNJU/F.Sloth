package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EveryImage {
	/*所有的变量和方法都限定为public
	 * 所有的图片引用都来自于此
	 * 图片命名规则：IMG_分类_名字
	 */
	public Image CURSOR = new ImageIcon("graphics/component/cursor.png").getImage();
	public Image IMG_LOGIN_NEXT = new ImageIcon("graphics/bg/loginnext.png").getImage();
	public Image IMG_HELP_BG = new ImageIcon("graphics/bg/helpbg.png").getImage();
	public Image IMG_LOGIN_TITLE = new ImageIcon("graphics/login/title.png").getImage();
	public Image IMG_GAME_BG = new ImageIcon("graphics/bg/floor.png").getImage();
	public ImageIcon[] IMG_LOGIN1_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/start-game.png"),new ImageIcon("graphics/login/setting.png"),new ImageIcon("graphics/login/achievement.png"),new ImageIcon("graphics/login/about-us.png")};
	public ImageIcon[] IMG_LOGIN_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/volume.png"),new ImageIcon("graphics/login/help.png"),new ImageIcon("graphics/login/close.png")};
	public ImageIcon[] IMG_HELP_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/help/back.png"),new ImageIcon("graphics/help/left.png"),new ImageIcon("graphics/help/right.png")};
	public ImageIcon[] IMG_HELP_CONTENTS=new ImageIcon[]{new ImageIcon("graphics/help/content1.png"),new ImageIcon("graphics/help/content2.png"),new ImageIcon("graphics/help/content3.png"),new ImageIcon("graphics/help/content4.png")};
	public ImageIcon[] IMG_HELP_TITLES=new ImageIcon[]{new ImageIcon("graphics/help/introduction.png"),new ImageIcon("graphics/help/rule.png")};
	public ImageIcon[] IMG_GAME_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/game/occupy.png"),new ImageIcon("graphics/game/disturb.png"),new ImageIcon("graphics/game/move.png"),new ImageIcon("graphics/game/disappear.png"),new ImageIcon("graphics/game/appear.png"),new ImageIcon("graphics/game/back.png")};
	
	

}
