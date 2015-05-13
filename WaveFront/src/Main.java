import java.util.ArrayList;
import java.util.Stack;
<<<<<<< HEAD

import lejos.nxt.Button;
import lejos.nxt.Motor;
=======
>>>>>>> origin/master


public class Main {

	private static int LINHA = 7;
	private static int COLUNA = 6;
	private static final int ROBO = 99;
	private static final int ORIGEM = 2;
	private static final int OBSTACULO = -1;
<<<<<<< HEAD
	private static final int DIREITA = 0;
	private static final int ABAIXO = 1;
	private static final int ESQUERDA = 2;
	private static final int ACIMA = 3;
	private static int direcaoAtual = 0;	
=======
	private static final int INI = 2;
	private static final int FIM = 3;
	private static final int CENTRO = 1;
	private static final int BRANCO = 0;
	private static final int CINZA = 1;
	private static final int PRETO = 2;
>>>>>>> origin/master
	
	private static final int INI = 2;
	private static final int FIM = 3;
	private static final int CENTRO = 1;
	private static final int BRANCO = 0;
	private static final int CINZA = 1;
	private static final int PRETO = 2;
	
	//cenarioATrapezoide();
	//cenarioBTrapezoide();
			
	private static ArrayList<int[]> trapezoides = new ArrayList<int[]>();
	private static ArrayList<int[]> pontosMedios = new ArrayList<int[]>();
	private static ArrayList<int[]> vertices = new ArrayList<int[]>();
<<<<<<< HEAD
	
	private static int[][] matriz = new int[LINHA][COLUNA];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		limparMatriz();
		direcaoAtual = DIREITA;
		System.out.println("Iniciar Wave Front A");
		Button.ENTER.waitForPress();		
		cenarioA();
		
		limparMatriz();
		direcaoAtual = DIREITA;		
		System.out.println("Iniciar Trapezoide B");
		Button.ENTER.waitForPress();		
		cenarioBTrapezoide();

		limparMatriz();
		direcaoAtual = DIREITA;		
		System.out.println("Iniciar Trapezoide A");
		Button.ENTER.waitForPress();		
		cenarioATrapezoide();
		
		limparMatriz();
		direcaoAtual = DIREITA;		
		System.out.println("Iniciar Wave Front B");
		Button.ENTER.waitForPress();		
		cenarioB();				

	}
	
	public static void limparMatriz(){
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = 0;
			}
		}
=======
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cenario2(); +- 
		// cenarioA();
		//cenarioB();
		//cenarioATrapezoide();
		cenarioBTrapezoide();
