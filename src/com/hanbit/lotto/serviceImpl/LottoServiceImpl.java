package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
	int [][] lottos;
	int [] lotto; // 돈과 상관없이 생성되는 한줄(숫자 6개) 로또
	private int count;

	@Override
	public void setCount(LottoBean bean) {
		// 몇줄을 출력할 것인지 로또 수 계산(최대값 5줄)
		count = (bean.getMoney()/1000>=5)?5:bean.getMoney()/1000;
	}
	
	@Override
	public void setLottors(LottoBean bean) {
		setCount(bean);
		lottos = new int [count][6];
		
		for (int count=0;count<lottos.length;count++) {
			for (int i=0;i<6;i++) {
				int num = bean.getNumber();
				if (!isDuplication(count, num)) {
					lottos[count][i] = num;
				}
				else {
					i--;
				}
				/*밑의 코딩은 위의 else {i--;} 와 같아진다
				 * 더 복잡하므로 간단한 녀석으로 사용해준다
				 * else if (isDuplication(count, num)) {
					num = bean.getNumber();
					lottos[count][i] = num;
				}*/
			}sort(lottos[count]);
		}
	}

	@Override
	public int[][] getLottos() {
		//만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		//중복된 번호인지 체크 (중복이면 true 리턴)
		boolean flag = false;
		
		for (int i=0;i<lottos[count].length;i++) {
			if (num==lottos[count][i]) {
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public void sort(int[] arr) {
		int temp=0;
		for (int i=0;i<arr.length-1;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}

	@Override
	public int getCount() {
		// 해당 로또 수만큼 출력
		return count;
	}

}
