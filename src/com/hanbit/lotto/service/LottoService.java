package com.hanbit.lotto.service;

import com.hanbit.lotto.domain.LottoBean;

public interface LottoService {
	public void setLottors(LottoBean bean);
	public int [][] getLottos();
	public boolean isDuplication(int count, int num);
	public void sort(int[] arr);
	public int getCount();
	public void setCount(LottoBean bean);
}
