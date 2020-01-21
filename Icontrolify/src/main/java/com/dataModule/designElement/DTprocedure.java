package com.dataModule.designElement;

import java.util.Map;

import com.dataModule.Element;

public class DTprocedure extends Element {
	DTprocedure(String pname){
		DTunitProcedure elmt =  new DTunitProcedure(getNum()) ;
		setName(pname);
	}
	public String getNum(){
		num++;
	  return name+num;
	 }
	
	@Override
	public void addElement() {
		// TODO Auto-generated method stub
		DTunitProcedure elmt =  new DTunitProcedure(getNum()) ;		
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
}
