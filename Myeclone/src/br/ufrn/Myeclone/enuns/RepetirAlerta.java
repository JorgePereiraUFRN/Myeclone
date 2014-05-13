package br.ufrn.Myeclone.enuns;

public enum RepetirAlerta {
	
	A_CADA_HORA("A cada hora"),
	DIARIAMENTE("Diariamente"),
	NAO_REPETIR("Não repetir");
	
	
	private final String label;
	
	private RepetirAlerta(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
