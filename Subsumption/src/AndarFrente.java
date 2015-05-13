import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;


public class AndarFrente implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Motor.A.forward();
		Motor.B.forward();
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		Motor.A.flt();
		Motor.B.flt();

	}

}
