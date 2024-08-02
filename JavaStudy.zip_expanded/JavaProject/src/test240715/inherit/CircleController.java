package test240715.inherit;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		double area = Math.PI * c.getRadius() * c.getRadius();
		
		return "면적 : " + c.toString() + " / " + area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double circum = Math.PI * c.getRadius() * 2;		
		return "둘레 : " + c.toString() +" / " + circum;
	}
}
