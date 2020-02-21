
public class CaptionTv extends Tv{

	boolean caption = false;  // 캡션 상태
	
	void displayCaption(String text) {
		if(caption == true) {  // 캡션 상태가 true(켠)일 경우 text를 보여준다 
			System.out.println(text);
		}
	}
	
}
