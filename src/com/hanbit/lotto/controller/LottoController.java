package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoService service = new LottoServiceImpl();
		LottoBean bean = new LottoBean();
		StringBuffer buff = new StringBuffer();
		while (true) {
			switch (JOptionPane.showInputDialog("0. 안사 1. 산다")) {
			case "0":
				return;
			case "1":
				bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("돈내놔")));
				service.setLottors(bean);
				int[][] arr = service.getLottos();
				for (int i=0;i<arr.length;i++) {
					for (int j=0;j<arr[i].length;j++) {
						//System.out.print(arr[i][j] + "\t");
						buff.append(arr[i][j] + "\t");
					}
					buff.append("/");
				}
				int lottoSerialNo = (int)(Math.random()*99999+10000);
				File output = new File("C:\\Users\\1027\\JavaProjects\\lottos\\" + lottoSerialNo + ".txt");
				FileWriter fw = null;
				BufferedWriter bw = null;
				String[] lottoPrint = buff.toString().split("/");
				try {
					bw = new BufferedWriter(new FileWriter(output));
					for (String s:lottoPrint) {
						s += System.getProperty("line.separator");// 라인 계행(\n 과 같음)
						bw.write(s);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
		}
	}
}
