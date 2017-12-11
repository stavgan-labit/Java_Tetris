package com.labit.tetris;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public static final int WIDTH = 560, HEIGHT = 830;
	
	Board board = new Board();

	public Main(){
		setTitle("Tetris");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(board);
		addKeyListener(board);
		setVisible(true);
	}
	 public static void main(String[] argv) {
		 new Main();
	 }
}
