public class ExArrayList2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArr1 = new String[4];
		String[] strArr2 = new String[3];
		
		strArr1[0] = "첫번째";
		strArr1[1] = "두번째";
		strArr1[2] = "세번째";
		strArr1[3] = "네번째";
		
		viewArr(strArr1);
		System.out.println("strArr1 0번째를 지운다.");

		for (int i = 0; i < strArr2.length; i++) {
			strArr2[i] = strArr1[i + 1];
		}
		System.out.println();

		viewArr(strArr2);

	}

	public static void viewArr(String[] strArr) {

		String str = "";

		for (int i = 0; i < strArr.length; i++) {
			str = strArr[i];
			System.out.println(i + " : " + str);
		}
		System.out.println();

	}

}
