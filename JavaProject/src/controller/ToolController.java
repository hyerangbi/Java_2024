package controller;

import java.util.ArrayList;
import java.util.List;

import model.vo.Tool;

public class ToolController {
	private List<Tool> toolList = new ArrayList<>();	
	private Tool t;
	
	public ToolController() {	
		super();		
		
		new Tool(1, "종이뭉치", 10);
		new Tool(2, "이쑤시개", 5);
		new Tool(3, "미정의3", 20);
		new Tool(4, "동그란 얼음", 30);
		new Tool(5, "미정의5", 100);
		new Tool(6, "미정의6", 22);
		new Tool(7, "미정의7", 55);
		new Tool(8, "미정의8", 33);
		new Tool(9, "먼지덩어리", 1);
		new Tool(10, "솜", 0);
			
	}
	
	/*
	public List getToolList(){
		return toolList;
	}
	*/
	
	// Toolrand을 돌려서 toolList에 있는 도구의 번호와 같은 데이터 추출
	public Tool insertTool() {
		int Toolrand = (int)(Math.random()*10)+1;		
		
		
		
		
		return t;
	}
	
	// 가지고 있는 도구에 대한 정보 
	public Tool informTool() {
		return t;
	}
}
