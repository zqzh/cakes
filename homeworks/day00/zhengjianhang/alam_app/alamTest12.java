package com.alam.app.alam_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class alamTest12 {
	/*二分查找
	 * int[]{1,2,4,6,1,4,5,6,9,3}找出3
	 * */
	public static boolean findInt(int[] array,int ii) {
		if(array.length<1) {
			return false;
		}
		Arrays.sort(array);
//		System.out.println("升序排序：");
		List<Integer> list1=new ArrayList<Integer>();
		for (int num : array) {
			list1.add(num);
//			System.out.println(num);
		}
		int ls=list1.size();
//		int ls2=(int)li.size()/2;
//		System.out.println(list1.size());
		int left=0;
		int right=ls-1;
//		int mid=ls2;
		while ((left+1)<right) {
			int mid=(int)(right+left)/2;
			if(ii>list1.get(mid)) {
				left=mid;
			}else if(ii<list1.get(mid)) {
				right=mid;
			}else {
				return true;
			}
		}return false;
	}

	public static void main(String[] args) {
		int[] list1 ={1,2,4,6,1,4,5,6,9,3};
		System.out.println(findInt(list1,3));//true
		
		int[] list2 ={1,2,4,6,1,4,5,6,9,7};
		System.out.println(findInt(list2,3));//false
		
		int[] list3 ={1,2,4,6,1,4,5,6,9,3,1};
		System.out.println(findInt(list3,3));//true
		
		int[] list4 ={};
		System.out.println(findInt(list4,3));//false
	}
}
