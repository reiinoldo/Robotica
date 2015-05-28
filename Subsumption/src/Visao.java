import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class Visao implements Behavior {
	
	private No raiz;
	private No noAtual;
	private No noAntecessor;
	private ColorSensor cor;
	
	UltrasonicSensor sensor;
	public Visao(UltrasonicSensor sensor, ColorSensor cor, No raiz){
		this.sensor = sensor;
		this.raiz = raiz;
		noAtual = raiz;
		this.cor = cor;
	}
	
	public int retornaDirecao(){
		int retorno = 0;
		int distancia = sensor.getDistance();
		System.out.println("dist " + distancia);	
		if (distancia > 23 /*&& retorno == 0*/){			
			if(retorno == 0){
				retorno = utils.FRENTE;
			}
			noAtual.setFrente(new No());
			noAtual.getFrente().setAntecessor(noAtual);
			
		}
					
		// direita
		Motor.C.rotate(90);
		distancia = sensor.getDistance();
		System.out.println("dist " + distancia);
		if (distancia > 23 /*&& retorno == 0*/){
						
			if(retorno == 0){
				retorno = utils.DIREITA;
			}
			noAtual.setDireita(new No());
			noAtual.getDireita().setAntecessor(noAtual);
			
		}
		
		// esquerda				
		Motor.C.rotate(-180);
		distancia = sensor.getDistance();
		System.out.println("dist " + distancia);
		if (distancia > 23 /*&& retorno == 0*/){
			
			
			if(retorno == 0){
				retorno = utils.ESQUERDA;
			}
			noAtual.setEsquerda(new No());
			noAtual.getEsquerda().setAntecessor(noAtual);
			
		}			
		
		noAtual.setVisitado(true);
		
		// frente
		Motor.C.rotate(90);		
		
		System.out.println("ret " + retorno);
		
//		Button.ENTER.waitForPress();
		return retorno;
		
	}

	@Override
	public boolean takeControl() {
		
		if(cor.getLightValue() <= 8){ // verde
			return false;
		}
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		switch (retornaDirecao()) {
		case utils.FRENTE:
			Motor.A.rotate(utils.distanciaAndar -10, true);
			Motor.B.rotate(utils.distanciaAndar);
			noAtual = noAtual.getFrente();					
			break;

		case utils.DIREITA:
			Motor.A.rotate(210, true);
			Motor.B.rotate(-210);
			noAtual = noAtual.getDireita();
			Motor.A.rotate(utils.distanciaAndar -10, true);
			Motor.B.rotate(utils.distanciaAndar);
			break;
		case utils.ESQUERDA:
			Motor.A.rotate(-210, true);
			Motor.B.rotate(210);
			noAtual = noAtual.getEsquerda();
			Motor.A.rotate(utils.distanciaAndar -10, true);
			Motor.B.rotate(utils.distanciaAndar);
			break;
			//BackTracking
		case 0:
			noAtual = utils.encontraOutroCaminho(noAtual);
			break;
		default:
			break;
		}	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
