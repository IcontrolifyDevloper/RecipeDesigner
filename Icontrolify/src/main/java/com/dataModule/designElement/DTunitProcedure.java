package com.dataModule.designElement;

import com.dataModule.Element;

public class DTunitProcedure extends Element {

	public DTunitProcedure(String num) {
		// TODO Auto-generated constructor stub
		DToperation op=new DToperation(getNum());
		setName(num);
	}

	public String getNum(){
		num++;
	  return "up"+name+num;
	 }

	@Override
	public void addElement() {
		// TODO Auto-generated method stub
		DToperation op=new DToperation(getNum());
		list.put(getNum(), op);
	}

	@Override
	public void removeElement(String eName) {
		// TODO Auto-generated method stub
		list.remove(eName);		
	}

public String getMname() {
	return getName();
	
}

	@Override
	public Element getChild(String eName) {
		// TODO Auto-generated method stub
		return null;
	}

}
