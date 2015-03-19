import java.util.Scanner;
public class Exc2Slide { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	Float n1, n2;
	System.out.printf("Digite o numero 1: ");
	n1 = dado.nextFloat();
        System.out.printf("Digite o numero 2: ");
	n2 = dado.nextFloat();
	System.out.println("Soma: "+ (n1+n2));
	System.out.println("Produto: "+ (n1*n2));
	System.out.println("Diferença: "+ (n1-n2));
	System.out.println("Quociente: "+ (n1/n2));
    }
}
