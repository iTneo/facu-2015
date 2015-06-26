import java.util.Scanner;

public class Biblioteca {
	public static void main (String [] args){

	Scanner  ler = new Scanner (System.in); 

//OBJETOS 
		int op = 0; 
		Aluno a = new Aluno(); 
		Livro l = new Livro(); 
		Periodico p = new Periodico(); 
		Emprestimo e = new Emprestimo(); 
		Dvd d = new Dvd(); 

//MENU 
		do {
			System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca"); 

			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Cadastrar Livro");
			System.out.println("3 - Cadastrar DVD");
			System.out.println("Emprestimo");
			System.out.println("Devolução");
			System.out.println("Sair");
			op = ler.nextInt(); 
		}

//CASES 
		switch (op){
		case 1: 

			System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");

			System.out.println("Cadastro de Alunos \n");
			System.out.println("Entre com o Codigo do Aluno");
			a.setCodigo(ler.nextInt());
			System.out.println("Entre com o Aluno: ");
			a.setNome(entrada.nextInt);
			System.out.println();
			System.out.println("\n Aluno cadastrado com sucesso!");	

			break; 
		

		case 2: 
		
			System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
			System.out.println();
			System.out.println("Cadastro de livros\n");
			

	}
	
	}
}

