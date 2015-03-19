import java.util.Scanner;
public class Exc5 { 
    public static void main(String[] args) {
	String texto = "Olá, " ;
	Scanner dado = new Scanner(System.in);
	System.out.printf("Digite seu nome: ");
	texto += dado.nextLine()+ ". Você tem ";
	System.out.println("Qual sua idade?");
	texto += dado.nextLine() + " anos e é natural de ";
	System.out.println("Qual sua naturalidade?");
	texto += dado.nextLine() + ".";
	System.out.println(texto);
    } 
}
