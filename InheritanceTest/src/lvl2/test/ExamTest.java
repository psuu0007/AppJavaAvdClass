package lvl2.test;

public class ExamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MotionlessHuman motionlessHuman = new MotionlessHuman();
		
		WalkHuman walkHuman = new WalkHuman(); // 1
		
		RunHuman runHuman = new RunHuman(); // 2
		
		Human human = new Human();  // 3
		
		Plane plane = new Plane(); // 4
		
//		FlyHuman flyHuman = new FlyHuman(); // 5
		
		// 각 객체가 접근가능한 멤버를 작성하시오
		// 자바 용어를 사용하시오
		
		motionlessHuman.name = "mh";
		motionlessHuman.stay();
		
		walkHuman.name = "wh";
		walkHuman.walking();
		
		runHuman.name = "rh";
		runHuman.running();
		
		human.name = "h";
		human.namePrint();
		
		plane.fly = "^^";
		plane.flying();
	}

}
