package com.yilan.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.yilan.entity.Kutu;

public class AnaPencere extends JFrame {

	private static AnaPencere myAnaPencere = null;
	private int mGenislik = 670;
	private int mYukseklik = 690;
	private YilanEkrani yilanEkrani = new YilanEkrani();
	
	private AnaPencere() {
		add(yilanEkrani);
		setResizable(false);
		setBounds(0,0,mGenislik,mYukseklik);
		setTitle("Yılan Oyunu");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static AnaPencere getAnaPencere() {
		
		if (myAnaPencere == null) {
			myAnaPencere = new AnaPencere();
		}
		
		return myAnaPencere;
	}
}
