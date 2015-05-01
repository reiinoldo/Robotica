package leTest;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

public class Main {

		public static void main(String[] args) throws InterruptedException {
			
			Button.ENTER.waitForPress();
			naLinha();
			
		}
		
		public static void naLinha(){
			ColorSensor cor = new ColorSensor(SensorPort.S3);
			
			int corint;
			int speed = 800; //<850
			int rotate =-25; //<30
						
			Motor.A.setSpeed(speed);
			Motor.B.setSpeed(speed);		
			
			while (true) {								
				
				corint = cor.getLightValue();				
				
				if(corint < 100){
					Motor.B.rotate(rotate, true);
				}else{
					Motor.A.rotate(rotate, true);
				}
								
			}
			
		}
}
