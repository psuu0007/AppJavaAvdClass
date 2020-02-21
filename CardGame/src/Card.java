
public class Card {

	static String[] shapeArr = {"♥", "◆", "♠", "♣"};
	static String[] numberArr = {"A", "2", "3", "4", "5",
			"6", "7", "8", "9", "T", "J", "Q", "K"};
	
	String card = "";
	
	Card(){
		
	}
	
	public Card(int shapeIndex, int numberIndex) {
		init(shapeIndex, numberIndex);
	}
	
	//	랜덤 뽑기
	void init() {
		// 모양 랜덤
		int shapeIndex = (int)(Math.random() * shapeArr.length);
		// 숫자 랜덤
		int numberIndex = (int)(Math.random() * numberArr.length);
		// ♠4이런게 됨
		card = shapeArr[shapeIndex] + numberArr[numberIndex];
	}
	
	// 직접 뽑기
	void init(int shapeIndex, int numberIndex) {
		// ♠4이런게 됨
		card = shapeArr[shapeIndex] + numberArr[numberIndex];
	}
	
	String getCard() {
		return card;
	}
	
}
