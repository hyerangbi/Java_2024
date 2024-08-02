package test240710.object3;

public class SnackController {
	
	private Snack s = new Snack();
	
	public SnackController() {
		super();
		System.out.println("SnackController 생성 됨.");
	}
	
	public String saveDate(String kind, String name, String flavor, int numOf, int prise) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(prise);
		
		return "저장 완료되었습니다.";
		
	}
	
	public String comfirmData() {
		
			return s.getKind()+"("+s.getName()+s.getFlavor()+")"
					+s.getNumOf()+" - "+s.getPrice()+"원";
	}
	
	
	
}
