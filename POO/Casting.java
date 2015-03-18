import java.io.*;
public class Casting { 
    public static void main(String[] args) {
	double d = 2.2222;
	int i = (int)d;
	System.out.println(i);

	i = 1234;
	d = i;
	System.out.println(d);

	String dados = "123.4";
	double dado = Double.parseDouble(dados);
	System.out.println(dado);
    } 
}
