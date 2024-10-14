package test240719.object1;

public class AnimalManager{
	public static void main(String[] agrs) {
		Animal[] aArr = new Animal[5];
		
		aArr[0] = new Dog("흰둥이","시고르자브종", 20);
		aArr[1] = new Cat("코코","렉돌","우리집","하양색");
		aArr[2] = new Dog("두부","포메라니안", 12);
		aArr[3] = new Cat("나비","삼색","우리집","삼색");
		aArr[4] = new Cat("냥","스트릿출신","우리집","까망색");
		
		for(Animal ani : aArr) {
			 ani.speak();
		}
	}
}
