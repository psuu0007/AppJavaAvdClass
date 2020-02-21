
public class CardCasePlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardCase cardCase = new CardCase();
	
//		cardCase.shuffle();
		cardCase.caseInSide();
		
		Card card = null;
		
		card = cardCase.pick();
		
//		Card card = cardCase.pick(0);
//		
		System.out.println(card.getCard());
		
	}

}
