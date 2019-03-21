
package com.simonscholz.re4fx.app.part;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.controlsfx.control.CheckComboBox;
import org.controlsfx.validation.ValidationSupport;

import com.fasterxml.jackson.core.type.TypeReference;
import com.simonscholz.re4fx.common.domain.Contributor;
import com.simonscholz.re4fx.common.services.ReactorHttpClient;

import freetimelabs.io.reactorfx.schedulers.FxSchedulers;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import reactor.core.publisher.Mono;

public class PropertiesPart {

	@PostConstruct
	public void postConstruct(BorderPane parent, ReactorHttpClient client) {
		Label label = new Label("FileSize");
		TextField textField = new TextField();
		textField.setEditable(false);
		ValidationSupport.setRequired(textField, true);

		// create the data to show in the CheckComboBox
		final ObservableList<String> strings = FXCollections.observableArrayList();
		for (int i = 0; i <= 100; i++) {
			strings.add("Item " + i);
		}

		// Create the CheckComboBox with the data
		final CheckComboBox<String> checkComboBox = new CheckComboBox<>(strings);

		// and listen to the relevant events (e.g. when the selected indices or
		// selected items change).
		checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
			public void onChanged(ListChangeListener.Change c) {
				System.out.println(checkComboBox.getCheckModel().getCheckedItems());
			}
		});

		TextArea textArea = new TextArea();
		TypeReference<List<Contributor>> cListType = new TypeReference<List<Contributor>>() {
		};
		Mono<List<Contributor>> mono = client
				.get("https://api.github.com/repos/simonscholz/reactive-e4-fx-rcp/contributors", cListType);

		mono.publishOn(FxSchedulers.fxThread()).subscribe(contributors -> {
			textArea.setText(contributors.stream().map(String::valueOf).collect(Collectors.joining()));
		}, Throwable::printStackTrace);

		VBox hBox = new VBox(label, textField, checkComboBox, textArea);
		parent.setCenter(hBox);

	}
}
