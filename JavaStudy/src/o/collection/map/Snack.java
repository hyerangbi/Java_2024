package o.collection.map;

public class Snack {
	private String flavor;
	private int calory;
	
	public Snack() {
		super();
	}

	public Snack(String flavor, int price) {
		super();
		this.flavor = flavor;
		this.calory = calory;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getcalory() {
		return calory;
	}

	public void setcalory(int calory) {
		this.calory = calory;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", calory=" + calory + "]";
	}
	
	
}
