
package com.simonscholz.re4fx.app.part;

import javax.annotation.PostConstruct;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ElementsPart {

	@PostConstruct
	public void postConstruct(BorderPane parent) {
			Button button = new Button("Center");
			button.getStyleClass().add("my-button");
			button.setOnAction(e -> {
				System.err.println("Button center");
			});
			parent.setCenter(button);

			Button button2 = new Button("Bottom");
			button2.getStyleClass().add("my-button2");
			button2.setOnAction(e -> {
				System.err.println("Button bottom");
			});
			parent.setBottom(button2);
	}
}