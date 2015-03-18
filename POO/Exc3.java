import java.util.Scanner;
public class Exc3 { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	double raio = 0;
	System.out.printf("Digite o valor da largura do cilindro: ");
	double largura = dado.nextDouble();
	double doisPi = 6.28;
	raio = largura / doisPi;
        System.out.println("Raio= "+raio);
    } 
}
