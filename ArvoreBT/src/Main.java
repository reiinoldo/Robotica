
public class Main {
	public static void main(String[] args){
		No raiz = new No();
		No noAtual = raiz;
		No antecessor;
		
		//Mapeando Cenario
		noAtual.setFrente(new No());
		antecessor = noAtual;
		noAtual = noAtual.getFrente();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		
		noAtual.setFrente(new No());
		antecessor = noAtual;
		noAtual = noAtual.getFrente();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		
		noAtual.setEsquerda(new No());
		antecessor = noAtual;
		noAtual = noAtual.getEsquerda();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("esquerda");
		
		noAtual.setFrente(new No());
		noAtual.setEsquerda(new No());
		antecessor = noAtual;
		noAtual.setVisitado(true);
		noAtual = noAtual.getFrente();
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		
		noAtual.setVisitado(true);
		noAtual = encontraOutroCaminho(noAtual);
		
		noAtual.setFrente(new No());
		antecessor = noAtual;
		noAtual = noAtual.getFrente();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		
		noAtual.setFrente(new No());
		noAtual.setDireita(new No());
		antecessor = noAtual;
		noAtual = noAtual.getFrente();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		
		noAtual.setVisitado(true);
		noAtual = encontraOutroCaminho(noAtual);
		
		noAtual.setEsquerda(new No());
		noAtual.setDireita(new No());
		antecessor = noAtual;
		noAtual = noAtual.getDireita();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("direita");
		
		noAtual = encontraOutroCaminho(noAtual);
		
		noAtual.setDireita(new No());
		antecessor = noAtual;
		noAtual = noAtual.getDireita();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("direita");
		
		noAtual.setDireita(new No());
		antecessor = noAtual;
		noAtual = noAtual.getDireita();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("direita");
		
		noAtual.setFrente(new No());
		antecessor = noAtual;
		noAtual = noAtual.getFrente();
		noAtual.setVisitado(true);
		noAtual.setAntecessor(antecessor);
		System.out.println("frente");
		noAtual.setObjetivo(true);
		buscaLargura(raiz, 1);
		menorCaminho(raiz);
	}
	
	public static No encontraOutroCaminho(No noAtual){
		No antecessor = noAtual.getAntecessor();
		System.out.println("tras");
		if(antecessor.getDireita() != null && antecessor.getDireita().isVisitado() == false){
			System.out.println("direita");
			antecessor.getDireita().setVisitado(true);
			return antecessor.getDireita();
		}
		if(antecessor.getEsquerda() != null && antecessor.getEsquerda().isVisitado() == false){
			System.out.println("esquerda");
			antecessor.getEsquerda().setVisitado(true);
			return antecessor.getEsquerda();
		}
		return encontraOutroCaminho(antecessor);
	}
	
	public static void buscaLargura(No no, int valor){
		if(no == null)
			return;
		if(no.getFrente() != null){
			buscaLargura(no.getFrente(), valor + 1);
		}
		
		if(no.getDireita() != null){
			buscaLargura(no.getDireita(), valor + 1);
		}
		
		if(no.getEsquerda() != null){
			buscaLargura(no.getEsquerda(), valor + 1);
		}
		no.setPesoLargura(valor);
		
		System.out.println(no.getIdNo() + "  " + no.getPesoLargura());
	}
	
	//Variação de dijkstra
	public static void menorCaminho(No no){
		int esquerda = 999;
		int direita = 999;
		int frente = 999;
		if(no == null)
			return;
		if(no.isObjetivo() == true)
			return;
		
		if(no.getFrente() != null)
			frente = extraiMin(no.getFrente());
		if(no.getDireita() != null)
			direita = extraiMin(no.getDireita());
		if(no.getEsquerda() != null)
			esquerda = extraiMin(no.getEsquerda());		
		
		if(frente <= direita &&
		   frente <= esquerda){
			System.out.println("frente");
			menorCaminho(no.getFrente());
		} else if(direita <= frente &&
				  direita <= esquerda){
			System.out.println("direita");
			menorCaminho(no.getDireita());
		} else if(esquerda <= frente &&
				  esquerda <= direita){
			System.out.println("Esquerda");
			menorCaminho(no.getEsquerda());
		}
	}
	
	public static int extraiMin(No no){
		int esquerda = 99;
		int direita = 99;
		int frente = 99;
		
		if(no.getFrente() != null)
			frente = no.getFrente().getPesoLargura();
		if(no.getDireita() != null)
			direita = no.getDireita().getPesoLargura();
		if(no.getEsquerda() != null)
			esquerda = no.getEsquerda().getPesoLargura();
		
		if(frente <= direita &&
		   frente <= esquerda){
		   return no.getPesoLargura() + frente;		   
		} else if(direita <= frente &&
		          direita <= esquerda){
		  return no.getPesoLargura() + direita;
		} else if(esquerda <= frente &&
		          esquerda <= direita){
		  return no.getPesoLargura() + esquerda;
		}
		return no.getPesoLargura() + 150;		
	}
}
