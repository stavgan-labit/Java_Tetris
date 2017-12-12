package com.labit.tetris;

// Commit #3
//

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import com.labit.tetris.Main;

public class Board extends JPanel implements KeyListener, MouseListener{
	
	private int widht = 14, height = 20, gridSize = 40;
	
	private final Color[] colors = {Color.GRAY, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.PINK,  Color.YELLOW, Color.WHITE}; // 0-9

	private byte[][] well = new byte[widht][height];
	
	private Timer looper = new Timer(1000/8, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tick();
			repaint();
		}
	});
	
	public Board(){
		addMouseListener(this);
		start();
		looper.start();
	}
	
	private void start() {
	/*	well[1][1] = 2;
		well[0][0] = 5;
		well[13][19] = 9;
		well[13][18] = 8;*/
	}
	
	private boolean isLine(int height) {
		for(int i = 0; i < widht; i++)
			if(well[i][height] == 0)
				return false;
		return true;
	}
	
	private void setLine(int height) {
		for(int i = 0; i < widht; i++)
			well[i][height] = 9;
	}
	
	private void downWell(int y) {
		for(int ty = y; ty > 0; ty--)
			for(int x = 0; x < widht; x++)
				well[x][ty] = well[x][ty-1];
		for(int x = 0; x < widht; x++)
			well[x][0] = 0;
	} 
	
	private void line() {
		for(int j = 0; j < height; j++) {
			//for(int x = 0; x < widht; x++)
			if(well[0][j] == 9)
				downWell(j);
			if(isLine(j))
				setLine(j);
		}
	}
	

	private void tick() {
	//	line();
	
	}
	
	private void paintWell(Graphics2D g2d) {
		for(int i = 0; i < widht; i++)
			for(int j = 0; j < height; j++) {
				g2d.setColor(colors[well[i][j]]);
				g2d.fillRect(i*gridSize, j*gridSize, gridSize, gridSize);
				g2d.setColor(Color.BLACK);
				if(well[i][j] > 0)
					g2d.drawRect(i * gridSize, j * gridSize, gridSize - 1, gridSize - 1);
			}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setStroke(new BasicStroke(2));
		
		//g2d.setColor(Color.GRAY);
		//g2d.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		line();
		paintWell(g2d);
		
		

		/*
		g2d.setColor(Color.WHITE);
		for(int i = 0; i < widht; i++)
			for(int j = 0; j < height; j++)
				g2d.drawRect(i * gridSize, j * gridSize, gridSize, gridSize);*/
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		well[e.getX()/gridSize][e.getY()/gridSize] = 1;
		
	}
}