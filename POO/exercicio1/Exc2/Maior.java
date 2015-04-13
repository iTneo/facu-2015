import java.util.Scanner;
import java.util.InputMismatchException;  
public class Maior { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	try {
	    double valor = 0;
	    double maior = 0;
	    for (int i = 0; i<3; i++){
		System.out.printf("Digite o numero "+(i+1)+": ");
		valor = dado.nextDouble();
		if(valor > maior){
		    maior = valor;
		}
	    }
	    System.out.printf("O maior é "+maior);
	} catch(InputMismatchException erro){
	    System.out.println("Erro no tipo de dado fornecido. Valores devem ser apenas números.");
	}
    } 
}
