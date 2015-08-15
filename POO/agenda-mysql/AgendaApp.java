
import java.io.IOException;
import java.util.Scanner;


public class AgendaApp {
	public static void main(String[] args) throws IOException {
		
		Agenda agenda = new Agenda();
		agenda.conectar();
		Scanner entrada = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("Agenda: Bem vindo");
			System.out.println("1 - Adicionar um Contato");
			System.out.println("2 - Consultar");
			System.out.println("3 - Remover");
			System.out.println("4 - Editar");
			System.out.println("9 - sair");
			System.out.println("Digite sua opção");
			opcao = entrada.nextInt();

			switch (opcao) {
				case 1:
					agenda.adicionarContato();
					break;
				case 2:
					agenda.consultar();
					break;
				case 3:
					agenda.remover();
					break;
				case 4:
					agenda.editar();
			}
		}while(opcao != 9);
		agenda.desconectar();
	}
}
