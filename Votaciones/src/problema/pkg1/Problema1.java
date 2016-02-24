/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkg1;
/**
 *
 * @author FamiliaOrjRod
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         java.util.Scanner lectura=
           new java.util.Scanner(System.in);
        int opcion;
        int NumeroMunicipios;
        int NumeroCandidatos;
        int votos[][] = new int[21][21]; // Aqui se almacenan los votos
        boolean reiniciar=true;
        double VotosTotales = 0;
        int posicion;
        int posicion2;
        boolean HayGanador = false;
       
        
        System.out.println("Ingrese el numero de municipios");
        NumeroMunicipios = lectura.nextInt();
        System.out.println("Ingrese el numero de candidatos por municipio");
        NumeroCandidatos = lectura.nextInt();
        
        do{
        System.out.println("\f");
        System.out.println("1. Ingresar votos");
        System.out.println("2. Tabla de votaciones");
        System.out.println("3. Estado de las votaciones");
        System.out.println("4. Segunda ronda");
        
   
   opcion = lectura.nextInt();
        switch(opcion){
        case 1: 
            
            //Aqui se ingresan los votos por candidato, cada fila representa un municipio, y cada columna un candidato
            for(int i = 1; i < NumeroMunicipios +1; i++){
            System.out.println("Municipio " + i);
            for(int n = 1; n < NumeroCandidatos +1; n++){
            System.out.println("Ingrese votos del candidato" + n);
            votos[i - 1][n - 1] = lectura.nextInt();
            }
            }
  
            VotosTotales= ContadorVotos(votos, NumeroMunicipios, NumeroCandidatos);
            
            
            //En el siguiente ciclo se suman las votaciones por cada candidato en la ultima fila de la matriz votos
        for(int f=0; f<NumeroMunicipios ; f++){
        for(int g=0; g<NumeroCandidatos; g++){
        votos[20][g] = votos[20][g] + votos[f][g];
        }
        }
        
        break;
        case 2:
            
            int a;
            System.out.print("Cadidato      ");
             for (a = 1; a < NumeroCandidatos +1; a++){ // se imprime la palabra "candidato" seguida de el conteo desde 1 hasta el numero de candidatos ingresado
             System.out.print(a + "     ");
             }
             System.out.println("");
             for(int b= 0; b < NumeroMunicipios; b++){ // se imprime la palabra "municipio" seguida de la cantidad de votos por cada candidato en ese municipio
             System.out.print("Municipio " + (b+1));
             for(int c = 0; c < NumeroCandidatos; c++){
             System.out.print("    " + votos[b][c]);
             }
             System.out.println("");
             }
        break;
        case 3:

        for(int k=0; k < NumeroCandidatos; k++){
            System.out.println(" Votos Candidato " + (k+1) + ": " + votos[20][k] + "     Porcentaje " + (votos[20][k]/VotosTotales)*100 + "%");       
        }
        System.out.println("Votos Totales: " + VotosTotales); 
        break;
            
        case 4:
            
            for (int x=1 ; x<votos.length;x++){
            
            if (votos[20][x]/VotosTotales > 0.5) {
            System.out.println("Candidato " + (x+1) + " es el ganador por tener mas del 50% de la votacion");
            HayGanador=true;
        }   
            }
            if(HayGanador==false){
           
                posicion= PosicionDelMayor(votos);
                posicion2= PosicionDelMenor(votos);
                System.out.println("El candidato " + (posicion+1) + " tuvo la mayor cantidad de votos");
            System.out.println("El candidato " + (posicion2+1) + " tuvo la menor cantidad de votos, queda eliminado para la segunda ronda");}
            
        
            break;
        }
    }while(reiniciar == true);
    }
    
    public static int ContadorVotos(int matriz[][], int a, int b){
           int Total = 0;
            for(int d=0 ; d < a ; d++){
            for(int e=0; e < b ; e++){
            Total =  Total + matriz[d][e];
            }
            }
            return Total;
    }
    public static int PosicionDelMayor(int Matriz[][]){
        int a, b;
        a = Matriz[20][0];
        b = 0;
        for (int x=1 ; x<Matriz.length ;x++){  
        if (Matriz[20][x]>a){
        a = Matriz[20][x];
        b = x;
        } 
} return b;     
    }
        public static int PosicionDelMenor(int Matriz[][]){
        int a, b;
        a = Matriz[20][0];
        b = 0;
        for (int x=1 ; x<Matriz.length ;x++){  
        if (Matriz[20][x]<a){
        a = Matriz[20][x];
        b = x;
        } 
} return b;     
    }

}
