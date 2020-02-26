package str.answer;

public class StringLv2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 절대 원본 데이터를 변경하지 않는다
		String originStr = "자바를 자바라"; // 기준
		String changeStr = "";          // 결과   
		
		int lastIndex = 0;
		lastIndex = originStr.length()-1;
//		System.out.println(originStr.charAt(0));
		
//		changeStr = String.valueOf(originStr.charAt(lastIndex));
		changeStr = originStr.charAt(lastIndex) + "";
		
//		문자열 안에서 마지막 문자가 무엇인지 출력하시오 
		
		System.out.println(originStr);
		System.out.println(changeStr);
		
		
	}

}
