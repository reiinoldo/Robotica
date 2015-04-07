
public class Main {

	private static int LINHA = 7;
	private static int COLUNA = 6;
	
	private static int[][] matriz = new int[LINHA][COLUNA];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cenario2(); +- 
		cenarioA();
	}
	
	public static void cenarioA(){
		iniciarObstaculos();
		iniciarObjetivo();
		iniciarRobo();		
		showConsole();
		
		valoraQuadrante3(2, 5);
        valoraQuadrante4(2, 5);
		
        showConsole();
	}
	
	public static void cenarioB(){
		iniciarObstaculos();
		iniciarObjetivo();
		iniciarRobo();		
		showConsole();
		
		valoraQuadrante3(2, 5);
        valoraQuadrante4(2, 5);
		
        showConsole();
	}
	
    public static void cenario2(){
        //Obstaculos
        matriz[1][3] = -1;
        matriz[2][3] = -1;
        matriz[3][3] = -1;
        matriz[4][3] = -1;
        matriz[5][3] = -1;
        matriz[6][3] = -1;
        //---------------
        
        //Objetivo
        matriz[3][5] = 2;
        //--------
        
        //Robo
        matriz[6][0] = 99;
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
    
	
	public static void iniciarObstaculos(){		
		//Linha X Coluna
		matriz[0][1] = -1;
		matriz[1][3] = -1;
		matriz[2][4] = -1;
		matriz[3][2] = -1;
		matriz[4][4] = -1;
		matriz[5][0] = -1;
		matriz[5][2] = -1;
		matriz[6][3] = -1;
		matriz[6][5] = -1;		
	}	
	
	public static void iniciarObjetivo(){
		matriz[2][5] = 2;
	}

	public static void iniciarRobo(){
		matriz[6][0] = 99;
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
				try{
					if(matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1)){
						matriz[j + 1][i] = matriz[j][i] + 1;
						ok = true;
					}	
				} catch(Exception ex){                  
				}
	                
				// <<
				try{
					if(matriz[j][i - 1] == 0 || (matriz[j][i - 1] > valor + 1)){
						matriz[j][i - 1] = matriz[j][i] + 1;
						ok = true;
					}
						
				} catch(Exception ex){                    
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
                
                try{
                    if((matriz[j][i + 1] == 0 || (matriz[j][i + 1] > valor + 1))  )
                        matriz[j][i + 1] = matriz[j][i] + 1;
                } catch(Exception ex){                    
                }
                
                try{
                    if((matriz[j + 1][i] == 0 || (matriz[j + 1][i] > valor + 1)) && j < linha)
                        matriz[j + 1][i] = matriz[j][i] + 1;
                } catch(Exception ex){                  
                }
                
                try{
                    if((matriz[j][i - 1] == 0 || (matriz[j][i - 1] > valor + 1)) )
                        matriz[j][i - 1] = matriz[j][i] + 1;
                } catch(Exception ex){                    
                }
                
                try{
                    if((matriz[j - 1][i] == 0 || (matriz[j - 1][i] > valor + 1)) )
                        matriz[j - 1][i] = matriz[j][i] + 1;
                } catch(Exception ex){                    
                }   
                valor++;
            }
        }            
    }

	
	
}

