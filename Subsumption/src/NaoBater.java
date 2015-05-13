import lejos.nxt.Motor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class NaoBater implements Behavior {

	UltrasonicSensor sensor;
	public NaoBater(UltrasonicSensor sensor){
		this.sensor = sensor;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub	
		if (sensor.getDistance() <= 10)
			return  true;
		else
			return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Motor.B.rotate(-180);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
