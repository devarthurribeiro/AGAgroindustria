package algoritmogenetico;

import java.util.Arrays;
import java.util.Random;

public class Testes {

	public static void main(String[] args) {
                testaCruzamento();
                selecaoRoleta();

	}
        
        private static void testaCruzamento(){
                double[] pai0 = {5, 6, 7, 8};
		double[] pai1 = {1, 2, 3, 4};
	
		
		double[] filho0 = new double[4];
		double[] filho1 = new double[4];
		
		System.arraycopy(pai0, 0, filho0, 0, 2);
		System.arraycopy(pai0, 2, filho1, 2, 2);
		
		System.arraycopy(pai1, 0, filho1, 0, 2);
		System.arraycopy(pai1, 2, filho0, 2, 2);
	
                System.out.println("Cruzamento:");
		System.out.println(Arrays.toString(filho0));
		System.out.println(Arrays.toString(filho1));
        }
        
        private static void selecaoRoleta(){
                double total = 0;
                double[] aptidao = {0.90, 1.00, 0.95, 1.50};
                double[] percentual = new double[aptidao.length];
                double[] fatias = new double[aptidao.length];
                
                System.out.println("\nRoleta:\n"+Arrays.toString(aptidao));
                
                for(int i = 0; i < aptidao.length; i++){
                    total += 1/aptidao[i];
                }
                
                System.out.println("Total: "+total);
                
                System.out.println("\nPercentual:");
                for(int i = 0; i < aptidao.length; i++){
                    percentual[i] = (1/aptidao[i])/total;
                    System.out.println(percentual[i]);
                }
               
                System.out.println("\nFatias:");
                for(int i = 0; i < fatias.length; i++){
                    if(i == 0)
                        fatias[i] = percentual[i];
                    else
                        fatias[i] = fatias[i-1] + percentual[i];
                    System.out.println(fatias[i]);
                }
                
                for(int i = 0; i < 2; i++){
                    System.out.println("Solucao "+rodarRoleta(fatias));
                }
	}
        
        private static int rodarRoleta(double[] fatias){
            double random = new Random().nextDouble();
            System.out.println("\nRodar Roleta: "+random);
            for(int i = 0; i < fatias.length; i++){
                if(random < fatias[i])
                    return i;
            }
            return 0;
        }

}
