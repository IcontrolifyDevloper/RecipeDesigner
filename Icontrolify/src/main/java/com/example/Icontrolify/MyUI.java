package com.example.Icontrolify;

import javax.servlet.annotation.WebServlet;

import com.dataModule.CTrecipeDialogTable;
import com.dataModule.RdTable;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {


	VerticalLayout mainLayout = new VerticalLayout();

	Component actualComponent;
	@Override
	protected void init(VaadinRequest vaadinRequest) {	
		mainLayout.setSizeFull();
		mainLayout.setMargin(false);
		Label title = new Label("Recipe design  Tree");
		title.setStyleName("title");
		mainLayout.addComponent(title);

		MenuBar mbar = new MenuBar();
		mbar.setWidth("100%");
		mainLayout.addComponent(mbar);


		MenuItem compitem = mbar.addItem("File", null);

		MenuItem view = mbar.addItem("View", null);
		MenuItem window = mbar.addItem("Window", null);
		MenuItem abt = mbar.addItem("About", null);
		abt.addItem("(i)About", new MenuCommand(CTrecipeDialogTable.class));
		compitem.addItem("New Design ", new MenuCommand(RdTable.class));
		compitem.addItem("Open Design ", new MenuCommand(CTrecipeDialogTable.class));
		compitem.addItem("Help ", new MenuCommand(RdTable.class));


		setMainComponent(new VerticalLayout());


		setContent(mainLayout);
	}

	public void setMainComponent(Component comp) {
		if (actualComponent != null) {
			if (comp.getClass() == actualComponent.getClass()) {
				//				Nothing to change
				//				return;
			}
			mainLayout.removeComponent(actualComponent);
		}
		mainLayout.addComponent(comp);
		mainLayout.setExpandRatio(comp, 1);
		actualComponent = comp;
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	class MenuCommand implements Command {

		private Class myClass;

		private Component comp;

		MenuCommand(Class compclass) {
			myClass = compclass;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {

			if (comp == null)
				try {
					comp = (Component) myClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}

			setMainComponent(comp);
		}
	}

}
