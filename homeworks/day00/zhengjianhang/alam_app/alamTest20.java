package com.alam.app.alam_app;

public class alamTest20 {
	/*
	 * 翻转一个long类型数字, 例如123456L 输出654321L
	 */
	public static long Reverse(long l) {
		long ll = 0L;
		String sl = "" + l;// 输入值转string
		int lsl = sl.length();// 输入值长度
		String ol = "";// 输出string
		long oll = 0L;// 输出long
		for (int i = 0; i < lsl; i++) {
			char slc = sl.charAt(i);
			// System.out.println(slc);
			int slci = Character.getNumericValue(slc);
			// System.out.println(slci);
			int outlong = (int) (slci * Math.pow(10, (i)));
			// System.out.println(outlong);

			oll += outlong;
		}
		return oll;

	}

	public static void main(String[] args) {

		System.out.println(Reverse(1234567L));// 7654321
		System.out.println(Reverse(0L));// 0
	}

}
