import java.util.Scanner;
public class Pesquisa { 
    public static void main(String[] args) {
	int[] costaSilva= new int[5], aventureiro=new int[5], bomRetiro=new int[5], america= new int[5], centro=new int[5];
	Scanner dado = new Scanner(System.in);
	int bairro;
	do{
	    System.out.println("Qual o bairro da pessoa? ");
	    System.out.println("1- Costa e Silva ");
	    System.out.println("2- Aventureiro ");
	    System.out.println("3- Bom Retiro");
	    System.out.println("4- America ");
	    System.out.println("5- Centro");
	    System.out.println("9- Sair do programa e apresentar resultados.");
	    bairro = dado.nextInt();
	    if(bairro == 9){
		continue;
	    }
	    System.out.printf("Qual a idade da pessoa?");
	    int idade = dado.nextInt();
	    if(idade <= 12){
		idade=0;
	    }else if(idade <= 18){
		idade=1;
	    }else if(idade<=25){
		idade=2;
	    }else if(idade<=50){
		idade=3;
	    }else{
		idade=4;
	    }
	    switch(bairro) {
		case 1:
		    costaSilva[idade]+=1;
		    break;
		case 2:
		    aventureiro[idade]+=1;
		    break;
		case 3:
		    bomRetiro[idade]+=1;
		    break;
		case 4:
		    america[idade]+=1;
		    break;
		case 5:
		    centro[idade]+=1;
		    break;
		default:
		    System.out.println("Bairro inválido!");
	    }
	}while(bairro!=9);
	for(int i = 0; i<5;i++){
	    int[] arrayBairro;
	    if(i==0){
		System.out.print("Costa e Silva:\n");
		arrayBairro=costaSilva;
	    }else if(i==1){
		System.out.print("Aventureiro:\n");
		arrayBairro=aventureiro;
	    }else  if(i==2){
		System.out.print("Bom Retiro:\n");
		arrayBairro=bomRetiro;
	    }else  if(i==3){
		System.out.print("America:\n");
		arrayBairro=america;
	    }else{
		System.out.print("Centro:\n");
		arrayBairro=centro;
	    }

	    for(int j=0;j<5;j++){
		    if(j==0){
			System.out.print("1 a 12 anos: ");
		    }else if(j==1){
			System.out.print("13 a 18 anos: ");
		    }else if(j==2){
			System.out.print("19 a 25 anos: ");
		    }else if(j==3){
			System.out.print("26 a 50 anos: ");
		    }else{
			System.out.print("51 a 110 anos: ");
		    }
		    System.out.print(arrayBairro[j]+"\n");
	    }
	}
    } 
}
