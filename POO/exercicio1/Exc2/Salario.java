import java.util.Scanner;
public class Salario { 
   public static void main(String[] args) {
	Scanner dado = new Scanner(System.in);
	System.out.println("Qual a quantidade de horas que você trabalhou?");
	double horas = dado.nextDouble();
	System.out.println("Qual seu salario por hora?");
	double salarioHora = dado.nextDouble();
	System.out.println("Quantos dependentes você tem?");
	int dependentes = dado.nextInt();
	double salarioBruto = (horas*salarioHora)+(50*dependentes);
	System.out.println("Seu salario bruto é de: "+salarioBruto);
	double INSS;
	if(salarioBruto<=1000){
	    INSS = 0.085;
	}else{
	    INSS = 0.09;
	}
	INSS *= salarioBruto;
	System.out.println("Desconto do INSS é de: "+INSS);
	double IR;
	if(salarioBruto <= 500){
	    IR=0;
	}else if(salarioBruto <= 1000){
	    IR=0.05;
	}else{
	    IR=0.07;
	}
	IR*=salarioBruto;
	System.out.println("Seu Imposto de Renda: "+ IR);
	System.out.println("Seu salário limpo é de: "+(salarioBruto-IR-INSS));
    } 
}
