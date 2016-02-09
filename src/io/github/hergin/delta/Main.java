package io.github.hergin.delta;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

import io.github.hergin.delta.ui.DelTaUI;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		DelTaUI theUI = new DelTaUI();
		JFrame frame = new JFrame();
		frame.getContentPane().add(theUI, BorderLayout.CENTER);
		frame.setSize(885, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("DelTa Model Generator UI");
	}
	
}
