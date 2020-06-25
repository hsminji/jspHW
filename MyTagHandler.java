package com.hansin.database.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTagHandler extends SimpleTagSupport {
	int num1;
	int num2;
	int num3;
	int num4;
	int num5;
	
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
	public int getNum3() {
		return num3;
	}
	public int getNum4() {
		return num4;
	}
	public int getNum5() {
		return num5;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public void setNum4(int num4) {
		this.num4 = num4;
	}
	public void setNum5(int num5) {
		this.num5 = num5;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("클래스 기반 커스텀 태그 출력 메시지 - 입력 숫자: ");
		out.print(num1 + "," +num2 +"," +num3 +"," +num4 +"," +num5);
		
		int[] arrs = {num1, num2, num3, num4, num5};
		myquick(arrs, 0, arrs.length -1);
		
		out.println("정렬 후: ");
		
		for(int i: arrs) {
			out.print(i + " ");
		}
		
	}
	
	public static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		return left;
	}

	public static void myquick(int arr[], int left, int right) {

		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);

			myquick(arr, left, pivotNewIndex - 1);
			myquick(arr, pivotNewIndex + 1, right);
		}

	}
}
