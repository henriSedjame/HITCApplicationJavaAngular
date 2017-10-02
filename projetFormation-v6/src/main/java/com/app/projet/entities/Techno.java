package com.app.projet.entities;

public enum Techno {
	ALGO("cours d'algorithme"),
	JAVA("cours de Java"),
	WEBSERVICES("cours de web service "),
	ARDUINO("cours d'Arduino"),
	PYTHON("cours de Python"),
	CSHARP("cours de C#");
	
	private final String label;

	private Techno(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
