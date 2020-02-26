package str.answer;

public class StringLv3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 절대 원본 데이터를 변경하지 않는다
		String originStr = "자바를 자바라"; // 기준
		String changeStr = "";          // 결과
		int interestingIndex = 0;
		String interestingKeyword = "자바";
		interestingIndex = originStr.lastIndexOf("자바");
		
//		System.out.println(interestingIndex);
		String frontStr = "";
		String centerStr = "";
		String endStr = "";
		
		frontStr = originStr.substring(0, interestingIndex);
		System.out.println(frontStr);
		
		centerStr = originStr.substring(interestingIndex, interestingIndex 
				+ "자바".length());
		System.out.println(centerStr);
		
		centerStr = centerStr.replace("자바", "잡아");
		System.out.println(centerStr);
		
		endStr = originStr.substring(interestingIndex 
				+ interestingKeyword.length());
		System.out.println(endStr);
		
		changeStr = frontStr + centerStr + endStr;
		
//		자바를 자바라를 자바를 잡아라로 변경하여 출력하시오 
		
		System.out.println(originStr);
		System.out.println(changeStr);
		
		
		
	}

}
