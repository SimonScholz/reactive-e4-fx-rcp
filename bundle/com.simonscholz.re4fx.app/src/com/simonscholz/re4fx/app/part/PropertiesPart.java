 
package com.simonscholz.re4fx.app.part;

import javax.annotation.PostConstruct;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PropertiesPart {
	
	@PostConstruct
	public void postConstruct(BorderPane parent) {
		Label label = new Label("FileSize");
		TextField textField = new TextField();
		textField.setEditable(false);
//		ValidationSupport.setRequired(textField, true);
		HBox hBox = new HBox(label, textField);
		parent.setCenter(hBox);
	}
}
