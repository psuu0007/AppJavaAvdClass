
public class Tv extends Product{

	Tv(){
		super(100);   // Tv가격은 100만원이라 한다
	}
	
	void mySpecial() {
		System.out.println("전용 필살기");
	}

	@Override
	public String toString() {
		return "Tv";
	}
	
	
}
