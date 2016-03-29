package main;

import ui.JMainFrame;
import ui.JPanelStart;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JMainFrame jMainFrame=new JMainFrame();
		JPanelStart panelStart=new JPanelStart(jMainFrame);
		jMainFrame.setContentPane(panelStart);

	}

}
