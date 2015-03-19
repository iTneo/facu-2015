import java.util.Scanner;
public class Exc3Slide { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	float total = 0;
	for(int i = 0; i < 3 ;i++){
	    System.out.printf("Digite o valor do produto "+(i+1)+": ");
	    Float valor = dado.nextFloat();
	    System.out.printf("Digite a quantidade do produto "+(i+1)+": ");
	    Float quantidade = dado.nextFloat();
	    total += (valor*quantidade);
	}
        System.out.println("O valor total entre os produtos é "+total+".");
    } 
}
