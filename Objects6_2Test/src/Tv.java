
public class Tv {

//	속성 - 크기, 길이, 색상, 볼륨, 채널등
//	기능 - 켜기, 끄기, 볼륨 높이기, 볼륨 낮추기, 채널 변경하기 등
	boolean power;
	int channel;
	
//	return 여부
//	매개변수 여부
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	
}
