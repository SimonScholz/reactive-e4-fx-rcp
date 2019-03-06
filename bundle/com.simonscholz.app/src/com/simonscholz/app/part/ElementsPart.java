 
package com.simonscholz.app.part;

import javax.annotation.PostConstruct;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ElementsPart {
	
	@PostConstruct
	public void postConstruct(BorderPane parent) {
		Button button = new Button("Hello");
		parent.setCenter(button);
	}
}