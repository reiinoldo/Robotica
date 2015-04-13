import java.util.ArrayList;
import java.util.Stack;


public class Main {

	private static int LINHA = 7;
	private static int COLUNA = 6;
	private static final int ROBO = 99;
	private static final int ORIGEM = 2;
	private static final int OBSTACULO = -1;
	private static final int INI = 2;
	private static final int FIM = 3;
	private static final int CENTRO = 1;
	private static final int BRANCO = 0;
	private static final int CINZA = 1;
	private static final int PRETO = 2;
	
	private static int[][] matriz = new int[LINHA][COLUNA];
	
	private static ArrayList<int[]> trapezoides = new ArrayList<int[]>();
	private static ArrayList<int[]> pontosMedios = new ArrayList<int[]>();
	private static ArrayList<int[]> vertices = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cenario2(); +- 
		// cenarioA();
		//cenarioB();
		cenarioATrapezoide();
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
		showConsole();
		
		valoraQuadrante3(2, 5);
        valoraQuadrante4(2, 5);
		
        showConsole();
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
		
		showConsole();
		
        valoraQuadrante4(6, 5);
		
        showConsole();
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
        
        
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.print("Linha: " + i);
//                System.out.print("   Coluna: " + j);
//                System.out.println("  Matriz: " + matriz[i][j]);
//            }
//        }        
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
		boolean ok;
		for (int i = coluna; i >= 0; i--) {
			for (int j = linha + 1; j < matriz.length; j++) {
				if(matriz[j][i] == 0){
					matriz[j][i] = valor;
				}
				ok = false;
	                
//				// >> 
//				try{
//					if(matriz[j][i + 1] == 0 || (matriz[j][i + 1] > valor + 1) )
//						matriz[j][i + 1] = matriz[j][i] + 1;
//				} catch(Exception ex){                    
//				}
	                
				// \/
				
					if((getPosicaoAbaixo(j, i) == 0 || (getPosicaoAbaixo(j, i) > valor + 1)) && !posicaoRobo(j + 1, i)){
						setPosicaoAbaixo(j, i);
						ok = true;
					}	
				
	                
				// <<
				
					if((getPosicaoEsquerda(j, i) == 0 || (getPosicaoEsquerda(j, i) > valor + 1)) && !posicaoRobo(j, i - 1)){
						setPosicaoEsquerda(j, i);
						ok = true;
					}
				
	                
				// /\
//				try{
//					if(matriz[j - 1][i] == 0 || (matriz[j - 1][i] > valor + 1))
//						matriz[j - 1][i] = matriz[j][i] - 1;
//				} catch(Exception ex){                    
//				}   
				
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
                
//                // >>
//                try{
//                    if((matriz[j][i + 1] == 0 || (matriz[j][i + 1] > valor + 1))  )
//                        matriz[j][i + 1] = matriz[j][i] + 1;
//                } catch(Exception ex){                    
//                }
//                
//                // \/
//                try{
//                    if((matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1)) && j < linha)
//                        matriz[j + 1][i] = matriz[j][i] + 1;
//                } catch(Exception ex){                  
//                }
                
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
				 getPosicaoDireita(linha, coluna) <= getPosicaoAbaixo(linha, coluna) &&
				 getPosicaoDireita(linha, coluna) <= getPosicaoEsquerda(linha, coluna) &&
				 getPosicaoDireita(linha, coluna) <= getPosicaoAcima(linha, coluna) ) 
			{
				posicao = getPosicaoDireita(linha, coluna);
				// move robo para direita
			} 
			// \/
			else if ( getPosicaoAbaixo(linha, coluna) != OBSTACULO &&
					  getPosicaoAbaixo(linha, coluna) <= getPosicaoEsquerda(linha, coluna) &&
					  getPosicaoAbaixo(linha, coluna) <= getPosicaoAcima(linha, coluna) )				
			{
				posicao = getPosicaoAbaixo(linha, coluna);
				// move robo para abaixo
			}
			// <<			
			else if ( getPosicaoEsquerda(linha, coluna) != OBSTACULO &&
					  getPosicaoEsquerda(linha, coluna) <= getPosicaoAcima(linha, coluna) )				
			{
				posicao = getPosicaoEsquerda(linha, coluna);
				// move robo para esquerda
			}
			// /\			
			else if ( getPosicaoAcima(linha, coluna) != OBSTACULO )
			{
				posicao = getPosicaoAcima(linha, coluna);
				// move robo para acima
			}				
				
				
		}
		
	}
	
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
					
					//Quando o centro do trapezoide nao for -1, ele � valido
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
					
					//Quando o ponto m�dio nao for -1 ele � valido
					if(matriz[pontoMedio[1]][pontoMedio[0]] != -1)
						pontosMedios.add(pontoMedio);
					
				} else if(centroProxColuna[0] > centro[0] + 1){
					break;
				}
			}
		}
		
		buscaEmLargura(6, 0);
		
	}
	
	public static void buscaEmLargura(int linhaO, int colunaO){
		Stack<int[]> fila = new Stack<int[]>();
		
		int[] robo = new int[3];
		robo[0] = colunaO;
		robo[1] = linhaO;
		robo[2] = CINZA;
		
		fila.addElement(robo);
		int[][] grafoCaminho = new int[LINHA][COLUNA];
		int[][] menorCaminho = new int[2][COLUNA];
		
		for (int i = 0; i < grafoCaminho.length; i++) {
			for (int j = 0; j < grafoCaminho[0].length; j++) {
				grafoCaminho[i][j] = -1;
			}
		}
		grafoCaminho[linhaO][colunaO] = 0;
		
		int distancia = 1;
		
		//Inicializando vertices
		for (int[] listVertice : pontosMedios) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false){
				System.out.print(vertice[0] + ";");
				System.out.println(vertice[1] + ";");
				vertices.add(vertice);
			}				
		}
		
		//Inicializando vertices
		for (int[] listVertice : trapezoides) {
			int[] vertice = new int[3];
			vertice[0] = listVertice[0];
			vertice[1] = listVertice[1];
			vertice[2] = BRANCO;
			
			if(pontoSemSaida(vertice[1], vertice[0]) == false){
				System.out.print(vertice[0] + ";");
				System.out.println(vertice[1] + ";");
				vertices.add(vertice);
			}	
		}		
		
		while(fila.size() > 0){
			int[] vertice = (int[]) fila.pop();
			for (int[] vAdj : vertices) {
				//Se os vertices forem adjacentes
				if(vAdj[0] == vertice[0] + 1 && vAdj[2] == BRANCO){
					fila.push(vAdj);
					grafoCaminho[vAdj[1]][vAdj[0]] = distancia; // + Math.abs(vertice[1] - vAdj[1]);
					vAdj[2] = CINZA;
				} else if(vAdj[0] > vertice[0] + 1){
					break;
				}
			}
			vertice[2] = PRETO;
			distancia ++;
		}
		System.out.println();
		showConsole2(grafoCaminho);
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
			//para para baixa
			if(matriz[linha + 1][coluna] != -1)
				return false;
		} catch (Exception e) {
		}
		return true;
	}
	
}

