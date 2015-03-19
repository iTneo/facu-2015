import java.util.Scanner;
public class Exc4 { 
    public static void main(String[] args) {
	String s;
	String resultado = "" ;
	Scanner dado = new Scanner(System.in);
	for(int i = 0;i < 3; i++){
	    System.out.printf("Digite uma palavra: ");
	    s = dado.next();
	    resultado += s;
	}
	System.out.println(resultado);
    } 
}