>>>>>>> origin/master
	}
	
	public static void cenarioA(){
		// iniciar obstaculos | Linha X Coluna
		matriz[0][1] = OBSTACULO;
		matriz[1][3] = OBSTACULO;
		matriz[2][4] = OBSTACULO;
		matriz[3][2] = OBSTACULO;
		matriz[4][4] = OBSTACULO;
		matriz[5][0] = OBSTACULO;
		matriz[5][2] = OBSTACULO;
		matriz[6][3] = OBSTACULO;
		matriz[6][5] = OBSTACULO;
		
		// iniciar objetivo
		matriz[2][5] = ORIGEM;
		
		// iniciar robo
		matriz[6][0] = ROBO;	
//		showConsole();
		
		valoraQuadrante3(2, 5);
        valoraQuadrante4(2, 5);
		
        percorreCaminho(6,0);
//        showConsole();
	}
	
	public static void cenarioB(){
		// iniciar obstaculos | Linha X Coluna		
		matriz[1][2] = OBSTACULO;
		matriz[2][3] = OBSTACULO;
		matriz[3][1] = OBSTACULO;
		matriz[3][4] = OBSTACULO;
		matriz[4][2] = OBSTACULO;		
		matriz[5][4] = OBSTACULO;		
		matriz[6][3] = OBSTACULO;		
		
		// iniciar objetivo
		matriz[6][5] = ORIGEM;
		
		// iniciar robo
		matriz[3][0] = ROBO;		
		
        valoraQuadrante4(6, 5);
        percorreCaminho(3,0);	
        
	}
	
    public static void cenario2(){
        //Obstaculos
        matriz[1][3] = OBSTACULO;
        matriz[2][3] = OBSTACULO;
        matriz[3][3] = OBSTACULO;
        matriz[4][3] = OBSTACULO;
        matriz[5][3] = OBSTACULO;
        matriz[6][3] = OBSTACULO;
        //---------------
        
        //Objetivo
        matriz[3][5] = ORIGEM;
        //--------
        
        //Robo
        matriz[6][0] = ROBO;
        //---------------        
        valoraQuadrante3(3, 5);
        valoraQuadrante4(3, 5);
        
        showConsole();
        
            
    }	
    
    public static void showConsole(){
    	String temp = "        ";
        
        for (int j = 0; j < matriz[0].length; j++) {
        	temp +="   Coluna: " + j;
        }        
        System.out.println(temp);
        
        temp = "";
        for (int i = 0; i < matriz.length; i++) {
        	temp = "Linha " + i + ": ";
            for (int j = 0; j < matriz[0].length; j++) {
            	if (matriz[i][j] < 10 && matriz[i][j] > 0)
            		temp += "       " + matriz[i][j] + "    ";
            	else
            		temp += "      " + matriz[i][j] + "    ";
            }
            System.out.println(temp);
        }       
    }
    
    public static void showConsole2(int[][] matriz){
    	String temp = "        ";
        
        for (int j = 0; j < matriz[0].length; j++) {
        	temp +="   Coluna: " + j;
        }        
        System.out.println(temp);
        
        temp = "";
        for (int i = 0; i < matriz.length; i++) {
        	temp = "Linha " + i + ": ";
            for (int j = 0; j < matriz[0].length; j++) {
            	if (matriz[i][j] < 10 && matriz[i][j] > 0)
            		temp += "       " + matriz[i][j] + "    ";
            	else
            		temp += "      " + matriz[i][j] + "    ";
            }
            System.out.println(temp);
        }       
    }
    
    public static boolean posicaoRobo(int linha, int coluna){
    	return matriz[linha][coluna] == ROBO;
    }
    
    public static int getPosicaoEsquerda(int linha, int coluna){
    	try {
    		return matriz[linha][coluna -1];
		} catch (Exception e) {
			return -1;
		}    			
    }
    
    public static int getPosicaoDireita(int linha, int coluna){
    	try {
    		return matriz[linha][coluna +1];
		} catch (Exception e) {
			return -1;
		}    			
    }
    
    public static int getPosicaoAbaixo(int linha, int coluna){
    	try {
    		return matriz[linha + 1][coluna];
	    } catch (Exception e) {
			return -1;
		}
    }
    
    public static int getPosicaoAcima(int linha, int coluna){
    	try {
    		return matriz[linha - 1][coluna];
	    } catch (Exception e) {
			return -1;
		}
    }
    
    
    public static void setPosicaoEsquerda(int linha, int coluna){
    	matriz[linha][coluna -1] = matriz[linha][coluna] + 1;    			
    }
    
    public static void setPosicaoAbaixo(int linha, int coluna){
    	matriz[linha + 1][coluna] = matriz[linha][coluna] + 1;    	
    }
    
    public static void setPosicaoAcima(int linha, int coluna){
    	matriz[linha - 1][coluna] = matriz[linha][coluna] + 1;	    
    }
    
	public static void valoraQuadrante1(int linha, int coluna){
		int valor = 1;
		for (int i = coluna; i >= 0; i--) {
			for (int j = linha + 1; j < matriz.length; j++) {
				if(matriz[j][i] == 0){
					matriz[j][i] = valor;
				}
	                
				try{
					if(matriz[j][i + 1] == 0 || (matriz[j][i + 1] > valor + 1) )
						matriz[j][i + 1] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}
	                
				try{
					if(matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1))
						matriz[j + 1][i] = matriz[j][i] + 1;
				} catch(Exception ex){                  
				}
	                
				try{
					if(matriz[j][i - 1] == 0 || (matriz[j][i - 1] > valor + 1))
						matriz[j][i - 1] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}
	                
				try{
					if(matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1))
						matriz[j + 1][i] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}   
				valor++;
			}
		}
	}
	    
	public static void valoraQuadrante2(int linha, int coluna){
		int valor = 2;
		for (int i = coluna; i >= 0; i--) {
			for (int j = linha; j >= 0; j--) {
				if(matriz[j][i] == 0){
					matriz[j][i] = valor;
				}
	                
				try{
					if((matriz[j][i + 1] == 0 || (matriz[j][i + 1] > valor + 1)) && j < 2 )
						matriz[j][i + 1] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}
	                
				try{
					if((matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1)) && j < 2)
						matriz[j + 1][i] = matriz[j][i] + 1;
				} catch(Exception ex){                  
				}
	                
				try{
					if((matriz[j][i - 1] == 0 || (matriz[j][i - 1] > valor + 1)) && j < 2)
						matriz[j][i - 1] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}
	                
				try{
					if((matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1)) && j < 2)
						matriz[j + 1][i] = matriz[j][i] + 1;
				} catch(Exception ex){                    
				}   
				valor++;
			}
		}            
	}
	
	public static void valoraQuadrante3(int linha, int coluna){
		int valor = 3;
		
		for (int i = coluna; i >= 0; i--) {
			for (int j = linha + 1; j < matriz.length; j++) {
				if(matriz[j][i] == 0){
					matriz[j][i] = valor;
				}
		
	                
				// \/
				
					if((getPosicaoAbaixo(j, i) == 0 || (getPosicaoAbaixo(j, i) > valor + 1)) && !posicaoRobo(j + 1, i)){
						setPosicaoAbaixo(j, i);
		
					}	
				
	                
				// <<
				
					if((getPosicaoEsquerda(j, i) == 0 || (getPosicaoEsquerda(j, i) > valor + 1)) && !posicaoRobo(j, i - 1)){
						setPosicaoEsquerda(j, i);
		
					}
				
					valor++;
			}
		}
	}
	    
	public static void valoraQuadrante4(int linha, int coluna){
        int valor = 2;
        for (int i = coluna; i >= 0; i--) {
            for (int j = linha; j >= 0; j--) {
                if(matriz[j][i] == 0){
                    matriz[j][i] = valor;
                }
                
                // <<
                
                    if((getPosicaoEsquerda(j, i) == 0 || (getPosicaoEsquerda(j, i) > valor + 1))  && !posicaoRobo(j, i - 1))
                    	setPosicaoEsquerda(j, i);
                
                
                // /\
                
                    if((getPosicaoAcima(j, i) == 0 || (getPosicaoAcima(j, i) > valor + 1))  && !posicaoRobo(j - 1, i))
                    	setPosicaoAcima(j, i);
                   
                valor++;
            }
        }            
    }

	public static void percorreCaminho(int linha, int coluna){
		int posicao = 0;
		while (posicao != ORIGEM) {
						
			// >>
			if ( getPosicaoDireita(linha, coluna) != OBSTACULO &&
				 (getPosicaoDireita(linha, coluna) <= getPosicaoAbaixo(linha, coluna) || getPosicaoAbaixo(linha, coluna) == -1) &&
				 (getPosicaoDireita(linha, coluna) <= getPosicaoEsquerda(linha, coluna) || getPosicaoEsquerda(linha, coluna) == -1) &&
				 (getPosicaoDireita(linha, coluna) <= getPosicaoAcima(linha, coluna) || getPosicaoAcima(linha, coluna) == -1) ) 
			{
				posicao = getPosicaoDireita(linha, coluna);
				coluna ++;
				// move robo para direita
				System.out.println("Direita");
				moverRobo(DIREITA);
			} 
			// \/
			else if ( getPosicaoAbaixo(linha, coluna) != OBSTACULO &&
					  (getPosicaoAbaixo(linha, coluna) <= getPosicaoEsquerda(linha, coluna)  || getPosicaoEsquerda(linha, coluna) == -1) &&
					  (getPosicaoAbaixo(linha, coluna) <= getPosicaoAcima(linha, coluna)  || getPosicaoAcima(linha, coluna) == -1) )				
			{
				posicao = getPosicaoAbaixo(linha, coluna);
				linha ++;
				// move robo para abaixo
				System.out.println("Abaixo");
				moverRobo(ABAIXO);
			}
			// <<			
			else if ( getPosicaoEsquerda(linha, coluna) != OBSTACULO &&
					  (getPosicaoEsquerda(linha, coluna) <= getPosicaoAcima(linha, coluna)  || getPosicaoAcima(linha, coluna) == -1))				
			{
				posicao = getPosicaoEsquerda(linha, coluna);
				coluna --;
				// move robo para esquerda
				System.out.println("Esquerda");
				moverRobo(ESQUERDA);
			}
			// /\			
			else if ( getPosicaoAcima(linha, coluna) != OBSTACULO )
			{
				posicao = getPosicaoAcima(linha, coluna);
				linha --;
				// move robo para acima
				System.out.println("Acima");
				moverRobo(ACIMA);
			}				
				
				
		}
		
	}
	
