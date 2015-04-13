import java.util.Scanner;
import java.util.InputMismatchException;  
public class Aumentos { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	try {
	    System.out.printf("Digite o valor do produto: ");
	    double valor = dado.nextDouble();
	    System.out.printf("Digite o codigo de aumento do produto: ");
	    int codigo = dado.nextInt();
	    switch	(codigo) {
		case 1: 
		    valor += valor * 0.15;
		    break;
		case 3:
		    valor += valor * 0.2;
		    break;
		case 4:
		    valor += valor * 0.35;
		    break;
		case 8:
		    valor += valor * 0.4;
		    break;
		default: 
		    System.out.printf("Codigo inválido. Consulte nossa documentação para identificar os codigos possíveis.");
	    }
	    System.out.format("Seu produto tem o valor de R$ %.2f.\n", valor);
	} catch(InputMismatchException erro){
	    System.out.println("Erro no tipo de dado fornecido. Valores devem ser apenas números.");
	}
    } 
}
