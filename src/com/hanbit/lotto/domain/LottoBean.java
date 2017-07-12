package com.hanbit.lotto.domain;

import java.io.Serializable;

public class LottoBean implements Serializable {

	private static final long serialVersionUID = 1L;
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