<<<<<<< HEAD
	public static void moverRobo(int direcao){
		
		
		switch (direcao) {
		case DIREITA:			
			
			if(direcaoAtual == ACIMA){
				
				Motor.A.rotate( 268, true);
				Motor.B.rotate(-268);
				
			}else if (direcaoAtual == ABAIXO){
				
				Motor.A.rotate(-268, true);
				Motor.B.rotate( 268);
			}			
			break;

		case ABAIXO:
			
			if(direcaoAtual == DIREITA){
				
				Motor.A.rotate( 268, true);
				Motor.B.rotate(-268 );
			}
			break;
		
		case ACIMA:
			
			if(direcaoAtual == DIREITA){
				
				
				Motor.A.rotate(-268, true);
				Motor.B.rotate( 268);
				
			}
			break;
			
		default:
			break;
		}
		
		// Andar
		Motor.A.rotate(-580, true);		
		Motor.B.rotate(-580);	
		direcaoAtual = direcao;
		
	}

	
	// ----------------------------- Trapezoiede ------------------------------
=======
>>>>>>> origin/master
	public static void cenarioATrapezoide(){		
		int[] trapezoide;
		int ponto;
		
		// iniciar obstaculos | Linha X Coluna
		matriz[0][1] = OBSTACULO;
		matriz[1][3] = OBSTACULO;
		matriz[2][4] = OBSTACULO;
		matriz[3][2] = OBSTACULO;
		matriz[4][4] = OBSTACULO;
		matriz[5][0] = OBSTACULO;
		matriz[5][2] = OBSTACULO;
		matriz[6][3] = OBSTACULO;
		matriz[6][5] = OBSTACULO;
		
		// iniciar objetivo
		matriz[2][5] = ORIGEM;
		
		// iniciar robo
		matriz[6][0] = ROBO;	
		
		//Identificar os trapezoides
		for (int i = 0; i < matriz[0].length; i++) { //coluna
			ponto = 0;
			for (int j = 0; j < matriz.length; j++) { //linha
				
				if(matriz[j][i] == -1 || (j == matriz.length - 1 && matriz[j][i] != -1)){
					trapezoide = new int[4];
					trapezoide[0] = i;                    //Coluna do trapezoide
					trapezoide[CENTRO] = (j + ponto) / 2; //Centro do trapezoide
					trapezoide[INI] = ponto;              //Inicio do trapezoide
					trapezoide[FIM] = j;                  //Fim do trapezoide
					ponto = j + 1;
					
					//Quando o centro do trapezoide nao for -1, ele é valido
					if(matriz[trapezoide[1]][trapezoide[0]] != -1){
						trapezoides.add(trapezoide);
					}
					
				}
			}
		}
		
		//showConsole();
		int[] pontoMedio;
<<<<<<< HEAD
		
		for (int[] centro : trapezoides) {						
			for (int[] centroProxColuna : trapezoides) {
				//Proxima coluna, com a qual devem ser encontrados os vertices
				if(centroProxColuna[0] == centro[0] + 1){
					int iniInterseccao = centro[INI];
					if(centroProxColuna[INI] > iniInterseccao){
						iniInterseccao = centroProxColuna[INI];
					}
					
					int fimInterseccao = centro[FIM];
					if(centroProxColuna[FIM] < fimInterseccao){
						fimInterseccao = centroProxColuna[FIM];
					}
					
					pontoMedio = new int[2];
					pontoMedio[0] = centroProxColuna[0];
					pontoMedio[1] = (iniInterseccao + fimInterseccao) / 2; //Ponto medio entre os 2 trapezoides
					
					//Quando o ponto médio nao for -1 ele é valido
					if(matriz[pontoMedio[1]][pontoMedio[0]] != -1)
						pontosMedios.add(pontoMedio);					
				}
			}
		}
		
		buscaEmLargura(6, 0, 2, 5);
		
	}
	
	public static void buscaEmLargura(int linhaRobo, int colunaRobo, int linhaObjetivo, int colunaObjetivo){
		Stack<int[]> pilha = new Stack<int[]>();
		
		int[] robo = new int[3];
		robo[0] = colunaRobo;
		robo[1] = linhaRobo;
		robo[2] = CINZA;
		
		pilha.addElement(robo);
		int[][] grafoCaminho = new int[LINHA][COLUNA];		
		
		for (int i = 0; i < grafoCaminho.length; i++) {
			for (int j = 0; j < grafoCaminho[0].length; j++) {
				grafoCaminho[i][j] = -1;
			}
		}
		grafoCaminho[linhaRobo][colunaRobo] = 0;
		
		int distancia = 1;
		
		//Inicializando vertices
		for (int[] listVertice : pontosMedios) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false && pontoSemEntrada(vertice[1], vertice[0]) == false){
				vertices.add(vertice);
			}				
		}
		
		//Inicializando vertices
		for (int[] listVertice : trapezoides) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false && pontoSemEntrada(vertice[1], vertice[0]) == false){
				vertices.add(vertice);
			}	
		}		
		
		while(pilha.size() > 0){
			int[] vertice = (int[]) pilha.pop();
			for (int[] vAdj : vertices) {
				//Se os vertices forem adjacentes
				if(vAdj[0] == vertice[0] + 1 && vAdj[2] == BRANCO){
					pilha.push(vAdj);
					grafoCaminho[vAdj[1]][vAdj[0]] = distancia;
					vAdj[2] = CINZA;
				}
			}
			vertice[2] = PRETO;
			distancia ++;
		}		
		
		//Inicializando Dijkstra
		int[][] matrizDijkstra = new int[LINHA][COLUNA];
		int[][] menorCaminho = new int[LINHA][2];
		
		for (int i = 0; i < matrizDijkstra.length; i++) {
			for (int j = 0; j < matrizDijkstra[0].length; j++) {
				matrizDijkstra[i][j] =  Integer.MAX_VALUE;
			}
		}
		
		matrizDijkstra[linhaRobo][colunaRobo] = 0;
		int[] vertice;
		int menorValor;
			
		//Extraindo menor vertice
		for (int i = 0; i < matrizDijkstra[0].length; i++) {
			
			vertice = new int[2];
			menorValor = Integer.MAX_VALUE;
			
			for (int j = 0; j < matrizDijkstra.length; j++) {
				if(matrizDijkstra[j][i] < menorValor){
					menorValor = matrizDijkstra[j][i];
					vertice[0] = i;
					vertice[1] = j;
				}
			}
			
			//Vertice Pai daquela coluna
			menorCaminho[i][0] = vertice[1];
			menorCaminho[i][1] = vertice[0];			
				
			for (int[] vAdj : vertices) {
				//Se os vertices forem adjacentes
				if(vAdj[0] == vertice[0] + 1){
					//RELAX
					if(matrizDijkstra[vAdj[1]][vAdj[0]] > menorValor + 1 + (Math.abs(vertice[1] - vAdj[1]) * 2) + Math.abs(linhaObjetivo - vAdj[1])){						
						matrizDijkstra[vAdj[1]][vAdj[0]] = menorValor + 1 + (Math.abs(vertice[1] - vAdj[1]) * 2) + Math.abs(linhaObjetivo - vAdj[1]);
					}
				}
			}
		}
		
		menorCaminho[6][0] = linhaObjetivo;
		menorCaminho[6][1] = colunaObjetivo;
