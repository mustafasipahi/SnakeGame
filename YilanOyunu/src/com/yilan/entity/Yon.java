package com.yilan.entity;

public enum Yon {

	SAG(-1),
	SOL(1),
	ASAGI(-2),
	YUKARI(2);

	private final int a;
	
	private Yon(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}
	
}
