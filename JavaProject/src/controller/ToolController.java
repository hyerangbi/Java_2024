package controller;

import java.util.ArrayList;
import java.util.List;

import model.vo.Tool;

public class ToolController {
	private List<Tool> toolList;
	private Tool t;
	
	// 생성자에서 리스트 초기화 및 아이템 추가
	public ToolController() {
		toolList = new ArrayList<>();
		addTools();
	}
	
	// 아이템을 리스트에 추가하는 메소드
	private void addTools() {		
		toolList.add(new Tool(1, "종이뭉치", 10));
		toolList.add(new Tool(2, "이쑤시개", 5));
		toolList.add(new Tool(3, "미정의3", 20));
		toolList.add(new Tool(4, "동그란 얼음", 30));
		toolList.add(new Tool(5, "미정의5", 100));
		toolList.add(new Tool(6, "미정의6", 22));
		toolList.add(new Tool(7, "미정의7", 55));
		toolList.add(new Tool(8, "미정의8", 33));
		toolList.add(new Tool(9, "먼지덩어리", 1));
		toolList.add(new Tool(10, "솜", 0));
				
	}
	
	// 리스트 반환 메소드
	public List<Tool> getToolList(){
		return toolList;
	}
	
	
		
	// 가지고 있는 도구에 대한 정보 
	public void informTool(Tool randomTool) {
		
		System.out.println(randomTool.toString());
	}
}
