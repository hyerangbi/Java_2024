package controller;

import java.util.List;
import java.util.Random;

import model.vo.Tool;

public class ToolSelector {
	
	private	Random random = new Random();
	
	public Tool getRandomTool(List<Tool> toolList) {
		if (toolList == null || toolList.isEmpty()) {
			return null;
		}
		
		return toolList.get(random.nextInt(toolList.size()));
	}
		 			
}
