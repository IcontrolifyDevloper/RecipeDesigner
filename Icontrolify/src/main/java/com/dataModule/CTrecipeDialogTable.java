package com.dataModule;

import java.util.List;
import java.util.Optional;

import com.dataModule.editWindows.CTeditRecipeCom;
import com.dataModule.editWindows.DTeditComp;
import com.example.Icontrolify.MyUI;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class CTrecipeDialogTable  extends VerticalLayout {

	public Grid<RecipeData> articleGrid = new Grid<>();
	private Window dialog;
	List<RecipeData> gridList;

	HorizontalLayout editField= new HorizontalLayout();
	Button add = new Button("Add");
	RadioButtonGroup<String> single = new RadioButtonGroup<>("Single Selection");



	public CTrecipeDialogTable() {
		//	articleGrid.addColumn(RecipeData::getRecipeName).setCaption("Recipe");
		articleGrid.addColumn(RecipeData::getProcedureName).setCaption("Procedure");
		articleGrid.addColumn(RecipeData::getUpName).setCaption("UP-proocedure");
		articleGrid.addColumn(RecipeData::getOperationName).setCaption("Operation");
		articleGrid.addColumn(RecipeData::getPhaseName).setCaption("Phase");
		articleGrid.addSelectionListener(e -> edit(e));

		articleGrid.setSizeFull();
		gridList=RecipeData.getExampleList();
		articleGrid.setItems(gridList);
		//articleGrid.setit
		single.setItems("Procedure", "UP", "Operation","Phase");
		add.addClickListener(e -> doADD());


		editField.addComponents( single,add);
		addComponents(editField,articleGrid);
		this.setExpandRatio(articleGrid, 1);
		this.setSizeFull();
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
		
//		Optional<String> ab = single.getSelectedItem();
//		if(ab.isPresent()) {
//			if("Procedure"==ab.get()){
//				gridList.add(new RecipeData("Test","Procedure", "Test", "Test", "Test"));
//				articleGrid.setItems(gridList);
//			}
//			if("UP"==ab.get()){
//				gridList.add(new RecipeData("Test","Procedure", "Test", "Test", "Test"));
//				articleGrid.setItems(gridList);
//			}
//			if("Operation"==ab.get()){
//				gridList.add(new RecipeData("Recipe","Procedure", "UP", "Operation", "Test"));
//				articleGrid.setItems(gridList);
//			}
//			if("Phase"==ab.get()){
//				gridList.add(new RecipeData("Recipe", "Procedure", "UP", "Operation", "Phase"));
//				articleGrid.setItems(gridList);
//			}
//		}
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
		articleGrid.getDataProvider().refreshAll();
	}

}


