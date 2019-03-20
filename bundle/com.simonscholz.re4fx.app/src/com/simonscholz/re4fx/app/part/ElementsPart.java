
package com.simonscholz.re4fx.app.part;

import java.io.File;

import javax.annotation.PostConstruct;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class ElementsPart {

	@PostConstruct
	public void postConstruct(BorderPane parent) {
		File file = File.listRoots()[0];
		TreeItem<File> treeItem = new TreeItem<>(file);
		File[] listFiles = file.listFiles();
		for (File childFile : listFiles) {
			TreeItem<File> childTreeItem = new TreeItem<>(childFile);
			treeItem.getChildren().add(childTreeItem);
		}
		
		TreeView<File> treeView = new TreeView<>(treeItem);
		treeView.getStyleClass().add("elements-tree-view");
		parent.setCenter(treeView);
	}
}