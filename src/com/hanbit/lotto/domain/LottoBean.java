package com.hanbit.lotto.domain;

public class LottoBean {
	private int number, money;

	public int getNumber() {
		setNumber();
		return number;
	}

	public void setNumber() {
		this.number = (int)(Math.random()*45+1);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
