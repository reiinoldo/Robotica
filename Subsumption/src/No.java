
public class No {
	private static int idClasseNo;
	private int idNo;
	private No frente;
	private No direita;
	private No esquerda;
	private No antecessor;
	private boolean visitado;
	private boolean objetivo;
	private int pesoLargura;
	
	public No(){
		idClasseNo++;
		idNo = idClasseNo;
	}
	
	public No getFrente() {
		return frente;
	}
	
	public void setFrente(No frente) {
		this.frente = frente;
	}
	
	public No getDireita() {
		return direita;
	}
	
	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	public No getEsquerda() {
		return esquerda;
	}
	
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(No antecessor) {
		this.antecessor = antecessor;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public boolean isObjetivo() {
		return objetivo;
	}

	public void setObjetivo(boolean objetivo) {
		this.objetivo = objetivo;
	}

	public int getPesoLargura() {
		return pesoLargura;
	}

	public void setPesoLargura(int pesoLargura) {
		this.pesoLargura = pesoLargura;
	}
}
