package com.fan.mystery;
/* Name: Keith Reis
 * Program Name: MysterySpinner
 * Due Date: XX/XX/XX
 * Description: A sideproject to both improve my skill, and test my limits of coding.
 */

// TODO
// "I want someone to make basically a wheel spinner, but on my computer. Ok? And for the wheel spinner, I can put whatever images I want ok? 
// It could be a signed card, a pizza. I want the wheel spinner, to not be a wheel, but the mystery box." Also has to be operated via streamdeck button
//
// Constraints:
// Must be a "wheel spinner" (Roughly equal chances for each outcome) ~ WheelSpinner Class
// Must be able to easily import images as potential outcomes [Drag and drop into Mystery Box Window?] ~ MysteryDnD, and ImportImages Class
// Must be a visual of the mystery box ~ MysteryBox Class
// Must be able to use streamdeck ~ I personally don't know the capabilities of streamdeck; I'm hopping I can create this as an Executable, and you can run it.
//
// Notes:
// I would say I'm an avid programmer, but not an expert in any means. If there is any bug, please contact me so I can try to fix it.
// Also if you want additional features and/or current features to be expanded upon feel free to reach out and contact me.

import javax.swing.JFrame;

public class MysteryMain {
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		MysteryBody body = new MysteryBody();
		
		jFrame.setSize(1200+17, 675+40);
		// Decorated edges ~ is 40 pixels of height; Can fix remove later
		// The Width is 1200, the Height is 675, Aspect of 16:19.
        jFrame.setTitle("Mystery Box Spinner");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(body);
        body.requestFocusInWindow();
	}
}
