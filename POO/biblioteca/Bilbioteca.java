package biblioteca;

import java.util.Scanner;
import java.util.ArrayList;


public class Bilbioteca {
	static String nome;
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>(); 
	static ArrayList<Livro> livros;
	static ArrayList<Dvd> dvds;
	static ArrayList<Periodico> periodicos;

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		// OBJETOS
		int opcao = 0;
		
		
		Emprestimo emprestimo = new Emprestimo();
		
		// MENU
		do {
			System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Cadastrar Livro");
			System.out.println("3 - Cadastrar DVD");
			System.out.println("4 - Cadastrar Periódico");
			System.out.println("5 - Realizar Emprestimo");
			System.out.println("6 - Realizar Devolução");
			System.out.println("9 - Sair");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Cadastro de Alunos \n");
				System.out.println("Entre com o Codigo do Aluno");
				Aluno aluno = new Aluno();
				aluno.setCodigo(ler.nextInt());
				System.out.println("Entre com o Aluno: ");
				aluno.setNome(ler.next());
				System.out.println();
				alunos.add(aluno);
				System.out.println("\n Aluno cadastrado com sucesso!");

				break;

			case 2:

				System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Cadastro de livros\n");
				System.out.println("Entre com o ISBN do livro");
				Livro livro = new Livro();
				livro.setIsbn(ler.nextInt());
				System.out.println("Entre com o Autor: ");
				livro.setAutor(ler.next());
				System.out.println("Entre com o título do livro: ");
				livro.setTitulo(ler.next());
				System.out.println("Entre com o Ano: ");
				livro.setAno(ler.nextInt());
				System.out.println();
				livros.add(livro);
				System.out.println("\n Livro cadastrado com sucesso!");

				break;
			
			case 3:

				System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Cadastro de DVDs\n");
				System.out.println("Entre com o codigo do DVD");
				Dvd dvd = new Dvd();
				dvd.setCodigo(ler.nextInt());
				System.out.println("Entre com o Descrição: ");
				dvd.setDescricao(ler.next());
				System.out.println("Entre com o Ano: ");
				dvd.setAno(ler.nextInt());
				System.out.println("Entre com a Duração: ");
				dvd.setDuracao(ler.next());
				System.out.println();
				dvds.add(dvd);
				System.out.println("\n DVD cadastrado com sucesso!");

				break;
			
			case 4:

				
				System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Cadastro de Periódicos\n");
				System.out.println("Entre com o codigo do Periódico");
				Periodico periodico = new Periodico();
				periodico.setCodigo(ler.nextInt());
				System.out.println("Entre com o Descrição: ");
				periodico.setDescricao(ler.next());
				System.out.println("Entre com o Ano: ");
				periodico.setAno(ler.nextInt());
				System.out.println("Entre com a Edição: ");
				periodico.setEdicao(ler.nextInt());
				System.out.println();
				periodicos.add(periodico);
				System.out.println("\n Periodico cadastrado com sucesso!");

				break;
			
					
		
			case 5:

				System.out.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Realização de emprestimos\n");
				System.out.println("Entre com o codigo do aluno:");
				int cod_aluno = ler.nextInt();
				Aluno aluno_emprestimo = null;
				for(Aluno item: alunos){
					if(item.getCodigo() == cod_aluno){
						aluno_emprestimo = item;
					}
				}
				if(aluno_emprestimo == null){
					System.out.println("Aluno não encontrado!!!");
					break;
				} else {
					
				}
				
				
				
				break;
				
			}

		} while (opcao != 9);

	}
}