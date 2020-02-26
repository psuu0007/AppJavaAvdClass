package str.answer;

public class StringUtil4_2 {

	// 자바라는 글자가 있다면 무조건 2개를 앞에서부터 찾아서 변경해준
	String changeJavaToDb(String originStr) {
		String changeStr = ""; // 리턴 값
		String tempOriginStr = ""; // 원본 백업
		String interestingStr = ""; // 대상
		int interestingIndex = 0;

		tempOriginStr = originStr;
		interestingStr = "자바";

		String frontStr = "";
		String centerStr = "";
		String endStr = "";
		for (int i = 0; i < 2; i++) {

			interestingIndex = tempOriginStr.indexOf(interestingStr);

//			System.out.println(interestingIndex);

			frontStr = tempOriginStr.substring(0, interestingIndex);
//			System.out.println(frontStr);
			centerStr = tempOriginStr.substring(interestingIndex, interestingIndex + interestingStr.length());
//			System.out.println(centerStr);
			centerStr = centerStr.replace(interestingStr, "DB");
//			System.out.println(centerStr);
			endStr = tempOriginStr.substring(interestingIndex + interestingStr.length());
//			System.out.println(endStr);

			changeStr = frontStr + centerStr + endStr;
//			System.out.println("!!!!!!!! " + changeStr);
//			System.out.println("!!!!!!!! " + originStr);
		}

		changeStr = tempOriginStr;
		return changeStr;
	}

	/**
	 * @param originStr 변경할 내용이 있는 문자열
	 * @param findStr   변경할 내용이 있는 문자열에서 변경하고자 하는 문자열
	 * @param changeStr 변경할 새로운 문자열
	 * @param count     변경할 횟수
	 * @return 사용자가 변경하길 원하는 문자열을 원하는 키워드로 앞에서 부터 원하는 
	 * 	숫자만큼 변경하여 준다
	 * @Author : Administrator
	 * @Date : 2019. 8. 7.
	 * @Method Name : changeJavaToDb
	 * @return : String
	 */
	String changeJavaToDb(String originStr, 
			String findStr, String changeStr, int count) {
		String returnStr = ""; // 리턴 값
		int interestingIndex = 0;

		String frontStr = "";
		String centerStr = "";
		String endStr = "";
		for (int i = 0; i < count; i++) {

			interestingIndex = originStr.indexOf(findStr);

//				System.out.println(interestingIndex);

			frontStr = originStr.substring(0, interestingIndex);
//				System.out.println(frontStr);
			centerStr = originStr.substring(interestingIndex, interestingIndex + findStr.length());
//				System.out.println(centerStr);
			centerStr = centerStr.replace(findStr, changeStr);
//				System.out.println(centerStr);
			endStr = originStr.substring(interestingIndex + findStr.length());
//				System.out.println(endStr);

			originStr = frontStr + centerStr + endStr;
//			System.out.println("!!!!!!!! " + originStr);
		}

		returnStr = originStr;
		
		return returnStr;
	}

}
