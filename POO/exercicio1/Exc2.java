import java.util.Scanner;
public class Exc2 { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	float total = 0;
	for(int i = 0; i < 5; i++){
	    System.out.printf("Digite o valor do produto "+(i+1)+": ");
	    total += dado.nextFloat();
	}
        System.out.println("Total = "+total);
    } 
}
