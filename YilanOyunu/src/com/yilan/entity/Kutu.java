package com.yilan.entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;

import javax.security.auth.x500.X500Principal;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Kutu extends JLabel {

	public int yon = Yon.SAG.getA();
	public Kutu() {

		setBounds(200, 200, 20, 20);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;

		Rectangle2D rectangle = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(2));
		g2.fill(rectangle);
	}

	public void sagaGit() {

		setBounds(getX() + getWidth(), getY(), getWidth(), getHeight());

	}

	public void solaGit() {

		setBounds(getX() - getWidth(), getY(), getWidth(), getHeight());

	}

	public void asagıGit() {

		setBounds(getX(), getY() + getWidth(), getWidth(), getHeight());

	}

	public void yukariGit() {

		setBounds(getX(), getY() - getWidth(), getWidth(), getHeight());

	}

	public void hareketEt() {

		if (yon == Yon.SOL.getA()) {
			solaGit();
		} else if (yon == Yon.SAG.getA()) {
			sagaGit();
		} else if (yon == Yon.YUKARI.getA()) {
			yukariGit();
		} else {
			asagıGit();
		}

	}

	public Kutu KutuOlustur() {
		
		Kutu kutu = new Kutu();
		kutu.setBounds(getX(), getY(), 20, 20);
		kutu.yon = -this.yon;
		kutu.hareketEt();
		kutu.yon = this.yon;
		return kutu;
	}
}
