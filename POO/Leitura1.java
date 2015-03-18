import java.io.*;
public class Leitura1 { 
    public static void main(String[] args) {
	String s;
	DataInputStream dado;
	try {
	    System.out.println("Entre com a porra do seu nome:");
	    dado = new DataInputStream(System.in);
	    s = dado.readLine();
	    System.out.println(s);
	}catch (IOException e){
	    System.out.println("O erro foi: "+e);
	}
    } 
}