//		showConsole2(menorCaminho);
		
		percorreCaminhoTrapezoide(menorCaminho);

	}
	
	private static boolean pontoSemSaida(int linha, int coluna){
		try{
			//para cima
			if(matriz[linha - 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para frente
			if(matriz[linha][coluna + 1] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para para baixo
			if(matriz[linha + 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		return true;
	}
	
	private static boolean pontoSemEntrada(int linha, int coluna){
		try{
			//para cima
			if(matriz[linha - 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para frente
			if(matriz[linha][coluna - 1] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para para baixo
			if(matriz[linha + 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		return true;
	}
	
	public static void percorreCaminhoTrapezoide(int[][] caminho){
		int vertical = 0;
		int horizontal = 0;
		
=======
		
		for (int[] centro : trapezoides) {						
			for (int[] centroProxColuna : trapezoides) {
				//Proxima coluna, com a qual devem ser encontrados os vertices
				if(centroProxColuna[0] == centro[0] + 1){
					int iniInterseccao = centro[INI];
					if(centroProxColuna[INI] > iniInterseccao){
						iniInterseccao = centroProxColuna[INI];
					}
					
					int fimInterseccao = centro[FIM];
					if(centroProxColuna[FIM] < fimInterseccao){
						fimInterseccao = centroProxColuna[FIM];
					}
					
					pontoMedio = new int[2];
					pontoMedio[0] = centroProxColuna[0];
					pontoMedio[1] = (iniInterseccao + fimInterseccao) / 2; //Ponto medio entre os 2 trapezoides
					
					//Quando o ponto médio nao for -1 ele é valido
					if(matriz[pontoMedio[1]][pontoMedio[0]] != -1)
						pontosMedios.add(pontoMedio);					
				}
			}
		}
		
		buscaEmLargura(6, 0, 2, 5);
		
	}
	
	public static void buscaEmLargura(int linhaRobo, int colunaRobo, int linhaObjetivo, int colunaObjetivo){
		Stack<int[]> pilha = new Stack<int[]>();
		
		int[] robo = new int[3];
		robo[0] = colunaRobo;
		robo[1] = linhaRobo;
		robo[2] = CINZA;
		
		pilha.addElement(robo);
		int[][] grafoCaminho = new int[LINHA][COLUNA];		
		
		for (int i = 0; i < grafoCaminho.length; i++) {
			for (int j = 0; j < grafoCaminho[0].length; j++) {
				grafoCaminho[i][j] = -1;
			}
		}
		grafoCaminho[linhaRobo][colunaRobo] = 0;
		
		int distancia = 1;
		
		//Inicializando vertices
		for (int[] listVertice : pontosMedios) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false && pontoSemEntrada(vertice[1], vertice[0]) == false){
				vertices.add(vertice);
			}				
		}
		
		//Inicializando vertices
		for (int[] listVertice : trapezoides) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false && pontoSemEntrada(vertice[1], vertice[0]) == false){
				vertices.add(vertice);
			}	
		}		
		
		while(pilha.size() > 0){
			int[] vertice = (int[]) pilha.pop();
			for (int[] vAdj : vertices) {
				//Se os vertices forem adjacentes
				if(vAdj[0] == vertice[0] + 1 && vAdj[2] == BRANCO){
					pilha.push(vAdj);
					grafoCaminho[vAdj[1]][vAdj[0]] = distancia;
					vAdj[2] = CINZA;
				}
			}
			vertice[2] = PRETO;
			distancia ++;
		}		
		
		//Inicializando Dijkstra
		int[][] matrizDijkstra = new int[LINHA][COLUNA];
		int[][] menorCaminho = new int[LINHA][2];
		
		for (int i = 0; i < matrizDijkstra.length; i++) {
			for (int j = 0; j < matrizDijkstra[0].length; j++) {
				matrizDijkstra[i][j] =  Integer.MAX_VALUE;
			}
		}
		
		matrizDijkstra[linhaRobo][colunaRobo] = 0;
		int[] vertice;
		int menorValor;
			
		//Extraindo menor vertice
		for (int i = 0; i < matrizDijkstra[0].length; i++) {
			
			vertice = new int[2];
			menorValor = Integer.MAX_VALUE;
			
			for (int j = 0; j < matrizDijkstra.length; j++) {
				if(matrizDijkstra[j][i] < menorValor){
					menorValor = matrizDijkstra[j][i];
					vertice[0] = i;
					vertice[1] = j;
				}
			}
			
			//Vertice Pai daquela coluna
			menorCaminho[i][0] = vertice[1];
			menorCaminho[i][1] = vertice[0];			
				
			for (int[] vAdj : vertices) {
				//Se os vertices forem adjacentes
				if(vAdj[0] == vertice[0] + 1){
					//RELAX
					if(matrizDijkstra[vAdj[1]][vAdj[0]] > menorValor + 1 + (Math.abs(vertice[1] - vAdj[1]) * 2) + Math.abs(linhaObjetivo - vAdj[1])){						
						matrizDijkstra[vAdj[1]][vAdj[0]] = menorValor + 1 + (Math.abs(vertice[1] - vAdj[1]) * 2) + Math.abs(linhaObjetivo - vAdj[1]);
					}
				}
			}
		}
		
		menorCaminho[6][0] = linhaObjetivo;
		menorCaminho[6][1] = colunaObjetivo;
		showConsole2(menorCaminho);
		
		percorreCaminhoTrapezoide(menorCaminho);

	}
	
	private static boolean pontoSemSaida(int linha, int coluna){
		try{
			//para cima
			if(matriz[linha - 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para frente
			if(matriz[linha][coluna + 1] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para para baixo
			if(matriz[linha + 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		return true;
	}
	
	private static boolean pontoSemEntrada(int linha, int coluna){
		try{
			//para cima
			if(matriz[linha - 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para frente
			if(matriz[linha][coluna - 1] != -1)
				return false;
		} catch (Exception e) {
		}
		
		try{
			//para para baixo
			if(matriz[linha + 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		return true;
	}
	
	public static void percorreCaminhoTrapezoide(int[][] caminho){
		int vertical = 0;
		int horizontal = 0;
		
>>>>>>> origin/master
		for (int i = 1; i < caminho.length; i++) {

			vertical = caminho[i][0] - caminho[i -1][0];
			horizontal = caminho[i][1] - caminho[i -1][1];
			/*System.out.print("i: " + i);
			System.out.print("  Vert: " + vertical );
			System.out.println("  Hor: " + horizontal);*/
			
			
			if(frenteCima(horizontal, vertical, caminho[i -1][0], caminho[i -1][1], false)){
				frenteCima(horizontal, vertical, caminho[i -1][0], caminho[i -1][1], true);
			} else{
				cimaFrente(horizontal, vertical, caminho[i -1][0], caminho[i -1][1], true);
			}

		}
	}
	
	public static boolean frenteCima(int qtdFrente, int qtdCima, int linhaOrigem, int colOrigem, boolean impRota){
		for (int i = 1; i <= qtdFrente; i++) {
			if(matriz[linhaOrigem][colOrigem + i] == -1)
				return false;
			if(impRota){
				System.out.println("Frente");
<<<<<<< HEAD
				moverRobo(DIREITA);
=======
>>>>>>> origin/master
			}
		}
		colOrigem += qtdFrente;

		if(qtdCima > 0){
			for (int i = 1; i <= qtdCima; i++) {
				if(matriz[linhaOrigem + i][colOrigem] == -1)
					return false;
				if(impRota){
					System.out.println("Baixo");
<<<<<<< HEAD
					moverRobo(ABAIXO);
=======
>>>>>>> origin/master
				}
			}				
		} else{
			qtdCima = qtdCima * -1;
			for (int i = 1; i <= qtdCima; i++) {
				if(matriz[linhaOrigem - i][colOrigem] == -1)
					return false;
				if(impRota){
					System.out.println("Cima");
<<<<<<< HEAD
					moverRobo(ACIMA);
=======
>>>>>>> origin/master
				}				
			}
		}
		return true;
	}
	
	public static boolean cimaFrente(int qtdFrente, int qtdCima, int linhaOrigem, int colOrigem, boolean impRota){
		boolean cima = true;
		if(qtdCima < 0){
			qtdCima = qtdCima * -1;
			cima = false;
		}
		
		for (int i = 0; i < qtdCima; i++) {
			if(cima == true){
				if(matriz[linhaOrigem + i][colOrigem] == -1)
					return false;
				if(impRota){
					System.out.println("Baixo");
<<<<<<< HEAD
					moverRobo(ABAIXO);
=======
>>>>>>> origin/master
				}
			} else{
				if(matriz[linhaOrigem - i][colOrigem] == -1)
					return false;
				
				if(impRota){
					System.out.println("Cima");
<<<<<<< HEAD
					moverRobo(ACIMA);
=======
>>>>>>> origin/master
				}				
			}
		}
		
		for (int i = 1; i <= qtdFrente; i++) {
			if(impRota){
				System.out.println("Frente");
<<<<<<< HEAD
				moverRobo(DIREITA);
=======
>>>>>>> origin/master
			}
		}	
		
		return true;
<<<<<<< HEAD
	}
	
	public static void cenarioBTrapezoide(){		
		//Teste
		int[] trapezoide;
		int ponto;
		
		// iniciar obstaculos | Linha X Coluna		
		matriz[1][2] = OBSTACULO;
		matriz[2][3] = OBSTACULO;
		matriz[3][1] = OBSTACULO;
		matriz[3][4] = OBSTACULO;
		matriz[4][2] = OBSTACULO;		
		matriz[5][4] = OBSTACULO;		
		matriz[6][3] = OBSTACULO;		
		
		// iniciar objetivo
		matriz[6][5] = ORIGEM;
		
		// iniciar robo
		matriz[3][0] = ROBO;
		
		//Identificar os trapezoides
		for (int i = 0; i < matriz[0].length; i++) { //coluna
			ponto = 0;
			for (int j = 0; j < matriz.length; j++) { //linha
				
				if(matriz[j][i] == -1 || (j == matriz.length - 1 && matriz[j][i] != -1)){
					trapezoide = new int[4];
					trapezoide[0] = i;                    //Coluna do trapezoide
					trapezoide[CENTRO] = (j + ponto) / 2; //Centro do trapezoide
					trapezoide[INI] = ponto;              //Inicio do trapezoide
					trapezoide[FIM] = j;                  //Fim do trapezoide
					ponto = j + 1;
					
					//Quando o centro do trapezoide nao for -1, ele é valido
					if(matriz[trapezoide[1]][trapezoide[0]] != -1){
						trapezoides.add(trapezoide);
					}
					
				}
			}
		}
		
		//showConsole();
		int[] pontoMedio;
		
		for (int[] centro : trapezoides) {						
			for (int[] centroProxColuna : trapezoides) {
				//Proxima coluna, com a qual devem ser encontrados os vertices
				if(centroProxColuna[0] == centro[0] + 1){
					int iniInterseccao = centro[INI];
					if(centroProxColuna[INI] > iniInterseccao){
						iniInterseccao = centroProxColuna[INI];
					}
					
					int fimInterseccao = centro[FIM];
					if(centroProxColuna[FIM] < fimInterseccao){
						fimInterseccao = centroProxColuna[FIM];
					}
					
					pontoMedio = new int[2];
					pontoMedio[0] = centroProxColuna[0];
					pontoMedio[1] = (iniInterseccao + fimInterseccao) / 2; //Ponto medio entre os 2 trapezoides
					
					//Quando o ponto médio nao for -1 ele é valido
					if(matriz[pontoMedio[1]][pontoMedio[0]] != -1)
						pontosMedios.add(pontoMedio);					
				}
			}
		}
		
		buscaEmLargura(3, 0, 6, 5);
		
=======
>>>>>>> origin/master
	}
	
	public static void cenarioBTrapezoide(){		
		//Teste
		int[] trapezoide;
		int ponto;
		
		// iniciar obstaculos | Linha X Coluna		
		matriz[1][2] = OBSTACULO;
		matriz[2][3] = OBSTACULO;
		matriz[3][1] = OBSTACULO;
		matriz[3][4] = OBSTACULO;
		matriz[4][2] = OBSTACULO;		
		matriz[5][4] = OBSTACULO;		
		matriz[6][3] = OBSTACULO;		
		
		// iniciar objetivo
		matriz[6][5] = ORIGEM;
		
		// iniciar robo
		matriz[3][0] = ROBO;
		
		//Identificar os trapezoides
		for (int i = 0; i < matriz[0].length; i++) { //coluna
			ponto = 0;
			for (int j = 0; j < matriz.length; j++) { //linha
				
				if(matriz[j][i] == -1 || (j == matriz.length - 1 && matriz[j][i] != -1)){
					trapezoide = new int[4];
					trapezoide[0] = i;                    //Coluna do trapezoide
					trapezoide[CENTRO] = (j + ponto) / 2; //Centro do trapezoide
					trapezoide[INI] = ponto;              //Inicio do trapezoide
					trapezoide[FIM] = j;                  //Fim do trapezoide
					ponto = j + 1;
					
					//Quando o centro do trapezoide nao for -1, ele é valido
					if(matriz[trapezoide[1]][trapezoide[0]] != -1){
						trapezoides.add(trapezoide);
					}
					
				}
			}
		}
		
		//showConsole();
		int[] pontoMedio;
		
		for (int[] centro : trapezoides) {						
			for (int[] centroProxColuna : trapezoides) {
				//Proxima coluna, com a qual devem ser encontrados os vertices
				if(centroProxColuna[0] == centro[0] + 1){
					int iniInterseccao = centro[INI];
					if(centroProxColuna[INI] > iniInterseccao){
						iniInterseccao = centroProxColuna[INI];
					}
					
					int fimInterseccao = centro[FIM];
					if(centroProxColuna[FIM] < fimInterseccao){
						fimInterseccao = centroProxColuna[FIM];
					}
					
					pontoMedio = new int[2];
					pontoMedio[0] = centroProxColuna[0];
					pontoMedio[1] = (iniInterseccao + fimInterseccao) / 2; //Ponto medio entre os 2 trapezoides
					
					//Quando o ponto médio nao for -1 ele é valido
					if(matriz[pontoMedio[1]][pontoMedio[0]] != -1)
						pontosMedios.add(pontoMedio);					
				}
			}
		}
		
		buscaEmLargura(3, 0, 6, 5);
		
	}	
	
}



