package com.dataModule.editWindows;

import com.dataModule.RecipeData;
import com.dataModule.interfaces.ICallBack;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;


public class CTeditRecipeCom extends FormLayout {

	TextField recipeN = new TextField("Recipe Name");

	TextField procedure = new TextField("Procedure Name");

	TextField up = new TextField("UP Name");

	TextField operation = new TextField("Operation Name");

	TextField phase = new TextField("Phase Name");

//	CheckBox isValid = new CheckBox("Status");
	

	private ICallBack myBack;

	Binder<RecipeData> b = new Binder<>();

	public CTeditRecipeCom(RecipeData recipe, ICallBack back) {
		myBack = back;

		b.setBean(recipe);
		b.forField(recipeN).withValidator(text -> text.length() > 2, "To Short!").bind(RecipeData::getRecipeName,
				RecipeData::setRecipeName);
		b.bind(procedure, RecipeData::getProcedureName, RecipeData::setProcedureName);
		b.bind(up, RecipeData::getUpName, RecipeData::setUpName);
		b.bind(operation, RecipeData::getOperationName, RecipeData::setOperationName);					
		b.bind(phase, RecipeData::getPhaseName, RecipeData::setPhaseName);
	
		Button backBut = new Button("Back");
		backBut.addClickListener(e -> doBack());

		addComponents(recipeN, procedure, up, operation, phase,backBut);
	}


	private void doBack() {
		if (b.isValid()) {
			myBack.callback();
		} else {
			Notification.show("Wrong Input!", Notification.Type.WARNING_MESSAGE);
		}
	}

}

