package com.simonscholz.re4fx.common.domain;
public class Contributor {
	private String login;
	private int contributions;
	
	public Contributor() {
	}

	public Contributor(String login, int contributions) {
		this.setLogin(login);
		this.setContributions(contributions);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getContributions() {
		return contributions;
	}

	public void setContributions(int contributions) {
		this.contributions = contributions;
	}

	@Override
	public String toString() {
		return "Contributor [login=" + login + ", contributions=" + contributions + "]";
	}
}