package tg.m;

import java.util.HashMap;
import java.util.Scanner;

public class ExMap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> userMap = new HashMap<String, String>();

		userMap.put("admin", "admin12@");
		userMap.put("tg", "theGood");
		userMap.put("seven", "qwer1234");

		Scanner scan = new Scanner(System.in);

		System.out.println("id와 password를 입력해주세요");
		System.out.print("id : ");
		String id = scan.nextLine().trim();

		System.out.print("password : ");
		String pwd = scan.nextLine().trim();
		System.out.println();

		if (userMap.containsKey(id) == false) {
			System.out.println("입력하신 id는 존재하지 않습니다");
		} else {
			if (userMap.get(id).equals(pwd) == false) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
				System.out.println("로그인 되었습니다.");
			}
		}

	}

}
