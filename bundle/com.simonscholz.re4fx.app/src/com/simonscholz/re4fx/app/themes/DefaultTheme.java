package com.simonscholz.re4fx.app.themes;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.theme.AbstractTheme;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(name = "theme-default", service = org.eclipse.fx.ui.services.theme.Theme.class)
public class DefaultTheme extends AbstractTheme {
	public DefaultTheme() {
		super("theme.default", "Default theme", DefaultTheme.class.getClassLoader().getResource("css/default.css"));
	}
	
	@Reference(cardinality = ReferenceCardinality.MULTIPLE)
	@Override
	public void registerStylesheet(Stylesheet stylesheet) {
		super.registerStylesheet(stylesheet);
	}
	
	@Override
	public void unregisterStylesheet(Stylesheet stylesheet) {
		super.unregisterStylesheet(stylesheet);
	}
}
