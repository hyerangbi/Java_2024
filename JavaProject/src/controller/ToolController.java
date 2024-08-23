package controller;

import java.util.ArrayList;
import java.util.List;

import model.vo.Tool;



public class ToolController {
	private List<Tool> toolList = new ArrayList<>();

	public ToolController() {
		super();
		toolList.add(new Tool(1, "미정의1", 10));
		toolList.add(new Tool(2, "이쑤시개", 5));
		toolList.add(new Tool(3, "미정의3", 20));
		toolList.add(new Tool(4, "미정의4", 30));
		toolList.add(new Tool(5, "미정의5", 100));
		toolList.add(new Tool(6, "미정의6", 22));
		toolList.add(new Tool(7, "미정의7", 55));
		toolList.add(new Tool(8, "미정의8", 33));
		toolList.add(new Tool(9, "먼지덩어리", 1));
		toolList.add(new Tool(10, "솜", 0));
	}
	
	public List<Tool> getToolList(){
		return toolList;
	}
	
	public Tool searchTool(String tName) {
		for (Tool t : toolList) {
			if(t.gettoolName().equals(tName)) {
				return t;
			}
		}
		return null;
	}
	
}
