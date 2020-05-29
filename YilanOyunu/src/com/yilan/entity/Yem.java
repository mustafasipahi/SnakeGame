package com.yilan.entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class Yem extends JLabel{

	private int genislik = 20;
	
	public Yem() {
		setPozisyon(20,20);
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D ellipse2d = new Ellipse2D.Double(1, 1, genislik-2, genislik-2);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.draw(ellipse2d);
		g2.setColor(Color.GREEN);
		g2.fill(ellipse2d);
	}

	public void setPozisyon(int X,int Y) {
		
		setBounds(X, Y, genislik, genislik);
	}
	
}
