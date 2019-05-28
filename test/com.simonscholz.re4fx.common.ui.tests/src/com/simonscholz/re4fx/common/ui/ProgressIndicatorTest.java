package com.simonscholz.re4fx.common.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.bestsolution.fx.test.junit.FXRunner;
import javafx.scene.Node;
import reactor.core.Disposable;
import reactor.test.publisher.TestPublisher;

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
	public void testTransformerMultipleSubscriptionsCanceled() {
		// act
		TestPublisher<String> testPublisher = TestPublisher.create();
		TestPublisher<String> testPublisher2 = TestPublisher.create();

		Disposable subscribe = testPublisher.mono().transform(progressIndicator.progressIndicatorTransformer())
				.subscribe();
		Disposable subscribe2 = testPublisher2.mono().transform(progressIndicator.progressIndicatorTransformer())
				.subscribe();
		
		subscribe.dispose();
		subscribe2.dispose();

		// assert
		assertFalse(progressIndicatorNode.isVisible());
		assertFalse(progressIndicatorNode.isManaged());
	}

}
