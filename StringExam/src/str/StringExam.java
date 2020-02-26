
package str;
// 황지원
public class StringExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 절대 원본 데이터를 변경하지 않는다
		String originStr = "자바를 자바라"; // 기준
		String changeStr = ""; // 결과
		
		
		
		
		int index = originStr.indexOf(originStr);
		
		changeStr = originStr.substring(index, 4) + "잡아라";
		
//		changeStr = originStr.replace("자바라", "잡아라");

		
		// 자바를 자바라를 자바를 잡아라로 변경하여 출력하시오

		System.out.println(originStr);
		System.out.println(changeStr);

	}

}