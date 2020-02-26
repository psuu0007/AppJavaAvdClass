package str.answer;

public class StringUtil4_1 {

	// 자바라는 글자가 있다면 무조건 2개를 앞에서부터 찾아서 변경해준
	String changeJavaToDb(String originStr) {
		String changeStr = "";  // 리턴 값
		String interestingStr = ""; 	// 대상 
		int interestingIndex = 0;
		
		changeStr = originStr;
		interestingStr = "자바";
	
		String frontStr = "";
		String centerStr = "";
		String endStr = "";
		
		for (int i = 0; i < 2; i++) {
			
			interestingIndex = changeStr.indexOf(interestingStr);
			
//			System.out.println(interestingIndex);
			
			frontStr = changeStr.substring(0, interestingIndex);
//			System.out.println(frontStr);
			centerStr = changeStr.substring(interestingIndex, 
					interestingIndex+interestingStr.length());
//			System.out.println(centerStr);
			centerStr = centerStr.replace(interestingStr, "DB");
//			System.out.println(centerStr);
			endStr = changeStr.substring(
					interestingIndex+interestingStr.length());
//			System.out.println(endStr);
			
			changeStr = frontStr + centerStr + endStr;
//			System.out.println("!!!!!!!! " + changeStr);
//			System.out.println("!!!!!!!! " + originStr);
		}
		
		return changeStr;
	}
	
}
