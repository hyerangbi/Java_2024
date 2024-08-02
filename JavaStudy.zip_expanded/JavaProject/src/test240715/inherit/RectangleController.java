package test240715.inherit;

public class RectangleController {
	private Rectangle r;
	
	public RectangleController() {
		this.r = new Rectangle();
	}
	
	public String calcArea(int x, int y, int height, int width) {
		
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int area = r.getHeight() * r.getWidth();
		
		return "면적 : " + r.toString() + " / " + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		
		int perimeter = (r.getHeight()+r.getWidth()) * 2;
		
		
		return "둘레 : " + r.toString() + " / " + perimeter;
	}
}
