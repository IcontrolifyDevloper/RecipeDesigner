package com.dataModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dataModule.interfaces.DTcommon;

public abstract class Element implements DTcommon {
	protected static String name;
	protected HashMap<String,Element> list=new HashMap();
	protected int num=0;
	public static String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String eName) {
		// TODO Auto-generated method stub
		name=eName;
	}
	
	public void getList() {
		
		for (Map.Entry<String, Element> entry : list.entrySet()) {
		    String key = entry.getKey();
			System.out.println(key+"  \n  ");
		}
	}
	
	public abstract Element getChild(String eName);
	

}
