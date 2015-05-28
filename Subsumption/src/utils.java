import java.util.ArrayList;

import lejos.nxt.Motor;


public class utils {
	
	public static final int distanciaAndar = 810;
	public static ArrayList<Integer> caminhoMenor = new ArrayList<Integer>();
	
	public static final int DIREITA = 1;
	public static final int ESQUERDA = 2;
	public static final int FRENTE = 3;

	public static No encontraOutroCaminho(No noAtual){
		No antecessor = noAtual.getAntecessor();
		System.out.println("tras");
		Motor.A.rotate(-distanciaAndar +10, true);
		Motor.B.rotate(-distanciaAndar);
		if(antecessor.getDireita() != null && antecessor.getDireita().isVisitado() == false){
			System.out.println("direita");
			Motor.A.rotate(210, true);
			Motor.B.rotate(-210);
			Motor.A.rotate(distanciaAndar -10, true);
			Motor.B.rotate(distanciaAndar);
			antecessor.getDireita().setVisitado(true);
			return antecessor.getDireita();
		}		
		if(antecessor.getEsquerda() != null && antecessor.getEsquerda().isVisitado() == false){
			if(antecessor.getDireita() != null && antecessor.getDireita().isVisitado() == true){
				Motor.A.rotate(-210, true);
				Motor.B.rotate(210);
			}
			System.out.println("esquerda");
			Motor.A.rotate(-210, true);
			Motor.B.rotate(210);
			Motor.A.rotate(distanciaAndar -10, true);
			Motor.B.rotate(distanciaAndar);
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
			caminhoMenor.add(FRENTE);
			menorCaminho(no.getFrente());
		} else if(direita <= frente &&
				  direita <= esquerda){
			System.out.println("direita");
			caminhoMenor.add(DIREITA);
			menorCaminho(no.getDireita());
		} else if(esquerda <= frente &&
				  esquerda <= direita){			
			System.out.println("Esquerda");
			caminhoMenor.add(ESQUERDA);
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
