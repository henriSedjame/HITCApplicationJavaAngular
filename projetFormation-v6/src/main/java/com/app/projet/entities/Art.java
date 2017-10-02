package com.app.projet.entities;

public enum Art {
	MUSIQUE("cours d'instrument de musique"),
	DANSE("cours de danse"),
	PEINTURE("cours de peinture "),
	SCULPTURE("cours de sculpture"),
	BREAKDANCE("cours de break-dance"),
	DESSIN("cours de dessin");
	
	private final String label;

	private Art(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
