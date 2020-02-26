package com.tg.tryy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx4 {
	
	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		Scanner scan = new Scanner(System.in);
		
		try {
			int n = scan.nextInt();
			System.out.println(3);
			System.out.println(0/0);    // 0으로 나누어서는 안된다
			System.out.println(4);
		}catch (ArithmeticException ae) {
			ae.printStackTrace();
		} catch (InputMismatchException ae) {
			ae.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception");
		}
		
		System.out.println(6);
		
		
	}
}
