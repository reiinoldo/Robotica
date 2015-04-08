import java.util.ArrayList;


public class Main {

	private static int LINHA = 7;
	private static int COLUNA = 6;
	private static final int ROBO = 99;
	private static final int ORIGEM = 2;
	private static final int OBSTACULO = -1;
	
	private static int[][] matriz = new int[LINHA][COLUNA];
	
	private static ArrayList<int[]> trapezoides = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cenario2(); +- 
		// cenarioA();
		cenarioB();
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
		cenarioA();
		
		int[] trapezoide;
		int ponto;
		//Identificar os trapezoides
		for (int i = 0; i < matriz[0].length; i++) { //coluna
			ponto = 0;
			for (int j = 0; j < matriz.length; j++) { //linha
				
				if(matriz[j][i] == -1 || (j == matriz.length - 1 && matriz[j][i] != -1)){
					trapezoide = new int[2];
					trapezoide[0] = i; //Coluna do trapezoide
					trapezoide[1] = (j + ponto) / 2; //Ponto medio do trapezoide
					ponto = j + 1;
					if(matriz[trapezoide[1]][trapezoide[0]] != -1){
						trapezoides.add(trapezoide);
					}
					
				}
			}
		}
		
		showConsole();
		
		for (int[] ptMedio : trapezoides) {
			for (int i = 0; i < ptMedio.length; i++) {
				System.out.print(ptMedio[i] + ";");
			}
			System.out.println();
		}	
	}
	
}

