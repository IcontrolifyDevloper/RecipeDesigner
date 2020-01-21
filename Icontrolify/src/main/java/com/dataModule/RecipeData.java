package com.dataModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeData {
	private String recipeName;
	
	private String procedureName;
	
	private String upName;
	
	private String operationName;	
	
	private String phaseName;
	
	public RecipeData(String recipeName, String procedureName, String upName, String operationName, String phaseName) {
		super();
		this.recipeName = recipeName;
		this.procedureName = procedureName;
		this.upName = upName;
		this.operationName = operationName;
		this.phaseName = phaseName;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getUpName() {
		return upName;
	}

	public void setUpName(String upName) {
		this.upName = upName;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	
	public static List<RecipeData> getExampleList(){
		ArrayList<RecipeData> list = new ArrayList<>();
		list.add(new RecipeData("Recipe1", "Procedure", "UP1", "OP-2","Sho Instruction"));
	
//		Random r = new Random();
//		for (int i = 0; i< 2; i++) {
//			list.add(new RecipeData("Recipe-"+i, "Procedure-9"+i, "UP-"+i, "OP-"+i, " "));
//		}
		
		return list;
	}
}
