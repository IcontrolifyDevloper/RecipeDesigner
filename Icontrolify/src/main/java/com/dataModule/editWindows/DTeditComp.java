package com.dataModule.editWindows;

import java.util.ArrayList;
import java.util.List;

import com.dataModule.designElement.DTrecipeData;
import com.dataModule.interfaces.ICallBack;
import com.vaadin.data.Binder;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;


public class DTeditComp extends FormLayout {
	TextField entry=new TextField();
	ComboBox<String> procedure= new ComboBox<>();
	ComboBox<String> up= new ComboBox<>();
	ComboBox<String> operation= new ComboBox<>();
	ComboBox<String> phase= new ComboBox<>();
     HorizontalLayout box= new      HorizontalLayout();
	private ICallBack myBack;
	ArrayList<String> p1=new ArrayList<String>();
	ArrayList<String> p2=new ArrayList<String>();
	ArrayList<String> p3=new ArrayList<String>();
	ArrayList<String> p4=new ArrayList<String>();
	
	Binder<DTrecipeData> b = new Binder<>();

	public DTeditComp( ICallBack back,String val) {
		myBack = back;
		Button backBut = new Button("Add");
		backBut.addClickListener(e -> doBack(val));
		box.addComponents(procedure, up, operation, phase);
		procedure.setPlaceholder("Procedure");
		up.setPlaceholder("UP");
		operation.setPlaceholder("Operation");
		phase.setPlaceholder("Phase");
		disableFun(val);
		box.setHeight("100px");
		addComponents(box,entry, backBut);
	}



	private void disableFun(String val) {
		// TODO Auto-generated method stub
		switch(val)
		{
		case "UP":
			phase.setEnabled(false);			
			operation.setEnabled(false);			
			 break;
		case "Operation":
			phase.setEnabled(false);	
			 break;
		case "Procedure":
             procedure.setEnabled(false);
			 break;
			 default :
				 break;
		}
	}



	private void doBack(String val) {
		if (b.isValid()) {
		//	myBack.callback();
		} else {
			Notification.show("Wrong Input!", Notification.Type.WARNING_MESSAGE);
		}
		
		
		up.setItems(p1);
		
		
		
		switch(val)
		{
		case "Procedure":
			p1.add(entry.getValue());
			procedure.setItems(p1);
			 break;
		case "UP":
			p2.add(entry.getValue());
			procedure.setItems(p2);			
			 break;
		case "Operation":
			p3.add(entry.getValue());
			procedure.setItems(p3);	
			 break;
		case "Phase":
			p4.add(entry.getValue());
			procedure.setItems(p4);
			 break;
			 default :
				 break;
		}				
	}

}
