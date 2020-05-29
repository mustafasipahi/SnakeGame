package com.yilan.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.time.Year;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.yilan.entity.Kutu;
import com.yilan.entity.Yem;
import com.yilan.entity.Yon;

public class YilanEkrani extends JLabel {

	private Timer timer = new Timer(50, new TimerKontrol());
	private ArrayList<Kutu> kutular = new ArrayList<Kutu>();	
	private Kutu kutu = new Kutu();
	private Rectangle2D rec = null;
	private Yem yem = new Yem();
	

	public YilanEkrani() {
		timer.start();
		addKeyListener(new KlavyeKontrol());
		setFocusable(true);
		
		kutular.add(kutu);		
		for (int i = 0; i < 10; i++) {
			kuyrukEkle();                   		
		}
		add(yem);
		add(kutu);
	}
	
	public void yemEkle() {
		
		int yemWidth = getWidth() - 50 - yem.getWidth();
		int yemHeight = getHeight() - 50 - yem.getHeight();
		
		Random random = new Random(System.currentTimeMillis());
		
		int randomX = Math.abs(random.nextInt())%yemWidth+30;
		int randomY = Math.abs(random.nextInt())%yemHeight+30;
		
		randomX -= randomX%20;
		randomY -= randomY%20;
		
		for(Kutu myKutu : kutular) {
			
			if ((myKutu.getX() == randomX)&&(myKutu.getY() == randomY)) {
				yemEkle();
				return;
			}
		}
		
		yem.setPozisyon(randomX, randomY);
	}
	
	public void kuyrukEkle() {
		
		Kutu k = kutular.get(kutular.size()-1).KutuOlustur();
		kutular.add(k);
		add(k);
	}
	
	public void hepsiniYurut() {
		
		for (int i = kutular.size()-1; i >0 ; i--) {
			Kutu onceki = kutular.get(i-1);
			Kutu sonraki = kutular.get(i);			
			kutular.get(i).hareketEt();
			sonraki.yon = onceki.yon;
		}
		kutu.hareketEt();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		rec = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(10));
		g2.draw(rec);
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	public boolean carpismaVarmi() {
		
		if (kutu.getX() >= getWidth() - kutu.getWidth() - 10) {
			return true;
		}
		
		if (kutu.getX() <= 10) {
			return true;
		}
		
		if (kutu.getY() <= 10) {
			return true;
		}
		
		if (kutu.getY() >= getHeight() - kutu.getHeight() - 10) {
			return true;
		}
		
		for (int i = 1; i < kutular.size(); i++) {
			if ((kutular.get(i).getX() == kutu.getX())&&(kutular.get(i).getY() == kutu.getY())) {
				return true;
			}
		}
		
		if ((yem.getX() == kutu.getX())&&(yem.getY() == kutu.getY())) {
			kuyrukEkle();
			yemEkle();
		}
		
		return false;
	}
	
	class KlavyeKontrol implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (kutu.yon != Yon.ASAGI.getA()) 				
					kutu.yon = Yon.YUKARI.getA();
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (kutu.yon != Yon.YUKARI.getA())
					kutu.yon = Yon.ASAGI.getA();
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (kutu.yon != Yon.SOL.getA())
					kutu.yon = Yon.SAG.getA();
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (kutu.yon != Yon.SAG.getA())
					kutu.yon = Yon.SOL.getA();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class TimerKontrol implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			hepsiniYurut();
			
			if (carpismaVarmi()) {
				timer.stop();
			}
		}

	}
}
