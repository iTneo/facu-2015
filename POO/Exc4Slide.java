import java.util.Scanner;
public class Exc4Slide { 
    public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	System.out.printf("Digite a largura da piscina: ");
	float largura = dado.nextFloat();
	System.out.printf("Digite a profundidade da piscina: ");
	float profundidade = dado.nextFloat();
	System.out.printf("Digite o comprimento da piscina: ");
	float comprimento = dado.nextFloat();
	float area = comprimento * profundidade * largura;
	System.out.println("A piscina terá "+area+" metros cúbicos e custará R$" + (area * 45)+".");
    } 
}
