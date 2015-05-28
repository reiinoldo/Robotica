import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UltrasonicSensor sensor = new UltrasonicSensor(SensorPort.S2);
		ColorSensor cor = new ColorSensor(SensorPort.S1);
//			
//		Button.ENTER.waitForPress();
//		System.out.println("red " + cor.getLightValue());
//		Button.ENTER.waitForPress();
//		System.out.println("green " + cor.getLightValue());
//		Button.ENTER.waitForPress();
//		System.out.println("whatever "+ cor.getLightValue());
				
		Button.ENTER.waitForPress();
		No raiz = new No(); 
				
		Behavior objetivo = new Objetivo(cor, raiz);
		Behavior visao = new Visao(sensor, cor, raiz);
		
		Behavior[] comportamentos = {visao, objetivo};
		
		Arbitrator arb = new Arbitrator(comportamentos);
		arb.start();
		

	}
	
	

}
