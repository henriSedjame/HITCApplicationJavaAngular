package com.app.projet.entities;

public enum Langues {
	ANGLAIS("cours d'anglais"),
	FRANCAIS("cours de français"),
	ALLEMAND ("cours d'allemand"),
	ESPAGNOL("cours d'espagnol"),
	ARABE("cours d'arabe"),
	FINNOIS("cours de finlandais");
	
	private final String label;

	private Langues(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
