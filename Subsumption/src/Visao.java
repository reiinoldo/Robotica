import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class Visao implements Behavior {
	
	
	static final int DIREITA = 1;
	static final int ESQUERDA = 2;
	static final int FRENTE = 3;
	
	UltrasonicSensor sensor;
	public Visao(UltrasonicSensor sensor){
		this.sensor = sensor;
	}
	
	public int retornaDirecao(){
		int retorno = 0;
			
		if (sensor.getDistance() > 30 && retorno == 0)
			retorno = FRENTE;
		
		// direita
		Motor.C.rotate(90);		
		if (sensor.getDistance() > 30 && retorno == 0)
			retorno = DIREITA;
		
		// esquerda				
		Motor.C.rotate(-180);
		if (sensor.getDistance() > 30 && retorno == 0)
			retorno = ESQUERDA;
		
		// fazer backtrack
		
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
		switch (retornaDirecao()) {
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
		default:
			break;
		}	
				
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
