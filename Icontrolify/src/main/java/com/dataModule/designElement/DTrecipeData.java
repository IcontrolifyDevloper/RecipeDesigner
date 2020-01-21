package com.dataModule.designElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.dataModule.Element;
import com.dataModule.TableData;

public class DTrecipeData extends Element {
	private static List<DTprocedure> child= new LinkedList();
	public DTrecipeData(String name) {
		super();
		DTprocedure procedure= new DTprocedure(getNum());
		setName(name);
	}

	private String getNum() {
		// TODO Auto-generated method stub
		num++;
		return name+num;
	}

	public DTrecipeData(List<DTprocedure> child){
		super();
		this.child = child;
	}

	public DTprocedure getChild() {
		return child.get(0);
	}

	@Override
	public void addElement() {
		// TODO Auto-generated method stub
		DTprocedure elmt =  new DTprocedure(getNum()) ;		
		list.put(getNum(),elmt);
	}

	@Override
	public void removeElement(String eName) {
		// TODO Auto-generated method stub
            list.remove(eName);
	}

	@Override
	public Element getChild(String eName) {
		// TODO Auto-generated method stub
		return list.get(eName);
	}
	
	public static List<TableData> getExampleList(){
		ArrayList<TableData> list = new ArrayList<>();
		if(!list.isEmpty()) {
	  list.add(new TableData(getName(),child.get(0).getName(),"pp", "686-90"));
		
		}
	
		list.add(new TableData("Table", "122-11","Camera", "686-90"));
		list.add(new TableData("Chair", "686-90", "Camera", "686-90"));

		//		Random r = new Random();
//		for (int i = 0; i< 20; i++) {
//			list.add(new ArticleData("Thing-"+i, i+"-99-4", r.nextInt(99800)*0.01+1.99, true));
//		}	
		return list;
	}

}
