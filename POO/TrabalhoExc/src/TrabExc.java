import java.util.Scanner;
import java.util.InputMismatchException;
class LenghtErrorException extends RuntimeException{
	public LenghtErrorException(){
		super("Seu CPF deve ter 11 dígitos!");
	}
}
public class TrabExc {
	public static void main(String[] args){
		Scanner dados = new Scanner(System.in);
		System.out.println("Qual seu CPF?");
		try{
			System.out.println("Qual seu CPF?");
			String cpf = dados.next();
			if( cpf.length() != 11){
				throw new LenghtErrorException();
			}
			System.out.println("Qual sua idade?");
			int idade = dados.nextInt();
			int valorComanda = idade * 93; // Valor sem nenhum sentido!
			System.out.println("Você deve R$"+valorComanda+" .Deseja dividir em mais cartões? Se sim digite o numero de cartões, se não digite 1.");
			int numCartoes = dados.nextInt();
			System.out.println("Valor para cada cartão: R$"+ (valorComanda/numCartoes));
		}catch(LenghtErrorException e){
			System.out.println(e.getMessage());
		}catch(InputMismatchException e){
			System.out.println("Sua idade precisa ser um numero inteiro!");
		}catch(ArithmeticException e){
			System.out.println("Impossível dividir por zero cartões!!!");			
		}
		
	}
}
