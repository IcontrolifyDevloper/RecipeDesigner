package com.dataModule;

public class TableData {
	private String procedureName;

	public TableData(String procedureName, String upName, String operationName, String phaseName) {
		super();
		this.procedureName = procedureName;
		this.upName = upName;
		this.operationName = operationName;
		this.phaseName = phaseName;
	}

	private String upName;

	private String operationName;	

	private String phaseName;

}
