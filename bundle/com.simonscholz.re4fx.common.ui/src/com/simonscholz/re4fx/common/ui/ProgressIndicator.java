package com.simonscholz.re4fx.common.ui;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import reactor.core.publisher.Mono;

public class ProgressIndicator {

	private AtomicInteger progressAmout = new AtomicInteger();
	
	private ProgressBar progressBar;
	
	public Node createProgressIndicator() {
		progressBar = new ProgressBar();
		progressBar.getStyleClass().add("progressIndicator");
		
		return progressBar;
	}
	
	public void show() {
		progressBar.setManaged(true);
		progressBar.setVisible(true);
	}
	
	public void hide() {
		progressBar.setManaged(false);
		progressBar.setVisible(false);
	}
	
	public <T> Function<Mono<T>, Mono<T>> progressIndicatorTransformer() {
		return mono -> {
			return mono.doOnSubscribe(s -> {
				if(progressAmout.getAndIncrement() <= 0) {
					show();
				}
			}).doFinally(st -> {
				if(progressAmout.decrementAndGet() <= 0) {
					hide();
				}
			});
		};
	}
}
