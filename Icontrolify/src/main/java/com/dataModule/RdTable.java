package com.dataModule;

import java.util.List;
import java.util.Optional;

import com.dataModule.editWindows.CTeditRecipeCom;
import com.dataModule.editWindows.DTeditComp;
import com.example.Icontrolify.MyUI;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class RdTable extends VerticalLayout {

	private Window dialog;
	HorizontalLayout editField= new HorizontalLayout();
	TextField rName= new TextField("Recipe Name");
	HorizontalLayout recipeDetail= new HorizontalLayout();
	ComboBox<String> pType= new ComboBox();
	Button create = new Button("Create");
	Button add = new Button("Add");
	RadioButtonGroup<String> single = new RadioButtonGroup<>("Single Selection");


	public RdTable() {
		add.addClickListener(e -> doADD());

		pType.setItems("Inventory","Production","Maintainance");
		pType.setPlaceholder("Type ");
		recipeDetail.addComponents(rName,pType,create);
		recipeDetail.setComponentAlignment(create, Alignment.BOTTOM_RIGHT);
		recipeDetail.setComponentAlignment(pType, Alignment.BOTTOM_RIGHT);
		single.setItems("PROCEDURE","UP","OPERATION","PHASE");
		editField.setEnabled(false);
		create.addClickListener(e-> {
			if(!rName.getValue().isEmpty()||pType.isSelected(null))
			{
				String name=rName.getValue();
				String type=pType.getValue();			
				createRecipe(rName.getValue());
				editField.setEnabled(true);
				recipeDetail.removeAllComponents();
				recipeDetail.addComponents(new Label("Recipe Name : "+name+"    "+"   Type :  "+type));
			}
			else {
				//Poup CODE PleaseEnter Recipe Name

				exceptionDialog();
			}
		}
				);
		recipeDetail.setMargin(true);
		editField.addComponents(single,add);
		addComponents(recipeDetail,editField);
        setComponentAlignment(recipeDetail, Alignment.TOP_CENTER);
		this.setSizeFull();
	}


	private void exceptionDialog() {
		// TODO Auto-generated method stub

		MyUI ui = (MyUI) UI.getCurrent();

		String val="UP";
		Optional<String> ab = single.getSelectedItem();
		if(ab.isPresent()) {
			val= ab.get();
		}
		dialog = new Window("Error Message");
		VerticalLayout error =new VerticalLayout();
		Button btn=new Button("OK");
		if(pType.isSelected("Production")||pType.isSelected("Maintenance")||pType.isSelected("Inventory"))
			error.addComponents(new Label("Please enter Valid Recipe Name first.."),btn);
		else
			error.addComponents(new Label("Please selct Recipe Type.."),btn);
		btn.addClickListener(e->{
			rName.focus();
			pType.focus();
			dialog.close();} );
		dialog.setContent(error);
		dialog.center();
		dialog.setWidth("350px");
		dialog.setHeight("150px");
		dialog.setModal(true);
		UI.getCurrent().addWindow(dialog);

	}


	private Object createRecipe(String value) {
		// TODO Auto-generated method stub
		return null;
	}


	private void doCheck() {
		// TODO Auto-generated method stub

	}


	private void doADD() {
		// TODO Auto-generated method stub				
		MyUI ui = (MyUI) UI.getCurrent();

		String val="UP";
		Optional<String> ab = single.getSelectedItem();
		if(ab.isPresent()) {
			val= ab.get();
		}
		dialog = new Window("Design Window");

		dialog.setContent(new DTeditComp(this::closeWindow, val));
		dialog.center();
		dialog.setWidth("800px");
		dialog.setHeight("300px");
		dialog.setModal(true);
		UI.getCurrent().addWindow(dialog);

	}


	private void edit(SelectionEvent<RecipeData> e) {
		MyUI ui = (MyUI) UI.getCurrent();
		Optional<RecipeData> optArt = e.getFirstSelectedItem();
		if (optArt.isPresent()) {
			dialog = new Window("Edit Design");
			dialog.setContent(new CTeditRecipeCom(optArt.get(), this::closeWindow));
			dialog.center();
			dialog.setWidth("500px");
			dialog.setModal(true);
			UI.getCurrent().addWindow(dialog);
		}
	}

	public void closeWindow() {
		dialog.close();
		//refresh
	}

}


