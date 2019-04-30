package com.simonscholz.re4fx.common.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.bestsolution.fx.test.junit.FXRunner;
import javafx.scene.Node;

@RunWith(FXRunner.class)
public class ProgressIndicatorTest {

	private ProgressIndicator progressIndicator;
	private Node progressIndicatorNode;

	@Before
	public void setUp() throws Exception {
		progressIndicator = new ProgressIndicator();
		progressIndicatorNode = progressIndicator.createProgressIndicator();
	}

	@Test
	public void testShowIndicator() {
		// act
		progressIndicator.show();
		
		// assert
		assertTrue(progressIndicatorNode.isVisible());
		assertTrue(progressIndicatorNode.isManaged());
	}

	@Test
	public void testHideIndicator() {
		// act
		progressIndicator.show();
		progressIndicator.hide();
		
		// assert
		assertFalse(progressIndicatorNode.isVisible());
		assertFalse(progressIndicatorNode.isManaged());
	}

	@Test
	public void testTransformerHide() {
		// act
		progressIndicator.show();
		progressIndicator.hide();
		
		// assert
		assertFalse(progressIndicatorNode.isVisible());
		assertFalse(progressIndicatorNode.isManaged());
	}

}
