import java.util.ArrayList;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;


public class Objetivo implements Behavior {

	private No raiz;
	private ColorSensor cor;
	
	public Objetivo(ColorSensor cor, No raiz){
		this.cor = cor;
		this.raiz = raiz;
	}
	
	@Override
	public boolean takeControl() {
		
		if(cor.getLightValue() > 8) // verde
			return false;
		
		return true;
	}

	@Override
	public void action() {
		
		Button.ENTER.waitForPress();
		
		utils.buscaLargura(raiz, 1);
		
		utils.menorCaminho(raiz);
		ArrayList<Integer> retCaminhoMenor = utils.caminhoMenor;
		
		for (Integer direcao : retCaminhoMenor) {
			switch(direcao){
			case utils.FRENTE:
				Motor.A.rotate(utils.distanciaAndar - 10, true);
				Motor.B.rotate(utils.distanciaAndar);
									
				break;

			case utils.DIREITA:
				Motor.A.rotate(210, true);
				Motor.B.rotate(-210);
				
				Motor.A.rotate(utils.distanciaAndar -10, true);
				Motor.B.rotate(utils.distanciaAndar);
				break;
			case utils.ESQUERDA:
				Motor.A.rotate(-210, true);
				Motor.B.rotate(210);

				Motor.A.rotate(utils.distanciaAndar -10, true);
				Motor.B.rotate(utils.distanciaAndar);
				break;
				//BackTracking
			case 0:

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
		
		Button.ENTER.waitForPress();

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
