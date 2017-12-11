package com.labit.snake;

import java.awt.Graphics;
import java.awt.*;


import javax.swing.*;

public class Main extends JFrame {
	
	public static final int WIDTH = 600, HEIGHT = 630;
	
	private Board board = new Board();
	
	public Main() {
		setTitle("SnakeGame");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(board);
		addKeyListener(board);
		setVisible(true);
	}


	public static void main(String[] args) {
		new Main();
		
		
		
	}

}