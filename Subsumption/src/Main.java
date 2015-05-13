import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S2);	
			
		Button.ENTER.waitForPress();		
		
//		Behavior andar = new AndarFrente();
//		Behavior desviar = new NaoBater(sensor);
		Behavior visao = new Visao(sensor);
		
		Behavior[] comportamentos = {visao};
		
		Arbitrator arb = new Arbitrator(comportamentos);
		arb.start();
		

	}
	
	

}
