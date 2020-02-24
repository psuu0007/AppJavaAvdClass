
public class DiceGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dice dice = new Dice();
		
		User user = new User("나");
		User com = new User("com");
		
		System.out.println("나 차례");
		user.dice = dice;
		user.myPosition = user.myPosition + user.dice.roll();
		
		System.out.println("너 차례");
		com.dice = dice;
		com.myPosition = com.myPosition + com.dice.roll();
		
	}

}
