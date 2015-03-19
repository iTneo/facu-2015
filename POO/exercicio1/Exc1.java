import java.util.Scanner;
public class Exc1 { 
    public static void main(String[] args) {
	String s;
	Scanner dado = new Scanner(System.in);
	System.out.printf("Digite uma palavra: ");
	s = dado.next();
	System.out.println(s);
	System.out.println(s.subSequence(1,s.length()));
	System.out.println(s.subSequence(0,s.length()-1));
	System.out.println(s.length());
	if (s.length() >= 7 ){
	    System.out.println(s.subSequence(3,7));
	}else{
	    System.out.println("A palavra não possui 7 caracteres");
	}
        System.out.println(s.replace("e","&"));
        System.out.println(s+"POO");
    } 
}
