package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Bilbioteca {
	static String nome;
	static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	static ArrayList<Livro> livros = new ArrayList<Livro>();
	static ArrayList<Dvd> dvds = new ArrayList<Dvd>();
	static ArrayList<Periodico> periodicos = new ArrayList<Periodico>();
	static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	static ArrayList<ItemEmprestimo> itensEmprestimo = new ArrayList<ItemEmprestimo>();

	public static void main(String[] args) throws IOException {

		Scanner ler = new Scanner(System.in);

		// OBJETOS
		int opcao = 0;

		// MENU
		do {
			System.out
					.println("Sistema de Controle de Emprestimo em uma Biblioteca");
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
				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
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

				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
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

				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
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

				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
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

				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Realização de emprestimos\n");
				System.out.println("Entre com o codigo do aluno:");
				int cod_aluno = ler.nextInt();
				Aluno aluno_emprestimo = null;
				for (Aluno item : alunos) {
					if (item.getCodigo() == cod_aluno) {
						aluno_emprestimo = item;
					}
				}
				if (aluno_emprestimo == null) {
					System.out.println("Aluno não encontrado!!!");
					break;
				}
				System.out.println("Gerando empréstimo para aluno "
						+ aluno_emprestimo.getNome());
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setAluno(aluno_emprestimo);
				Calendar dataEmprestimo = Calendar.getInstance();
				dataEmprestimo.setTime(new Date());
				emprestimo.setDataEmprestimo(dataEmprestimo.getTime());
				Calendar dataDevolucao = Calendar.getInstance();
				dataDevolucao.setTime(new Date());
				dataDevolucao.add(Calendar.DAY_OF_MONTH, 10);
				emprestimo.setDataDevolucao(dataDevolucao.getTime());
				int opcaoTipo;
				do {
					System.out
							.println("Selecione o tipo do item do seu empréstimo:");
					System.out.println("1 - Livro");
					System.out.println("2 - DVD");
					System.out.println("3 - Periodico");
					System.out.println("9 - Sair");
					opcaoTipo = ler.nextInt();
					switch (opcaoTipo) {
					case 1:
						System.out.println("Digite o isbn do livro:");
						int cod_livro = ler.nextInt();
						Livro livro_emprestimo = null;
						for (Livro item : livros) {
							if (item.getIsbn() == cod_livro && item.status) {
								livro_emprestimo = item;
							}
						}
						if (livro_emprestimo == null) {
							System.out.println("Livro não encontrado");
							break;
						}
						ItemEmprestimo itemEmprestimoLivro = new ItemEmprestimo();
						itemEmprestimoLivro.setEmprestimo(emprestimo);
						itemEmprestimoLivro.setItem(livro_emprestimo);
						livro_emprestimo.status= false;
						break;
					
					case 2:
						System.out.println("Digite o codigo do DVD:");
						int cod_dvd = ler.nextInt();
						Dvd dvd_emprestimo = null;
						for (Dvd item : dvds) {
							if (item.getCodigo() == cod_dvd && item.status) {
								dvd_emprestimo = item;
							}
						}
						if (dvd_emprestimo == null) {
							System.out.println("DVD não encontrado ou emprestado");
							break;
						}
						ItemEmprestimo itemEmprestimoDvd = new ItemEmprestimo();
						itemEmprestimoDvd.setEmprestimo(emprestimo);
						itemEmprestimoDvd.setItem(dvd_emprestimo);
						dvd_emprestimo.status= false;
						break;					
					case 3:
						System.out.println("Digite o codigo do periódico:");
						int cod_periodico = ler.nextInt();
						Periodico periodico_emprestimo = null;
						for (Periodico item : periodicos) {
							if (item.getCodigo() == cod_periodico && item.status) {
								periodico_emprestimo = item;
							}
						}
						if (periodico_emprestimo == null) {
							System.out.println("Periódico não encontrado ou emprestado");
							break;
						}
						ItemEmprestimo itemEmprestimoPeriodico = new ItemEmprestimo();
						itemEmprestimoPeriodico.setEmprestimo(emprestimo);
						itemEmprestimoPeriodico.setItem(periodico_emprestimo);
						periodico_emprestimo.status= false;
						break;
					}
				
				} while (opcaoTipo != 9);

				emprestimos.add(emprestimo);
				SimpleDateFormat formatoArquivo = new SimpleDateFormat(
						"yyyy-MM-dd-hh-mm");
				String arquivoNome = "//tmp/"
						+ formatoArquivo.format(dataEmprestimo.getTime())
						+ aluno_emprestimo.getNome();

				emprestimo.imprimirComprovante(arquivoNome);
				break;
			case 6:

				System.out
						.println("Sistema de Controle de Emprestimo em uma Biblioteca");
				System.out.println("Cadastro de Periódicos\n");
				System.out.println("Entre com o codigo do Periódico");
				Periodico periodico123 = new Periodico();
				periodico123.setCodigo(ler.nextInt());
				System.out.println("Entre com o Descrição: ");
				periodico123.setDescricao(ler.next());
				System.out.println("Entre com o Ano: ");
				periodico123.setAno(ler.nextInt());
				System.out.println("Entre com a Edição: ");
				periodico123.setEdicao(ler.nextInt());
				System.out.println();
				periodicos.add(periodico123);
				System.out.println("\n Periodico cadastrado com sucesso!");

				break;



			}

		} while (opcao != 9);

	}
}