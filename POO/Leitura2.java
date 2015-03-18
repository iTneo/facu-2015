import java.util.Scanner;
public class Leitura2 { 
    public static void main(String[] args) {
	String s;
	Scanner dado = new Scanner(System.in);
	System.out.printf("Digite seu nome: ");
	s = dado.next("^Teste");
	System.out.println(s);
    } 
}
