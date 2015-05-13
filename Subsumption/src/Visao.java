import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class Visao implements Behavior {
		
	public static final int DIREITA = 1;
	public static final int ESQUERDA = 2;
	public static final int FRENTE = 3;
	
	private No raiz;
	private No noAtual;
	
	UltrasonicSensor sensor;
	public Visao(UltrasonicSensor sensor){
		this.sensor = sensor;
		this.raiz = new No();
		noAtual = raiz;
	}
	
	public int retornaDirecao(No no){
		int retorno = 0;
			
		if (sensor.getDistance() > 30 /*&& retorno == 0*/){
			retorno = FRENTE;
			if(no != null){
				no.setFrente(new No());
			}
		}
					
		// direita
		Motor.C.rotate(90);		
		if (sensor.getDistance() > 30 /*&& retorno == 0*/){
			retorno = DIREITA;
			
			if(no != null){
				no.setDireita(new No());
			}
		}
		
		// esquerda				
		Motor.C.rotate(-180);
		if (sensor.getDistance() > 30 /*&& retorno == 0*/){
			retorno = ESQUERDA;
			
			if(no != null){
				no.setEsquerda(new No());
			}
		}			
		
		// frente
		Motor.C.rotate(90);	
		return retorno;
		
	}

	@Override
	public boolean takeControl() {		
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		switch (retornaDirecao(noAtual)) {
		case FRENTE:
			Motor.A.rotate(500, true);
			Motor.B.rotate(500);
			break;

		case DIREITA:
			Motor.A.rotate(210, true);
			Motor.B.rotate(-210);
			
			break;
		case ESQUERDA:
			Motor.A.rotate(-210, true);
			Motor.B.rotate(210);
			break;
			//BackTracking
		case 0:
			break;
		default:
			break;
		}	
				
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
