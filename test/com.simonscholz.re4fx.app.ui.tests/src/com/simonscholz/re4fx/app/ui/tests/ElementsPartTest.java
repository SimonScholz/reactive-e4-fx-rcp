package com.simonscholz.re4fx.app.ui.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.bestsolution.fx.test.e4.junit.E4JunitTestCase;
import at.bestsolution.fx.test.junit.FXRunner;

@RunWith(FXRunner.class)
public class ElementsPartTest extends E4JunitTestCase {

	public ElementsPartTest() {
		super("com.simonscholz.re4fx.app.product");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testA() {
		rcontroller().cssFirst(".elements-tree-view").get().click();
	}
}
