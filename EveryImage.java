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
	public Image IMG_GAME_BG = new ImageIcon("graphics/bg/room1.png").getImage();
	public Image IMG_LOGIN_BG = new ImageIcon("graphics/bg/loginbg.png").getImage();
	public Image IMG_SETTING_BG = new ImageIcon("graphics/bg/settingbg.png").getImage();
	public Image IMG_SETTING_BLOCK = new ImageIcon("graphics/setting/block.png").getImage();
	public Image IMG_SETTING_SINGLE = new ImageIcon("graphics/setting/single.png").getImage();
	public Image IMG_SETTING_FAMILY = new ImageIcon("graphics/setting/family.png").getImage();
	public Image IMG_STN_BG = new ImageIcon("graphics/bg/stnbg.png").getImage();
	
	
	
	public ImageIcon[] IMG_LOGIN1_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/start-game.png"),new ImageIcon("graphics/login/setting.png"),new ImageIcon("graphics/login/achievement.png"),new ImageIcon("graphics/login/about-us.png")};
	public ImageIcon[] IMG_LOGIN_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/login/volumeOn.png"),new ImageIcon("graphics/login/help.png"),new ImageIcon("graphics/login/close.png"),new ImageIcon("graphics/login/volumeOff.png")};
	public ImageIcon[] IMG_HELP_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/help/back.png"),new ImageIcon("graphics/help/left.png"),new ImageIcon("graphics/help/right.png")};
	public ImageIcon[] IMG_HELP_CONTENTS=new ImageIcon[]{new ImageIcon("graphics/help/content1.png"),new ImageIcon("graphics/help/content2.png"),new ImageIcon("graphics/help/content3.png"),new ImageIcon("graphics/help/content4.png")};
	public ImageIcon[] IMG_HELP_TITLES=new ImageIcon[]{new ImageIcon("graphics/help/introduction.png"),new ImageIcon("graphics/help/rule.png")};
	public ImageIcon[] IMG_GAME_BUTTONS=new ImageIcon[]{new ImageIcon("graphics/game/occupy.png"),new ImageIcon("graphics/game/disturb.png"),new ImageIcon("graphics/game/move.png"),new ImageIcon("graphics/game/disappear.png"),new ImageIcon("graphics/game/up.png"),new ImageIcon("graphics/game/down.png"),new ImageIcon("graphics/game/left.png"),new ImageIcon("graphics/game/right.png"),new ImageIcon("graphics/game/back.png"),new ImageIcon("graphics/game/appear.png"),new ImageIcon("graphics/game/stop.png"),new ImageIcon("graphics/game/skip.png")};
	public Image IMG_STOP_BG = new ImageIcon("graphics/bg/stopbg.png").getImage();
	public ImageIcon[] IMG_STOP_BUTTONS = new ImageIcon[]{new ImageIcon("graphics/stop/volumeOn.png"),new ImageIcon("graphics/stop/restart.png"),new ImageIcon("graphics/stop/menu.png"),new ImageIcon("graphics/stop/continue.png"),new ImageIcon("graphics/stop/volumeOff.png")};
	public ImageIcon[] IMG_ACTIVITY_RIGHT = new ImageIcon[]{new ImageIcon("graphics/game/11.png"),new ImageIcon("graphics/game/12.png"),new ImageIcon("graphics/game/13.png"),new ImageIcon("graphics/game/14.png"),new ImageIcon("graphics/game/15.png"),new ImageIcon("graphics/game/16.png"),new ImageIcon("graphics/game/17.png")};
	public ImageIcon[] IMG_ACTIVITY_LEFT = new ImageIcon[]{new ImageIcon("graphics/game/21.png"),new ImageIcon("graphics/game/22.png"),new ImageIcon("graphics/game/23.png"),new ImageIcon("graphics/game/24.png"),new ImageIcon("graphics/game/25.png"),new ImageIcon("graphics/game/26.png"),new ImageIcon("graphics/game/27.png")};
	public ImageIcon[][] IMG_CHARACTER_HEAD = new ImageIcon[][]{{new ImageIcon("graphics/character/14.png"),new ImageIcon("graphics/character/24.png"),new ImageIcon("graphics/character/34.png")},{new ImageIcon("graphics/character/44.png"),new ImageIcon("graphics/character/54.png"),new ImageIcon("graphics/character/64.png")}};
	public ImageIcon IMG_SKIP_BUTTON = new ImageIcon("graphics/game/skip.png");
	public ImageIcon[] IMG_ST_BUTTONS = new ImageIcon[]{new ImageIcon("graphics/setting/allLeft.png"),new ImageIcon("graphics/setting/allRight.png")};
	public ImageIcon[] IMG_STN_BUTTONS = new ImageIcon[]{new ImageIcon("graphics/setting/left.png"),new ImageIcon("graphics/setting/right.png")};
	
	
	
}
