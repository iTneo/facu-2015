import java.util.Scanner;
public class Exc1Slide { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	String nome1, nome2, nome3;
	System.out.printf("Digite o nome 1: ");
	nome1 = dado.next();
        System.out.printf("Digite o nome 2: ");
	nome2 = dado.next();
	System.out.printf("Digite o nome 3: ");
	nome3 = dado.next();
	System.out.println(nome1+", "+nome3);
	System.out.println(nome2);
    } 
}
