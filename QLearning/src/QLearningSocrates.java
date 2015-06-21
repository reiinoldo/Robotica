
public class QLearningSocrates {
	
	private static final double GAMMA = 0.8;
	private static int[][] acoes = new int[4][4];
	private static int[][] q = new int[4][4];

	public static void main(String[] args) {
		
		acoes[0][0] = 0;
		acoes[0][1] = 0;
		acoes[0][2] = 0;
		acoes[0][3] = 1;
		
		acoes[1][0] = 0;
		acoes[1][1] = 0;
		acoes[1][2] = 0;
		acoes[1][3] = 2;
		
		acoes[2][0] = 0;
		acoes[2][1] = 0;
		acoes[2][2] = 0;
		acoes[2][3] = 3;
		
		acoes[3][0] = 0;
		acoes[3][1] = 0;
		acoes[3][2] = 0;
		acoes[3][3] = 4;
		
		//Executar uma acao e checar seu resultado
		for (int i = 0; i < acoes.length; i++) {
			for (int j = 0; j < acoes[0].length; j++) {
				q[i][j] = recompensa(i, j);
			}
		}
	}
	
	public static int recompensa(int i, int j){
		//fazer o rotate da acao solicitada e
		//devolver como recompensa o quanto o socrates andou
		//q[i][j] = qtdDeslocamento
		
		return (int)(q[i][j] + (GAMMA * maximo(i, j)));
	}
	
	public static int maximo(int estado, int acao){
		int retorno = 0;
		for (int i = acao + 1; i < q[0].length; i++) {
			if(retorno < q[estado][i])
				retorno += q[estado][i];
		}
		return retorno;
	}
	
	public static int encontraMelhorMov(){
		int maxRecompesa = 0;
		int recompesaMov;
		int mov = 0;
		for (int i = 0; i < q.length; i++) {
			recompesaMov = 0;
			for (int j = 0; j < q[0].length; j++) {
				recompesaMov += q[i][j];
			}
			if(recompesaMov > maxRecompesa){
				maxRecompesa = recompesaMov;
				mov = i;
			}
		}
		
		return mov;
	}
}
