 
package com.simonscholz.re4fx.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AboutHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(AboutHandler.class);
	
	@Execute
	public void execute() {
		LOG.warn("Show About Dialog...");
	}
		
}